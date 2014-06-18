package com.wh.base.service.message.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.base.bean.Reply;
import com.wh.base.service.base.DaoSupport;
import com.wh.base.service.message.ReplyService;
@Service @Transactional
public class ReplyServiceBean extends DaoSupport<Reply> implements ReplyService {
	
}
