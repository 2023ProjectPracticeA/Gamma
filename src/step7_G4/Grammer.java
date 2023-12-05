package step7_G4;

import java.util.*;

public class Grammar {
    private List<Production> productions;
    private Map<Symbol, Set<Symbol>> firstSets;
    private Map<Symbol, Set<Symbol>> followSets;

    public Grammar(List<Production> productions) {
        this.productions = productions;
        this.firstSets = new HashMap<>();
        this.followSets = new HashMap<>();
    }

    public void addProduction(Production production) {
        productions.add(production);
    }

    public void calculateFirstSets() {
        // Initialize first sets for all symbols
        for (Production production : productions) {
            firstSets.putIfAbsent(production.getNonTerminal(), new HashSet<>());
            for (Symbol symbol : production.getRightSide()) {
                firstSets.putIfAbsent(symbol, new HashSet<>());
            }
        }

        boolean changed;
        do {
            changed = false;
            for (Production production : productions) {
                Set<Symbol> productionFirstSet = getFirstSetForProduction(production);
                changed |= firstSets.get(production.getNonTerminal()).addAll(productionFirstSet);
            }
        } while (changed);
    }

    private Set<Symbol> getFirstSet(Symbol symbol) {
        if (symbol.isTerminal()) {
            return new HashSet<>(Collections.singletonList(symbol));
        }
        return firstSets.get(symbol);
    }

    private Set<Symbol> getFirstSetForProduction(Production production) {
        Set<Symbol> firstSet = new HashSet<>();
        for (Symbol symbol : production.getRightSide()) {
            Set<Symbol> symbolFirstSet = getFirstSet(symbol);
            firstSet.addAll(symbolFirstSet);
            if (!symbolFirstSet.contains(Symbol.EPSILON)) {
                break;
            }
        }
        return firstSet;
    }

    private boolean isNullable(Symbol symbol) {
        return getFirstSet(symbol).contains(Symbol.EPSILON);
    }

    public void calculateFollowSets() {
        // Initialize follow sets for all non-terminals
        for (Production production : productions) {
            if (!production.getNonTerminal().isTerminal()) {
                followSets.putIfAbsent(production.getNonTerminal(), new HashSet<>());
            }
        }

        // Add end-of-input marker to start symbol's follow set
        followSets.get(productions.get(0).getNonTerminal()).add(new Symbol(true, "$"));

        // Algorithm to calculate follow sets
        boolean changed;
        do {
            changed = false;
            for (Production production : productions) {
                Symbol[] rhs = production.getRightSide();
                for (int i = 0; i < rhs.length; i++) {
                    Symbol B = rhs[i];
                    if (!B.isTerminal()) {
                        Set<Symbol> followB = followSets.get(B);
                        int originalSize = followB.size();

                        if (i < rhs.length - 1) {
                            Set<Symbol> firstBeta = getFirstSet(rhs, i + 1);
                            followB.addAll(firstBeta);
                            followB.remove(Symbol.EPSILON);
                        }

                        if (i == rhs.length - 1 || firstSets.get(rhs[i + 1]).contains(Symbol.EPSILON)) {
                            followB.addAll(followSets.get(production.getNonTerminal()));
                        }

                        changed |= (followB.size() != originalSize);
                    }
                }
            }
        } while (changed);
    }

    private Set<Symbol> getFirstSet(Symbol[] symbols, int startIndex) {
        Set<Symbol> firstSet = new HashSet<>();
        for (int i = startIndex; i < symbols.length; i++) {
            Set<Symbol> symbolFirstSet = getFirstSet(symbols[i]);
            firstSet.addAll(symbolFirstSet);
            if (!symbolFirstSet.contains(Symbol.EPSILON)) {
                break;
            }
        }
        return firstSet;
    }

    public Map<Production, Set<Symbol>> calculateDirectorSets() {
        Map<Production, Set<Symbol>> directorSets = new HashMap<>();

        for (Production production : productions) {
            Set<Symbol> directorSet = new HashSet<>();

            // Add First set of RHS to the Director set
            Set<Symbol> firstOfRHS = getFirstSet(production.getRightSide(), 0);
            directorSet.addAll(firstOfRHS);
            directorSet.remove(Symbol.EPSILON);

            // If RHS is nullable, add Follow set of LHS to the Director set
            if (isNullable(production.getRightSide())) {
                directorSet.addAll(followSets.get(production.getNonTerminal()));
            }

            directorSets.put(production, directorSet);
        }

        return directorSets;
    }

    private boolean isNullable(Symbol[] symbols) {
        for (Symbol symbol : symbols) {
            if (!symbol.isTerminal() && !firstSets.get(symbol).contains(Symbol.EPSILON)) {
                return false;
            }
        }
        return true;
    }

    public void removeAllDirectLeftRecursion() {
        Map<Symbol, List<Production>> groupedProductions = new HashMap<>();

        // Group productions by their non-terminals
        for (Production production : productions) {
            Symbol nonTerminal = production.getNonTerminal();
            groupedProductions.putIfAbsent(nonTerminal, new ArrayList<>());
            groupedProductions.get(nonTerminal).add(production);
        }

        // Process each group of productions
        for (Symbol nonTerminal : groupedProductions.keySet()) {
            List<Production> nonTerminalProductions = groupedProductions.get(nonTerminal);
            List<Production> newProductions = new ArrayList<>();
            List<Production> recursiveProductions = new ArrayList<>();
            List<Production> nonRecursiveProductions = new ArrayList<>();

            // Separate recursive and non-recursive productions
            for (Production production : nonTerminalProductions) {
                if (Symbol.equals(production.getRightSide()[0], nonTerminal)) {
                    recursiveProductions.add(production);
                } else {
                    nonRecursiveProductions.add(production);
                }
            }

            if (!recursiveProductions.isEmpty()) {
                // Create a new non-terminal symbol
                Symbol newNonTerminal = new Symbol(false, nonTerminal.getIdentifier() + "'");

                // Transform non-recursive productions
                for (Production nrProduction : nonRecursiveProductions) {
                    Symbol[] newRHS = Arrays.copyOf(nrProduction.getRightSide(), nrProduction.getRightSide().length + 1);
                    newRHS[newRHS.length - 1] = newNonTerminal;
                    newProductions.add(new Production(nonTerminal, newRHS)); // A → βA'
                }

                // Transform recursive productions
                for (Production rProduction : recursiveProductions) {
                    Symbol[] newRHS = Arrays.copyOfRange(rProduction.getRightSide(), 1, rProduction.getRightSide().length + 1);
                    newRHS = Arrays.copyOf(newRHS, newRHS.length + 1);
                    newRHS[newRHS.length - 1] = newNonTerminal; // A' → αA'
                    newProductions.add(new Production(newNonTerminal, newRHS));
                }

                // Add epsilon production for new non-terminal
                newProductions.add(new Production(newNonTerminal, new Symbol[]{Symbol.EPSILON})); // A' → ε

                // Remove old productions and add new ones
                productions.removeAll(nonTerminalProductions);
                productions.addAll(newProductions);
            }
        }
    }
}
