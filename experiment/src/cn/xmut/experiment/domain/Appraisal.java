package cn.xmut.experiment.domain;

public class Appraisal {
	private int appraisalId;
	private int experimentId;
	private String expertId;
	private String appraisalStatus;
	private String experimentType;
	private String opinion;
	public int getAppraisalId() {
		return appraisalId;
	}
	public void setAppraisalId(int appraisalId) {
		this.appraisalId = appraisalId;
	}
	public int getExperimentId() {
		return experimentId;
	}
	public void setExperimentId(int experimentId) {
		this.experimentId = experimentId;
	}
	public String getExpertId() {
		return expertId;
	}
	public void setExpertId(String expertId) {
		this.expertId = expertId;
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
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
}
