package cn.xmut.experiment.service;

import java.util.List;

import cn.xmut.experiment.domain.Expert;
import cn.xmut.experiment.domain.ShowExpert;

public interface IExpertService {
	/**
	 * 处理评审专家登陆
	 * @param expert 评审专家对象
	 * @return 是否存在该专家
	 */
	public abstract boolean isExpert(Expert expert);
	/**
	 * 根据专业号，获取评审专家列表
	 * @param specialtyId 专业号
	 * @return 评审专家列表
	 */
	public abstract List<ShowExpert> getExpertList(int specialtyId);
}
