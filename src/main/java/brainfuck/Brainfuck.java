package brainfuck;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

public class Brainfuck {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.exit(1);
        }
        String bf = new String(Files.readAllBytes(Paths.get(args[0])));

        int[] loop = new int[bf.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < bf.length(); ++i) {
            switch (bf.charAt(i)) {
            case '[':
                stack.push(i);
                break;
            case ']':
                int start = stack.pop();
                loop[start] = i;
                loop[i] = start;
                break;
            default:
                break;
            }
        }

        int pc = 0, ptr = 0;
        byte[] mem = new byte[30000];
        while (pc < bf.length()) {
            switch (bf.charAt(pc)) {
            case '<':
                --ptr;
                break;
            case '>':
                ++ptr;
                break;
            case '-':
                --mem[ptr];
                break;
            case '+':
                ++mem[ptr];
                break;
            case '[':
                if (mem[ptr] == 0) {
                    pc = loop[pc];
                }
                break;
            case ']':
                if (mem[ptr] != 0) {
                    pc = loop[pc] - 1;
                }
                break;
            case '.':
                System.out.print((char) mem[ptr]);
                break;
            case ',':
                mem[ptr] = (byte) System.in.read();
                break;
            default:
                break;
            }

            ++pc;
        }
        System.out.println();
    }
}
