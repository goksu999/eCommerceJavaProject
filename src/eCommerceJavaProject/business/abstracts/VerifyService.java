package eCommerceJavaProject.business.abstracts;

import eCommerceJavaProject.entities.concretes.Verify;

public interface VerifyService {

    void add(Verify verify);
	
	void delete(Verify verify);
	
	boolean verification(String eMail,String confirmCode);
}

