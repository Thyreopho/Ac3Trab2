package domain;

public class InstructionElement {
    public InstructionTypeEnum instruction;
    public RegisterElement registerA;
    public Integer valueA;
    public RegisterElement registerB;
    public Integer valueB;
    public RegisterElement destiny;

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, RegisterElement paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = paramA;
        valueA = paramA.value;
        registerB = paramB;
        valueB = paramB.value;
        this.destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, Integer paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = paramA;
        valueA = paramA.value;
        registerB = null;
        valueB = paramB;
        this.destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, Integer paramA, RegisterElement paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = null;
        valueA = paramA;
        registerB = paramB;
        valueB = paramB.value;
        this.destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, Integer paramA, Integer paramB, RegisterElement destiny) {
        this.instruction = instruction;
        registerA = null;
        valueA = paramA;
        registerB = null;
        valueB = paramB;
        this.destiny = destiny;
    }
}