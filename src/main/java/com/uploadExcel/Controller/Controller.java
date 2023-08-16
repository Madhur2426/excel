package com.uploadExcel.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uploadExcel.Entity.ExcelTable;
import com.uploadExcel.Service.UploadImplementation;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class Controller {
	@Autowired
	UploadImplementation upload;
@PostMapping("/upload")
public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	{
		return this.upload.handleFileUpload(file);
	}
}
	@GetMapping("/getData")
	    public List<ExcelTable> getAllData() {
	        return this.upload.getAllData();
	    }
}
