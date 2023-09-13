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
 *	PostgradStudent is a subclass of Students representing a student that 
 *  have graduated and continued to study further
 *
 * @attributes
 * 	id			Integer		int
 * 	name		String
 * 	phoneNumber String
 *  address		String
 *  gpa			Float		float
 *  
 * @object
 *   A typical PostgradStudent is c = (i,n,p,a,g) where id(i), name(n), phoneNumber(p), address(a), gpa(g)
 * 
 * @abstract_properties
 * 	P_Student /\
 *  mutable(id) = false /\ optional(id) = false /\ min(id) = 10^8 + 1 /\ max(id) = 10^9 /\
 *  mutable(gpa) = true /\ optional(gpa) = false /\ min(gpa) = 0.0 /\ max(gpa) = 4.0
 *  
 *  @author Vũ Quỳnh Anh BI12-019
 * */

public class PostgradStudent extends Student {
	//constants
			private static final int MIN_ID = (int) 1e8+1;
			private static final int MAX_ID = (int) 1e9;
			private static final float MIN_GPA = 0.0f;
			private static final float MAX_GPA = 4.0f;

			/**OBJECT REPRESENTATION *
			 * 	- field declaration
			 * 	- domain constraints (based on @abstract_properties)
			 */
			@DomainConstraint(mutable=true,optional=false,min=MIN_GPA,max=MAX_GPA)
			private float gpa;
			
			/**OPERATION SPECIFICATION
			 * 	type: constructor, mutator, observer,default,helper
			 *  
			 * */
			
			//constructor
			/**
			 * @effects (post-conditions)
			 * if i,n,p,a,g are valid
			 * 		initialise this as Student(id=i,name=n,phoneNumber=p,address=a,gpa=g)
			 * else
			 * 		throw new NotPossibleException
			 * */
		
		public PostgradStudent(
				@AttrRef("id") 
				int i,
				@AttrRef("name")
				String n,
				@AttrRef("phoneNumber") 
				String p,
				@AttrRef("address")
				String a,
				@AttrRef("gpa")
				float g) {
			super(i,n,p,a);
			if (validateGPA(g)) {
				this.gpa = g;
			} else {
				throw new NotPossibleException("Invalid GPA input" + g);
			}
		}
		
		//mutator
		/**
		 * this is the mutator for gpa
		 * @effects
		 * if gpa is valid
		 * 		set this.gpa = gpa
		 * 		return true
		 * else
		 * 		return false
		 * */
		@DOpt(type=OptType.Mutator) @AttrRef("gpa")
		public boolean setGPA(float gpa) {
			if(validateGPA(gpa)) {
				this.gpa = gpa;
				return true;
			}
			return false;
		}
		
		//observer
		/**
		 * this is the observer for gpa
		 * @effects
		 * 	return this.gpa = gpa
		 * */
		@DOpt(type=OptType.Observer) @AttrRef("gpa")
		public float getGPA() {
			return gpa;
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
		
			/**
			 * validate gpa against domain constraint.
			 * 
			 * @effects
			 * 	if gpa is valid
			 * 		return true
			 * 	else
			 * 		return false
			 * */
		private boolean validateGPA(float gpa) {
			return gpa >= MIN_GPA && gpa <= MAX_GPA;
		}
		
		@Override
		public String toString() {
			//PostgradStudent is (id,name,phoneNumber,address,gpa)
			StringBuilder sb = new StringBuilder("PostgradStudent(");
			sb.append(getID())
			  .append(",")
			  .append(getName())
			  .append(",")
			  .append(getPhone())
			  .append(",")
			  .append(getAddress())
			  .append(",")
			  .append(getGPA())
			  .append(")");
			return sb.toString();
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
}
