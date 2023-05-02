using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace evenbettersyntaxanalyzer
{
    internal class tokenizer
    {
        private string input;
        private int pos;
        private Dictionary<string, string> keys = new Dictionary<string, string>
        {{"if", "IF_STMT"},{"else", "ELSE_STMT"},{"while", "WHILE_LOOP"},{"int", "DATATYPE"},{"double", "DATATYPE"},{"char", "DATATYPE"},{"bool", "DATATYPE"},{"&&","AND" },{ "||","OR"} };
        public tokenizer(string input)
        {
            this.input = input;
            this.pos = 0;
        }
        private char whatsnext()
        {
            if (pos < input.Length)
            {
                return input[pos];
            }
            return '\0';
        }
        private char Next()
        {
            char curr = whatsnext();
            if (pos < input.Length)
            {
                pos++;
            }
            return curr;
        }
        private bool number(char c)
        {
            return c >= '0' && c <= '9';
        }
        private bool letter(char c)
        {
            return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
        }
        private string ident()
        {
            string result = "";
            while (letter(whatsnext()) || number(whatsnext()))
            {
                result += Next();
            }
            if (keys.ContainsKey(result))
            {
                return keys[result];
            }
            return "ID";
        }
        private string numb()
        {
            string result = "";
            bool doubley = false;
            while (number(whatsnext()) || whatsnext() == '.')
            {
                if (whatsnext() == '.')
                {
                    if (doubley)
                    {
                        throw new Exception("Invalid number format");
                    }
                    doubley = true;
                }
                result += Next();
            }
            if (doubley)
            {
                return "DOUBLE_LIT";
            }
            return "INT_LIT";
        }

        private void SkipWhitespace()
        {
            while (Char.IsWhiteSpace(whatsnext()))
            {
                Next();
            }
        }
        public List<token> Tokenize()
        {
            List<token> tokens = new List<token>();
            while (pos < input.Length)
            {
                SkipWhitespace();
                if (whatsnext() == '\0')
                {
                    break;
                }
                if (whatsnext() == '+' || whatsnext() == '-' || whatsnext() == '*' || whatsnext() == '/' || whatsnext() == '%' || whatsnext() == '(' || whatsnext() == ')'|| whatsnext() == '{' || whatsnext() == '}' || whatsnext() == ';' || whatsnext() == ',' || whatsnext() == '=' || whatsnext() == '>' || whatsnext() == '<'|| whatsnext() == '!' || whatsnext() == '&'|| whatsnext() == '|')
                {
                    if (whatsnext() == '+') {
                        tokens.Add(new token("ADD", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '-')
                    {
                        tokens.Add(new token("SUB", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '*')
                    {
                        tokens.Add(new token("MULTI", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '/')
                    {
                        tokens.Add(new token("DIV", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '%')
                    {
                        tokens.Add(new token("MOD", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '(')
                    {
                        tokens.Add(new token("LEFT_PARA", whatsnext().ToString()));
                    }
                    else if (whatsnext() == ')')
                    {
                        tokens.Add(new token("RIGHT_PARA", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '{')
                    {
                        tokens.Add(new token("LEFT_BRACE", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '}')
                    {
                        tokens.Add(new token("RIGHT_BRACE", whatsnext().ToString()));
                    }
                    else if (whatsnext() == ';')
                    {
                        tokens.Add(new token("SEMI", whatsnext().ToString()));
                    }
                    else if (whatsnext() == ',')
                    {
                        tokens.Add(new token("COMMA", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '=')
                    {
                        tokens.Add(new token("EQUAL", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '>')
                    {
                        tokens.Add(new token("GREATER", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '<')
                    {
                        tokens.Add(new token("LESSER", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '!')
                    {
                        tokens.Add(new token("NOT", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '&')
                    {
                        tokens.Add(new token("AND", whatsnext().ToString()));
                    }
                    else if (whatsnext() == '|')
                    {
                        tokens.Add(new token("OR", whatsnext().ToString()));
                    }
                    Next();
                }
                else if (letter(whatsnext()))
                {
                    tokens.Add(new token(ident(), ""));
                }
                else if (number(whatsnext()))
                {
                    tokens.Add(new token(numb(), ""));
                }
                else
                {
                    throw new Exception("Invalid character: " + whatsnext());
                }
            }
            return tokens;
        }
    }
}
