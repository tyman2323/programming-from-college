using System.Data;
using System.Text.RegularExpressions;

public class syntaxanalyzer
{
    public static void Main(String[] args)
    {
        Console.WriteLine("Please write the file path and name. Example:C:\\Users\\Owner\\Documents\\funcode\\syntaxanalyzer\\test.txt");
        string file = Console.ReadLine();
        string code = "";
        if (File.Exists(file))
        {
            code = File.ReadAllText(file);

        }
        else
        {
            Console.WriteLine("File does not exist, check the path and file name again.");
        }
        statement(code);
        Console.WriteLine("No syntax errors found!");
    }
    public static void statement(string stmt)//<STMT> --> <IF_STMT> | <BLOCK> | <EXPR> | <WHILE_LOOP>
    {
        Regex ifstmt = new Regex(@"^if");
        Regex blockstmt = new Regex(@"(?<!\{)\{(?!\{).*?(?<!\})\}(?!\})");
        Regex whilestmt = new Regex(@"^while");
        Regex expstmt = new Regex(@".*;");
        if (ifstmt.IsMatch(stmt))
        {
            if_stmt(stmt);
        }
        else if (blockstmt.IsMatch(stmt))
        {
            block(stmt);
        }
        else if (whilestmt.IsMatch(stmt))
        {
            whilestat(stmt);
        }
        else if (expstmt.IsMatch(stmt))
        {
            expression(stmt);
        }
        else
        {
            Console.WriteLine("A syntax error has occured");
            Environment.Exit(0);
        }
    }
    public static void whilestat(string wyle)
    {//<WHILE_LOOP> --> `while` `(` <BOOL_EXPR> `)` ( <STMT> `;` | <BLOCK> )
        string boo = "";
        int leftpara = wyle.IndexOf('(');
        int rightpara = wyle.IndexOf(')');
        rightpara = rightpara - leftpara;
        boo = wyle.Substring(leftpara + 1, rightpara - 1);
        boo = boo.Replace("\u0020", "");
        if (boo_expr(boo))
        {
            try
            {
                wyle = wyle.Substring(wyle.IndexOf('{'), (wyle.IndexOf('}') + 1) - wyle.IndexOf('{'));
                block(wyle);
            }
            catch
            {
                Console.WriteLine("A syntax error has occured, check { }");
                Environment.Exit(0);
            }

        }
        else
        {   

            Console.WriteLine("A syntax error has occured");
            Environment.Exit(0);
        }
    }
    public static void if_stmt(string if_stmnt)//<IF_STMT> --> `if` `(` <BOOL_EXPR> `)` ( <STMT> `;` | <BLOCK> ) [ `else` ( <STMT> `;` | <BLOCK> )] 
    {
        string boo = "";
        int leftpara = if_stmnt.IndexOf('(');
        int rightpara = if_stmnt.IndexOf(')');
        rightpara = rightpara - leftpara;
        boo = if_stmnt.Substring(leftpara + 1, rightpara - 1);
        boo = boo.Replace("\u0020", "");
        if (if_stmnt.Contains("else")) {
            try
            {
                string else_stmt = if_stmnt.Substring(if_stmnt.LastIndexOf('{'), (if_stmnt.LastIndexOf('}') + 1) - if_stmnt.LastIndexOf('{'));
                if_stmnt = if_stmnt.Substring(if_stmnt.IndexOf('{'), (if_stmnt.IndexOf('}') + 1) - if_stmnt.IndexOf('{'));
                block(if_stmnt);
            }
            catch
            {
                Console.WriteLine("A syntax error has occured, check { }");
                Environment.Exit(0);
            }
        }
        if (boo_expr(boo))
        {
            try
            {
                if_stmnt = if_stmnt.Substring(if_stmnt.IndexOf('{'), (if_stmnt.IndexOf('}') + 1) - if_stmnt.IndexOf('{'));
                block(if_stmnt);
            }
            catch
            {
                Console.WriteLine("A syntax error has occured, check { }");
                Environment.Exit(0);
            }

        }
        else
        {
            Console.WriteLine("A syntax error has occured");
            Environment.Exit(0);
        }
    }
    public static bool boo_expr(string boole)//<BOOL_EXPR> --> <BTERM> {(`>`|`<`|`>=`|`<=`) <BTERM>}
    {
        Regex booleanexpression = new Regex(@"(?<=\w)(>|<|>=|<=)(?=\w)");
        if (booleanexpression.IsMatch(boole))
        {
            string[] lol = Regex.Split(boole, @">|<|>=|<=");
            for (int x =0;x<lol.Length;x++) {
                bterm(lol[x]);
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void block(string blocky)//<BLOCK> --> `{` <STMT_LIST> `}`
    {
        blocky = blocky.Replace("{", "");
        blocky = blocky.Replace("}", "");
        statementlist(blocky);
        
    }
    public static void statementlist(string blocky)
    {//<STMT_LIST> --> { <STMT> `;` }
        string[] stmtlist = blocky.Split(';');
        for(int x = 0; x< stmtlist.Length-1; x++) {
            stmtlist[x] = stmtlist[x] + ";";
            statement(stmtlist[x]);
        }
    }
    public static void expression(string express)
    { //<EXPR> --> <TERM> {(`+`|`-`) <TERM>}
        Regex addmin = new Regex(@"[-+].*");
        if (addmin.IsMatch(express))
        {
            express = express.Remove(express.Length-1);
            string[] admin = express.Split(new char[] { '+', '-' });
            for (int x = 0; x < admin.Length; x++) {
                term(admin[x]);
            }
        }
        else { 
            Console.WriteLine("A syntax error has occured");
            Environment.Exit(0);
        }
     
    }
    public static void term(string termy)
    {//<TERM> --> <FACT> {(`*`|`/`|`%`) <FACT>}
        //<FACT> --> ID | INT_LIT | FLOAT_LIT | `(` <EXPR> `)`
        Regex id = new Regex(@"^[a-zA-Z_$][a-zA-Z\\d_$]*[0-9]*$");
        Regex floatlit = new Regex(@"[\+\-]?\d+(\.\d*)?");
        Regex intlit = new Regex(@"^(-)?([1-9]+)$");
        if (id.IsMatch(termy))
        {

        }
        else if (floatlit.IsMatch(termy)) { 
        
        }
        else if(intlit.IsMatch(termy))
        {

        }
        else
        {
            Console.WriteLine("A syntax error occured");
            Environment.Exit(0);    
        }
    }
    public static void bterm(string b)
    {//<BTERM> --> <BAND> {(`==`|`!=`) <BAND>}
        //<BAND> --> <BOR> {`&&` <BOR>}
        //< BOR > --> < EXPR > {`&&` < EXPR >}
        if (b.Contains("==")|| b.Contains("!=")) {
            Console.WriteLine("You cant have a == or =! before or after the fact");
            Environment.Exit(0);
        }
        else if (b.Contains("&&"))
        {
            Console.WriteLine("You cant have a &&  before or after the fact");
            Environment.Exit(0);
        }
        if (b.Contains("||"))
        {
            Console.WriteLine("You cant have a || before or after the fact");
            Environment.Exit(0);
        }
    }
}