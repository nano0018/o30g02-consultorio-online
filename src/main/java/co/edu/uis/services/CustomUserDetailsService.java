package co.edu.uis.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.uis.interfaces.IEmpleado;
import co.edu.uis.interfaces.IPersona;
import co.edu.uis.models.Empleado;
import co.edu.uis.models.Usuario;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IPersona userRepository;
	
	@Autowired
	private IEmpleado workerRepository;

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // first try loading from User table
        Usuario user = userRepository.findById(Integer.valueOf(username)).orElse(null);
        if (user != null) {
            return new CustomUserDetails(user.getUserId(), user.getPassword(), "USER");
        } else {
            // Not found in user table, so check admin
            Empleado admin = workerRepository.findById(Integer.valueOf(username)).orElse(null);
            if (admin != null) {
                return new CustomUserDetails(admin.getIdWorkers(), admin.getWorkerPassword(), admin.getWorkerEmployment());
            }
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
	
	public class CustomUserDetails implements UserDetails {

        private int username;
        private String password;
        private Collection<? extends GrantedAuthority> authorities;

        public CustomUserDetails() {
            super();
        }

        public CustomUserDetails(int username, String password, String role) {
            this.username = username;
            this.password = password;
            String ROLE_PREFIX = "ROLE_";
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + role));
            this.authorities = grantedAuthorities;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return String.valueOf(username);
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

    }
	

}
