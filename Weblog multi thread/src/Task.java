import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Task implements Runnable
{

    private String[] array = new String[3];

    public Task(String[] array)
    {
        this.array = array;
    }

    @Override
    public void run()
    {

        try
        {

            String ip;

            for(int i=0; i<3; i++)
            {
                ip = array[i].substring(0,(array[i].indexOf("-")-1));
                InetAddress inetAddress =  InetAddress.getByName(ip);
                array[i] = array[i].replace(ip,inetAddress.getHostName());
                System.out.print("\n"+array[i]);
            }

        } catch (UnknownHostException e) {throw new RuntimeException(e);}
    }

}
