import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        boolean isRight = direction == 'R';
        if (direction != 'R' && direction != 'L') {return array;} // Invalid direction, return the original array
        if (array.length == 0 || move == 0) {return array;} // Empty array or no movment, return the original array
        if (move < 0) { // Convert negative move to positive move in the opposite direction
            move = -move;
            isRight = !isRight;
        } //now we can start shifting the array
        move = move % array.length; // Normalize move to be within the bounds of the array length
        int[] new_array = new int[array.length];
        for (int i = 0 ; i < array.length; i++) {
            int new_index = 0;
            if (isRight) {
                new_index = (i + move) % array.length;
            } else {
                new_index = (i - move + array.length) % array.length; // Add array.length to avoid negative index
            }
            new_array[new_index] = array[i];
        }
        array = new_array;
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}