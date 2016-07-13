/**
 *  Copyright Murex S.A.S., 2003-2016. All Rights Reserved.
 *
 *  This software program is proprietary and confidential to Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights, shall not be accessed, used, reproduced or distributed without the
 *  express prior written consent of Murex and subject to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly prohibited.
 */
package common.jobschedule; /**
                             *  Copyright Murex S.A.S., 2003-2016. All Rights Reserved.
                             *
                             *  This software program is proprietary and confidential to Murex S.A.S and its affiliates
                             * ("Murex") and, without limiting the generality of the foregoing reservation of rights,
                             * shall not be accessed, used, reproduced or distributed without the
                             *  express prior written consent of Murex and subject to the applicable Murex licensing
                             * terms. Any modification or removal of this copyright notice is expressly prohibited.
                             */

import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.Scanner;

import com.google.common.collect.Lists;


/**
 * Copyright Murex S.A.S., 2003-2016. All Rights Reserved. This software program is proprietary and confidential to
 * Murex S.A.S and its affiliates ("Murex") and, without limiting the generality of the foregoing reservation of rights,
 * shall not be accessed, used, reproduced or distributed without the express prior written consent of Murex and subject
 * to the applicable Murex licensing terms. Any modification or removal of this copyright notice is expressly
 * prohibited.
 */
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
