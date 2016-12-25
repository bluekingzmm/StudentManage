package com.stu.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.stu.db.DataBase;
import com.stu.dto.Student;

public class StuImpl {

	static Scanner sc = new Scanner(System.in);
	static Assist ai = new Assist();
	static SimpleDateFormat df = new SimpleDateFormat("Gyyyy年-MM月-dd日 HH时:mm分:ss秒 E");

	/*
	 * 主菜单
	 */

	public void dispmenu() {

		try {

			while (true) {
				mainmenu();
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("*     1.录入学生学籍信息                     *");
					addStu();
					break;
				case 2:
					System.out.println("*     2.显示学生学籍信息                     *");
					Infomation();

					break;
				case 3:
					System.out.println("*     3.查询学生学籍信息      *");

					find();
					break;

				case 4:
					System.out.println("*     4.修改学生学籍信息                     *");
					modify();
					break;
				case 5:
					System.out.println("*     5.删除学生学籍信息                     *");
					deletStu();
					break;
				case 6:
					System.out.println("*     6.按学号给学籍信息排序           *");
					sort();
					break;
				case 0:
					System.out.println("*     0.退出学生学籍信息                     *");
					System.out.println("3秒后退出系统 ");
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.exit(0);
				default:
					System.out.println("输入有误！！！");
					continue;
				}
			}

		} catch (Exception e) {
			System.out.println("异常说明：");
			e.printStackTrace();
			System.exit(0);
			// TODO: handle exception
		}
	}

	/*
	 * 数据初始化，用于系统运行时添加部分学生信息
	 */
	public void init() {
		Student s1 = new Student("114", "罗成", 20, "男士", "安徽省阜阳", "\t18885236271", "信息系", "\t无变动", "否");
		Student s2 = new Student("111", "单雄信", 19, "男士", "广东省东莞市", "16665236271", "汽车系", "\t转专业", "否");
		Student s3 = new Student("112", "陈咬金", 17, "男士", "安徽省宿州市", "18825234271", "信息系", "\t转专业", "否");
		Student s4 = new Student("113", "李元霸", 18, "男士", "安徽省滁州", "\t18845234271", "传媒系", "\t无变动", "否");
		Student s5 = new Student("116", "秦叔宝", 22, "男士", "安徽省阜阳", "\t18815231271", "经贸系", "\t转专业", "否");
		Student s6 = new Student("115", "单冰冰", 19, "女士", "安徽省芜湖市", "18385232271", "信息系", "\t无变动", "否");
		Student s7 = new Student("110", "罗通", 19, "男士", "安徽省合肥市", "16885233271", "土木系", "\t无变动", "否");
		DataBase.getsList().add(s1);
		DataBase.getsList().add(s2);
		DataBase.getsList().add(s3);
		DataBase.getsList().add(s4);
		DataBase.getsList().add(s5);
		DataBase.getsList().add(s6);
		DataBase.getsList().add(s7);
	}

	/*
	 * 主界面
	 * 
	 */
	public void mainmenu() {

		System.out.println("");
		System.out.println(
				"*                  1.录入学生学籍信息                                                                                    *");
		System.out.println(
				"*                  2.显示学生学籍信息                                                                                    *");
		System.out.println(
				"*                  3.查询学生学籍信息                                                                          *");
		System.out.println(
				"*                  4.修改学生学籍信息                                                                                      *");
		System.out.println(
				"*                  5.删除学生学籍信息                                                                                      *");
		System.out.println(
				"*                  6.按学号给学籍信息排序                                                                                *");
		System.out.println(
				"*                  0.退出学生学籍信息                                                                                       *");

		System.out.println("\n请输入你要选择的序号，然后按回车:");

	}

	/*
	 * 输出学生信息列表
	 */
	public void Infomation() {

		System.out
				.print("**************************************学生学籍信息表*********************************************\n");
		System.out.println("学号\t名字\t年龄\t性别\t籍贯\t\t联系电话\t\t所在系部\t学籍变动情况\t是否毕业");
		for (int i = 0; i < DataBase.getsList().size(); i++) {
			System.out.println(DataBase.getsList().get(i));
			System.out.print(
					"______________________________________________________________________________________________\n");

		}
	}

	/*
	 * 添加学生信息
	 */
	public void addStu() {
		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {
				Student student = new Student();
				System.out.println("请输入学号");
				String num = sc.next();
				ArrayList<Student> sList = DataBase.getsList();
				for (int i = 0; i < sList.size(); i++) {
					if (sList.get(i).getNum().equals(num)) {
						System.out.println("学号已经存在了，重新返回主菜单！");
						dispmenu();
					} else {

						student.setNum(num);
					}
				}
				System.out.println("请输入姓名");
				String regex = "[\u4E00-\u9FA5]+";
				// 确定中文文字的unicode范围[\u4E00-\u9FA5] // 1、至少匹配一个汉字的写法。// 2、这两个unicode值正好是Unicode表中的汉字的头和尾。
																	// 3、"[]"代表里边的值出现一个就可以，后边的“+”代表至少出现1次，合起来即至少匹配一个汉字。
																	// 正则表达式校验,利用String.matches()方法判断输入值是否符合,匹配类
				while (true) {
					String name = sc.next();
					if (name.matches(regex)) {
						student.setName(name);
						break;

					} else {
						System.out.println("输入的不是中文");
					}
				}

				System.out.println("请输入年龄");
				student.setAge(sc.nextInt());
				System.out.println("请输入性别：");
				while (true) {
					String sex = sc.next();
					if (sex.equals("男") || sex.equals("女")) {
						student.setSex(sex);
						break;
					} else {
						System.out.println("请输入男或者女");
					}
				}
				System.out.println("请输入籍贯");
				String rege = "[\u4E00-\u9FA5]+";
				while (true) {
					String nativeplace = sc.next();
					if (nativeplace.matches(rege)) {
						student.setNativeplace(nativeplace);
						break;
					} else {
						System.out.println("输入的不是中文");
					}
				}
				System.out.println("请输入联系电话");
				while (true) {
					String mobilephone = sc.next();
					if (mobilephone.startsWith("1") && mobilephone.length() == 11) {
						student.setMobilephone(mobilephone);
						break;
					} else {
						System.out.println("请输入11位数的号码并且第一位是1");
					}
				}
				while (true) {
					System.out.println("下面录入所在系部，且只能在下列范围内选择：");
					Student.initDepartment();
					System.out.println("请输入所在系部，只能选择系统给出的");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						student.setDepartment("土木系\t");
						break;
					case 2:
						student.setDepartment("信息系\t");
						break;
					case 3:
						student.setDepartment("汽车系\t");
						break;
					case 4:
						student.setDepartment("传媒系\t");
						break;
					case 5:
						student.setDepartment("经贸系\t");
						break;
					case 6:
						student.setDepartment("机电系\t");
						break;

					default:
						System.out.println("请在给出的系部进行选择");
						continue;

					}
					break;
				}

				System.out.println("请输入学籍变动情况");
				student.setChange(sc.next());
				System.out.println("请输入是否毕业");
				student.setGradute(sc.next());
				if (ai.addStu(student)) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败！！");
				}
				System.out.println("输入n或者N停止添加，任意键继续");
				yes = sc.next();
				System.out.println("@@@@@@@@@@@@@@@@*****【添加的时间是" + df.format(new Date()) + "】****@@@@@@@@@@@@@@@@@");

			}

		} catch (Exception e) {

			// TODO: handle exception
			System.out.println("录入信息不正常！！，异常说明：");

		}

	}

	/*
	 * 删除学生信息
	 */
	public void deletStu() {
		String yes = "y", num;
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要删除的学号");
				num = sc.next();
				if (ai.deletStu(num)) {
					System.out.println("删除成功");

				} else {
					System.out.println("删除失败，请确认好学号！！");
				}
				System.out.println("输入n或者N停止删除，任意键继续删除");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	/*
	 * 查找学生信息
	 */
	public void find() {

		String yes = "y";
		try {

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("1:按照姓名查找（或者按照姓氏查找）  2：按照学号进行查找  ");
				int key = sc.nextInt();
				System.out.println("请输入关键字");
				String keyname = sc.next();
				ArrayList<Student> sList = ai.find(keyname, key);
				for (int i = 0; i < sList.size(); i++) {
					Student stu = sList.get(i);
					showone(stu);
					System.out.println("一共查询到" + sList.size() + "个");
				}
				System.out.println("任意键继续查找，输入n或者N退出查找");
				yes = sc.next();
			}

		} catch (Exception e) {

			// TODO: handle exception

		}

	}

	/*
	 * 单个显示学生信息
	 */
	public void showone(Student stu) {
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println("学号\t名字\t年龄\t性别\t籍贯\t\t联系电话\t\t所在系部\t学籍变动情况\t是否毕业");
		System.out.println(stu.toString());

	}

	/*
	 * 修改学生信息
	 */

	public void modify() throws Exception {
		String yes = "y";
		try {

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("请输入你要修改的学生学号");
				String num = sc.next();
				Student stu = new Student();
				stu = ai.get(num);
				showone(stu);
				if (stu != null) {
					modifyInfo();
					int select = sc.nextInt();
					switch (select) {
					case 1:
						System.out.println("                                    1:请修改学号");
						stu.setNum(sc.next());
						break;
					case 2:
						System.out.println("                                    2:请修改姓名");
						stu.setName(sc.next());
						break;
					case 3:
						System.out.println("                                    3:请修改年龄");
						stu.setAge(sc.nextInt());
						break;
					case 4:
						System.out.println("                                    4:请修改性别");
						stu.setSex(sc.next());
						break;
					case 5:
						System.out.println("                                    5:请修改籍贯");
						stu.setNativeplace(sc.next());
						break;
					case 6:
						System.out.println("                                    6:请修改联系电话");

						stu.setMobilephone(sc.next());
						break;
					case 7:
						System.out.println("                                    7:请修改所在系部");
						stu.setDepartment(sc.next());
						break;
					case 8:
						System.out.println("                                    8:请修改学籍变动情况");
						stu.setChange(sc.next());
						break;
					case 9:
						System.out.println("                                    9:请修改是否毕业");
						stu.setGradute(sc.next());
						break;
					case 0:
						System.out.println("                                    0:退出修改");
						System.exit(0);
						break;
					default:
						System.out.println("输入有误,请重新输入");
						continue;
					}

				}

				if (ai.modeifyStu(stu)) {
					System.out.println("修改成功");
				} else {
					System.out.println("修改失败！！！");
				}
				System.out.println("是否继续修改，任意键继续修改，输入n或者N退出修改");
				yes = sc.next();
				showone(stu);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("异常说明：");
			e.printStackTrace();
		}

	}

	public void modifyInfo() {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("                                    1:请修改学号");
		System.out.println("                                    2:请修改姓名");
		System.out.println("                                    3:请修改年龄");
		System.out.println("                                    4:请修改性别");
		System.out.println("                                    5:请修改籍贯");
		System.out.println("                                    6:请修改联系电话");
		System.out.println("                                    7:请修改所在系部");
		System.out.println("                                    8:请修改学籍变动情况");
		System.out.println("                                    9:请修改是否毕业");
		System.out.println("                                    0:退出修改");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("\n   请输入你要修改的序号：   ");

	}

	public void sort() {
		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("1:按照学号排序  2：按照姓名排序  3：按照年龄排序，请选择");
				int key = sc.nextInt();
				ArrayList<Student> sList = ai.sort(key);
				for (int i = 0; i < sList.size(); i++) {
					Student stu = sList.get(i);
					showone(stu);
				}
				System.out.println("任意键继续排序，输入n或者N退出排序");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Student login(String usename, String password) throws Exception {
		Connection connection = null;// 连接数据库
		PreparedStatement ps = null;// （执行语句）用来执行不含参数的静态sql查询和更新(在服务器端编译，允许重复执行，提高效率）不建议用statement
		ResultSet rs = null;// 用来获得sql查询结果（结果集）执行查询
		Student Student = null;
		System.out.println("test");
		try {
			connection = getConn();
			ps = connection.prepareStatement("select * from text where userName= ? and password= ?");
			ps.setString(1, usename);
			ps.setString(2, password);
			rs = ps.executeQuery();//执行查询
			if (rs.next()) {
				Student = new Student();

				Student.setPassword(rs.getString("password"));
				Student.setUsename(rs.getString("userName"));
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();// 代表在数据库连接的建立，关闭或sql语句的执行过程发生异常
			throw sqle;
		} finally {         //释放资源，先打开的后关闭
			rs.close();
			ps.close();
			connection.close();
		}
		return Student;
	}

	 public void disp() {
	 for (int i = 0; i <= 100; i++) {
	 for (int j = 0; j < 200; j++) {// 刷屏
	 System.out.println();
	 }
	 for (int j = 0; j < i / 2; j++) {
	 System.out.print("<");
	 try {
	 Thread.sleep(0);
	 } catch (InterruptedException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 for (int j = 100; j > i; j -= 2) {
	 System.out.print("=");
	 }
	 System.out.print(i + "%");
	 try {
	 Thread.sleep(120);//整个进度条的时间
	 } catch (InterruptedException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 System.out.println();
	 System.out.println("进度加载完毕，即将进入学生管理系统...");
	 try {
	 Thread.sleep(2000);
	 } catch (InterruptedException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	 }
	private Connection getConn() throws Exception {
		String url = "jdbc:mysql://localhost:3306/aa"; // 数据库连接字串，url：统一资源定位符
		String useName = "root"; // 数据库用户名称
		String driver = "com.mysql.jdbc.Driver"; // 数据库驱动名称
		String password = "root"; // 数据库用户登陆密码
		try {
			Connection con;
			Class.forName(driver);// 安装驱动
			con = DriverManager.getConnection(url, useName, password);// DriverManger负责加载不同的驱动，并且根据不同的请求，向调用者放回相应额数据库连接
			return con;
		} catch (Exception e) {
			throw e;
		}
	}

	public void login() {
		try {
			System.out.println(">>>请输入名字");
			String usename = sc.next();
			System.out.println(">>>请输入登录密码");
			String password = sc.next();
			Student stu = login(usename, password);

			if (stu != null) {
				System.out.println(">>>欢迎您:" + stu.getUsename());
				dispmenu();

			} else {
				System.out.println(">>>不存在或密码错误,请重试");

			}
		} catch (Exception e) {
			System.out.print(">>>异常说明：");
			e.printStackTrace();
			System.out.println(e.toString());
		}

	}
}