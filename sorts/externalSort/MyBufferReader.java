package externalSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyBufferReader implements Comparable<MyBufferReader> {
    private Integer currentNumber;
    public boolean hasNumber = false;

    private final BufferedReader br;

    private final File f;

    public MyBufferReader(File tempFile) throws IOException {
        this.f = tempFile;
        br = new BufferedReader(new FileReader(tempFile));
        reload();
    }

    private void reload() throws IOException {
        String s = br.readLine();
        if (s == null) {
            hasNumber = false;
            currentNumber = null;
        } else {
            currentNumber = Integer.parseInt(s);
            hasNumber = true;
        }
    }

    public void close() throws IOException {
        this.br.close();
    }

    public int peek(){
        return currentNumber;
    }

    public int pop() throws IOException {
        int temp = peek();
        reload();
        return temp;
    }

    @Override
    public int compareTo(MyBufferReader o) {
        return this.currentNumber - o.currentNumber;
    }
}
