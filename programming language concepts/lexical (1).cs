using System;
using System.Collections.Generic;
using System.IO;
using System.Text.RegularExpressions;

public class lexical
{
    static List<int> ints = new List<int>();
    static List<double> doubles = new List<double>();

    public static void Main(String[] args)
    {
        Console.WriteLine("What is the path and name of your file ex:C:\\Users\\Ayman\\Documents\\plc\\test.txt");
        string file = Console.ReadLine();
       try
        {
            string text = File.ReadAllText(file);
            lex(text);
        }
        catch
       {
            Console.WriteLine("The given file name or file path is invalid");
       }
    }

    public static void lex(string text)
    {
        text = text.Replace(" ", "");
        MatchCollection nums = Regex.Matches(text, @"\d+(\.\d+)?");
        MatchCollection vars = Regex.Matches(text, @"^[a-zA-Z]$");
        string[] cases = { @"\+", @"\-", @"\*", @"\\", @"%", @"\(", @"\)", @"=", @"<", @"<=", @">", @">=", @"&&|[and]|[AND]", @"\|\||[or]|[OR]" };
        string[] types = { "Addition", "Subtraction", "Multiplication", "Division", "Modulo", "Open paranthesis", "Close paranthesis", "Equal", "Less than", "Less than or equal to", "Greater", "Greater than or equal to", "And", "Or","Integers","Doubles" };
        Boolean[] result = new Boolean[cases.Length+2];
        for (int x = 0; x < cases.Length; x++)
        {
            Regex re = new Regex(cases[x]);
            if (re.IsMatch(text))
            {
                result[x] = true;
            }
            else
            {
                result[x] = false;
            }
        }
        foreach (Match match in nums)
        {
            if (int.TryParse(match.Value, out int intResult))
            {
                ints.Add(intResult);
                result[14] = true;
            }
            else if (double.TryParse(match.Value, out double doubleResult))
            {
                doubles.Add(doubleResult);
                result[15] = true;
            }

        }
        for (int x = 0; x < cases.Length; x++)
        {
            if (result[x] == true)
            {
                Console.WriteLine("Token for " + types[x] + " has been satisfied with a " + cases[x]);
            }
        }
        if (result[14] == true)
        {
            Console.WriteLine("Token for " + types[14] + " has been satisfied with " );
            for (int x = 0; x < ints.Count; x++) {
                Console.Write(ints[x] + " ");
            }
        }
        Console.WriteLine();
        if (result[15] == true)
        {
            Console.WriteLine("Token for " + types[15] + " has been satisfied with ");
            for (int x = 0; x < doubles.Count; x++)
            {
                Console.Write(doubles[x] + " ");
            }
        }

    }
}
