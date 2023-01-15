import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.io.File;

public class FileSort implements Comparator<Object> {

    //класс для работы со строками на разных языках
    Collator collator;

    public FileSort() {
        //получаем системные настройки (язык и страну)
        String country = System.getProperty("user.country");
        String language = System.getProperty("user.language");
        //создаем экземпляр класса для сравнения строк на
        //основе региональных настроек
        collator = Collator.getInstance(new Locale(country, language));
    }

    /**
     * Этот метод выполняет сравнение имен двух файлов.
     * Возвращает:
     * 1 если первый параметр (о1) больше второго (о2),
     * -1 если первый параметр (о1) меньше второго (о2),
     * 0 если они равны.
     */
    public int compare(Object o1, Object o2) {
        //если объекты не равны null и имеют тип File
        if (o1 instanceof File f1 && o2 instanceof File f2) {
            //приводим к типу File
            //получаем полный путь к имени файла
            String fullPath1 = f1.getName();
            String fullPath2 = f2.getName();
            return collator.compare(fullPath1, fullPath2);
        }
        return 0;
    }

    public void sort(List<File> fileList) {
        fileList.sort(this);
    }
}