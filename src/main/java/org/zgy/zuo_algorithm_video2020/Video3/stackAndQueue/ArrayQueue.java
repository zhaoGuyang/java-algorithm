package org.zgy.zuo_algorithm_video2020.Video3.stackAndQueue;

import java.util.Arrays;

/**
 * @author ：z
 * @date ：Created in 2021/9/20 下午7:41
 * @description： 数组实现固定长度的队列
 */
public class ArrayQueue<T> {

    //push索引
    int pushIdx;
    //pop索引
    int popIdx;
    //已使用长度
    int size;
    //最大长度
    int maxSize;
    T [] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = (T[]) new Object[maxSize];
    }

    public void push(T value){
        if(size==maxSize){
            throw new RuntimeException("Queue is full,can not push any more.");
        }
        arr[pushIdx]=value;
        pushIdx=nextIndex(pushIdx);
        size++;
    }

    public T pop(){
        if (size==0){
            throw new RuntimeException("Queue is empty.");
        }
        size--;
        return arr[popIdx++];
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
