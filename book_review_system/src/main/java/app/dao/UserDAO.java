package app.dao;

import java.util.List;
import app.model.User;

public interface UserDAO extends BaseDAO<Integer, User> {
	List<User> loadUsers(int page);
	
	int loadRowsCount();

	User findByIdLock(int id, boolean lock);

	User loadUserByUserName(String username);
	
	User findByUserNameAndEmail(String userName, String email);
	List<User> loadAllUsers();
}
