package com.monika.reporting.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.monika.jba.entity.Item;

/**
 * @author Rohit
 *
 */
public class ItemListExcelView extends AbstractXlsView {

	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractXlsView#buildExcelDocument(java.util.Map, org.apache.poi.ss.usermodel.Workbook, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HSSFSheet excelSheet = (HSSFSheet) workbook.createSheet("Item List");
		setExcelHeader(excelSheet);

		List<Item> itemList = (List<Item>) model.get("itemList");
		setExcelRows(excelSheet, itemList);

	}

	/**
	 * @param excelSheet
	 */
	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Blog Name");
		excelHeader.createCell(1).setCellValue("Title");
		excelHeader.createCell(2).setCellValue("Published Date");
		excelHeader.createCell(3).setCellValue("Description");
	}

	/**
	 * @param excelSheet
	 * @param itemList
	 */
	public void setExcelRows(HSSFSheet excelSheet, List<Item> itemList) {
		int record = 1;
		for (Item item : itemList) {
			HSSFRow excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(item.getBlog().getName());
			excelRow.createCell(1).setCellValue(item.getTitle());
			excelRow.createCell(2).setCellValue(item.getPublishedDate());
			excelRow.createCell(3).setCellValue(item.getDescription());
		}
	}

}
