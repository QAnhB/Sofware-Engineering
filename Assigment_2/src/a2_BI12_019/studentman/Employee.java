package a2_BI12_019.studentman;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview
 * @attributes
 * 		fullName    String
 * @object
 * 		A typical Employee is e = <n> where fulName(n)
 * @abstract_properties
 * 		mutable(fullName) = true /\ optional(fullName) = false /\ lenght = 50
 * @author Admin
 *
 */

public class Employee {
	private static final int LEN_NAME = 50;
	
	@DomainConstraint(type = "String", mutable = true, optional = false, length = LEN_NAME)
	private String fullName;
	
	//Constructor
	/**
	 * @effects
	 * 	if n is valid
	 * 		initialise this as Employee(fullName = n)
	 *	else
	 *		throws NotPossibleException
	 * @param n
	 * @throws NotPossibleException
	 */
	public Employee(@AttrRef("fullName") String n) throws NotPossibleException {
		if(!validateName(n))
			throw new NotPossibleException("Invalid name: " + n);
		else
			this.fullName = n;
	}
	
	//mutator
	/**
	 * this is the mutator for fullName
	 * @effects
	 * 	if n is valid
	 * 		set this.fullName = n
	 * 		return true
	 * 	else
	 * 		return false
	 */
	@DOpt(type = OptType.Mutator) @AttrRef("fullName")
	public boolean setFullName(String n) {
		if (validateName(n)) {
			this.fullName = n;
			return true;
		}
		else
			return false;
	}
	
	//observer
	/**
	 * this is the observer for fullName
	 * @effects
	 * 		return this.fullName = fullName
	 */
	
	@DOpt(type = OptType.Observer) @AttrRef("fullName")
	public String getFullName() {
		return this.fullName;
	}
	
	//helper
	/**
	 * validate fullName against domain constraints
	 * @effects
	 * 	if fullName is valid
	 * 		return true
	 * 	else
	 * 		return false
	 */
	
	private boolean validateName(String fullName) {
		if (fullName == null || fullName.length() == 0)
			return false;
		return fullName.length() <= LEN_NAME;
	}
	
	/**
	 * Extract the first name from fullName
	 * @effects
	 * 	split n into substrings in an array nameParts
	 * 	assign the last element of nameParts to firstName
	 * 	return firstName
	 */
	public String extractName(String n) {
		String[] nameParts = n.split(" ");
		String firstName = nameParts[-1];
		return firstName;
	}
	
	//default
	@Override
	public String toString() {
		//Employee is Employee(fullName)
		StringBuilder sb = new StringBuilder("Employe(");
		sb.append(fullName)
			.append(")");
		return sb.toString();
	}
	
}
