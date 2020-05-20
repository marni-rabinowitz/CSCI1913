
/**
 * Write a description of class Sieve here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sieve
{
    private boolean[] numbers;
    public Sieve(int max)
    {
        if(max < 2)
        {
            throw new IllegalArgumentException();
        }
        numbers = new boolean[max];
        numbers[0] = false;
        numbers[1] = false;
        for(int i = 2; i < numbers.length; i++)
        {
            numbers[i] = true;
        }
    }

    public void findPrimes()
    {
        for(int i = 2; i < numbers.length; i++)
        {
            if(numbers[i] == true)
            {
                for(int j = i + 1; j < numbers.length; j++)
                {
                    if(j % i == 0)
                    {
                        numbers[j] = false;
                    }
                }
            }
        }
    }

    public String toString()
    {
        String str = "";
        for(int i = 2; i < numbers.length; i++)
        {
            if(numbers[i] == true)
            {
                str += i + " ";
            }
        }
        return str;
    }
}
