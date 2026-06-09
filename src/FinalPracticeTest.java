import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class FinalPracticeTest {

    //tests for OddIndexSum
    @Test
    void testOddIndexSum_oddLengthList() {
        ListNode list = new ListNode(4, new ListNode(8, new ListNode(15, new ListNode(16, new ListNode(23, new ListNode(42, new ListNode(11, new ListNode(29, new ListNode(34)))))))));
        int actual = FinalPractice.oddIndexSum(list);
        assertEquals(95, actual);
    }

    @Test
    void testOddIndexSum_null() {
        ListNode list = null;
        int actual = FinalPractice.oddIndexSum(list);
        assertEquals(0, actual);
    }

    @Test
    void testOddIndexSum_one() {
        ListNode list = new ListNode(67);
        int actual = FinalPractice.oddIndexSum(list);
        assertEquals(0, actual);
    }

    @Test
    void testOddIndexSum_allNegative() {
        ListNode list = new ListNode(-4, new ListNode(-8, new ListNode(-15, new ListNode(-16, new ListNode(-23, new ListNode(-42, new ListNode(-11, new ListNode(-29, new ListNode(-34)))))))));
        int actual = FinalPractice.oddIndexSum(list);
        assertEquals(-95, actual);
    }

    //tests for bigLastThree
    @Test
    void testBigLastThree_genericList() {
        ListNode list = new ListNode(4, new ListNode(8, new ListNode(15, new ListNode(16, new ListNode(23, new ListNode(42, new ListNode(11, new ListNode(29, new ListNode(34)))))))));
        int actual = FinalPractice.bigLastThree(list);
        assertEquals(34, actual);
    }

    @Test
    void testBigLastThree_allNegative() {
        ListNode list = new ListNode(-4, new ListNode(-8, new ListNode(-15, new ListNode(-16, new ListNode(-23, new ListNode(-42, new ListNode(-11, new ListNode(-29, new ListNode(-34)))))))));
        int actual = FinalPractice.bigLastThree(list);
        assertEquals(-11, actual);
    }

    @Test
    void testBigLastThree_null() {
        ListNode list = null;
        int actual = FinalPractice.bigLastThree(list);
        assertEquals(Integer.MIN_VALUE, actual);
    }

    @Test
    void testBigLastThree_three() {
        ListNode list = new ListNode(4,
                            new ListNode(8,
                                new ListNode(15)
                                        )
                                    );
        int actual = FinalPractice.bigLastThree(list);
        assertEquals(15, actual);
    }

    //evenLeafSum tests

    @Test
    void testEvenLeafSum_genericTree() {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(8);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(16);
        root.left.right = new TreeNode(23);

        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(42);

        int actual = FinalPractice.evenLeafSum(root);

        assertEquals(58, actual);
    }

    @Test
    void testEvenLeafSum_null() {
        TreeNode root = null;
        int actual = FinalPractice.evenLeafSum(root);
        assertEquals(0, actual);
    }

    @Test
    void testEvenLeafSum_oneNode() {
        TreeNode root = new TreeNode(8);
        int actual = FinalPractice.evenLeafSum(root);
        assertEquals(8, actual);
    }

    @Test
    void testEvenLeafSum_allNegative() {
        TreeNode root = new TreeNode(-4);

        root.left = new TreeNode(-8);
        root.right = new TreeNode(-15);

        root.left.left = new TreeNode(-16);
        root.left.right = new TreeNode(-23);

        root.right.left = new TreeNode(-11);
        root.right.right = new TreeNode(-42);

        int actual = FinalPractice.evenLeafSum(root);

        assertEquals(-58, actual);
    }

}


