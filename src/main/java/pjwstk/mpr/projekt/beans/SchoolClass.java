package pjwstk.mpr.projekt.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import pjwstk.mpr.projekt.core.SchoolClassConstructorException;

@Entity
public class SchoolClass implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String name;
    
    private String educator;
    
    @ManyToOne
    @JoinColumn(name="school_fk") 
    private School school; 
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="schoolClass")
    private List<Disciple> disciples; 

    protected SchoolClass() {}
    
    public SchoolClass(String name, String educator) throws SchoolClassConstructorException {
        if(name == null || educator == null) {
            throw new SchoolClassConstructorException();
        }
        this.name = name;
        this.educator = educator;
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

    public String getEducator() {
        return educator;
    }

    public void setEducator(String educator) {
        this.educator = educator;
    }

    public List<Disciple> getDisciples() {
        return disciples;
    }

    public void setDisciples(List<Disciple> disciples) {
        this.disciples = disciples;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
    
    @Override
    public String toString() {
        return name + " " + educator;
    }
}
