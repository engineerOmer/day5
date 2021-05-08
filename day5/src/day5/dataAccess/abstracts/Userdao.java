package day5.dataAccess.abstracts;

import java.util.List;

import day5.entities.concretes.User;

public interface Userdao {
		void add(User user);
		void update(User user);
		
		
		
		User get(String eposta,String parola);
		
		List<User> getAll();
		
		
		
}
