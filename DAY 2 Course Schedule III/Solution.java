class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses,(a,b)->a[1]-b[1]); //Sort the courses by their lastDay
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int time=0;
        for (int[] c:courses) 
        {
            time+=c[0]; 
            pq.add(c[0]);
            if (time>c[1]) time-=pq.poll(); //If time exceeds, drop the previous course which costs the most time.
        }        
        return pq.size();
        
    }
}
