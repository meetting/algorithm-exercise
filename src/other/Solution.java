// package Test;
//
// /**
//  * <p>
//  * Description：
//  * <p>
//  *
//  * @author 余新洁
//  * @since 2021/6/2
//  */
// public class Solution {
//
//         // public static void main(String[] args) {
//         //     Test1.Solution s = new Solution();
//         //     s.
//         //
//         // }
//
//         public Test1.ListNode addTwoNumbers(Test1.ListNode l1, Test1.ListNode l2) {
//             Test1.ListNode result = new Test1.ListNode();
//             int nextFlag = 0;
//             Test1.ListNode current = result;
//             Test1.ListNode la1 = l1;
//             Test1.ListNode la2 = l2;
//             while (la1 != null && la2 != null){
//                 int sum = la1.val + la2.val + nextFlag;
//                 nextFlag = 0;
//                 if (sum >= 10){
//                     sum = sum % 10;
//                     nextFlag = 1;
//                 }
//
//                 Test1.ListNode nextNode = new Test1.ListNode(sum);
//                 current.next = nextNode;
//                 current = nextNode;
//                 la1 = la1.next;
//                 la2 = la2.next;
//             }
//
//             if (la1 == null){
//                 while (la2 != null){
//                     int sum = la2.val + nextFlag;
//                     nextFlag = 0;
//                     if (sum >= 10){
//                         sum = sum % 10;
//                         nextFlag = 1;
//                     }
//                     Test1.ListNode nextNode = new Test1.ListNode(sum);
//                     current.next = nextNode;
//                     current = nextNode;
//                     la2 = la2.next;
//                 }
//             }else {
//                 while (la1 != null){
//                     int sum = la1.val + nextFlag;
//                     nextFlag = 0;
//                     if (sum >= 10){
//                         sum = sum % 10;
//                         nextFlag = 1;
//                     }
//                     Test1.ListNode nextNode = new Test1.ListNode(sum);
//                     current.next = nextNode;
//                     current = nextNode;
//                     la1 = la1.next;
//                 }
//             }
//             return result;
//         }
//     }
//
//
//     class ListNode {
//         int val;
//         Test1.ListNode next;
//
//         ListNode() {
//         }
//
//         ListNode(int val) {
//             this.val = val;
//         }
//
//         ListNode(int val, Test1.ListNode next) {
//             this.val = val;
//             this.next = next;
//         }
//     }
//
