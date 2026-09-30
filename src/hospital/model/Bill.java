package hospital.model;

public class Bill implements Billable {

    private int billId;
    private int patientId;
    private double consultationFee;
    private double medicineFee;
    private double totalAmount;

    // Default constructor
    public Bill() {
    }

    // Parameterized constructor
    public Bill(int billId, int patientId,
                double consultationFee, double medicineFee) {

        this.billId = billId;
        this.patientId = patientId;
        this.consultationFee = consultationFee;
        this.medicineFee = medicineFee;

        this.totalAmount = calculateBill();
    }

    // Getters and setters

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double getMedicineFee() {
        return medicineFee;
    }

    public void setMedicineFee(double medicineFee) {
        this.medicineFee = medicineFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    // Interface method
    @Override
    public double calculateBill() {

        return consultationFee + medicineFee;
    }

    // Method overloading
    public double calculateBill(double discountPercent) {

        double total = calculateBill();

        /*
         * Operator precedence:
         * multiplication (*) and division (/)
         * are evaluated before subtraction (-).
         */
        return total - total * discountPercent / 100;
    }

    // Object class method overriding
    @Override
    public String toString() {

        return "Bill ID: " + billId
                + ", Patient ID: " + patientId
                + ", Consultation Fee: ₹" + consultationFee
                + ", Medicine Fee: ₹" + medicineFee
                + ", Total Amount: ₹" + totalAmount;
    }
}