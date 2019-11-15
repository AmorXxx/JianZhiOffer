package LRU;


import java.util.HashMap;

public class LRU<K, V> {
    private int currentSize;
    private int capCity;
    //所有节点
    private HashMap<K, Node> caches;
    private Node first;
    private Node last;
    public LRU(int size){
        currentSize = 0;
        this.capCity = size;
        caches = new HashMap<K, Node>(size);
    }

    public void put(K key, V value){
        Node node = caches.get(key);
        if (node == null){
            if (caches.size() >= capCity){
                caches.remove(last.key);
                removeLast();
            }
            node = new Node(key, value);
        }
        node.value = value;
        moveToHead(node);
        caches.put(key, node);
    }

    public Object get(K key){
        Node node = caches.get(key);
        if (node == null){
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public Object remove(K key){
        Node node = caches.get(key);
        if (node != null){
            if (node.pre != null){
                node.pre.next = node.next;
            }
            if (node.next != null){
                node.next.pre = node.pre;
            }
            if (node == first){
                first = node.next;
            }
            if (node == last){
                last = node.pre;
            }
        }
        return caches.remove(key);
    }

    private void moveToHead(Node node){
        if (first == node){
            return;
        }
        if (node.next != null){
            node.next.pre = node.pre;
        }
        if (node.pre != null){
            node.pre.next = node.next;
        }
        if (node == last){
            last = last.pre;
        }
        if (first == null || last == null){
            first = last = node;
            return;
        }
        node.next = first;
        first.pre = node;
        first = node;
        first.pre = null;
    }

    public void clear(){
        first = null;
        last = null;
        caches.clear();
    }

    private void removeLast(){
        if (last != null){
            last = last.pre;
            if (last == null){
                first = null;
            }else {
                last.next = null;
            }
        }
    }

    public int getCurrentSize(){
        return caches.size();
    }
}
