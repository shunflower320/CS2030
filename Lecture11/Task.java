import java.util.concurrent.RecursiveTask;

class Task extends RecursiveTask<Integer> {
    int first;
    int last;

    Task(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    //is protected in RecursiveTask, so to override, this one also needs to be the same
    //Also auto-boxing does not work here, because generic type?
    protected Integer compute() { 
        if (first == last) {
            return first;
        }  
 
        int mid = (first + last) / 2;
        Task left= new Task(first, mid);
        Task right = new Task(mid + 1, last);
        System.out.println(Thread.currentThread().getName() + ": " + first + ", " + last);
        left.fork(); //will fork, but since no join, there's no collation.
        //also no error, just pointless.
        //return left.compute() + right.compute(); //main is still calling itself

        //Once forked, earlier tasks are queued to the back.
        //Workers will take the earliest tasks first, because they are bigger.
        //Later forked tasks are at put at front of queue, and are smaller.
        //forked tasks can be taken by main, if workers are all busy, but main will take the smaller tasks, are self-serviceable.

        //If you decide to fork right side also:
        //right.fork();
        //return left.join() + right.compute();
        //left side will wait for all workers to put work tgt. right side all done by main.
        //return left.join() + right.join(); means main does nothing. However, in this case, cannot set workers to 0.
        //left is called first, so it is added to the queue first, so closer to the end.
        //right is a later call, which apparently cannot be called before left is done. left is blocked.
        //So, call the "innermost" one first.
        //  ie follow the order of a.fork(); b.fork(); b.join(); a.join();
        //  Also more efficient.
    }

    public static void main(String[] args) {
        //compute from 1 to n
        int first = 1;
        int last = 10;
        Task t = new Task(first, last);
        System.out.println(t.compute());
    } 
}
