package domain;

import java.util.function.Consumer;

import components.Clock;

public class ReservationStationElement {

    public String name;

    private InstructionElement currentInstruction;
    private Consumer<InstructionElement> function;

    private Integer tickOffset;
    private Integer targetTick;
    private Integer currTick;

    public ReservationStationElement(
            String name,
            Integer tickOffset,
            Clock clock) {
        this.name = name;

        this.currentInstruction = null;
        this.function = null;

        this.tickOffset = tickOffset;
        this.targetTick = 0;
        this.currTick = clock.getCurrTick();

        clock.add((tick) -> this.onTick(tick));
    }

    public boolean isBusy() {
        return this.currentInstruction != null;
    }

    public void setFunction(Consumer<InstructionElement> function) {
        this.function = function;
    }

    public boolean setInstruction(InstructionElement instruction) {
        boolean response = !this.isBusy();
        if (response) {
            this.targetTick = this.currTick + this.tickOffset;
            this.currentInstruction = instruction;
        }
        return response;
    }

    public void onTick(Integer tick) {
        this.currTick = tick;
        if (this.currTick == this.targetTick && this.function != null) {
            InstructionElement tmpCI = this.currentInstruction;
            this.currentInstruction = null;
            this.function.accept(tmpCI);
        }
    }
}