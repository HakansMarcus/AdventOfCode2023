import java.util.Arrays;
import java.util.List;

public class CharArray {

    CharArray previous;
    CharArray next;
    char[] list;
    List<Integer> parts;

    public CharArray(String line) {
        list = line.toCharArray();
        findParts();
    }


    private void findParts() {
        for (int i = 0; i < list.length; i++) {
            char c = list[i];

            // Första raden
            if(previous == null) {
                if(Character.isDigit(c)) {

                }

            }

        }
    }


    @Override
    public String toString() {
        return Arrays.toString(list);
    }






}