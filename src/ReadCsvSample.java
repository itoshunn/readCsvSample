import java.io.*;

public class ReadCsvSample {

    public static void main(String[] args) {
        readCsv();
    }

    private static void readCsv() {

        String csvFile = "text.csv";
        String filePath = "";

        filePath = getCsvFile(csvFile);
        if (filePath != ""){
            readFileStream(filePath);
        }
    }

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

    private static void readFileStream(String filePath) {

        try {

            FileInputStream in = null;
            InputStreamReader is = null;
            BufferedReader br = null;

            in = new FileInputStream(filePath);
            is = new InputStreamReader(in);
            br = new BufferedReader(is);

            String line = "";

            // 1行ずつ読み込み
            while ((line = br.readLine()) !=  null) {

                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.toString());

        }
    }
}
