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
        set(go(Arrays.stream(orders)));
    }

    private void set(ViewPoint viewPoint){
        if(viewPoint == null) return;
        this.viewPoint = viewPoint;
    }

    private ViewPoint go(Stream<Order> orders) {
        return orders.filter(order -> order != null)
                .reduce(this.viewPoint, this::execute, (viewPoint, viewPoint2) -> null);
    }

   private ViewPoint execute(ViewPoint viewPoint, Order order){
        if(viewPoint == null) return null;
        return actions.get(order).execute(viewPoint);
   }

    private Map<Order, Action> actions = new HashMap<>();

    {
        actions.put(Left, this::turnLeft);
        actions.put(Right, this::turnRight);
        actions.put(Forward, this::forward);
        actions.put(Backward, this::backward);
    }

    private ViewPoint turnLeft(ViewPoint viewPoint) {
        return viewPoint.turnLeft();
    }

    private ViewPoint turnRight(ViewPoint viewPoint) {
        return viewPoint.turnRight();
    }

    private ViewPoint forward(ViewPoint viewPoint) {
        return viewPoint.forward();
    }

    private ViewPoint backward(ViewPoint viewPoint) {
        return viewPoint.backward();
    }

    @FunctionalInterface
    public interface Action {
        ViewPoint execute(ViewPoint viewPoint);
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

