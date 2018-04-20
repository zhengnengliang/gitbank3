package service;

import java.util.List;

import entity.News;

public interface NewsService {
	/**
	 * ��������
	 * @return
	 */
   public List<News> nationalnews(String field,Object a,Object orderby,int limit ,String order);
   /**
    * ��������
    * @return
    */
   public List<News> worldnews(String field,Object a,Object orderby,int limit ,String order);
   /**
    * ��������
    * @return
    */
   public List<News> entertainmentnews(String field,Object a,Object orderby,int limit ,String order);
   /**
    * ��������
    */
   public List<News> newscenter(String field,Object a,Object orderby,int limit ,String order);
  /**
   * ��ѯ����
   */
   public List<News> allfind();
   /**
    * �������
    */
   public int addnews(News news);
   /**
    * ����ɾ��
    */
   	public int deletenews(int a);
   	/**
	 * �޸�����
	 */
	public int amentNews(News news);
	/**
	 * ��ҳ��ѯ��һҳ
	 */
	public  List<News> fenye1(int id,int a,int zhongshu );
	 /**
	  * ��ҳ��ѯ��һҳ
	  */
	public  List<News> fenye2(int id ,int a,int zhongshu );
   
}

