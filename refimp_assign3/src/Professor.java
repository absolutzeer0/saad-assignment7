

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
public class Professor extends Employee{
    private ArrayList<String> degrees;
    private ArrayList<Course> coursesOfProfessor;
    
            
    
    public Professor(String uid, String name, String phoneNumber, String address, String salary,ArrayList<String> degree, ArrayList<Course> coursesOfCourseProfesors) {
        super(uid, name, phoneNumber, address, salary);
        this.degrees = degree;
        this.coursesOfProfessor = coursesOfCourseProfesors;
    }
      public Professor(String uid, String name, String phoneNumber, String address){
        super(uid, name, phoneNumber, address);
       
    }
    public boolean updateDegrees(){ return true; }
    
     public boolean addTeachingCourse(String idCourse){return true;}
    public boolean dropTeachingCourse(String idCourse){return true;} 
    public ArrayList<String> queryPastCoursesTeached(){return null;}        
    public ArrayList<String> queryCurrentCoursesTeaching(){return null;} 

    public ArrayList<String> getDegrees() {
        return degrees;
    }

    public void setDegrees(ArrayList<String> degrees) {
        this.degrees = degrees;
    }

    public ArrayList<Course> getCoursesOfProfessor() {
        return coursesOfProfessor;
    }

    public void setCoursesOfProfessor(ArrayList<Course> coursesOfProfessor) {
        this.coursesOfProfessor = coursesOfProfessor;
    }
  
    
    
}
