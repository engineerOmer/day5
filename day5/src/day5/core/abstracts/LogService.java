package day5.core.abstracts;

import day5.entities.concretes.User;

public interface LogService {
	void LogIn(User user);
	void register(User user);
	
}
