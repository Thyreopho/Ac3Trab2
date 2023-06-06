package components;

import domain.InstructionTypeEnum;
import domain.ReservationStationElement;

public class ReservationStation {

    private int size = 7;
    private ReservationStationElement[] data = new ReservationStationElement[size];

    public ReservationStation() {
        int aux = 0;
        data[aux].name = "Load1";
        data[aux].acceptedTypes[0] = InstructionTypeEnum.LW;
        data[aux].acceptedTypes[1] = InstructionTypeEnum.SW;
        aux++;

        data[aux].name = "Load2";
        data[aux].acceptedTypes[0] = InstructionTypeEnum.LW;
        data[aux].acceptedTypes[1] = InstructionTypeEnum.SW;
        aux++;

        data[aux].name = "Add1";
        data[aux].acceptedTypes[0] = InstructionTypeEnum.ADD;
        data[aux].acceptedTypes[1] = InstructionTypeEnum.ADDI;
        data[aux].acceptedTypes[2] = InstructionTypeEnum.SUB;
        aux++;

        data[aux].name = "Add2";
        data[aux].acceptedTypes[0] = InstructionTypeEnum.ADD;
        data[aux].acceptedTypes[1] = InstructionTypeEnum.ADDI;
        data[aux].acceptedTypes[2] = InstructionTypeEnum.SUB;
        aux++;
        
        data[aux].name = "Add3";
        data[aux].acceptedTypes[0] = InstructionTypeEnum.ADD;
        data[aux].acceptedTypes[1] = InstructionTypeEnum.ADDI;
        data[aux].acceptedTypes[2] = InstructionTypeEnum.SUB;
        aux++;
        
        data[aux].name = "Mult1";
        data[aux].acceptedTypes[0] = InstructionTypeEnum.MUL;
        data[aux].acceptedTypes[1] = InstructionTypeEnum.DIV;
        aux++;

        data[aux].name = "Mult2";
        data[aux].acceptedTypes[0] = InstructionTypeEnum.MUL;
        data[aux].acceptedTypes[1] = InstructionTypeEnum.DIV;

        for(int i = 0; i < size; i++){
            data[i].busy = false;
            data[i].currentInstruction = null;
        }     
    }

    
}