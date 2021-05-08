package day5;

import day5.business.abstracts.UserService;
import day5.business.concretes.UserManager;
import day5.core.concretes.LogManager;
import day5.dataAccess.concretes.HibernateUserDao;
import day5.entities.concretes.*;


public class Main {	
	public static void main(String[] args) {
		User user1=new User(1,"Omer","Sahin","omer@gmail.com","123456");
		registerSimulation(user1);
		loginSimulation(user1);
		User user2=new User(2,"ahmet","karaca","omer@gmail.com","123");
		registerSimulation(user2);
		loginSimulation(user2);
		
		
		
		
		

	}
	private static void registerSimulation(User user) {
		UserService userService=new UserManager(new HibernateUserDao(),new LogManager());
	
		if (userService.register(user)==true) {
			System.out.println("Emailinize onaylama postasi gönderilmistir");
			
			
			if (userService.emailVerification(user)==true) {
				System.out.println("Kayit OLusturuldu");
			}
			else {
				System.out.println("Kayit Olusturulamadi ");
			}
			//System.out.println("***********************************");
		}
		
		
		
	}


private static void loginSimulation(User user) {
	UserService userService = new UserManager(new HibernateUserDao(),new LogManager());
		
	
	
	
	if (userService.login(user)) {
		System.out.println("Giris basarili");
	}
	else {
		System.out.println("Giris basarisiz");
		
	}

	System.out.println("*********************************");
}


	}


