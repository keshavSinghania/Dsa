class Solution {
    //a special variable which will store task character and its freq
    class Task{
        char task;
        int freq;
        //constructor
        Task(char task, int freq){
            this.task = task;
            this.freq = freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        // first take the freq of all the tasks
        HashMap<Character,Integer> taskFreq = new HashMap<>();
        HashMap<Character,Integer> nextValidInterval = new HashMap<>();

        for(char task : tasks){
            taskFreq.put(task, taskFreq.getOrDefault(task,0) + 1);
            nextValidInterval.put(task, 1);
        }

        //convert our tasks into heap based on freq so that task with higher freq can be extracted first
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        // loop to put all the element from the taskFreq to maxHeap
        for(char task : taskFreq.keySet()){
            int freq = taskFreq.get(task);
            maxHeap.offer(new Task(task, freq));
        }

        int currentInterval = 1;
        int totalInterval = 0;

        //run a loop until you finished all the task from the hashmap
        while(!maxHeap.isEmpty()){
            //temp Tash ArrayList to push element if not possible to push
            ArrayList<Task> temp = new ArrayList<>();
            boolean executed = false;
            while(!maxHeap.isEmpty()){
                Task topTask = maxHeap.poll();
                if(nextValidInterval.get(topTask.task) <= currentInterval){
                    topTask.freq--;
                    if(topTask.freq > 0){
                        nextValidInterval.put(topTask.task, currentInterval + n + 1);
                        maxHeap.offer(topTask);
                    }
                    executed = true;
                    break;
                }else{
                    //add to the arraylist
                    temp.add(topTask);
                }
            }
                for(int i = 0; i < temp.size(); i++){
                    maxHeap.offer(temp.get(i));
                }
                currentInterval++;
                totalInterval++;
            }
        return totalInterval;
    }
}