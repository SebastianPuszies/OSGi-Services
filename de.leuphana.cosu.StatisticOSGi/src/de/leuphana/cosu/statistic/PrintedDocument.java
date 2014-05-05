package de.leuphana.cosu.statistic;

import java.util.Date;

/**
 * @author Slotos-Admin
 * @version 1.0
 * @created 23-Nov-2013 10:57:06
 */
public class PrintedDocument {

	private String printer;
	private Date printDate;

	public PrintedDocument() {

	}

	public String getPrinter() {
		return printer;
	}

	public void setPrinter(String printer) {
		this.printer = printer;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

}