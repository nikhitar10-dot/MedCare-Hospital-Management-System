package hospital.service;

import hospital.model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientService {

    // ================= ADD PATIENT =================

    public void addPatient(Patient patient) {

        String sql = "INSERT INTO patients "
                + "(name, age, gender, phone, blood_group, department) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getBloodGroup());
            ps.setString(6, patient.getDepartment().name());

            ps.executeUpdate();

            System.out.println(
                    "Patient registered successfully."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error registering patient: "
                            + e.getMessage()
            );
        }
    }

    // ================= VIEW PATIENTS =================

    public void viewPatients() {

        String sql = "SELECT * FROM patients";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println(
                    "\n========== PATIENT LIST =========="
            );

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "ID: " + rs.getInt("patient_id")
                        + " | Name: " + rs.getString("name")
                        + " | Age: " + rs.getInt("age")
                        + " | Gender: " + rs.getString("gender")
                        + " | Phone: " + rs.getString("phone")
                        + " | Blood Group: "
                        + rs.getString("blood_group")
                        + " | Department: "
                        + rs.getString("department")
                );
            }

            if (!found) {
                System.out.println("No patients found.");
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error viewing patients: "
                            + e.getMessage()
            );
        }
    }

    // ================= SEARCH PATIENT =================

    public void searchPatient(int patientId) {

        String sql =
                "SELECT * FROM patients WHERE patient_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    System.out.println(
                            "\n========== PATIENT FOUND =========="
                    );

                    System.out.println(
                            "ID: "
                                    + rs.getInt("patient_id")
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
                            "Phone: "
                                    + rs.getString("phone")
                    );

                    System.out.println(
                            "Blood Group: "
                                    + rs.getString("blood_group")
                    );

                    System.out.println(
                            "Department: "
                                    + rs.getString("department")
                    );

                } else {

                    System.out.println(
                            "Patient not found."
                    );
                }
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error searching patient: "
                            + e.getMessage()
            );
        }
    }

    // ================= UPDATE PATIENT =================

    public void updatePatient(Patient patient) {

        String sql =
                "UPDATE patients SET "
                + "name = ?, "
                + "age = ?, "
                + "gender = ?, "
                + "phone = ?, "
                + "blood_group = ?, "
                + "department = ? "
                + "WHERE patient_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getBloodGroup());
            ps.setString(6, patient.getDepartment().name());
            ps.setInt(7, patient.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Patient updated successfully."
                );

            } else {

                System.out.println(
                        "Patient not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating patient: "
                            + e.getMessage()
            );
        }
    }

    // ================= DELETE PATIENT =================

    public void deletePatient(int patientId) {

        String sql =
                "DELETE FROM patients WHERE patient_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Patient deleted successfully."
                );

            } else {

                System.out.println(
                        "Patient not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting patient: "
                            + e.getMessage()
            );
        }
    }
}