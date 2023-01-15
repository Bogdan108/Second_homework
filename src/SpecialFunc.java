import java.io.*;
import java.util.*;

final public class SpecialFunc {
    private SpecialFunc() {
    }

    final static private List<File> files = new ArrayList<>();

    static List<File> setFiles(File dir) {
        if (dir.isDirectory()) {
            // получаем все вложенные объекты в каталоге
            for (File item : Objects.requireNonNull(dir.listFiles())) {

                if (item.isDirectory()) {
                    setFiles(item);
                } else {
                    if (!item.getName().equals(".DS_Store")) {
                        files.add(item);
                    }
                }
            }
        }
        return files;
    }

    static void writeFiles(List<File> catalog, File answer) throws IOException {
        FileOutputStream output = new FileOutputStream(answer.getAbsolutePath(), true);
        for (File item : Objects.requireNonNull(catalog)) {
            FileInputStream input = new FileInputStream(item.getAbsolutePath());

            while (input.available() > 0) {
                int data = input.read();
                output.write(data);
            }

            input.close();
        }
        output.close();
    }
}

