package dao;
import entity.News;

import java.util.List;

public interface NewsDao  {
	/**
	 * 查询新闻
	 * 条件：WHERE "field"  = "a" ORDER BY "orderby" LIMINT "limit"+order(order升降序)
	 */
public List<News> query( String field,Object a,Object orderby,int limit ,String order);
   /**
    * 查询所有新闻
    */
 public List<News> queryall1();
 /**
  * 添加新闻
  */
 public int Addnews(News news);
 /**
  * 删除新闻
  * @param a
  * @return
  */
 public int delete(int a);
 /**
  * 修改新闻
  * @param news
  * @return
  */
public int amentNews(News news);
/**
 * 查询新闻（分页查询）
 */
public List<News> fenye(int   ziduan,int dijiye,int zongshu);
}
