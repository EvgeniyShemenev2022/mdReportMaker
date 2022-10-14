package org.shemenev.v2;

import java.util.Arrays;

public class Main {
    private static String onNoArgsMessage = """
              Hello. You run me without arguments. I don't know what to do.
              Please run me with -h argument.
              Buy!
            """;
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println(onNoArgsMessage);
            return;
        }


    }
}
