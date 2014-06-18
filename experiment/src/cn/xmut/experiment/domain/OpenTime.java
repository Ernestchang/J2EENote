package cn.xmut.experiment.domain;

public class OpenTime {
	private int openTimeId;
	private String schoolYear;
	private int schoolTerm;
	public OpenTime() {}
	public OpenTime(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public OpenTime(String schoolYear,int schoolTerm) {
		this.schoolTerm = schoolTerm;
		this.schoolYear = schoolYear;
	}
	public int getOpenTimeId() {
		return openTimeId;
	}
	public void setOpenTimeId(int openTimeId) {
		this.openTimeId = openTimeId;
	}
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public int getSchoolTerm() {
		return schoolTerm;
	}
	public void setSchoolTerm(int schoolTerm) {
		this.schoolTerm = schoolTerm;
	}
}
