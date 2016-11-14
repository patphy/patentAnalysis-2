package com.patent.servlet;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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

public class InventorChartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���÷�������ΪͼƬ
		response.setContentType("image/png");
		// ����ͼ�����
		CategoryDataset dataset = createDataset();
		JFreeChart jfreechart = ChartFactory.createLineChart("�������������Ʒ���", null,
				"��������", dataset, PlotOrientation.VERTICAL, true, true, true);
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

	public static CategoryDataset createDataset() {

		DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();

		int[] number = { 0, 91, 135, 212, 181, 278, 357, 422, 535, 564 };
		int j = 2006;
		for (int i = 0; i < 10; i++) {

			defaultDataset.addValue(number[i], "��������", j + "��");
			j++;
		}
		return defaultDataset;
	}
}
