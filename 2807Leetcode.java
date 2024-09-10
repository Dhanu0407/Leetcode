class Solution{
    public static int Gcd(int a, int b){
        if(b==0){
            return a;
        }
        return Gcd(b, a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head){

        ListNode curr = head;

        while(curr!=null && curr.next!=null){
            int gcd = Gcd(curr.val, curr.next.val);

            ListNode gcdval = new ListNode(gcd);

            gcdval.next = curr.next;
            curr.next = gcdval;

            curr = gcdval.next;
        }
        return head;
    }
}