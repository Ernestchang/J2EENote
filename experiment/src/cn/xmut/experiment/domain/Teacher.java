package cn.xmut.experiment.domain;

public class Teacher {
	/**
	 * 定义教工号（主键）
	 */
	private String teacherId;
	/**
	 * 定义密码
	 */
	private String teacherPassword;
	/**
	 * 定义名字
	 */
	private String teacherName;
	/**
	 * 定义用户类型（课程组长，普通老师）
	 */
	private String teacherType;
	/**
	 * 定义所在单位id（外键）
	 */
	private int deptId;
	private String deptName;
	
	public Teacher() {}
	
	public Teacher(String teacherId, String teacherPassword, String teacherType) {
		this.teacherId = teacherId;
		this.teacherPassword = teacherPassword;
		this.teacherType = teacherType;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherType() {
		return teacherType;
	}

	public void setTeacherType(String teacherType) {
		this.teacherType = teacherType;
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
