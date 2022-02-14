package org.zgy.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author ：z
 * @date ：Created in 2022/1/29 下午11:07
 * @description：current state: Time Limit Exceeded
 */
public class P1765 {

    public static void main(String[] args) {
//        int[][] isWater = new int[][]{{0, 1}, {0, 0}};
//        int[][] isWater = new int[][]{{0,0,1}, {1,0,0}, {0,0,0}};
        int[][] isWater = new int[1000][1999];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                int v = (int)Math.random() * 10 % 2;
                isWater[i][j]=v;
            }
        }
        long start = System.currentTimeMillis();
        int[][] ints = new P1765().highestPeak2(isWater);
        System.out.println("耗时："+(System.currentTimeMillis()-start));
//        System.out.println(Arrays.deepToString(ints));
    }

    public int[][] highestPeak(int[][] g) {
        /**
         * 解题地址：https://leetcode-cn.com/problems/map-of-highest-peak/solution/gong-shui-san-xie-duo-yuan-bfs-yun-yong-8sw0f/
         * 思路：利用队列先进先出的原理，先找出所有水域坐标，放入队列。
         * 然后循环从队列中取，每取出来一个坐标就遍历它的上下左右，如果上下左右邻居有被赋值过，就不操作这个。把上下左右的值置为当前值+1
         * 然后把赋过值的当前坐标放入队列。这里是精髓所在，先把水域的上下左右赋一遍值，再赋值刚才赋值过的，周而复始。由各个水域点向周边扩散开来。
         * 时间复杂度：m*n,其实是m*n*4这里的4是因为每个格子都要遍历它上下左右邻居，不过因为4是常数，所以可以省去。
         */
        int m = g.length, n = g[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) d.addLast(new int[]{i, j});
                ans[i][j] = g[i][j] == 1 ? 0 : -1;
            }
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int x = info[0], y = info[1];
            for (int[] di : dirs) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (ans[nx][ny] != -1) continue;
                ans[nx][ny] = ans[x][y] + 1;
                d.addLast(new int[]{nx, ny});
            }
        }
        return ans;
    }

    public int[][] highestPeak2(int[][] isWater) {
        /**
         * 看leetcode上面的解题思路，自己写的，提交结果还是超时。
         * 思路：先找出所有水域坐标，然后遍历整个矩阵，每个位置都计算和所有水域坐标的距离，取最短水域距离。就是当前陆地高度。
         * 时间复杂度：m*n*水域数量
         */
        int[][] height = new int[isWater.length][isWater[0].length];
        ArrayList<Integer[]> waters = new ArrayList<>();
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    waters.add(new Integer[]{i, j});
                }
            }
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height[i].length; j++) {
                int minWeight = -1;
                for (Integer[] water : waters) {
                    //如果是水域，就结束当前子循环
                    if (water[0] == i && water[1] == j) {
                        minWeight=-1;
                        break;
                    }
                    int i1 = (water[0] > i ? water[0] - i : i - water[0])+(water[1] > j ? water[1] - j : j - water[1]);

                    if(i1<minWeight||minWeight==-1){
                        minWeight=i1;
                    }
                }
                if (minWeight != -1) {
                    height[i][j] = minWeight;
                }
            }
        }
        return height;
    }

    public int[][] highestPeak1(int[][] isWater) {
        //先遍历一遍isWater，初始化height把陆地都设置位1，水域都设置为0，
        //遍历height，判断这个格子的上下左右，如果都是n，并且当前格子的
        // 数值小于n+1，则设置为n+1，updateCnt++
        //此方法有问题
        int[][] height = new int[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 0) {
                    height[i][j] = 1;
                } else {
                    height[i][j] = 0;
                }
            }
        }
        boolean noUpdate = true;
        int min;
        while (true) {
            noUpdate = true;
            for (int i = 0; i < height.length; i++) {
                for (int j = 0; j < height[i].length; j++) {
                    if (height[i][j] == 0) {
                        continue;
                    }
                    //up
                    if (i - 1 >= 0) {
                        min = height[i - 1][j];
                    } else {
                        min = -1;
                    }
                    //down
                    if (i + 1 < height.length && (height[i + 1][j] < min || min == -1)) {
                        min = height[i + 1][j];
                    }
                    //left
                    if (j - 1 >= 0 && (height[i][j - 1] < min || min == -1)) {
                        min = height[i][j - 1];
                    }
                    //right
                    if (j + 1 < height[i].length && (height[i][j + 1] < min || min == -1)) {
                        min = height[i][j + 1];
                    }
                    if (min + 1 > height[i][j]) {
                        height[i][j] = min + 1;
                        noUpdate = false;
                    }
                }
            }
            if (noUpdate) {
                return height;
            }
        }
    }
}
