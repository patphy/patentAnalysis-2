<%@ page contentType="text/html; charset=gbk"%>
<%@include file="../common/admin_head.jsp"%>
<html>
<head>
<title><s:text name="admin_title"/></title>
<s:head theme="ajax" debug="true"/>
<link href="<%=basepath%>/css/admin.css" rel="stylesheet" type="text/css" />
 <script language="JavaScript" type="text/javascript">
 	var url = "#";
 	var root;
 	
	//��Ӧ�˵������¼�
	function treeNodeSelected(arg) {
		var node = dojo.widget.byId(arg.source.widgetId);
		if(node.isFolder){
			if(dojo.widget.byId(arg.source.widgetId).isExpanded){
				dojo.widget.byId(arg.source.widgetId).collapse();
			}else{
				dojo.widget.byId(arg.source.widgetId).expand();
			}		
		}else{
			processSelected(arg.source.widgetId);
		}
	}
	
	//����˵�����
	function processSelected(menuid){
		var tmp = (new Date()).getTime();
		if (menuid=='column'){
			url = "columns_browseColumns.action";
		}else if (menuid=='news'){
			url = "news_browseNews.action";
		}else if (menuid=='crawl'){
			url = "rule_browseNewsrule.action";
		}else if (menuid=='memeberLevel'){
			url = "level_browseMemberlevel.action";
		}else if (menuid=='memeber'){
			url = "member_browseMember.action";
		}else if (menuid=='cate'){
			url = "cate_browseCategory.action";
		}else if (menuid=='mer'){
			url = "mer_browseMerchandise.action";
		}else if (menuid=='order'){
			url = "orders_browseOrders.action";		
		}else if (menuid=='ip'){
			url = "browseIP_index.jsp";		
		}else if (menuid=='pv'){
			url = "browsePV_index.jsp";	
		}else if (menuid=='admin'){
			url = "admin_browseAdmin.action";	
		}else if (menuid=='exit'){
			url = "admin_logout.action";	
		}else if(menuid == 'patent'){
			url = "patent_analyse.action";
		}else if(menuid == 'patent_collection'){
			url = "/patent_Crawl.jsp";
		}else if(menuid=='patent_spider'){
			url = "/patent_spider.jsp";
		}
		else if(menuid == 'patent_search'){
			url = "/patentSearch.jsp";
		}
		else if(menuid == 'patent_year'){
			url = "/patent_yearApply.jsp";
		}
		else if(menuid == 'patent_area'){
			url = "/patent_area.jsp";
		}else if(menuid == 'patent_applicant'){
			url = "/patent_applicant.jsp";
		}else if(menuid == 'patent_inventor'){
			url = "/patent_inventor.jsp";
		}else if(menuid == 'patent_tech'){
			url = "/patent_tech.jsp";
		}else if(menuid == 'patent_theme'){
			url = "/patent_theme.jsp";
		}
		else if(menuid == 'patent_report'){
			url = "/patent_report.jsp";
		}
		else if(menuid == 'whole_apply'){
			url = "/whole_apply.jsp";
		}else if(menuid == 'whole_public'){
			url = "/whole_public.jsp";
		}else if(menuid == 'whole_compare'){
			url = "/whole_compare.jsp";
		}else if(menuid == 'whole_summary'){
			url = "/whole_summary.jsp";
		}
		
		else if(menuid == 'ipc_content'){
			url = "/ipc_content.jsp";
		}else if(menuid == 'ipc_apply'){
			url = "/ipc_apply.jsp";
		}else if(menuid == 'ipc_area'){
			url = "/ipc_area.jsp";
		}
		else if(menuid == 'area_apply'){
			url = "/area_apply.jsp";
		}else if(menuid == 'area_ipc'){
			url = "/area_ipc.jsp";
		}else if(menuid == 'area_competitor'){
			url = "/area_competitor.jsp";
		}
		else if(menuid == 'competitor_analysis'){
			url = "/competitor_analysis.jsp";
		}else if(menuid == 'competitor_apply'){
			url = "/competitor_apply.jsp";
		}
		
		
		//�����ʱ����,��ʶ����һ��ȫ�µ�����
		url = "<%=basepath%>/admin/"+url+"?tmp="+tmp;
		if (menuid=='exit'){
			window.parent.location=url;
		}else{
			window.parent.mainFrame.location=url;
		}		
	}
	
	//��Ӧ�˵�չ���¼�
	function treeNodeExpanded(arg) {
	    alert('id['+arg.source.widgetId+'], name['+ arg.source.title+ '] expanded');
	}
	
	//��Ӧ�˵������¼�
	function treeNodeCollapsed(arg) {
	    alert('id['+arg.source.widgetId+'], name['+ arg.source.title+ '] collapsed');
	}
	
	//ע��˵��¼�����
	dojo.addOnLoad(function(){
	    root = dojo.widget.byId('adminctrl');
	    dojo.event.topic.subscribe(root.eventNames.titleClick, treeNodeSelected);
	});
	
	//չ�����в˵���
	function expandAll(){
       for(var i=0; i<root.children.length; i++) {
          var child = root.children[i];
          dojo.lang.forEach(child.getDescendants(),function(node) {node.expand(); });
       }
	}
</script>
</head>
<body style="padding:18px;">
<s:tree label="<b>ePortal��̨����</b>" id="adminctrl" theme="ajax" showRootGrid="true" showGrid="true">
    <s:treenode theme="ajax" label="<img src='../images/icon_newscolumn.gif'/>���Ź���" id="news_column">
        <s:treenode theme="ajax" label="<img src='../images/icon_column.gif'/>������Ŀ����" id="column"/>
        <s:treenode theme="ajax" label="<img src='../images/icon_news.gif'/>���Ź���" id="news"/>
    </s:treenode>
    <s:treenode theme="ajax" label="<img src='../images/icon_crawl.gif'/>���Ųɼ�" id="crawl"/>
    <s:treenode theme="ajax" label="<img src='../images/icon_member.gif'/>��Ա����" id="memeber_level">
    	<s:treenode theme="ajax" label="<img src='../images/icon_level.gif'/>��Ա�������" id="memeberLevel"/>
    	<s:treenode theme="ajax" label="<img src='../images/icon_member.gif'/>��Ա����" id="memeber"/>    
    </s:treenode>
    <!-- 
    <s:treenode theme="ajax" label="<img src='../images/icon_catemer.gif'/>��Ʒ����" id="cate_mer">
        <s:treenode theme="ajax" label="<img src='../images/icon_cate.gif'/>��Ʒ����" id="cate"/>
        <s:treenode theme="ajax" label="<img src='../images/icon_mer.gif'/>��Ʒ����" id="mer"/>
    </s:treenode>
     -->
     <s:treenode theme="ajax" label="<img src='../images/icon_catemer.gif'/>ר�����ݷ���" id="patent">
     	<s:treenode theme="ajax" label="<img src='../images/icon_cate.gif'/>ר����������" id="">
     	 <s:treenode theme="ajax" label="<img src='../images/icon_mer.gif'/>ʱ������" id="patent_year" />
     		<s:treenode theme="ajax" label="<img src='../images/icon_mer.gif'/>����ֲ�����" id="patent_area"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_mer.gif'/>������" id="patent_applicant"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_mer.gif'/>������" id="patent_inventor"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_mer.gif'/>��������" id="patent_tech"/> 
     		
     	<!-- �������Ʒ��� -->	
     	<s:treenode theme="ajax" label="<img src='../images/icon_statistis.jpg'/>�������Ʒ���" id="">
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>������������Ʒ���" id="whole_apply"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>������������Ʒ���" id="whole_public"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>���빫�����Ա�" id="whole_compare"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>С��" id="whole_summary"/>
     	     	
     	</s:treenode>	
     		
     		
     	<!-- ����༭�޸� -->
     	<s:treenode theme="ajax" label="<img src='../images/icon_statistis.jpg'/>ר�������������" id="">
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>�������빹�ɷ���" id="area_apply"/>
     		
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>����������ҪIPC��������" id="area_ipc"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>����������Ҫ�����߷���" id="area_competitor"/>     	     	
     	</s:treenode>	
     	
     	
     	<!-- ��Ҫ����������� -->
     	<s:treenode theme="ajax" label="<img src='../images/icon_statistis.jpg'/>��Ҫ�����������" id="">
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>��ҪIPC�������ɷ���" id="ipc_content"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>��ҪIPC�����걨���Ʒ���" id="ipc_apply"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>��ҪIPC������������Ա�" id="ipc_area"/>      	     	
     	</s:treenode>	
     	
     	<!-- ��Ҫ�����߷��� -->
     	<s:treenode theme="ajax" label="<img src='../images/icon_statistis.jpg'/>��Ҫ�����߷���" id="">
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>��Ҫ������ר���ݶ�" id="competitor_analysis"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>��Ҫ�������걨���Ʒ���" id="competitor_apply"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>��Ҫ��������������Աȷ���" id="competitor_area"/>
     		<s:treenode theme="ajax" label="<img src='../images/icon_zhexian.gif'/>��Ҫ������IPC�����������" id="competitor_ipc"/>     	     	
     	</s:treenode>	
     		
     	</s:treenode>
     	
     	<!-- ר��������Ϣ �ռ������� -->
        <s:treenode theme="ajax" label="<img src='../images/icon_newscolumn.gif'/>ר�������ռ�" id="patent_coll" >
        	<s:treenode theme="ajax"   label="<img src='../images/icon_column.gif'/> ��ȡר��" id="patent_spider" />
        	<s:treenode theme="ajax"   label="<img src='../images/icon_column.gif'/>ר����Ϣ����" id="patent_collection"/>
        </s:treenode>
        <s:treenode theme="ajax" label="<img src='../images/icon_cate.gif'/>ר��ȫ�ļ���" id="patent_search"/>
      
        <%--�����Ʊ�ǩ��ʾ���ɵ������� --%>
        <s:treenode theme="ajax" label="<img src='../images/icon_cate.gif'/>ר�����������" id="patent_theme" />
        <s:treenode theme="ajax" label="<img src='../images/icon_cate.gif'/>���ר����������" id="patent_report"/>
       
     </s:treenode>
    <s:treenode theme="ajax" label="<img src='../images/icon_order.gif'/>��������" id="order"/>
    <s:treenode theme="ajax" label="<img src='../images/icon_trafic.gif'/>����ͳ��" id="ip_pv">
        <s:treenode theme="ajax" label="<img src='../images/icon_ip.gif'/>IPͳ��" id="ip"/>
        <s:treenode theme="ajax" label="<img src='../images/icon_pv.gif'/>PVͳ��" id="pv"/>
    </s:treenode>    
    <s:treenode theme="ajax" label="<img src='../images/icon_admin.gif'/>ϵͳ�û�����" id="admin"/>
    <s:treenode theme="ajax" label="<img src='../images/icon_exit.gif'/>��ȫ�˳�" id="exit"/>    
</s:tree>
<br/>
</body>
<script type="text/javascript">
	//չ�����в˵���
	window.setTimeout("expandAll();",2000);
</script>
</html>