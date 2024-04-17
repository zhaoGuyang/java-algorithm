package org.zgy.xiaohui.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author z
 * @create 2022/2/15 15:40
 */
public class my_QuickSort {

  static int i = 0;

  public static void main(String[] args) {
    int[] arr = {1, 67, 3, 26, 2, 6, 2, 6, 2, 8, 2, 8};
//    int[] arr = {1,3,4,1,2};
//    int[] arr = {5, 1, 2, 3, 4, 6};
//    int[] arr = {2, 6, 5, 4, 3, 1};
    sort(arr, 0, arr.length - 1,"group0");
//    b_QuickSort.quickSort(arr,0,arr.length-1);
//    xiaohui_QuickSort.sort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));
  }

  private static int random(int i,int j){
    Random r=new Random();
    int i1 = r.nextInt(j - i) + i;
    System.out.println("随机 " + i1 + "最大 " + j + "最小 " + i);
    return i1;
  }

  /**
   * 排序
   *
   * @param arr
   * @param startIndex
   * @param endIndex
   * @return
   */
  public static void sort(int[] arr, int startIndex, int endIndex,String group) {
    if (startIndex >= endIndex) {
      return;
    }
    //先选定基准值，可以是任意一个，这里我们就用startIndex
//    int randomIndex = startIndex;
//    int randomIndex = endIndex;
    /*int i = (int) (Math.random() * 10 % (endIndex - startIndex));
    System.out.println(i);
    System.out.println("start " + startIndex);
    int randomIndex = i + startIndex;*/
    int randomIndex = random(startIndex,endIndex);

    int pivot = arr[randomIndex];
    // 接着定义两个变量left,right，当作滑动窗口的边界。初始值如下，遍历的时候，窗口向中间缩小。
    int left = startIndex;
    int right = endIndex;
    // 接着遍历arr数组，当left>基准值时，
    System.out.println("第" + (++my_QuickSort.i) + "次递归, 基准值: " + pivot + ", 基准值INDEX: " + randomIndex + ", GROUP: " + group + " 左右边界: { " + startIndex + ", " + endIndex + "} : " + Arrays.toString(arr));
    int j = 1;
    while (left != right) {
      /*这里先算left还是先算right，的前提条件是：基准值位于start还是end，如果start，就先算right，要先确定右边界。如果end，就先确定左边界。
      总之就是要先确定下来边界，因为基准值已经选定，所以只需要确定基准值反方向的边界即可。这样两边的边界就都确定了。
      这个东西决定了left和right相遇的位置是大于pivot的还是小于，就决定了把pivot往左扔还是往右扔。*/
      // 上面这个结论只是根据现象得出来的，可能是错的，因为还有个问题没解决：为什么随机取pivot时，先right后left好使，反之则不好使
      // [ 1,3,4,1,2]
      // 1 while
      // 第一次 基准 1 index = 0  左 0 右 4   左++ 左 = 1    右-- 右= 3  [ 1,1,4,3,2]
      // 第二次 基准 1 index = 0  左 1 右 3   左++ 左 = 2  右-- 右 = 2
      // 2 while 基准index 1 基准和left互换   [ 4,1,1,3,2] 索引max = 2
      // 第一次 基准 2 index = 1  左 0 右 2   左++ 左 = 1   左++  左 = 2
      // 2 while 基准index 1 基准和left互换  [ 1,1,2,3,4] 索引max = 2
      // 第一次 基准 2 index = 1  左 0 右 2   左++ 左 = 1   左++  左 = 2


      /*
      * 第2次递归, 基准值: 4, 基准值INDEX: 0 左右边界: { 0, 1} : [4, 1, 1, 3, 2]
第2次递归的第1循环, 基准值: 4基准值INDEX: 0 , 左右边界: { 0, 1} : [4, 1, 1, 3, 2]
第3次递归, 基准值: 3, 基准值INDEX: 3 左右边界: { 3, 4} : [1, 4, 1, 3, 2]
第3次递归的第1循环, 基准值: 3基准值INDEX: 3 , 左右边界: { 3, 4} : [1, 4, 1, 3, 2]
      * */


      while (left < right && arr[right] > pivot) {
        right--;
      }
      while (left < right && arr[left] <= pivot) {
        left++;
      }



      if (left < right) {
        swapArray(arr, left, right);
      }
      System.out.println("第" + my_QuickSort.i + "次递归的第" + (j++) + "循环, 基准值: " + pivot + "基准值INDEX: " + randomIndex + ", GROUP: " + group + " , 左右边界: { " + startIndex + ", " + endIndex + "} : " + Arrays.toString(arr));

    }
     swapArray(arr, randomIndex, left);
    // [ 1,3,4,1,2]
    // 1 while
    // 第一次 基准 4 右 不执行 左 ++ 左 =1 右 = 4
    // 第二次 基准 4 右 不执行 左 ++ 左 =2 右 = 4
    // 第三次 基准 4 右 不执行 左 ++ 左 =3 右 = 4
    // 第四次 基准 4 右 不执行 左 ++ 左 =4 右 = 4
    // 2 while 基准index 2 基准和left互换  [ 1,3,2,1,4] 索引max = 3
    // 第一次 基准 1 index 1 右 不执行 左 ++ 左 =1 右 = 3
    // 第二次 基准 1 index 1 右 不执行 左 不动 左 =1 右 = 3  执行交换 1 3互换  [ 1,1,2,3,4]
    // 第三次 基准 1 index 1 右 --  右 = 2  右 --  右 = 1
    // 3 while 基准index 1 基准和left互换 1 = 1 = 无操作  [ 1,1,2,3,4] 索引max = 0
    sort(arr, startIndex, left - 1,"group1");

    // 5  4
    sort(arr, left + 1, endIndex,"group1");


    /*swapArray(arr, startIndex, left-1);
    sort(arr, startIndex, left - 1);
    sort(arr, left, endIndex);*/
  }

  public static void swapArray(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

}
