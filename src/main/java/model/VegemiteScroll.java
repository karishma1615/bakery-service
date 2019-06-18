package model;

import java.util.HashMap;
import java.util.Map;

public class VegemiteScroll extends BakeryItem {

    public VegemiteScroll() {
        this.name = "VS5";
        Map<Integer, Double> packetsMap = new HashMap<>();
        packetsMap.put(3, 6.99);
        packetsMap.put(5, 8.99);
        this.packetDistributionList = packetsMap;
    }
}
