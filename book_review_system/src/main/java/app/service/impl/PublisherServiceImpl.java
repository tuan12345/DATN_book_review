package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import app.dto.PublisherInfo;
import app.model.Publisher;
import app.service.PublisherService;

public class PublisherServiceImpl extends BaseServiceImpl implements PublisherService {

	@Override
	public PublisherInfo findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PublisherInfo saveOrUpdate(PublisherInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(PublisherInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PublisherInfo> publishers() {
		try {
				List<Publisher> list=publisherDAO.Publishers();
				List<PublisherInfo> listInfo=new ArrayList<>();
				for (Publisher publisher : list) {
					PublisherInfo publisherInfo=new PublisherInfo();
					publisherInfo.setId(publisher.getId());
					publisherInfo.setAddress(publisher.getAddress());
					publisherInfo.setName(publisher.getName());
					publisherInfo.setPhone(publisher.getPhone());
					publisherInfo.setNumberBook(bookDAO.findBooksByPublisherId(publisher.getId()).size());
					listInfo.add(publisherInfo);
				}
				return listInfo;
		} catch (Exception e) {
			return null;
		}
		
	}

}
