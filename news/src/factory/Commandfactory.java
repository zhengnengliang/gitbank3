package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import action.Action;



//����ģʽ���Ǵ��������
public class Commandfactory {
		public Action getAction(String namename) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
			
			Action action=null;
			InputStream in=	Commandfactory.class.getClassLoader().getResourceAsStream("find.properties");
			Properties params=new Properties();
			try {
				params.load(in);
				//in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (Action)Class.forName(params.getProperty(namename)).newInstance();
			
		}
}
/*2.Properties�е���Ҫ����

(1)load(InputStream inStream)

 ��������������Դ�.properties�����ļ���Ӧ���ļ��������У����������б�Properties�����������Ĵ��룺

Properties pro = new Properties();
FileInputStream in = new FileInputStream("a.properties");
pro.load(in);
in.close();
(2)store(OutputStream out, String comments)

 �������������Properties�����������б��浽������С�������Ĵ��룺

FileOutputStream oFile = new FileOutputStream(file, "a.properties");
pro.store(oFile, "Comment");
oFile.close();
�������comments��Ϊ�գ������������ļ���һ�л���#comments,��ʾע����Ϣ�����Ϊ����û��ע����Ϣ��

����ע����Ϣ�����������ļ��ĵ�ǰ����ʱ����Ϣ��

(3)getProperty/setProperty

 ���������������Ƿֱ��ǻ�ȡ������������Ϣ��*/