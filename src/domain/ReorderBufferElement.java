package domain;

public class ReorderBufferElement {
    public boolean busy;
    public InstructionElement currentInstruction;
    public StatusEnum state;

    public ReorderBufferElement() {
        busy = false;
        currentInstruction = null;
        state = StatusEnum.NotInitiated;
    }
}