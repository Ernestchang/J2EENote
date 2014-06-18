package com.client.model;

import com.common.User;

public class QQClientUser {
	public boolean checkUser(User u) {
		return new QQClientConServer().sendLoginInfoToServer(u);
	}
}
