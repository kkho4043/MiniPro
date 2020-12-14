package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonApp {
	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		System.out.print(">>메뉴 번호 : ");
		
		//DB 읽기 데이타
		Reader pd = new FileReader("C:\\java\\eclipse\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(pd );
		
		Writer pw= new FileWriter("C:\\java\\eclipse\\myperson.txt");
		BufferedWriter bw = new BufferedWriter(pw);
		
		String str;
		String[] sArr;
		ArrayList<Person> plist = new ArrayList<Person>();
		
		while(true) {
			str = br.readLine();
			
			if(str == null) {
				break;
			}
			sArr = str.split(",");
			
			plist.add(new Person(sArr[0] ,sArr[1],sArr[2]));
		}
		
		
		//DB 읽기 끝
		
			
		while(true) {
			System.out.println("********************************");
			System.out.println("*       전화번호 관리  프로그램      *");
			System.out.println("********************************");
			
			System.out.println("1.리스트 	2.등록  3.삭제  4.검색 5.종료");
			System.out.println("----------------------------------");
			
			
			int Mnum = sc.nextInt();
			
			if(Mnum == 1) {
				System.out.println("<1.리스트>");
				allDraw(plist);
				
				
			}else if(Mnum == 2) {
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				sc.nextLine();
				String strName = sc.nextLine();
				
				
				System.out.print(">휴대전화: ");
				String strPH = sc.nextLine();
				
				System.out.print(">회사전화: ");
				String strCompany= sc.nextLine();

				
				plist.add(new Person(strName,strPH,strCompany));
				for(int i = 0; i < plist.size();i++) {
					bw.write(backtolist(plist, i));
				}
				System.out.println("[등록되었습니다.]");
			}else if(Mnum == 3) {
				System.out.println("<3.삭제>");
				System.out.print(">번호");
				plist.remove(sc.nextInt());
				System.out.println("[삭제되었습니다.]");
				
			}else if(Mnum == 4) {
				
				System.out.println("<4.검색>");
				System.out.print(">이름: ");
				sc.nextLine();
				String nsearch = sc.nextLine();
				
				for (int i = 0; i < plist.size(); i++) {
					if(plist.get(i).getName().contains(nsearch)) {
						System.out.print(i+1 + ".\t");
						plist.get(i).draw();
					}
				}
				
			}else if(Mnum == 5 ) {
				System.out.println("********************************");
				System.out.println("*           감사합니다			   *");
				System.out.println("********************************");
				break;
			}else {
				System.out.println("잘못입력하셨습니다");
			}
		}

	}
	public static String backtolist(List<Person> list,int i) {
		
		String str = list.get(i).getName() + "," +list.get(i).getHp() + "," + list.get(i).getCompany()+ "\n";
		return str;
		
	}
	public static void allDraw(List<Person> list) {
		for(int i = 0; i < list.size();i++) {
			System.out.print(i+1 + ".\t");
			list.get(i).draw();
		}
	}
	
}
