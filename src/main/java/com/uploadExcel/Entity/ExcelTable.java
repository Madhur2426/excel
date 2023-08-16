package com.uploadExcel.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ExcelTable {
    @Id
    String id;
	@Column
	String Column1;
    String Column2;
	@Override
	public String toString() {
		return "ExcelTable [id=" + id + ", Column1=" + Column1 + ", Column2=" + Column2 + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id2) {
		this.id = id2;
	}
	public String getColumn1() {
		return Column1;
	}
	public void setColumn1(String column12) {
		Column1 = column12;
	}
	public String getColumn2() {
		return Column2;
	}
	public void setColumn2(String column22) {
		Column2 = column22;
	}
	public ExcelTable(String id, String column1, String column2) {
		super();
		this.id = id;
		Column1 = column1;
		Column2 = column2;
	}
	public ExcelTable() {
		super();
		// TODO Auto-generated constructor stub
	}

}
