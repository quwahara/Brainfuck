package brainfuck;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Brainfuck {
    
    public static void main(String[] args) throws Exception {

        AnsiConsole.systemInstall();

        if(args.length < 1) {
            System.exit(1);
        }
        String bf = new String(Files.readAllBytes(Paths.get(args[0])));

        int sleepMS = args.length < 2 ? 10 : Integer.valueOf(args[1]);

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

        pf(
                ansi().eraseScreen()
                .newline().newline()
                .newline().newline()
                .newline()
                .cursor(5, 1)
                );

        int last = 20;
        int pc = 0, ptr = 0;
        char[] mem = new char[30000];
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
                pf(ansi().a(String.valueOf(mem[ptr])).reset());
                break;
            case ',':
                mem[ptr] = (char) System.in.read();
                break;
            default:
                break;
            }

            pf(ansi().saveCursorPosition().cursor(1, 1).eraseLine().format("pc:%d, bf[pc]:%s", pc, s(bf.charAt(pc))).restorCursorPosition());
            pf(ansi().saveCursorPosition().cursor(2, 1).eraseLine()
                    .a(bf.substring(0, pc))
                    .bg(YELLOW).fg(BLACK).a(bf.substring(pc, pc + 1)).reset()
                    .a(bf.substring(pc + 1, bf.length()))
                    .restorCursorPosition().reset());
            pf(ansi().saveCursorPosition().cursor(3, 1).eraseLine().format("ptr:%d, mem[ptr]:%s", ptr, s(mem[ptr])).restorCursorPosition());
            pf(ansi().saveCursorPosition().cursor(4, 1).eraseLine()
                    .a(memHead(mem, ptr))
                    .bg(YELLOW).fg(BLACK).a(formatMem(mem[ptr]) + " ").reset()
                    .a(memTail(mem, ptr, last))
                    .restorCursorPosition().reset());

            Thread.sleep(sleepMS);

            ++pc;
        }
        System.out.println();
    }

    public static void pf(Object obj) {
        System.out.print(obj);
        System.out.flush();
    }

    public static String hex(char c) {
        return String.format("%02x", (int) c);
    }

    public static String s(char c) {
        if(' ' <= c && c <= '~') {
            return String.valueOf(c);
        } else {
            return "0x" + hex(c);
        }
    }

    public static String formatMem(char c) {
        return hex(c) + "." + ((' ' <= c && c <= '~') ? String.valueOf(c) : " ");
    }

    public static String memHead(char[] mem, int ptr) {
        StringBuilder b = new StringBuilder();
        for(int i = 0; i < ptr; ++i) {
            b.append(formatMem(mem[i]))
            .append(" ")
            ;
        }
        return b.toString();
    }

    public static String memTail(char[] mem, int ptr, int last) {
        StringBuilder b = new StringBuilder();
        for(int i = ptr + 1; i < last; ++i) {
            b.append(formatMem(mem[i]))
            .append(" ")
            ;
        }
        return b.toString();
    }
}
