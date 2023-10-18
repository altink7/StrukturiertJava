package StrukturiertJava.Apps;

public class DijkstraAlg {
    public static void main(String[] args) {
        final int x = Integer.MAX_VALUE;

        int[][] Graph ={{0,x,x,x,x,x,7,2,x},//A
                {x,0,4,x,x,3,x,1,x},//B
                {x,4,0,6,x,x,x,x,3},//C
                {x,x,4,0,4,6,x,x,x},//D
                {x,x,x,4,0,x,x,x,2},//E
                {x,3,x,6,x,0,9,x,5},//F
                {7,x,x,x,x,9,0,8,2},//G
                {2,1,x,x,x,x,8,0,x},//H
                {x,3,x,2,5,2,x,0},};//I

        System.out.println(meanLength(Graph));//zum Testen

    }

    public static double meanLength(int[][] g){
        double Length=0;
        int Anzahl=0;
        for (int[] ints : g) {
            for (int anInt : ints) {
                if (anInt != Integer.MAX_VALUE) {
                    Length += anInt;
                    Anzahl++;
                }
            }
        }
        return Length/(Anzahl-g.length);
    }
}
