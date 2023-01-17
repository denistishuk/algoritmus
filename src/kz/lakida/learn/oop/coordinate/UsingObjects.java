package kz.lakida.learn.oop.coordinate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UsingObjects {

    public static void main(String[] args) throws IOException {
        List<String> fileContents = Files.readAllLines(Paths.get(args[0]));
        double distance = 0.0;
        for (int i = 0; i < fileContents.size() - 1; i++) {
            Coordinate previous = new Coordinate(fileContents.get(i));
            Coordinate next = new Coordinate(fileContents.get(i + 1));

            distance += previous.distance(next);
        }

        System.out.println(distance);
    }

}

class Coordinate {

    final int x;

    final int y;

    final int z;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinate(String str) {
        String[] coordinateArray = str.split(",");
        this.x = Integer.parseInt(coordinateArray[0]);
        this.y = Integer.parseInt(coordinateArray[1]);
        this.z = Integer.parseInt(coordinateArray[2]);
    }

    public double distance(Coordinate other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2) + Math.pow(other.z - this.z, 2));
    }
}
