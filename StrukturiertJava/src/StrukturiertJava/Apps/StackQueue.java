package StrukturiertJava.Apps;

import java.util.Scanner;

public class StackQueue {
    public static void main(String[] args) {
        System.out.println("Infos + Anleitung nebendatei(.pdf)");
        Scanner sc = new Scanner(System.in);
        Stack stack1 = new Stack();
        String values=sc.next();

        while(!values.equals("=")){

            switch (values) {
                case "*" -> push(stack1, pop(stack1) * pop(stack1));
                case "/" -> {
                    int division1 = pop(stack1);
                    int division2 = pop(stack1);
                    push(stack1, division2 / division1);
                }
                case "%" -> {
                    int modulo1 = pop(stack1);
                    int modulo2 = pop(stack1);
                    push(stack1, modulo2 % modulo1);
                }
                case "+" -> push(stack1, pop(stack1) + pop(stack1));
                case "-" -> {
                    int minus1 = pop(stack1);
                    int minus2 = pop(stack1);
                    push(stack1, minus2 - minus1);
                }
                default -> push(stack1, Integer.parseInt(values));
            }
            values = sc.next();
        }
        System.out.println(pop(stack1));
    }

    public static void push(Stack s, int value){
        Node nN =new Node();
        nN.item=value;
        nN.next=s.head;
        s.head=nN;
    }

    public static int pop(Stack s) {
        if (s == null || s.head == null)
            return 0;
        int c = s.head.item;
        s.head = s.head.next;
        return c;
    }
}