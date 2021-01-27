package xyz.foobar;

import java.util.List;
import java.util.Objects;

public class DiffRendererImpl implements DiffRenderer {

	public String render(Diff<?> diff) throws DiffException {

	      Objects.requireNonNull(diff);

	        Class<?> myClass;
	        
	        myClass = (Objects.nonNull(diff.getPlaceHolder()))?diff.getPlaceHolder().getClass():null;
	        
	        List<DifferencesClass> diffClasses = diff.getDifferencesClasses();
	        
	        StringBuilder buildStr = new StringBuilder();
	        
        
	        for (DifferencesClass diffClass : diffClasses) {
	        	
	            makeSpace(buildStr, diffClass.getLength());
	            
	            if(Objects.isNull(myClass)){
	                buildStr.append(diffClass.getStatus()).append(":").append(diffClass.getFieldName());
	            }
	            else if (diffClass.getFieldName().equals(myClass.getSimpleName()) && diffClass.isParentClass()) {
	                buildStr.append(diffClass.getStatus()).append(":").append(myClass.getSimpleName());
	                buildStr.append(System.getProperty("line.separator"));
	            } else {
	                try {
	                    if(diffClass.getObjType().equals(myClass.getSimpleName()) && diffClass.isParentClass()){
	                        buildStr.append(diffClass.getStatus())
	                                .append(":")
	                                .append((diffClass.getFieldName()));
	                        buildStr.append(System.getProperty("line.separator"));

	                    }
	              	                    
	                else if(diffClass.getStatus().equals(StatusEnum.UPDATE)){
	                        buildStr.append(diffClass.getStatus()).append(":").append((diffClass.getFieldName()))
	                                .append(" from ")
	                                .append(diffClass.getOldValue())
	                                .append(" to ")
	                                .append(diffClass.getObjVal());
	                        buildStr.append(System.getProperty("line.separator"));
	                    }
	                else if (diffClass.getStatus().equals(StatusEnum.DELETE) ){
	                        buildStr.append(diffClass.getStatus())
	                                .append(":")
	                                .append((diffClass.getFieldName()));
	                        buildStr.append(System.getProperty("line.separator"));
	                }else {
	                        buildStr.append(diffClass.getStatus())
	                                .append(":")
	                                .append((diffClass.getFieldName()))
	                                .append(" as ")
	                                .append(diffClass.getObjVal());
	                        buildStr.append(System.getProperty("line.separator"));
	                    }

	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }

	        }

	        return buildStr.toString();
	    }

	    private static void makeSpace(StringBuilder builder, int length) {
	        for (int j = 0; j < length; j++) {
	            builder.append(" ");
	        }
	    }



}
