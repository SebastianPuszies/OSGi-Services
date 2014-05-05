package de.leuphana.cosu.printingsystemosgi;

public class Queued implements PrintJobState {

	@Override
	public PrintJobState changePrintJobState(PrintAction printAction) {
		PrintJobState printJobState = this;

		switch (printAction) {
		case DISPATCH:
			printJobState = new Dispatched();
			System.out.println(printAction);
		}

		return printJobState;
	}

}