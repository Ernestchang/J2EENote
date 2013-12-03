package com.bingoogol.algorithm.dao.impl;

import org.springframework.stereotype.Repository;

import com.bingoogol.algorithm.dao.IAlgorithmDao;
import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.dto.PagerJson;
import com.bingoogol.algorithm.model.Algorithm;

@Repository("algorithmDao")
public class AlgorithmDao extends GenericDao<Algorithm> implements IAlgorithmDao {

	@Override
	public void addAlgorithm(Algorithm algorithm) {
		super.add(algorithm);
	}

	@Override
	public PagerJson<Algorithm> find(Pager pager, Integer cid, String con) {
		String hql = "from Algorithm a left join fetch a.channel c where 1=1";
		if(cid != null) {
			hql += " and c.id=" + cid;
		} else {
			hql = "from Algorithm a where 1=1";
		}
		if(con != null) {
			hql += " and (a.name like '%" + con + "%' or a.intro like '%" + con + "%')";
		}
		return super.find(pager, hql);
	}

	@Override
	public Algorithm getAlgorithm(Integer id) {
		return super.load(id);
	}

}
