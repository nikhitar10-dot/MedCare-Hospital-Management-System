package hospital.model;

public class Doctor extends Person {

    private String specialization;
    private Department department;
    private String phone;
    private double consultationFee;
    private double salary;

    // Default constructor
    public Doctor() {
        super();
    }

    // Parameterized constructor
    public Doctor(int id, String name, int age, String gender,
                  String specialization, Department department,
                  String phone, double consultationFee,
                  double salary) {

        super(id, name, age, gender);

        this.specialization = specialization;
        this.department = department;
        this.phone = phone;
        this.consultationFee = consultationFee;
        this.salary = salary;
    }

    // Getters and setters

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Method overriding
    @Override
    public void displayRole() {
        System.out.println("Role: Doctor");
    }

    // Object class method overriding
    @Override
    public String toString() {

        return super.toString()
                + ", Specialization: " + specialization
                + ", Department: " + department
                + ", Phone: " + phone
                + ", Consultation Fee: ₹" + consultationFee
                + ", Salary: ₹" + salary;
    }
}