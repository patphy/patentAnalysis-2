<%@ page language="java" import="java.util.*" pageEncoding="gbk"
	contentType="text/html; charset=gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>


	</head>

	<body>
		<center>
			<img src="<%=request.getContextPath()%>/applyNumberYearLine" />
			<br />
		</center>
		
		<div id="explainApplyNumber">
			<h3>��д����</h3>
			<p>
			���г���������չ��1985���������ҹ�ʵ��ר���ƶ�����һֱ������չ����90��������г����õķ�չ��
			��������ˮƽ�ĵõ���ߵ������г���ʼ�ռ���ͬʱ���ھ��÷�չ����С�γ���δ�õ��㷺Ӧ������ͨ���
			���ڼ䴦�����г���չ�ĸ߷壬���90�������20���ͳ�����������ˮƽ�õ���ߣ����ý�Ϊ��ԣ��
			�����г���չ�ϻ���С�γ���չѸ�٣�
			��2006�꿪ʼ�����绷������Ŀ����ռ��������ͼ۵ĳ����������ǿ�ʼ��ע���г����ּȻ����ֽ��ܵĳ��з�ʽ��
			���������г�������չ�����ѽ����ƹ�ר���������������١�
			��������ר�����Ʒ������г��ڽ��һ��ʱ�仹�������õ���չ�������漰���ܻ����༼��ͻ�ƽ�Ϊ���г���ҵ�ṩ�µķ�չ����
			</p>
		</div>
		
	</body>
</html>
