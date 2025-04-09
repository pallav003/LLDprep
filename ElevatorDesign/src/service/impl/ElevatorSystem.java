package service.impl;

import controller.ElevatorController;
import dao.Direction;
import dao.Request;
import service.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private static ElevatorSystem instance;
    private List<ElevatorController> controllers;
    private ElevatorSelectionStrategy strategy;

    private ElevatorSystem() {
        controllers = new ArrayList<>();
        strategy = new ClosestElevatorStrategy();
    }

    public static ElevatorSystem getInstance() {
        if (instance == null) {
            instance = new ElevatorSystem();
        }
        return instance;
    }

    public void addElevator(int id) {
        controllers.add(new ElevatorController(id));
    }

    public void requestElevator(int floor, Direction direction) {
        Request request = new Request(floor, direction);
        ElevatorController controller = strategy.selectElevator(request, controllers);
        System.out.println("Assigned elevator " + controller.getElevator().getId() + " for request from floor " + floor);
        controller.acceptRequest(request);
    }

    public void selectDestination(int elevatorId, int destinationFloor) {
        Request request = new Request(destinationFloor);
        for (ElevatorController controller : controllers) {
            if (controller.getElevator().getId() == elevatorId) {
                controller.acceptRequest(request);
                break;
            }
        }
    }
}

