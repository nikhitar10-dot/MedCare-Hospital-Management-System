package hospital.service;

import hospital.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentService {

    // ================= BOOK APPOINTMENT =================

    public void bookAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointments "
                + "(patient_id, doctor_id, appointment_date, status) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getStatus());

            ps.executeUpdate();

            System.out.println(
                    "Appointment booked successfully."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error booking appointment: "
                            + e.getMessage()
            );
        }
    }

    // ================= VIEW APPOINTMENTS =================

    public void viewAppointments() {

        String sql = "SELECT * FROM appointments";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println(
                    "\n========== APPOINTMENT LIST =========="
            );

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "Appointment ID: "
                                + rs.getInt("appointment_id")
                                + " | Patient ID: "
                                + rs.getInt("patient_id")
                                + " | Doctor ID: "
                                + rs.getInt("doctor_id")
                                + " | Date: "
                                + rs.getString("appointment_date")
                                + " | Status: "
                                + rs.getString("status")
                );
            }

            if (!found) {
                System.out.println(
                        "No appointments found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error viewing appointments: "
                            + e.getMessage()
            );
        }
    }

    // ================= UPDATE APPOINTMENT STATUS =================

    public void updateAppointmentStatus(
            int appointmentId,
            String status) {

        String sql =
                "UPDATE appointments "
                + "SET status = ? "
                + "WHERE appointment_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, appointmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Appointment status updated successfully."
                );

            } else {

                System.out.println(
                        "Appointment not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error updating appointment: "
                            + e.getMessage()
            );
        }
    }

    // ================= DELETE APPOINTMENT =================

    public void deleteAppointment(int appointmentId) {

        String sql =
                "DELETE FROM appointments "
                + "WHERE appointment_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Appointment deleted successfully."
                );

            } else {

                System.out.println(
                        "Appointment not found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting appointment: "
                            + e.getMessage()
            );
        }
    }
}