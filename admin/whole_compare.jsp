<%@ page language="java" import="java.util.*" pageEncoding="gbk" contentType="text/html; charset=gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>���������������Աȷ���</title>
    

  </head>
  
  <body>
    <center>
    <img src="<%=request.getContextPath()%>/applyAndPublicCompareServlet" />
			<br />
    
    <div id="explainCompare">
			<h3>��д����</h3>
			<p>
			�������빫�������������ƴ�����ͬ��������������Ϊ2011�꣬�������������������2012��
			</p>
		</div>
		</center>
  </body>
</html>
