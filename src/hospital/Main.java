package hospital;

import hospital.model.*;
import hospital.service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    // Static field
    private static int operationCount = 0;

    private static final PatientService patientService = new PatientService();
    private static final DoctorService doctorService = new DoctorService();
    private static final AppointmentService appointmentService = new AppointmentService();
    private static final BillService billService = new BillService();

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("      HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("======================================");
        System.out.println(HospitalConstants.HOSPITAL_NAME);

        testDatabaseConnection();

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");
            operationCount++;

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    registerDoctor();
                    break;

                case 3:
                    patientService.viewPatients();
                    break;

                case 4:
                    doctorService.viewDoctors();
                    break;

                case 5:
                    searchPatient();
                    break;

                case 6:
                    searchDoctor();
                    break;

                case 7:
                    updatePatient();
                    break;

                case 8:
                    deletePatient();
                    break;

                case 9:
                    bookAppointment();
                    break;

                case 10:
                    appointmentService.viewAppointments();
                    break;

                case 11:
                    updateAppointmentStatus();
                    break;

                case 12:
                    deleteAppointment();
                    break;

                case 13:
                    generateBill();
                    break;

                case 14:
                    billService.viewBills();
                    break;

                case 15:
                    hospitalStatistics();
                    break;

                case 16:
                    deleteDoctor();
                    break;

                case 17:
                    running = false;
                    System.out.println("\nThank you for using Hospital Management System.");
                    System.out.println("Total operations performed: " + operationCount);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // ========================= MENU =========================

    private static void displayMenu() {

        System.out.println("\n======================================");
        System.out.println("              MAIN MENU");
        System.out.println("======================================");

        System.out.println("1. Register Patient");
        System.out.println("2. Register Doctor");
        System.out.println("3. View Patients");
        System.out.println("4. View Doctors");
        System.out.println("5. Search Patient");
        System.out.println("6. Search Doctor");
        System.out.println("7. Update Patient");
        System.out.println("8. Delete Patient");
        System.out.println("9. Book Appointment");
        System.out.println("10. View Appointments");
        System.out.println("11. Update Appointment Status");
        System.out.println("12. Delete Appointment");
        System.out.println("13. Generate Bill");
        System.out.println("14. View Bills");
        System.out.println("15. Hospital Statistics");
        System.out.println("16. Delete Doctor");
        System.out.println("17. Exit");

        System.out.println("======================================");
    }

    // ========================= DATABASE =========================

    private static void testDatabaseConnection() {

        try (Connection con = DatabaseConnection.getConnection()) {

            if (con != null) {
                System.out.println("Database connection successful.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Database connection failed: " + e.getMessage()
            );
        }
    }

    // ========================= PATIENT =========================

    private static void registerPatient() {

        System.out.println("\n========== REGISTER PATIENT ==========");

        String name = readString("Enter patient name: ");

        int age;

        while (true) {

            age = readInt("Enter age: ");

            if (age > 0 && age <= HospitalConstants.MAX_PATIENT_AGE) {
                break;
            }

            System.out.println(
                    "Invalid age. Please enter age between 1 and "
                            + HospitalConstants.MAX_PATIENT_AGE + "."
            );

            // Continue statement demonstration
            continue;
        }

        String gender = readString("Enter gender: ");
        String phone = readString("Enter phone number: ");
        String bloodGroup = readString("Enter blood group: ");

        Department department = selectDepartment();

        Patient patient = new Patient(
                0,
                name,
                age,
                gender,
                bloodGroup,
                phone,
                department
        );

        // Array of objects demonstration
        Patient[] patients = {patient};

        for (Patient p : patients) {
            p.displayRole();
        }

        patientService.addPatient(patient);
    }

    private static void searchPatient() {

        System.out.println("\n========== SEARCH PATIENT ==========");

        int id = readInt("Enter patient ID: ");

        patientService.searchPatient(id);
    }

    private static void updatePatient() {

        System.out.println("\n========== UPDATE PATIENT ==========");

        int id = readInt("Enter patient ID: ");

        String name = readString("Enter new name: ");
        int age = readInt("Enter new age: ");
        String gender = readString("Enter new gender: ");
        String phone = readString("Enter new phone: ");
        String bloodGroup = readString("Enter new blood group: ");

        Department department = selectDepartment();

        Patient patient = new Patient(
                id,
                name,
                age,
                gender,
                bloodGroup,
                phone,
                department
        );

        patientService.updatePatient(patient);
    }

    private static void deletePatient() {

        System.out.println("\n========== DELETE PATIENT ==========");

        int id = readInt("Enter patient ID: ");

        patientService.deletePatient(id);
    }

    // ========================= DOCTOR =========================

    private static void registerDoctor() {

        System.out.println("\n========== REGISTER DOCTOR ==========");

        String name = readString("Enter doctor name: ");
        int age = readInt("Enter age: ");
        String gender = readString("Enter gender: ");
        String specialization =
                readString("Enter specialization: ");

        Department department = selectDepartment();

        String phone = readString("Enter phone number: ");

        double consultationFee =
                readDouble("Enter consultation fee: ₹");

        double salary =
                readDouble("Enter monthly salary: ₹");

        Doctor doctor = new Doctor(
                0,
                name,
                age,
                gender,
                specialization,
                department,
                phone,
                consultationFee,
                salary
        );

        // Dynamic binding demonstration
        Person person = doctor;
        person.displayRole();

        doctorService.addDoctor(doctor);
    }

    private static void searchDoctor() {

        System.out.println("\n========== SEARCH DOCTOR ==========");

        int id = readInt("Enter doctor ID: ");

        doctorService.searchDoctor(id);
    }

    private static void deleteDoctor() {

        System.out.println("\n========== DELETE DOCTOR ==========");

        int id = readInt("Enter doctor ID: ");

        doctorService.deleteDoctor(id);
    }

    // ========================= APPOINTMENT =========================

    private static void bookAppointment() {

        System.out.println("\n========== BOOK APPOINTMENT ==========");

        int patientId =
                readInt("Enter patient ID: ");

        int doctorId =
                readInt("Enter doctor ID: ");

        String date =
                readString("Enter appointment date (YYYY-MM-DD): ");

        String status = "Booked";

        Appointment appointment = new Appointment(
                0,
                patientId,
                doctorId,
                date,
                status
        );

        appointmentService.bookAppointment(appointment);
    }

    private static void updateAppointmentStatus() {

        System.out.println(
                "\n========== UPDATE APPOINTMENT STATUS =========="
        );

        int appointmentId =
                readInt("Enter appointment ID: ");

        System.out.println("1. Booked");
        System.out.println("2. Completed");
        System.out.println("3. Cancelled");

        int choice =
                readInt("Select status: ");

        String status;

        switch (choice) {

            case 1:
                status = "Booked";
                break;

            case 2:
                status = "Completed";
                break;

            case 3:
                status = "Cancelled";
                break;

            default:
                System.out.println("Invalid status.");
                return;
        }

        appointmentService.updateAppointmentStatus(
                appointmentId,
                status
        );
    }

    private static void deleteAppointment() {

        System.out.println(
                "\n========== DELETE APPOINTMENT =========="
        );

        int id =
                readInt("Enter appointment ID: ");

        appointmentService.deleteAppointment(id);
    }

    // ========================= BILL =========================

    private static void generateBill() {

        System.out.println("\n========== GENERATE BILL ==========");

        int patientId =
                readInt("Enter patient ID: ");

        double consultationFee =
                readDouble("Enter consultation fee: ₹");

        double medicineFee =
                readDouble("Enter medicine fee: ₹");

        Bill bill = new Bill(
                0,
                patientId,
                consultationFee,
                medicineFee
        );

        // Interface reference demonstration
        Billable billable = bill;

        double total = billable.calculateBill();

        System.out.println(
                "Original Bill Amount: ₹"
                        + total
        );

        double discount =
                readDouble("Enter discount percentage: ");

        double finalAmount =
                bill.calculateBill(discount);

        // Type casting demonstration
        int roundedAmount =
                (int) finalAmount;

        System.out.println(
                "Discounted Amount: ₹"
                        + finalAmount
        );

        System.out.println(
                "Rounded Amount: ₹"
                        + roundedAmount
        );

        billService.addBill(bill);
    }

    // ========================= STATISTICS =========================

    private static void hospitalStatistics() {

        System.out.println(
                "\n========== HOSPITAL STATISTICS =========="
        );

        int patientCount = 0;
        int doctorCount = 0;
        int appointmentCount = 0;

        double totalRevenue = 0;
        double totalSalary = 0;

        try (Connection con =
                     DatabaseConnection.getConnection()) {

            String patientSQL =
                    "SELECT COUNT(*) FROM patients";

            try (PreparedStatement ps =
                         con.prepareStatement(patientSQL);
                 ResultSet rs =
                         ps.executeQuery()) {

                if (rs.next()) {
                    patientCount =
                            rs.getInt(1);
                }
            }

            String doctorSQL =
                    "SELECT COUNT(*) FROM doctors";

            try (PreparedStatement ps =
                         con.prepareStatement(doctorSQL);
                 ResultSet rs =
                         ps.executeQuery()) {

                if (rs.next()) {
                    doctorCount =
                            rs.getInt(1);
                }
            }

            String appointmentSQL =
                    "SELECT COUNT(*) FROM appointments";

            try (PreparedStatement ps =
                         con.prepareStatement(appointmentSQL);
                 ResultSet rs =
                         ps.executeQuery()) {

                if (rs.next()) {
                    appointmentCount =
                            rs.getInt(1);
                }
            }

            String revenueSQL =
                    "SELECT COALESCE(SUM(total_amount), 0) "
                            + "FROM bills";

            try (PreparedStatement ps =
                         con.prepareStatement(revenueSQL);
                 ResultSet rs =
                         ps.executeQuery()) {

                if (rs.next()) {
                    totalRevenue =
                            rs.getDouble(1);
                }
            }

            String salarySQL =
                    "SELECT COALESCE(SUM(salary), 0) "
                            + "FROM doctors";

            try (PreparedStatement ps =
                         con.prepareStatement(salarySQL);
                 ResultSet rs =
                         ps.executeQuery()) {

                if (rs.next()) {
                    totalSalary =
                            rs.getDouble(1);
                }
            }

            double profit =
                    totalRevenue - totalSalary;

            System.out.println(
                    "Total Patients      : " + patientCount
            );

            System.out.println(
                    "Total Doctors       : " + doctorCount
            );

            System.out.println(
                    "Total Appointments  : " + appointmentCount
            );

            System.out.printf(
                    "Total Revenue       : ₹%.2f%n",
                    totalRevenue
            );

            System.out.printf(
                    "Total Doctor Salary : ₹%.2f%n",
                    totalSalary
            );

            System.out.printf(
                    "Estimated Profit    : ₹%.2f%n",
                    profit
            );

            System.out.println(
                    "=========================================="
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error generating statistics: "
                            + e.getMessage()
            );
        }
    }

    // ========================= DEPARTMENT =========================

    private static Department selectDepartment() {

        System.out.println("\nSelect Department:");

        Department[] departments =
                Department.values();

        for (int i = 0; i < departments.length; i++) {

            System.out.println(
                    (i + 1) + ". "
                            + departments[i]
            );
        }

        while (true) {

            int choice =
                    readInt("Enter department choice: ");

            if (choice >= 1
                    && choice <= departments.length) {

                return departments[choice - 1];
            }

            System.out.println(
                    "Invalid department choice."
            );
        }
    }

    // ========================= INPUT METHODS =========================

    private static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                String input =
                        scanner.nextLine().trim();

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid integer."
                );
            }
        }
    }

    private static double readDouble(String message) {

        while (true) {

            try {

                System.out.print(message);

                String input =
                        scanner.nextLine().trim();

                return Double.parseDouble(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    private static String readString(String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty."
            );
        }
    }
}