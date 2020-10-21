package com.kinsha.emp;

import java.io.Serializable;

//Bean Class
public class EmpDto implements Serializable {
	private int eid;
	private String ename, email;

	public EmpDto() {
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
