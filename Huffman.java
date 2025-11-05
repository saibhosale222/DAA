import java.util.PriorityQueue;
import java.util.Comparator;

// Node class for Huffman tree
class HuffmanNode {
    int data;           // frequency
    char c;             // character
    HuffmanNode left;   // left child
    HuffmanNode right;  // right child
}

// Comparator to order nodes by frequency (ascending)
class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class Huffman {
    // Function to print Huffman codes
    public static void printCode(HuffmanNode root, String s) {
        // Base case: leaf node
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + " : " + s);
            return;
        }
        // Traverse left and right
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        // Input characters
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        // Frequencies
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        // Priority queue for building Huffman tree
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(charArray.length, new MyComparator());

        // Create leaf nodes for each character
        for (int i = 0; i < charArray.length; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charFreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        // Build the Huffman tree
        HuffmanNode root = null;

        while (q.size() > 1) {
            // Extract two nodes with smallest frequency
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            // Create new internal node with frequency = sum of two smallest
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-'; // placeholder for internal node
            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }

        // Print Huffman Codes
        System.out.println("Character  |  Huffman Code");
        System.out.println("---------------------------");
        printCode(root, "");
    }
}
