package de.leuphana.cosu.workbench;

import java.util.Map;
import java.util.TreeMap;

import org.osgi.framework.ServiceReference;

import de.leuphana.cosu.componentservicebusosgi.ComponentServiceBus;
import de.leuphana.cosu.messagingosgi.process.MessagingSystem;
import de.leuphana.cosu.printingsystemosgi.Document;
import de.leuphana.cosu.printingsystemosgi.PrintingSystem;
import de.leuphana.cosu.statistic.StatisticsSystem;
import de.leuphana.cosu.toolosgi.Tool;
import de.leuphana.cosu.toolosgi.ToolTypes;



public class Workbench {
	private Map<ToolTypes, Tool> workbenchTools;

	ServiceReference<?> messageServiceReference;

	public Workbench() {
		workbenchTools = new TreeMap<ToolTypes, Tool>();
	}

	public boolean printDocument(Document document) {
		PrintingSystem printingSystem = (PrintingSystem) workbenchTools
				.get(ToolTypes.PRINTING);

		MessagingSystem messagingSystem = (MessagingSystem) workbenchTools
				.get(ToolTypes.MESSAGING);
		
		StatisticsSystem statisticsSystem = (StatisticsSystem) workbenchTools
				.get(ToolTypes.STATISTICS);
		
		  //printServiceReference= context.getServiceReference(PrintingSystem.class.getName());
        //PrintingSystem printSys =(PrintingSystem)context.getService(printServiceReference);
        System.out.println("COMPONENT STARTET PRINTINGSYSTEM.....");
        
		ComponentServiceBus.start(printingSystem, messagingSystem);//, statisticsSystem);
		

		return printingSystem.printDocument(document);
	}

	public void addTool(ToolTypes toolTypes, Tool tool) {
		workbenchTools.put(toolTypes, tool);
	}

}