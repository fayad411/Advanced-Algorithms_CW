package task4;
import java.util.*;
public class CPUScheduler {

	public static void main(String[] args) {
		 // Sample input
        Job[] jobs = {new Job(1, 0, 10), new Job(2, 0, 5)};

        // Scheduler policies
        SchedulerPolicy[] policies = {new FCFS(), new Priority(), new SRTF()};

        // Simulate scheduling process
        for (SchedulerPolicy policy : policies) {
            System.out.println(policy.getClass().getSimpleName() + ":");
            policy.schedule(jobs);
            System.out.println();
        }
    }

    // Job class representing a CPU job
    static class Job {
        int id, priority, duration;

        public Job(int id, int priority, int duration) {
            this.id = id;
            this.priority = priority;
            this.duration = duration;
        }
    }

    // Interface for scheduler policies
    interface SchedulerPolicy {
        void schedule(Job[] jobs);
    }

    // First Come First Served policy
    static class FCFS implements SchedulerPolicy {
        public void schedule(Job[] jobs) {
            int time = 0;
            for (Job job : jobs) {
                System.out.println("System time [" + time + "] - Job " + job.id + " is running.");
                time += job.duration;
            }
        }
    }

    // Highest Priority policy
    static class Priority implements SchedulerPolicy {
        public void schedule(Job[] jobs) {
            int time = 0;
            PriorityQueue<Job> queue = new PriorityQueue<>(Comparator.comparingInt(j -> -j.priority));
            queue.addAll(Arrays.asList(jobs));
            while (!queue.isEmpty()) {
                Job job = queue.poll();
                System.out.println("System time [" + time + "] - Job " + job.id + " is running.");
                time += job.duration;
            }
        }
    }

    // Shortest Remaining Time First policy
    static class SRTF implements SchedulerPolicy {
        public void schedule(Job[] jobs) {
            int time = 0;
            List<Job> list = new ArrayList<>(Arrays.asList(jobs));
            while (!list.isEmpty()) {
                list.sort(Comparator.comparingInt(j -> j.duration));
                Job job = list.get(0);
                System.out.println("System time [" + time + "] - Job " + job.id + " is running.");
                time += job.duration;
                list.remove(0);
                job.duration = 0;
                for (Job j : list) {
                    if (j.priority > job.priority) {
                        j.duration -= job.duration;
                    } else {
                        j.duration--;
                    }
                }
                list.removeIf(j -> j.duration == 0);
            }
        }
    }
}

