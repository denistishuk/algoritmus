package kz.lakida.learn.oop.files;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkingWithFiles {

    public static void main(String[] args) throws Exception {
        var file = Files.createTempFile("input", ".txt");
        var path = Paths.get("/tmp/1.txt");
        System.out.println(file.getFileName().toString());
    }

    private static void exampleWithTryCloseable() throws Exception {
        try (var tryCloseable = new TryCloseable()) {
            System.out.println("hello");
        }
    }

    private static void exampleWithFileStreams() throws IOException {
        try (var fileInputStream = new FileInputStream("input_file.txt"); var fileOutputStream =
                new FileOutputStream("output_file.txt")) {
            while (fileInputStream.available() > 0) {
                byte[] buffer = fileInputStream.readNBytes(Math.min(fileInputStream.available(), 4096));
                fileOutputStream.write(buffer);
            }
        }
    }

    private static void exampleWithFileReaders() throws IOException {
        var inputReader = new BufferedReader(new InputStreamReader(new FileInputStream("input_file.txt")));
        var outputWriter = new DataOutputStream(new FileOutputStream("output_file.txt"));

        while (inputReader.ready()) {
            var line = inputReader.readLine();
            outputWriter.writeUTF(line);
        }

        inputReader.close();
        outputWriter.close();
    }

}

class TryCloseable implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("closed");
    }
}
