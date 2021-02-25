package com.bat.jyzh.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 基于 Tire 树算法思想实现一个姓名树重复判断
 *
 * @author ZhengYu
 * @version 1.0 2021/2/25 13:55
 **/
public class TireTree {

    private final TreeNode root;

    private final ReentrantReadWriteLock rwLock;

    public TireTree() {
        root = new TreeNode();
        root.key = '/';
        rwLock = new ReentrantReadWriteLock();
    }

    /**
     * 将一个值放入 Tire 树
     *
     * @param key 键
     * @throws IllegalArgumentException if key is null or blank
     * @author ZhengYu
     */
    public void put(String key) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("key must not blank");
        }

        rwLock.writeLock().lock();

        try {
            TreeNode parent = root;
            for (int i = 0; i < key.length(); i++) {
                List<TreeNode> childNodes = parent.childNodes;
                if (childNodes == null) {
                    childNodes = new ArrayList<>();
                    parent.childNodes = childNodes;
                }

                boolean keyExistFlag = false;
                for (TreeNode node : childNodes) {
                    if (node.key == key.charAt(i)) {
                        keyExistFlag = true;
                        parent = node;
                        break;
                    }
                }

                if (!keyExistFlag) {
                    TreeNode node = new TreeNode();
                    node.key = key.charAt(i);
                    node.exist = i == key.length() - 1;
                    childNodes.add(node);
                    parent = node;
                }
            }
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    /**
     * 判断一个值是否存在
     *
     * @param key 键
     * @throws IllegalArgumentException if key is null or blank
     * @author ZhengYu
     */
    public boolean exist(String key) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("key must not blank");
        }

        rwLock.readLock().lock();

        try {
            TreeNode parent = root;
            for (int i = 0; i < key.length(); i++) {
                List<TreeNode> childNodes = parent.childNodes;
                if (childNodes == null) {
                    return false;
                }

                boolean keyExistFlag = false;
                for (TreeNode node : childNodes) {
                    if (node.key == key.charAt(i)) {
                        keyExistFlag = true;
                        parent = node;
                        break;
                    }
                }

                if (!keyExistFlag) {
                    return false;
                } else {
                    if (i == key.length() - 1) {
                        return parent.exist;
                    }
                }
            }
        } finally {
            rwLock.readLock().unlock();
        }
        throw new RuntimeException("unexpected exception");
    }

    private static class TreeNode {

        /**
         * 节点是否存在数据
         */
        private boolean exist;

        /**
         * 当前树节点的键值
         */
        private char key;

        /**
         * 子节点列表
         */
        private List<TreeNode> childNodes;
    }

    /**
     * 测试用例
     *
     * @author ZhengYu
     */
    public static void main(String[] args) {
        TireTree tireTree = new TireTree();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            String s = "张三" + i;
            tireTree.put(s);
        }

        System.out.println("put time -->: " + (System.currentTimeMillis() - start));

        String s1 = "张三0";
        String s2 = "张三";

        start = System.currentTimeMillis();
        System.out.println("s1 -->: " + tireTree.exist(s1));
        System.out.println("exist time -->: " + (System.currentTimeMillis() - start));

        System.out.println("s2 -->: " + tireTree.exist(s2));
    }
}
