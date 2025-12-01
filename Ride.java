// Ride.java
// Main ride class implementing all required functionality with full encapsulation

import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private String rideType;
    private Employee operator;
    private final int maxRider;        // immutable after construction
    private int numOfCycles = 0;

    private Queue<Visitor> waitingQueue = new LinkedList<>();
    private LinkedList<Visitor> rideHistory = new LinkedList<>();

    // Default constructor
    public Ride() {
        this.rideName = "Unnamed Ride";
        this.rideType = "Unknown";
        this.operator = null;
        this.maxRider = 4;
    }

    // Parameterized constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    // === Getters and Setters (ALL non-final fields have setters) ===
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getMaxRider() { return maxRider; }  // no setter - final

    public int getNumOfCycles() { return numOfCycles; }
    // no setter for numOfCycles - managed internally

    // === RideInterface Methods ===
    @Override
    public void addVisitorToQueue(Visitor v) {
        if (v != null && v.hasTicket()) {
            waitingQueue.add(v);
            System.out.println("Visitor " + v.getVisitorID() + " (" + v.getName() + ") added to queue for " + rideName);
        } else {
            System.out.println("Cannot add visitor: invalid or no ticket.");
        }
    }

    @Override
    public Visitor removeVisitorFromQueue() {
        Visitor v = waitingQueue.poll();
        if (v != null) {
            System.out.println("Visitor " + v.getVisitorID() + " (" + v.getName() + ") removed from queue");
        } else {
            System.out.println("Queue is empty. No visitor removed.");
        }
        return v;
    }

    @Override
    public void printQueue() {
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue is empty.");
            return;
        }
        System.out.println("Current waiting queue for " + rideName + ":");
        int position = 1;
        for (Visitor v : waitingQueue) {
            System.out.println(position++ + ". " + v);
        }
    }

    @Override
    public void addVisitorToHistory(Visitor v) {
        if (v != null) {
            rideHistory.add(v);
            System.out.println("Visitor " + v.getVisitorID() + " added to ride history");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor v) {
        boolean found = rideHistory.contains(v);
        System.out.println("Visitor " + (v != null ? v.getVisitorID() : "null") +
                (found ? " HAS " : " has NOT ") + "ridden " + rideName);
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Total visitors who have ridden " + rideName + ": " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No ride history available for " + rideName);
            return;
        }
        System.out.println("Ride History for " + rideName + " (" + rideHistory.size() + " visitors):");
        int index = 1;
        for (Visitor v : rideHistory) {
            System.out.println(index++ + ". " + v);
        }
    }

    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history sorted successfully by age, then name.");
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Cannot run cycle: No operator assigned to " + rideName);
            return;
        }
        if (waitingQueue.isEmpty()) {
            System.out.println("Cannot run cycle: Queue is empty for " + rideName);
            return;
        }

        System.out.println("Running one cycle of " + rideName + " (max " + maxRider + " riders)");
        int ridersThisCycle = 0;
        while (ridersThisCycle < maxRider && !waitingQueue.isEmpty()) {
            Visitor v = waitingQueue.poll();
            rideHistory.add(v);
            ridersThisCycle++;
            System.out.println("  Rider " + ridersThisCycle + ": " + v.getName() + " (ID: " + v.getVisitorID() + ")");
        }
        numOfCycles++;
        System.out.println("Cycle " + numOfCycles + " completed. " + ridersThisCycle + " visitors rode.");
    }

    public void exportRideHistory(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("visitorID,name,age,gender,hasTicket\n");
            for (Visitor v : rideHistory) {
                writer.write(String.format("%s,%s,%d,%s,%b%n",
                        v.getVisitorID(), v.getName(), v.getAge(), v.getGender(), v.hasTicket()));
            }
            System.out.println("Ride history exported successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        rideHistory.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.readLine(); // skip header
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    try {
                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        int age = Integer.parseInt(parts[2].trim());
                        String gender = parts[3].trim();
                        boolean hasTicket = Boolean.parseBoolean(parts[4].trim());
                        Visitor v = new Visitor(name, age, gender, id, hasTicket);
                        rideHistory.add(v);
                        count++;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age format in line: " + line);
                    }
                }
            }
            System.out.println("Successfully imported " + count + " visitors from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}