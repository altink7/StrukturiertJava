package StrukturiertJava;
import java.util.Scanner;

public class ReadGraph {
    static final double oo = Double.POSITIVE_INFINITY;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int laenge = sc.nextInt();
        int x=0;
        int y=0;
        float wert;
        double graph[][]= new double[laenge][laenge];
        for(int m=0;m<graph.length;m++){
            for(int n=0;n<graph[m].length;n++){
                graph[m][n]=oo;
            }
        }

        while(true){
            x=sc.nextInt();
            if(x<0||x>laenge){
                break;
            }
            y=sc.nextInt();
            if(y<0||y>laenge){
                break;
            }
            wert= sc.nextFloat();
            graph[x][y]=wert;

        }

        writegraph(graph);
        sc.close();


    }

    public static void writegraph(double graph[][]) {

        int i, j;

        System.out.printf("digraph mygraph {\n");
        System.out.printf("node [style = filled, color = black, fontcolor = white]\n");

        for (i = 0; i < graph.length; i++)
            for (j = 0; j < graph[i].length; j++)
                if (graph[i][j] != oo)
                    System.out.printf("    %c -> %c [label = %.1f]\n", i + 'A', j + 'A', graph[i][j]);
        System.out.printf("}\n");

    }
}
