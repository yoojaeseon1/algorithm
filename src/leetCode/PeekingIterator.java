package leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 헷갈렸던 부분
 * - list를 필드로 선언만하고 초기화를 안해서 NullPoint Exception이 발생했다.
 * 
 * 해결방법
 * - list 초기화
 * 
 */

public class PeekingIterator implements Iterator<Integer> {

    private int pointer;
    private List<Integer> list;


    public PeekingIterator(Iterator<Integer> iterator) {
        list = new ArrayList<>();
        while(iterator.hasNext()) {
            Integer element = iterator.next();
            if (element != null) {
                list.add(element);
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

//        while(iterator.hasNext())
//            list.add(iterator.next());

        PeekingIterator iter = new PeekingIterator(list.iterator());

        System.out.println(iter.next());
        System.out.println(iter.peek());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());



    }

    @Override
    public boolean hasNext() {

        return pointer < list.size();
    }

    @Override
    public Integer next() {

        return list.get(pointer++);
    }

    public Integer peek(){

        return list.get(pointer);

    }



}
