package service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.junit.Test;

import cn.xmut.experiment.domain.OpenTime;
import cn.xmut.experiment.service.IOpenTimeService;
import cn.xmut.experiment.service.impl.OpenTimeServiceImpl;

public class TestOpenTime {
	IOpenTimeService openTimeService = new OpenTimeServiceImpl();
	@Test
	public void getOpenTimeList() {
		List<OpenTime> list = openTimeService.getOpenTimeList();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[]{"schoolTerm"});
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		System.out.println(jsonArray.toString());
	}
	@Test
	public void getOpenTimeId() {
		OpenTime openTime = new OpenTime("2013-2015", 1);
		openTimeService.getOpenTimeId(openTime);
		System.out.println(openTime.getOpenTimeId());
	}
}
