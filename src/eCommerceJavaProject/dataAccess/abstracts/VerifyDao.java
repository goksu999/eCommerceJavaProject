package eCommerceJavaProject.dataAccess.abstracts;

import eCommerceJavaProject.entities.concretes.Verify;

public interface VerifyDao {

    void add(Verify verify);
	
	void delete(Verify verify);
	
	boolean verification(String eMail,String confirmCode);
}
