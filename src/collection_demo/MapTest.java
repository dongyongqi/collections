package collection_demo;

import java.security.KeyStore.Entry;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	/**
	 * 用来橙装学生类型对象
	 * @param args
	 */
public Map<String, Student>students;
/**
 * 在构造方法中初始化student属性
 * @param args
 */
	public MapTest(){
		this.students=new HashMap<String,Student>();
	}
	/**
	 * 添加方法：输入学生id，判断是否占用
	 * @param args
	 */
	public void testPut(){
		//创建Scanner对象，用那个来获取学生ID号和姓名
		Scanner console=new Scanner(System.in);
		int i=0;
		while (i<3) {
			System.out.println("请输入学生ID：");
			String ID=console.next();
			//判断是否被占用
			Student st=students.get(ID);
			if (st==null) {
				//请输入学生姓名
				System.out.println("请输入学生姓名：");
				String name=console.next();
				//创建新的学生对象
				Student newStudent=new Student(ID, name);
				//通过调用students的put方法，添加ID-学生映射
				students.put(ID, newStudent);
				System.out.println("成功添加学生:"+students.get(ID).id+"  "+students.get(ID).name);
				i++;
			}else{
				System.out.println("该学生ID已被占用！");
				continue;
			}
		}
	}
	/**
	 * 测试MAP的keyset方法
	 */
	public void testKeySet(){
		Set<String>KeySet=students.keySet();
		for (String studID : KeySet) {
			Student st=students.get(studID);
			if (st!=null) {
				System.out.println("学生"+st.name);
			}
		}
	}

	/**
	 * 测试删除Map中的映射
	 * @param args
	 */
	public void testRemove(){
		Scanner console=new Scanner(System.in);
		while(true){
			System.out.println("请输入要删除学生的ID");
		String ID=console.next();
		Student s=students.get(ID);
		if (s==null) {
			System.out.println("输入的ID不存在");
			continue;
		}
		students.remove(ID);
		System.out.println("成功删除学生："+s.name);
		break;
	}
}
	/**
	 * 通过entrySet方法来便利Map
	 * @param args
	 */
	public void entrySet() {
		Collection<java.util.Map.Entry<String,Student>>entrySet=students.entrySet();
		for (java.util.Map.Entry<String, Student> entry : entrySet) {
			System.out.println("取得建:"+entry.getKey());
			System.out.println("对应的值为:"+entry.getValue().name);
		}
	}
	public static void main(String[] args) {
		MapTest mt=new MapTest();
		mt.testPut();
		mt.testKeySet();
		mt.testRemove();     
		mt.entrySet();

	}
}
