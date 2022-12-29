import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class prog2 
{
    public static void main(String[] args) throws Exception
    {
        Logger loger = Logger.getLogger(prog2.class.getName());
        FileHandler fHandler = new FileHandler("log.txt");
        SimpleFormatter sFormatter = new SimpleFormatter();
        fHandler.setFormatter(sFormatter);
        loger.addHandler(fHandler);
        
        int[] array = { 7, 4, 7, 9, 8, 7, 3, 5, 1, 4, 2, 6, 5 };
        int temp;

        for (int i = array.length - 1; i > 0; i--) 
        {
            for (int j = 0; j < i; j++) 
            {
                if (array[j] > array[j + 1]) 
                {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }  
            }
            loger.info(Arrays.toString(array));
        }
    }
}
