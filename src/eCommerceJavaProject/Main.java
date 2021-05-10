package eCommerceJavaProject;

import eCommerceJavaProject.business.abstracts.AuthService;
import eCommerceJavaProject.business.abstracts.EmailService;
import eCommerceJavaProject.business.abstracts.UserService;
import eCommerceJavaProject.business.abstracts.VerifyService;
import eCommerceJavaProject.business.concretes.AuthManager;
import eCommerceJavaProject.business.concretes.EmailManager;
import eCommerceJavaProject.business.concretes.UserManager;
import eCommerceJavaProject.business.concretes.VerifyManager;
import eCommerceJavaProject.core.GoogleAuthManagerAdapter;
import eCommerceJavaProject.dataAccess.concretes.InMemoryUserDao;
import eCommerceJavaProject.dataAccess.concretes.InMemoryVerifyDao;
import eCommerceJavaProject.entities.concretes.User;
import eCommerceJavaProject.entities.concretes.Verify;

public class Main {

	public static void main(String[] args) {
		
		User user = new User(1, "Göksu", "Yılmaz", "yilmazgoksu999@gmail.com", "123456", false);

		//Onay kodu mail yolu ile gönderiliyor.
		
		EmailService emailService = new EmailManager();
		String confirmCode = emailService.SendMail(user.getemail());

		// onay kodu fake veritabanına ekleniyor.
		
		Verify verify = new Verify(user.getemail(), confirmCode);
		VerifyService verifyService = new VerifyManager(new InMemoryVerifyDao());
		verifyService.add(verify);

		UserService userService = new UserManager(new InMemoryUserDao());
		AuthService authService = new AuthManager(userService, verifyService, new GoogleAuthManagerAdapter());
		authService.signUp(user); // yeni kullanici kayıt oluyor

		// yeni kullanici onay kodunu giriyor
		
		authService.mailConfirmation(user.getemail(), confirmCode);

		authService.signIn(user); // sisteme giriş yapılır
		authService.signOut(user); // sistemden cıkıs yapılır 

		// google kullanıcı
		User googleUser = new User(2, "google", "user", "googleuser@gmail.com", "", false);

		// google hesaba ile sisteme giriş yapılır
		authService.signInWithGoogle(googleUser);

			
	}

}
