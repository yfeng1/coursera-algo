/**
 * Author: Yang FENG
 * 7/15/16
 */
/*
 * Copyright (c) 2016.
 * Author: Yang Feng
 */
package common.mst;

import java.io.File;

import java.util.List;

import com.google.common.collect.Lists;

import org.junit.Assert;
import org.junit.Test;


public class MstFileReaderTest {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void initSampleGraph(List<Edge> expectedEdges, List<Node> expectedNodes) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        /*
         * 1 2 6807
         * 2 3 -8874
         * 1 3 -1055
         */
        Edge edge1 = new Edge(node1, node2, 6807);
        Edge edge2 = new Edge(node2, node3, -8874);
        Edge edge3 = new Edge(node1, node3, -1055);

        node1.addEdge(edge1);
        node1.addEdge(edge3);

        node2.addEdge(edge2);
        node2.addEdge(edge1);

        node3.addEdge(edge2);
        node3.addEdge(edge3);

        expectedEdges.add(edge1);
        expectedEdges.add(edge2);
        expectedEdges.add(edge3);

        expectedNodes.add(node1);
        expectedNodes.add(node2);
        expectedNodes.add(node3);
    }

    @Test
    public void testLoad() throws Exception {
        File file = new File("D:\\codinggame\\coursera-algo\\coursera-algo\\coursera-algo\\weekone\\src\\test\\resources\\testedges1");
        List<Node> nodes = Lists.newArrayList();
        List<Edge> edges = Lists.newArrayList();
        MstFileReader.load(file, nodes, edges);
        List<Edge> expectedEdges = Lists.newArrayList();
        List<Node> expectedNodes = Lists.newArrayList();
        initSampleGraph(expectedEdges, expectedNodes);

        Assert.assertEquals("edges check", expectedEdges, edges);
        Assert.assertEquals("nodes check", expectedNodes, nodes);
    }

}
