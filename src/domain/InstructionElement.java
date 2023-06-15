package domain;

import components.Clock;

public class InstructionElement {
    
    public InstructionTypeEnum instruction;
    public RegisterElement registerA;
    public Byte valueA;
    public RegisterElement registerB;
    public Byte valueB;
    public RegisterElement destiny;

    public StatusEnum status;

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, RegisterElement paramB, RegisterElement destiny, Clock clock) {
        this.instruction = instruction;
        registerA = paramA;
        valueA = paramA.value;
        registerB = paramB;
        valueB = paramB.value;
        this.destiny = destiny;
        this.status = StatusEnum.NotInitiated;
        clock.add((tick) -> this.onTick(tick));
    }

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, Byte paramB, RegisterElement destiny, Clock clock) {
        this.instruction = instruction;
        registerA = paramA;
        valueA = paramA.value;
        registerB = null;
        valueB = paramB;
        this.destiny = destiny;
        this.status = StatusEnum.NotInitiated;
        clock.add((tick) -> this.onTick(tick));
    }

    public InstructionElement(InstructionTypeEnum instruction, Byte paramA, RegisterElement paramB, RegisterElement destiny, Clock clock) {
        this.instruction = instruction;
        registerA = null;
        valueA = paramA;
        registerB = paramB;
        valueB = paramB.value;
        this.destiny = destiny;
        this.status = StatusEnum.NotInitiated;
        clock.add((tick) -> this.onTick(tick));
    }

    public InstructionElement(InstructionTypeEnum instruction, Byte paramA, Byte paramB, RegisterElement destiny, Clock clock) {
        this.instruction = instruction;
        registerA = null;
        valueA = paramA;
        registerB = null;
        valueB = paramB;
        this.destiny = destiny;
        this.status = StatusEnum.NotInitiated;
        clock.add((tick) -> this.onTick(tick));
    }

    public boolean haveDependency() {
        return this.valueA == null || this.valueB == null;
    }

    private void onTick(Integer tick) {
        if (this.registerA != null) {
            this.valueA = this.registerA.value;
        }
        if (this.registerB != null) {
            this.valueB = this.registerB.value;
        }
    }
}