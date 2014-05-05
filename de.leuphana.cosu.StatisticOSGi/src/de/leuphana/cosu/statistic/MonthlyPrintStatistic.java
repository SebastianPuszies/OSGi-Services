package de.leuphana.cosu.statistic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Slotos-Admin
 * @version 1.0
 * @created 23-Nov-2013 10:57:06
 */
public class MonthlyPrintStatistic implements PrintStatistic,
		PrintedDocumentListener {

	private Collection<PrintedDocument> printedDocuments;

	public MonthlyPrintStatistic() {
		printedDocuments = new ArrayList<PrintedDocument>();
	}

	public Collection<PrintedDocument> getPrintedDocuments() {
		return printedDocuments;
	}

	@Override
	public void onNewPrintedDocument(PrintedDocument printedDocument) {
		printedDocuments.add(printedDocument);
		
		System.out.println("MonthlyPrintStatistic");
		System.out.println(new SimpleDateFormat("MM").format(printedDocument
				.getPrintDate()));
	}
}