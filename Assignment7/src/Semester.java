/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;



/**
 *
 * @author Matt
 */
public class Semester {
    private String idSemester;
    private String name;
    private String year;
    private ArrayList<Student> studentWaitlist;
    
    public Semester(String idSemester, String name, String year, ArrayList<Student> studentWaitlist){
        this.setIdSemester(idSemester);
        this.setName(name);
        this.setYear(year);
        this.studentWaitlist = new ArrayList<Student>(); //new empty arraylist
    }

    public String getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(String idSemester) {
        this.idSemester = idSemester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<Student> getStudentWaitlist() {
        return studentWaitlist;
    }

    public void setStudentWaitlist(ArrayList<Student> studentWaitlist) {
        this.studentWaitlist = studentWaitlist;
    }
    
    public void addToStudentWaitlist(Student student){
        this.studentWaitlist.add(student);
    }
    
    public void removeFromStudentWaitlist(Student student){
        this.studentWaitlist.remove(student);
    }
    
    public int countStudentWaitlist(){
        return this.studentWaitlist.size();
    }
    
}
