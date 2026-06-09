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
}
