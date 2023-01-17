package kz.lakida.learn.oop.coordinate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UsingProcedures {

    /*
    1,4,6
    2,5,4
    6,5,8
    2,4,3
     */
    public static void main(String[] args) throws IOException {
        List<String> fileContents = Files.readAllLines(Paths.get(args[0]));
        double distance = 0.0;
        for (int i = 0; i < fileContents.size() - 1; i++) {
            String firstCoordinate = fileContents.get(i);
            String[] firstCoordinateArray = firstCoordinate.split(",");
            int x1 = Integer.parseInt(firstCoordinateArray[0]);
            int y1 = Integer.parseInt(firstCoordinateArray[1]);
            int z1 = Integer.parseInt(firstCoordinateArray[2]);
            String secondCoordinate = fileContents.get(i + 1);
            String[] secondCoordinateArray = secondCoordinate.split(",");
            int x2 = Integer.parseInt(secondCoordinateArray[0]);
            int y2 = Integer.parseInt(secondCoordinateArray[1]);
            int z2 = Integer.parseInt(secondCoordinateArray[2]);
            distance += calculateDistance(x1, y1, z1, x2, y2, z2);
        }

        System.out.println(distance);
    }

    public static double calculateDistance(int x1, int y1, int z1, int x2, int y2, int z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

}
