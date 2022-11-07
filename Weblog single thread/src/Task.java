import java.io.*;
import java.net.InetAddress;

public class Task implements Runnable
{

    private String log;

    public Task(String log)
    {
        this.log = log;
    }

    @Override
    public void run()
    {
        try
        {
            File file = new File(log);
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line,ip;
            long time1 = System.currentTimeMillis();
            long time2;

            while((line = bufferedReader.readLine()) != null )
            {
                ip = line.substring(0,line.indexOf("-")-1);
                InetAddress inetAddress = InetAddress.getByName(ip);
                line = line.replace(ip,inetAddress.getHostName());
                System.out.print("\n"+line);

            }

            time2 = System.currentTimeMillis();
            System.out.print("\n\nTempo trascorso: "+(time2-time1) + " ms");

        } catch (IOException e) {throw new RuntimeException(e);}

    }

}
