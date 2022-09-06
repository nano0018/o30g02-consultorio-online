package co.edu.uis.o30g02consultorioonline.models;

public class Usuario {
	private int userId;
	private String userName;
	private String userLastName;
	private String email;
	private String pasword;
	private String create_time;
	private String userNum;
	public Usuario(int userId, String userName, String userLastName, String email, String pasword, String create_time,
			String userNum) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userLastName = userLastName;
		this.email = email;
		this.pasword = pasword;
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
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
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
				+ email + ", pasword=" + pasword + ", create_time=" + create_time + ", userNum=" + userNum + "]";
	}
	
	
}
