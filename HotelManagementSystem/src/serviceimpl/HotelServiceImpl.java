package serviceimpl;

import java.util.LinkedHashMap;

import dao.HotelRepo;
import entity.Customer;
import entity.address;
import service.HotelService;
import java.util.Scanner;
public class HotelServiceImpl implements HotelService,HotelRepo{
	Scanner scn1=new Scanner(System.in);
	{
		for(int i=101;i<=110;i++) {
			cm.put(i, null);
		}

		for(int i=201;i<=208;i++) {
			sm.put(i, null);
		}
		for(int i=301;i<=305;i++) {
			dm.put(i, null);
		}
	}

	@Override
	public void roominfo() {
		System.out.println("==========Classic Rooms===========");
		System.out.println("Hot water:Yes");
		System.out.println("Ac:No");
		System.out.println("Tv:No");
		System.out.println("Wifi:No");
		System.out.println("Price:2000 Rs");
		System.out.println("==========Standard Rooms===========");
		System.out.println("Hot water:Yes");
		System.out.println("Ac:No");
		System.out.println("Tv:Yes");
		System.out.println("Wifi:No");
		System.out.println("Price:2500 Rs");
		System.out.println("==========Deluxe Rooms===========");
		System.out.println("Hot water:Yes");
		System.out.println("Ac:Yes");
		System.out.println("Tv:Yes");
		System.out.println("Wifi:Yes");
		System.out.println("Price:3500 Rs");
	}
	public void checkRooms(LinkedHashMap<Integer, Customer> l1) {
		boolean flag=false;
		for(Integer ele:l1.keySet()) {
			if(l1.get(ele)==null) {
				System.out.print(ele+" ");
				flag=true;
			}
		}
		System.out.println();
		if(flag==false) {
			System.out.println("No Rooms Available");
		}
	}
	@Override
	public void availableRoom() {
		System.out.println("======Availablle Rooms======");
		System.out.println("======Classic Rooms======");
		checkRooms(cm);
		System.out.println("======Standard Rooms======");
		checkRooms(sm);
		System.out.println("======Deluxe Rooms======");
		checkRooms(dm);
	}
	public Customer createcustomer(){
		System.out.println("====Enter Customer Details====");
		System.out.println("Enter customer id");
		String cid=scn1.next();
		System.out.println("Enter customer name");
		String cname=scn1.next();
		System.out.println("Enter customer cphno");
		long cphno=scn1.nextLong();
		System.out.println("Enter customer cemail");
		String cemail=scn1.next();
		System.out.println("Enter customer cpan");
		String cpan=scn1.next();
		System.out.println("Enter doornum");
		int doornum=scn1.nextInt();
		System.out.println("Enter street");
		scn1.nextLine();
		String street=scn1.nextLine();
		System.out.println("Enter distrct");
		String district=scn1.next();
		System.out.println("Enter state");
		String state=scn1.next();
		System.out.println("Enter country");
		String country=scn1.next();
		System.out.println("Enter pincode");
		long cpincode=scn1.nextLong();
		address a1=new address(doornum, street, district, state, country, cpincode);
		return new Customer(cid,cname, cphno, cemail, a1, cpan);
	}
	public void mapRoom(LinkedHashMap<Integer,Customer> l1,int Roomno,double camt) {
		if(l1.get(Roomno)==null) {
			Customer c=createcustomer();
			a1.add(c);
			l1.put(Roomno, c);
			c.setCamt(camt);
			System.out.println("Room No :"+Roomno+" Had Been Allocated For "+c.getCname());
			System.out.println("======================================================");
		}
		else {
			System.out.println("Room is not available...!!");
		}
	}
	@Override
	public void allocateroom() {
		System.out.println("=====Menu=====");
		System.out.println("1.Classic Room\n2.Standard Room\n3.Deluxe Room");
		int op=scn1.nextInt();
		switch(op) {
		case 1:{System.out.println("Enter Roomno");
		int roomno1=scn1.nextInt();
		if(roomno1>=101&&roomno1<=110) {
			mapRoom(cm,roomno1,2000);
		}
		else {
			System.out.println("Enter Correct Room No...!!!");
		}
		}
		break;
		case 2:{System.out.println("Enter Roomno");
		int roomno2=scn1.nextInt();
		if(roomno2>=201&&roomno2<=208) {
			mapRoom(sm,roomno2,2500);
		}
		else {
			System.out.println("Enter Correct Room No...!!!");
		}
		} break;
		case 3:{System.out.println("Enter Roomno");
		int roomno3=scn1.nextInt();
		if(roomno3>=301&&roomno3<=305) {
			mapRoom(dm,roomno3,3500);
		}
		else {
			System.out.println("Enter Correct Room No...!!!");
		}
		} break;
		}
	}
	public void deallocateroom(LinkedHashMap<Integer, Customer> l1,int roomno) {
		if(l1.get(roomno)!=null) {
			Customer c1=l1.get(roomno);
			System.out.println(c1);
			System.out.println(c1.getCname()+"need To Pay "+c1.getCamt()+" Rs.");
			l1.put(roomno, null);
		}
	}
	@Override
	public void checkout() {
		System.out.println("Enter Your Room Type");
		System.out.println("1.Classic Rooms\n2.Standard Rooms\n3.Deluxe Room\n4.Exit");
		int r1=scn1.nextInt();
		System.out.println("Enter RoomNo :");
		int roomno=scn1.nextInt();
		switch(roomno) {
		case 1:{if(roomno>=101&&roomno<=110) {
			deallocateroom(cm, roomno);
		}else {
			System.out.println("invalid Roomno");
		}


		break;
		}
		case 2:{if(roomno>=201&&roomno<=208) {
			deallocateroom(sm, roomno);
		}else {
			System.out.println("invalid Roomno");
		}
		break;
		}
		case 3:{if(roomno>=301&&roomno<=308) {
			deallocateroom(dm, roomno);
		}else {
			System.out.println("invalid Roomno");
		}
		break;
		}
		case 4:System.exit(0);break;
		default:System.out.println("Invalid Option");break;
		}
	}
	@Override
	public void findallcustomer() {
		if(a1.size()==0) {
			System.out.println("Data Base Is Empty");
		}
		else {
			for(Customer ele:a1) {
				System.out.println(ele);
			}
		}
	}
	@Override
	public void findcustomerbyid() {
		boolean flag=false;
		System.out.println("Enter Customer id:-");
		String cid=scn1.next();
		for(Customer ele:a1) {
			if(ele.getCid().equals(cid)) {
				System.out.println(ele);
				flag=false;
			}
		}
		if(flag==false) {
			System.out.println("Invalid customer Id..!!");
		}

	}

}
