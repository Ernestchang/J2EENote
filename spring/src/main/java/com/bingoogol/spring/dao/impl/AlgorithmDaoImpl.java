package com.bingoogol.spring.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bingoogol.spring.dao.AlgorithmDao;
import com.bingoogol.spring.dto.AddAlgorithmDto;

@Repository
public class AlgorithmDaoImpl implements AlgorithmDao {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addAlgorithm(AddAlgorithmDto addAlgorithmDto) {
		String sql = "insert into algorithm(id,name,summary,price,code,iodata,thesis,uid,cid,author1,author2,author3,updatetime,createtime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql,addAlgorithmDto.getId(),addAlgorithmDto.getName(),addAlgorithmDto.getSummary(),addAlgorithmDto.getPrice(),addAlgorithmDto.getCode(),addAlgorithmDto.getIodata(),addAlgorithmDto.getThesis(),addAlgorithmDto.getUid(),addAlgorithmDto.getCid(),addAlgorithmDto.getAuthor1(),addAlgorithmDto.getAuthor2(),addAlgorithmDto.getAuthor3(),new Date(),new Date());
	}

	@Override
	public Map<String, Object> getAlgorithmById(String id) {
		return jdbcTemplate.queryForMap("select * from algorithm where status=3 and id=?", id);
	}

	@Override
	public List<Map<String, Object>> list() {
		return jdbcTemplate.queryForList("select * from algorithm where status=3");
	}

}
