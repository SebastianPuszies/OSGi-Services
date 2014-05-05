package de.leuphana.cosu.printingsystemosgi;


public class Printer {
	private String ipAddress;
	private PrinterType printerType;

	public Printer() {
		this.printerType = PrinterType.BLACK_WHITE;
	}

	public void executePrintJob(PrintJob printJob) {
		printJob.setPrintJobState(PrintAction.DISPATCH);
		
		if (printJob.getDocument().getNumberOfPages() <= 5) {
			printJob.setPrintJobState(PrintAction.EXECUTE);
			System.out.println(printJob.getDocument().getTitle());
		} else {
			printJob.setPrintJobState(PrintAction.HOLD);
		}
		
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public PrinterType getPrinterType() {
		return printerType;
	}

	public void setPrinterType(PrinterType printerType) {
		this.printerType = printerType;
	}

}