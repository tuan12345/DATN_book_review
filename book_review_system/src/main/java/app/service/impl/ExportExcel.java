package app.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import app.dto.UserInfo;

public class ExportExcel extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=\"users.xls\"");
		List<UserInfo> users = (List<UserInfo>) model.get("userInfos");
		Sheet sheet = workbook.createSheet("List User");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("User ID");
		header.createCell(1).setCellValue("Full Name");
		header.createCell(2).setCellValue("Username");
		header.createCell(3).setCellValue("Email");
		header.createCell(4).setCellValue("Role");
		int rowNum = 1;
		for (UserInfo user : users) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(user.getId());
			row.createCell(1).setCellValue(user.getName());
			row.createCell(2).setCellValue(user.getUserName());
			row.createCell(3).setCellValue(user.getEmail());
			row.createCell(4).setCellValue(user.getRole().getName());
		}
	}

}
