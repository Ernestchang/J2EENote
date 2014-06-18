package bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
	private Integer empNo;
	private String name;
	private String phone;
	private Date hireDate;
	private String dept;
	
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return empNo + "|" + name + "|" + phone + "|" + new SimpleDateFormat("yyyy-MM-dd").format(hireDate).toString() + "|" + dept;
	}
}
