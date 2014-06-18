package service;

import java.util.List;

import net.sf.json.JSONArray;

import org.junit.Test;

import cn.xmut.experiment.domain.Dept;
import cn.xmut.experiment.service.IDeptService;
import cn.xmut.experiment.service.impl.DeptServiceImpl;

public class TestDept {
	IDeptService deptService = new DeptServiceImpl();
	@Test
	public void getDept() {
//		Dept dept = deptService.getDeptById(1);
//		System.out.println(dept.getDeptName());
	}
	@Test
	public void getDeptList() {
		List<Dept> list = deptService.getDeptList();
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray.toString());
	}
	
}
