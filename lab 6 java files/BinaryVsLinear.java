class BinaryVsLinear  
{  
    private static int linearSearch(int key, int [] keys)  
    {  
        int count = 0;
        for (int i = 0; i < keys.length; i++)
        {  
            if (keys[i] == key)
            {
                count++;
                return count;
            }
            else
            {
                count++;
            }
        }
        return -1;  
    }  

    private static int binarySearch(int key, int [] keys)  
    {  
        int count = 0;
        int low = 0;
        int high = keys.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (keys[mid] == key){
                count++;
                return count;
            }
            else if (keys[mid] < key) {
                count += 2;
                low = mid + 1;
            }
            else{
                count+=2;
                high = mid - 1; 
            }
        }
        return -1;  
    }  

    public static void main(String [] args)  
    {  
        for (int length = 1; length <= 30; length += 1)  
        {  
            int[] array = new int[length];  
            for (int index = 0; index < length; index += 1)  
            {  
                array[index] = index;  
            }  

            double linearTotal = 0.0;  
            double binaryTotal = 0.0;  
            for (int element = 0; element < length; element += 1)  
            {  
                linearTotal += linearSearch(element, array);  
                binaryTotal += binarySearch(element, array);  
            }  

            double linearAverage = linearTotal / length;  
            double binaryAverage = binaryTotal / length;  
            System.out.println(length + " " + linearAverage + " " + binaryAverage);  
        }  
    }  
}
