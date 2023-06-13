import java.util.ArrayList;

import components.InstructionsQueue;
import components.ReorderBuffer;
import components.ReservationStation;
import domain.InstructionElement;
import components.Register;

public class InterfaceIO {

    public static InstructionsQueue readInstructions(int bufferSize) {
        return new InstructionsQueue(bufferSize, new ArrayList<InstructionElement>(0));
    }

    /* private static String iterationToString(int size, Function<Integer, String> exe) {
        String response = "";
        for (int i = 0; i < size; i++) {
            response += exe.apply(i);
        }
        return response;
    } */

    public static void renderTable(ReorderBuffer reorderBuffer, ReservationStation reservationStation, Register registers) {
        String[] lines = new String[21/*  + reorderBuffer.size() + reservationStation. */];
        int i = 0;
        lines[i++] = "╔═╗";
        lines[i++] = "║ Reorder Buffer ║";
        lines[i++] = "╚═╝";
        lines[i++] = "┌─┬─┬─┬─┬─┬─┐";
        lines[i++] = "│ Entry │ Busy │ Intruction │ State │ Destination │ Value │";
        lines[i++] = "├─┴─┴─┴─┴─┴─┤";
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
        System.out.println(lines);
        // ┄ ┆
        //║ ═ ╔ ╗ ╚ ╝
        //└ ┘ ┌ ─ ┐ │ ├ ┤ ┬ ┴ ┼
    }
}