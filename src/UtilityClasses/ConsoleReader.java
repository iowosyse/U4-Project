package UtilityClasses;

import Controllers.Validator;
import java.util.Scanner;

public class ConsoleReader {
    static Scanner sc = new Scanner(System.in);
    static String input;

    /**Alternative to .nextInt() from Scanner objects. Prevents exceptions*/
    public static int readInteger() {
        int result = 0;
        boolean goodToGo = false;

        do {
            try {
                System.out.print(">> ");
                input = sc.nextLine();
                result = Integer.parseInt(input);
                goodToGo = true;
            } catch (Exception e) {
                //Somehow the System.err.println() gives problems and makes it hard to align correctly with the other prints.
                System.out.println(Colors.red + "-- Invalid input --" + Colors.reset);
            }
        } while (!goodToGo);

        return result;
    }

    public static String readString() {
        System.out.print(">> ");
        input = sc.nextLine();
        return input;
    }

    public static int readInteger(Validator validator) {
        int result = 0;
        boolean goodToGo = false;

        do {
            do {
                try {
                    System.out.print(">> ");
                    input = sc.nextLine();
                    result = Integer.parseInt(input);
                    goodToGo = true;
                } catch (Exception e) {
                    //Somehow the System.err.println() gives problems and makes it hard to align correctly with the other prints.
                    System.out.println(Colors.red + "-- Invalid input --" + Colors.reset);
                }
            } while (!goodToGo);
        } while (!validator.validate(result));

        return result;
    }

    public static String readString(Validator validator) {
        do {
            do {
                System.out.print(">> ");
                input = sc.nextLine();
            } while (validator.validate(input));
        } while (!validator.validate(input));

        return input;
    }
}
