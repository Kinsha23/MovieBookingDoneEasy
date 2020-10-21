package com.kinsha.hall;

import java.io.Serializable;

public class HallDto implements Serializable {
	private int hid;
	private String hname, location;

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public HallDto() {

	}
}
