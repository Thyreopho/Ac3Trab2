package domain;

import components.Clock;

public class ReservationStationElement {
    public String name;
    public InstructionTypeEnum[] acceptedTypes;
    public boolean busy;
    private InstructionElement currentInstruction;

    private Integer tickOffset;
    private Integer targetTick;
    private Integer currTick;

    public ReservationStationElement(String name, InstructionTypeEnum[] acceptedTypes, Integer tickOffset, Clock clock) {
        this.name = name;
        this.acceptedTypes = acceptedTypes;
        this.busy = false;
        this.currentInstruction = null;

        this.tickOffset = tickOffset;
        this.currTick = clock.getCurrTick();
        this.targetTick = 0;
        clock.add((tick) -> this.onTick(tick));
    }

    public void setInstruction(InstructionElement instruction) {
        this.targetTick = this.currTick + this.tickOffset;
        this.currentInstruction = instruction;
    }

    public void onTick(Integer tick) {
        this.currTick = tick;
        if (this.currTick == this.targetTick) {
            //Execute
        }
    }
}