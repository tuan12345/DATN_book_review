package app.service;

import java.util.List;

import app.dto.ActivityInfo;
import app.dto.ReviewInfo;
import app.model.Activity;

public interface ActivityService extends BaseService<Integer, Activity>{
	List<ActivityInfo> loadActivitiesByUserName(String userName);
	List<ActivityInfo> loadActivitiesFollowedByUserId(int user_id);
	ActivityInfo saveReviewActivity(ReviewInfo reviewInfo,int user_id);
	
}
