package app.service;

import java.util.List;

import app.dto.RoleInfo;
import app.model.Role;

public interface RoleService extends BaseService<Integer, Role>{
	List<RoleInfo> loadRoles();
}
