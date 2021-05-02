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


//==========================================================================================================================================

class Solution {

    // TC : O(nlogn)
    // SC : O(n)
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> (a[1] - b[1]));

        // Course duration of the selected ones
        PriorityQueue<Integer> pq = new PriorityQueue<Integer> ((a,b) -> (b-a));

        int timeElapsed = 0;
        for(int[] course : courses){
            if(timeElapsed + course[0] <= course[1]){
                pq.offer(course[0]);
                timeElapsed += course[0];
            } else if(!pq.isEmpty() && pq.peek() > course[0]){
                timeElapsed = timeElapsed - pq.poll();
                pq.offer(course[0]);
                timeElapsed = timeElapsed + course[0];
            } else {
                // pq.peek() < course[0]
                // reject the current course
            }
        }

        return pq.size(); // 3
    }
}

