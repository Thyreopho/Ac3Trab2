import java.util.ArrayList;
import java.util.List;

import components.InstructionsQueue;
import components.Register;
import components.ReorderBuffer;
import components.ReservationStation;
import domain.RegisterElement;
import domain.StatusEnum;

public class App {
    public static void main(String[] args) throws Exception {
        ReservationStation reservationStation = new ReservationStation(7, () -> {
            // On value returned -> render screen
        });
        Register registers = new Register(10);
        
        int bufferSize = 6;
        InstructionsQueue instructionsQueue = InterfaceIO.readInstructions(bufferSize);
        ReorderBuffer reorderBuffer = new ReorderBuffer(bufferSize, instructionsQueue.read());
        
        //Teste da interface - Buffer de reordenação
        for(int i = 0; i < 10; i++){

        }

        //Teste da interface - Estação de reserva


        //Teste da interface - Registrador
        RegisterElement registador = new RegisterElement();
        registador.value = 10;
        registador.busy = true;
        for(int i = 0; i < 10; i++){
            registers.set(i, registador);
        }

        //chamada de teste da interface
        InterfaceIO.renderTable(reorderBuffer, reservationStation, registers);
    }

    public void funcaoTempo(){
        ReservationStation reservationStation = new ReservationStation(null, null);
        Register registers = new Register(10);
        
        int bufferSize = 6;
        InstructionsQueue instructionsQueue = InterfaceIO.readInstructions(bufferSize);
        ReorderBuffer reorderBuffer = new ReorderBuffer(bufferSize, instructionsQueue.read());

        int pointerReorderBuffer = 0;
        if(reorderBuffer.size() > 0){
            Boolean inserted = false;
            var item = reorderBuffer.get(pointerReorderBuffer);
            //inserted = reservationStation.Add(item.currentInstruction);
            if(inserted){
                item.state = StatusEnum.Commit;
            }
            pointerReorderBuffer++;


        }
    }

}
