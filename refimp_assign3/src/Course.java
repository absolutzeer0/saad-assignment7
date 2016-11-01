
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge
 */
public class Course {
    private String idCourse;
    private String nameCourse;
    private ArrayList<String> semestersOffered;
    private String description;
    private boolean isOnline;
    private boolean isOnCampus;
    private int capStudents;    


  
    public Course(String idCourse, String nameCourse, ArrayList<String> semestersOffered, String description, boolean isOnline, boolean isOnCampus) {
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.semestersOffered = semestersOffered;
        this.description = description;
        this.isOnline = isOnline;
        this.isOnCampus = isOnCampus; 
        
    }
public Course(String idCourse, String nameCourse, ArrayList<String> semestersOfferedI){
        this.idCourse = idCourse;
        this.nameCourse = nameCourse;
        this.semestersOffered = semestersOfferedI;
        
         
    }
    public String getIdCourse() {return idCourse;}
    public void setIdCourse(String idCourse) {this.idCourse = idCourse;}
    public String getNameCourse() {return nameCourse; }

    public void setNameCourse(String nameCourse) {this.nameCourse = nameCourse;}

    public ArrayList<String> getSemestersOffered() {return semestersOffered;}

    public void setSemestersOffered(ArrayList<String> semestersOffered) {this.semestersOffered = semestersOffered;}

    public String getDescription() {return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    public boolean isOnCampus() {
        return isOnCampus;
    }

    public void setIsOnCampus(boolean isOnCampus) {
        this.isOnCampus = isOnCampus;
    }

    public int getCapStudents() {
        return capStudents;
    }

    public void setCapStudents(int capStudents) {
        this.capStudents = capStudents;
    }

    @Override
    public String toString() {
        return "Course{" + "idCourse=" + idCourse + ", nameCourse=" + nameCourse + '}';
    }
   

  
    
    
           
}
