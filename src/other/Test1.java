package other;

/**
 * <p>
 * Description：
 * <p>
 *
 * @author 余新洁
 * @since 2021/6/2
 */
public class Test1 {

    // 两个整数 以链表逆序存储 相加
    //  342  465
    //  2->4->3  5->6->4
    //  7->0->8
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Solution test = test1.new Solution();
        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        // ListNode l111 = new ListNode(3);
        l1.next = l11;
        // l11.next = l111;
        ListNode l2 = new ListNode(7);
        // ListNode l22= new ListNode(6);
        // ListNode l222= new ListNode(6);
        // l2.next = l22;
        // l22.next = l222;
        // l222.next = new ListNode(7);

        ListNode listNode = test.addTwoNumbers(l1, l2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = new ListNode();
            int nextFlag = 0;
            ListNode current = result;
            ListNode la1 = l1;
            ListNode la2 = l2;
            while (la1 != null && la2 != null){
                int sum = la1.val + la2.val + nextFlag;
                nextFlag = 0;
                if (sum >= 10){
                    sum = sum % 10;
                    nextFlag = 1;
                }

                ListNode nextNode = new ListNode(sum);
                current.next = nextNode;
                current = nextNode;
                la1 = la1.next;
                la2 = la2.next;
            }

            if (la1 == null){
                while (la2 != null){
                    int sum = la2.val + nextFlag;
                    nextFlag = 0;
                    if (sum >= 10){
                        sum = sum % 10;
                        nextFlag = 1;
                    }
                    ListNode nextNode = new ListNode(sum);
                    current.next = nextNode;
                    current = nextNode;
                    la2 = la2.next;
                }
            }else {
                while (la1 != null){
                    int sum = la1.val + nextFlag;
                    nextFlag = 0;
                    if (sum >= 10){
                        sum = sum % 10;
                        nextFlag = 1;
                    }
                    ListNode nextNode = new ListNode(sum);
                    current.next = nextNode;
                    current = nextNode;
                    la1 = la1.next;
                }

            }
            if (nextFlag != 0){
                ListNode nextNode = new ListNode(1);
                current.next = nextNode;
            }
            return result.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
