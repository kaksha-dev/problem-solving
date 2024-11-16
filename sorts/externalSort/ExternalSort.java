package externalSort;

import java.io.*;
import java.util.*;

public class ExternalSort {

    private final File inputFile;

    public ExternalSort(File inputFile) {
        this.inputFile = inputFile;

    }

    public void sort() throws IOException {
        List<File> tempFiles = createSortedTempFiles(10);
        PriorityQueue<MyBufferReader> pq = new PriorityQueue<>();
        for (File t : tempFiles) {
            pq.add(new MyBufferReader(t));
        }

        File output = new File("./output.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(output));
        while (!pq.isEmpty()) {
            MyBufferReader m = pq.poll();
            bw.write(m.pop() + "");
            bw.newLine();
            if (m.hasNumber) {
                pq.add(m);
            } else {
                m.close();
            }
        }
        bw.close();
    }

    public List<File> createSortedTempFiles(long batchSize) throws IOException {
        List<File> tempFiles = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(this.inputFile));
        String number;
        List<Integer> numbers = new ArrayList<>();
        while ((number = br.readLine()) != null) {
            numbers.add(Integer.parseInt(number));
            if (numbers.size() >= batchSize) {
                File tempFile = sortAndCreate(numbers);
                tempFiles.add(tempFile);
                numbers = new ArrayList<>();
            }
        }
        if (!numbers.isEmpty()) {
            File tempFile = sortAndCreate(numbers);
            tempFiles.add(tempFile);
        }
        return tempFiles;
    }

    private File sortAndCreate(List<Integer> numbers) throws IOException {
        Collections.sort(numbers);
        File tempFile = new File("./" + UUID.randomUUID() + ".txt");
        tempFile.deleteOnExit();
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
        for (int num : numbers) {
            bw.write(num + "");
            bw.newLine();
        }
        bw.close();
        return tempFile;
    }
}
