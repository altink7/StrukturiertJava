package StrukturiertJava.Apps;
import java.util.Objects;
import java.util.Scanner;


public class AlphabetWalkerStackQueue{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int horizontal=0;
        int vertikal=0;
        int alphabetcounter=1;
        int A1=0;
        int A2=0;
        int stackValue=-1;
        int stack2Value=-1;
        int decodeStackValue=-1;
        int decodeStack2Value=-1;
        Stack stack=new Stack();
        Stack stack2=new Stack();

        String[][] feld= new String [10][10];
        char[] alphabet = new char[26];
        char a = 65; //erster Buchstabe (großes A)
        for(int i = 0; i < alphabet.length; i++, a++) {
            alphabet[i] = a;
        }

        for(int i =0;i<10;i++){
            for(int j=0;j<10;j++){
                if(i==0 && j==0){
                    feld[i][j]="A";
                }
                else{
                    feld[i][j]=".";
                }
                System.out.print(feld[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("Enter direction command: \n" +
                "6->rechts, 8 rauf, 4<-links, 2 runter, 5 schliessen, 7==UNDO");
        int x =sc.nextInt();

        while(x!=5) {
            if(decodeStackValue>0&&x!=7&&x!=9){
                decodeStackValue=pop(stack);
                vertikal=decodeStackValue/10;
                horizontal=decodeStackValue%10;
            }
            if(x==8) vertikal-=1;
            else if(x==4)horizontal-=1;
            else if(x==2)vertikal+=1;
            else if(x==6)horizontal+=1;


            if (x == 2 || x == 4 || x == 6 || x == 8||x==7||x==9) {



                if(x!=7&&x!=9&&(horizontal>9||horizontal<0||vertikal<0||vertikal>9|| !Objects.equals(feld[vertikal][horizontal], "."))){
                    horizontal = A2;
                    vertikal = A1;
                    System.out.print("You cannot go there!\n");
                    System.out.print("Enter direction command: \n");
                    x = sc.nextInt();
                }
                else if(x == 2 || x == 4 || x == 6 || x == 8){

                    for (int k = 0; k < 10; k++) {
                        for (int l = 0; l < 10; l++) {

                            if(k == vertikal && l == horizontal && Objects.equals(feld[k][l], ".")){

                                feld[k][l]= String.valueOf(alphabet[alphabetcounter%26]);
                                alphabetcounter++;
                                A1= k;
                                A2=l;
                                stackValue=(k*10)+l;
                                push(stack,stackValue);
                            }
                            System.out.print(feld[k][l]);
                            pop(stack2);
                        }
                        System.out.print("\n");
                    }System.out.print("Enter direction command: \n");
                    x = sc.nextInt();

                }
                else if(x==7){
                    int changeVariable=0;
                    decodeStackValue=pop(stack);
                    for (int k = 0; k < 10; k++) {
                        for (int l = 0; l < 10; l++) {
                            if((decodeStackValue!=0&&(k==decodeStackValue/10 &&l==decodeStackValue%10))){
                                feld[k][l]=".";
                                alphabetcounter--;
                                vertikal= k;
                                horizontal=l;
                                changeVariable=1;
                                stack2Value=(k*10)+l;
                                push(stack2,stack2Value);
                            }
                            if(decodeStackValue!=0) System.out.print(feld[k][l]);
                        }
                        if(decodeStackValue!=0) System.out.print("\n");
                    }
                    if(changeVariable==0){
                        System.out.println("Nothing to undo!");
                        push(stack,decodeStackValue);
                    }
                    System.out.print("Enter direction command: \n");
                    x = sc.nextInt();
                }
                else{
                    int changeVariable=0;
                    decodeStack2Value=pop(stack2);
                    for (int k = 0; k < 10; k++) {
                        for (int l = 0; l < 10; l++) {
                            if (decodeStack2Value != 0 && (k == decodeStack2Value / 10 && l == decodeStack2Value % 10)) {
                                changeVariable = 1;
                                break;
                            }
                        }
                    }
                    if(decodeStackValue==0) {
                        System.out.println("Nothing to undo!");
                        System.out.print("Enter direction command: \n");
                        x = sc.nextInt();
                    }
                    else if(changeVariable==0&&decodeStackValue!=0){
                        vertikal+=1;

                        for (int o = 0; o < 10; o++) {
                            for (int u = 0; u < 10; u++) {

                                if(o == vertikal && u == horizontal && Objects.equals(feld[o][u], ".")) {
                                    feld[o][u]= String.valueOf(alphabet[alphabetcounter%26]);
                                    alphabetcounter++;
                                    A1= o;
                                    A2=u;
                                    stackValue=(o*10)+u;
                                    push(stack,stackValue);
                                }
                                System.out.print(feld[o][u]);
                            }
                            System.out.print("\n");
                        }
                    }
                    else {
                        for (int k = 0; k < 10; k++) {
                            for (int l = 0; l < 10; l++) {
                                if (k == decodeStack2Value / 10 && l == decodeStack2Value % 10) {
                                    feld[k][l] = String.valueOf(alphabet[alphabetcounter % 26]);
                                    alphabetcounter++;
                                    vertikal = k;
                                    horizontal = l;
                                    stackValue = (k * 10) + l;
                                    push(stack, stackValue);
                                }

                                System.out.print(feld[k][l]);

                            }
                            System.out.print("\n");
                        }
                    }

                    System.out.print("Enter direction command: \n");
                    x = sc.nextInt();
                }

            }
            else {
                System.out.print("Enter direction command: \n");
                x = sc.nextInt();
            }
        }
        sc.close();
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
class Node {
    int item;
    Node next;
}

class Stack {
    Node head;
}