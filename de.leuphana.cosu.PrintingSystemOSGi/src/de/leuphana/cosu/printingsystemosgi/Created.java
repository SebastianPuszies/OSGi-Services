package de.leuphana.cosu.printingsystemosgi;

public class Created implements PrintJobState {

	@Override
	public PrintJobState changePrintJobState(PrintAction printAction) {
		// Interface (Was?) (1x)
		// Klassen (Wie? (nx)
		
		PrintJobState printJobState = this;
		
		switch (printAction) {
		case QUEUE:
			System.out.println(printAction);
			printJobState = new Queued();
		}
		
		return printJobState;
	}

}