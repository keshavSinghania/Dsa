class MyStack {
    //we have to create a two queue for now
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        //add new element
        if (q1.isEmpty()) {
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        } else if (q2.isEmpty()) {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
        }
    }

    public int pop() {
        if (q1.isEmpty()) {
            return q2.poll();
        } else if (q2.isEmpty()) {
            return q1.poll();
        }
        return -1;
    }

    public int top() {
        if (q1.isEmpty()) {
            return q2.peek();
        } else if (q2.isEmpty()) {
            return q1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return (q1.isEmpty() && q2.isEmpty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */