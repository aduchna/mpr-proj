
package pjwstk.mpr.projekt.beans;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Disciple implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private Long weight;
    
    private Long age;
    
    @ManyToOne
    @JoinColumn(name="schoolClasss_fk") 
    private SchoolClass schoolClass;

    protected Disciple() {}
    
    public Disciple(String name, Long weight, Long age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
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

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @Override
    public String toString() {
        return name + " wiek: " + age;
    }
}
