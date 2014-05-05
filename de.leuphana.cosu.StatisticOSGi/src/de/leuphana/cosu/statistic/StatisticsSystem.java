package de.leuphana.cosu.statistic;

import java.util.HashSet;
import java.util.Set;

import org.rribbit.Listener;

import de.leuphana.cosu.toolosgi.Tool;

public class StatisticsSystem extends de.leuphana.cosu.toolosgi.Tool {
	private static StatisticsSystem statisticsSystem;

	private Set<PrintedDocumentListener> printedDocumentListeners;

	public StatisticsSystem() {
		this.setName();

		printedDocumentListeners = new HashSet<PrintedDocumentListener>();

		// normalerweise in XML-Konfigurationsdatei angegeben
		printedDocumentListeners.add(new DailyPrintStatistic());
		printedDocumentListeners.add(new MonthlyPrintStatistic());
	}

	public static Tool createInstance() {
		if (statisticsSystem == null) {
			statisticsSystem = new StatisticsSystem();
		}

		return statisticsSystem;
	}

	@Override
	public void setName() {
		super.name = "StatisticsSystem";
	}

	@Listener(hint="refresh")
	public void refresh(PrintedDocument printedDocument) {
		for (PrintedDocumentListener printedDocumentListener : printedDocumentListeners) {
			printedDocumentListener.onNewPrintedDocument(printedDocument);
		}

		System.out.println("StatisticsSystem - "
				+ printedDocument.getPrinter());
		
	}
}