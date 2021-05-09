package org.example;

public enum Doctor {
	
	JOHN("Ishan John"),
	THARA("Nayan Thara"),
	VIJAY("Joesph Vijay"),
	DULQUER("dulquer salman");

	private String doctorName;
	
	public String getDoctorName() {
		return doctorName;
	}
	
	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}

}
