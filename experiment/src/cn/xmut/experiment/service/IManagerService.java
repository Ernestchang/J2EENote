package cn.xmut.experiment.service;

import cn.xmut.experiment.domain.Manager;

public interface IManagerService {
	/**
	 * 处理管理员登陆
	 * @param manager 管理员对象
	 * @return 是否为管理员
	 */
	public abstract boolean isManager(Manager manager);
}
