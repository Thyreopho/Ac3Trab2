package domain;

public class InstructionElement {
    public InstructionTypeEnum Instruction;
    public RegisterElement RegisterA;
    public Integer ValueA;
    public RegisterElement RegisterB;
    public Integer ValueB;
    public RegisterElement Destiny;

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, RegisterElement paramB, RegisterElement destiny) {
        Instruction = instruction;
        RegisterA = paramA;
        ValueA = paramA.Value;
        RegisterB = paramB;
        ValueB = paramB.Value;
        Destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, RegisterElement paramA, Integer paramB, RegisterElement destiny) {
        Instruction = instruction;
        RegisterA = paramA;
        ValueA = paramA.Value;
        RegisterB = null;
        ValueB = paramB;
        Destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, Integer paramA, RegisterElement paramB, RegisterElement destiny) {
        Instruction = instruction;
        RegisterA = null;
        ValueA = paramA;
        RegisterB = paramB;
        ValueB = paramB.Value;
        Destiny = destiny;
    }

    public InstructionElement(InstructionTypeEnum instruction, Integer paramA, Integer paramB, RegisterElement destiny) {
        Instruction = instruction;
        RegisterA = null;
        ValueA = paramA;
        RegisterB = null;
        ValueB = paramB;
        Destiny = destiny;
    }
}