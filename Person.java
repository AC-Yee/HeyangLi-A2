// Person.java
// Abstract base class for all persons in the theme park

public abstract class Person {
    private String name;
    private int age;
    private String gender;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
    }

    // Parameterized constructor
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", gender='" + gender + "'}";
    }
}