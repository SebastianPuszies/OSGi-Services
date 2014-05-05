package de.leuphana.cosu.componentservicebusosgi;

import java.util.Observable;
import java.util.Observer;

import org.rribbit.RequestResponseBus;
import org.rribbit.creation.ListenerObjectCreator;
import org.rribbit.creation.ObjectBasedListenerObjectCreator;
import org.rribbit.util.RRiBbitUtil;

import org.osgi.framework.ServiceReference;

import de.leuphana.cosu.messagingosgi.domain.Content;
import de.leuphana.cosu.messagingosgi.process.MessagingSystem;
import de.leuphana.cosu.printingsystemosgi.Document;
import de.leuphana.cosu.printingsystemosgi.PrintingSystem;
import de.leuphana.cosu.statistic.PrintedDocument;
import de.leuphana.cosu.statistic.StatisticsSystem;

//import de.leuphana.cosa.statistic.PrintedDocument;
//import de.leuphana.cosa.statistic.StatisticsSystem;
//import de.leuphana.cosu.messagingosgi.domain.Content;
import de.leuphana.cosu.messagingosgi.domain.message.Message;
import de.leuphana.cosu.messagingosgi.domain.messagechannel.MessageChannelType;

public class ComponentServiceBus {

	private ComponentServiceBus componentServiceBus;
	private RequestResponseBus requestResponseBus;

	private PrintingSystem printingSystem;
	private MessagingSystem messagingSystem;
	//private  StatisticsSystem statisticsSystem;

	public ComponentServiceBus(PrintingSystem printingSystem, MessagingSystem messagingSystem){//, StatisticsSystem statisticsSystem) {

		this.printingSystem = printingSystem;
		this.messagingSystem = messagingSystem;
//		this.statisticsSystem = statisticsSystem;

		ListenerObjectCreator listenerObjectCreator = new ObjectBasedListenerObjectCreator(
				messagingSystem);//, statisticsSystem);
		requestResponseBus = RRiBbitUtil.createRequestResponseBusForLocalUse(
				listenerObjectCreator, true);
	}

	//STATIC
	public  ComponentServiceBus start(PrintingSystem printingSystem,  
			MessagingSystem messagingSystem){// , StatisticsSystem statisticsSystem) {
		if (componentServiceBus == null) {
			componentServiceBus = new ComponentServiceBus(printingSystem, messagingSystem);//, statisticsSystem);
			componentServiceBus.listenToPrintingSystem();
		}
		return componentServiceBus;
	}

	private void listenToPrintingSystem() {

		// PrintingSystem
		// ============================
		// PrintingSystem zum Observer/Listener machen
		// ComponentServiceBus als Observer/Listener registrieren
		printingSystem.addObserver(new Observer() {

			@Override
			public void update(Observable observable, Object object) {
				if (object instanceof Document) {
					Document document = (Document) object;

					// MessagingSystem
					// ============================
					// Document in Message umwandeln
					// Message an MessagingSystem schicken
					notifyMessagingSystem(document);

					// StatisticSystem
					// ============================
					// Document in PrintedDocument umwandeln
					// PrintedDocument an StatisticSystem schicken
					notifyStatisticsSystem(document);
				}
			}
		});
	}

	private void notifyStatisticsSystem(Document document) {
		// Transformation Document in PrintedDocument
		PrintedDocument printedDocument = new PrintedDocument();
		printedDocument.setPrintDate(document.getPrintDate());
		printedDocument.setPrinter(document.getPrinter());

		// Benachrichtung StatisticsSystem
		// statisticsSystem.refresh(printedDocument);
		requestResponseBus.send("refresh", printedDocument);
	}

	private void notifyMessagingSystem(Document document) {
		// Transformation Document in Message
		Message message = messagingSystem.createMessage("slotos@leuphana.de",
				"funk@leuphana.de", "Printed document " + document.getTitle(),
				new Content(document.getTitle()), MessageChannelType.SMTP);

		// Benachrichtung MessagingSystem
		// messagingSystem.sendMessage(message);
		requestResponseBus.send("sendMessage", message);
	}
}