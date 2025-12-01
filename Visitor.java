// Visitor.java
// Represents a visitor to the theme park

public class Visitor extends Person {
    private String visitorID;
    private boolean hasTicket;

    // Default constructor
    public Visitor() {
        super();
        this.visitorID = "V000";
        this.hasTicket = false;
    }

    // Parameterized constructor
    public Visitor(String name, int age, String gender, String visitorID, boolean hasTicket) {
        super(name, age, gender);
        this.visitorID = visitorID;
        this.hasTicket = hasTicket;
    }

    // Getters and Setters
    public String getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(String visitorID) {
        this.visitorID = visitorID;
    }

    public boolean hasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitorID='" + visitorID + '\'' +
                ", hasTicket=" + hasTicket +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", gender='" + getGender() + '\'' +
                '}';
    }
}