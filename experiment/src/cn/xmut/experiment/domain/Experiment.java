package cn.xmut.experiment.domain;

public class Experiment {
	private int experimentId;
	private String experimentName;
	private int courseId;
	private String courseName;
	private String experimentCategory;
	private int specialtyId;
	private String specialtyName;
	private String experimentDemand;
	private int creditHours;
	private int openTimeId;
	private String schoolYear;
	private int schoolTerm;
	private String introduction;
	private String docPath;
	private String appraisalStatus;
	private String experimentType;
	private String teacherId;
	private String teacherName;
	public int getExperimentId() {
		return experimentId;
	}
	public void setExperimentId(int experimentId) {
		this.experimentId = experimentId;
	}
	public String getExperimentName() {
		return experimentName;
	}
	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getExperimentCategory() {
		return experimentCategory;
	}
	public void setExperimentCategory(String experimentCategory) {
		this.experimentCategory = experimentCategory;
	}
	public int getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(int specialtyId) {
		this.specialtyId = specialtyId;
	}
	public String getExperimentDemand() {
		return experimentDemand;
	}
	public void setExperimentDemand(String experimentDemand) {
		this.experimentDemand = experimentDemand;
	}
	public int getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	public int getOpenTimeId() {
		return openTimeId;
	}
	public void setOpenTimeId(int openTimeId) {
		this.openTimeId = openTimeId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}
	public String getAppraisalStatus() {
		return appraisalStatus;
	}
	public void setAppraisalStatus(String appraisalStatus) {
		this.appraisalStatus = appraisalStatus;
	}
	public String getExperimentType() {
		return experimentType;
	}
	public void setExperimentType(String experimentType) {
		this.experimentType = experimentType;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
}

