/**
 * Author: Yang FENG
 * 7/15/16
 */
package common.jobschedule;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Comparator;
import java.util.List;


public class Schedule {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        try {
            String filePath = args[0];
            List<Job> jobList = JobFileReader.read(new File(filePath));

            Comparator<Job> comparator = getDiffComparator();
            long weightSum = getWeightedSum(jobList, comparator);
            System.out.println(weightSum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static long getWeightedSum(List<Job> jobList, Comparator<Job> comparator) {
        jobList.sort(comparator);

        long weightSum = 0;
        long currentTime = 0;
        for (int i = 0; i < jobList.size(); i++) {
            Job job = jobList.get(i);
            currentTime += job.getLength();
            weightSum += job.getWeight() * currentTime;
        }
        return weightSum;
    }

    public static Comparator<Job> getDiffComparator() {
        return new Comparator<Job>() {
            public int compare(Job o1, Job o2) {
                int score1 = o1.getWeight() - o1.getLength();
                int score2 = o2.getWeight() - o2.getLength();
                int diffScore = score2 - score1;
                return (diffScore != 0) ? diffScore : (o2.getWeight() - o1.getWeight());
            }
        };
    }

    public static Comparator<Job> getRatioComparator() {
        return new Comparator<Job>() {
            public int compare(Job o1, Job o2) {
                double score1 = o1.getWeight() / (double) o1.getLength();
                double score2 = o2.getWeight() / (double) o2.getLength();
                double diff = score2 - score1;
                return (diff != 0) ? ((diff > 0) ? 1 : -1) : (o2.getWeight() - o1.getWeight());
            }
        };
    }

}
