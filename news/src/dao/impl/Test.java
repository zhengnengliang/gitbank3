package dao.impl;

import java.util.*;

import service.impl.NewsServiceImpl;
import entity.News;
public class Test {

	public static void main(String[] args){
		
			NewsServiceImpl new4=new NewsServiceImpl();
			List<News> listnews=new4.newscenter("nID",1,"nCreatedate",6,"ASC");
			System.out.println(listnews.size());
			
    		for(int a=0;a<listnews.size();a++){
	}
	}}
