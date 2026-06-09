import java.util.HashMap;
import java.util.Map;

public class FinalPractice {
    public static void main(String[] args) {
        // Feel free to call your methods here to experiment

        // YOU MUST ALSO MAKE THOROUGH TESTS FOR EVERY METHOD 
    }

    /**
     * Return the sum of the values at odd indexes in a linked list.
     * 
     * Assumes head is at index 0.
     * 
     * If passed a null head, returns 0.
     * 
     * @param head the head of the linked list
     * @return the sum of the values at odd indexes
     */
    public static int oddIndexSum(ListNode head) {
        if (head == null) {
            return 0;
        }

        boolean indexEven = true;
        int sum = 0;

        while (head.next != null) {
            if (indexEven == true) {
                head = head.next;
                indexEven = false;
            }
            if (indexEven == false) {
                sum += head.data;
                head = head.next;
                indexEven = true;
            }
        }
        return sum;
    }

    /**
    Given a reference to the head of a linked list, 
    return the largest of only the last 3 values of the list.
    Example:
    Linked List:
    7 -> 3 -> 19 -> 21 -> 14 -> 33 -> 8 -> 26 -> 11 -> 5
    Expected Answer: 26
    Last 3 values are: 26  11  5, the largest of which is 26
    **/
    public static int bigLastThree(ListNode head) {
        int big = Integer.MIN_VALUE;

        if (head == null) {
            return big;
        }

        ListNode one = head;
        ListNode two = head;
        ListNode three = head;

        if (two == head && head.next != null) {
            two = head.next;
        }
        if (three == head && head.next.next != null) {
            three = head.next.next;
        }

        while (three.next != null) {
            one = one.next;
            two = two.next;
            three = three.next;
        }

        if (one.data >= two.data && one.data >= three.data) {
            big = one.data;
        }
        if (two.data >= one.data && two.data >= three.data) {
            big = two.data;
        }
        if (three.data >= one.data && three.data >= two.data) {
            big = three.data;
        }

        return big;        
    }

    /**
     * Given a reference to the root of a tree, 
     * return the sum of the leaf nodes with even values in the tree. 
     * Do not include any odd or branch nodes.
     * Example: 
     * Tree:
     *            12
     *          /    \
     *         6      18
     *        / \    /  \
     *       4   8  16   20
     *      /               \
     *     3                22
     *
     * Expected Answer: 46
     * The leaf nodes are 3   8   16   22, and the even ones are 8   16   22.
     * The sum of the even leaf nodes is 8+16+22 = 46
     */
    public static int evenLeafSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        //is this a leaf
        if (root.left == null && root.right == null) {
            //is it even
            if (root.data % 2 == 0) {
                sum += root.data;
            }
        }

        sum += evenLeafSum(root.left);
        sum += evenLeafSum(root.right);

        return sum;
    }

    /**
     * Given a reference to the root of a tree, 
     * return the sum of the branch nodes with odd values in the tree. 
     * Do not include any even or leaf nodes.
     * Example:
     * Tree:
     *            15
     *          /    \
     *         9      4
     *        / \    /  \
     *       8   11 21   30
     *      / \        \
     *     2   6        23
     * 
     * Expected Answer: 45
     * The branch nodes are 15  9  4  8  21, 
     * and the odd ones are 15  9   21
     * The sum of the odd branch nodes is 15+9+21=45
     * 
     */

    public static int oddBranchSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        //is this a branch?
        if (root.left != null || root.right != null) {
            //is it odd?
            if (root.data % 2 != 0) {
                sum += root.data;
            }
        }

        sum += oddBranchSum(root.left);
        sum += oddBranchSum(root.right);

        return sum;
    }

    /**
     * Given a reference to a head node in a linked list of integers, 
     * return a Map<Integer, Integer> containing each value along with the number of times it shows up.
     * Example:
     * Linked List:
     * 4 -> 34 -> 4 -> 16 -> 4 -> 16 -> 29 -> 8 -> 8
     * 
     * Expected Return Map (order is unimportant): 
     * { 
     *   4: 3,
     *   8: 2,
     *   16: 2,
     *   29: 1,
     *   34: 1
     * } 
     * Explanation
     * 4 shows up three times
     * 8 shows up two times
     * 16 shows up two times
     * 29 shows up one time
     * 34 shows up one time
     * 
     */
    public static Map<Integer, Integer> nodeMapCount(ListNode head) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if (head == null) {
            return map;
        }

        while (head != null) {
            //if the key alreayd exists add 1 to the value
            if (map.containsKey(head.data)) {
                map.put(head.data, map.get(head.data) + 1);
            }

            //if it doesn't exist add it to the map
            if (map.containsKey(head.data) == false) {
                map.put(head.data, 1);
            }

            head = head.next;
        }
        return map;
    }
}
