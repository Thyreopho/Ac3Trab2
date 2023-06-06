package domain;

public class ReservationStationElement {
    public String name;
    public InstructionTypeEnum[] acceptedTypes;
    public boolean busy;
    public InstructionElement currentInstruction;

    public ReservationStationElement(String name, InstructionTypeEnum[] acceptedTypes) {
        this.name = name;
        this.acceptedTypes = acceptedTypes;
        busy = false;
        currentInstruction = null;
    }
}