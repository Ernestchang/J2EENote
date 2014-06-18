package cn.xmut.experiment.domain;

public class Manager {
	/**
	 * 定义教工号（主键）
	 */
	private String managerId;
	/**
	 * 定义密码
	 */
	private String managerPassword;
	/**
	 * 定义名字
	 */
	private String managerName;
	/**
	 * 定义所在单位
	 */
	private int deptId;
	
	public Manager() {}
	
	public Manager(String managerId, String managerPassword) {
		this.managerId = managerId;
		this.managerPassword = managerPassword;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
