package app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.dto.RequestInfo;

@CrossOrigin
@RestController
public class RequestsController extends BaseController {
	private static final Logger logger = Logger.getLogger(RequestsController.class);

	@RequestMapping(value = "/requests", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<RequestInfo> getRequests() {
		logger.info("load Requests");
		return requestService.loadRequests();
	}

	@RequestMapping(value = "/requests/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteRequest(@PathVariable("id") String id) {
		logger.info("delete Requests id: " + id);
		requestService.deleteRequest(Integer.parseInt(id));
	}

	@RequestMapping(value = "/requests/{id}/{status}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody RequestInfo editRequest(@PathVariable("id") String id, @PathVariable("status") String status) {
		return requestService.updateRequest(Integer.parseInt(id), Integer.parseInt(status));
	}
}
