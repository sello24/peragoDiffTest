package xyz.foobar.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import xyz.foobar.Diff;
import xyz.foobar.DiffEngine;
import xyz.foobar.DiffEngineImpl;
import xyz.foobar.DiffRenderer;
import xyz.foobar.DiffRendererImpl;

public class DiffEngineImplTest {


    
    @Test
    
    
    /*
     * Test  When object is null and the modified  is not null
     */
    
    
    public void testDiffEngineIsNullAndModifiedNonNull() throws Exception {
        DiffEngine diffEngine = new DiffEngineImpl();
        Person modified = new Person();
        modified.setFirstName("John");
        modified.setSurname("Sebastian");

        Diff<Person> diff = diffEngine.calculate(null, modified);
        Person clone = (modified);
        clone.setSurname("Jameson");

        Person applied = diffEngine.apply(clone, diff);
        assertNotNull(applied);
        assertEquals(applied.getSurname(),"Sebastian");
        assertEquals(applied.getSurname(),modified.getSurname());

    }

    @Test
    
    /*
     * Test  When object is null
     */
    
    
    public void testDiffEngineIsNull() throws Exception {
        DiffEngine diffEngine = new DiffEngineImpl();
       DiffRenderer renderer = new DiffRendererImpl();
        Person original = new Person();
        original.setFirstName("John");
        original.setSurname("Sebastian");

        Diff<Person> diff = diffEngine.calculate(original, null);
        Person applied = diffEngine.apply(original, diff);
        assertNotNull(original);
        assertNull(applied);

    }


    @Test
    /*
     * Test object differences
     */
    public void testDiffDifferences() throws Exception {
        DiffEngine diffEngine = new DiffEngineImpl();
      
        Person person = new Person();
        person.setFirstName("John");
        person.setSurname("Sebastian");

       Pet pet = new Pet();
       pet.setName("RoaringBud");
       pet.setType("Lion");
       Pet pet1 = (pet);
       pet1.setName("Bobby");
       pet1.setType("Dog");




        Diff<Pet> diff = diffEngine.calculate(pet, pet1);

        assertEquals(0L, diff.getDifferencesClasses().size());

    }

    
    @Test
    /*
     * Test  When Original Is Null
     */
    public void diffEngineCalculatesDiffShouldEqualModifedWhenOriginalIsNull() throws Exception {
        DiffEngine diffEngine = new DiffEngineImpl();
    
        Person person = new Person();
        person.setFirstName("John");
        person.setSurname("Sebastian");
        Person friend = new Person();
        friend.setFirstName("Sello");
        person.setFriend(friend);
        Set<String> nickNames = new HashSet<String>();
        nickNames.add("Buddy");
        nickNames.add("Joe");
        person.setNickNames(nickNames);

        Diff<Person> diff = diffEngine.calculate(null, person);
        assertNotNull(diff);
        assertEquals(diff.getPlaceHolder(), person);

    }

    
    

    @Test
    /*
     * Test collections
     */
    public void testDiffCollections() throws Exception {
        DiffEngine diffEngine = new DiffEngineImpl();

        Person person = new Person();
        person.setFirstName("John");
        person.setSurname("Sebastian");
        Set<String> names = new HashSet<>();
        names.add("Johnny");
        person.setNickNames(names);

        Person clone = (person);
        clone.setFirstName("Fred");


        Set<String> listNames = new HashSet<String>();
        names.add("Sipho");
        names.add("Sello");
        names.add("Sbu");
        names.add("Gonzalez");
        names.add("Bongz");
        clone.setNickNames(listNames);

        Diff<Person> diff = diffEngine.calculate(person, clone);
        Person applied = diffEngine.apply(person, diff);
        assertEquals(applied.getFirstName(),clone.getFirstName());
        assertEquals(applied.getNickNames(),clone.getNickNames());

        assertEquals(applied, clone);



    }




    @Test
    /*
     * Test  When object is null and the modified is also null
     */
    public void testDiffEngineNulls() throws Exception {
        DiffEngine diffEngine = new DiffEngineImpl();
        Person original = new Person();
        original.setFirstName("John");
        original.setSurname("Sebastian");

        Person friend = new Person();
        friend.setFirstName("Sello");

        Person modified =(original);
        modified.setSurname("Jameson");
        modified.setFriend(friend);

        Diff<Person> diff = diffEngine.calculate(original, modified);

        Person applied = diffEngine.apply(modified, diff);
        assertEquals("Sebastian", original.getSurname());
        assertEquals("Jameson", applied.getSurname());
        assertEquals(applied.getFriend().getFirstName(), "Sello");

    }

    
    

}
