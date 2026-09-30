package hospital.model;

public class Patient extends Person {

    private String bloodGroup;
    private String phone;
    private Department department;

    // Default constructor
    public Patient() {
        super();
    }

    // Parameterized constructor
    public Patient(int id, String name, int age, String gender,
                   String bloodGroup, String phone,
                   Department department) {

        super(id, name, age, gender);

        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.department = department;
    }

    // Getters and setters

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    // Method overriding
    @Override
    public void displayRole() {
        System.out.println("Role: Patient");
    }

    // Object class method overriding
    @Override
    public String toString() {

        return super.toString()
                + ", Blood Group: " + bloodGroup
                + ", Phone: " + phone
                + ", Department: " + department;
    }
}