package Sequence;

import java.util.PriorityQueue;

public class Test0295 {
}

class MedianFinder02 {
    int [] values;
    int size;
    public MedianFinder02() {
        size = 0;
        values = new int[10];
    }

    public void addNum(int num) {
        int index=0;

        if (size>0){
            int l=0,r=size-1;
            while (l<=r){
                int mid=(l+r)/2;
                int value = values[mid];

                if (value<num){
                    l=++mid;
                }else if (value>num){
                    r=--mid;
                }else {
                    l=mid;
                    break;
                }
            }
            index=l;
        }

        int[] temp = values;
        if (size+1<values.length){
            values=new int[values.length];
        }else {
            values=new int[values.length*2];
        }

        System.arraycopy(temp,0,values,0,index);
        values[index]=num;
        System.arraycopy(temp,index,values,index+1,size-index);

        size++;
    }

    public double findMedian() {
        int mid = size / 2;
        return size%2==0? (values[mid]+values[mid-1])/2.0:values[mid];
    }
}


class MedianFinder01 {

    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    double median;

    /** initialize your data structure here. */
    public MedianFinder01() {
        pq1 = new PriorityQueue<>((a,b) -> b - a);
        pq2 = new PriorityQueue<>();
        median = Double.MAX_VALUE;
    }

    public void addNum(int num) {
        if(num < median) {
            pq1.offer(num);
        } else {
            pq2.offer(num);
        }
        while(Math.abs(pq1.size() - pq2.size()) > 1) {
            if(pq1.size() > pq2.size()) {
                pq2.offer(pq1.poll());
            } else {
                pq1.offer(pq2.poll());
            }
        }
        if(pq1.size() == pq2.size()) {
            median = (pq1.peek() + pq2.peek()) / 2.0;
        } else {
            median = pq1.size() > pq2.size()? pq1.peek() : pq2.peek();
        }
    }

    public double findMedian() {
        return median;
    }
}

class MedianFinder03 {

    double mid=Double.MAX_VALUE;
    PriorityQueue<Integer> l;
    PriorityQueue<Integer> r;

    public MedianFinder03() {
        l=new PriorityQueue<>((a,b) -> b - a);
        r=new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (num < mid) l.offer(num);
        else r.offer(num);

        int t = l.size() - r.size();
        if (t<-1) l.offer(r.poll());
        else if (t>1) r.offer(l.poll());

        if (l.size()==r.size()) mid=(l.peek()+r.peek())/2.0;
        else mid=l.size()>r.size()?l.peek():r.peek();
    }

    public double findMedian() {
        return mid;
    }
}