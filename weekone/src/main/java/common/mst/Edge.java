/**
 * Author: Yang FENG
 * 7/15/16
 */
package common.mst;

import java.util.Objects;


public class Edge {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Instance fields
    //~ ----------------------------------------------------------------------------------------------------------------

    private final Node from;
    private final Node to;
    private final int cost;

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Constructors
    //~ ----------------------------------------------------------------------------------------------------------------

    public Edge(Node from, Node to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods
    //~ ----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (getClass() != o.getClass()))
            return false;
        Edge edge = (Edge) o;
        return (cost == edge.cost) && Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, cost);
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }
}
