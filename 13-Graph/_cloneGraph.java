import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class _cloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();

        if (node == null) {
            return null;
        }

        return dfs(node, map);
    }

    private Node dfs(Node current, Map<Node, Node> map) {
        if (map.containsKey(current)) {
            return map.get(current);
        }

        Node clone = new Node(current.val);
        map.put(current, clone);

        for (Node neighbor : current.neighbors) {
            clone.neighbors.add(dfs(neighbor, map)); 
        }

        return clone;
    }
}
