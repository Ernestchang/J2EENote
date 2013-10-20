package com.bingoogol.algorithm.dto;

import com.bingoogol.algorithm.model.Algorithm;


public class AlgorithmDto {

	private String name;

	private String intro;

	private Integer score;
	private Integer cid;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	
	public Algorithm getAlgorithm() {
		Algorithm algorithm = new Algorithm();
		algorithm.setName(name);
		algorithm.setScore(score);
		algorithm.setIntro(intro);
		return algorithm;
	}

}
