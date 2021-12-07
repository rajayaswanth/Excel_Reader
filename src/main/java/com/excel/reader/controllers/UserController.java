package com.excel.reader.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.excel.reader.entities.User;
import com.excel.reader.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/import")
	public void mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
	    List<User> tempUserList = new ArrayList<>();
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    
	    for(int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
	    	User tempUser = new User();
	        XSSFRow row = worksheet.getRow(i);
	        tempUser.setName(row.getCell(0).getStringCellValue());
	        tempUser.setEmail(row.getCell(1).getStringCellValue());
	        tempUserList.add(tempUser);   
	    }
	    userService.addUsers(tempUserList);
	}

}
