package co.edu.uis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class O30g02ConsultorioOnlineApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(O30g02ConsultorioOnlineApplication.class, args);
		System.out.println("Este si es");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Este si es");
		String passUserString = "user";
		String passWorkerString = "worker";
		String passDoctorString = "doctor";
		
		System.out.println(passwordEncoder.encode(passUserString));
		System.out.println(passwordEncoder.encode(passWorkerString));
		System.out.println(passwordEncoder.encode(passDoctorString));
	}

}
