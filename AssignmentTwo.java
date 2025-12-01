// HeyangLi-A2
// AssignmentTwo.java

// I acknowledge that I have not knowingly used GenAI to complete this assessment.

public class AssignmentTwo {

    public static void main(String[] args) {
        System.out.println("PROG2004 Assignment 2 - Theme Park Ride Visitor Management System (PRVMS)\n");

        AssignmentTwo assignment = new AssignmentTwo();

        assignment.partThree();
        assignment.printSeparator();

        assignment.partFourA();
        assignment.printSeparator();

        assignment.partFourB();
        assignment.printSeparator();

        assignment.partFive();
        assignment.printSeparator();

        assignment.partSix();
        assignment.printSeparator();

        assignment.partSeven();
        assignment.printSeparator();

        System.out.println("All parts demonstrated successfully.");
    }

    public void printSeparator() {
        System.out.println("------------------------------");
    }

    // Part 3 - Waiting Line (Queue)
    public void partThree() {
        System.out.println("Part 3 - Waiting Line (Queue)");

        Employee operator = new Employee("Alice Smith", 30, "Female", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Thunderbolt", "Roller Coaster", operator, 4);

        Visitor v1 = new Visitor("Tom", 25, "Male", "V101", true);
        Visitor v2 = new Visitor("Lisa", 22, "Female", "V102", true);
        Visitor v3 = new Visitor("Mike", 30, "Male", "V103", true);
        Visitor v4 = new Visitor("Emma", 19, "Female", "V104", true);
        Visitor v5 = new Visitor("James", 35, "Male", "V105", true);
        Visitor v6 = new Visitor("Sophie", 28, "Female", "V106", true);

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        rollerCoaster.addVisitorToQueue(v6);

        System.out.println("Current queue:");
        rollerCoaster.printQueue();

        rollerCoaster.removeVisitorFromQueue();
        System.out.println("After removing one visitor:");
        rollerCoaster.printQueue();
    }

    // Part 4A - Ride History
    public void partFourA() {
        System.out.println("Part 4A - Ride History");

        Employee operator = new Employee("Bob Jones", 40, "Male", "E002", "Supervisor");
        Ride ferrisWheel = new Ride("SkyView", "Ferris Wheel", operator, 6);

        Visitor v1 = new Visitor("Anna", 27, "Female", "V201", true);
        Visitor v2 = new Visitor("John", 32, "Male", "V202", true);
        Visitor v3 = new Visitor("Grace", 17, "Female", "V203", true);
        Visitor v4 = new Visitor("David", 45, "Male", "V204", true);
        Visitor v5 = new Visitor("Nina", 29, "Female", "V205", true);

        ferrisWheel.addVisitorToHistory(v1);
        ferrisWheel.addVisitorToHistory(v2);
        ferrisWheel.addVisitorToHistory(v3);
        ferrisWheel.addVisitorToHistory(v4);
        ferrisWheel.addVisitorToHistory(v5);

        ferrisWheel.numberOfVisitors();
        ferrisWheel.checkVisitorFromHistory(v3);
        ferrisWheel.checkVisitorFromHistory(new Visitor("Unknown", 99, "Other", "V999", false));

        System.out.println("Full ride history:");
        ferrisWheel.printRideHistory();
    }

    // Part 4B - Sorting Ride History
    public void partFourB() {
        System.out.println("Part 4B - Sorting Ride History");

        Employee operator = new Employee("Carol Lee", 35, "Female", "E003", "Operator");
        Ride dropTower = new Ride("FreeFall", "Drop Tower", operator, 8);

        dropTower.addVisitorToHistory(new Visitor("Zoe", 18, "Female", "V301", true));
        dropTower.addVisitorToHistory(new Visitor("Alex", 40, "Male", "V302", true));
        dropTower.addVisitorToHistory(new Visitor("Ben", 18, "Male", "V303", true));
        dropTower.addVisitorToHistory(new Visitor("Cathy", 25, "Female", "V304", true));
        dropTower.addVisitorToHistory(new Visitor("Aaron", 18, "Male", "V305", true));

        System.out.println("Before sorting:");
        dropTower.printRideHistory();

        dropTower.sortRideHistory();

        System.out.println("After sorting by age (then name):");
        dropTower.printRideHistory();
    }

    // Part 5 - Run One Cycle
    public void partFive() {
        System.out.println("Part 5 - Run One Cycle");

        Employee operator = new Employee("David Kim", 28, "Male", "E004", "Operator");
        Ride bumperCars = new Ride("Crash Arena", "Bumper Cars", operator, 4);

        for (int i = 1; i <= 12; i++) {
            Visitor v = new Visitor("Visitor" + i, 15 + (i % 20), i % 2 == 0 ? "Male" : "Female",
                    "V4" + String.format("%02d", i), true);
            bumperCars.addVisitorToQueue(v);
        }

        System.out.println("Initial queue (12 visitors):");
        bumperCars.printQueue();

        bumperCars.runOneCycle();

        System.out.println("After one cycle:");
        System.out.println("Remaining in queue:");
        bumperCars.printQueue();
        System.out.println("Ride history after cycle:");
        bumperCars.printRideHistory();
    }

    // Part 6 - Export to CSV
    public void partSix() {
        System.out.println("Part 6 - Writing Ride History to CSV File");

        Employee operator = new Employee("Emma Brown", 33, "Female", "E005", "Senior Operator");
        Ride logFlume = new Ride("Splash Mountain", "Log Flume", operator, 5);

        String[] names = {"Liam", "Olivia", "Noah", "Sophia", "Jackson"};
        int[] ages = {22, 19, 30, 26, 35};
        String[] genders = {"Male", "Female", "Male", "Female", "Male"};

        for (int i = 0; i < names.length; i++) {
            Visitor v = new Visitor(names[i], ages[i], genders[i], "V5" + (i + 1), true);
            logFlume.addVisitorToHistory(v);
        }

        logFlume.exportRideHistory("rideHistory.csv");
    }

    // Part 7 - Import from CSV
    public void partSeven() {
        System.out.println("Part 7 - Reading Ride History from CSV File");

        Employee operator = new Employee("Frank White", 42, "Male", "E006", "Manager");
        Ride ghostTrain = new Ride("Haunted Mansion", "Dark Ride", operator, 6);

        ghostTrain.importRideHistory("rideHistory.csv");

        System.out.println("Imported ride history count: " + ghostTrain.numberOfVisitors());
        System.out.println("Imported visitors:");
        ghostTrain.printRideHistory();
    }
}