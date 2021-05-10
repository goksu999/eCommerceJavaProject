package eCommerceJavaProject.business.abstracts;

public interface EmailService {
	
	
    public String SendMail(String eMail);
	
	public boolean Verify(String eMail,String confirmCode);
}
