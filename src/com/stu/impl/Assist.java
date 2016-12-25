package com.stu.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.stu.db.DataBase;
import com.stu.dto.Student;

public class Assist {

	
	/*
	 * 添加学生的功能，boolean判断是否添加成功
	 */
	public boolean addStu(Student s) {

		return DataBase.getsList().add(s);
	}

	/*删除学生信息
	 * 先找到这个学生的学号，在进行删除
	 */
	public boolean deletStu(String num) throws Exception {

		Student stu = get(num);
		return DataBase.getsList().remove(stu);
	}

	/*
	 * 查询学生信息的功能
	 * 用ArrayList
	 * 通过学号姓名查找学生 add是将查询到的学生信息加到sList中
	 * indexof索引应用
	 * chatAt不一样
	 */

	public ArrayList<Student> find(String keyname, int key) {
	
		ArrayList<Student> sList = new ArrayList<Student>();
		Iterator<Student> iterable = DataBase.getsList().iterator();
		while (iterable.hasNext()) {
			Student stu =  iterable.next();
			switch (key) {
			case 1:
				if (stu.getName().indexOf(keyname) == 0) {
					sList.add(stu);
				}

				break;
			case 2:
				if (stu.getNum().indexOf(keyname) == 0) {
					sList.add(stu);
				}
				break;

			default:
				
				break;
			}

		}

		return sList;
	}

	public Student get(String num) throws Exception {
		int i;
		for (i = 0; i < DataBase.getsList().size(); i++) {
			if (num.equals(DataBase.getsList().get(i).getNum()) ) {
				return DataBase.getsList().get(i);

			}
		}
		return null;

	}
	/*
	 * boolean用于StuImpl中是否修改成功
	 */
	public boolean modeifyStu(Student s) throws Exception {

		ArrayList<Student> sList = DataBase.getsList();
		Student stu = get(s.getNum());// 找到这个学生信息
		sList.remove(stu);//将原先的删除
		return sList.add(stu);//再添加进去

	}

	public ArrayList<Student> sort(int key) {
		ArrayList<Student> sList = DataBase.getsList();
		Comparator<Student> comBynum = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {

				return s1.getNum().compareTo(s2.getNum());
			}
		};
		Comparator<Student> comByname = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				return s1.getName().compareTo(s2.getName());
			}
		};
		switch (key) {
		case 1:
		Collections.sort(sList,comBynum);
			break;
		case 2:
			Collections.sort(sList, comByname);
			break;
		case 3:
			sortByage();
			break;
		default:
			System.out.println("出现异常错误！！");
			break;
		}

		return sList;

	}

	public boolean login(String usename, String password) {

		Iterator<Student> iterator = DataBase.getsList().iterator();
		while (iterator.hasNext()) {
			Student stu = iterator.next();
			if (stu.getUsename().equals(usename) && stu.getPassword().equals(password)) {
				return true;
			}

		}
		return false;
	}
	
	/*
	 * 按照年龄排序
	 */
	public void sortByage(){
		ArrayList<Student> sList=DataBase.getsList();
		for (int i = 0; i < sList.size()-1; i++) {
			for (int j = 0; j <sList.size()-i-1; j++) {
				if(sList.get(j).getAge()>sList.get(j+1).getAge()){
					Student stu=sList.get(j);
					sList.set(j, sList.get(j+1));
					sList.set(j+1, stu);
				}
				
			}
		}
	}
}
