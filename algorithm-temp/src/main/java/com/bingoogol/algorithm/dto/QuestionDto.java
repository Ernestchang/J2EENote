package com.bingoogol.algorithm.dto;

import com.bingoogol.algorithm.model.Question;



public class QuestionDto {
	private String title;
	private String intro;
	private Integer score;
	private Integer cid;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	
	public Question getQuestion() {
		Question question = new Question();
		question.setTitle(title);
		question.setIntro(intro);
		question.setScore(score);
		return question;
	}
	
}
