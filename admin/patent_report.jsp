<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ page import="com.report.text.bayes.*" %>
<%@ page import="com.report.predict.Report" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ר������ҳ��</title>
    
	 <meta content="text/html;charset=gbk" http-equiv="Content-Type"> 
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 				
  
  </head>
  
  <body>
  <%
  	String text = request.getParameter("testText");
  String result = "";
	if(text!= null){
		BayesClassifier classifier = new BayesClassifier();
	  	 result = "���ڵ����Ϊ��"+ classifier.classify(text);
	}
	else{
		result = "�޷�ʶ�������";
	}
  %>

  
	<center>
	
		<div  >
			<form action="" method="post" >
				<textarea cols="70" rows="10" id="testText" style="font-size: 18px" name="testText">������Ҫ�жϵ��ı�</textarea>
				<br/>
				<br/>
				<input type="submit"  name="classify" value="�ж����" onclick="">
				
				
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button"  name="report" value="���ɱ���" onclick="window.open('http://localhost:8080/patentAnalysis/admin/patent_report_generate.jsp')"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" name="newReport" value="�Ľ��汨������" onclick="window.open('http://localhost:8080/patentAnalysis/admin/patent_report_improveGenerate.jsp')"/>
				<br/>
				<br/>
			  <textarea rows="10" cols="70" style="font-size: 18px;  " >
			  
			  	<%=result %>
			  </textarea>
			   
			   
			</form>
			 
			    <%--����һ�����ز�  �����������ݣ�����¼�������������ʾ--%>
		</div>
	</center>    
  </body>
</html>
