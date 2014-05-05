package de.leuphana.cosu.componentservicebusosgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;


//import org.rribbit.RequestResponseBus;

import de.leuphana.cosu.messagingosgi.process.MessagingSystem;
import de.leuphana.cosu.printingsystemosgi.PrintingSystem;
import de.leuphana.cosu.statistic.StatisticsSystem;

public class Activator implements BundleActivator {

   //private static BundleContext context;


	ServiceReference<?> statisticReference;
	ServiceReference<?> printServiceReference;
	ServiceReference<?> messageServiceReference;
	//private RequestResponseBus requestResponseBus;
 	private PrintingSystem printingSystem;
	private MessagingSystem messagingSystem;
	private StatisticsSystem statisticSystem;
	 
	//static BundleContext getContext() {
	//	return context;
	//}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		//Activator.context = bundleContext;
	    System.out.println("Hello ComponentServiceBus!!");
	
	    printServiceReference= context.getServiceReference(PrintingSystem.class.getName());
        PrintingSystem printSys =(PrintingSystem)context.getService(printServiceReference);
        System.out.println("COMPONENT STARTET PRINTINGSYSTEM.....");
        
	    messageServiceReference= context.getServiceReference(MessagingSystem.class.getName());
	    MessagingSystem messageSys =(MessagingSystem)context.getService(messageServiceReference);
        System.out.println("COMPONENT STARTET MESSAGINGSYSTEM.....");
	
	   // statisticReference= context.getServiceReference(StatisticsSystem.class.getName());
	   // StatisticsSystem statisticSys =(StatisticsSystem)context.getService(statisticReference);
        context.registerService(ComponentServiceBus.class.getName(), new ComponentServiceBus(printingSystem, messagingSystem), null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		//Activator.context = null;
	    System.out.println("Goodbye ComponentServiceBus!!");
        context.ungetService(printServiceReference);
        context.ungetService(messageServiceReference);
	}

}