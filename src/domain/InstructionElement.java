package domain;

public class InstructionElement {
    public InstructionTypeEnum instruction;
    public RegisterElement registerA;
    public Byte valueA;
    public RegisterElement registerB;
    public Byte valueB;
    public RegisterElement destiny;

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, RegisterElement paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = paramA;
        valueA = paramA.value;
        registerB = paramB;
        valueB = paramB.value;
        this.destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, Byte paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = paramA;
        valueA = paramA.value;
        registerB = null;
        valueB = paramB;
        this.destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, Byte paramA, RegisterElement paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = null;
        valueA = paramA;
        registerB = paramB;
        valueB = paramB.value;
        this.destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, Byte paramA, Byte paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = null;
        valueA = paramA;
        registerB = null;
        valueB = paramB;
        this.destiny = destiny;
    }
}