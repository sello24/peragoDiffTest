package xyz.foobar;

import java.io.Serializable;
import java.util.Objects;

/**
 * The object representing a diff.
 * Implement this class as you see fit. 
 *
 */

public class DifferencesClass implements Serializable{
	
    public StatusEnum getStatusEnum() {
		return statusEnum;
	}

	public void setStatusEnum(StatusEnum statusEnum) {
		this.statusEnum = statusEnum;
	}

	public Object getObjVal() {
		return objVal;
	}

	public void setObjVal(Object objVal) {
		this.objVal = objVal;
	}

	public boolean isParentClass() {
		return isParentClass;
	}

	public void setParentClass(boolean isParentClass) {
		this.isParentClass = isParentClass;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setOldValue(Object oldValue) {
		this.oldValue = oldValue;
	}

	private StatusEnum statusEnum;
    private String fieldName;
    private Object objVal;
    private boolean isParentClass;
    private int length;
    private String objType ="";
    private Object oldValue;

    public DifferencesClass(StatusEnum statusEnum,  String fieldName, String objType,Object oldValue, Object objVal,int length, boolean isParentClass){
        
    	this.statusEnum=statusEnum;
        this.fieldName = getSimpleName(fieldName);
        this.isParentClass=isParentClass;
        this.length =length;
        this.objVal =objVal;
        this.objType=objType;
        this.oldValue=oldValue;


    }

    public DifferencesClass(StatusEnum statusEnum,  String fieldName, String objType, int length ,  boolean isParentClass) {
        this.statusEnum=statusEnum;
        this.fieldName = getSimpleName(fieldName);
        this.isParentClass=isParentClass;
        this.length =length;
        this.objType=objType;
    }

  
    private static String getSimpleName(String fieldName){
        Objects.requireNonNull(fieldName);
        return fieldName.substring(fieldName.lastIndexOf(".")+1, fieldName.length());
    }

 
    public StatusEnum getStatus() {
        return statusEnum;
    }

    public String getFieldName() {
        return fieldName;
    }

 
    public Object getOldValue() {
        return oldValue;
    }

    @Override
    public String toString() {
        return "DifferencesClass{" +
                "statusEnum=" + statusEnum +
                ", fieldName='" + fieldName + '\'' +
                ", parent=" + isParentClass +
                '}';
    }
}


