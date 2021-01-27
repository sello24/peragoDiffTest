package xyz.foobar;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import xyz.foobar.StatusEnum;


/**
 * The object representing a diff.
 * Implement this class as you see fit. 
 *
 */
public class Diff<T extends Serializable> {

	   public T getPlaceHolder() {
		return placeHolder;
	}




	public void setPlaceHolder(T placeHolder) {
		this.placeHolder = placeHolder;
	}




	public List<DifferencesClass> getDifferencesClasses() {
		return differencesClasses;
	}




	public void setDifferencesClasses(List<DifferencesClass> differencesClasses) {
		this.differencesClasses = differencesClasses;
	}




	private T placeHolder;
	   private List<DifferencesClass> differencesClasses = new LinkedList<DifferencesClass>();


	    public void addLog(DifferencesClass differencesClass){
	    	differencesClasses.add(differencesClass);
	    }

	 
	
	
	    @Override
	    public String toString() {
	        return "Diff{" +
	                "holder=" + placeHolder +
	                ", differences" + differencesClasses +
	                '}';
	    }
}
