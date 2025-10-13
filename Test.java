public class Test 
{
    public static void main(String[] args)
    {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (scanner.hasNextLine())
        {
            String in = scanner.nextLine();
            System.out.println(in);
        }
        scanner.close();
    }    
}
