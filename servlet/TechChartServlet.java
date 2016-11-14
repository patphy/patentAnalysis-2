package com.patent.servlet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

public class TechChartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���÷�������ΪͼƬ
		response.setContentType("image/png");
		// ��ȡ���ݼ�����
		CategoryDataset dataset = createDataset();
		// ����ͼ�ζ���
		JFreeChart jfreechart = ChartFactory.createLineChart("ר�������������Ʒ���--������", null,
				"ר������������", dataset, PlotOrientation.VERTICAL, true, true, true);
		// ����ͼ����ӱ���
		jfreechart.addSubtitle(new TextTitle("�����"));
		TextTitle texttitle = new TextTitle("����" + new Date());
		// ���ñ�������
		texttitle.setFont(new Font("����", 0, 10));
		// ���ñ������¶���
		texttitle.setPosition(RectangleEdge.BOTTOM);
		// ���ñ������Ҷ���
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
		// ���ͼ����ӱ���
		jfreechart.addSubtitle(texttitle);
		// ����ͼ��ı���ɫΪ��ɫ
		jfreechart.setBackgroundPaint(Color.white);

		// ���ͼ���������
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setRangeGridlinesVisible(false);
		// ����ʾ��������
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);

		// �������ּӴ�
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(2F));
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));

		// �������߹յ�
		lineandshaperenderer.setSeriesShape(0,
				new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));
		// ��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,
				600, 400);
	}

	private CategoryDataset createDataset() {
		// TODO Auto-generated method stub
		DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
		
		int[] faming = {0,31,44,53,56,587,139,121,140,153};
		int[] shouquan = {0,17,22,24,12,34,42,27,4,0};
		int[] shiyong = {0,8,11,17,18,23,31,24,36,44};
		int[] taiwan = {0,1,1,0,0,0,0,0,0,0};
		int[] waiguan = {0,0,0,2,0,0,2,2,1,3};
		
		int i = 2006;
		for(int j = 0; j < 10;j++){
			defaultDataset.addValue(faming[j], "����ר��", i+"��");
			defaultDataset.addValue(shouquan[j], "��Ȩר��", i+"��");
			defaultDataset.addValue(shiyong[j], "ʵ��ר��", i+"��");
			defaultDataset.addValue(taiwan[j], "�й�̨��", i+"��");
			defaultDataset.addValue(waiguan[j], "���ר��", i+"��");
			i++;
		}
		
		return defaultDataset;
	}
	
	
}
