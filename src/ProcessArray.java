import java.util.Arrays;

public class ProcessArray {

    private final int[] array;

    public ProcessArray() {
        this.array = new int[5];
        setInitialValues();
    }

    private void setInitialValues() {
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.round((float) Math.random() * 100);
        }
    }

    public int[] heat(int position) {
        if (position < 0 || position >= array.length) {
            throw new IllegalArgumentException("Invalid position. Array has length: " + array.length);
        }

        if (position == 0) {
            array[position] = array[position] + 1;
        } else if (position == array.length - 1) {
            array[position] = array[position] - 1;
        } else {
            int leftPosition = array[position - 1];
            int rightPosition = array[position + 1];
            array[position] = (leftPosition + rightPosition) / 2;
        }

        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }
}
