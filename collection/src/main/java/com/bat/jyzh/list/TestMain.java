package com.bat.jyzh.list;

/**
 * TestMain
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 17:24
 **/
public class TestMain {

    private static final int COUNT_BITS = Integer.SIZE - 3;

    public static void main(String[] args) {
        printBinaryString("CAPACITY", (1 << COUNT_BITS) - 1);
        printBinaryString("RUNNING", -1 << COUNT_BITS);
        printBinaryString("SHUTDOWN", 0 << COUNT_BITS);
        printBinaryString("STOP", 1 << COUNT_BITS);
        printBinaryString("TIDYING", 2 << COUNT_BITS);
        printBinaryString("TERMINATED", 3 << COUNT_BITS);
        printBinaryString("", -1 << COUNT_BITS | 0);
        printBinaryString("~CAPACITY", ~((1 << COUNT_BITS) - 1));
    }

    public static void printBinaryString(String name, int i) {
        System.out.println(Integer.toBinaryString(i) + " ==>" + name);
    }
}
/**

 private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
 private static final int COUNT_BITS = Integer.SIZE - 3;
 private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

 // runState is stored in the high-order bits
 private static final int RUNNING    = -1 << COUNT_BITS;
 private static final int SHUTDOWN   =  0 << COUNT_BITS;
 private static final int STOP       =  1 << COUNT_BITS;
 private static final int TIDYING    =  2 << COUNT_BITS;
 private static final int TERMINATED =  3 << COUNT_BITS;

 // Packing and unpacking ctl
 private static int runStateOf(int c)     { return c & ~CAPACITY; }
 private static int workerCountOf(int c)  { return c & CAPACITY; }
 private static int ctlOf(int rs, int wc) { return rs | wc; }


 > Task :collection:TestMain.main()
 11111111111111111111111111111 ==>CAPACITY
 11100000000000000000000000000000 ==>RUNNING
 0 ==>SHUTDOWN
 100000000000000000000000000000 ==>STOP
 1000000000000000000000000000000 ==>TIDYING
 1100000000000000000000000000000 ==>TERMINATED
 11100000000000000000000000000000 ==>
 11100000000000000000000000000000 ==>~CAPACITY
 * */
