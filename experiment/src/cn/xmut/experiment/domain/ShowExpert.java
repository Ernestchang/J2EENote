package cn.xmut.experiment.domain;

public class ShowExpert {
	/**
	 * 定义教工号（主键）
	 */
	private String expertId;
	/**
	 * 定义名字
	 */
	private String expertName;
	public String getExpertId() {
		return expertId;
	}
	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
}
