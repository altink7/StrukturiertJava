package StrukturiertJava.Apps;
import java.util.Arrays;
import java.util.Scanner;

public class DijkstraShortestPath {
    static final double oo = Double.POSITIVE_INFINITY;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("**Bitte folgen Sie der Anleitung, um den kürzesten Weg zu bestimmen-altinpage41.pdf**");

        int laenge = sc.nextInt();
        int x;
        int y;
        float wert;
        double[][] graph = new double[laenge][laenge];
        int CONSTANT=graph.length;
        int[] precede= new int[CONSTANT];
        double[] distance= new double[CONSTANT];
        int i;
        float Summe=0;


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
        int start=sc.nextInt();
        int finish=sc.nextInt();
        dijkstra(graph,precede, distance);

        int j = finish;
        for (i = start; i < CONSTANT; i++) {
            if (j == i) {
                Summe = (float) distance[i];
            }
        }
        while (j != 0) {
            System.out.printf("%c <- ", j+'A');
            j = precede[j];
        }
        System.out.printf("%c (%1.1f)\n", start+'A',Summe);


        sc.close();


    }

    public static boolean allSelected(int[] selected) {
        int i;
        for (i = 0; i < selected.length; i++)
            if (selected[i] == 0)
                return false;
        return true;
    }

    public static void dijkstra(double[][] graph, int[] precede, double[] distance) {
        //
        int[] finalG = new int[graph.length];

        int current=0;
        int i;
        int k=-1;
        double dc,smalldist, newdist;
        //init distances
        for (i = 0; i < distance.length; i++)
            distance[i] = oo;


        //init algo
        finalG[current] = 1;    //set A final
        distance[0] = 0;        //distance 0 from A to A


        while (!allSelected(finalG)) {
            smalldist = oo;
            dc = distance[current];

            for (i = 0; i < finalG.length; i++) {
                if (finalG[i] == 0) {
                    newdist = dc + graph[current][i];
                    if (newdist < distance[i]) {
                        distance[i] = newdist;
                        precede[i] = current;
                    }
                    if (distance[i] < smalldist) {
                        smalldist = distance[i];
                        k = i;
                    }
                }

            }
            current = k;
            finalG[current] = 1;
        }
    }
}
