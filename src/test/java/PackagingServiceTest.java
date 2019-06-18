import org.junit.Test;
import service.PackagingService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PackagingServiceTest {

    PackagingService packagingService = new PackagingService();

    @Test
    public void testFindOptimalPacketsForVegemiteScroll() {
        Map<Integer, Double> packetsMap = new HashMap<>();
        packetsMap.put(3, 6.99);
        packetsMap.put(5, 8.99);

        ArrayList<Integer> optimumPacketSolution = packagingService.findOptimumPackets(packetsMap, 10, "VS5");

        assert (optimumPacketSolution.size() == 2);
        assert (optimumPacketSolution.get(0) == 5 && optimumPacketSolution.get(1) == 5);
    }

    @Test
    public void testFindOptimalPacketsForBlueberryMuffin() {
        Map<Integer, Double> packetsMap = new HashMap<>();
        packetsMap.put(2, 9.95);
        packetsMap.put(5, 16.95);
        packetsMap.put(8, 24.95);
        ArrayList<Integer> optimumPacketSolution = packagingService.findOptimumPackets(packetsMap, 14, "MB11");

        assert (optimumPacketSolution.size() == 4);
        assert (Collections.frequency(optimumPacketSolution,2)==3);
        assert (Collections.frequency(optimumPacketSolution,8)==1);

    }

    @Test
    public void testFindOptimalPacketsForCroissant() {
        Map<Integer, Double> packetsMap = new HashMap<>();
        packetsMap.put(3, 5.95);
        packetsMap.put(5, 9.95);
        packetsMap.put(9, 16.99);

        ArrayList<Integer> optimumPacketSolution = packagingService.findOptimumPackets(packetsMap, 13, "CF");

        assert (optimumPacketSolution.size() == 3);
        assert (Collections.frequency(optimumPacketSolution,5)==2);
        assert (Collections.frequency(optimumPacketSolution,3)==1);
    }
}
