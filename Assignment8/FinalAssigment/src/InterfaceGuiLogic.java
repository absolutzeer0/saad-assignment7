
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jorge
 */
public class InterfaceGuiLogic {

    private University u;
    String nameOfFirstDocument = "students.csv";
    String nameOfSecondDocument = "courses.csv";
    String nameOfThirdDocument = "instructors.csv";
    String nameOfFourthDocument = "records.csv";
    String nameOfFithtDocument = "prereqs.csv";
    String nameOfSixthDocument = "assignments";
    String nameOfSeventhDocument = "requests";
    // String nameOfSeventhDocument = "requests.csv";
    public InterfaceGuiLogic() {
    //SloadFiles();
    //doAssigments();
    }
    
    public String digestFileWithWeka(File inputFile) throws Exception{
        WekaConverter wc = new WekaConverter();
        return wc.aprioriReadout(inputFile);
    }

    public void loadFiles() {

        BufferedReader readerF = null;

        try {
            readerF = new BufferedReader(new FileReader(nameOfFirstDocument));

            String aux;
            ArrayList<Student> students = new ArrayList<>();
            while ((aux = readerF.readLine()) != null) {
                //System.out.println(aux);
                StringTokenizer tk = new StringTokenizer(aux, ",");

                while (tk.hasMoreElements()) {

                    String idS = tk.nextToken();
                    String nameS = tk.nextToken();
                    String addressS = tk.nextToken();
                    String phoneS = tk.nextToken();

                    Student sAux = new Student(idS, nameS, addressS, phoneS);
                    students.add(sAux);
                }
            }
            // System.out.println(students.toString());
            readerF.close();
            readerF = new BufferedReader(new FileReader(nameOfSecondDocument));
            String auxCourses;
            ArrayList<Course> courses = new ArrayList<>();
            while ((auxCourses = readerF.readLine()) != null) {
                // System.out.println(auxCourses);
                String[] splittedCourseS = auxCourses.split(",");

                //  System.out.println(tk.nextToken());
                String idC = splittedCourseS[0];
                String nameC = splittedCourseS[1];
                Course cAux = null;
                if (splittedCourseS.length > 2) {
                    ArrayList<String> semestersOfe = new ArrayList<>();
                    for (int i = 2; i < splittedCourseS.length; i++) {
                        semestersOfe.add(splittedCourseS[i]);
                    }
                    cAux = new Course(idC, nameC, semestersOfe);
                } else {
                    cAux = new Course(idC, nameC, null);
                }

                courses.add(cAux);

            }
            readerF.close();
            readerF = new BufferedReader(new FileReader(nameOfThirdDocument));
            //System.out.println(courses.toString());
            String auxP;
            ArrayList<Employee> professors = new ArrayList<>();
            while ((auxP = readerF.readLine()) != null) {
                //   System.out.println(auxP);
                StringTokenizer tk = new StringTokenizer(auxP, ",");

                while (tk.hasMoreElements()) {

                    String idP = tk.nextToken();
                    String nameP = tk.nextToken();
                    String addressP = tk.nextToken();
                    String phoneP = tk.nextToken();

                    Professor pAux = new Professor(idP, nameP, addressP, phoneP);
                    professors.add(pAux);
                }
            }
            readerF.close();
            readerF = new BufferedReader(new FileReader(nameOfFourthDocument));
            // System.out.println(professors.toString());
            String auxR;
            ArrayList<Record> records = new ArrayList<>();

            while ((auxR = readerF.readLine()) != null) {
                //System.out.println(auxR);
                String[] tk = auxR.split(",");

                String idS = tk[0];
                String idC = tk[1];
                String idP = tk[2];
                String comments = tk[3];
                String finalGrade = tk[4];

                Record rAux = new Record(idS, idC, idP, comments, finalGrade);
                records.add(rAux);

            }

            u = new University(students, professors, courses, records);
            readerF = new BufferedReader(new FileReader(nameOfFithtDocument));
            auxR = "";

            while ((auxR = readerF.readLine()) != null) {                
                String[] tk = auxR.split(",");
                String prerequesite = tk[0];
                String idCourseToAddPrerequsite = tk[1];
                u.addPrerequiste(prerequesite, idCourseToAddPrerequsite);
            }
            readerF.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(InterfaceGuiLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(InterfaceGuiLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void doAssigments(int cycle) {
        try {
            nameOfSixthDocument+=cycle+".csv";
            BufferedReader readerF = new BufferedReader(new FileReader(nameOfSixthDocument));
            String auxR = "";
            
            while ((auxR = readerF.readLine()) != null) {
                //System.out.println(auxR);
                String[] tk = auxR.split(",");                
                String idProfessor = tk[0];
                String idCourse = tk[1];
                String capStudents = tk[2];                
                u.doAssigments(idProfessor, idCourse, Integer.parseInt(capStudents));
            }
            readerF.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(InterfaceGuiLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void handleRequests(int cycle){
        BufferedReader   readerF = null;
        try {
            nameOfSeventhDocument+=cycle+".csv";
            readerF = new BufferedReader(new FileReader(nameOfSeventhDocument));
            String auxR = "";
            int counterSuccessRequest = 0;
            while ((auxR = readerF.readLine()) != null) {
                //System.out.println(auxR);
                String[] tk = auxR.split(",");

                String studentID = tk[0];
                String courseIDRequested = tk[1];

                if (u.handleRequestStudent(studentID, courseIDRequested).equalsIgnoreCase("valid")) {
                    counterSuccessRequest++;
                }
            }
            readerF.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceGuiLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceGuiLogic.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                readerF.close();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceGuiLogic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public University getU() {
        return u;
    }

    public void setU(University u) {
        this.u = u;
    }    
}
