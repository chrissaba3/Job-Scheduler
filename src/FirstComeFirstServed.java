import java.util.Hashtable;
import java.util.Objects;

public class FirstComeFirstServed implements ANSI_COLOR{

    private double size;
    private String job;
    private double time;
    double totalTime = 0;
    private Hashtable<String, Double> hashTable;
    //Constructor
    public FirstComeFirstServed(Hashtable<String, Double> hashTable){
        this.hashTable = hashTable;
        this.size = this.hashTable.size();
    }
    //Calculate first come first serve in order of jobs
    //listed in a job.txt file specified or randomly generated
    public double fCFS(){
        double tempTime = 0;
        System.out.println("\n\n\n ---------------------------------------------- ");
        System.out.println(toString());
        for(int i = 1; i<=size; i++){
            job = "Job" + i;
            time = hashTable.get(job);
            tempTime += time;
            System.out.println(ANSI_BLUE + "Job "+ i + " Complete: " + tempTime + ANSI_RESET);
            totalTime += tempTime;
        }
        //mean process turnaround time
        System.out.println(toString());
        System.out.println(" ---------------------------------------------- ");
        return totalTime/size;
    }
    /**Utilize a toString method in the fCFS algorithm to print what is inside the hash table
     * and other variables at any given moment
     *
     * Auto generated toString, equals, and hashCode methods, for use in the program is
     * only the toString method.
     *
     */
    @Override
    public String toString() {
        return "FirstComeFirstServed{" +
                "size=" + size +
                ", job='" + job + '\'' +
                ", time=" + time +
                ", totalTime=" + totalTime +
                ", hashTable=" + hashTable +
                '}';
    }
    //Automatically generated equals function to show if the object matches up to other industry standard, but isn't used in the program
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FirstComeFirstServed)) return false;
        FirstComeFirstServed that = (FirstComeFirstServed) o;
        return size == that.size &&
                time == that.time &&
                Double.compare(that.totalTime, totalTime) == 0 &&
                Objects.equals(job, that.job) &&
                Objects.equals(hashTable, that.hashTable);
    }
    //auto generated
    @Override
    public int hashCode() {
        return Objects.hash(size, job, time, totalTime, hashTable);
    }
}
