using Microsoft.Win32;
using System.CodeDom.Compiler;
using System.IO;

class source {
    static void Main(String[] args) {
        var watch = new System.Diagnostics.Stopwatch();
        watch.Start();
        Console.WriteLine("What would you like to do");
        String input = Console.ReadLine();
        if (string.Equals(input, "Register", StringComparison.OrdinalIgnoreCase))
        {
            try { register(); }
            catch
            {
                Console.WriteLine("Invalid Input please try again");
                register();
            }

        }
        else if (string.Equals(input, "Retrieve", StringComparison.OrdinalIgnoreCase) || string.Equals(input, "Retrieve Data", StringComparison.OrdinalIgnoreCase))
        {
            try { retrieve(); }
            catch
            {
                Console.WriteLine("Invalid Input please try again");
                retrieve();
            }
        }
        else {
            Console.WriteLine("Invalid input");
        }

        watch.Stop();
        Console.WriteLine($"Execution Time: {watch.ElapsedMilliseconds} ms");
    }
    static void register() {
        Console.WriteLine("What is your first name?");
        String fname = Console.ReadLine().ToUpper();
        Console.WriteLine("What is your last name?");
        String lname = Console.ReadLine().ToUpper();
        Console.WriteLine("What is your date of birth (YYYMMDD)");
        int dob = Convert.ToInt32(Console.ReadLine());
        Console.WriteLine("How many doses have you had?");
        String dose_numer = Console.ReadLine();
        Console.WriteLine("What is the date of the previous dose");
        String dose_date = Console.ReadLine();
        Console.WriteLine("What type of dose did you have? Moderna, Pfizer, etc.");
        String dose_type = Console.ReadLine().ToUpper();
        Console.WriteLine("What is your zip code?");
        String zip = Console.ReadLine();
        int intage = int.Parse(DateTime.Now.ToString("yyyyMMdd"))-dob;
        String age =intage.ToString();
        age = age.Substring(0,2);
        String code = fname.Substring(0, 1) + lname.Substring(0, 1) + age + dose_type.Substring(0, 1) + zip.Substring(zip.Length - 3);
        String data = code + "       " + fname + "        " + lname + "        " + dob + "        " + dose_numer + "        " + dose_date + "        " + dose_type + "        " + zip;
        Console.WriteLine("Your code is " + code);
        String path = @"C:\Users\Ayman\Documents\systemlevelprog\coviddatabase\coviddatabase\registrycs.txt";
        StreamWriter pencil = File.AppendText(path);
        pencil.WriteLine(data);
        pencil.Close();
    }
    static void retrieve() {
        String path = @"C:\Users\Ayman\Documents\systemlevelprog\coviddatabase\coviddatabase\registrycs.txt";
        StreamReader sr = new StreamReader(path);
        Console.WriteLine("What is your code make sure to follow caps");
        String code = Console.ReadLine();
        string[] lines = File.ReadAllLines(path);
        for (int i = 0; i < lines.Length; i++)
        {
            if (string.Equals(lines[i].Substring(0, 7),code)) {
                Console.WriteLine(lines[i]);
                break;
            }
            
            }
        }
    }
    

