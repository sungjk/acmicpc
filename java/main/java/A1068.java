import java.util.Scanner;

/**
 * Created by jeremy on 03/11/2019.
 */
/*
input:
5
-1 0 0 1 1
2

output:
2
 */
public class A1068 {

    public static int[] initTree(Scanner sc, int numOfNodes) {
        int[] tree = new int[numOfNodes];
        for (int i = 0; i < numOfNodes; i++) {
            tree[i] = sc.nextInt();
        }
        return tree;
    }

    private static boolean hasChild(int[] tree, int current, boolean isLeftChild) {
        if (current > 0 && tree[current] == -1) return false;
        return tree.length > current * 2 + (isLeftChild ? 1 : 2);
    }

    public static int countLeafNodes(int[] tree, int current) {
        if (tree.length == 1) return 0;
        if (current > 0 && tree[current] == -1) return 0;

        boolean hasLeftChild = hasChild(tree, current, true);
        boolean hasRightChild = hasChild(tree, current, false);
        if (!hasLeftChild && !hasRightChild) return 1;

        int count = 0;
        if (hasLeftChild) {
            count += countLeafNodes(tree, current * 2 + 1) ;
        }
        if (hasRightChild) {
            count += countLeafNodes(tree, current * 2 + 2);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfNodes = sc.nextInt();
        // initialize
        int[] tree = initTree(sc, numOfNodes);

        // delete a node
        int deleteNode = sc.nextInt();
        tree[deleteNode] = -1;

        // count the leaf nodes
        System.out.println(countLeafNodes(tree, 0));
        sc.close();
    }

}
