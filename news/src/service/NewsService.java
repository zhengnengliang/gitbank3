package service;

import java.util.List;

import entity.News;

public interface NewsService {
	/**
	 * 国内新闻
	 * @return
	 */
   public List<News> nationalnews(String field,Object a,Object orderby,int limit ,String order);
   /**
    * 国际新闻
    * @return
    */
   public List<News> worldnews(String field,Object a,Object orderby,int limit ,String order);
   /**
    * 娱乐新闻
    * @return
    */
   public List<News> entertainmentnews(String field,Object a,Object orderby,int limit ,String order);
   /**
    * 新闻中心
    */
   public List<News> newscenter(String field,Object a,Object orderby,int limit ,String order);
  /**
   * 查询所有
   */
   public List<News> allfind();
   /**
    * 添加新闻
    */
   public int addnews(News news);
   /**
    * 新闻删除
    */
   	public int deletenews(int a);
   	/**
	 * 修改新闻
	 */
	public int amentNews(News news);
	/**
	 * 分页查询上一页
	 */
	public  List<News> fenye1(int id,int a,int zhongshu );
	 /**
	  * 分页查询下一页
	  */
	public  List<News> fenye2(int id ,int a,int zhongshu );
   
}

