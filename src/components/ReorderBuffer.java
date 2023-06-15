package components;

import java.util.List;

import domain.InstructionElement;
import domain.ReorderBufferElement;
import domain.StatusEnum;

public class ReorderBuffer {

    private InstructionsQueue queue;
    private ReorderBufferElement[] reorderBuffer;

    public ReorderBuffer(InstructionsQueue queue, Clock clock) {
        this.reorderBuffer = new ReorderBufferElement[queue.bufferSize];
        this.queue = queue;

        List<InstructionElement> list = queue.read();
        for (int i = 0; i < list.size(); i++) {
            ReorderBufferElement value = new ReorderBufferElement(clock);
            value.currentInstruction = list.get(i);
            reorderBuffer[i] = value;
        }

        clock.add((tick) -> this.onTick(tick));
    }

    public boolean put(InstructionElement instruction) {
        boolean response = false;
        for (int i = 0; i < reorderBuffer.length && !response; i++) {
            response = reorderBuffer[i].setInstruction(instruction);
        }
        return response;
    }

    public InstructionElement get() {
        InstructionElement response = null;
        for (int i = 0; i < reorderBuffer.length && response == null; i++) {
            response = reorderBuffer[i].currentInstruction;
            if (response == null || response.status != StatusEnum.NotInitiated || response.haveDependency()) {
                response = null;
            }
        }
        return response;
    }

    private void onTick(Integer tick) {
        if (this.put(queue.read(1).get(0))) {
            queue.next(1);
        }
    }

    public int size() {
        return this.reorderBuffer.length;
    }

    public void print(int index) {
        var data = this.reorderBuffer[index];
        
    }
}
