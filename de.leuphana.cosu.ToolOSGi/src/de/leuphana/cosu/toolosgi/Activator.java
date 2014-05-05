package de.leuphana.cosu.toolosgi;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import de.leuphana.cosu.toolosgi.Tool;

public class Activator implements BundleActivator {

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		System.out.println("Hello Tool!!");
	    //context.registerService(Tool.class.getName(), new Tool(), null);		   
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		System.out.println("Goodbye Tool!!");
	}

}
