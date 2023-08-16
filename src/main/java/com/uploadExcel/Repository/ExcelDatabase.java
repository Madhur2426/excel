package com.uploadExcel.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uploadExcel.Entity.ExcelTable;

public interface ExcelDatabase extends JpaRepository<ExcelTable,String>{
	
}