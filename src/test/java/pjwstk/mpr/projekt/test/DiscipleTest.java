
package pjwstk.mpr.projekt.test;

import pjwstk.mpr.projekt.core.SchoolClassConstructorException;
import pjwstk.mpr.projekt.beans.Disciple;
import pjwstk.mpr.projekt.beans.SchoolClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DiscipleTest {
    
    Disciple disciple;
    
    @Before
    public void setUp() {
        disciple = new Disciple("", 0L, 0L); 
    }
    
    @Test
    public void constructor() {
        assertEquals("", disciple.getName());
        assertEquals(new Long(0), disciple.getWeight());
        assertEquals(new Long(0), disciple.getAge());
        assertNotNull(disciple.getName()); 
        assertTrue(disciple.getName().equals("")); 
    }
    
    @Test
    public void propertyName() { 
        disciple.setName("Jan Kowalski");
        assertEquals("Jan Kowalski", disciple.getName());
    }
    
    @Test
    public void propertyWeight() {
        disciple.setWeight(1000L);
        assertEquals(new Long(1000), disciple.getWeight());
    }
    
    @Test
    public void propertyPrice() {
        disciple.setAge(1000L);
        assertEquals(new Long(1000), disciple.getAge());
    }
    
    @Test
    public void propertyTruck() throws SchoolClassConstructorException {
        SchoolClass truck = new SchoolClass("", "");
        disciple.setSchoolClass(truck);
        assertSame(truck, disciple.getSchoolClass());
    }
    
    @Test
    public void toStringMethod() {
        disciple.setName("Jan Kowalski");
        disciple.setAge(20L);
        
        assertEquals("Jan Kowalski wiek: 20", disciple.toString());
    }
}
