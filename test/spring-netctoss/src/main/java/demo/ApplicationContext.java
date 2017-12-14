package demo;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ApplicationContext {
	//缓存Spring容器的Bean对象
	private Map<String, Object> beans=new HashMap<String, Object>();
	//利用配置文件初始化当前容器
	//利用xml配置文件，初始化全部的Bean对象
	public ApplicationContext(String xml) throws Exception{
		//利用DOM4j读取xml文件
		//解析xml文件内容，得到Bean的类名和Bean的ID
		//根据类名动态加载类并且创建对象
		//将对象和对应的ID添加到map中
		InputStream in=getClass().getClassLoader().getResourceAsStream(xml);//读Resources(classpath)读取流
		SAXReader reader=new SAXReader();//高级流,前期要打开一个低级流
		Document doc=reader.read(in);
		in.close();
		//解析xml：<beans><bean>
		Element root=doc.getRootElement();
		//读取根元素中全部的bean子元素
		List<Element> list=root.elements("bean");
		for (Element e : list) {
			//e 就是bean元素 id属性和class属性
			String id=e.attributeValue("id");
			String className=e.attributeValue("class");
			//动态加载类，动态创建对象
			Class cls=Class.forName(className);
			Object bean=cls.newInstance();
			beans.put(id, bean);
		}
	}
	
	public Object getBean(String id){
		//根据id在map查找对象，并返回对象
		return beans.get(id);
	}
	
	//泛型方法：优点是可以减少一次类型转换
	public <T> T getBean(String id,Class<T> cls){
		return (T)beans.get(id);
	}
}
