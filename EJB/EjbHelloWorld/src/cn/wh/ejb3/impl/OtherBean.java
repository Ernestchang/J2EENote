package cn.wh.ejb3.impl;

import javax.ejb.Stateless;

import cn.wh.ejb3.Other;
@Stateless
public class OtherBean implements Other {

	public String sayMe() {
		return "Other";
	}

}
