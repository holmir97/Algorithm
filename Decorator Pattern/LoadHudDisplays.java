import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface {
    String fileName;

    LoadHudDisplays(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public ArrayList<String> load() {
        //파일 불러오기
        try {
            ArrayList<String> list = new ArrayList<String>();
            BufferedReader read = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            for (String str = read.readLine(); str != null; str = read.readLine())
                list.add(str);

            return list;
        } catch (Exception excp) {
            excp.printStackTrace();
        }
        return null;
    }
}