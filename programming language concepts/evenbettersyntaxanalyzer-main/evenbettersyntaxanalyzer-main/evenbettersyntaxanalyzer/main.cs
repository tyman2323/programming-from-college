using evenbettersyntaxanalyzer;

public class main
{
    public static void Main(String[] args)
    {
        Console.WriteLine("Please write the file path and name. Example:C:\\Users\\Owner\\Documents\\funcode\\syntaxanalyzer\\test.txt");
        string file = Console.ReadLine();
        string code = "";
        if (File.Exists(file))
        {
            code = File.ReadAllText(file);
            tokenizer tokenplease = new tokenizer(code);
            List<token> tokenss = tokenplease.Tokenize();
            foreach (token x in tokenss) {
                Console.WriteLine(x.type + " " + x.value);
            }
            syntaxchecker checkit = new syntaxchecker(tokenss);
            
            try { 
                checkit.STMT();
                Console.WriteLine("No Errors Found");
            }
            catch (Exception e) {Console.WriteLine("An error has occured, please check your syntax and try again"); }
        }
        else
        {
            Console.WriteLine("File does not exist, check the path and file name again.");
        }
    }
}