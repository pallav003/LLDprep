package service.impl;

import controller.ElevatorController;
import dao.Direction;
import dao.Elevator;
import dao.Request;
import dao.Status;
import service.ElevatorSelectionStrategy;

import java.util.List;

class ClosestElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorController selectElevator(Request request, List<ElevatorController> controllers) {
        ElevatorController best = null;
        int minDistance = Integer.MAX_VALUE;

        for (ElevatorController controller : controllers) {
            Elevator elevator = controller.getElevator();
            int distance = Math.abs(elevator.getCurrentFloor() - request.sourceFloor);
            if (elevator.getStatus() == Status.IDLE ||
                    (elevator.getDirection() == request.direction &&
                            (request.direction == Direction.UP ? elevator.getCurrentFloor() <= request.sourceFloor :
                                    elevator.getCurrentFloor() >= request.sourceFloor))) {
                if (distance < minDistance) {
                    minDistance = distance;
                    best = controller;
                }
            }
        }
        return best != null ? best : controllers.get(0); // Fallback to first elevator
    }
}

