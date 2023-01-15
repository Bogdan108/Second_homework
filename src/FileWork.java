import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileWork {

    public void MainWork() throws IOException {
        System.out.println("Enter folder name");
        Scanner input = new Scanner(System.in);
        String root_folder = input.nextLine();
        File root_dir = new File(root_folder);

        if (!root_dir.isDirectory()) {
            throw new RuntimeException("This is not a directory");
        }
        if (!root_dir.exists()) {
            throw new RuntimeException("Directory does not exist");
        }

        List<File> files = SpecialFunc.setFiles(root_dir);
        File newFile = new File(root_dir.getAbsolutePath() + "/answer");
        try {
            boolean created = newFile.createNewFile();
            if (created) System.out.println("File has been created");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        FileSort Sorter = new FileSort();
        Sorter.sort(files);
        SpecialFunc.writeFiles(files, newFile);
    }
}
