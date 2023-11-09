package controller;

import java.util.Scanner;
import service.HotelService;
import serviceimpl.HotelServiceImpl;
public class HotelApp {
	public static void main(String[] args) {
		
	
	Scanner ip = new Scanner(System.in);
	HotelService h1=new HotelServiceImpl();
	System.out.println("======Welcome To Hotel Management System======");
	while(true) {
		System.out.println("====Menu====");
		System.out.println("1.RoomInfo\n2.Available Rooms\n3.Allocate Room\n4.Deallocate Room\n5.Find all customer\n6.Find Customer By Id\n7.Exit");
		int opt=ip.nextInt();
		switch(opt) {
		case 1:h1.roominfo();break;
		case 2:h1.availableRoom();break;
		case 3:h1.allocateroom();break;
		case 4:h1.checkout();break;
		case 5:h1.findallcustomer();break;
		case 6:h1.findcustomerbyid();break;
		case 7:System.out.println("======Thank You Visit Again======");break;
		
		default:System.out.println("Enter Valid Option");break;
		}
	}
	}
}
