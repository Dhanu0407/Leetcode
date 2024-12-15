
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store classes based on the gain from adding a student
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> 
            Double.compare(b[0], a[0]) // Compare by gain
        );
        
        // Add each class to the heap with its initial gain
        for (int[] cls : classes) {
            int pass = cls[0], total = cls[1];
            double gain = gainFromAddingStudent(pass, total);
            maxHeap.offer(new double[]{gain, pass, total});
        }
        
        // Distribute extra students
        while (extraStudents > 0) {
            // Get the class with the highest gain
            double[] current = maxHeap.poll();
            double gain = current[0];
            int pass = (int) current[1];
            int total = (int) current[2];
            
            // Add one student
            pass++;
            total++;
            extraStudents--;
            
            // Recompute the gain and push back to the heap
            double newGain = gainFromAddingStudent(pass, total);
            maxHeap.offer(new double[]{newGain, pass, total});
        }
        
        // Compute the final average pass ratio
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] current = maxHeap.poll();
            int pass = (int) current[1];
            int total = (int) current[2];
            totalRatio += (double) pass / total;
        }
        
        return totalRatio / classes.length;
    }
    
    // Helper method to calculate the gain from adding a student
    private double gainFromAddingStudent(int pass, int total) {
        double currentRatio = (double) pass / total;
        double newRatio = (double) (pass + 1) / (total + 1);
        return newRatio - currentRatio;
    }
}
