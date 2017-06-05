package collection_demo;

import java.util.List;
import java.util.zip.CRC32;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test {
		public List coursesToSelect;
		/**
		 * 被选课程类
		 */
		public Test(){
			this.coursesToSelect=new ArrayList();
		}
		public void testAdd(){
			Course cr1=new Course("1","数据结构");
			coursesToSelect.add(cr1);
			Course temp=(Course) coursesToSelect.get(0);
			System.out.println("添加了课程："+temp.id+"."+temp.name);
			
			Course cr2=new Course("2","C语言");
			coursesToSelect.add(0,cr2);
			Course temp2=(Course) coursesToSelect.get(0);
			System.out.println("添加了课程："+temp2.id+"."+temp2.name);
			  
			Course[] course={new Course("3", "离散数学"),new Course("4", "汇编语言")};
			coursesToSelect.addAll(Arrays.asList(course));
			Course temp3=(Course) coursesToSelect.get(2);
			Course temp4=(Course) coursesToSelect.get(3);
			System.out.println("添加了两门课程："+temp3.id+":"+
			temp3.name+":"+temp4.id+":"+temp4.name);
			
			Course[] course1={new Course("5", "java面向对象"),new Course("6", "英语")};
			coursesToSelect.addAll(Arrays.asList(course1));
			Course temp5=(Course) coursesToSelect.get(4);
			Course temp6=(Course) coursesToSelect.get(5);
			System.out.println("添加了两门课程："+temp5.id+":"+
					temp5.name+":"+temp6.id+":"+temp6.name);
		}
		/**
		 * 取list中元素的方法
		 * @param args
		 */
		public void testGet(){
			int size=coursesToSelect.size();
			System.out.println("有如下课程待选：");
			for (int i = 0; i < size; i++) {
				Course cr=(Course) coursesToSelect.get(i);
				System.out.println("课程:"+cr.id+":"+cr.name);
			}
		}
		/**
		 * 通过迭代器遍历list
		 * @param args
		 */
		public void testIterator(){
			Iterator it=coursesToSelect.iterator();
//通过迭代器访问
			System.out.println("有如下课程待选：(通过迭代器遍历list)");
			while (it.hasNext()) {
				Course cr =(Course) it.next();
				System.out.println("课程:"+cr.id+":"+cr.name);
			}
		}
		/**
		 * for each方法写
		 * @param args
		 */
		public void testForEach(){
			System.out.println("有如下课程待选：(for each方法写)");
			for (Object obj : coursesToSelect) {
				Course cr=(Course) obj;
				System.out.println("课程:"+cr.id+":"+cr.name);
			}
		}
		/**
		 * 修改list中的元素
		 */
		public void testModify(){
			coursesToSelect.set(4,new Course("7","毛概" ));
		}
		/**
		 * 删除元素
		 * @param args
		 */
		public void testRemove(){
			Course cr=(Course) coursesToSelect.get(4);
			System.out.println("我是课程："+cr.id+":"+cr.name+",我将被删除");
			Course[] courses={(Course) coursesToSelect.get(4),(Course) coursesToSelect.get(5)};
		//	coursesToSelect.remove(cr);
			coursesToSelect.removeAll(Arrays.asList(courses));
			System.out.println("成功删除课程");
			testForEach();
		}
			/**
			 * 
			 */
		public void testType(){
			System.out.println("能否添加怪的东西  。。。");
				coursesToSelect.add("我不是课程，我是个字符串!!!");
			}
		public static void main(String[] args) {
			Test t=new Test();
			t.testAdd();
			t.testGet();
			t.testIterator();
			t.testForEach();
			t.testModify();
			t.testForEach();
			t.testRemove();
			t.testType();
			t.testForEach();
		}
}
