package app.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import app.dto.UserInfo;

public class ImportExcel {

	public static List<UserInfo> importExcel(MultipartFile file) {
		HSSFWorkbook workbook;
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		try {
			workbook = new HSSFWorkbook(file.getInputStream());
			HSSFSheet worksheet = workbook.getSheetAt(0);
			int i = 0;
			while (i <= worksheet.getLastRowNum()) {
				UserInfo userInfo = new UserInfo();
				HSSFRow row = worksheet.getRow(i++);
				userInfo.setName(row.getCell(0).getStringCellValue());
				userInfo.setUserName(row.getCell(1).getStringCellValue());
				userInfo.setEmail(row.getCell(2).getStringCellValue());
				userInfos.add(userInfo);
			}
			workbook.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfos;
	}
}
