package eCommerceJavaProject.business.concretes;

import java.util.List;

import eCommerceJavaProject.business.abstracts.UserService;
import eCommerceJavaProject.dataAccess.abstracts.UserDao;
import eCommerceJavaProject.entities.concretes.User;



public class UserManager implements UserService{
	
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		System.out.println("Kullanıcı eklendi : " + user.getFirsName());
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);;
		
	}

	@Override
	public User getByMail(String eMail) {
		return userDao.getByMail(eMail);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
	

	

}
