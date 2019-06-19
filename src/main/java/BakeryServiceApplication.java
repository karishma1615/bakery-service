import model.AbstractBakeryItem;
import model.BlueberryMuffin;
import model.Croissant;
import model.VegemiteScroll;
import service.PackagingService;
import java.util.Scanner;

public class BakeryServiceApplication {

    private static final String regexConstant = "\\d+";

    public static void main(String args[]) {
            //take input
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Empty input given");
                return;
            }

            //split item type and quantity
            String[] inputArray = input.split(" ");

            //input must consist of 2 words and first word should be a number
            if (inputArray.length != 2 || !inputArray[0].matches(regexConstant)) {
                System.out.println("Wrong input format");
                return;
            }

            PackagingService packagingService = new PackagingService();
            AbstractBakeryItem abstractBakeryItem;

            switch (inputArray[1]) {
                case "VS5":
                    abstractBakeryItem = new VegemiteScroll();
                    break;
                case "MB11":
                    abstractBakeryItem =new BlueberryMuffin();
                    break;
                case "CF":
                    abstractBakeryItem =new Croissant();
                    break;
                 default:
                     throw new IllegalArgumentException("Wrong input format");
            }

            packagingService.findOptimumPackets(abstractBakeryItem.packetDistributionList,
                    Integer.parseInt(inputArray[0]), inputArray[1]);

    }
}
