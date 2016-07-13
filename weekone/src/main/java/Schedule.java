/**
 *  Copyright Murex S.A.S., 2003-2016. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Copyright Murex S.A.S., 2003-2016. All Rights Reserved. This software program is proprietary and confidential to
 * Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights,
 * shall not be accessed, used, reproduced or distributed without the express prior written consent of Murex and subject
 * to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly
 * prohibited.
 */
public class Schedule {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        try {
            String filePath = args[0];
            List<Job> jobList = JobFileReader.read(new File(filePath));


            jobList.sort(getComparator2());

            long weightSum = 0;
            long currentTime = 0;
            for (int i = 0; i < jobList.size(); i++) {
                Job job = jobList.get(i);
                currentTime += job.getLength();
                weightSum += job.getWeight() * currentTime;
            }
            System.out.println(weightSum);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Comparator<Job> getComparator() {
        return new Comparator<Job>() {
            public int compare(Job o1, Job o2) {
                int score1 = o1.getWeight() - o1.getLength();
                int score2 = o2.getWeight() - o2.getLength();
                int diffScore = score2 - score1;
                return (diffScore != 0) ? diffScore : (o2.getWeight() - o1.getWeight());
            }
        };
    }

    public static Comparator<Job> getComparator2() {
        return new Comparator<Job>() {
            public int compare(Job o1, Job o2) {
                double score1 = o1.getWeight() / o1.getLength();
                double score2 = o2.getWeight() / o2.getLength();
                return (int)(score2 - score1);
            }
        };
    }

}
