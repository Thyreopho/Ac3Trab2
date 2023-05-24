package domain;

public class ReorderBufferElement {
    public boolean Busy;
    public Process CurrentProcess;

    public ReorderBufferElement() {
        Busy = false;
        CurrentProcess = null;
    }
}