package a2_BI12_019.studentman;
import utils.DomainConstraint;
import utils.AttrRef;

/**
 * Header specification
 *	
 * @overview
 *	UndergradStudent is a subclass of Students representing a student have not
 *  graduated.
 *
 * @attributes
 * 	id			Integer		int
 * 	name		String
 * 	phoneNumber String
 *  address		String		
 *  
 * @object
 *   A typical Student is c = (i,n,p,a) where id(i), name(n), phoneNumber(p), address(a)
 * 
 * @abstract_properties
 * P_Student /\	
 * mutable(id) = false /\ optional(id) = false /\ min(id) = 10^5 /\ max(id) = 10^8
 *  
 *  @author Vũ Quỳnh Anh BI12-019
 * */

public class UndergradStudent extends Student {
	//constants
		private static final int MIN_ID = (int) 1e5;
		private static final int MAX_ID = (int) 1e8;

		/**OBJECT REPRESENTATION *
		 * 	- field declaration
		 * 	- domain constraints (based on @abstract_properties)
		 */
		/**OPERATION SPECIFICATION
		 * 	type: constructor, helper
		 *  
		 * */
		
		//constructor
		/**
		 * @effects (post-conditions)
		 * if i,n,p,a are valid
		 * 		initialise this as Student(id=i,name=n,phoneNumber=p,address=a)
		 * else
		 * 		throw new NotPossibleException
		 * */
	
	public UndergradStudent(
			@AttrRef("id") 
			int i,
			@AttrRef("name")
			String n,
			@AttrRef("phoneNumber") 
			String p,
			@AttrRef("address")
			String a) {
		super(i,n,p,a);
	}
	
	@Override
	public String toString() {
		//UndergradStudent is (id,name,phoneNumber,address)
		StringBuilder sb = new StringBuilder("UndergradStudent(");
		sb.append(getID())
		  .append(",")
		  .append(getName())
		  .append(",")
		  .append(getPhone())
		  .append(",")
		  .append(getAddress())
		  .append(")");
		return sb.toString();
	}
	
	//helper
	//validation methods
	/**
	* validate id against domain constraint.
	* 
	* @effects
	* 	if id is valid
	* 		return true
	* 	else
	* 		return false
	* */
	@Override
	@DomainConstraint(mutable=false,optional=false,min=MIN_ID,max=MAX_ID)
	protected boolean validateID(int id) {
		if (!(super.validateID(id)))
			return false;

		if (id >= MIN_ID && id <= MAX_ID)
			return true;
		else
			return false;
	}
	
	// implements: Comparable
	  /**
	   * @effects <pre>return super.compareByName(o)</pre> 
	   */
	@Override
	public int compareTo(Object o) 
			throws NullPointerException, ClassCastException {
	    // compare two car objects by name
		return super.compareTo(o);
	  }
	
	@Override
	/**
	 * string contain text of html document
	 * @effects <pre>
	 * 	StringBuilder html
	 * return html <pre>
	 * */
	public String toHtmlDoc() {
		// TODO Auto-generated method stub
		StringBuilder html = new StringBuilder();
		html.append("<html> \n")
		  .append("<head><title>Student:"+getID()+"-"+getName()+"</title></head> \n")
		  .append("<body> \n")
		  .append(getID() + " " + getName() + " " + getPhone() + " " + getAddress() + "\n")
		  .append("</body></html>");
		return html.toString();
	}
}
