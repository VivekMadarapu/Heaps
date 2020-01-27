import java.util.ArrayList;
import java.util.List;

public class Heap {

    List<Integer> tree;

    public Heap(int root){
        tree  = new ArrayList<>();
        tree.add(null);
        tree.add(root);
    }

//    public void add(int val){
//            tree[heapSize - 1] = val;
//            siftUp(heapSize - 1);
//    }

//    private void siftUp(int index) {
//        int parentIndex, tmp;
//        if (index != 0) {
//
//            parentIndex = getParentIndex(index);
//
//            if (tree.get(parentIndex) > tree.get(index)) {
//
//                tmp = tree.get(parentIndex);
//
//                tree.set(parentIndex, tree.get(index));
//
//                tree.set(index, tmp);
//
//                siftUp(parentIndex);
//            }
//
//        }
//    }

//    private int getParentIndex(int node) {
//
//    }

    public void remove(){

    }

    public int peek(){
        return tree.get(1);
    }

    public boolean isEmpty(){
        return tree.size() == 1;
    }

    public static void main(String[] args) {

    }
}
