package com.wh.action.jfreechart;

import java.awt.Font;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ViewResultAction extends ActionSupport {
	private static final long serialVersionUID = 2643846879002435767L;
	private List<String> interest;
	private JFreeChart chart;

	@Override
	public String execute() throws Exception {

		return SUCCESS;
	}

	// 客户端提交一次请求，这个方法就执行一次，在真正的项目开发里面一定要放在相应的model里面,是一个业务处理方法
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void increaseResult(List<String> list) {
		ActionContext context = ActionContext.getContext();
		Map map = context.getApplication();
		if(null != list) {
			
		}
		for (String str : list) {
			if (null == map.get(str)) {
				map.put(str, 1);
			} else {
				map.put(str, (Integer) map.get(str) + 1);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private CategoryDataset getDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		this.increaseResult(this.getInterest());
		ActionContext context = ActionContext.getContext();
		Map map = context.getApplication();
		dataset.setValue((Integer) map.get("football"), "", "足球");
		dataset.setValue((Integer) map.get("basketball"), "", "蓝球");
		dataset.setValue((Integer) map.get("volleyball"), "", "排球");
		dataset.setValue((Integer) map.get("badminton"), "", "羽毛球球");
		return dataset;
	}

	public List<String> getInterest() {
		return interest;
	}

	public void setInterest(List<String> interest) {
		this.interest = interest;
	}

	public JFreeChart getChart() {
		chart = ChartFactory.createBarChart("兴趣统计结果", "项目", "结果", this.getDataset(), PlotOrientation.VERTICAL, false, false,
				false);
		chart.setTitle(new TextTitle("兴趣统计结果", new Font("黑体", Font.BOLD, 22)));
		
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		
		CategoryAxis categoryAxis = plot.getDomainAxis();
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
		
		NumberAxis numberAxis = (NumberAxis) plot.getRangeAxis();
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 22));
		
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
}
