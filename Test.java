import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Test {

    public static void main(String[] args){
        List<Integer> list1 = Arrays.asList(2,3);
        List<Integer> list2 = Arrays.asList(2,3);
        int[] arr1 = new int[]{2,3};
        int[] arr2 = new int[]{2,3};
        System.out.println(arr1.equals(arr2));
        System.out.println(Arrays.equals(arr1,arr2));
        System.out.println(list1.equals(list2));
    }

    class MyHashSet {
        private Bucket[] buckets;

        /** Initialize your data structure here. */
        public MyHashSet() {
            buckets = new Bucket[769];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new Bucket();
            }
        }

        public int _hash(int key) {
            return key % buckets.length;
        }
        
        public void add(int key) {
            int index = _hash(key);
            buckets[index].keys.add(key);
        }
        
        public void remove(int key) {
            int index = _hash(key);
            buckets[index].keys.remove(key);
        }
        
        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int index = _hash(key);
            return buckets[index].keys.contains(key);
        }
        
        class Bucket{
            private List<Integer> keys = new ArrayList<>();

            public void remove(int key) {
                for (int i = 0;i < keys.size(); i++) {
                    int curr = keys.get(i);
                    if (curr == key) {
                        keys.remove(i);
                    } 
                }
            }
        }
    }
    
}
