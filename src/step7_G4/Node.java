package step7_G4;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private Symbol symbol;
    private List<Node> children;

    public Node(Symbol symbol) {
        this.symbol = symbol;
        this.children = new ArrayList<>();
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    // Optional: Add a method to add multiple children at once
    public void addChildren(List<Node> children) {
        this.children.addAll(children);
    }

    // Optional: A method to represent the node as a string for debugging
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(symbol.getIdentifier());
        if (!children.isEmpty()) {
            sb.append(" -> ");
            children.forEach(child -> sb.append(child.getSymbol().getIdentifier()).append(" "));
        }
        return sb.toString().trim();
    }
}
