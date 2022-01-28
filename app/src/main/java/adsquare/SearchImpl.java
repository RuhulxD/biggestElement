package adsquare;

import java.util.Collection;
import java.util.PriorityQueue;

public class SearchImpl<T extends Comparable> implements Search<T> {

    private final PriorityQueue<T> priorityQueue;

    public SearchImpl() {
        this.priorityQueue = new PriorityQueue<>();
    }

    @Override
    public T findBiggestElement(Collection<T> elements, int position) {
        priorityQueue.clear();
        for (T element : elements) {
            priorityQueue.add(element);
            if (priorityQueue.size() > position) {
                priorityQueue.poll();
            }
        }
        // Not enough element
        if(priorityQueue.size() < position){
            // we could also throw exception
            return null;
        }

        return priorityQueue.poll();
    }
}
