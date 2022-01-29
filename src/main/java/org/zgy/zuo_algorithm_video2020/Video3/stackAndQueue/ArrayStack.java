package org.zgy.zuo_algorithm_video2020.Video3.stackAndQueue;

import java.util.Arrays;

/**
 * @author ：z
 * @date ：Created in 2021/9/20 下午7:41
 * @description： 数组实现固定长度的栈
 */
public class ArrayStack<T> {

    //已使用长度
    int size;
    //最大长度
    int maxSize;
    T [] arr;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = (T[]) new Object[maxSize];
    }

    public void push(T value){
        if(size==maxSize){
            throw new RuntimeException("Stack is full,can not push any more.");
        }
        arr[size++]=value;
    }

    public T pop(){
        if (size==0){
            throw new RuntimeException("Stack is empty.");
        }
        return arr[--size];
    }

    private int nextIndex(int index){
        if(index==maxSize){
            return 0;
        }else{
            return index+1;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
