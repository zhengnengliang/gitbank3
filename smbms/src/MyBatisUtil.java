

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	static{
	  /*获取Mybatis-config.xml的输入流*/
	  try {
		InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
		  factory=new SqlSessionFactoryBuilder().build(is);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static SqlSession createSqlSession(){
		return factory.openSession(false);//true表示关闭事务控制，自动提交：false表示开启事务控制，若不传参数默认为true
		                                  //openSession()方法的参数为Boolean值时。
	}
	public static void closeSqlSession(SqlSession sqlSession){
		if(null !=sqlSession){
			sqlSession.close();
		}
	}
}
