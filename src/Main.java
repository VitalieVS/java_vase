import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    int N = 0;
    int n = 0;
    int[] array = {};
    int capacity = 0;

    @Test
    public void vase() {
        solve();
        sortArray();
        if (checkCapacity()) {
            System.out.println("DA");
        } else {
            System.out.println("NU");
        }
    }

    public void solve() {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    boolean checkCapacity() {
        int capacity = 0;
        boolean result = false;
        for (int i = array.length - 1; i > 0; i--) {
            capacity += array[i];
            if (capacity >= this.capacity) {
              result = true;
            }
        }
        return result;
    }

    public void sortArray() {
        Arrays.sort(array);
    }

    public void readFile() throws FileNotFoundException {
        int line = 0;
        File file = new File("data.txt");

        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            switch (line) {
                case 0 -> N = Integer.parseInt(reader.nextLine());
                case 1 -> parseLine(reader.nextLine());
                case 2 -> capacity = Integer.parseInt(reader.nextLine());
            }
            line++;
        }
    }

    public void parseLine(String line) {
        String[] lineArray = line.split(" ");

        for (String elem : lineArray) {
            array = addElem(n, array, Integer.parseInt(elem));
            n++;
        }
    }

    private static int[] addElem(int n, int[] arr, int value) {
        int i;
        int[] newArr = new int[n + 1];

        for (i = 0; i < n; i++) {
            newArr[i] = arr[i];
        }
        newArr[n] = value;

        return newArr;
    }
}
