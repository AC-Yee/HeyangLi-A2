// RideInterface.java
// Interface defining operations for theme park rides

public interface RideInterface {
    void addVisitorToQueue(Visitor v);
    Visitor removeVisitorFromQueue();
    void printQueue();
    void addVisitorToHistory(Visitor v);
    boolean checkVisitorFromHistory(Visitor v);
    int numberOfVisitors();
    void printRideHistory();
    void runOneCycle();
}