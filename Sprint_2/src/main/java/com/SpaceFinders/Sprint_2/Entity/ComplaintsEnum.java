package com.SpaceFinders.Sprint_2.Entity;

public class ComplaintsEnum {
	public enum ComplaintType {
		property_issue,
		host_behavior,
		guest_behavior,
		payment,
	    others
	}
	
	public enum Severity {
		low, medium, high, critical
	}
	
	public enum Status {
		open, investigating, resolved, closed
	}

}
