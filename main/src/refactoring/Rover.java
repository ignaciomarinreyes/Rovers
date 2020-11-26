package refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static refactoring.Rover.Order.*;

public class Rover {

    private ViewPoint viewPoint;

    public Rover(ViewPoint viewPoint) {
        this.viewPoint = viewPoint;
    }

    public ViewPoint viewPoint() {
        return viewPoint;
    }

    public void go(String instructions) {
        go(Arrays.stream(instructions.split("")).map(Order::of));
    }

    public void go(Order... orders) {
        go(Arrays.stream(orders));
    }

    private void go(Stream<Order> orders) {
        orders.filter(order -> order != null).forEach(order -> execute(order));
    }

    private void execute(Order order) {
        actions.get(order).execute();
    }

    private Map<Order, Action> actions = new HashMap<>();

    {
        actions.put(Left, this::turnLeft);
        actions.put(Right, this::turnRight);
        actions.put(Forward, this::forward);
        actions.put(Backward, this::backward);
    }

    private ViewPoint turnLeft() {
        return viewPoint.turnLeft();
    }

    private ViewPoint turnRight() {
        return viewPoint.turnRight();
    }

    private ViewPoint forward() {
        return viewPoint.forward();
    }

    private ViewPoint backward() {
        return viewPoint.backward();
    }

    @FunctionalInterface
    public interface Action {
        void execute();
    }

    public enum Order {
        Forward, Backward, Left, Right;

        static Order of(char c) {
            if (c == 'L') return Left;
            if (c == 'R') return Right;
            if (c == 'F') return Forward;
            if (c == 'B') return Backward;
            return null;
        }

        static Order of(String s) {
            return of(s.charAt(0));
        }

    }


}

