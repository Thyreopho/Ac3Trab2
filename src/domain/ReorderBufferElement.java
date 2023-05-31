package domain;

public class ReorderBufferElement {
    public boolean busy;
    public InstructionElement currentInstruction;

    public ReorderBufferElement() {
        busy = false;
        currentInstruction = null;
    }
}