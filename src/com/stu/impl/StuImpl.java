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
	static SimpleDateFormat df = new SimpleDateFormat("Gyyyy��-MM��-dd�� HHʱ:mm��:ss�� E");

	/*
	 * ���˵�
	 */

	public void dispmenu() {

		try {

			while (true) {
				mainmenu();
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("*     1.¼��ѧ��ѧ����Ϣ                     *");
					addStu();
					break;
				case 2:
					System.out.println("*     2.��ʾѧ��ѧ����Ϣ                     *");
					Infomation();

					break;
				case 3:
					System.out.println("*     3.��ѯѧ��ѧ����Ϣ      *");

					find();
					break;

				case 4:
					System.out.println("*     4.�޸�ѧ��ѧ����Ϣ                     *");
					modify();
					break;
				case 5:
					System.out.println("*     5.ɾ��ѧ��ѧ����Ϣ                     *");
					deletStu();
					break;
				case 6:
					System.out.println("*     6.��ѧ�Ÿ�ѧ����Ϣ����           *");
					sort();
					break;
				case 0:
					System.out.println("*     0.�˳�ѧ��ѧ����Ϣ                     *");
					System.out.println("3����˳�ϵͳ ");
					try {
						Thread.sleep(3000);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.exit(0);
				default:
					System.out.println("�������󣡣���");
					continue;
				}
			}

		} catch (Exception e) {
			System.out.println("�쳣˵����");
			e.printStackTrace();
			System.exit(0);
			// TODO: handle exception
		}
	}

	/*
	 * ���ݳ�ʼ��������ϵͳ����ʱ��Ӳ���ѧ����Ϣ
	 */
	public void init() {
		Student s1 = new Student("114", "�޳�", 20, "��ʿ", "����ʡ����", "\t18885236271", "��Ϣϵ", "\t�ޱ䶯", "��");
		Student s2 = new Student("111", "������", 19, "��ʿ", "�㶫ʡ��ݸ��", "16665236271", "����ϵ", "\tתרҵ", "��");
		Student s3 = new Student("112", "��ҧ��", 17, "��ʿ", "����ʡ������", "18825234271", "��Ϣϵ", "\tתרҵ", "��");
		Student s4 = new Student("113", "��Ԫ��", 18, "��ʿ", "����ʡ����", "\t18845234271", "��ýϵ", "\t�ޱ䶯", "��");
		Student s5 = new Student("116", "���屦", 22, "��ʿ", "����ʡ����", "\t18815231271", "��óϵ", "\tתרҵ", "��");
		Student s6 = new Student("115", "������", 19, "Ůʿ", "����ʡ�ߺ���", "18385232271", "��Ϣϵ", "\t�ޱ䶯", "��");
		Student s7 = new Student("110", "��ͨ", 19, "��ʿ", "����ʡ�Ϸ���", "16885233271", "��ľϵ", "\t�ޱ䶯", "��");
		DataBase.getsList().add(s1);
		DataBase.getsList().add(s2);
		DataBase.getsList().add(s3);
		DataBase.getsList().add(s4);
		DataBase.getsList().add(s5);
		DataBase.getsList().add(s6);
		DataBase.getsList().add(s7);
	}

	/*
	 * ������
	 * 
	 */
	public void mainmenu() {

		System.out.println("");
		System.out.println(
				"*                  1.¼��ѧ��ѧ����Ϣ                                                                                    *");
		System.out.println(
				"*                  2.��ʾѧ��ѧ����Ϣ                                                                                    *");
		System.out.println(
				"*                  3.��ѯѧ��ѧ����Ϣ                                                                          *");
		System.out.println(
				"*                  4.�޸�ѧ��ѧ����Ϣ                                                                                      *");
		System.out.println(
				"*                  5.ɾ��ѧ��ѧ����Ϣ                                                                                      *");
		System.out.println(
				"*                  6.��ѧ�Ÿ�ѧ����Ϣ����                                                                                *");
		System.out.println(
				"*                  0.�˳�ѧ��ѧ����Ϣ                                                                                       *");

		System.out.println("\n��������Ҫѡ�����ţ�Ȼ�󰴻س�:");

	}

	/*
	 * ���ѧ����Ϣ�б�
	 */
	public void Infomation() {

		System.out
				.print("**************************************ѧ��ѧ����Ϣ��*********************************************\n");
		System.out.println("ѧ��\t����\t����\t�Ա�\t����\t\t��ϵ�绰\t\t����ϵ��\tѧ���䶯���\t�Ƿ��ҵ");
		for (int i = 0; i < DataBase.getsList().size(); i++) {
			System.out.println(DataBase.getsList().get(i));
			System.out.print(
					"______________________________________________________________________________________________\n");

		}
	}

	/*
	 * ���ѧ����Ϣ
	 */
	public void addStu() {
		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {
				Student student = new Student();
				System.out.println("������ѧ��");
				String num = sc.next();
				ArrayList<Student> sList = DataBase.getsList();
				for (int i = 0; i < sList.size(); i++) {
					if (sList.get(i).getNum().equals(num)) {
						System.out.println("ѧ���Ѿ������ˣ����·������˵���");
						dispmenu();
					} else {

						student.setNum(num);
					}
				}
				System.out.println("����������");
				String regex = "[\u4E00-\u9FA5]+";
				// ȷ���������ֵ�unicode��Χ[\u4E00-\u9FA5] // 1������ƥ��һ�����ֵ�д����// 2��������unicodeֵ������Unicode���еĺ��ֵ�ͷ��β��
																	// 3��"[]"������ߵ�ֵ����һ���Ϳ��ԣ���ߵġ�+���������ٳ���1�Σ�������������ƥ��һ�����֡�
																	// ������ʽУ��,����String.matches()�����ж�����ֵ�Ƿ����,ƥ����
				while (true) {
					String name = sc.next();
					if (name.matches(regex)) {
						student.setName(name);
						break;

					} else {
						System.out.println("����Ĳ�������");
					}
				}

				System.out.println("����������");
				student.setAge(sc.nextInt());
				System.out.println("�������Ա�");
				while (true) {
					String sex = sc.next();
					if (sex.equals("��") || sex.equals("Ů")) {
						student.setSex(sex);
						break;
					} else {
						System.out.println("�������л���Ů");
					}
				}
				System.out.println("�����뼮��");
				String rege = "[\u4E00-\u9FA5]+";
				while (true) {
					String nativeplace = sc.next();
					if (nativeplace.matches(rege)) {
						student.setNativeplace(nativeplace);
						break;
					} else {
						System.out.println("����Ĳ�������");
					}
				}
				System.out.println("��������ϵ�绰");
				while (true) {
					String mobilephone = sc.next();
					if (mobilephone.startsWith("1") && mobilephone.length() == 11) {
						student.setMobilephone(mobilephone);
						break;
					} else {
						System.out.println("������11λ���ĺ��벢�ҵ�һλ��1");
					}
				}
				while (true) {
					System.out.println("����¼������ϵ������ֻ�������з�Χ��ѡ��");
					Student.initDepartment();
					System.out.println("����������ϵ����ֻ��ѡ��ϵͳ������");
					int key = sc.nextInt();
					switch (key) {
					case 1:
						student.setDepartment("��ľϵ\t");
						break;
					case 2:
						student.setDepartment("��Ϣϵ\t");
						break;
					case 3:
						student.setDepartment("����ϵ\t");
						break;
					case 4:
						student.setDepartment("��ýϵ\t");
						break;
					case 5:
						student.setDepartment("��óϵ\t");
						break;
					case 6:
						student.setDepartment("����ϵ\t");
						break;

					default:
						System.out.println("���ڸ�����ϵ������ѡ��");
						continue;

					}
					break;
				}

				System.out.println("������ѧ���䶯���");
				student.setChange(sc.next());
				System.out.println("�������Ƿ��ҵ");
				student.setGradute(sc.next());
				if (ai.addStu(student)) {
					System.out.println("��ӳɹ�");
				} else {
					System.out.println("���ʧ�ܣ���");
				}
				System.out.println("����n����Nֹͣ��ӣ����������");
				yes = sc.next();
				System.out.println("@@@@@@@@@@@@@@@@*****����ӵ�ʱ����" + df.format(new Date()) + "��****@@@@@@@@@@@@@@@@@");

			}

		} catch (Exception e) {

			// TODO: handle exception
			System.out.println("¼����Ϣ�������������쳣˵����");

		}

	}

	/*
	 * ɾ��ѧ����Ϣ
	 */
	public void deletStu() {
		String yes = "y", num;
		try {
			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��������Ҫɾ����ѧ��");
				num = sc.next();
				if (ai.deletStu(num)) {
					System.out.println("ɾ���ɹ�");

				} else {
					System.out.println("ɾ��ʧ�ܣ���ȷ�Ϻ�ѧ�ţ���");
				}
				System.out.println("����n����Nֹͣɾ�������������ɾ��");
				yes = sc.next();

			}

		} catch (Exception e) {
			// TODO: handle exception

		}

	}

	/*
	 * ����ѧ����Ϣ
	 */
	public void find() {

		String yes = "y";
		try {

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("1:�����������ң����߰������ϲ��ң�  2������ѧ�Ž��в���  ");
				int key = sc.nextInt();
				System.out.println("������ؼ���");
				String keyname = sc.next();
				ArrayList<Student> sList = ai.find(keyname, key);
				for (int i = 0; i < sList.size(); i++) {
					Student stu = sList.get(i);
					showone(stu);
					System.out.println("һ����ѯ��" + sList.size() + "��");
				}
				System.out.println("������������ң�����n����N�˳�����");
				yes = sc.next();
			}

		} catch (Exception e) {

			// TODO: handle exception

		}

	}

	/*
	 * ������ʾѧ����Ϣ
	 */
	public void showone(Student stu) {
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println("ѧ��\t����\t����\t�Ա�\t����\t\t��ϵ�绰\t\t����ϵ��\tѧ���䶯���\t�Ƿ��ҵ");
		System.out.println(stu.toString());

	}

	/*
	 * �޸�ѧ����Ϣ
	 */

	public void modify() throws Exception {
		String yes = "y";
		try {

			while (!yes.equalsIgnoreCase("n")) {
				System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ��");
				String num = sc.next();
				Student stu = new Student();
				stu = ai.get(num);
				showone(stu);
				if (stu != null) {
					modifyInfo();
					int select = sc.nextInt();
					switch (select) {
					case 1:
						System.out.println("                                    1:���޸�ѧ��");
						stu.setNum(sc.next());
						break;
					case 2:
						System.out.println("                                    2:���޸�����");
						stu.setName(sc.next());
						break;
					case 3:
						System.out.println("                                    3:���޸�����");
						stu.setAge(sc.nextInt());
						break;
					case 4:
						System.out.println("                                    4:���޸��Ա�");
						stu.setSex(sc.next());
						break;
					case 5:
						System.out.println("                                    5:���޸ļ���");
						stu.setNativeplace(sc.next());
						break;
					case 6:
						System.out.println("                                    6:���޸���ϵ�绰");

						stu.setMobilephone(sc.next());
						break;
					case 7:
						System.out.println("                                    7:���޸�����ϵ��");
						stu.setDepartment(sc.next());
						break;
					case 8:
						System.out.println("                                    8:���޸�ѧ���䶯���");
						stu.setChange(sc.next());
						break;
					case 9:
						System.out.println("                                    9:���޸��Ƿ��ҵ");
						stu.setGradute(sc.next());
						break;
					case 0:
						System.out.println("                                    0:�˳��޸�");
						System.exit(0);
						break;
					default:
						System.out.println("��������,����������");
						continue;
					}

				}

				if (ai.modeifyStu(stu)) {
					System.out.println("�޸ĳɹ�");
				} else {
					System.out.println("�޸�ʧ�ܣ�����");
				}
				System.out.println("�Ƿ�����޸ģ�����������޸ģ�����n����N�˳��޸�");
				yes = sc.next();
				showone(stu);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("�쳣˵����");
			e.printStackTrace();
		}

	}

	public void modifyInfo() {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("                                    1:���޸�ѧ��");
		System.out.println("                                    2:���޸�����");
		System.out.println("                                    3:���޸�����");
		System.out.println("                                    4:���޸��Ա�");
		System.out.println("                                    5:���޸ļ���");
		System.out.println("                                    6:���޸���ϵ�绰");
		System.out.println("                                    7:���޸�����ϵ��");
		System.out.println("                                    8:���޸�ѧ���䶯���");
		System.out.println("                                    9:���޸��Ƿ��ҵ");
		System.out.println("                                    0:�˳��޸�");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println("\n   ��������Ҫ�޸ĵ���ţ�   ");

	}

	public void sort() {
		String yes = "y";
		try {
			while (!yes.equalsIgnoreCase("n")) {

				System.out.println("1:����ѧ������  2��������������  3����������������ѡ��");
				int key = sc.nextInt();
				ArrayList<Student> sList = ai.sort(key);
				for (int i = 0; i < sList.size(); i++) {
					Student stu = sList.get(i);
					showone(stu);
				}
				System.out.println("�����������������n����N�˳�����");
				yes = sc.next();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Student login(String usename, String password) throws Exception {
		Connection connection = null;// �������ݿ�
		PreparedStatement ps = null;// ��ִ����䣩����ִ�в��������ľ�̬sql��ѯ�͸���(�ڷ������˱��룬�����ظ�ִ�У����Ч�ʣ���������statement
		ResultSet rs = null;// �������sql��ѯ������������ִ�в�ѯ
		Student Student = null;
		System.out.println("test");
		try {
			connection = getConn();
			ps = connection.prepareStatement("select * from text where userName= ? and password= ?");
			ps.setString(1, usename);
			ps.setString(2, password);
			rs = ps.executeQuery();//ִ�в�ѯ
			if (rs.next()) {
				Student = new Student();

				Student.setPassword(rs.getString("password"));
				Student.setUsename(rs.getString("userName"));
			}
		} catch (Exception sqle) {
			sqle.printStackTrace();// ���������ݿ����ӵĽ������رջ�sql����ִ�й��̷����쳣
			throw sqle;
		} finally {         //�ͷ���Դ���ȴ򿪵ĺ�ر�
			rs.close();
			ps.close();
			connection.close();
		}
		return Student;
	}

	 public void disp() {
	 for (int i = 0; i <= 100; i++) {
	 for (int j = 0; j < 200; j++) {// ˢ��
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
	 Thread.sleep(120);//������������ʱ��
	 } catch (InterruptedException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 }
	 System.out.println();
	 System.out.println("���ȼ�����ϣ���������ѧ������ϵͳ...");
	 try {
	 Thread.sleep(2000);
	 } catch (InterruptedException e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	 System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

	 }
	private Connection getConn() throws Exception {
		String url = "jdbc:mysql://localhost:3306/aa"; // ���ݿ������ִ���url��ͳһ��Դ��λ��
		String useName = "root"; // ���ݿ��û�����
		String driver = "com.mysql.jdbc.Driver"; // ���ݿ���������
		String password = "root"; // ���ݿ��û���½����
		try {
			Connection con;
			Class.forName(driver);// ��װ����
			con = DriverManager.getConnection(url, useName, password);// DriverManger������ز�ͬ�����������Ҹ��ݲ�ͬ������������߷Ż���Ӧ�����ݿ�����
			return con;
		} catch (Exception e) {
			throw e;
		}
	}

	public void login() {
		try {
			System.out.println(">>>����������");
			String usename = sc.next();
			System.out.println(">>>�������¼����");
			String password = sc.next();
			Student stu = login(usename, password);

			if (stu != null) {
				System.out.println(">>>��ӭ��:" + stu.getUsename());
				dispmenu();

			} else {
				System.out.println(">>>�����ڻ��������,������");

			}
		} catch (Exception e) {
			System.out.print(">>>�쳣˵����");
			e.printStackTrace();
			System.out.println(e.toString());
		}

	}
}