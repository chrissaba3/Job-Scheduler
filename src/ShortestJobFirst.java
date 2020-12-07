import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Objects;

public class ShortestJobFirst implements ANSI_COLOR {
    private double size;
    private String job;
    private double time;
    double totalTime = 0;
    private Hashtable<String, Double> hashTable;
    private ArrayList<Double> timeHolder = new ArrayList<>();


    /**Initialize Shortest Job First hashtable, using similar algorithm to FCFS
    * We use timeHolder because sorting the hash table by times is very tedious,
    * this allows an easier algorithm to code, but doesn't physically sort the jobs by time,
    * but instead calculates the SJF utilizing a sorted time arraylist.
    * */
    public ShortestJobFirst(Hashtable<String, Double> hashTable){
        this.hashTable = hashTable;
        this.size = this.hashTable.size();
        //Sort jobs based on job time,
        for(int i = 1; i<=size; i++){
            job = "Job" + i;
            time = hashTable.get(job);
            timeHolder.add(time);
        }
        Collections.sort(timeHolder);
    }

    public double sJF(){
        double tempTime = 0;
        System.out.println("\n\n\n ---------------------------------------------- ");
        System.out.println(toString());
        for(int i = 0; i < size; i++){
            tempTime += timeHolder.get(i);
            System.out.println(ANSI_BLUE+"Job With Time "+timeHolder.get(i).intValue()+ "ms Complete: " + tempTime + ANSI_RESET);
            totalTime += tempTime;
        }
        System.out.println(" ---------------------------------------------- ");

        //mean process turnaround time
        return totalTime/size;
    }
    /**
     * Auto generated toString, equals, and hashCode methods, for use in the program is
     * only the toString method.
     *
     */
    @Override
    public String toString() {
        return "ShortestJobFirst{" +
                "size=" + size +
                ", job='" + job + '\'' +
                ", time=" + time +
                ", totalTime=" + totalTime +
                ", hashTable=" + hashTable +
                ", timeHolder=" + timeHolder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShortestJobFirst)) return false;
        ShortestJobFirst that = (ShortestJobFirst) o;
        return size == that.size &&
                time == that.time &&
                Double.compare(that.totalTime, totalTime) == 0 &&
                Objects.equals(job, that.job) &&
                Objects.equals(hashTable, that.hashTable) &&
                Objects.equals(timeHolder, that.timeHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, job, time, totalTime, hashTable, timeHolder);
    }
}
