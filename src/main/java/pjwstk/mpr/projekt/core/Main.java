
package pjwstk.mpr.projekt.core;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pjwstk.mpr.projekt.beans.School;
import pjwstk.mpr.projekt.beans.Disciple;
import pjwstk.mpr.projekt.beans.SchoolClass;

public class Main {
    
    public static void main( String[] args )
    {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            Transaction transaction = session.beginTransaction();
            
            School school = new School("Szkoła Geniuszy", "ul. Mickiewicza 20, Łupieżowo 54-234");
            
            SchoolClass claasA = new SchoolClass("A", "Jan Kowalski");
            SchoolClass classB = new SchoolClass("B", "Jan Bednarski");
            SchoolClass classC = new SchoolClass("C", "Jan Kogut");
            
            List<SchoolClass> schoolClasses = new ArrayList<SchoolClass>();
            
            schoolClasses.add(claasA);
            schoolClasses.add(classB);
            schoolClasses.add(classC);
            
            school.setSchoolClass(schoolClasses);
            claasA.setSchool(school);
            classB.setSchool(school);
            classC.setSchool(school);
            
            Disciple discipleA = new Disciple("Artur Mąka", 54L, 15L);
            Disciple discipleB = new Disciple("Artur Wiśniewski", 60L, 15L);
            Disciple discipleC = new Disciple("Artur Malenczuk", 58L, 15L);
            
            List<Disciple> disciples = new ArrayList<Disciple>();
            
            disciples.add(discipleA);
            disciples.add(discipleB);
            
            claasA.setDisciples(disciples);
            discipleA.setSchoolClass(claasA);
            discipleB.setSchoolClass(claasA);
            
            List<Disciple> disciples2 = new ArrayList<Disciple>();
            
            disciples2.add(discipleC);
            
            classC.setDisciples(disciples2);
            discipleC.setSchoolClass(classC);
            
            session.save(school);
            
            transaction.commit();
            session.close();
        } catch (SchoolClassConstructorException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SearchDisciple searchTransport = new SearchDisciple();
        
        System.out.println("\nSzukaj po imieniu:");
        print(searchTransport.searchByName("Artur Wiśniewski"));
        System.out.println("\nSzukaj po wadze:");
        print(searchTransport.searchByWeight(55L, 60L));
        System.out.println("\nSzukaj po wieku:");
        print(searchTransport.searchByAge(15L, 15L));
    }
    
    public static void print(List<Disciple> transports) {
        for(Disciple transport : transports) {
            System.out.println(transport);
        }
    }
}
