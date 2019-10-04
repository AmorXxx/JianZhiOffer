import java.util.*;

public class Answer_27 {

    private StringBuilder path = new StringBuilder();
    private TreeSet<String> paths = new TreeSet<>();
    private ArrayList<String> list = new ArrayList<>();
    private boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        if (str.equals("")){
            return list;
        }
        if (str.length() <= 1){
            list.add(str);
            return list;
        }
        char[] strs = str.toCharArray();
        Arrays.sort(strs);
        visited = new boolean[strs.length];
        fun(strs, 0);
        list.addAll(paths);
        return list;
    }

    private void fun(char[] strs, int len){
        if (len == strs.length){
            paths.add(path.toString());
            return;
        }
        for (int i = 0; i < strs.length; i++){
            if (!visited[i]){
                visited[i] = true;
                path.append(strs[i]);
                fun(strs, len + 1);
                visited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
