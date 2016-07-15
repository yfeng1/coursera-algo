/**
 * Author: Yang FENG
 * 7/15/16
 */
package common.jobschedule;

import java.util.ArrayList;
import java.util.Comparator;

import com.google.common.collect.Lists;

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
