
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
public class CourseToTake extends Course {
      
    private int studentsRegistered;

 
    private ArrayList<CoursePrerequesite> coursesPrerequisite;

    public CourseToTake(String idCourse, String nameCourse, ArrayList<String> semestersOfferedI) {
        super(idCourse, nameCourse, semestersOfferedI);
        studentsRegistered =0;
        coursesPrerequisite = new ArrayList<>();        
    }

  
 
   
  public ArrayList<CoursePrerequesite> getCoursesPrerequisite() {
        return coursesPrerequisite;
    }

    public void setCoursesPrerequisite(ArrayList<CoursePrerequesite> coursesPrerequisite) {
        this.coursesPrerequisite = coursesPrerequisite;
    }

    public int getStudentsRegistered() {
        return studentsRegistered;
    }

    public void setStudentsRegistered(int studentsRegistered) {
        this.studentsRegistered = studentsRegistered;
    }

    @Override
    public String toString() {
        return "CourseToTake{ ID: "+this.getIdCourse()+" Name:"+this.getNameCourse() + "studentsRegistered=" + studentsRegistered + ", coursesPrerequisite=" + coursesPrerequisite + '}';
    }

  
    
    
           
}
