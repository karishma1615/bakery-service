import model.BakeryItem;
import model.BlueberryMuffin;
import model.Croissant;
import model.VegemiteScroll;
import service.PackagingService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BakeryServiceApplication {

    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input = bufferedReader.readLine();
            String[] inputArray = input.split(" ");
            PackagingService packagingService = new PackagingService();
            BakeryItem bakeryItem=null;
            switch (inputArray[1]) {
                case "VS5":
                    bakeryItem = new VegemiteScroll();
                    break;
                case "MB11":
                    bakeryItem=new BlueberryMuffin();
                    break;
                case "CF":
                    bakeryItem=new Croissant();
                    break;
            }
            packagingService.findOptimumPackets(bakeryItem.packetDistributionList,
                    Integer.parseInt(inputArray[0]), inputArray[1]);

        } catch(IOException e) {

        }
    }
}
