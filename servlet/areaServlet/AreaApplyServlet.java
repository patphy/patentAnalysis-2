package com.patent.servlet.areaServlet;

import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.crawl.DBUtil;

public class AreaApplyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���÷�������ΪͼƬ
		response.setContentType("image/png");
		// ��ȡ���ݼ�����
		PieDataset dataset;
		try {
			dataset = createDataset();
		
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
				600, 400);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static PieDataset createDataset() throws SQLException {
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		// �����ݿ��в�ѯ
		DBUtil db = new DBUtil();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT COUNT(id), ProvinceCode FROM ai GROUP BY ProvinceCode HAVING COUNT(id) > 20";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		ArrayList<String> areaList = new ArrayList<String>();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		while (rs.next()) {
			areaList.add(rs.getString(2));
			numList.add(rs.getInt(1));
		}
		System.out.println(areaList);
		System.out.println(numList);

		for (int i = 0; i < areaList.size(); i++) {

			defaultPieDataset.setValue(areaList.get(i), numList.get(i));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return defaultPieDataset;
	}

	public static void main(String[] args) throws SQLException {
		createDataset();
	}
}
