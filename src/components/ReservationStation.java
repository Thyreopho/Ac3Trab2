package components;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import domain.InstructionElement;
import domain.InstructionTypeEnum;
import domain.ReservationStationElement;

public class ReservationStation {

    private Consumer<ReservationStation> runnable;
    private List<ReservationStationElement> data;

    public ReservationStation(Integer size, Consumer<ReservationStation> runnable) {
        this.data = new ArrayList<ReservationStationElement>(size);
        this.runnable = runnable;
    }

    public void addRSLoad(String name, Clock clock) {
        InstructionTypeEnum[] restrains = {
            InstructionTypeEnum.LW,
            InstructionTypeEnum.SW
        };
        ReservationStationElement rs = new ReservationStationElement(name, 5, clock, restrains);
        rs.setFunction((instruction) -> {
            this.runnable.accept(this);
        });
        this.data.add(rs);
    }

    public void addRSAdd(String name, Clock clock) {
        InstructionTypeEnum[] restrains = {
            InstructionTypeEnum.ADD,
            InstructionTypeEnum.SUB
        };
        ReservationStationElement rs = new ReservationStationElement(name, 5, clock, restrains);
        rs.setFunction((instruction) -> {
            switch (instruction.instruction) {
                case ADD:
                    instruction.destiny.value = (byte) (instruction.valueA + instruction.valueB);
                    break;
                case SUB:
                    instruction.destiny.value = (byte) (instruction.valueA - instruction.valueB);
                    break;
            }
            this.runnable.accept(this);
        });
        this.data.add(rs);
    }

    public void addRSMult(String name, Clock clock) {
        InstructionTypeEnum[] restrains = {
            InstructionTypeEnum.MUL,
            InstructionTypeEnum.DIV
        };
        ReservationStationElement rs = new ReservationStationElement(name, 5, clock, restrains);
        rs.setFunction((instruction) -> {
            switch (instruction.instruction) {
                case MUL:
                    instruction.destiny.value = (byte) (instruction.valueA * instruction.valueB);
                    break;
                case DIV:
                    instruction.destiny.value = (byte) (instruction.valueA / instruction.valueB);
                    break;
            }
            this.runnable.accept(this);
        });
        this.data.add(rs);
    }

    public boolean put(InstructionElement instruction) {
        boolean response = false;
        for (int i = 0; i < data.size() && !response; i++) {
            response = data.get(i).setInstruction(instruction);
        }
        return response;
    }
}