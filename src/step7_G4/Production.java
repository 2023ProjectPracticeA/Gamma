package step7_G4;

public final class Production {
    private Symbol nonTerminal;
    private Symbol[] rightSide;

    public Production(Symbol nonTerminal, Symbol[] rightSide) {
        this.nonTerminal = nonTerminal;
        this.rightSide = rightSide;
    }

    public Symbol getNonTerminal() {
        return nonTerminal;
    }

    public void setNonTerminal(Symbol nonTerminal) {
        this.nonTerminal = nonTerminal;
    }

    public Symbol[] getRightSide() {
        return rightSide;
    }

    public void setRightSide(Symbol[] rightSide) {
        this.rightSide = rightSide;
    }
}
