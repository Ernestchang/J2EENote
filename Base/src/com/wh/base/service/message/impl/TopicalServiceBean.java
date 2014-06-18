package com.wh.base.service.message.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wh.base.bean.Topical;
import com.wh.base.service.base.DaoSupport;
import com.wh.base.service.message.TopicalService;

@Service @Transactional
public class TopicalServiceBean extends DaoSupport<Topical> implements TopicalService {

}
