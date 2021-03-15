import java.io.*;

public class FileInputStreamEx {
    public static void main(String agrs[]) throws IOException {
        FileInputStream file = new FileInputStream("c:\\windows\\system.ini");
        int c;
        while((c=file.read()) != -1){
            System.out.print((char)c);
        }

        file.close();
    }
}
