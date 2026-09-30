package hospital.model;

public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String appointmentDate;
    private String status;

    // Default constructor
    public Appointment() {
    }

    // Parameterized constructor
    public Appointment(int appointmentId, int patientId,
                       int doctorId, String appointmentDate,
                       String status) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    // Getters and setters

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Object class method overriding
    @Override
    public String toString() {

        return "Appointment ID: " + appointmentId
                + ", Patient ID: " + patientId
                + ", Doctor ID: " + doctorId
                + ", Appointment Date: " + appointmentDate
                + ", Status: " + status;
    }
}