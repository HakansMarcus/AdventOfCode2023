import java.util.ArrayList;
import java.util.List;

public class LinkedChar {

    List<CharArray> schematic;
    List<Integer> parts;

    public LinkedChar() {
        schematic = new ArrayList<>();
    }

    public void appendToSchematic(String line) {
        schematic.add(new CharArray(line));
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        schematic.stream().forEach(c -> builder.append(c.toString()));

        return builder.toString();

    }

    public void linkCharArrays() {
        for (int i = 0; i < schematic.size(); i++) {
            if (i == 0) {
                CharArray first = schematic.get(i);
                first.previous = null;
                first.next = schematic.get(i + 1);
            }

            else if (i == schematic.size() - 1) {
                CharArray last = schematic.get(i);
                last.previous = schematic.get(i - 1);
                last.next = null;
            } else {

                /*
                 * Hitta digit, kolla adjacent, märka digit
                 *
                 */

                CharArray middle = schematic.get(i);
                middle.previous = schematic.get(i - 1);
                middle.next = schematic.get(i + 1);
            }

        }
    }

}