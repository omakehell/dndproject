package application;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	public Usuario(int id, String user, String password, String recovery_code) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
		this.recovery_code = recovery_code;
	}
	int id;
	String user;
	String password;
	String recovery_code;
	List pjs = new ArrayList();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRecovery_code() {
		return recovery_code;
	}
	public void setRecovery_code(String recovery_code) {
		this.recovery_code = recovery_code;
	}
	public List getPjs() {
		return pjs;
	}
	public void setPjs(List pjs) {
		this.pjs = pjs;
	}

}
