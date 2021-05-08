package day5.dataAccess.concretes;

import java.util.List;

import day5.dataAccess.abstracts.Userdao;
import day5.entities.concretes.User;

public class HibernateUserDao implements Userdao{

	@Override
	public void add(User user) {
		System.out.println("Kullanici Hibernate ile uye oldu. " + user.getFirstName() + user.getLastName());
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanici bilgilerini guncelledi. " + user.getFirstName());
		
	}


	@Override
	public User get(String eposta, String parola) {
		
		return null;
	}

	@Override
	public List<User> getAll() {
		
		return null;
	}

}
