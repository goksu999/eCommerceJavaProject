package eCommerceJavaProject.core;

import eCommerceJavaProject.googleAuth.GoogleAuthenticationManager;

public class GoogleAuthManagerAdapter implements GoogleAuthService{

	@Override
	public void login(String eMail) {
		GoogleAuthenticationManager googleAuthenticationManager=new GoogleAuthenticationManager();
		googleAuthenticationManager.login(eMail);
		
	}

	
	
}
