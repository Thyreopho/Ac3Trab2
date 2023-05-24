package domain;

public class ReservationStationElement {
    public String Name;
    public InstructionTypeEnum[] AcceptedTypes;
    public boolean Busy;
    public InstructionElement CurrentInstruction;

    public ReservationStationElement(String name, InstructionTypeEnum[] acceptedTypes) {
        Name = name;
        AcceptedTypes = acceptedTypes;
        Busy = false;
        CurrentInstruction = null;
    }
}