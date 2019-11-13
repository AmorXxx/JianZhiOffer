import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * 此类用于测试通过foreach遍历集合来删除元素的缺陷
 */
public class TestArrayList {
    public static ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b"));
    public static void ForEach(ArrayList<String> list){
        for (String temp : list) {
            if ("b".equals(temp)) {
                list.remove(temp);
            }
        }
    }

    public static void For(ArrayList<String> list){
        for (int i = 0; i < list.size(); i++){
            String temp = list.get(i);
            if ("b".equals(temp)){
                list.remove(i);
            }
        }
    }

    public static void Iterator(ArrayList<String> list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("b")){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Iterator(list);
        for (String temp: list
             ) {
            System.out.println(temp+ " ");

        }
    }
    /**
     * 用foreach遍历ArrayList会出现ConcurrentModificationException
     * 原因:（fail-fast机制:当多个线程对集合进行结构上改变的操作时，就有可能触发fail-fast机制，即当方法检测到对象的并发修改，但不允许这种修改时就抛出该异常）
     * 把foreach代码块生成的class文件反编译出来发现是依赖while和Iterator实现的
     * 所以遍历集合时调用的是Iterator.next()会调用Iterator.checkForComodification方法
     * 而该方法会判断modCount是否等于exceptedModCount,若不相等则触发fail-fast机制，抛出ConcurrentModificationException
     * modCount：是ArrayList里的成员变量，他表示该集合实际被修改的次数
     * exceptedModCount：是ArrayList的内部类Itr的成员变量，其值是在ArrayList.iterator方法调用时被初始化的，只有通过迭代器对集合进行操作
     * 该值才会改变,Itr是Iterator的实现,ArrayList.iterator方法可以获取到的迭代器就是Itr类的实例
     * 所以foreach中其实是调用了iterator.next()方法去便利集合,而这个方法又会去调用Iterator.checkForComodification方法通过modCount和
     * exceptModCount的值去校验这个集合是否被其他线程修改,而我们移除元素调用的却是ArrayList的remove方法,该方法只改变了modCount的值却没有
     * 改变exceptModCount的值,所以最终导致抛出ConcurrentModificationException
     *
     * 建议使用Iterator或者for循环进行remove/add操作
     */
}
