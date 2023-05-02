using System;
using System.Text.RegularExpressions;

public class Program
{
    public static void Main(string[] args)
    {
        string email = "atawaalai1@stud-ent.gsu.edu";
        string regex = "1.575E1";
        Regular1(email);
        Regular2(regex);
        regex = "2000000022l";
        Regular3(regex);
        regex = "cbadcbad";
        Regular4(regex);
        regex = "9banasffwFWEg";
        Regular5(regex);
        regex = "/*hello  */";
        Regular6(regex);
    }

    public static void Regular1(string regex)
    {
        string[] locdom = regex.Split('@');
        string localregex = @"[a-zA-Z0-9#!%`$&+=?^_'{|}~*\-]+([.]*)?";
        string domainregex = @"[a-zA-Z0-9]+(-?[a-zA-Z0-9]+)*(.[a-zA-Z0-9]+)+";
        if (Regex.IsMatch(locdom[0], localregex) && Regex.IsMatch(locdom[1], domainregex))
        {
            Console.WriteLine("This is a valid email address");
        }
        else
        {
            Console.WriteLine("Not a valid email");
        }
    }
    public static void Regular2(string regex)
    {
        string rege = @"[+-]?\d+(\.\d+)?([eE][+-]?\d+)?[LlFf]?";
        if ((Regex.IsMatch(regex, rege)))
        {
            Console.WriteLine(regex + " is a float");
        }
        else
        {
            Console.WriteLine(regex + " is not a float");
        }
    }
    public static String Regular3(string regex)
    {
        string rege = @"0[xX]?[\da-fA-F]+([iIuUlL][6-9]?[2-9]?)?";

        if (Regex.IsMatch(regex, rege))
        {
            return(regex + " is an integer.");
        }
        else
        {
            return(regex + " is not an integer.");
        }
    }
    public static string Regular4(string regex)
    {
        if ((regex.StartsWith("a") || regex.StartsWith("b")) && regex.EndsWith("cd"))
        {
            int a = 0;
            int b = 0;
            for (int i = 0; i < regex.Length; i++)
            {
                if (regex[i] == 'a')
                {
                    a++;
                }
                else if (regex[i] == 'b')
                {
                    b++;
                }
                else if (regex[i] != 'c' && regex[i] != 'd')
                {
                    Console.WriteLine(regex + " is not existent in the language");
                    return null;
                }
            }
            if (a % 2 == 0 && b % 2 == 1)
            {
                Console.WriteLine(regex + " is existent in the language");
                return null;
            }
            else
            {
                Console.WriteLine(regex + " is not existent in the language");
                return null;
            }
        }
        else if (regex.StartsWith("cbad"))
        {
            int cbadb = 1;
            for (int i = 4; i < regex.Length; i += 4)
            {
                if (!regex.Substring(i, 4).Equals("cbad"))
                {
                    Console.WriteLine(regex + " is not existent in the language");
                    return null;
                }
                cbadb++;
            }
            if (cbadb % 2 == 0)
            {
                Console.WriteLine(regex + " is existent in the language");
                return null;
            }
            Console.WriteLine(regex + " is not existent in the language");
            return null;
        }
        else
        {
            Console.WriteLine(regex + " is not existent in the language");
            return null;
        }
    }
    public static void Regular5(string regex) {
        string rege = @"^[a-zA-Z_$][a-zA-Z\\d_$]*$";
        if (Regex.IsMatch(regex, rege))
        {
            Console.WriteLine("This is a valid variable, class, or method name in java");
        }
        else {
            Console.WriteLine("This is not a valid variable, class, or method name in java");
        }
    }
    public static void Regular6(string regex)
    {
        string rege = @"\/\*.*\*\/";
        if (Regex.IsMatch(regex, rege))
        {
            Console.WriteLine("This is a multiline comment");
        }
        else
        {
            Console.WriteLine("This is not a multiline comment");
        }
    }
}
/********************************************************
 * 
 * THERE ARE LEXEMS ABOVE NOT INCLUDING THE USING STATEMENTS 105
*/////////////////////////////////////////////////////////