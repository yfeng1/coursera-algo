/**
 * Author: Yang FENG
 * 7/15/16
 */
package common.mst;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;
import java.util.Scanner;


public class MstFileReader {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public static void load(File file, List<Node> nodes, List<Edge> edges) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        int nbNode = s.nextInt();
        int nbEdge = s.nextInt();
        for (int i = 1; i <= nbNode; i++) {
            nodes.add(new Node(i));
        }
        for (int j = 0; j < nbEdge; j++) {
            Node from = nodes.get(s.nextInt() - 1);
            Node to = nodes.get(s.nextInt() - 1);
            int cost = s.nextInt();
            Edge newEdge = new Edge(from, to, cost);
            from.addEdge(newEdge);
            to.addEdge(newEdge);
            edges.add(newEdge);
        }
    }

}
