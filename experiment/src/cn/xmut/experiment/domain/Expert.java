package cn.xmut.experiment.domain;
/**
 * 评审专家
 * @author Administrator
 *
 */
public class Expert {
	/**
	 * 定义教工号（主键）
	 */
	private String expertId;
	/**
	 * 定义密码
	 */
	private String expertPassword;
	/**
	 * 定义名字
	 */
	private String expertName;
	/**
	 * 定义职称
	 */
	private String jobtitle;
	/**
	 * 定义从事专业(外键)
	 */
	private int specialtyId;
	/**
	 * 定义所在单位id（外键）
	 */
	private int deptId;
	
	public Expert() {}
	
	public Expert(String expertId, String expertPassword) {
		this.expertId = expertId;
		this.expertPassword = expertPassword;
	}

	public String getExpertId() {
		return expertId;
	}

	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}

	public String getExpertPassword() {
		return expertPassword;
	}

	public void setExpertPassword(String expertPassword) {
		this.expertPassword = expertPassword;
	}

	public String getExpertName() {
		return expertName;
	}

	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public int getSpecialtyId() {
		return specialtyId;
	}

	public void setSpecialtyId(int specialtyId) {
		this.specialtyId = specialtyId;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
