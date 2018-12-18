package app.service;

import java.util.List;
import app.dto.PublisherInfo;
public interface PublisherService extends BaseService<Integer, PublisherInfo> {
	List<PublisherInfo> publishers();

}
