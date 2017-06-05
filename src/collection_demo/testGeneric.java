package collection_demo;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sound.midi.VoiceStatus;

import org.omg.CORBA.PUBLIC_MEMBER;

public class testGeneric {
	public List<Course>courses;
	public testGeneric(){
		this.courses=new ArrayList<Course>();
	}
	/**
	 * 测试添加
	 * @param args
	 */
	public void testAdd() {
		Course cr1=new Course("1","大学语文");
		courses.add(cr1);
		//泛型中不能添加规定类型及其子类型以外的对象
		//courses.add("能否添加一些奇怪的方法！！！");
		Course cr2=new Course("2", "大学英语");
		courses.add(cr2);
	}
	/**
	 * 测试循环遍历
	 */
		public void testForEach(){
			for (Course cr : courses) {
				System.out.println(cr.id+":"+cr.name);
			}
	}
		public void testChild(){
			ChildCourse cr=new ChildCourse();
			cr.id="3";
			cr.name="我是子类型的课程";
			courses.add(cr);
		}
		/**
		 * 泛型不能使用基本类型
		 */
		public void testBasic(){
			List<Integer> list=new ArrayList<Integer>();
			list.add(1);
			System.out.println("基本类型必须使用包装类作为泛型！"+list.get(0));
				
			}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testGeneric tg=new testGeneric();
		tg.testAdd();
		tg.testForEach();
		tg.testChild();
		tg.testForEach();
		tg.testBasic();
		
	}

}
