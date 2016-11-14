<%@ page language="java" contentType="text/html; charset=gbk"
    pageEncoding="gbk"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/backend/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<title>���ר��</title>
<style type="text/css">
<!--
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size:12px;
	color:#666666;
	background:#fff;
	text-align:center;

}

* {
	margin:0;
	padding:0;
}

a {
	color:#1E7ACE;
	text-decoration:none;	
}

a:hover {
	color:#000;
	text-decoration:underline;
}
h3 {
	font-size:14px;
	font-weight:bold;
}

pre,p {
	color:#1E7ACE;
	margin:4px;
}
input, select,textarea {
	padding:1px;
	margin:2px;
	font-size:12px;
}
.buttom{
	padding:1px 10px;
	font-size:12px;
	border:1px #1E7ACE solid;
	background:#D0F0FF;
}
#formwrapper {
	width:95%;
	margin:15px auto;
	padding:20px;
	text-align:left;
}

fieldset {
	padding:10px;
	margin-top:5px;
	border:1px solid #1E7ACE;
	background:#fff;
}

fieldset legend {
	color:#1E7ACE;
	font-weight:bold;
	background:#fff;
}

fieldset label {
	float:left;
	width:120px;
	text-align:right;
	padding:4px;
	margin:1px;
}

fieldset div {
	clear:left;
	margin-bottom:2px;
}

.enter{ text-align:center;}
.clear {
	clear:both;
}

-->
</style>
<script type="text/javascript" src="../js/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
function initEditor(){
	CKEDITOR.replace( 'content',
		{
			skin : 'office2003',
			width:700
		} 
	);
}
</script>
</head>

<body onload="initEditor()">
<div id="formwrapper">
	<h3>�༭ר����Ϣ</h3>
	<form action="ArticleServlet" method="post" enctype="multipart/form-data">
	<input type="hidden" name="method" value="add">
	<fieldset>
		<legend>ר��������Ϣ</legend>
		<div>
			<label for="title">ר������</label>
			<input type="text" name="title" id="title" value="" size="60" maxlength="200" /> 
			*(���200���ַ�)<br />	
		</div>
		<div>
			<label for="source">ר����Դ</label>
			<input type="text" name="source" id="source" value="" size="30" maxlength="100" /> 
			*(���100���ַ�)<br />	
		</div>
		<div>
			<label for="author">����</label>
			<input type="text" name="author" id="author" value="" size="30" maxlength="100" /> 
		</div>
		<div>
			<label for="keyword">�ؼ���</label>
			<input type="text" name="keyword" id="keyword" value="" size="30" maxlength="100" /> 
		</div>
		<div>
			<label for="type">����</label>
			<select name="type" id="type">
				<option value="����ר��">����ר��</option>
				<option value="ʵ������">ʵ������</option>
				<option value="������">������</option>
			</select> 
		</div>
		
		<div>
			<label for="intro">���</label>
			<textarea rows="5" cols="100" name="intro" id="intro"></textarea>
			<br />	
		</div>
		<div>
			<label for="content">��������</label>
			<textarea rows="20" cols="100" name="content" id="content"></textarea>
			<br />	
		</div>
		<div>
			<label for="attachs">ѡ�񸽼�</label>
			<input type="file" name="attachs" id="attachs">
			<br />	
		</div>
		<div class="enter">
		    <input name="submit" type="submit" class="buttom" value="�ύ" />
		    <input name="reset" type="reset" class="buttom" value="����" />
		    <input name="return" type="button" class="buttom" value="�����б�ҳ��" onclick="window.location = 'ArticleServlet'"/>
		</div>
	</fieldset>
	</form>
</div>

</body>
</html>

