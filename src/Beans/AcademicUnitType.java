package Beans;

public enum AcademicUnitType {

	   PROGRAMME("Programme"),
	    FACULTY("Faculty"),
	    DEPARTMENT("Department");
	    
	    private final String value;
	    
	    private AcademicUnitType(String value) {
	        this.value = value;
	    }
	    
	    public String getValue() {
	        return value;
	    }
}
