package service;

import java.util.*;

public class PackagingService {


    public ArrayList<Integer> findOptimumPackets(Map<Integer, Double> packetPricingMap, int itemQuantity, String item)
    {
        //get all packet sizes available
        Integer[] itemPackets = new Integer[packetPricingMap.size()];
        itemPackets = packetPricingMap.keySet().toArray(itemPackets);

        ArrayList<Integer>[] packets = new ArrayList[itemQuantity + 1];

        //to find minimum number of packets required for the defined quantity
        int minimumPackets[] = new int[itemQuantity + 1];

        //min packets for 0 items is 0
        minimumPackets[0] = 0;

        packets[0] = new ArrayList<>();

        for (int i = 1; i <= itemQuantity; i++) {
            minimumPackets[i] = Integer.MAX_VALUE;
        }

        //find minimum number of packets required for all quantities from 1 to the quantity required
        for (int i = 1; i <= itemQuantity; i++)
        {
            for (int j = 0; j < itemPackets.length; j++)
                if (itemPackets[j] <= i)
                {
                    int previousOptimum = minimumPackets[i - itemPackets[j]];
                    if (previousOptimum != Integer.MAX_VALUE && previousOptimum + 1 < minimumPackets[i]) {
                        minimumPackets[i] = previousOptimum + 1;
                        if (packets[i] == null) {
                            packets[i] = new ArrayList<>();
                        } else {
                            //remove previously calculated optimum packets
                            packets[i].clear();
                        }
                        //add new optimum packet list
                        packets[i].addAll(packets[i - itemPackets[j]]);
                        packets[i].add(itemPackets[j]);
                    }

                }
        }

        //find cost for the minimum number of packets calculated for the quantity required
        findCost(packets[itemQuantity], packetPricingMap, item, itemQuantity);
        return packets[itemQuantity];
    }

    private void findCost(List<Integer> packetsList, Map<Integer, Double> packetPricingMap, String item, Integer itemQuantity) {
        double totalCost = 0.0;
        Map<Integer, Integer> countIndividualPackets = new HashMap<>();

        for(Integer optimumPackets : packetsList) {
            //add cost of packet
            totalCost += packetPricingMap.get(optimumPackets);

            //calculate total number of packets of a particular size
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
