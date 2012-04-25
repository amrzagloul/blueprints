package com.tinkerpop.blueprints.pgm.util.wrappers.event;

import com.tinkerpop.blueprints.pgm.Edge;
import com.tinkerpop.blueprints.pgm.Vertex;
import com.tinkerpop.blueprints.pgm.util.wrappers.event.listener.GraphChangedListener;
import com.tinkerpop.blueprints.pgm.util.wrappers.event.util.EventEdgeSequence;

import java.util.List;

/**
 * An vertex with a GraphChangedListener attached.  Those listeners are notified when changes occur to
 * the properties of the vertex.
 *
 * @author Stephen Mallette
 */
public class EventVertex extends EventElement implements Vertex {
    public EventVertex(final Vertex rawVertex, final List<GraphChangedListener> graphChangedListeners) {
        super(rawVertex, graphChangedListeners);
    }

    public Iterable<Edge> getInEdges(final Object... filters) {
        return new EventEdgeSequence(((Vertex) this.rawElement).getInEdges(filters).iterator(), this.graphChangedListeners);
    }

    public Iterable<Edge> getOutEdges(final Object... filters) {
        return new EventEdgeSequence(((Vertex) this.rawElement).getOutEdges(filters).iterator(), this.graphChangedListeners);
    }

    public Vertex getRawVertex() {
        return (Vertex) this.rawElement;
    }
}
