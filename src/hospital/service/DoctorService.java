package hospital.service;

import hospital.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorService {

    // ================= ADD DOCTOR =================

    public void addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors "
                + "(name, age, gender, specialization, department, phone, consultation_fee, salary) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getName());
            ps.setInt(2, doctor.getAge());
            ps.setString(3, doctor.getGender());
            ps.setString(4, doctor.getSpecialization());
            ps.setString(5, doctor.getDepartment().name());
            ps.setString(6, doctor.getPhone());
            ps.setDouble(7, doctor.getConsultationFee());
            ps.setDouble(8, doctor.getSalary());

            ps.executeUpdate();

            System.out.println("Doctor registered successfully.");

        } catch (SQLException e) {

            System.out.println(
                    "Error registering doctor: "
                            + e.getMessage()
            );
        }
    }

    // ================= VIEW DOCTORS =================

    public void viewDoctors() {

        String sql = "SELECT * FROM doctors";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== DOCTOR LIST ==========");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "ID: " + rs.getInt("doctor_id")
                        + " | Name: " + rs.getString("name")
                        + " | Age: " + rs.getInt("age")
                        + " | Gender: " + rs.getString("gender")
                        + " | Specialization: "
                        + rs.getString("specialization")
                        + " | Department: "
                        + rs.getString("department")
                        + " | Phone: "
                        + rs.getString("phone")
                        + " | Fee: ₹"
                        + rs.getDouble("consultation_fee")
                        + " | Salary: ₹"
                        + rs.getDouble("salary")
                );
            }

            if (!found) {
                System.out.println("No doctors found.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error viewing doctors: "
                            + e.getMessage()
            );
        }
    }

    // ================= SEARCH DOCTOR =================

    public void searchDoctor(int doctorId) {

        String sql =
                "SELECT * FROM doctors WHERE doctor_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println(
                            "\n========== DOCTOR FOUND =========="
                    );

                    System.out.println(
                            "ID: "
                                    + rs.getInt("doctor_id")
                    );

                    System.out.println(
                            "Name: "
                                    + rs.getString("name")
                    );

                    System.out.println(
                            "Age: "
                                    + rs.getInt("age")
                    );

                    System.out.println(
                            "Gender: "
                                    + rs.getString("gender")
                    );

                    System.out.println(
                            "Specialization: "
                                    + rs.getString("specialization")
                    );

                    System.out.println(
                            "Department: "
                                    + rs.getString("department")
                    );

                    System.out.println(
                            "Phone: "
                                    + rs.getString("phone")
                    );

                    System.out.println(
                            "Consultation Fee: ₹"
                                    + rs.getDouble(
                                            "consultation_fee")
                    );

                    System.out.println(
                            "Salary: ₹"
                                    + rs.getDouble("salary")
                    );

                } else {

                    System.out.println(
                            "Doctor not found."
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error searching doctor: "
                            + e.getMessage()
            );
        }
    }

    // ================= DELETE DOCTOR =================

    public void deleteDoctor(int doctorId) {

        String sql =
                "DELETE FROM doctors WHERE doctor_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Doctor deleted successfully."
                );

            } else {

                System.out.println(
                        "Doctor not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting doctor: "
                            + e.getMessage()
            );
        }
    }
}