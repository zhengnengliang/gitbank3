package cn.itrip.utils;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static{
		//1 获取mybatis-config.xml的输入流
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession createSqlSession(){
		return factory.openSession(true);
	}
	public static void closeSqlSession(SqlSession sqlSession){
		if(null!= sqlSession){
			sqlSession.close();
		}
	}
}
