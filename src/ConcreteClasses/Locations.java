package ConcreteClasses;

import java.util.HashMap;
import java.util.Map;

public class Locations {
    
    private final Map<String, Map<String, Double>> distanceMatrix = new HashMap<>();

    public Locations() {
        setupDistances();
    }

    private void setupDistances() {
        // town
        Map<String, Double> townDestinations = new HashMap<>();
        townDestinations.put("Strathmore", 10.5);
        townDestinations.put("Home", 11.72);
        distanceMatrix.put("town", townDestinations);

        // home
        Map<String, Double> homeDestinations = new HashMap<>();
        homeDestinations.put("Strathmore", 5.2);
        homeDestinations.put("Town", 11.72);
        distanceMatrix.put("Home", homeDestinations);

        // strathmore
        Map<String, Double> strathmoreDestinations = new HashMap<>();
        strathmoreDestinations.put("Town", 10.5);
        strathmoreDestinations.put("Home", 5.2);
        distanceMatrix.put("Strathmore", strathmoreDestinations);
    }

    public double getDistance(String start, String end) {
        if (distanceMatrix.containsKey(start) && distanceMatrix.get(start).containsKey(end)) {
            return distanceMatrix.get(start).get(end);
        }
        return -1;
    }
}
