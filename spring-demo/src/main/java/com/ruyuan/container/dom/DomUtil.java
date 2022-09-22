package com.ruyuan.container.dom;

import com.ruyuan.container.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class DomUtil {

	public static void main(String[] args) throws Exception {
		String xmlPath = "D:\\01-development\\idea\\projects\\spring-framework" +
				"\\spring-demo\\src\\main\\resources\\students.xml";
		//List<Student> students = getStudents(xmlPath);
		//System.out.println(students);
	}

	public static Document getDocument(String xmlPath) throws Exception{
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			return db.parse(xmlPath);
		} catch (Exception e) {
			throw new RuntimeException("文档解析失败...");
		}
	}

	public static List<Student> getStudents(String xmlPath) throws Exception {
		//1.获取student.xml对应Document
		Document document = getDocument(xmlPath);

		//2.获取xml中所有student的节点
		List<Student> students = new ArrayList<Student>();
		NodeList studentNodes = document.getElementsByTagName("student");
		for (int i = 0; i < studentNodes.getLength(); i++) {
			//3.遍历每个student节点
			Element studentEle = (Element) studentNodes.item(i);

			Student student = new Student();
			student.setName(studentEle.getElementsByTagName("name").item(0).getTextContent());
			//student.setAge(Integer.valueOf(studentEle.getElementsByTagName("age").item(0).getTextContent()));

			students.add(student);
		}

		//4.直接返回
		return students;
	}

}
