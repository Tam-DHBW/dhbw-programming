package dhbw.tam.logisim;

import dhbw.tam.logisim.gates.InputGate;
import dhbw.tam.logisim.gates.SimpleGate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LogicGate circuit = SimpleGate.and(
                SimpleGate.or(
                        new InputGate('A', true),
                        new InputGate('B', false)
                ).display(),
                new InputGate('C', true)
        ).display();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();

            CircuitUI.RenderResult render = CircuitUI.render(circuit);
            System.out.println(render.buffer().asString());

            System.out.print("Toggle Input Gate: ");
            String line = scanner.nextLine();
            if (line.isEmpty()) return;

            char toggle = line.toCharArray()[0];
            toggleInputGate(circuit, toggle);
        }
    }

    private static void toggleInputGate(LogicGate gate, char id) {
        if (gate instanceof InputGate inputGate && inputGate.getId() == id) {
            inputGate.toggle();
        } else {
            gate.getInputs().forEach(input -> toggleInputGate(input, id));
        }
    }
}