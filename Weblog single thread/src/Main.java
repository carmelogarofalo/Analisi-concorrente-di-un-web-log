import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String file;

        System.out.print("Inserisci il nome del file di log: ");
        file = bufferedReader.readLine();

        Task task = new Task(file);
        Thread thread = new Thread(task);

        thread.start();
    }
}
