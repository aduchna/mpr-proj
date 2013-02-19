
package pjwstk.mpr.projekt.test;

import java.util.ArrayList;
import java.util.List;
import pjwstk.mpr.projekt.beans.SchoolClass;
import pjwstk.mpr.projekt.beans.School;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SchoolTest {
    
    School school;
    
    @Before
    public void setUp() {
        school = new School("", "");
    }
    
    @Test
    public void constructor() {
        assertEquals("", school.getName());
        assertEquals("", school.getAdress());
    }
    
    @Test
    public void propertyName() {
        school.setName("Szkoła");
        assertEquals("Szkoła", school.getName());
    }
    
    @Test
    public void propoertyAdress() {
        school.setAdress("ul. Mickiewicza 20, Łupieżowo 54-234");
        assertEquals("ul. Mickiewicza 20, Łupieżowo 54-234", school.getAdress());
    }
    
    @Test
    public void propertyTrucks() {
        List<SchoolClass> trucks = new ArrayList<SchoolClass>();
        school.setSchoolClass(trucks);
        assertSame(trucks, school.getSchoolClass());
    }
    
    @Test
    public void toStringMethod() {
        school.setName("Szkoła");
        school.setAdress("ul. Mickiewicza 20, Łupieżowo 54-234");
        
        assertEquals("Szkoła ul. Mickiewicza 20, Łupieżowo 54-234", school.toString());
    }
}
