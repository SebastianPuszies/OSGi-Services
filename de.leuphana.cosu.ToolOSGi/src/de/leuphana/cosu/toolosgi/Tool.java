package de.leuphana.cosu.toolosgi;

import java.util.Observable;

public abstract class Tool extends Observable {
	protected String name;
	
	public Tool(){}
	
	public String getName() {
		return name;
	}
	
	public abstract void setName();
}