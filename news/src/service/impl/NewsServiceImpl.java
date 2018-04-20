package service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.NewsDao;
import dao.impl.NewsDaoImpl;
import entity.News;
import service .NewsService;
public class NewsServiceImpl implements NewsService {
	NewsDao newsdao=new NewsDaoImpl();
	/**
	 * 国内新闻
	 * @return
	 */
   public List<News> nationalnews(String field,Object a,Object orderby,int limit ,String order){
	   List<News> nationalnews= newsdao.query( field, a,orderby, limit , order);
	   return nationalnews;
   }

	/**
	 * 国际新闻
	 */
	public List<News> worldnews(String field,Object a,Object orderby,int limit ,String order) {
		 List<News> nationalnews= newsdao.query( field, a, orderby, limit , order);
		   return nationalnews;
	}

	/**
	 * 娱乐新闻
	 */
	public List<News> entertainmentnews(String field,Object a,Object orderby,int limit ,String order) {
		 List<News> nationalnews= newsdao.query( field, a, orderby, limit ,order);
		   return nationalnews;
	}

	/**
	 * 新闻中心
	 */
	public List<News> newscenter(String field,Object a,Object orderby,int limit ,String order) {
		 List<News> news= newsdao.query( field, a, orderby, limit , order);
		return news;
	
		}
	/**
	 * 查询所用新闻
	 */
	public List<News> allfind(){
		List<News> list=newsdao.queryall1();
		return list;
	}

	/**
	 * 添加新闻
	 */
	public int addnews(News news) {
		Date date=new Date();
		long time=date.getTime();
		SimpleDateFormat formatter=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String dateString=formatter.format(date);
		news.setnCreatedate(date);
		int i=newsdao.Addnews(news);
		return i;
	}
	   
	/**
	 * 修改新闻
	 */
	public int amentNews(News news){
		Date date=new Date();
		long time=date.getTime();
		SimpleDateFormat formatter=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		String dateString=formatter.format(date);
		news.setnModifydate(date);
		int i=newsdao.amentNews(news);
		return i;
	}
	
//	public static void main(String[] args){
//		ServiceImplnews a=new ServiceImplnews();
//		List<News> a1=a.newscenter("NTID", 1,"NCREATEDATE" );
//		for(News b:a1){
//			System.out.println(b.getNTID());
//		}

/**
 * 新闻删除
 */
	public int deletenews(int a){
		int b=newsdao.delete(a);
		 return b;
	}
	/**
	 * 分页查询上一页(上一页页数，总页数)
	 */
	public  List<News> fenye1( int id ,int a,int zhongshu ){
//		int b=a-1;
		List<News> list=newsdao.fenye(id, a, zhongshu);
		return list;
	}
	 /**
	  * 分页查询下一页
	  */
	public  List<News> fenye2( int id ,int a,int zhongshu){
		int b=a+1;
		List<News> list1=newsdao.fenye(id, b, zhongshu);
		return list1;
	}
		
	}

