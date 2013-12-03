package com.bingoogol.algorithm.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bingoogol.algorithm.dao.IAlgorithmDao;
import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.dto.PagerJson;
import com.bingoogol.algorithm.model.Algorithm;
import com.bingoogol.algorithm.service.IAlgorithmService;

@Service
public class AlgorithmService implements IAlgorithmService {
	@Autowired
	private IAlgorithmDao algorithmDao;
	@Override
	public void addAlgorithm(String realPath, Algorithm algorithm2, InputStream thesis, InputStream algorithm) {
		try {
			algorithmDao.addAlgorithm(algorithm2);
			String path = realPath+"/resources/upload/";
			FileUtils.copyInputStreamToFile(thesis, new File(path + algorithm2.getNewThesisName()));
			FileUtils.copyInputStreamToFile(algorithm, new File(path + algorithm2.getNewAlgirithmName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public PagerJson<Algorithm> find(Pager pager, Integer cid, String con) {
		return algorithmDao.find(pager, cid, con);
	}
	@Override
	public Algorithm getAlgorithm(Integer id) {
		return algorithmDao.getAlgorithm(id);
	}

}
