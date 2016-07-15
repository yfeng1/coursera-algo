/**
 * Author: Yang FENG
 * 7/15/16
 */
package common.mst;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


public class Mst {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        List<Node> nodes = Lists.newArrayList();
        List<Edge> edges = Lists.newArrayList();

        try {
            MstFileReader.load(new File("D:\\codinggame\\coursera-algo\\coursera-algo\\coursera-algo\\weekone\\src\\main\\resources\\edges.txt"), nodes, edges);
            Set<Edge> mst = getMstEdges(nodes);

            long minCost = 0;
            for (Edge edge : mst) {
                minCost += edge.getCost();
            }
            System.out.println(minCost);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Set<Edge> getMstEdges(List<Node> nodes) {
        PriorityQueue<Edge> queue = new PriorityQueue<Edge>(new Comparator<Edge>() {
                    public int compare(Edge o1, Edge o2) {
                        return o1.getCost() - o2.getCost();
                    }
                });
        Set<Node> alreadyPassedNodes = Sets.newHashSet();
        Set<Node> notPassedNodes = Sets.newHashSet(nodes);
        Set<Edge> mst = Sets.newHashSet();
        // Init phase, put Node 1
        Node node1 = nodes.get(0);
        alreadyPassedNodes.add(node1);
        notPassedNodes.remove(node1);
        queue.addAll(node1.getEdges());
        // Check this, queue could cnotainsmultipple same edge. TODO

        while (!notPassedNodes.isEmpty()) {
            Edge lowestCostEdge = queue.peek();
            mst.add(lowestCostEdge);
            Node notPassedNode = alreadyPassedNodes.contains(lowestCostEdge.getFrom()) ? lowestCostEdge.getTo() : lowestCostEdge.getFrom();

            alreadyPassedNodes.add(notPassedNode);
            notPassedNodes.remove(notPassedNode);
            queue.addAll(notPassedNode.getEdges());
            for (Edge edge : notPassedNode.getEdges()) {
                // Remove already have edge
                if (alreadyPassedNodes.contains(edge.getTo()) && alreadyPassedNodes.contains(edge.getFrom())) {
                    queue.removeAll(Collections.singleton(edge));
                }
            }
        }
        return mst;
    }

}
