package model;

import java.util.HashMap;
import java.util.Map;

public class Croissant extends BakeryItem {

    public Croissant() {
        this.name = "CF";
        Map<Integer, Double> packetsMap = new HashMap<>();
        packetsMap.put(3, 5.95);
        packetsMap.put(5, 9.95);
        packetsMap.put(9, 16.99);
        this.packetDistributionList = packetsMap;
    }
}
