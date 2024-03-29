/*
**************** Problem Description ****************
Given a link list of size N, modify the list such that all the even numbers appear before all the odd numbers in the modified list.
The order of appearance of numbers within each segregation should be same as that in the original list.
  Example 1 :
  Input:
  N = 7
  Link List =
  17 -> 15 -> 8 -> 9 -> 2 -> 4 -> 6 -> NULL
  Output: 8 2 4 6 17 15 9
  Explaination: 17,15,8,9 are odd so they appear
  first and 2,4,6 are the even numbers that appear later.
  Example 2 :
  Input:
  N = 4
  Link List = 1 -> 3 -> 5 -> 7
  Output: 1 3 5 7
  Explaination: There is no even number.
  So ne need for modification.
*/
class Solution
{
    Node compute(Node head)
    {
        if(head==null)
            return null;

        Node rev=reverseList(head);
        Node revHead=rev;
        while(rev!=null && rev.next !=null)
        {
            if(rev.next.data<rev.data)
                rev.next=rev.next.next;
            else
                rev=rev.next;
        }

        return reverseList(revHead);

    }

    Node reverseList(Node head)
    {
        Node prev=null;
        while(head!=null)
        {
            Node next=head.next;
            head.next=prev;
            prev=head;
            head=next;

        }

        return prev;
    }

}

/*
**************** Logic ****************
Iterate the list and insert the even nodes at the beginning of the list.
*/