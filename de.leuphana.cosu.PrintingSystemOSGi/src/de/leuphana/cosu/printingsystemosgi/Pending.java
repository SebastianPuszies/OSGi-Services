package de.leuphana.cosu.printingsystemosgi;

public class Pending implements PrintJobState {

	@Override
	public PrintJobState changePrintJobState(PrintAction printAction) {
		PrintJobState printJobState = this;

		switch (printAction) {
		case EXECUTE:
			printJobState = new Executed();
			System.out.println(printAction);
		}

		return printJobState;
	}

}