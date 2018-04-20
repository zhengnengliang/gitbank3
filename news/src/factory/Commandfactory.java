package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import action.Action;



//工厂模式就是创建对象的
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
/*2.Properties中的主要方法

(1)load(InputStream inStream)

 　　这个方法可以从.properties属性文件对应的文件输入流中，加载属性列表到Properties类对象。如下面的代码：

Properties pro = new Properties();
FileInputStream in = new FileInputStream("a.properties");
pro.load(in);
in.close();
(2)store(OutputStream out, String comments)

 　　这个方法将Properties类对象的属性列表保存到输出流中。如下面的代码：

FileOutputStream oFile = new FileOutputStream(file, "a.properties");
pro.store(oFile, "Comment");
oFile.close();
　　如果comments不为空，保存后的属性文件第一行会是#comments,表示注释信息；如果为空则没有注释信息。

　　注释信息后面是属性文件的当前保存时间信息。

(3)getProperty/setProperty

 　　这两个方法是分别是获取和设置属性信息。*/