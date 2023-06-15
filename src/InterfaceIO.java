import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import components.Clock;
import components.InstructionsQueue;
import components.ReorderBuffer;
import components.ReservationStation;
import domain.InstructionElement;
import domain.InstructionTypeEnum;
import domain.RegisterElement;
import components.Register;

public class InterfaceIO {

    public static InstructionsQueue readInstructions(int bufferSize, Clock clock) throws IOException {
        ArrayList<InstructionElement> instructionList = new ArrayList<InstructionElement>(0);

        BufferedReader buffRead = new BufferedReader(new FileReader("C:\\Users\\felip\\Desktop\\AC3\\Ac3Trab2\\Trace.txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
                String[] infs = linha.split(" ");
                if(infs.length > 2){
                    InstructionTypeEnum command = infs[0].equals(InstructionTypeEnum.ADD.toString()) ? InstructionTypeEnum.ADD : infs[0].equals(InstructionTypeEnum.SUB.toString()) ? InstructionTypeEnum.SUB : infs[0].equals(InstructionTypeEnum.ADDI.toString()) ? InstructionTypeEnum.ADDI : infs[0].equals(InstructionTypeEnum.MUL.toString()) ? InstructionTypeEnum.MUL : infs[0].equals(InstructionTypeEnum.DIV.toString()) ? InstructionTypeEnum.DIV : infs[0].equals(InstructionTypeEnum.LW.toString()) ? InstructionTypeEnum.LW : infs[0].equals(InstructionTypeEnum.SW.toString()) ? InstructionTypeEnum.SW : infs[0].equals(InstructionTypeEnum.J.toString()) ? InstructionTypeEnum.J : infs[0].equals(InstructionTypeEnum.BNE.toString()) ? InstructionTypeEnum.BNE : InstructionTypeEnum.BEQ;
                    RegisterElement param1 = new RegisterElement(Integer.parseInt(infs[2].replace("R", "")));
                    RegisterElement param2 = new RegisterElement(Integer.parseInt(infs[3].replace("(", "").replace(")", "").replace("R", "")));
                    RegisterElement dest = new RegisterElement(Integer.parseInt(infs[1].replace("R", "")));

                    InstructionElement instruction = new InstructionElement(command, param1, param2, dest, clock);

                    instructionList.add(instruction);
                }
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();

        return new InstructionsQueue(bufferSize, instructionList);
    }

    /* private static String iterationToString(int size, Function<Integer, String> exe) {
        String response = "";
        for (int i = 0; i < size; i++) {
            response += exe.apply(i);
        }
        return response;
    } */

    public static void renderTable(ReorderBuffer reorderBuffer, ReservationStation reservationStation, Register registers) {
        String[] lines = new String[21 + reorderBuffer.size() + reservationStation.size() + registers.size()];
        int i = 0;
        lines[i++] = "╔═╗";
        lines[i++] = "║ Reorder Buffer ║";
        lines[i++] = "╚═╝";
        lines[i++] = "┌─┬─┬─┬─┬─┬─┐";
        lines[i++] = "│ Entry │ Busy │ Intruction │ State │ Destination │ Value │";
        lines[i++] = "├─┴─┴─┴─┴─┴─┤";
        for (int j = 0; j < reorderBuffer.size(); j++) {
            reorderBuffer.print(j);
            i++;
        }
        lines[i++] = "└─┘";
        lines[i++] = "╔═╗";
        lines[i++] = "║ Reservation Station ║";
        lines[i++] = "╚═╝";
        lines[i++] = "┌─┬─┬─┬─┬─┬─┬─┬─┬─┐";
        lines[i++] = "│ Name │ Busy │ Op │ Vj │ Vk │ Qj │ Qk │ Dest │ A │";
        lines[i++] = "├─┴─┴─┴─┴─┴─┴─┴─┴─┤";
        lines[i++] = "└─┘";
        lines[i++] = "╔═╗";
        lines[i++] = "║ Registers ║";
        lines[i++] = "╚═╝";
        lines[i++] = "┌─┬─┬─┐";
        lines[i++] = "│ Field │ Reorder # │ Busy │";
        lines[i++] = "├─┴─┴─┤";
        lines[i++] = "└─┘";
        for (int j = 0; j < lines.length; j++) {
            System.out.println(lines[j]);
        }
        // ┄ ┆
        //║ ═ ╔ ╗ ╚ ╝
        //└ ┘ ┌ ─ ┐ │ ├ ┤ ┬ ┴ ┼
    }
}