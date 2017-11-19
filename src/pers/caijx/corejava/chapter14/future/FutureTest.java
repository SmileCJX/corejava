package pers.caijx.corejava.chapter14.future;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/11/19/019.
 */
public class FutureTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter base directory (e.g /uer/local/jdk8.0/src): ");
        String directory = in.nextLine();
        System.out.printf("Enter keyword (e.g volatile): ");
        String keyword = in.nextLine();

        MathCounter counter = new MathCounter(new File(directory),keyword);
        FutureTask<Integer> task = new FutureTask<Integer>(counter);
        Thread t = new Thread(task);
        t.start();
        try {
            System.out.println(task.get() + " matching files");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MathCounter implements Callable<Integer> {

    private File directory;

    private String keyword;

    private int count;

    public MathCounter(File directory, String keyword) {
        this.directory = directory;
        this.keyword = keyword;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        File[] files = directory.listFiles();
        List<Future<Integer>> results = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                MathCounter counter = new MathCounter(file,keyword);
                FutureTask<Integer> task = new FutureTask<Integer>(counter);
                results.add(task);
                Thread t = new Thread(task);
                t.start();
            } else {
                if (search(file)) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file)){
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) {
                        found = true;
                    }
                }
                return found;
            }
        } catch (FileNotFoundException e) {
            return false;
        }
    }
}
