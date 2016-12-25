/**
 * 
 */
package com.stu.dto;


/**
 * @author Administrator
 *
 */

public class Student {

	private String usename;

	private String password;// 密码
	private String num;// 学号
	private String name;// 姓名
	private int age;// 年龄
	private String sex;// 性别
	private String nativeplace;// 籍贯
	private String department;// 所在系部
	private String mobilephone;// 联系电话
	private String change;// 学籍变动情况
	private String gradute;// 是否毕业

	public String getUsename() {
		return usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getGradute() {
		return gradute;
	}

	public void setGradute(String gradute) {
		this.gradute = gradute;

	}

	/*
	 * 无参构造，为成员变量提供默认值
	 */
	public Student() {
	}

	/*
	 * 有参数的构造方法的主要目的是为类中的属性初始化的
	 */
	public Student(String num, String name, int age, String sex, String nativeplace, String mobilephone,
			String department, String change, String gradute) {
		// 创建实例化对象

		this.num = num;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.nativeplace = nativeplace;
		this.mobilephone = mobilephone;

		this.department = department;

		this.change = change;
		this.gradute = gradute;
		
	}

	@Override
	/*
	 * 返回一个以文本的格式，格式化的功能 (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.num + "\t" + this.name + "\t" + this.age + "\t" + this.sex + "\t" + this.nativeplace + "\t"
				+ this.mobilephone + "\t" + this.department + this.change + "\t\t" + this.gradute;
	}

public static void initDepartment() {
		
		
		
		System.out.println("1：土木系	2：信息系	3：汽车系	4：传媒系	5：经贸系	6：机电系");
	}


}
