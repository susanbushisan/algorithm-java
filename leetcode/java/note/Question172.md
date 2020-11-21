思考

    看上去是一道编程题，实际上是一个数学题，只要知道数学上如何求这个问题，就容易编写了，要想尾数0，就需要2的因子和5的因子，在阶乘中2的因子大于5的因子，所以有多少个5的因子就有多少个0，要注意的是25中有2个为5的因子

### 找2和5的因子

~~~
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5){
            n = n/5;
            res +=n;
        }
        return res;
    }
~~~

时间复杂度O(n)，空间复杂度O(1)