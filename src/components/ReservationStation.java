package components;

import java.util.ArrayList;
import java.util.List;

import domain.InstructionElement;
import domain.InstructionTypeEnum;
import domain.ReservationStationElement;
import domain.StatusEnum;

public class ReservationStation {

    private List<ReservationStationElement> data;
    private ReorderBuffer reorderBuffer;

    public ReservationStation(Integer size, ReorderBuffer reorderBuffer, Clock clock) {
        this.data = new ArrayList<ReservationStationElement>(size);
        this.reorderBuffer = reorderBuffer;
        clock.add((tick) -> this.onTick(tick));
    }

    public void addRSLoad(String name, Clock clock) {
        InstructionTypeEnum[] restrains = {
            InstructionTypeEnum.LW,
            InstructionTypeEnum.SW
        };
        ReservationStationElement rs = new ReservationStationElement(name, 5, clock, restrains);
        rs.setFunction((instruction) -> {
            this.commit(instruction);
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
            this.commit(instruction);
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
            this.commit(instruction);
        });
        this.data.add(rs);
    }

    private void commit(InstructionElement instruction) {
        instruction.status = StatusEnum.Commit;
    }

    public boolean put(InstructionElement instruction) {
        boolean response = false;
        for (int i = 0; i < data.size() && !response; i++) {
            response = data.get(i).setInstruction(instruction);
        }
        return response;
    }

    private void onTick(Integer tick) {
        InstructionElement instructionElement = reorderBuffer.get();
        if (instructionElement != null) {
            this.put(instructionElement);
        }
    }

    public int size() {
        return this.data.size();
    }
}