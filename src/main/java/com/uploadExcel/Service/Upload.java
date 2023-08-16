package com.uploadExcel.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uploadExcel.Entity.ExcelTable;

public interface Upload {
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file);
	public List<ExcelTable> getAllData();
}
