import java.util.*;

class VectorClock {
    Map<String, Integer> clock = new HashMap<>();

    void increment(String myNodeId) {
        clock.put(myNodeId, clock.getOrDefault(myNodeId, 0) + 1);
    }

    void merge(VectorClock other) {
        for (String node : other.clock.keySet()) {
            int current = clock.getOrDefault(node, 0);
            int remote  = other.clock.get(node);
            clock.put(node, Math.max(current, remote));
        }
    }

    boolean isConcurrent(VectorClock other) {
        boolean foundLess = false;
        boolean foundGreater = false;

        Set<String> allNodes = new HashSet<>();
        allNodes.addAll(clock.keySet());
        allNodes.addAll(other.clock.keySet());

        for (String node : allNodes) {
            int a = clock.getOrDefault(node, 0);
            int b = other.clock.getOrDefault(node, 0);
            if (a > b) foundGreater = true;
            if (a < b) foundLess = true;
        }
        return foundLess && foundGreater;
    }
    @Override
    public String toString() {
        return clock.toString();
    }

    public static void main(String[] args) {
        VectorClock replica1 = new VectorClock();
        VectorClock replica2 = new VectorClock();

        System.out.println("Start: r1=" + replica1 + "  r2=" + replica2);

        replica1.increment("client1");
        System.out.println("Write on r1 → " + replica1);

        replica2.increment("client2");
        System.out.println("Write on r2 → " + replica2);

        boolean conflict = replica1.isConcurrent(replica2);

        System.out.println("Conflict found? " + conflict);

    }

}
