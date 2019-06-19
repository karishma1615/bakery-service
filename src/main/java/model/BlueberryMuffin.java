package model;

import java.util.HashMap;
import java.util.Map;

public class BlueberryMuffin extends AbstractBakeryItem {

    public BlueberryMuffin() {
        this.name = "MB11";
        Map<Integer, Double> packetsMap = new HashMap<>();
        packetsMap.put(2, 9.95);
        packetsMap.put(5, 16.95);
        packetsMap.put(8, 24.95);
        this.packetDistributionList = packetsMap;
    }
}
