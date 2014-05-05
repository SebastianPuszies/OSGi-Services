package de.leuphana.cosu.printingsystemosgi;
import java.util.HashMap;
import java.util.Map;




public class PrintJobDispatcher {
	private static PrintJobDispatcher printJobDispatcher;
	private Map<PrinterType, Printer> printerMap;
	private PrintJobQueue printJobQueue;
	private PrintJob currentPrintJob;
	
	private PrintJobDispatcher() {
		printerMap = new HashMap<PrinterType, Printer>();
	}

	public synchronized static PrintJobDispatcher getInstance() {
		if (printJobDispatcher == null) {
			printJobDispatcher = new PrintJobDispatcher();
		}

		return printJobDispatcher;
	}

	public void addPrintJobQueue(PrintJobQueue printJobQueue) {
		this.printJobQueue = printJobQueue;
	}

	public void addPrinter(Printer printer) {
		printerMap.put(printer.getPrinterType(), printer);
	}

	public Printer getPrinterForPrintJob(PrintJob printJob) {
		// Logik um Printer zu ermitteln
		// - nach Ort
		// - nach Farbe
		// - verfügbar
		Printer printer = null;
		
		switch (printJob.getPrinterType()) {
		case COLOR:
			printer = printerMap.get(PrinterType.COLOR);
			break;
		}
		
		return printer;
	}

	public PrintJob getNextPrintJob() {
		return printJobQueue.getNextPrintJob();
	}

}