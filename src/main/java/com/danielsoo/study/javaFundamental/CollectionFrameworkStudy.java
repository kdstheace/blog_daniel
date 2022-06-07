package com.danielsoo.study.javaFundamental;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
@Interfaces
 1. List: ArrayList, LinkedList, Stack, Vector - 순서O중복O
 2. Set: HashSet, TreeSet  - 순서x중복x
 3. Map: HashMap, TreeMap, Hashtable, Properties - 순서x중복x
 */

public class CollectionFrameworkStudy {
 /**
  @CollectionI/F
  1. C(3): Iterator iterator(), Object[] toArray(), Object[] toArray(Object[] a)
  2. R(5): boolean contains(Object o), boolean containsAll(Collection c), boolean equals(Object o), boolean isEmpty(), int size()
  3. U(2): boolean add(E e), boolean addAll(Collection c)
  4. D(4): void clear(), boolean remove(E e), boolean removeAll(Collection c), boolean retainAll(Collection c)
  */

 /**
  @ListI/F
  1. C(2): ListIterator listIterator(), ListIterator listIterator(int idx)
  2. R(4): E get(int idx), int indexOf(Object o), int lastIndexOf(Object o), List subList(int fromidx, int toidx)
  3. U(4): boolean add(int idx, E e), boolean addAll(int idx, Collection c), void sort(Comparator c), Object set(int idx, E e)
  4. D(1): Object remove(int idx)

  @ArrayList implements List
  1. C(): ArrayList(), ArrayList(Collection c), ArrayList(int initialCapacity),
           Object clone(), boolean contains(Object o)
           void ensureCapacity(int minCapacity)
  2. R(): int indexOf(Object o)
  3. U(): boolean add(E e), void add(int idx, E e), boolean addAll(Collection c), boolean addAll(int idx, Collection c)
  4. D(): void clear(),
  */



    public static void arrayListTest(){
        List<String> arrList = new ArrayList<>(); //size = 0
        List<String> arrList2 = new ArrayList<>(3);  //size = 0
        List<String> arrList3 = new ArrayList<>(arrList);  // size = 0


    }

    public static void main(String... args){
       arrayListTest();
    }
}
