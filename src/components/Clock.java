package components;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Clock {

    private Integer tick;
    private List<Consumer<Integer>> listeners;

    public Clock() {
        tick = 0;
        listeners = new ArrayList<Consumer<Integer>>();
    }

    public Integer getCurrTick() {
        return tick;
    }

    public void tick() {
        for (Consumer<Integer> listener : listeners) {
            listener.accept(tick);
        }
        tick++;
    }

    public boolean add(Consumer<Integer> e) {
        return listeners.add(e);
    }

    public boolean remove(Object o) {
        return listeners.remove(o);
    }
}