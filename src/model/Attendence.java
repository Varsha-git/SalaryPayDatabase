package model;

import java.util.Date;

public class Attendence {
	private String eid;
	private String status;
	private Date date;

	public Attendence(String eid, String status) {
		super();
		this.eid = eid;
		this.status = status;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Attendence(String eid) {
		super();
		this.eid = eid;
	}

}
