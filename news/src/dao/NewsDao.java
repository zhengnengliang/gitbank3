package dao;
import entity.News;

import java.util.List;

public interface NewsDao  {
	/**
	 * ��ѯ����
	 * ������WHERE "field"  = "a" ORDER BY "orderby" LIMINT "limit"+order(order������)
	 */
public List<News> query( String field,Object a,Object orderby,int limit ,String order);
   /**
    * ��ѯ��������
    */
 public List<News> queryall1();
 /**
  * �������
  */
 public int Addnews(News news);
 /**
  * ɾ������
  * @param a
  * @return
  */
 public int delete(int a);
 /**
  * �޸�����
  * @param news
  * @return
  */
public int amentNews(News news);
/**
 * ��ѯ���ţ���ҳ��ѯ��
 */
public List<News> fenye(int   ziduan,int dijiye,int zongshu);
}
