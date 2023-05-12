package task8;
import java.util.*;
public class RoutingTableBuilder {
	private Map<Character, Map<Character, Character>> routingTables;

    public RoutingTableBuilder(List<String> connectivityInfo) {
        routingTables = new HashMap<>();
        buildRoutingTables(connectivityInfo);
    }

    public void printRoutingTables() {
        for (Character node : routingTables.keySet()) {
            System.out.println("Routing table for node " + node + ":");
            Map<Character, Character> table = routingTables.get(node);
            for (Character dest : table.keySet()) {
                System.out.println("  " + dest + " -> " + table.get(dest));
            }
        }
    }

    private void buildRoutingTables(List<String> connectivityInfo) {
        for (String connection : connectivityInfo) {
            char node = connection.charAt(0);
            char neighbor = connection.charAt(2);
            updateRoutingTable(node, neighbor, neighbor);
            updateRoutingTable(neighbor, node, node);
        }

        for (char node : routingTables.keySet()) {
            Set<Character> visited = new HashSet<>();
            visited.add(node);
            Queue<Character> queue = new LinkedList<>();
            queue.offer(node);

            while (!queue.isEmpty()) {
                char curr = queue.poll();
                Map<Character, Character> neighbors = routingTables.get(curr);
                for (char neighbor : neighbors.keySet()) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.offer(neighbor);
                        updateRoutingTable(node, neighbor, neighbors.get(neighbor));
                    }
                }
            }
        }
    }

    public void updateRoutingTable(char node, char dest, char nextHop) {
        if (!routingTables.containsKey(node)) {
            routingTables.put(node, new HashMap<>());
        }
        Map<Character, Character> table = routingTables.get(node);
        if (!table.containsKey(dest) || table.get(dest) > nextHop) {
            table.put(dest, nextHop);
        }
    }

    public static void main(String[] args) {
        List<String> connectivityInfo = new ArrayList<>();
        connectivityInfo.add("A:B");
        connectivityInfo.add("A:C");
        connectivityInfo.add("A:D");

        RoutingTableBuilder rtb = new RoutingTableBuilder(connectivityInfo);
        rtb.printRoutingTables();
    }
}

