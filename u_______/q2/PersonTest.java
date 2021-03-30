import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########
    //To test the `calcInsurancePrice()` method, which returns void, you can use the `getHealthInsurancePrice()` method, for example:
    //Person p = new Person("XYZ", 10, "XYZ", true, true);
    //assertEquals(0, p.getHealthInsurancePrice().intValue());
	
//	 public Person(String name, Integer age, String occupation, boolean diabetes, boolean heartDisease)
	
	
	//Just checking get functions can be ignored
	Person p = new Person("Saswat", 10, "Student", true, true);
	 @Test(timeout = 1000)
	    public void testPersonName() {

	        assertEquals("Saswat", p.getName());
	       
	        
	    }
	 
	 @Test(timeout = 1000)
	    public void testPersonZ_Age() {

	        assertEquals("10", p.getAge()+"");

	    }
	 
	 @Test(timeout = 1000)
	    public void testPersonOccuation() {

	        assertEquals("Student", p.getOccupation());

	        
	    }
	 
	 @Test(timeout = 1000)
	    public void testPersonDiabetes() {
	        
	  
	        assertEquals(true, p.getDiabetes());
	        
	        
	    }
	 
	 @Test(timeout = 1000)
	    public void testPersonHeart() {
	        
		 assertEquals(true, p.getHeartDisease());
	        
	    }
	 
	
	 
	 
	 //testing health insurance price or  calcInsurancePrice() method of the Person class [15 marks] 
	 //occupation not aviator
	 @Test(timeout = 1000)
	    public void testHealthInsurance1() {
	        
		 assertEquals(340+"", p.getHealthInsurancePrice()+"");
	        
	    }
	 
	 //####
	 //occupation aviator
	 
	 //age<40
	 @Test(timeout = 1000)
	    public void testHealthInsurance2() {
		 Person p1 = new Person("Saswat", 10, "aviator", true, true);
		 assertEquals(200+"", p1.getHealthInsurancePrice()+"");
	        
	    }
	 
	 //age>40
	 //dia=true, hd=true
	 @Test(timeout = 1000)
	    public void testHealthInsurance3() {
		 Person p1 = new Person("Saswat", 41, "aviator", true, true);
		 assertEquals(1100+"", p1.getHealthInsurancePrice()+"");
	        
	    }
	 
	//age>40
		 //dia=false, hd=false
		 @Test(timeout = 1000)
		    public void testHealthInsurance4() {
			 Person p1 = new Person("Saswat", 41, "aviator", false, false);
			 assertEquals(360+"", p1.getHealthInsurancePrice()+"");
		        
		    }
		//age>40
		 //dia=false, hd=true
		 @Test(timeout = 1000)
		    public void testHealthInsurance5() {
			 Person p1 = new Person("Saswat", 41, "aviator", false, true);
			 assertEquals(400+"", p1.getHealthInsurancePrice()+"");
		        
		    }
		//age>40
		 //dia=true, hd=false
		 @Test(timeout = 1000)
		    public void testHealthInsurance6() {
			 Person p1 = new Person("Saswat", 41, "aviator", true, false);
			 assertEquals(500+"", p1.getHealthInsurancePrice()+"");
		        
		    }
	 


    // ########## YOUR CODE ENDS HERE ##########

}
