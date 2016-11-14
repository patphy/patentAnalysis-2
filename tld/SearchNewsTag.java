package com.patent.tld;

import java.io.*;
import java.util.*;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import java.text.SimpleDateFormat;
import com.patent.ORM.*;
import com.patent.DAO.*;
import com.patent.util.*;

/** 新闻搜索自定义标签类 */
public class SearchNewsTag extends SimpleTagSupport{
	SimpleDateFormat df = null;
	BaseDAO dao = null;		//数据库DAO接口
	News obj= null;
	String hql= null;
	String keyword;	 		//搜索关键字
	int number;      		//新闻的数量
	int pageNo = 1;			//页号
	int titlelen;    		//标题的字数
	String split="0";  		//是否需要分隔符　默认为无分隔符    
	String prex="";   		//前置图片，默认为无，'0'为'·',否则为其它．
	String prexchar=""; 	//前缀字符
	String splitchar=""; 	//分隔字符
	String baseurl =""; 	//基本URL
	String dateFormat="";   //日期格式，默认为无，y:年 M:月 d:日 k:时 m:分 s:秒 如：yyyy-MM-dd kk:mm:ss 需要外部提供.newslist_title与.newslist_date两个CSS样式来控制显示效果
	String dateStr="";		//格式化后的日期字符串
	
	/** 标签体处理 */
    public void doTag() throws JspException, IOException{
    	//使用WebApplicationContextUtils工具类获取Spring IOC容器中的dao实例
    	dao = (BaseDAOImpl)WebApplicationContextUtils.getRequiredWebApplicationContext(((PageContext)getJspContext()).getServletContext()).getBean("dao");
		if (dateFormat.length()>0){//新闻列表需要日期
			try{
				df = new SimpleDateFormat(dateFormat);
			}catch(Exception ex){//传入的日期格式不正确时,使用默认的yyyy-MM-dd日期格式
				df = new SimpleDateFormat("yyyy-MM-dd");
			}
		}
		int i=1;
		hql=" from News as a where a.status=1 and (a.keyWords like '%"+keyword+"%' or a.title like '%"+keyword+"%' or a.abstract_ like '%"+keyword+"%') order by a.priority desc,a.id desc";
		StringBuffer sb=new StringBuffer();
		List list=dao.query(hql,pageNo,number);
		if(list==null||list.size()==0){
	    	//输出处理结果到页面上
	    	getJspContext().getOut().println(""); 			
			return;
		}
		//标题描红
		String redStart = "";
		String redEnd = "";
		Iterator it=list.iterator();
		sb.append("<ul>\n");
		while(it.hasNext()){
			if(split.equals("1")){//处理分割符				
				if(prex.equals("0")){//处理字符前缀
					if (i%2==1){					
						prexchar="&middot;";
					}else{
						prexchar="";
					}			
				}
				if (i%2==1){
					splitchar="&nbsp;|&nbsp;";
				}else{
					splitchar="";
				}
			}else{
				splitchar="";
				if(prex.equals("0")){//处理字符前缀		
					prexchar="&middot;";
				}				
			}
			
			obj=(News)it.next();
			//标题是否需要描红
			if (obj.getRed()==1){
				redStart ="<span style='color:#ff0000;'>";
				redEnd = "</span>";
			}else{
				redStart = "";
				redEnd = "";				
			}
			if (df!=null){//新闻列表需要日期
				dateStr = df.format(obj.getCdate());
				if(obj.getTitle().length()>titlelen){//标题字符过多
					if(prex.endsWith("_.jpg")||prex.endsWith("_.gif")||prex.endsWith("_.png")){//顺序图片
						sb.append("<li><div class='newslist_title'><img src='"+prex.replaceAll("_.","_"+i+".")+"'/><a href='"+baseurl+obj.getHtmlPath()+"' title='"+obj.getTitle()+"'>"+redStart+Tools.cutString(obj.getTitle(), titlelen*2)+redEnd+"</a></div><div class='newslist_date'>"+dateStr+"</div>"+splitchar+"</li>\n");
					}else if(prex.endsWith(".jpg")||prex.endsWith(".gif")||prex.endsWith(".png")){//固定图片
						sb.append("<li><div class='newslist_title'><img src='"+prex+"'/><a href='"+baseurl+obj.getHtmlPath()+"' title='"+obj.getTitle()+"'>"+redStart+Tools.cutString(obj.getTitle(), titlelen*2)+redEnd+"</a></div><div class='newslist_date'>"+dateStr+"</div>"+splitchar+"</li>\n");
					}else{					
						sb.append("<li><div class='newslist_title'>"+prexchar+"<a href='"+baseurl+obj.getHtmlPath()+"' title='"+obj.getTitle()+"'>"+redStart+Tools.cutString(obj.getTitle(), titlelen*2)+redEnd+"</a></div><div class='newslist_date'>"+dateStr+"</div>"+splitchar+"</li>\n");
					}
				}else{
					if(prex.endsWith("_.jpg")||prex.endsWith("_.gif")||prex.endsWith("_.png")){//顺序图片
						sb.append("<li><div class='newslist_title'><img src='"+prex.replaceAll("_.","_"+i+".")+"'/><a href='"+baseurl+obj.getHtmlPath()+"'>"+redStart+obj.getTitle()+redEnd+"</a></div><div class='newslist_date'>"+dateStr+"</div>"+splitchar+"</li>\n");
					}else if(prex.endsWith(".jpg")||prex.endsWith(".gif")||prex.endsWith(".png")){//固定图片
						sb.append("<li><div class='newslist_title'><img src='"+prex+"'/><a href='"+baseurl+obj.getHtmlPath()+"'>"+redStart+obj.getTitle()+redEnd+"</a></div><div class='newslist_date'>"+dateStr+"</div>"+splitchar+"</li>\n");
					}else{
						sb.append("<li><div class='newslist_title'>"+prexchar+"<a href='"+baseurl+obj.getHtmlPath()+"'>"+redStart+obj.getTitle()+redEnd+"</a></div><div class='newslist_date'>"+dateStr+"</div>"+splitchar+"</li>\n");
					}
				}				
			}else{//新闻列表不需要日期
				if(obj.getTitle().length()>titlelen){//标题字符过多
					if(prex.endsWith("_.jpg")||prex.endsWith("_.gif")||prex.endsWith("_.png")){//顺序图片
						sb.append("<li><img src='"+prex.replaceAll("_.","_"+i+".")+"'/><a href='"+baseurl+obj.getHtmlPath()+"' title='"+obj.getTitle()+"'>"+redStart+Tools.cutString(obj.getTitle(), titlelen*2)+redEnd+"</a>"+splitchar+"</li>\n");
					}else if(prex.endsWith(".jpg")||prex.endsWith(".gif")||prex.endsWith(".png")){//固定图片
						sb.append("<li><img src='"+prex+"'/><a href='"+baseurl+obj.getHtmlPath()+"' title='"+obj.getTitle()+"'>"+redStart+Tools.cutString(obj.getTitle(), titlelen*2)+redEnd+"</a>"+splitchar+"</li>\n");
					}else{					
						sb.append("<li>"+prexchar+"<a href='"+baseurl+obj.getHtmlPath()+"' title='"+obj.getTitle()+"'>"+redStart+Tools.cutString(obj.getTitle(), titlelen*2)+redEnd+"</a>"+splitchar+"</li>\n");
					}
				}else{
					if(prex.endsWith("_.jpg")||prex.endsWith("_.gif")||prex.endsWith("_.png")){//顺序图片
						sb.append("<li><img src='"+prex.replaceAll("_.","_"+i+".")+"'/><a href='"+baseurl+obj.getHtmlPath()+"'>"+redStart+obj.getTitle()+redEnd+"</a>"+splitchar+"</li>\n");
					}else if(prex.endsWith(".jpg")||prex.endsWith(".gif")||prex.endsWith(".png")){//固定图片
						sb.append("<li><img src='"+prex+"'/><a href='"+baseurl+obj.getHtmlPath()+"'>"+redStart+obj.getTitle()+redEnd+"</a>"+splitchar+"</li>\n");
					}else{
						sb.append("<li>"+prexchar+"<a href='"+baseurl+obj.getHtmlPath()+"'>"+redStart+obj.getTitle()+redEnd+"</a>"+splitchar+"</li>\n");
					}
				}				
			}
			i++;
		}
		sb.append("</ul>\n");
    	//输出处理结果到页面上
    	getJspContext().getOut().println(sb); 
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPrex() {
		return prex;
	}

	public void setPrex(String prex) {
		this.prex = prex;
	}

	public String getSplit() {
		return split;
	}

	public void setSplit(String split) {
		this.split = split;
	}

	public int getTitlelen() {
		return titlelen;
	}

	public void setTitlelen(int titlelen) {
		this.titlelen = titlelen;
	}

	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
