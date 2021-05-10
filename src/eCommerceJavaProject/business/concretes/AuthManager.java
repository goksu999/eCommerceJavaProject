package eCommerceJavaProject.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceJavaProject.business.abstracts.AuthService;
import eCommerceJavaProject.business.abstracts.UserService;
import eCommerceJavaProject.business.abstracts.VerifyService;
import eCommerceJavaProject.core.GoogleAuthManagerAdapter;
import eCommerceJavaProject.entities.concretes.User;

public class AuthManager implements AuthService{
	
	private UserService userService;
	private VerifyService verifyService;
	private GoogleAuthManagerAdapter googleAuthManagerAdapter;
	
	
	public AuthManager(UserService userService, VerifyService verifyService,
			GoogleAuthManagerAdapter googleAuthManagerAdapter) {
		
		this.userService = userService;
		this.verifyService = verifyService;
		this.googleAuthManagerAdapter = googleAuthManagerAdapter;
	}

	@Override
	public boolean signIn(User user) {
		if (user.getemail() == "") {
			System.out.println("E-mail girmediniz!!! ");
			return false;
		}

		if (user.getPassword() == "") {
			System.out.println("Parola girmediniz!!! ");
			return false;
		}

		User result = this.userService.getByMail(user.getemail());

		if (result == null) {
			System.out.println("Kullanıcı bulunamadı!!! ");
			return false;
		}
		if (!user.getPassword().equals(result.getPassword())) {
			System.out.println("Parola yanlış!!!");
			return false;
		}

		if (!user.isVerified()) {
			System.out.println("Kullanıcı henüz dogrulanmadı!!!");
			return false;
		}

		System.out.println("Sisteme giriş yapıldı!!! ");
		return true;
	}

	@Override
	public boolean signInWithGoogle(User user) {
		googleAuthManagerAdapter.login(user.getemail());

		User result = this.userService.getByMail(user.getemail());
		if (result == null) {
			user.setVerified(true);
			this.userService.add(user);
		}
		return true;
	}

	@Override
	public boolean signUp(User user) {
		if (this.userService.getByMail(user.getemail()) != null) {
			System.out.println("E-mail sistemde kayıtlı!");
			return false;
		}

		if (!this.isValidEmailAddress(user.getemail())) {
			System.out.println("E-mail formatı hatalı!");
			return false;
		}

		if (user.getFirsName().length() < 2) {
			System.out.println("Kullanıcı adı en az 2 karakter olmalı!");
			return false;
		}

		if (user.getLastName().length() < 2) {
			System.out.println("Kullanıcı soyadı en az 2 karakter olmalı!");
			return false;
		}

		if (user.getPassword().length() < 6) {
			System.out.println("Parola en az 6 karakter olmalı!");
			return false;
		}

		user.setVerified(false);
		this.userService.add(user);

		return true;
	}

	@Override
	public boolean signOut(User user) {
		System.out.println("Sistemden cıkıs yapıldı.");
		return false;
	}

	@Override
	public boolean isValidEmailAddress(String email) {
		Pattern p = Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean mailConfirmation(String email, String confirmCode) {
		boolean result = this.verifyService.verification(email, confirmCode);
		if (!result) {
			System.out.println("Kayıt doğrulama hatalı.");
			return false;
		}

		System.out.println("Kayıt doğrulama basarılı.");

		User user = this.userService.getByMail(email);
		user.setVerified(true);
		this.userService.update(user);

		return true;
	}
	
	

}
