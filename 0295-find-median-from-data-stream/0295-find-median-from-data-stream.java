class MedianFinder {
    PriorityQueue<Double> leftMaxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));
    PriorityQueue<Double> rightMinHeap = new PriorityQueue<>();
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        double num1 = num;
        if(leftMaxHeap.isEmpty()){
            leftMaxHeap.offer(num1);
            return;
        }

        double leftPeak = leftMaxHeap.peek();
        if(num1 <= leftPeak){
            leftMaxHeap.offer(num1);
        }else{
            rightMinHeap.offer(num1);
        }

        //make sure size1 + 1 == size2 || size1 == size1 || or size1 = size2 + 1

        if(leftMaxHeap.size() >  rightMinHeap.size() + 1){
            rightMinHeap.offer(leftMaxHeap.poll());
            return;
        }else if(rightMinHeap.size() > leftMaxHeap.size() + 1){
            leftMaxHeap.offer(rightMinHeap.poll());
            return;
        }
        return;
    }
    
    public double findMedian() {

        //if odd length
        if(leftMaxHeap.size() > rightMinHeap.size()){
            return leftMaxHeap.peek();
        }else if(leftMaxHeap.size() < rightMinHeap.size()){
            return rightMinHeap.peek();
        }else{
            //even length case
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */