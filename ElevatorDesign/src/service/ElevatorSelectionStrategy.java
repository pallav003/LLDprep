package service;

import controller.ElevatorController;
import dao.Request;

import java.util.List;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(Request request, List<ElevatorController> controllers);
}
