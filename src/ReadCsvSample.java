import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadCsvSample {

    /**
     * メインクラス
     * @param args
     */
    public static void main(String[] args) {
        readCsv();
    }

    /**
     * CSV ファイルを読み込むだけの処理
     */
    private static void readCsv() {

        String csvFile = "text.csv";
        String filePath = "";
        String[] list = null;

        filePath = getCsvFile(csvFile);
        if (filePath != "") {
            try {
                System.out.println(readAll(filePath));

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    /**
     * 対象のCSVファイルを取得する
     * @param csvFile
     * @return ファイルパス
     */
    private static String getCsvFile(String csvFile) {

        String filePath = "";
        File dir = new File(System.getProperty("user.dir"));
        File[] fileList = dir.listFiles();

        for (File f : fileList) {
            if (csvFile.equals(f.getName())) {
                filePath = f.getPath();
            }
        }
        return filePath;
    }

    /**
     * 高速にテキストを読み込む
     * @param path  ファイルパス
     * @return ファイル文字列
     * @throws IOException
     */
    private static String readAll(final String path) throws IOException {
        return String.join(System.getProperty("line.separator"),
                Files.readAllLines(Paths.get(path), Charset.forName("UTF-8")));
    }
}
