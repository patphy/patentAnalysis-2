<%@ page language="java" import="java.util.*" pageEncoding="gbk"
	contentType="text/html; charset=gbk"%>
<%@ page import="com.report.predict.Report" %>
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
		<title>�������ɸĽ���</title>
		<meta content="text/html; charset=gbk" http-equiv="Content-Type">
		<style type="text/css"> 
<!--
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #666666;
	background: #fff;
	text-align: center;
}

* {
	margin: 0;
	padding: 0;
}

a {
	color: #1E7ACE;
	text-decoration: none;
}

a:hover {
	color: #000;
	text-decoration: underline;
}

h3 {
	font-size: 14px;
	font-weight: bold;
}

pre,p {
	color: #1E7ACE;
	margin: 4px;
}

input,select,textarea {
	padding: 1px;
	margin: 2px;
	font-size: 12px;
}

.buttom {
	padding: 1px 10px;
	font-size: 12px;
	border: 1px #1E7ACE solid;
	background: #D0F0FF;
}

#formwrapper {
	width: 95%;
	margin: 15px auto;
	padding: 20px;
	text-align: left;
}

fieldset {
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #1E7ACE;
	background: #fff;
}

fieldset legend {
	color: #1E7ACE;
	font-weight: bold;
	background: #fff;
}

fieldset label {
	float: left;
	width: 120px;
	text-align: right;
	padding: 4px;
	margin: 1px;
}

fieldset div {
	clear: left;
	margin-bottom: 2px;
}

.enter {
	text-align: center;
}

.clear {
	clear: both;
}

hr {
	color: red;
	border: 1px solid;
	width: 70%;
}
-->

</style>
<style type="text/css" media="print"></style>
		<script type="text/javascript">

function coverShow() {
	var div = document.getElementById("cover");

	var btnCover = document.getElementById("coverBtn").value;
	if (btnCover == 'չ������') {
		div.style.display = "block";
		document.getElementById("coverBtn").value = '���ط���';
	} else if (btnCover == '���ط���') {
		div.style.display = "none";
		document.getElementById("coverBtn").value = 'չ������';
	}

}
function bgShow() {
	var btnBg = document.getElementById("bgBtn").value;
	if (btnBg == '�����༭�޸�') {
		document.getElementById("bginfo").style.display = "block";
		document.getElementById("bgBtn").value = '���ر����༭�޸�';
	} else {
		document.getElementById("bginfo").style.display = "none";
		document.getElementById("bgBtn").value = '�����༭�޸�';
	}
}
function overallShow(){
	var btnOverall = document.getElementById("overallBtn").value;
	if (btnOverall == '����༭�޸�') {
		document.getElementById("overall").style.display = "block";
		document.getElementById("overallBtn").value = '��������༭�޸�';
	} else {
		document.getElementById("overall").style.display = "none";
		document.getElementById("overallBtn").value = '����༭�޸�';
	}
}
function regionShow(){
	var btnOverall = document.getElementById("regionBtn").value;
	if (btnOverall == '����༭�޸�') {
		document.getElementById("region").style.display = "block";
		document.getElementById("regionBtn").value = '��������༭�޸�';
	} else {
		document.getElementById("region").style.display = "none";
		document.getElementById("regionBtn").value = '����༭�޸�';
	}
}
function ipcShow(){
	var btnIPC = document.getElementById("ipcBtn").value;
	if (btnIPC == 'IPC�༭�޸�') {
		document.getElementById("ipc").style.display = "block";
		document.getElementById("ipcBtn").value = '����IPC�༭�޸�';
	} else {
		document.getElementById("ipc").style.display = "none";
		document.getElementById("ipcBtn").value = 'IPC�༭�޸�';
	}
}
function rivalShow(){
	var btnRival = document.getElementById("rivalBtn").value;
	if (btnRival == '�����߱༭�޸�') {
		document.getElementById("rival").style.display = "block";
		document.getElementById("rivalBtn").value = '���ؾ����߱༭�޸�';
	} else {
		document.getElementById("rival").style.display = "none";
		document.getElementById("rivalBtn").value = '�����߱༭�޸�';
	}
}
function paramShow(){
	var btnParamAndPre = document.getElementById("paramAndPreBtn").value;
	if (btnParamAndPre == '�����༭�鿴') {
		document.getElementById("paramAndPredict").style.display = "block";
		document.getElementById("paramAndPreBtn").value = '���ز����༭�鿴';
	} else {
		document.getElementById("paramAndPredict").style.display = "none";
		document.getElementById("paramAndPreBtn").value = '�����༭�鿴';
	}
}
function topicShow(){
	var btnTopic = document.getElementById("topicBtn").value;
	if (btnTopic == '����༭�鿴') {
		document.getElementById("topic").style.display = "block";
		document.getElementById("topicBtn").value = '��������༭�鿴';
	} else {
		document.getElementById("topic").style.display = "none";
		document.getElementById("topicBtn").value = '����༭�鿴';
	}
}
function abstractShow(){
	var btnAbstract = document.getElementById("abstractBtn").value;
	if (btnAbstract == '���ר������') {
		document.getElementById("abstract").style.display = "block";
		document.getElementById("abstractBtn").value = '�������ר������';
	} else {
		document.getElementById("abstract").style.display = "none";
		document.getElementById("abstractBtn").value = '���ר������';
	}
}

  
</script>
	</head>

	<body>
		<!-- ��ͳר�������������������� �����ò����ʾ������-->
             
		<div id="formwrapper">
			<h2>
				ר����������
			</h2>
			<form action="" method="post" enctype="multipart/form-data">
				<div><input id="btnPrint" type="button" value="��        ӡ" onclick="javascript:window.print();" style="margin-left: 1000px"/> </div>
				<fieldset>
					<legend>
						���������Ϣ
					</legend>
					<div id="cover" style="display: none">
						<label for="name">
							��Ŀ���ƣ�
						</label>
						<input type="text" name="reportName" id="reportName" size="60"
							maxlength="100" />
						*(���100���ַ�)
						<br />
						<label>
							�����ˣ�
						</label>
						<input type="text" name="searcher" id="searcher" size="60"
							maxlength="100" />
						*(���100���ַ�)
						<br />
						<label>
							����ˣ�
						</label>
						<input type="text" name="auditor" id="auditor" size="60"
							maxlength="100" />
						*(���100���ַ�)
						<br />

						<label>
							�������ڣ�
						</label>
						<input type="text" name="year" id="year" size="10" />
						��
						<input type="text" name="month" id="month" size="5" />
						��
						<input type="text" name="day" id="day" size="5" />
						��
						<br />
						<label>
							�������ڣ�
						</label>
						<input type="text" name="year" id="year" size="10" />
						��
						<input type="text" name="month" id="month" size="5" />
						��
						<input type="text" name="day" id="day" size="5" />
						��
						<br />
					</div>

					<input type="button" name="coverBtn" id="coverBtn" value="չ������"
						onclick="coverShow()" style="margin-left: 800px" />
						<hr/>

				</fieldset>
				<fieldset>
					<legend>
						ר����ͳ������������
					</legend>
					<div id="bginfo" style="display: none">
						<h3>
							һ�����ⱳ��
						</h3>
						<label>
							����綨
						</label>
						<input type="text" size="150" maxlength="300" name="baseregion"
							id="baseregion" />
						*(���300���ַ�)
						<br />
						<label>
							���ݷ�Χ����������
						</label>
						<input type="text" size="150" maxlength="200" name="time"
							id="time" />
						*(���200���ַ�)
						<br />
						<label>
							����Ŀ��
						</label>
						<input type="text" size="150" maxlength="300" name="aim" id="aim" />
						*(���300���ַ�)
						<br />

						<label>
							�����ؼ���
						</label>
						<input type="text" size="150" maxlength="300" name="keyword"
							id="keyword" />
						*(���300���ַ�)
						<br />
					</div>
					<input type="button" name="bgBtn" id="bgBtn" value="�����༭�޸�"
						onclick="bgShow()" style="margin-left: 800px" />
						<hr/>
					<div id="ptAnalysis">
						<div id="overall" style="display: none">
							<center>
								<h3>
									���巢չ����
								</h3>
							</center>
							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="1.������������Ʒ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='����������������'){value=''}"
								onblur="if (value ==''){value='����������������'}"
								style="font-size: 18px">����������������</textarea>
							<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="2.������������Ʒ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='������������Ʒ���'){value=''}"
								onblur="if (value ==''){value='������������Ʒ���'}"
								style="font-size: 18px">������������Ʒ���</textarea>
								
								<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="3.���빫�����Ա�" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='���빫�����Ա�'){value=''}"
								onblur="if (value ==''){value='���빫�����Ա�'}"
								style="font-size: 18px">���빫�����Ա�</textarea>
								<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="4.С��" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='С��'){value=''}"
								onblur="if (value ==''){value='С��'}"
								style="font-size: 18px">С��</textarea>				


						</div>
						<input type="button" name="overallBtn" id="overallBtn" value="����༭�޸�"
						onclick="overallShow()" style="margin-left: 800px" />
						<hr/>
						<div id="region" style="display: none;">
							<center>
								<h3>
									ר�������������
								</h3>
							</center>
							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="1.�������빹�ɷ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='�������빹�ɷ���'){value=''}"
								onblur="if (value ==''){value='�������빹�ɷ���'}"
								style="font-size: 18px">�������빹�ɷ���</textarea>
							<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="2.�����������Ʒ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='�����������Ʒ���'){value=''}"
								onblur="if (value ==''){value='�����������Ʒ���'}"
								style="font-size: 18px">�����������Ʒ���</textarea>
								
								<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="3.����������ҪIPC�������ɷ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='����������ҪIPC�������ɷ���'){value=''}"
								onblur="if (value ==''){value='����������ҪIPC�������ɷ���'}"
								style="font-size: 18px">����������ҪIPC�������ɷ���</textarea>
								<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="4.����������Ҫ�����߷���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='����������Ҫ�����߷���'){value=''}"
								onblur="if (value ==''){value='����������Ҫ�����߷���'}"
								style="font-size: 18px">����������Ҫ�����߷���</textarea>		
						</div>
						<input type="button" name="regionBtn" id="regionBtn" value="����༭�޸�"
						onclick="regionShow()" style="margin-left: 800px" />
						<hr/>
						
						<div id="ipc" style="display: none;">
							<center>
								<h3>
									��Ҫ�����������
								</h3>
							</center>
							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="1.��ҪIPC�������ɷ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='��ҪIPC�������ɷ���'){value=''}"
								onblur="if (value ==''){value='��ҪIPC�������ɷ���'}"
								style="font-size: 18px">��ҪIPC�������ɷ���</textarea>
							<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="2.��ҪIPC�����걨���Ʒ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='I��ҪIPC�����걨���Ʒ���'){value=''}"
								onblur="if (value ==''){value='��ҪIPC�����걨���Ʒ���'}"
								style="font-size: 18px">��ҪIPC�����걨���Ʒ���</textarea>
								
								<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="3.��ҪIPC������������Աȷ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='��ҪIPC������������Աȷ���'){value=''}"
								onblur="if (value ==''){value='��ҪIPC������������Աȷ���'}"
								style="font-size: 18px">��ҪIPC������������Աȷ���</textarea>
								<br />
							
						</div>
						<input type="button" name="ipcBtn" id="ipcBtn" value="IPC�༭�޸�"
						onclick="ipcShow()" style="margin-left: 800px" />
						<hr/>
						
						
						
						<div id="rival" style="display: none;">
							<center>
								<h3>
									��Ҫ�����߷���
								</h3>
							</center>
							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="1.��Ҫ������ר���ݶ�" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='��Ҫ������ר���ݶ�'){value=''}"
								onblur="if (value ==''){value='��Ҫ������ר���ݶ�'}"
								style="font-size: 18px">��Ҫ������ר���ݶ�</textarea>
							<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="2.��Ҫ�������걨���Ʒ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='��Ҫ�������걨���Ʒ���'){value=''}"
								onblur="if (value ==''){value='��Ҫ�������걨���Ʒ���'}"
								style="font-size: 18px">��Ҫ�������걨���Ʒ���</textarea>
								
								<br />

							<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="3.��Ҫ��������������Աȷ���" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='��Ҫ��������������Աȷ���'){value=''}"
								onblur="if (value ==''){value='��Ҫ��������������Աȷ���'}"
								style="font-size: 18px">��Ҫ��������������Աȷ���</textarea>
								<br />
								
								<input type="text" style="font-size: 18px; border: 0"
								disabled="disabled" value="4.��Ҫ������IPC�����������" />
							<br />

							<textarea cols="120" rows="5" id="textarea"
								onfocus="if(value=='��Ҫ������IPC�����������'){value=''}"
								onblur="if (value ==''){value='��Ҫ������IPC�����������'}"
								style="font-size: 18px">��Ҫ������IPC�����������</textarea>
								<br />
							
						</div>
						<input type="button" name="rivalBtn" id="rivalBtn" value="�����߱༭�޸�"
						onclick="rivalShow()" style="margin-left: 800px" />
					</div>
				</fieldset>


             <fieldset>
             	<legend>ר��������չ������������Ԥ��</legend>
             		<div id="paramAndPredict" style="display: none">
             			<!-- ���������һ����� ������ʾ���� -->
             			<center>
             			<table align="center" border="0" id="paramTb" width="70%" >
             				<tr >
             					<td colspan="4" align="center">ר�������������ڲ���</td>
             				</tr>
             				<tr>
             					<td align="center">����������</td>
             					<td align="center">��������ϵ��</td>
             					<td align="center">����˥��ϵ��</td>
             					<td align="center">�¼�������ϵ��</td>
             					<td align="center">����Ԥ��ֵ</td>
             				</tr>
             				<%
             					Report rp = new Report();
             					double[] param = rp.TechS();
             				%>
             				<tr>
             				<% for(int i = 0; i < param.length; i++){ %>
             				<td align="center"> <%=param[i] %></td>
             				<%} %>
             				<td align="center"><%=rp.predictValue() %> </td>
             				</tr>
             				
             				
             			</table>
             			</center>
             		</div>
             		<input type="button" name="paramAndPreBtn" id="paramAndPreBtn" onclick="paramShow()" value="�����༭�鿴" style="margin-left: 800px"/>
             		<hr/>
             		
             		
             </fieldset>
             
             <fieldset>
             	<legend>ר����������ֲ�</legend>
             		<div id="topic" style="display: none;">
             			<%
             				String[] tc = rp.getTopic().split("topic");
             			    for(int i = 0; i < tc.length; i++){
             			%>
             		<p>	<%= tc[i] %></p>
             			<%} %>
             		</div>
             		<input type="button" name="topicBtn" id="topicBtn" onclick="topicShow()" value="����༭�鿴" style="margin-left: 800px"/>
             		<hr/>
             		
             		<div id="abstract" style="display: block;">
             			<%
             				String[] s = rp.getAbstract().split("\\n");
             			for(int i = 0; i < s.length; i++){
             			%>
             			<p> <%=s[i] %> </p>
             			<% }%>
             			
             		</div>
             		<input type="button" name="abstractBtn" id="abstractBtn" onclick="abstractShow()" value="���ר������" style="margin-left: 800px"/>
             		<hr/>
             </fieldset>
			</form>
		</div>
	</body>
</html>
