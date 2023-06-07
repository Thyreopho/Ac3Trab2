package components;

import java.util.List;

import domain.InstructionElement;
import domain.ReorderBufferElement;

public class ReorderBuffer {
    private ReorderBufferElement[] reorderBuffer;

    public ReorderBuffer(int size, List<InstructionElement> list) {
        this.reorderBuffer = new ReorderBufferElement[size];
        for (int i = 0; i < reorderBuffer.length; i++) {
            this.set(i, list.get(i));
        }
    }

    public int size() {
        return reorderBuffer.length;
    }

    public ReorderBufferElement get(int index) {
        return reorderBuffer[index];
    }

    public void set(int index, InstructionElement instruction) {
        ReorderBufferElement value = new ReorderBufferElement();
        value.currentInstruction = instruction;
        reorderBuffer[index] = value;
    }

    public InstructionElement remove(int index) {
        InstructionElement removed = get(index).currentInstruction;
        set(index, null);
        return removed;
    }

    public InstructionElement replace(int index, InstructionElement instruction) {
        InstructionElement removed = get(index).currentInstruction;
        set(index, instruction);
        return removed;
    }
}
