package domain;

import components.Clock;

public class ReorderBufferElement {
    public InstructionElement currentInstruction;

    public ReorderBufferElement(Clock clock) {
        this.currentInstruction = null;
        clock.add((tick) -> this.onTick(tick));
    }

    public boolean isBusy() {
        return this.currentInstruction != null;
    }

    public boolean setInstruction(InstructionElement instruction) {
        boolean response = !this.isBusy();
        
        if (response) {
            this.currentInstruction = instruction;
        }

        return response;
    }

    private void onTick(Integer tick) {
        if (this.currentInstruction.status == StatusEnum.Commit) {
            this.currentInstruction = null;
        }
    }
}