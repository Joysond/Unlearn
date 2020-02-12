import java.math.BigInteger;

public class TriesDataStructure {
    public static void main(String[] args) {
        /**
         * This is just a sample Trie data structure !
         */
        TrieNode root = new TrieNode('*');
        insert("pqrst", root);
        //insert("pqsst", root);
        find("pqrst", root);
        update("pqsrt", "pssrt", root);
        String s = new StringBuilder().reverse().toString();
    }

    private static void insert(String someString, TrieNode root) {
        TrieNode tempNode = root;
        for(int i = 0; i < someString.length(); i++) {
            if(someString.charAt(i) == '$') {
                throw new RuntimeException("$ character is not allowed");
            }
            boolean noneMatched = true;
            if(tempNode.getCharacters() != null) {
                for(TrieNode node : tempNode.getCharacters()) {
                    if(someString.charAt(i) == node.getCharacter()) {
                        noneMatched = false;
                        tempNode = node;
                        break;
                    }
                }
            }
            System.out.println(i + " String " + someString);
            if(noneMatched) {
                TrieNode node = new TrieNode(someString.charAt(i));
                TrieNode[] nodes = tempNode.getCharacters();
                if(nodes == null) {
                    nodes = new TrieNode[1];
                    nodes[0] = node;
                } else {
                    TrieNode[] tempArray = new TrieNode[nodes.length + 1];
                    System.arraycopy(nodes, 0, tempArray, 0, nodes.length);
                    tempArray[nodes.length] = node;
                    nodes = tempArray;
                }
                tempNode.setCharacters(nodes);
                tempNode = node;
            }
        }
        if(tempNode.getCharacter() != '*') {
            tempNode.setTerminatingCount(tempNode.getTerminatingCount()+1);
        }
    }

    private static void find(String someString, TrieNode root) {
        TrieNode tempNode = root;
        for(int i = 0; i < someString.length(); i++) {
            if(someString.charAt(i) == '$') {
                throw new RuntimeException("$ character is not allowed");
            }
            if(tempNode.getCharacters() != null) {
                for(TrieNode node : tempNode.getCharacters()) {
                    if(someString.charAt(i) == node.getCharacter()) {
                        tempNode = node;
                        break;
                    }
                }
            }
        }
        if(tempNode.getTerminatingCount() != 0) {
            System.out.println("We have reached the end of string");
        } else {
            System.err.println("Could not locate the given string " + someString);
        }
    }

    private static void delete(String someString, TrieNode root) {
        TrieNode tempNode = root;
        for(int i = 0; i < someString.length(); i++) {
            if(someString.charAt(i) == '$') {
                throw new RuntimeException("$ character is not allowed");
            }
            if(tempNode.getCharacters() != null) {
                for(TrieNode node : tempNode.getCharacters()) {
                    if(someString.charAt(i) == node.getCharacter()) {
                        tempNode = node;
                        break;
                    }
                }
            }
            tempNode.setTerminatingCount(tempNode.getTerminatingCount() - 1);
        }
    }

    private static void update(String oldString, String newString, TrieNode root) {
        delete(oldString, root);
        insert(newString, root);
    }

    public static class TrieNode {
        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        Character character;
        TrieNode[] characters;

        public Integer getTerminatingCount() {
            return terminatingCount;
        }

        public void setTerminatingCount(Integer terminatingCount) {
            this.terminatingCount = terminatingCount;
        }

        Integer terminatingCount;

        public TrieNode(Character character) {
            this.character = character;
            this.setTerminatingCount(0);
        }

        public TrieNode[] getCharacters() {
            return characters;
        }

        public void setCharacters(TrieNode[] characters) {
            this.characters = characters;
        }
    }
}
