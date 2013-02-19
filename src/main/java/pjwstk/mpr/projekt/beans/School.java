package pjwstk.mpr.projekt.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class School implements Serializable {
    
    @Id 
    @GeneratedValue 
    private Long id; 
     
    private String name; 
    
    private String adress; 
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="school") 
    private List<SchoolClass> schoolClasses; 
    
    protected School() {
        
    }
    
    public School(String name, String adress) {
        this.name = name;
        this.adress = adress;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<SchoolClass> getSchoolClass() {
        return schoolClasses;
    }

    public void setSchoolClass(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    
    @Override
    public String toString() {
        return name + " " + adress;
    }
}
