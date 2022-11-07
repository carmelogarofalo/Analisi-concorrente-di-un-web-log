import java.io.*;
import java.util.concurrent.*;


public class Main
{

    public static void main(String[] args) throws IOException
    {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String nome_file;
        int c = 0;
        String[] array = new String[3];
        ExecutorService service = Executors.newCachedThreadPool();

        System.out.print("Inserisci il nome del file di log: ");
        nome_file = bufferedReader.readLine();

        File file = new File(nome_file);

        if(file.exists() && file.isFile())
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fileInputStream);
                BufferedReader br = new BufferedReader(isr);
                String line;
                long time1 = System.currentTimeMillis();
                long time2;

                while((line = br.readLine()) != null )
                {
                    if(c==2)
                    {
                        array[c] = line;
                        service.execute(new Task(array.clone()));
                        array[0] = "";
                        array[1] = "";
                        array[2] = "";
                        c = 0;
                    }

                    else
                    {
                        array[c] = line;
                        c++;
                    }
                }

                service.shutdown();
                service.awaitTermination(100000,TimeUnit.MILLISECONDS);
                time2 = System.currentTimeMillis();
                System.out.print("\n\nTempo trascorso: "+(time2-time1) + " ms");

            }catch (IOException | InterruptedException e) {throw new RuntimeException(e);}
        }
    }
}
