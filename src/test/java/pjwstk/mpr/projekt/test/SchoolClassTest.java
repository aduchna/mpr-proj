
package pjwstk.mpr.projekt.test;

import java.util.ArrayList;
import java.util.List;
import pjwstk.mpr.projekt.core.SchoolClassConstructorException;
import pjwstk.mpr.projekt.beans.Disciple;
import pjwstk.mpr.projekt.beans.School;
import pjwstk.mpr.projekt.beans.SchoolClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SchoolClassTest {
    
    SchoolClass schoolClass;
    
    @Before
    public void setUp() throws SchoolClassConstructorException {
        schoolClass = new SchoolClass("", "");
    }
    
    @Test
    public void constructor() {
        assertEquals("", schoolClass.getName());
        assertEquals("", schoolClass.getEducator());
    }
    
    @Test
    public void propertyModel() {
        schoolClass.setName("A");
        assertEquals("A", schoolClass.getName());
    }
    
    @Test
    public void propertyRegistration() {
        schoolClass.setEducator("Jan Kowalski");
        assertEquals("Jan Kowalski", schoolClass.getEducator());
    }
    
    @Test
    public void propertyCompany() {
        School company = new School("", "");
        schoolClass.setSchool(company);
        assertSame(company, schoolClass.getSchool());
    }
    
    @Test
    public void propertyTransports() {
        List<Disciple> transports = new ArrayList<Disciple>();
        schoolClass.setDisciples(transports);
        assertSame(transports, schoolClass.getDisciples());
    }
    
    @Test (expected=SchoolClassConstructorException.class)
    public void truckExceptionForRegistration() throws SchoolClassConstructorException {
        new SchoolClass("", null);
    }
    
    @Test (expected=SchoolClassConstructorException.class) 
    public void truckExceptionForModel() throws SchoolClassConstructorException {
        new SchoolClass(null, "");
    }
    
    @Test (expected=SchoolClassConstructorException.class)
    public void truckExceptionForBoth() throws SchoolClassConstructorException {
        new SchoolClass(null, null);
    }
    
    @Test
    public void toStringMethod() {
        schoolClass.setName("A");
        schoolClass.setEducator("Jan Kowalski");
        
        assertEquals("A Jan Kowalski", schoolClass.toString());
    }
}
