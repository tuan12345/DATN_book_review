package app.dao;

import java.util.List;

import app.model.Activity;

public interface ActivityDAO extends BaseDAO<Integer, Activity>{
	List<Activity> loadActivitiesByUserName(String userName);
	List<Activity> loadActivitiesFollowedByUserId(int user_id);
}
