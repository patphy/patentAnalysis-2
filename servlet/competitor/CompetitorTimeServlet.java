package com.patent.servlet.competitor;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

import com.crawl.DBUtil;

public class CompetitorTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���÷�������ΪͼƬ
		response.setContentType("image/png");
		// ����ͼ�����
		CategoryDataset dataset;
		try {
			dataset = createDataset();

			JFreeChart jfreechart = ChartFactory.createLineChart("��Ҫ�������������Ʒ���",
					"���ڳ�", "ר����", dataset, PlotOrientation.VERTICAL, true, true,
					true);
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
			categoryplot.setRangeGridlinesVisible(true);
			// ����ʾ��������
			LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
					.getRenderer();
			lineandshaperenderer.setBaseShapesVisible(true);
			lineandshaperenderer.setDrawOutlines(true);
			lineandshaperenderer.setUseFillPaint(true);
			lineandshaperenderer.setBaseFillPaint(Color.white);

			lineandshaperenderer.setBaseLinesVisible(true);

			// �������ּӴ�
			lineandshaperenderer.setSeriesStroke(0, new BasicStroke(2F));
			lineandshaperenderer.setSeriesOutlineStroke(0,
					new BasicStroke(2.0F));

			// �������߹յ�
			lineandshaperenderer.setSeriesShape(0,
					new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D));
			// ��ͼ�����������ķ�ʽ���ظ��ͻ���
			ChartUtilities.writeChartAsPNG(response.getOutputStream(),
					jfreechart, 600, 400);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CategoryDataset createDataset() throws SQLException {
		DefaultCategoryDataset defaultDataset = new DefaultCategoryDataset();
		// �����ݿ��в�ѯ
		DBUtil db = new DBUtil();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		int i = 2006;String sql;
		for(int j = 0; j < 10; j++){
			sql = "SELECT COUNT(id) FROM ai WHERE Inventor LIKE '%���ڳ�%' AND ApplicationDate LIKE '%"+(2006+j)+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				numList.add(rs.getInt(1));
			}
		}
		System.out.println(numList);
		for(int k = 0; k < numList.size(); k++){
			defaultDataset.addValue(numList.get(k), "������", (2006+k)+"��");
		}

		rs.close();
		pstmt.close();
		conn.close();

		return defaultDataset;
	}

	public static void main(String[] args) throws SQLException {
		createDataset();
	}
}
