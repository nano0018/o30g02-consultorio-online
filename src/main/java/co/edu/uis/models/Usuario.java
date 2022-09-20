package co.edu.uis.models;

import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="user")
public class Usuario {
	
	@Id
	@Column(name="userid")
	private int userId;
	@Column(name="username")
	private String userName;
	@Column(name="userlastname")
	private String userLastName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="create_time", updatable=false)
	@CreationTimestamp
	private Date create_time;
	@Column(name="usernum")
	private String userNum;
	public Usuario(int userId, String userName, String userLastName, String email, String password, Date create_time,
			String userNum) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userLastName = userLastName;
		this.email = email;
		this.password = password;
		this.create_time = create_time;
		this.userNum = userNum;
	}
	public Usuario() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	@Override
	public String toString() {
		return "Usuario [userId=" + userId + ", userName=" + userName + ", userLastName=" + userLastName + ", email="
				+ email + ", pasword=" + password + ", create_time=" + create_time + ", userNum=" + userNum + "]";
	}
	
	
}
