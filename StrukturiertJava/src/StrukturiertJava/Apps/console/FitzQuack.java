package StrukturiertJava.Apps.console;
import java.util.Scanner;

public class FitzQuack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();

        System.out.print(": ");

        for (int i=1;i<=x;i++){

            if(i%35==0){
                System.out.print("FitzQuack");
            }
            else if(i%5==0){
                System.out.print("Fitz");
            }

            else if(i%7==0){
                System.out.print("Quack");
            }

            else{
                System.out.printf("%d",i);
            }

            System.out.print((i%10==0? "\n":" "));
            sc.close();
        }
    }
}
