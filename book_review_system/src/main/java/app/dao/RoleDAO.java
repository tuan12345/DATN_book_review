package app.dao;

import java.util.List;

import app.model.Role;

public interface RoleDAO extends BaseDAO<Integer, Role>{
	List<Role> loadRoles();
}
