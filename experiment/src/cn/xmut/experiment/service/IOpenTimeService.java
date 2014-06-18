package cn.xmut.experiment.service;

import java.util.List;

import cn.xmut.experiment.domain.OpenTime;

public interface IOpenTimeService {
	/**
	 * 获取所有首开时间
	 * @return 首开时间集合
	 */
	public abstract List<OpenTime> getOpenTimeList();
	/**
	 * 获取首开时间的编号
	 * @param openTime 首开时间对象
	 */
	public abstract void getOpenTimeId(OpenTime openTime);
}
