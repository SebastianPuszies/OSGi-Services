package de.leuphana.cosu.printingsystemosgi;
import java.util.PriorityQueue;
import java.util.Queue;





public class PrintJobQueue {
	private Queue<PrintJob> printJobQueue;
	
	public PrintJobQueue() {
		printJobQueue = new PriorityQueue<PrintJob>();
	}

	public void addPrintJob(PrintJob printJob) {
		printJobQueue.add(printJob);
		printJob.setPrintJobState(PrintAction.QUEUE);
	}

	public PrintJob getNextPrintJob() {
		return printJobQueue.poll();
	}

}