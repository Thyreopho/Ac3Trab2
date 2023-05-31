import java.util.ArrayList;
import java.util.List;

import components.InstructionsQueue;
import components.ReorderBuffer;
import domain.RegisterElement;
import domain.ReorderBufferElement;
import domain.ReservationStationElement;

public class App {
    public static void main(String[] args) throws Exception {
        List<ReservationStationElement> reservationStation = new ArrayList<ReservationStationElement>(7);
        List<RegisterElement> registers = new ArrayList<RegisterElement>(10);

        int bufferSize = 6;
        InstructionsQueue instructionsQueue = InterfaceIO.readInstructions(bufferSize);
        ReorderBuffer reorderBuffer = new ReorderBuffer(bufferSize, instructionsQueue.read());
    }
}
