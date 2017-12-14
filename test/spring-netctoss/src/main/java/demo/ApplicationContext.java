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
	//����Spring������Bean����
	private Map<String, Object> beans=new HashMap<String, Object>();
	//���������ļ���ʼ����ǰ����
	//����xml�����ļ�����ʼ��ȫ����Bean����
	public ApplicationContext(String xml) throws Exception{
		//����DOM4j��ȡxml�ļ�
		//����xml�ļ����ݣ��õ�Bean��������Bean��ID
		//����������̬�����ಢ�Ҵ�������
		//������Ͷ�Ӧ��ID���ӵ�map��
		InputStream in=getClass().getClassLoader().getResourceAsStream(xml);//��Resources(classpath)��ȡ��
		SAXReader reader=new SAXReader();//�߼���,ǰ��Ҫ��һ���ͼ���
		Document doc=reader.read(in);
		in.close();
		//����xml��<beans><bean>
		Element root=doc.getRootElement();
		//��ȡ��Ԫ����ȫ����bean��Ԫ��
		List<Element> list=root.elements("bean");
		for (Element e : list) {
			//e ����beanԪ�� id���Ժ�class����
			String id=e.attributeValue("id");
			String className=e.attributeValue("class");
			//��̬�����࣬��̬��������
			Class cls=Class.forName(className);
			Object bean=cls.newInstance();
			beans.put(id, bean);
		}
	}
	
	public Object getBean(String id){
		//����id��map���Ҷ��󣬲����ض���
		return beans.get(id);
	}
	
	//���ͷ������ŵ��ǿ��Լ���һ������ת��
	public <T> T getBean(String id,Class<T> cls){
		return (T)beans.get(id);
	}
}