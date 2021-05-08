package day5.business.concretes;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

import day5.business.abstracts.UserService;
import day5.core.abstracts.LogService;
import day5.dataAccess.abstracts.Userdao;
import day5.entities.concretes.User;

public class UserManager implements UserService{
	
	private Userdao userdao;
	private LogService logService;
	
	
	
	public UserManager(Userdao userdao, LogService logService) {
		super();
		this.userdao = userdao;
		this.logService = logService;
	}
	
	public static boolean isEmailValid(String eposta) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(eposta).matches();
	}

	public static boolean isEmailValidOnClick() {
		return true;
	}
	
	@Override
	public void add(User user) {
		if (register(user)==false) {
			System.out.println("Hata! Eklenmedi");
			
		}
		userdao.add(user);
	}
	

	@Override
	public boolean emailValidator(String eposta) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(eposta);
	   if (matcher.matches()==false) {
		   System.out.println("Email dogrulamasi basarisiz!");
		
	}
	
		return true;
	}
	

	@Override
	public boolean emailVerification(User user) {
		System.out.println("Onaylama basarili. Siteye yönlendiriliyorsunuz!");
		return true;
	}

	@Override
	public boolean register(User user) {
		if (user.getParola().length()<6 || user.getFirstName().length()<2 || user.getLastName().length()<2 || emailValidator(user.getEposta())==false) {
			System.out.println("Kayit olusturulamadi, bilgilerinizi kontrol ediniz!");
			return false;
			
		}
		
		logService.register(user);
		
		return true;
		
	}

	@Override
	public boolean login(User user) {
		if (user.getEposta()	.isEmpty() || user.getParola().isEmpty()) {
			return false;
		}
		
		logService.LogIn(user);
		return true;
	}
	






}
