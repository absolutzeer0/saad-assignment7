
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

    public static void main(String args[]) throws IOException {

        /*
           
         
         */
//            //   System.out.println(u.getCourses().toString());
//            //System.out.println(u.getRequests().toString());
//            System.out.println(u.getRequests().size());
//            //System.out.println(counterSuccessRequest);
//            System.out.println(u.queryRequestsFailedPrere());
//            System.out.println(u.queryRequestsFailedPerformance());
//            System.out.println(u.queryRequestsFailedCap());
        //Scanner in = new Scanner(System.in);
        InterfaceGuiLogic iG = new InterfaceGuiLogic();
        iG.loadFiles();
        int cycle = 1;
        iG.doAssigments(cycle);
        iG.handleRequests(cycle);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String options = "";
        boolean run = true;
        while (run) {
            options = in.readLine();

            if (options.equals("display_requests")) {
                for (int i = 0; i < iG.getU().getRequests().size(); i++) {
                    if (iG.getU().getRequests().get(i).isAccepted()) {
                        System.out.println(iG.getU().getRequests().get(i).getStudent().getUuid()
                                + ", " + iG.getU().getRequests().get(i).getStudent().getNameStudent() + ", "
                                + iG.getU().getRequests().get(i).getCourseRequested().getIdCourse() + ", "
                                + iG.getU().getRequests().get(i).getCourseRequested().getNameCourse());
                    }
                }
            } else if (options.equals("display_seats")) {
                for (int i = 0; i < iG.getU().getCourses().size(); i++) {
                    System.out.println(iG.getU().getCourses().get(i).getIdCourse() + ", " + iG.getU().getCourses().get(i).getNameCourse() + ", "
                            + (iG.getU().getCourses().get(i).getCapStudents() - iG.getU().getCourses().get(i).getStudentsRegistered()));
                }
            } else if (options.equals("display_records")) {
                for (int i = 0; i < iG.getU().getRecords().size(); i++) {
                    System.out.println(iG.getU().getRecords().get(i).getIdStudent() + ", " + iG.getU().getRecords().get(i).getIdCourse()
                            + ", " + iG.getU().getRecords().get(i).getIdProfessor() + ", " + iG.getU().getRecords().get(i).getCommentsProfessor()
                            + ", " + iG.getU().getRecords().get(i).getPerformace());
                }
            } else if (options.contains("add_record")) {
                String[] tk = options.split(",");

                String idS = tk[1];
                String idC = tk[2];
                String idP = tk[3];
                String comments = tk[4];
                String finalGrade = tk[5];

                Record rAux = new Record(idS, idC, idP, comments, finalGrade);
                iG.getU().addRecord(rAux);

            } else if (options.contains("add_seats")) {
                String optS[] = options.split(",");
                iG.getU().addSeats(optS[1], Integer.parseInt(optS[2]));
            } else if (options.contains("check_request")) {
                String optS[] = options.split(",");
                System.out.println(iG.getU().handleRequestStudent(optS[1], optS[2]));
            } else if (options.equals("quit")) {
                System.out.println("stopping the command loop");
                run = false;
                in.close();
            }
        }
    }
}
