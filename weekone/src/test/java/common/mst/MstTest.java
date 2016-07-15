/**
 * Author: Yang FENG
 * 7/15/16
 */
/*
 * Copyright (c) 2016.
 * Author: Yang Feng
 */
package common.mst;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

import static org.junit.Assert.*;
import org.junit.Test;


public class MstTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Test
    public void testGetMstEdges() throws Exception {
        List<Edge> edges = Lists.newArrayList();
        List<Node> nodes = Lists.newArrayList();
        MstFileReaderTest.initSampleGraph(edges, nodes);

        Set<Edge> mstEdges = Mst.getMstEdges(nodes);
        System.out.println("Finished.");
    }
}
