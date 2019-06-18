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
        findCost(packets[itemQuantity], packetPricingMap, item, itemQuantity);
        return packets[itemQuantity];
    }

    private void findCost(List<Integer> packetsList, Map<Integer, Double> packetPricingMap, String item, Integer itemQuantity) {
        double totalCost = 0.0;
        Map<Integer, Integer> countIndividualPackets = new HashMap<>();

        for(Integer optimumPackets : packetsList) {
            totalCost += packetPricingMap.get(optimumPackets);
            if (countIndividualPackets.get(optimumPackets) != null) {
                countIndividualPackets.put(optimumPackets, countIndividualPackets.get(optimumPackets) + 1);
            } else {
                countIndividualPackets.put(optimumPackets, 1);
            }
        }

        System.out.println(itemQuantity + " " + item + " " + totalCost);

        for (Map.Entry<Integer, Integer> individualCount : countIndividualPackets.entrySet()) {
            System.out.println(individualCount.getValue() + " x " + individualCount.getKey() + " " +
                    packetPricingMap.get(individualCount.getKey()));
        }

    }
}
