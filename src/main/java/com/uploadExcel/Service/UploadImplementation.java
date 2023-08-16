package com.uploadExcel.Service;

import java.io.InputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.uploadExcel.Entity.*;
import com.uploadExcel.Repository.ExcelDatabase;

import java.util.*;

@Service
public class UploadImplementation {
	@Autowired
	ExcelDatabase exceldatabase;

	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		try {
			InputStream inputStream = file.getInputStream();
			try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
				Sheet sheet11 = workbook.getSheetAt(0); // Assuming the data is present in the first sheet

				List<ExcelTable> entities = new ArrayList<>();

				for (Row row : sheet11) {
					// Assuming the data starts from the second row, adjust the index if needed
					if (row.getRowNum() > 0) {
						String id = row.getCell(0).getStringCellValue();
						String column1 = row.getCell(1).getStringCellValue();
						String column2 = row.getCell(2).getStringCellValue();
						// Extract other columns as needed

						ExcelTable entity = new ExcelTable();
						entity.setId(id);
						entity.setColumn1(column1);
						entity.setColumn2(column2);
						// Set other properties

						entities.add(entity);
					}
				}

				exceldatabase.saveAll(entities);
			}
			return ResponseEntity.ok("File uploaded and data saved successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading the file.");
		}
	}

	public List<ExcelTable> getAllData() {
		List<ExcelTable> excelTableData = exceldatabase.findAll();
		List<ExcelTable> result = new ArrayList<>();

		for (ExcelTable excelTable : excelTableData) {
			ExcelTable Data = new ExcelTable();
			Data.setId(excelTable.getId());
			Data.setColumn1(excelTable.getColumn1());
			Data.setColumn2(excelTable.getColumn2());
			result.add(Data);
		}

		return result;

	}
}
