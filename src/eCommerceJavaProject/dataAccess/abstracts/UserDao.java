package eCommerceJavaProject.dataAccess.abstracts;

import java.util.List;

import eCommerceJavaProject.entities.concretes.User;

public interface UserDao {

	void add(User user);
	
	void delete(User user);

	void update(User user);

	User getById(int id);

	User getByMail(String email);


	List<User> getAll();

}
