package service;

import org.junit.Test;

import cn.xmut.experiment.service.ISpecialtyService;
import cn.xmut.experiment.service.impl.SpecialtyServiceImpl;

public class TestSpecialty {
	ISpecialtyService specialtyService = new SpecialtyServiceImpl();
	@Test
	public void getSpecialtyJSON() {
//		System.out.println(specialtyService.getSpecialtyJSON("1"));
	}
}
