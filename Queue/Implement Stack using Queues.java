/**
 * Problem: Implement Stack using Queues
 * Platform: Leetcode
 * Difficulty: Easy
 * Pattern: Implementation
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: Whenever a new element is added to the back of the queue, the code immediately rotates the queue by 
                removing all previously added elements from the front and pushing them back to the rear.

 * Time: O(N)
 * Space: O(N)
 */
class MyStack {

    private Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
 */
