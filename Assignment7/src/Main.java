


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
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
public class Main {

    public static void main(String args[]) {
        BufferedReader readerF = null;
        String nameOfFirstDocument = "students.csv";
        String nameOfSecondDocument = "courses.csv";
        String nameOfThirdDocument = "instructors.csv";
        String nameOfFourthDocument = "records.csv";
        String nameOfFithtDocument = "prereqs.csv";
        String nameOfSixthDocument = "assignments.csv";
        String nameOfSeventhDocument = "requests.csv";

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
            ArrayList<CourseToTake> courses = new ArrayList<>();
            while ((auxCourses = readerF.readLine()) != null) {
                // System.out.println(auxCourses);
                String[] splittedCourseS = auxCourses.split(",");

                //  System.out.println(tk.nextToken());
                String idC = splittedCourseS[0];
                String nameC = splittedCourseS[1];
                CourseToTake cAux = null;
                if (splittedCourseS.length > 2) {
                    ArrayList<String> semestersOfe = new ArrayList<>();
                    for (int i = 2; i < splittedCourseS.length; i++) {
                        semestersOfe.add(splittedCourseS[i]);
                    }
                    cAux = new CourseToTake(idC, nameC, semestersOfe);
                } else {
                    cAux = new CourseToTake(idC, nameC, null);
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

            University u = new University(students, professors, courses, records);
            readerF = new BufferedReader(new FileReader(nameOfFithtDocument));
            auxR = "";

            while ((auxR = readerF.readLine()) != null) {
                //System.out.println(auxR);
                String[] tk = auxR.split(",");

                String prerequesite = tk[0];
                String idCourseToAddPrerequsite = tk[1];

                u.addPrerequiste(prerequesite, idCourseToAddPrerequsite);
            }
            readerF.close();

            readerF = new BufferedReader(new FileReader(nameOfSixthDocument));
            auxR = "";

            while ((auxR = readerF.readLine()) != null) {
                //System.out.println(auxR);
                String[] tk = auxR.split(",");

                String idProfessor = tk[0];
                String idCourse = tk[1];
                String capStudents = tk[2];

                u.doAssigments(idProfessor, idCourse, Integer.parseInt(capStudents));
            }
            readerF.close();
            readerF = new BufferedReader(new FileReader(nameOfSeventhDocument));
            auxR = "";

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

            //   System.out.println(u.getCourses().toString());
            //System.out.println(u.getRequests().toString());
            System.out.println(u.getRequests().size());
            System.out.println(counterSuccessRequest);
            System.out.println(u.queryRequestsFailedPrere());
            System.out.println(u.queryRequestsFailedPerformance());
            System.out.println(u.queryRequestsFailedCap());

            //Scanner in = new Scanner(System.in);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String options = "";
            boolean run = true;
            while (run) {
                options = in.readLine();

                if (options.equals("display_requests")) {
                    for (int i = 0; i < u.getRequests().size(); i++) {
                        if (u.getRequests().get(i).isAccepted()) {
                            System.out.println(u.getRequests().get(i).getStudent().getUuid()
                                    + ", " + u.getRequests().get(i).getStudent().getNameStudent() + ", "
                                    + u.getRequests().get(i).getCourseRequested().getIdCourse() + ", "
                                    + u.getRequests().get(i).getCourseRequested().getNameCourse());
                        }
                    }
                } else if (options.equals("display_seats")) {
                    for (int i = 0; i < u.getCourses().size(); i++) {
                        System.out.println(u.getCourses().get(i).getIdCourse() + ", " + u.getCourses().get(i).getNameCourse() + ", "
                                + (u.getCourses().get(i).getCapStudents() - u.getCourses().get(i).getStudentsRegistered()));
                    }
                } else if (options.equals("display_records")) {
                    for (int i = 0; i < u.getRecords().size(); i++) {
                        System.out.println(u.getRecords().get(i).getIdStudent() + ", " + u.getRecords().get(i).getIdCourse()
                                + ", " + u.getRecords().get(i).getIdProfessor() + ", " + u.getRecords().get(i).getCommentsProfessor()
                                + ", " + u.getRecords().get(i).getPerformace());
                    }
                } else if (options.contains("add_record")) {
                    String[] tk = options.split(",");

                    String idS = tk[1];
                    String idC = tk[2];
                    String idP = tk[3];
                    String comments = tk[4];
                    String finalGrade = tk[5];

                    Record rAux = new Record(idS, idC, idP, comments, finalGrade);
                    u.addRecord(rAux);

                } else if (options.contains("add_seats")) {
                    String optS[] = options.split(",");
                    u.addSeats(optS[1], Integer.parseInt(optS[2]));
                } else if (options.contains("check_request")) {
                    String optS[] = options.split(",");
                    System.out.println(u.handleRequestStudent(optS[1], optS[2]));
                } else if (options.equals("quit")) {
                    System.out.println("stopping the command loop");
                    run = false;
                    in.close();
                }

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
