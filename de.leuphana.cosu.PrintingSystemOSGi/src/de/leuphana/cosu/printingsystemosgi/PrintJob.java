package de.leuphana.cosu.printingsystemosgi;



public class PrintJob {
	private PrinterType printerType;
	private Document document;
	private PrintJobState printJobState;

	public PrintJob(Document document) {
		printerType = PrinterType.BLACK_WHITE;
		this.document = document;

		printJobState = new Created();
		System.out.println(PrintAction.CREATE);
	}

	public PrinterType getPrinterType() {
		return printerType;
	}

	public void setPrinterType(PrinterType printerType) {
		this.printerType = printerType;
	}

	public Document getDocument() {
		return document;
	}

	public void setPrintJobState(PrintAction printAction) {
		printJobState = printJobState.changePrintJobState(printAction);
	}

}