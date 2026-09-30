package hospital.model;

public abstract class Person {

    // Encapsulated instance variables
    private int id;
    private String name;
    private int age;
    private String gender;

    // Default constructor
    public Person() {
    }

    // Parameterized constructor
    public Person(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Abstract method
    public abstract void displayRole();

    // Object class method overriding
    @Override
    public String toString() {

        return "ID: " + id
                + ", Name: " + name
                + ", Age: " + age
                + ", Gender: " + gender;
    }
}