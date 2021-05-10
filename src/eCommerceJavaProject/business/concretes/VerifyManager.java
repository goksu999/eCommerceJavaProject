package eCommerceJavaProject.business.concretes;

import eCommerceJavaProject.business.abstracts.VerifyService;
import eCommerceJavaProject.dataAccess.abstracts.VerifyDao;
import eCommerceJavaProject.entities.concretes.Verify;

public class VerifyManager implements VerifyService {
	
    private VerifyDao verifyDao;
	
	
	public VerifyManager(VerifyDao verifyDao) {
		super();
		this.verifyDao = verifyDao;
	}

	@Override
	public void add(Verify verify) {
		this.verifyDao.add(verify);
		
	}

	@Override
	public void delete(Verify verify) {
		this.verifyDao.delete(verify);
		
	}

	@Override
	public boolean verification(String eMail, String confirmCode) {
		return this.verifyDao.verification(eMail, confirmCode);
	}

}
