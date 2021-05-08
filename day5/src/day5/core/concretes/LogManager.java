package day5.core.concretes;

import day5.core.abstracts.LogService;
import day5.entities.concretes.User;
import day5.googleSignup.GoogleSignupManager;

public class LogManager implements LogService{

	@Override
	public void LogIn(User user) {
		GoogleSignupManager googleSignupManager = new GoogleSignupManager();
		googleSignupManager.logIn(user);
		
	}

	@Override
	public void register(User user) {
		GoogleSignupManager googleSignupManager = new GoogleSignupManager();
		googleSignupManager.register(user);
		
	}

	
	
	
	
}
