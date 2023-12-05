package step7_G4;

import java.util.*;

public class LL1Parser {
    private Grammar grammar;
    private Map<Symbol, Map<Symbol, Production>> parsingTable;

    public LL1Parser(Grammar grammar) {
        this.grammar = grammar;
        buildParsingTable();
    }

    private void buildParsingTable() {
        // Assuming Grammar class has methods to calculate First, Follow, and Director sets
        grammar.calculateFirstSets();
        grammar.calculateFollowSets();
        Map<Production, Set<Symbol>> directorSets = grammar.calculateDirectorSets();

        parsingTable = new HashMap<>();
        // Initialize parsing table with empty maps
        for (Production production : grammar.getProductions()) {
            parsingTable.putIfAbsent(production.getNonTerminal(), new HashMap<>());
        }

        // Fill the parsing table based on the director sets
        for (Map.Entry<Production, Set<Symbol>> entry : directorSets.entrySet()) {
            Production production = entry.getKey();
            Set<Symbol> directorSet = entry.getValue();
            Map<Symbol, Production> row = parsingTable.get(production.getNonTerminal());
            for (Symbol terminal : directorSet) {
                row.put(terminal, production);
            }
        }
    }

    public Node parse(String input) {
        // Convert input string to a queue of symbols
        Queue<Symbol> inputSymbols = new LinkedList<>();
        for (char ch : input.toCharArray()) {
            inputSymbols.add(new Symbol(true, String.valueOf(ch)));
        }
        inputSymbols.add(new Symbol(true, "$")); // End-of-input symbol

        // Initialize stack with start symbol of the grammar
        Stack<Symbol> symbolStack = new Stack<>();
        symbolStack.push(new Symbol(true, "$"));
        symbolStack.push(grammar.getProductions().get(0).getNonTerminal());

        // Initialize root of the AST
        Node root = new Node(grammar.getProductions().get(0).getNonTerminal());
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!symbolStack.isEmpty()) {
            Symbol currentSymbol = symbolStack.peek();
            Symbol inputSymbol = inputSymbols.peek();

            if (currentSymbol.isTerminal()) {
                if (currentSymbol.equals(inputSymbol)) {
                    symbolStack.pop();
                    inputSymbols.poll();
                    nodeStack.pop(); // Terminal nodes are not added to AST
                } else {
                    throw new RuntimeException("Syntax Error");
                }
            } else {
                Production production = parsingTable.get(currentSymbol).get(inputSymbol);
                if (production != null) {
                    symbolStack.pop();
                    Node currentNode = nodeStack.pop();

                    // Reverse the right-hand side of the production for stack
                    Symbol[] rhs = production.getRightSide();
                    for (int i = rhs.length - 1; i >= 0; i--) {
                        symbolStack.push(rhs[i]);

                        // Create a new node for each symbol and add it as a child
                        Node childNode = new Node(rhs[i]);
                        currentNode.addChild(childNode);
                        nodeStack.push(childNode);
                    }
                } else {
                    throw new RuntimeException("Syntax Error");
                }
            }
        }

        return root; // The root of the AST
    }
}
