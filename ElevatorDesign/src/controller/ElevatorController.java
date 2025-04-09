package controller;


import dao.Elevator;
import dao.Request;

public class ElevatorController {
    private Elevator elevator;

    public ElevatorController(int id) {
        this.elevator = new Elevator(id);
    }

    public void acceptRequest(Request request) {
        if (request.destinationFloor != 0) {
            elevator.addRequest(request.destinationFloor);
        } else {
            elevator.addRequest(request.sourceFloor);
        }
        controlElevator();
    }

    public void controlElevator() {
        elevator.move();
    }

    public Elevator getElevator() { return elevator; }
}

