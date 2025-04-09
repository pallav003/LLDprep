import dao.Direction;
import service.impl.ElevatorSystem;

public class ElevatorDemo {
    public static void main(String[] args) {
        ElevatorSystem system = ElevatorSystem.getInstance();
        system.addElevator(1);
        system.addElevator(2);

        // External requests
        system.requestElevator(5, Direction.UP);
        system.requestElevator(3, Direction.DOWN);

        // Internal request
        system.selectDestination(1, 10);
    }
}