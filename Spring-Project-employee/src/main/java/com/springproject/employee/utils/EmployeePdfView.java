package com.springproject.employee.utils;

import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springproject.employee.model.Employee;


public class EmployeePdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfMetadata(
			Map<String, Object> model, 
			Document document, HttpServletRequest request)
	{
		HeaderFooter header = new HeaderFooter(new Phrase("EMPLOYEE PDF VIEW"), false);
		header.setAlignment(Element.ALIGN_CENTER);
		document.setHeader(header);
		
		HeaderFooter footer = new HeaderFooter(new Phrase(new Date()+" (C) bway, Page # "), true);
		footer.setAlignment(Element.ALIGN_CENTER);
		document.setFooter(footer);
	}

	@Override
	protected void buildPdfDocument(
			Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		//download PDF with a given filename
		response.addHeader("Content-Disposition", "attachment;filename=employee.pdf");

		//read data from controller
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("list");
		
		//create element
		//Font (Family, Size, Style, Color)
		Font titleFont = new Font(Font.TIMES_ROMAN, 30, Font.BOLD, Color.RED);
		Paragraph title = new Paragraph("EMPLOYEE DATA",titleFont);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(20.0f);
		title.setSpacingAfter(25.0f);
		//add to document
		document.add(title);
		
		Font tableHead = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, Color.BLUE);
		PdfPTable table = new PdfPTable(5);// no.of columns
		table.addCell(new Phrase("ID",tableHead));
		table.addCell(new Phrase("FIRSTNAME",tableHead));
		table.addCell(new Phrase("LASTNAME",tableHead));
		table.addCell(new Phrase("COMPANY",tableHead));
		table.addCell(new Phrase("SALARY",tableHead));
		
		for(Employee spec : list ) {
			table.addCell(String.valueOf(spec.getId()));
			table.addCell(spec.getFname());
			table.addCell(spec.getLname());
			table.addCell(spec.getCompany());
			table.addCell(String.valueOf(spec.getSalary()));
		}
		//add to document
		document.add(table);
	}
}
