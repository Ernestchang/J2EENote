package cn.xmut.experiment.domain;

public class Dept {
	
	private int deptId;
	private String deptName;
	
	public Dept() {}
	public Dept(int deptId) {
		this.deptId = deptId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


}
