package com.patent.servlet;

import java.awt.Font;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class AreaChartServlet extends HttpServlet {

	private static final long serialVersionUID = 5852523271721922574L;

	public AreaChartServlet(){
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���÷�������ΪͼƬ
		response.setContentType("image/png");
		// ��ȡ���ݼ�����
		PieDataset dataset = createPieDataset();
		// ����ͼ�ζ���
		JFreeChart jfreechart = ChartFactory.createPieChart3D("����ר�����ֲ�",
				dataset, true, true, true);
		// ���ͼ���������
		PiePlot piePlot = (PiePlot) jfreechart.getPlot();
		piePlot.setLabelFont(new Font("����", 0, 12));
		piePlot.setLabelFont(new Font("����", 0, 12));
		// ����ͼ������������ʱ��Ĭ����ʾ����
		piePlot.setNoDataMessage("û��ר������");
		// ����ͼ��������Բ�Σ�������3D�ı���ͼ����������Ϊfalse
		piePlot.setCircular(false);
		// ����ͼ������������ͼ������ļ�����룬0.02��ʾ2%
		piePlot.setLabelGap(0.02D);
		// ��ͼ�����������ķ�ʽ���ظ��ͻ���
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,
				500, 270);
	}

	public static PieDataset createPieDataset() {

		// ��������ͼ���ݶ���
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		// �ֱ�ͼ�������˵��������
		defaultPieDataset.setValue("����ʡ", 682);
		defaultPieDataset.setValue("������", 231);
		defaultPieDataset.setValue("�㶫ʡ", 143);
		defaultPieDataset.setValue("�Ϻ���", 89);
		defaultPieDataset.setValue("�㽭ʡ", 84);
		defaultPieDataset.setValue("ɽ��ʡ", 47);
		defaultPieDataset.setValue("����ʡ", 41);
		defaultPieDataset.setValue("����ʡ", 41);
		defaultPieDataset.setValue("����ʡ", 36);
		defaultPieDataset.setValue("����", 35);
		return defaultPieDataset;
	}
}
