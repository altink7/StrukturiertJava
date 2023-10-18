package StrukturiertJava.Apps.console;
import java.util.Arrays;
import java.util.Scanner;

public class ReadGraph {
    static final double oo = Double.POSITIVE_INFINITY;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int laenge = sc.nextInt();
        int x;
        int y;
        float wert;
        double[][] graph = new double[laenge][laenge];
        for (double[] doubles : graph) {
            Arrays.fill(doubles, oo);
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

        writeGraph(graph);
        sc.close();


    }

    public static void writeGraph(double[][] graph) {

        int i, j;

        System.out.print("digraph mygraph {\n");
        System.out.print("node [style = filled, color = black, fontcolor = white]\n");

        for (i = 0; i < graph.length; i++)
            for (j = 0; j < graph[i].length; j++)
                if (graph[i][j] != oo)
                    System.out.printf("    %c -> %c [label = %.1f]\n", i + 'A', j + 'A', graph[i][j]);
        System.out.print("}\n");

    }
}
