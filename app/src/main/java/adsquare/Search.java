package adsquare;

import java.util.Collection;

public interface Search <T extends Comparable> {
    T findBiggestElement(Collection<T> elements, int position);
}
