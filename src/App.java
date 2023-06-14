import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import components.Clock;
import components.InstructionsQueue;
import components.Register;
import components.ReorderBuffer;
import components.ReservationStation;

public class App {

    public static Integer bufferSize = 6;

    public static void main(String[] args) throws Exception {
        Clock clock = new Clock();
        InstructionsQueue instructionsQueue = InterfaceIO.readInstructions(bufferSize);/*
        Register register = new Register(10);
        ReorderBuffer reorderBuffer = new ReorderBuffer(bufferSize, instructionsQueue.read());
        ReservationStation reservationStation = new ReservationStation(8, (rs) -> {
            InterfaceIO.renderTable(reorderBuffer, rs, register);
        });
        
        char key;
        do {
            InterfaceIO.renderTable(reorderBuffer, reservationStation, register);
            clock.tick();
            key = (char) System.in.read();
        } while (key != 'q' && key != 'Q');*/
    }
}
