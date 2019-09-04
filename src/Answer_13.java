import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Answer_13 {
    public void reOrderArray(int [] array) {
        List oushulist = new ArrayList();
        List jishulist = new ArrayList();
        for (int i = 0; i < array.length; i++){
            if (judge(array[i])){
                oushulist.add(array[i]);
            }else{
                jishulist.add(array[i]);
            }
        }
        for (int j = 0; j < jishulist.size(); j++){
            array[j] = (int) jishulist.get(j);
        }
        for (int k = jishulist.size(); k < array.length; k++){
            array[k] = (int) oushulist.get(k-jishulist.size());
        }

    }
    public boolean judge(int i){
        if(i % 2 == 0){
            return true;
        }
        return false;
    }
}