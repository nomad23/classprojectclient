
public class clientProtocol {
	private boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}

	public boolean receiveNumber(String studentNumber){	
		
		if(this.isInteger(studentNumber)){
			return true;
			}
		else{
			return false;	
		}			
	}
	
	public boolean receiveName(String studentName){
		//StringUtils.isAlphanumeric(studentName);
		String s =studentName;
		boolean hasNonAlpha = s.matches("^.*[^a-zA-Z ].*$");
		if(hasNonAlpha){
			return false;
		}
		else{
			return true;
		}
		
	}
	
	
}
