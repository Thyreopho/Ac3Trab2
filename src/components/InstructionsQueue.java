package components;

import java.util.List;
import java.util.stream.Collectors;

import domain.InstructionElement;

//TODO: não descartar elementos da fila, a mesma deve permitir desvios para linhas anteriores
public class InstructionsQueue {

    public Integer bufferSize;
    private List<InstructionElement> data;

    public InstructionsQueue(int bufferSize, List<InstructionElement> data) {
        this.bufferSize = bufferSize;
        this.data = data;
    }

    public List<InstructionElement> read() {
        return this.data
                .stream()
                .limit(this.bufferSize)
                .collect(Collectors.toList());
    }

    public List<InstructionElement> read(int limit) {
        return this.data
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public void next() {
        this.data.subList(0, this.bufferSize - 1).clear();
    }

    public void next(int jump) {
        this.data.subList(0, jump).clear();
    }
}