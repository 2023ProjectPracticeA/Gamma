package step7_G4;

import java.util.Objects;

public final class Symbol {
    private boolean isTerminal;
    private String identifier;

    public static final Symbol EPSILON = new Symbol(true, "ε");

    public Symbol(boolean isTerminal, String identifier) {
        this.isTerminal = isTerminal;
        this.identifier = identifier;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean isTerminal) {
        this.isTerminal = isTerminal;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public static Symbol getEpsilon() {
        return EPSILON;
    }

    public static boolean isEpsilon(Symbol symbol) {
        return symbol == EPSILON;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return isTerminal == symbol.isTerminal &&
                Objects.equals(identifier, symbol.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isTerminal, identifier);
    }

    public static boolean equals(Symbol left, Symbol right) {
        if (left == null) {
            return right == null;
        }
        return left.equals(right);
    }

    public static boolean notEquals(Symbol left, Symbol right) {
        return !equals(left, right);
    }
}