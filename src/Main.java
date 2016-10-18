import java.util.*;

public class Main {

    private static char[] startPosition;
    private static char[] endPosition;

    //A list with all the right moves
    private static List<String> moves = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the number of frogs: ");
        int n = reader.nextInt();

        startPosition = createMap(n);
        endPosition = reverse(startPosition);

        nextMove(startPosition);
        moves.add(new String(startPosition));

        for(int i=moves.size()-1;i>=0;i--){
            System.out.println(moves.get(i));
        }

    }

    private static int nextMove(char[] arr) {

        //bottom of recursion

        if (Arrays.equals(arr, endPosition)) {;
            return 1;
        } else {
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == '>') {


                    if (i + 1 < arr.length) {
                        if (arr[i + 1] == '_') {

                            char[] newArr = Arrays.copyOf(arr, arr.length);

                            char tmp = newArr[i];
                            newArr[i] = newArr[i + 1];
                            newArr[i + 1] = tmp;

                            if (nextMove(newArr) > 0) {
                                moves.add(new String(newArr));
                                return 1;
                            }
                        }
                        if (i + 2 < arr.length) {
                            if (arr[i + 2] == '_') {
                                char[] newArr = Arrays.copyOf(arr, arr.length);
                                char tmp = newArr[i];
                                newArr[i] = newArr[i + 2];
                                newArr[i + 2] = tmp;
                                // System.out.println(2);
                                if (nextMove(newArr) > 0) {

                                    moves.add(new String(newArr));
                                    return 1;
                                }
                            }
                        }
                    }
                }

                if (arr[i] == '<') {

                    if ((i - 1) >= 0) {
                        if (arr[i - 1] == '_') {
                            char[] newArr = Arrays.copyOf(arr, arr.length);

                            char tmp = newArr[i];
                            newArr[i] = newArr[i - 1];
                            newArr[i - 1] = tmp;
                            // System.out.println(3);
                            if (nextMove(newArr) > 0) {
                                moves.add(new String(newArr));
                                return 1;
                            }

                        }
                    }
                    if (i - 2 >= 0) {
                        if (arr[i - 2] == '_') {
                            char[] newArr = Arrays.copyOf(arr, arr.length);

                            char tmp = newArr[i];
                            newArr[i] = newArr[i - 2];
                            newArr[i - 2] = tmp;
                            // System.out.println(1);
                            if (nextMove(newArr) > 0) {

                                moves.add(new String(newArr));
                                return 1;
                            }

                        }
                    }
                }
            }
        }
        return 0;
    }


    //Creates the start position of our frogs
    private static char[] createMap(int numOfFrogs){

        char[] map = new char[2*numOfFrogs+1];

        for(int i=0;i<numOfFrogs; i++){
            map[i] = '>';
        }

        map[numOfFrogs] = '_';

        for(int i = numOfFrogs+1;i<map.length;i++){
            map[i] = '<';
        }

        return map;
    }

    //Reverses the start position to get the end position string;
    private static char[] reverse(char[] arr){
        char [] newArr = new char[arr.length];

        for(int i = 0; i<arr.length;i++){
            newArr[(arr.length - 1)- i] = arr[i];
        }

        return newArr;
    }
}