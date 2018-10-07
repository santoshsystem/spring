package me.test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListVO {
	private List<EmployeeVO> employees;
	
	{
		employees = new ArrayList<EmployeeVO>();
	}

	public List<EmployeeVO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeVO> employees) {
		this.employees = employees;
	}
	
	
}
