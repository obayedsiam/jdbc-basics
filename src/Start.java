import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Student management");

        while (true) {
            System.out.println("Press 1 to add student");
            System.out.println("Press 2 to delete student");
            System.out.println("Press 3 to display student");
            System.out.println("Press 4 to update student");
            System.out.println("Press 5 to exit api");

            int c = Integer.parseInt(br.readLine());

            if (c == 1) { // Add Student

                System.out.println("Enter student name");
                String name = br.readLine();

                System.out.println("Enter student phone number");
                String phone = br.readLine();

                System.out.println("Enter student city");
                String city = br.readLine();

                Student student = new Student(name, phone, city);

                boolean result = StudentDao.insertToDatabase(student);

                if (result == true) System.out.println("successfully added");
                else System.out.println("Failed to insert");
                System.out.println(student);

            } else if (c == 2) {  // Delete Student
                System.out.println("Enter id to delete");
                int studentId = Integer.parseInt(br.readLine());
                boolean result = StudentDao.deleteStudent(studentId);

                if (result == true) System.out.println("Deleted");
                else System.out.println("Failed to delete");

            } else if (c == 3) { // Display Student
                System.out.println("Enter id to display");
                int studentId = Integer.parseInt(br.readLine());
                StudentDao.displayStudent(studentId);

            } else if (c == 4) { //update
                System.out.println("Enter id to update");
                int studentId = Integer.parseInt(br.readLine());

                Student student = StudentDao.displayStudent(studentId);

                System.out.println("Enter updated name (keep blank if no update needed)");
                String name = br.readLine();

                System.out.println("Enter updated phone number (keep blank if no update needed)");
                String phone = br.readLine();

                System.out.println("Enter updatetd city (keep blank if no update needed)");
                String city = br.readLine();

                if(!name.equals(""))student.setStudentName(name);
                if(!city.equals(""))student.setStudentCity(city);
                if(!phone.equals(""))student.setStudentPhone(phone);

                boolean result = StudentDao.updateToDatabase(student);

                if (result == true){
                    System.out.println("Updated");
                    StudentDao.displayStudent(student.getStudentId());
                }
                else System.out.println("Failed to update");

            } else {
                break;
            }
        }
        System.out.println("Thank you for using my application");
    }
}
