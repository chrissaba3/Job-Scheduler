import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class RoundRobin2 implements ANSI_COLOR {
    private double roundRobinTime = 2;
    private double size;
    private String job;
    private double time;
    private double totalTime = 0;
    private double jobsDone = 0;
    private double jobTimeLeft;
    private Hashtable<String, Double> hashTable;
    private ArrayList<Double> timeHolder = new ArrayList<Double>();

    public RoundRobin2(Hashtable<String, Double> hashTable){
        this.hashTable = hashTable;
        this.size = this.hashTable.size();

        for(int j = 1; j<=size; j++){
            job = "Job" + j;
            time = hashTable.get(job);
            timeHolder.add(time);
        }
    }

    public double rR2(){
        int i = 0;
        double timeAdder = 0;
        System.out.println("\n\n\n ---------------------------------------------- ");
        System.out.println(toString());
        while(jobsDone!= size){

            jobTimeLeft = timeHolder.get(i) - roundRobinTime;

            if(jobTimeLeft > 0){
                timeHolder.add(jobTimeLeft);
                timeAdder += roundRobinTime;
                System.out.print(ANSI_RED + "||Time left on current job "+ timeHolder.get(i).intValue() +"ms || " );
                System.out.println(ANSI_RESET + "");
            }
            else if(jobTimeLeft == -1){
                timeAdder++;
                jobsDone++;
                System.out.println();
                System.out.println(ANSI_BLUE + "Job with time left "+ timeHolder.get(i).intValue() +"ms Complete: " + timeAdder + ANSI_RESET);

                totalTime += timeAdder;

            }
            else{
                timeAdder += roundRobinTime;
                jobsDone++;
                System.out.println();
                System.out.println(ANSI_BLUE + "Job with time left " + timeHolder.get(i).intValue() + "ms Complete: " + timeAdder + ANSI_RESET);
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
        return "RoundRobin2{" +
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
        if (!(o instanceof RoundRobin2)) return false;
        RoundRobin2 that = (RoundRobin2) o;
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
