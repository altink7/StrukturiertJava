package StrukturiertJava.Apps.console;
import java.util.Scanner;
public class ArbeitRelevantUmsaetze {
    static Scanner sc;
    public static void printRevenues(int[][] revenues){
        System.out.print("revenues: \n");
        for (int[] revenue : revenues) {
            for (int i : revenue) {
                System.out.printf("%2d ", i);
            }
            System.out.print("\n");
        }
    }

    public static int[][] scanRevenues(int branches, int days){
        int[][] revenues = new int[branches][days];


        for(int i=0; i<revenues.length; i++){
            for(int j=0; j<revenues[i].length; j++){
                System.out.print(": ");
                revenues[i][j]=sc.nextInt();
            }
        }


        return revenues;
    }

    public static int sumDay(int[][]revenues, int day){
        int sum=0;
        for (int[] revenue : revenues) {
            for (int j = 0; j < revenue.length; j++) {
                if (j == day) sum = sum + revenue[j];
            }
        }

        return sum;
    }

    public static int sumBranch(int[][]revenues, int branch){
        int sum=0;
        for(int i=0; i<revenues[branch].length; i++) sum=sum+revenues[branch][i];

        return sum;
    }

    public static int[] daySummary(int[][] revenues){
        int[] summary = new int[revenues[0].length];
        for(int i=0; i<summary.length; i++) summary[i] = sumDay(revenues, i);


        return summary;
    }

    public static int[] branchSummary(int[][] revenues){
        int[] summary = new int[revenues.length];

        for(int i=0; i<summary.length; i++) summary[i] = sumBranch(revenues, i);

        return summary;
    }

    public static int maxIdx(int[] arr){
        int index = 0;

        for(int i=1; i<arr.length; i++) index = arr[i] > arr[i-1] ? i : index;

        return index;
    }

    public static int[] maxRev(int[][] revenues){
        int[] rev = new int[2];
        int tmp = 0;
        for(int i=0; i<revenues.length; i++){
            for(int j=0; j<revenues[i].length; j++){
                if(revenues[i][j] > tmp){
                    tmp = revenues[i][j];
                    rev[0] = i;
                    rev[1] = j;
                }

            }
        }

        return rev;
    }

    public static void app(){
        int branches, days;

        System.out.print("branches: ");
        branches = sc.nextInt();
        System.out.print("days: ");
        days = sc.nextInt();

        int[][] revenues = scanRevenues(branches, days);
        printRevenues(revenues);
        int[] daySummary = daySummary(revenues);
        System.out.print("day Summary: ");
        for (int value : daySummary) System.out.printf("%d ", value);

        int maxDay=maxIdx(daySummary);
        System.out.printf("\nmax day is day %d with total revenue of %d.\n", maxDay, sumDay(revenues, maxDay));
        int[] branchSummary = branchSummary(revenues);
        System.out.print("branch Summary: ");
        for (int k : branchSummary) System.out.printf("%d ", k);
        int maxBranch=maxIdx(branchSummary);
        System.out.printf("\nmax branch is branch %d with total revenue of %d.\n", maxBranch, sumBranch(revenues, maxBranch));

        int highestRev = 0;
        for (int[] revenue : revenues) {
            for (int i : revenue) {
                highestRev = Math.max(highestRev, i);
            }
        }

        sc.close();

        int[] maxRev = maxRev(revenues);
        System.out.printf("max revenue of %d in branch %d on day %d.",highestRev,maxRev[0],maxRev[1]);

    }






    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Test[] tests = {new PrintRevenueTest(),
                new ScanRevenuesTest(),
                new SumDayTest(),
                new SumBranchTest(),
                new DaySummaryTest(),
                new BranchSummaryTest(),
                new MaxIdxTest(),
                new MaxRevTest(),
                new AppTest()

        };


        System.out.print("Test#: ");
        int n=sc.nextInt();
        if(n<1 || n> tests.length+1){
            System.out.println("unknown test.");
            return;
        }
        tests[n-1].run();
        sc.close();
    }

    private abstract static class Test{
        protected abstract void exec();
        void run(){
            System.out.printf("executing %s\n", this.getClass().getSimpleName());
            exec();
        }
    }

    private static final class PrintRevenueTest extends Test{
        @Override
        protected void exec() {
            int[][] rev = {
                    {121, 146, 126, 111, 152},  //
                    {129, 127, 195, 189, 130}, //
                    {199, 131, 197, 187, 117}, //
                    {106, 163, 173, 186, 133}, //
                    {118, 125, 140, 170, 119}, //
                    {193, 158, 192, 169, 124}, //
                    {120, 165, 157, 162, 134}, //
                    {114, 155, 181, 132, 159}, //
                    {191, 144, 112, 190, 115}, //
                    {161, 176, 137, 142, 153}, //
                    {100, 179, 136, 183, 122}, //
                    {99, 151, 184, 141, 194}, //
                    {166, 109, 188, 143, 116}, //
                    {182, 171, 198, 138, 145}, //
                    {175, 178, 123, 174, 113}, //
                    {101, 185, 135, 107, 147}, //
                    {172, 103, 149, 108, 180}, //
                    {139, 156, 167, 154, 196}, //
                    {128, 110, 160, 105, 164}, //
                    {148, 102, 150, 177, 168} //
            };
            printRevenues(rev);

        }

    }

    private static final class ScanRevenuesTest extends Test{

        @Override
        protected void exec() {
            int branches=sc.nextInt();
            int days = sc.nextInt();
            int[][] rev =scanRevenues(branches, days);
            printRevenues(rev);

        }


    }





    private static final class SumDayTest extends Test{

        @Override
        protected void exec() {
            int[][] rev = {
                    {121, 146, 126, 111, 152},  //
                    {129, 127, 195, 189, 130}, //
                    {199, 131, 197, 187, 117}, //
                    {106, 163, 173, 186, 133}, //
                    {118, 125, 140, 170, 119}, //
                    {193, 158, 192, 169, 124}, //
                    {120, 165, 157, 162, 134}, //
                    {114, 155, 181, 132, 159}, //
                    {191, 144, 112, 190, 115}, //
                    {161, 176, 137, 142, 153}, //
                    {100, 179, 136, 183, 122}, //
                    {99, 151, 184, 141, 194}, //
                    {166, 109, 188, 143, 116}, //
                    {182, 171, 198, 138, 145}, //
                    {175, 178, 123, 174, 113}, //
                    {101, 185, 135, 107, 147}, //
                    {172, 103, 149, 108, 180}, //
                    {139, 156, 167, 154, 196}, //
                    {128, 110, 160, 105, 164}, //
                    {148, 102, 150, 177, 168} //
            };
            System.out.printf("%d\n",sumDay(rev, sc.nextInt()));
        }

    }

    private static final class SumBranchTest extends Test{

        @Override
        protected void exec() {
            int[][] rev = {
                    {121, 146, 126, 111, 152},  //
                    {129, 127, 195, 189, 130}, //
                    {199, 131, 197, 187, 117}, //
                    {106, 163, 173, 186, 133}, //
                    {118, 125, 140, 170, 119}, //
                    {193, 158, 192, 169, 124}, //
                    {120, 165, 157, 162, 134}, //
                    {114, 155, 181, 132, 159}, //
                    {191, 144, 112, 190, 115}, //
                    {161, 176, 137, 142, 153}, //
                    {100, 179, 136, 183, 122}, //
                    {99, 151, 184, 141, 194}, //
                    {166, 109, 188, 143, 116}, //
                    {182, 171, 198, 138, 145}, //
                    {175, 178, 123, 174, 113}, //
                    {101, 185, 135, 107, 147}, //
                    {172, 103, 149, 108, 180}, //
                    {139, 156, 167, 154, 196}, //
                    {128, 110, 160, 105, 164}, //
                    {148, 102, 150, 177, 168} //
            };
            System.out.printf("%d\n",sumBranch(rev, sc.nextInt()));
        }

    }
    private static final class DaySummaryTest extends Test{

        @Override
        protected void exec() {
            int[][] rev = {
                    {121, 146, 126, 111, 152},  //
                    {129, 127, 195, 189, 130}, //
                    {199, 131, 197, 187, 117}, //
                    {106, 163, 173, 186, 133}, //
                    {118, 125, 140, 170, 119}, //
                    {193, 158, 192, 169, 124}, //
                    {120, 165, 157, 162, 134}, //
                    {114, 155, 181, 132, 159}, //
                    {191, 144, 112, 190, 115}, //
                    {161, 176, 137, 142, 153}, //
                    {100, 179, 136, 183, 122}, //
                    {99, 151, 184, 141, 194}, //
                    {166, 109, 188, 143, 116}, //
                    {182, 171, 198, 138, 145}, //
                    {175, 178, 123, 174, 113}, //
                    {101, 185, 135, 107, 147}, //
                    {172, 103, 149, 108, 180}, //
                    {139, 156, 167, 154, 196}, //
                    {128, 110, 160, 105, 164}, //
                    {148, 102, 150, 177, 168} //
            };
            for(int n:daySummary(rev))
                System.out.printf("%d ", n);
            System.out.println();

        }

    }
    private static final class BranchSummaryTest extends Test{

        @Override
        protected void exec() {
            int[][] rev = {
                    {121, 146, 126, 111, 152},  //
                    {129, 127, 195, 189, 130}, //
                    {199, 131, 197, 187, 117}, //
                    {106, 163, 173, 186, 133}, //
                    {118, 125, 140, 170, 119}, //
                    {193, 158, 192, 169, 124}, //
                    {120, 165, 157, 162, 134}, //
                    {114, 155, 181, 132, 159}, //
                    {191, 144, 112, 190, 115}, //
                    {161, 176, 137, 142, 153}, //
                    {100, 179, 136, 183, 122}, //
                    {99, 151, 184, 141, 194}, //
                    {166, 109, 188, 143, 116}, //
                    {182, 171, 198, 138, 145}, //
                    {175, 178, 123, 174, 113}, //
                    {101, 185, 135, 107, 147}, //
                    {172, 103, 149, 108, 180}, //
                    {139, 156, 167, 154, 196}, //
                    {128, 110, 160, 105, 164}, //
                    {148, 102, 150, 177, 168} //
            };
            for(int n:branchSummary(rev))
                System.out.printf("%d ", n);
            System.out.println();

        }

    }

    private static final class MaxIdxTest extends Test{

        @Override
        protected void exec() {
            int[][] rev = {
                    {121, 146, 126, 111, 152},  //
                    {129, 127, 195, 189, 130}, //
                    {199, 131, 197, 187, 117}, //
                    {106, 163, 173, 186, 133}, //
                    {118, 125, 140, 170, 119}, //
                    {193, 158, 192, 169, 124}, //
                    {120, 165, 157, 162, 134}, //
                    {114, 155, 181, 132, 159}, //
                    {191, 144, 112, 190, 115}, //
                    {161, 176, 137, 142, 153}, //
                    {100, 179, 136, 183, 122}, //
                    {99, 151, 184, 141, 194}, //
                    {166, 109, 188, 143, 116}, //
                    {182, 171, 198, 138, 145}, //
                    {175, 178, 123, 174, 113}, //
                    {101, 185, 135, 107, 147}, //
                    {172, 103, 149, 108, 180}, //
                    {139, 156, 167, 154, 196}, //
                    {128, 110, 160, 105, 164}, //
                    {148, 102, 150, 177, 168} //
            };
            System.out.printf("%d\n",maxIdx(rev[0]));
            System.out.println();

        }

    }

    private static final class MaxRevTest extends Test{

        @Override
        protected void exec() {
            int[][] rev = {
                    {121, 146, 126, 111, 152},  //
                    {129, 127, 195, 189, 130}, //
                    {199, 131, 197, 187, 117}, //
                    {106, 163, 173, 186, 133}, //
                    {118, 125, 140, 170, 119}, //
                    {193, 158, 192, 169, 124}, //
                    {120, 165, 157, 162, 134}, //
                    {114, 155, 181, 132, 159}, //
                    {191, 144, 112, 190, 115}, //
                    {161, 176, 137, 142, 153}, //
                    {100, 179, 136, 183, 122}, //
                    {99, 151, 184, 141, 194}, //
                    {166, 109, 188, 143, 116}, //
                    {182, 171, 198, 138, 145}, //
                    {175, 178, 123, 174, 113}, //
                    {101, 185, 135, 107, 147}, //
                    {172, 103, 149, 108, 180}, //
                    {139, 156, 167, 154, 196}, //
                    {128, 110, 160, 105, 164}, //
                    {148, 102, 150, 177, 168} //
            };
            int[]mr=maxRev(rev);
            System.out.printf("%d %d\n",mr[0], mr[1]);
        }

    }

    private static final class AppTest extends Test{

        @Override
        protected void exec() {
            app();

        }

    }

    /*-------------------------------------------*/

}
