import components.Clock;
import components.Register;
import components.ReorderBuffer;
import components.ReservationStation;

public class App {

    public static Integer bufferSize = 6;

    public static void main(String[] args) throws Exception {
        Clock clock = new Clock();
        Register register = new Register(10);
        ReorderBuffer reorderBuffer = new ReorderBuffer(InterfaceIO.readInstructions(bufferSize, clock), clock);
        ReservationStation reservationStation = new ReservationStation(8, reorderBuffer, clock);
        
        char key;
        do {
            InterfaceIO.renderTable(reorderBuffer, reservationStation, register);
            clock.tick();
            key = (char) System.in.read();
        } while (key != 'q' && key != 'Q');
    }
}
