/**
 * Name: Chris Saba
 * Professor: Gilbert Young
 * Date: 6/20/20
 *
 * Project Name: Job Scheduler
 *
 * First-Come-First-Serve (FCFS)
 *
 * Shortest-Job-First (SJF)
 *
 * Round-Robin with Time Slice = 2 (RR-2)
 *
 * Round-Robin with Time Slice = 5 (RR-5)
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

/**
 * ANSI_COLOR is implemented for a cleaner, color coded output,
 * if your IDE does not support it, please remove all the ANSI_**** from the print statements
 * This is tested and working inside of IntelliJ IDE. but may not work from older methods of IDE/console.
 * Be sure to test the output for colors before removal, as these colors are supported in java formats.
 * ANSI_COLOR should not give any errors if it does not support it, but may add some unsightly text before each output line.
 */
public class JobScheduler implements ANSI_COLOR{
    //Using Number of Tests, we calculate average turnaround times per algorithm.
    private static final int numberOfTests = 20;
    //We will use a Hash Table data structure, since our size is predefined to max at 30, and will bring constant O(1) time complexity in search/insert/delete of entries.
    private static Hashtable<String, Double> hashTable = new Hashtable<>(30);
    //Hashtable entries may be implemented in arraylists from the algorithm, more info in their java class files.

    public static void main(String[] args){
        //Create input for number of jobs.
        Scanner sc = new Scanner(System.in);
        String input;
        //Initialize testCounter and algorithm averages to 0.
        int testCounter = 0;
        double fcfsAverage = 0;
        double sjfAverage = 0;
        double rr2Average = 0;
        double rr5Average = 0;
        boolean useInputFile = false;
        File inputFile = null;
        int intUser = 0;
        File file = null;
        //Check user input of job count, when pass, it will initialize intUser with the job number.
        while(true) {
            System.out.println(ANSI_CYAN + "Enter number of jobs for JobScheduler." +
                    "The jobs entered will be random in time, bound up to 50 ms per job. " +
                    "You may use 5, 10, 15, 20, 25, or 30 jobs \n " +
                    "You can also type ''specify'' to input a file location for job.txt" + ANSI_RESET);
            input = sc.nextLine();
            if(input.equals("5") | input.equals("10") | input.equals("15") | input.equals("20") | input.equals("25")| input.equals("30")){
                break;
            }
            else if(input.equalsIgnoreCase("specify")){
                System.out.println("Enter the location of the Job.txt file");
                useInputFile = true;
               String fileInputTxt = sc.nextLine();
                inputFile = new File(fileInputTxt);
                break;
            }
            else{
                System.err.println("Please use the correct input suggestions.");
            }
        }
        if(!useInputFile) {
            sc = new Scanner(input);
            intUser = sc.nextInt();
        }
        Scanner jobInput;

        //Create Job#.txt file with increasing job# per line, and random job size bound by 50 ms
        while(testCounter < numberOfTests) {
            if(!useInputFile) {
                file = new File("Job" + input + ".txt");

                Random rand = new Random();
                try {
                    FileWriter writer = new FileWriter(file, false);
                    for (int i = 1; i <= intUser; i++) {
                        writer.write("Job" + i + "\n"); //Job # increasing
                        writer.write("" + (rand.nextInt(50)) + "\n"); //Job size random
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //Create Hash Table with file previously created sorted by Job#
            //Or specify your own Job.txt file instead of the randomly generated Job.txt
            try {
                if(useInputFile){
                    jobInput = new Scanner(inputFile);
                }
                else {
                    jobInput = new Scanner(file);
                }
                String tempJob;
                double tempTime;
                while (jobInput.hasNextLine()) {
                    tempJob = jobInput.nextLine();
                    tempTime = jobInput.nextDouble();
                    hashTable.put(tempJob, tempTime);
                    if (jobInput.hasNextLine())
                       jobInput.nextLine();
                }
                jobInput.close();
            } catch (FileNotFoundException o) {
                System.exit(0);
            }
            //Calculate all the algorithms.
            FirstComeFirstServed fcfs = new FirstComeFirstServed(hashTable);
            ShortestJobFirst sjf = new ShortestJobFirst(hashTable);
            RoundRobin2 rr2 = new RoundRobin2(hashTable);
            RoundRobin5 rr5 = new RoundRobin5(hashTable);

            fcfsAverage += fcfs.fCFS();
            sjfAverage += sjf.sJF();
            rr2Average += rr2.rR2();
            rr5Average += rr5.rR5();

            testCounter++;
        }
        System.out.println("Here are the averages for the four different algorithms using this many tests: " + numberOfTests + " for this many jobs: " + intUser + "\n");
        System.out.println("First Come First Served Average turnaround time: " + fcfsAverage/numberOfTests+"ms \n");
        System.out.println("Shortest Job First Average turnaround time: " + sjfAverage/numberOfTests+"ms \n");
        System.out.println("Round Robin with a time splice of 2ms Average turnaround time: " + rr2Average/numberOfTests+"ms \n");
        System.out.println("Round Robin with a time splice of 5ms Average turnaround time: " + rr5Average/numberOfTests +"ms \n");
        System.out.println("Done!");



    }
}
