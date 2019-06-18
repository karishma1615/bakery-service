package service;

import java.util.*;

public class PackagingService {


    public ArrayList<Integer> findOptimumPackets(Map<Integer, Double> packetPricingMap, int itemQuantity, String item)
    {

        Integer[] itemPackets = new Integer[packetPricingMap.size()];
        itemPackets = packetPricingMap.keySet().toArray(itemPackets);

        ArrayList<Integer>[] packets = new ArrayList[itemQuantity + 1];

        int findMinTable[] = new int[itemQuantity + 1];

        findMinTable[0] = 0;
        packets[0] = new ArrayList<>();

        for (int i = 1; i <= itemQuantity; i++) {
            findMinTable[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= itemQuantity; i++)
        {
            for (int j = 0; j < itemPackets.length; j++)
                if (itemPackets[j] <= i)
                {
                    int previousOptimum = findMinTable[i - itemPackets[j]];
                    if (previousOptimum != Integer.MAX_VALUE && previousOptimum + 1 < findMinTable[i]) {
                        findMinTable[i] = previousOptimum + 1;
                        if (packets[i] == null) {
                            packets[i] = new ArrayList<>();
                        } else {
                            packets[i].clear();
                        }
                        packets[i].addAll(packets[i - itemPackets[j]]);
                        packets[i].add(itemPackets[j]);
                    }

                }
        }

        return packets[itemQuantity];
    }
}
