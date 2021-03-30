
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonRepositoryTest {

    SequenceGenerator sequenceGenerator;
    PersonRepository personRepository;
    Person p = new Person("Saswat", 10, "Student", true, true);

    @Before
    public void before() {
        sequenceGenerator = new SequenceGenerator();
        personRepository = new PersonRepository();
        personRepository.setSequenceGenerator(sequenceGenerator);
    }

    // Implement your test cases
    // Hint: The java.lang.Integer.intValue() is an inbuilt method in Java that returns the value of an Integer as an int.

    // ########## YOUR CODE STARTS HERE ##########

    // ########## YOUR CODE ENDS HERE ##########


    @Test(timeout = 1000)
    public void testSavePerson() {
        
	 assertEquals(p,personRepository.save(p));
        
    }
    
    
    
    @Test(timeout = 1000)
    public void testID() {
     Person p1=personRepository.save(p);
     assertEquals(p1,personRepository.findById(1));
     System.out.println(personRepository.findById(1));
//	 assertEquals();
        
    }
}
