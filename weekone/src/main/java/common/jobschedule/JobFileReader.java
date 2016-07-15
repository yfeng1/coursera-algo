/**
 * Author: Yang FENG
 * 7/15/16
 */
package common.jobschedule;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.Scanner;

import com.google.common.collect.Lists;


public class JobFileReader {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static List<Job> read(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        List<Job> jobs = Lists.newArrayList();
        int nb = s.nextInt();
        for (int i = 0; i < nb; i++) {
            jobs.add(new Job(s.nextInt(), s.nextInt()));
        }
        return jobs;
    }

}
