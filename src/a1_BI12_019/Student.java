package a1_BI12_019;
import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * Header specification
 *	
 * @overview
 *	Student is a person that have not graduated or have graduated but continued to study higher 
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
 * 	mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\ max(id) = 10^9 /\
 *  mutable(name) = true /\ optional(name) = false /\ length(name) = 50 /\
 *  mutable(phoneNumber) = true /\ optional(phoneNumber) = false /\ length(phoneNumber) = 10 /\
 *  mutable(address) = true /\ optional(address) = false /\ lenght(address) = 100
 *  
 *  @author Vũ Quỳnh Anh BI12-019
 * */
public class Student implements Comparable {
	//constants
	private static final int MIN_ID = 1;
	private static final int MAX_ID = (int) 1e9;
	private static final int LEN_NAME = 50;
	private static final int LEN_PHONE = 10;
	private static final int LEN_ADDRESS = 100;

	/**OBJECT REPRESENTATION *
	 * 	- field declaration
	 * 	- domain constraints (based on @abstract_properties)
	 */
	@DomainConstraint(mutable=false,optional=false,min=MIN_ID,max=MAX_ID)
	private int id;
	
	@DomainConstraint(mutable=true,optional=false,length=LEN_NAME)
	private String name;
	
	@DomainConstraint(mutable=true,optional=false,length=LEN_PHONE)
	private String phoneNumber;
	
	@DomainConstraint(mutable=true,optional=false,length=LEN_ADDRESS)
	private String address;
	
	/**OPERATION SPECIFICATION
	 * 	type: constructor, mutator, observer,default,helper
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
	public Student(
			@AttrRef("id") 
			int i,
			@AttrRef("name") 
			String n,
			@AttrRef("phoneNumber") 
			String p,
			@AttrRef("address")
			String a) {
		
		if (validateID(i)) {
			this.id = i;
		} else {
			throw new NotPossibleException("Invalid ID input" + i);
		}
		
		if (validateName(n)) {
			this.name = n;
		} else {
			throw new NotPossibleException("Invalid ID input" + n);
		}
		
		if (validatePhone(p)) {
			this.phoneNumber = p;
		} else {
			throw new NotPossibleException("Invalid ID input" + p);
		}
		
		if (validateAddress(a)) {
			this.address = a;
		} else {
			throw new NotPossibleException("Invalid ID input" + a);
		}
	}
	
	//mutator
	/**
	 * this is the mutator for id
	 * @effects
	 * if id is valid
	 * 		set this.id = id
	 * 		return true
	 * else
	 * 		return false
	 * */
	@DOpt(type=OptType.Mutator) @AttrRef("id")
	public boolean setID(int id) {
		if(validateID(id)) {
			this.id = id;
			return true;
		}
		return false;
	}
	
	/**
	 * this is the mutator for name
	 * @effects
	 * if name is valid
	 * 		set this.name = name
	 * 		return true
	 * else
	 * 		return false
	 * */
	@DOpt(type=OptType.Mutator) @AttrRef("name")
	public boolean setName(String name) {
		if(validateName(name)) {
			this.name = name;
			return true;
		}
		return false;
	}
	
	/**
	 * this is the mutator for phoneNumber
	 * @effects
	 * if phoneNumber is valid
	 * 		set this.phoneNumber = phoneNumber
	 * 		return true
	 * else
	 * 		return false
	 * */
	@DOpt(type=OptType.Mutator) @AttrRef("phoneNumber")
	public boolean setPhone(String phoneNumber) {
		if(validatePhone(phoneNumber)) {
			this.phoneNumber = phoneNumber;
			return true;
		}
		return false;
	}
	
	/**
	 * this is the mutator for address
	 * @effects
	 * if address is valid
	 * 		set this.address = address
	 * 		return true
	 * else
	 * 		return false
	 * */
	@DOpt(type=OptType.Mutator) @AttrRef("address")
	public boolean setID(String address) {
		if(validateAddress(address)) {
			this.address = address;
			return true;
		}
		return false;
	}
	
	//observer
	/**
	 * this is the observer for id
	 * @effects
	 * 	return this.id = id
	 * */
	@DOpt(type=OptType.Observer) @AttrRef("id")
	public int getID() {
		return id;
	}
	
	/**
	 * this is the observer for name
	 * @effects
	 * 	return this.name = name
	 * */
	@DOpt(type=OptType.Observer) @AttrRef("name")
	public String getName() {
		return name;
	}
	
	/**
	 * this is the observer for phoneNumber
	 * @effects
	 * 	return this.phoneNumber = phoneNumber
	 * */
	@DOpt(type=OptType.Observer) @AttrRef("phoneNumber")
	public String getPhone() {
		return phoneNumber;
	}
	
	/**
	 * this is the observer for address
	 * @effects
	 * 	return this.address = address
	 * */
	@DOpt(type=OptType.Observer) @AttrRef("address")
	public String getAddress() {
		return address;
	}
	
	// default
		/**
		 * @effects <pre>
		 *   if this is valid with regards to abstract properties
		 *     return true
		 *   else
		 *     return false</pre>
		 */
		public boolean repOK() {
			return validateID(id) && validateName(name)
					&& validatePhone(phoneNumber) && validateAddress(address);
		}
		
	//default
	@Override
	public String toString() {
		//Student is (id,name,phoneNumber,address)
		StringBuilder sb = new StringBuilder("Student(");
		sb.append(id)
		  .append(",")
		  .append(name)
		  .append(",")
		  .append(phoneNumber)
		  .append(",")
		  .append(address)
		  .append(")");
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o==null||!(o instanceof Student)) {
			return false;
		} else {
			Student other = (Student) o;
			return id == other.getID();
		}
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
	protected boolean validateID(int id) {
		return id >= MIN_ID && id <= MAX_ID;
	}
	
		/**
		 * validate name against domain constraint.
		 * 
		 * @effects
		 * 	if name is valid
		 * 		return true
		 * 	else
		 * 		return false
		 * */
	private boolean validateName(String name) {
		if (name==null || name.length()==0) 
			return false;
		return name.length() <= LEN_NAME;
	}
	
		/**
		 * validate phoneNumber against domain constraint.
		 * 
		 * @effects
		 * 	if phoneNumber is valid
		 * 		return true
		 * 	else
		 * 		return false
		 * */
	private boolean validatePhone(String phoneNumber) {
		if (phoneNumber==null||phoneNumber.length()==0) 
			return false;
		return phoneNumber.length() <= LEN_PHONE;
	}
	
		/**
		 * validate address against domain constraint.
		 * 
		 * @effects
		 * 	if address is valid
		 * 		return true
		 * 	else
		 * 		return false
		 * */
	private boolean validateAddress(String address) {
		if (address==null||address.length()==0) 
			return false;
		return address.length() <= LEN_ADDRESS;
	}

	@Override
	/**
	 * compare two Students by name
	 * @effects
	 * 	if o is null 
	 *       throws NullPointerException 
	 *  else if o is not a Student object
	 *       throws ClassCastException
	 *  else 
	 *      returns this.name.compareTo(o.name)
	 * */
	public int compareTo(Object o) 
		// TODO Auto-generated method stub
		throws NullPointerException, ClassCastException {
		    if (o == null)
		      throw new NullPointerException("Student.compareByName");
		    else if (!(o instanceof Student))
		      throw new ClassCastException("Student.compareByName: not a Vehicle " + o);
		Student other = (Student) o;
		int compare = this.name.compareTo(other.name);
		return compare;
	}
}
