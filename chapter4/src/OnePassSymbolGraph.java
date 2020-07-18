import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;

public class OnePassSymbolGraph {
    private ST<String, SET<String>> st;

    public OnePassSymbolGraph(){
        st = new ST<>();
    }
    public OnePassSymbolGraph(String filename, String delimiter){
        st = new ST<>();
        In in = new In(filename);
        while(in.hasNextLine()){
            String[] names = in.readLine().split(delimiter);
            String v = names[0];
            for(int i = 1;i < names.length;++i)
                addEdge(v, names[i]);
        }
    }

    public int degree(String v){
        if(st.contains(v)) return st.get(v).size();
        else return 0;
    }

    public boolean hasEdge(String v, String u){
        if(!contains(u) || !contains(v)) return false;
        return st.get(u).contains(v);
    }

    public boolean contains(String name){
        return st.contains(name);
    }

    public Iterable<String> vertices(){
        return st.keys();
    }

    public Iterable<String> adjTo(String v){
        return st.get(v);
    }

    public void addEdge(String u, String v){
        if(!st.contains(u)) st.put(u, new SET<>());
        if(!st.contains(v)) st.put(v, new SET<>());
        st.get(u).add(v);
        st.get(v).add(u);
    }

    public String toString(){
        String s = "";
        for(String v : vertices()){
            s += v + " ";
                for(String w : adjTo(v))
                    s += w + " ";
            s += "\n";
        }
        return s;
    }
}
