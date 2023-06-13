package components;

import java.util.ArrayList;
import java.util.List;
import domain.ReservationStationElement;

public class ReservationStation {

    private Runnable runnable;
    private List<ReservationStationElement> data;

    public ReservationStation(Integer size, Runnable runnable) {
        this.data = new ArrayList<ReservationStationElement>(size);
        this.runnable = runnable;
    }

    public void addRSLoad(String name, Clock clock) {
        ReservationStationElement rs = new ReservationStationElement(name, 5, clock);
        rs.setFunction((instruction) -> {
            this.runnable.run();
        });
        this.data.add(rs);
    }

    public void addRSAdd(String name, Clock clock) {
        ReservationStationElement rs = new ReservationStationElement(name, 5, clock);
        rs.setFunction((instruction) -> {
            switch (instruction.instruction) {
                case ADD:
                    instruction.destiny.value = (byte) (instruction.valueA + instruction.valueB);
                    break;
                case SUB:
                    instruction.destiny.value = (byte) (instruction.valueA - instruction.valueB);
                    break;
            }
            this.runnable.run();
        });
        this.data.add(rs);
    }

    public void addRSMult(String name, Clock clock) {
        ReservationStationElement rs = new ReservationStationElement(name, 5, clock);
        rs.setFunction((instruction) -> {
            switch (instruction.instruction) {
                case MUL:
                    instruction.destiny.value = (byte) (instruction.valueA * instruction.valueB);
                    break;
                case DIV:
                    instruction.destiny.value = (byte) (instruction.valueA / instruction.valueB);
                    break;
            }
            this.runnable.run();
        });
        this.data.add(rs);
    }

    /* public boolean Add(InstructionElement instruction) {
        var type = instruction.instruction;
        for (var station : data) {
            if (!station.busy) {
                for (var acceptedTypes : station.acceptedTypes) {
                    if (acceptedTypes == type) {
                        station.busy = true;
                        station.currentInstruction = instruction;
                        return true;
                    }
                }
            }
        }
        return false;
    } */
}