import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class RoundRobin5 implements ANSI_COLOR{

    private double roundRobinTime = 5;
    private double size;
    private String job;
    private double time;
    private double totalTime = 0;
    private double jobsDone = 0;
    private double jobTimeLeft;
    private Hashtable<String, Double> hashTable;
    private ArrayList<Double> timeHolder = new ArrayList<Double>();

    public RoundRobin5(Hashtable<String, Double> hashTable){
        this.hashTable = hashTable;
        this.size = this.hashTable.size();

        for(int j = 1; j<=size; j++){
            job = "Job" + j;
            time = hashTable.get(job);
            timeHolder.add(time);
        }
    }

    /** Similar to SJF and RR2, we use timeHolder to calculate the times due to its ease of access and calculations
     * We do not need to sort the times, however, since round robin doesn't care about priority nor how much time left.
     * This ends up producing a large output, but can show exactly how much time left is on a job and when it is completed.
     *
     */

    public double rR5(){
        int i = 0;
        double timeAdder = 0;
        System.out.println("\n\n\n ---------------------------------------------- ");
        System.out.println(toString());

        while(jobsDone != size){

            jobTimeLeft = timeHolder.get(i) - roundRobinTime;

            if(jobTimeLeft > 0){
                timeHolder.add(jobTimeLeft);
                timeAdder += roundRobinTime;
                System.out.print(ANSI_RED + "||Time left on current job "+ timeHolder.get(i).intValue() +"ms || " );
                System.out.println(ANSI_RESET + "");
            }
            else if(jobTimeLeft == -2){
                timeAdder += 3;
                jobsDone++;
                System.out.println();
                System.out.println(ANSI_BLUE + "Job with time left "+ timeHolder.get(i).intValue() +"ms Complete: " + timeAdder + ANSI_RESET);
                totalTime += timeAdder;
            }
            else if(jobTimeLeft == -3){
                timeAdder += 2;
                jobsDone++;
                System.out.println();
                System.out.println(ANSI_BLUE + "Job with time left "+ timeHolder.get(i).intValue() +"ms Complete: " + timeAdder + ANSI_RESET);
                totalTime += timeAdder;
            }
            else if(jobTimeLeft == -4){
                timeAdder += 1;
                jobsDone++;
                System.out.println();
                System.out.println(ANSI_BLUE + "Job with time left "+ timeHolder.get(i).intValue() +"ms Complete: " + timeAdder + ANSI_RESET);
                totalTime += timeAdder;
            }
            else if(jobTimeLeft == -1){
                timeAdder += 4;
                jobsDone++;
                System.out.println();
                System.out.println(ANSI_BLUE + "Job with time left "+ timeHolder.get(i).intValue() +"ms Complete: " + timeAdder + ANSI_RESET);
                totalTime += timeAdder;
            }
            else{
                timeAdder += roundRobinTime;
                jobsDone++;
                System.out.println();
                System.out.println(ANSI_BLUE + "Job with time left "+ timeHolder.get(i).intValue() +"ms Complete: " + timeAdder + ANSI_RESET);
                totalTime += timeAdder;
            }
            i++;
        }
        System.out.println(" ---------------------------------------------- ");
        return totalTime/size;
    }

    /**
     * Auto generated toString, equals, and hashCode methods, for use in the program is
     * only the toString method.
     *
     */
    @Override
    public String toString() {
        return "RoundRobin5{" +
                "roundRobinTime=" + roundRobinTime +
                ", size=" + size +
                ", job='" + job + '\'' +
                ", time=" + time +
                ", totalTime=" + totalTime +
                ", jobsDone=" + jobsDone +
                ", jobTimeLeft=" + jobTimeLeft +
                ", hashTable=" + hashTable +
                ", timeHolder=" + timeHolder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoundRobin5)) return false;
        RoundRobin5 that = (RoundRobin5) o;
        return roundRobinTime == that.roundRobinTime &&
                size == that.size &&
                Double.compare(that.time, time) == 0 &&
                Double.compare(that.totalTime, totalTime) == 0 &&
                jobsDone == that.jobsDone &&
                Double.compare(that.jobTimeLeft, jobTimeLeft) == 0 &&
                Objects.equals(job, that.job) &&
                Objects.equals(hashTable, that.hashTable) &&
                Objects.equals(timeHolder, that.timeHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundRobinTime, size, job, time, totalTime, jobsDone, jobTimeLeft, hashTable, timeHolder);
    }
}
