/**
 * Name: Chris Saba
 *
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
 *
 *
 * ANSI_COLOR is implemented for a cleaner, color coded output,
 * if your IDE does not support it, please remove all the ANSI_**** from the print statements
 * This is tested and working inside of IntelliJ IDE. but may not work from older methods of IDE/console.
 * Be sure to test the output for colors before removal, as these colors are supported in java formats.
 * ANSI_COLOR should not give any errors if it does not support it, but may add some unsightly text before each output line.
 */

---------------------------------------------------------------------------------------------
Included are 6 different .java files, 4 of which are algorithm classes, utilized by 1 other class called JobScheduler.java
JobScheduler is the driver/main program,
where you can run and choose between a random text file generated with random job times given
5, 10, 15, 20, 25, and 30.
Or you may type "specify" to bring a job file with any size or any number of jobs, given they follow
the EXACT format of Job# on one line, and a non-negative integer on the next line corresponding to the job above.
If you use more than 30 jobs, be sure to manually change the hashtable initialCapacity on this line inside of JobScheduler to the new size
located on Line 35.
35)     private static Hashtable<String, Double> hashTable = new Hashtable<>(30);  <--------------


The last class is the ANSI_COLOR interface used for color coding output text to give a nicer format and readability.

