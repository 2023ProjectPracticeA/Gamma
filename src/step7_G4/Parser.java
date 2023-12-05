package step7_G4;

import java.util.*;

public class Parser {
    private Grammar grammar;
    private String input;
    private int position;
    private Symbol currentToken;

    public Parser(Grammar grammar) {
        this.grammar = grammar;
    }

    public Node parse(String input) {
        this.input = input;
        this.position = 0;
        this.currentToken = nextToken();

        // Assuming the start symbol of the grammar is the non-terminal of the first production
        Symbol startSymbol = grammar.getProductions().get(0).getNonTerminal();
        return buildAST(startSymbol);
    }

    private Node buildAST(Symbol symbol) {
        Node node = new Node(symbol);

        if (symbol.isTerminal()) {
            if (symbol.equals(currentToken)) {
                // Terminal matches current token, consume and advance
                currentToken = nextToken();
            } else {
                throw new RuntimeException("Syntax Error: Expected " + symbol.getIdentifier());
            }
        } else {
            // Find production based on the current symbol and lookahead token
            Production selectedProduction = findProductionFor(symbol, currentToken);
            for (Symbol rhsSymbol : selectedProduction.getRightSide()) {
                Node child = buildAST(rhsSymbol);
                node.addChild(child);
            }
        }

        return node;
    }

    private Symbol nextToken() {
        // Implement logic to get the next token from the input string
        // For simplicity, assume each character in the input string is a separate token
        if (position < input.length()) {
            char tokenChar = input.charAt(position++);
            return new Symbol(true, String.valueOf(tokenChar));
        }
        return new Symbol(true, "$"); // End of input symbol
    }

    private Production findProductionFor(Symbol nonTerminal, Symbol lookahead) {
        // Implement logic to select the appropriate production based on the current non-terminal and lookahead token
        // This is a simplified approach; actual implementation depends on the grammar and may require a parsing table
        for (Production production : grammar.getProductions()) {
            if (production.getNonTerminal().equals(nonTerminal)) {
                // For simplicity, select the first production that matches the non-terminal
                // In a real parser, you would use a more sophisticated method (like a parsing table)
                return production;
            }
        }
        throw new RuntimeException("No production found for symbol: " + nonTerminal.getIdentifier());
    }
}
