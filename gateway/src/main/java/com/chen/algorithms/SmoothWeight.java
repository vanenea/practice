package com.chen.algorithms;

public class SmoothWeight {

    /**
     * server A  weight 5
     * server B  weight 1
     * server C  weight 1
     *
     * AABACAA
     *
     * init 0,0,0
     *                  5,1,1                                               7
     *currentWeight += weight      maxWeight        maxCurrentWeight -= sumWeight      use
     *          5,1,1                  5                            -2,1,1              A
     *          3,2,2                  3                            -4,2,2              A
     *          1,3,3                  3                            1,-4,3              B
     *          6,-3,4                  6                           -1,-3,4             A
     *          4,-2,5                  5                           4,-2,-2             c
     *          9,-1,-1                 9                           2,-1,-1             A
     *          7,0,0                   7                           0,0,0               A
     *          5,1,1
     *
     *
     */


}
