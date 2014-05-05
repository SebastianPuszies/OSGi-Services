package de.leuphana.cosu.statistic;

import java.util.EventListener;

public interface PrintedDocumentListener extends EventListener {
	void onNewPrintedDocument(PrintedDocument printedDocument);
}