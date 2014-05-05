package de.leuphana.cosu.printingsystemosgi;

import de.leuphana.cosu.toolosgi.Tool;

public class PrintingSystem extends Tool {

	private static PrintingSystem printingSystem;
	
	private PrintJobDispatcher printJobDispatcher;
	private PrintJobQueue printJobQueue;

	public PrintingSystem() {
		Printer printer = new Printer();
		printer.setPrinterType(PrinterType.COLOR);

		printJobQueue = new PrintJobQueue();
		printJobDispatcher = PrintJobDispatcher.getInstance();
		printJobDispatcher.addPrinter(printer);
		printJobDispatcher.addPrintJobQueue(printJobQueue);
	}

	public boolean printDocument(Document document) {
		PrintJob printJob = new PrintJob(document);
		printJob.setPrinterType(PrinterType.COLOR);

		printJobQueue.addPrintJob(printJob);

		printJob = printJobDispatcher.getNextPrintJob();

		Printer printer = printJobDispatcher.getPrinterForPrintJob(printJob);

		printer.executePrintJob(printJob);
		
		// NotifyObserver
		setChanged();
		notifyObservers(printJob.getDocument());

		return true;
	}

	public static synchronized PrintingSystem createInstance() {
		if(printingSystem == null) {
			printingSystem = new PrintingSystem();
		}
		
		return printingSystem;
	}

	@Override
	public void setName() {
		super.name = "PrintingSystem";
	}

}