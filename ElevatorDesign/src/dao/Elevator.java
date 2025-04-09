package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private Status status;
    private List<Integer> requestQueue;
    private int capacity;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.NONE;
        this.status = Status.IDLE;
        this.requestQueue = new ArrayList<>();
        this.capacity = 8; // Max 8 people
    }

    public void move() {
        if (requestQueue.isEmpty()) {
            status = Status.IDLE;
            direction = Direction.NONE;
            return;
        }
        status = Status.MOVING;
        int nextFloor = requestQueue.get(0);
        direction = nextFloor > currentFloor ? Direction.UP : Direction.DOWN;
        System.out.println("Elevator " + id + " moving " + direction + " to floor " + nextFloor);
        currentFloor = nextFloor;
        stop();
    }

    public void stop() {
        status = Status.STOPPED;
        System.out.println("Elevator " + id + " stopped at floor " + currentFloor);
        openDoor();
        requestQueue.remove(0); // Process request
        closeDoor();
    }

    public void openDoor() {
        System.out.println("Elevator " + id + " doors open");
    }

    public void closeDoor() {
        System.out.println("Elevator " + id + " doors closed");
    }

    public void addRequest(int floor) {
        requestQueue.add(floor);
        Collections.sort(requestQueue, (a, b) -> direction == Direction.UP ? a - b : b - a);
    }

    // Getters
    public int getCurrentFloor() { return currentFloor; }
    public Direction getDirection() { return direction; }
    public Status getStatus() { return status; }
    public int getId() { return id; }
}