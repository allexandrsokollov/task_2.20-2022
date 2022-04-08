package vsu.cs.sokolov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyList list = new MyList();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter integer array in a row and then press enter");

        String input;
        input = in.nextLine();

        Scanner stringHandler = new Scanner(input);

        while (stringHandler.hasNextInt()) {
            list.add(stringHandler.nextInt());
        }

        list.printList();
        list.fixList();
        list.printList();

    }
}
