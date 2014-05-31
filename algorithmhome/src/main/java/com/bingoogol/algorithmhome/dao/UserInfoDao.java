package com.bingoogol.algorithmhome.dao;

public interface UserInfoDao {
	public int plusPrice(String sellerid, int price);
	public int minusPrice(String buyerid, int price);
}
