package hospital.service;

import hospital.model.Bill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillService {

    // ================= ADD BILL =================

    public void addBill(Bill bill) {

        String sql = "INSERT INTO bills "
                + "(patient_id, consultation_fee, medicine_fee, total_amount) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getPatientId());
            ps.setDouble(2, bill.getConsultationFee());
            ps.setDouble(3, bill.getMedicineFee());
            ps.setDouble(4, bill.getTotalAmount());

            ps.executeUpdate();

            System.out.println(
                    "Bill generated successfully."
            );

        } catch (SQLException e) {

            System.out.println(
                    "Error generating bill: "
                            + e.getMessage()
            );
        }
    }

    // ================= VIEW BILLS =================

    public void viewBills() {

        String sql = "SELECT * FROM bills";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println(
                    "\n========== BILL LIST =========="
            );

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                        "Bill ID: "
                                + rs.getInt("bill_id")
                                + " | Patient ID: "
                                + rs.getInt("patient_id")
                                + " | Consultation Fee: ₹"
                                + rs.getDouble("consultation_fee")
                                + " | Medicine Fee: ₹"
                                + rs.getDouble("medicine_fee")
                                + " | Total Amount: ₹"
                                + rs.getDouble("total_amount")
                );
            }

            if (!found) {

                System.out.println(
                        "No bills found."
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error viewing bills: "
                            + e.getMessage()
            );
        }
    }
}