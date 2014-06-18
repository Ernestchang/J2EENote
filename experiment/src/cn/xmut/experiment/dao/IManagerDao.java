package cn.xmut.experiment.dao;

import cn.xmut.experiment.domain.Manager;

public interface IManagerDao {
	/**
	 * 处理管理员登陆
	 * @param manager 管理员对象
	 * @return 是否为管理员
	 */
	public abstract boolean isManager(Manager manager);
}
