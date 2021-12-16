package treeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

/**
 * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
 * 341. 扁平化嵌套列表迭代器
 * 等价于遍历 n 叉树的所有叶子节点
 */
public class NestedIterator implements Iterable<Integer> {
    private Iterator<Integer> it;
    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> res = new LinkedList<>(); // 存放结果
        for(NestedInteger node : nestedList){
            traverse(node, res);
        }
        this.it = res.iterator();
    }

    public Integer next() {
       return it.next();
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    private void traverse(NestedInteger root, List<Integer> res){
        if(root.isInteger()){
            res.add(root.getInteger());
            return;
        }
        for(NestedInteger child : root.getList()){
            traverse(child, res);
        }
    }
}
