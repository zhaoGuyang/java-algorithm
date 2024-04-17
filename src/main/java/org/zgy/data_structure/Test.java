package org.zgy.data_structure;

/**
 * @Author z
 * @create 2022/3/3 10:17
 */
public class Test {

  public static void main(String[] args) {
//    int[] n = {5, 1, 2, 3, 4};
//    int target = 1;
//    System.out.println(new Test().search(n, target));

    /*String a="test1";
    String b="test1";
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    a="test2";
    System.out.println(a);
    System.out.println(b);*/

    /*Integer a1 = 128;
    Integer b1 = a1;
    System.out.println(a1 == b1);
    System.out.println(a1);
    System.out.println(b1);
    a1 = 129;
    System.out.println(a1);
    System.out.println(b1);*/

    /*Student a = new Student(10);
    Student b = a;w
    System.out.println(a.age);
    System.out.println(b.age);
    a.age=11;
    System.out.println(a.age);
    System.out.println(b.age);*/

    /*int [] a={1,2,3};
    new Test().changeArr(a);
    System.out.println(a[0]);*/

    Integer a=1;
    Integer b =a;

    System.out.println(a);
    new Test().change(a);
    System.out.println(a);



  }

  public void change(Integer a){
    a=3;
  }

  public int search(int[] nums, int target) {
    //二分法+双游标
    int left = 0, right = nums.length - 1;

    while (left < right) {
      int mid = (left + right) / 2;
      //这里的三个条件异或，等价于：三个都满足 或 只满足一个。满足两个就是false了等同于下面的大if，如果忘了异或可以看看
//      if (nums[0] > target ^ nums[0] > nums[mid] ^ target > nums[mid]) {
//        System.out.println("Up: nums[0]="+nums[0]+", nums[mid]="+nums[mid]+", target="+target+".");
//        left = mid + 1;
//      } else {
//        right = mid;
//      }
      if ((nums[0] > target && nums[0] > nums[mid] && target > nums[mid]) ||
          (nums[0] > target && nums[0] <= nums[mid] && target <= nums[mid]) ||
          (nums[0] <= target && nums[0] > nums[mid] && target <= nums[mid]) ||
          (nums[0] <= target && nums[0] <= nums[mid] && target > nums[mid])) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left == right && nums[left] == target ? left : -1;
  }
}

class Student {

  String a;
  Integer b;

  public Student(int age) {
    this.age = age;
  }

  int age;
}