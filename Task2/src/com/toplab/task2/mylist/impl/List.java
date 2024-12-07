package com.toplab.task2.mylist.impl;

import com.toplab.task2.mylist.MyList;

import java.util.Arrays;
//import java.util.Objects;

public class List implements MyList {
    private Object[] arr;
    private  int size;//元素个数

    public List() {

    }
    public Object[] getArr(){
        return arr;
    }


    //初始化
    public void Initialize(int capacity) {
        if (capacity < 0) {
            System.out.println("初始化数组出现异常，容量最少为1");
        }
        arr = new Object[capacity];
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("获取元素时索引超出范围");
            return null;
        }
        return arr[index];
    }

    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index >= arr.length) {
            System.out.println("设置元素时索引超出范围");
        }
        if (arr[index] == null)
        {
            size++;
        }
        arr[index] = element;
        return arr[index];
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null&&arr[i].equals(o))//equals使用不能有null参与
                return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Object[] c) {
        for (int i = 0; i < c.length; i++) {
            if (!contains(c[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
//        if (size == 0)//size是静态变量；
//            return true;
//        else
//            return false;
//        return size == 0;
        for (int i = 0;i< arr.length;i++){
            if(arr[i] != null){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean add(Object e) {
        if (size == arr.length)
        {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[size++] = e;
        }
        else{
            arr[size++] = e;
        }
        return (arr[size-1] != null);


//        int count = size;
//        for (int i = 0; i < arr.length; i++) {
//            if (count == 0) {
//                arr[i] = e;
//                size++;
//                return true;
//            }
//            if
//            (arr[i] != null) {
//                count--;
//            }
//        }
//        System.out.println("最大索引位置不为空");
//        return false;//设置为布尔值，因为是面向对象编程，注重结果，不是给用户展示过程
        //也为其他方法编写提供了便利
    }

    @Override
    public boolean addAll(Object[] e) {
        for (int i = 0; i < e.length; i++) {
            if (!add(e[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(Object e) {
        for (int i = 0; i < size; i++) {
            if ((e == null &&arr[i] == null) || (e != null && e.equals(arr[i]))) {
                // 找到匹配的元素，删除它
                for (int j = i; j < size - 1; j++) {
                    arr[j] = arr[j + 1]; // 元素向前移动
                }
                arr[--size] = null; // 清空最后一个元素
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Object[] e) {
        for (int i = 0; i < e.length; i++) {
            if (!remove(e[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {

        Arrays.fill(arr, null);
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null){
            return  -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null&&arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null){
            return  -1;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i]!=null&&arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof List)) return false;
        List list = (List) o;
        return Arrays.equals(arr, list.arr);
    }


    @Override
    public String toString() {
        return   Arrays.toString(arr);

    }
}
