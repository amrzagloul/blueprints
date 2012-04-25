package com.tinkerpop.blueprints.pgm.util.wrappers.partition;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.util.wrappers.partition.util.PartitionEdgeSequence;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class PartitionVertex extends PartitionElement implements Vertex {

    public PartitionVertex(final Vertex rawVertex, final PartitionGraph graph) {
        super(rawVertex, graph);
    }

    public Iterable<Edge> getOutEdges(final Object... filters) {
        return new PartitionEdgeSequence(((Vertex) this.rawElement).getOutEdges(filters).iterator(), this.graph);
    }

    public Iterable<Edge> getInEdges(final Object... filters) {
        return new PartitionEdgeSequence(((Vertex) this.rawElement).getInEdges(filters).iterator(), this.graph);
    }

    public Vertex getRawVertex() {
        return (Vertex) this.rawElement;
    }
}
