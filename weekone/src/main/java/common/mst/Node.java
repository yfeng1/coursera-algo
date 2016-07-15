/**
 * Author: Yang FENG
 * 7/15/16
 */
package common.mst;

import java.util.Objects;
import java.util.Set;

import com.google.common.collect.Sets;


public class Node {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    private final int id;
    private final Set<Edge> edges = Sets.newHashSet();

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public Node(int id) {
        this.id = id;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    public Set<Edge> getEdges() {
        return edges;
    }

    public boolean addEdge(Edge e) {
        return edges.add(e);
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (getClass() != o.getClass()))
            return false;
        Node node = (Node) o;
        return id == node.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
