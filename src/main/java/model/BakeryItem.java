package model;

import java.util.HashMap;
import java.util.Map;

public abstract class BakeryItem {
    public String name;

    public Map<Integer, Double> packetDistributionList = new HashMap<>();

}
