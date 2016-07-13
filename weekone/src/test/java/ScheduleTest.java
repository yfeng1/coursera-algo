/**
 *  Copyright Murex S.A.S., 2003-2016. All Rights Reserved.
 * 
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */

import java.util.ArrayList;
import java.util.Comparator;

import com.google.common.collect.Lists;

import common.jobschedule.Job;
import common.jobschedule.Schedule;

import org.junit.Assert;
import org.junit.Test;


public class ScheduleTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    private final Comparator<Job> comparator = Schedule.getRatioComparator();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Test
    public void testGetWeightedSum1() throws Exception {
        ArrayList<Job> jobs = Lists.newArrayList(new Job(1, 1), new Job(1, 2), new Job(1, 3));
        long weightedSum = Schedule.getWeightedSum(jobs, comparator);
        Assert.assertEquals(10, weightedSum);

        jobs = Lists.newArrayList(new Job(1, 3), new Job(1, 2), new Job(1, 1));
        weightedSum = Schedule.getWeightedSum(jobs, comparator);
        Assert.assertEquals(10, weightedSum);
    }

    @Test
    public void testGetWeightedSum2() throws Exception {
        ArrayList<Job> jobs = Lists.newArrayList(new Job(1, 1), new Job(2, 1), new Job(3, 1));
        long weightedSum = Schedule.getWeightedSum(jobs, comparator);
        Assert.assertEquals(10, weightedSum);

        jobs = Lists.newArrayList(new Job(3, 1), new Job(2, 1), new Job(1, 1));
        weightedSum = Schedule.getWeightedSum(jobs, comparator);
        Assert.assertEquals(10, weightedSum);

    }

    @Test
    public void testGetWeightedSum3() throws Exception {
        ArrayList<Job> jobs = Lists.newArrayList(new Job(1, 1), new Job(2, 2), new Job(3, 3));
        long weightedSum = Schedule.getWeightedSum(jobs, comparator);
        Assert.assertEquals(25, weightedSum);

        jobs = Lists.newArrayList(new Job(3, 3), new Job(2, 2), new Job(1, 1));
        weightedSum = Schedule.getWeightedSum(jobs, comparator);
        Assert.assertEquals(25, weightedSum);
    }

}
