using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace evenbettersyntaxanalyzer
{
    internal class syntaxchecker
    {
        private List<token> tokens;
        private int pos;
        private string curr;
        private List<bool> inpara;
        public syntaxchecker(List<token> tokens)
        {
            this.tokens = tokens;
            pos = 0;
            curr = tokens[pos].type;
        }
        public void STMT()
        {
            if (curr == "IF_STMT")
            {
                ifstmt();
                
            }
            else if (curr == "LEFT_BRACE")
            {
                block();
            }
            else if (curr == "ID")
            {
                assign();
            }
            else if (curr == "DATATYPE")
            {
                declare();
            }
            else if (curr == "WHILE_LOOP")
            {
                whileloop();
            }
            else
            {
                error();
            }
        }
        private void error()
        {
            Console.WriteLine("A error has occured, please check your syntax and try again" + curr);
            //Environment.Exit(0);
        }
        private void whileloop() {
            pos++;
            curr = tokens[pos].type;
            if (curr == "LEFT_PARA")
            {
                bool_expr();
                pos++;
                curr = tokens[pos].type;
                if (curr == "LEFT_BRACE")
                {
                    block();
                }
            }
        }
        private void ifstmt()
        {
            pos++;
            curr = tokens[pos].type;
            if (curr == "LEFT_PARA")
            {
                bool_expr();
                pos++;
                curr = tokens[pos].type;
                if (curr == "LEFT_BRACE") {
                    block();
                }
            }
            if (curr == "ELSE_STMT") {
                if (curr == "LEFT_BRACE")
                {
                    block();
                }
            }
        }
        private void bool_expr()
        {
            pos++;
            curr = tokens[pos].type;
            if (curr == "ID" || curr == "INT_LIT" || curr == "DOUBLE_LIT")
            {
                pos++;
                curr = tokens[pos].type;
                if (curr == "GREATER" || curr == "LESSER")
                {
                    pos++;
                    curr = tokens[pos].type;
                    if (curr == "ID" || curr == "INT_LIT" || curr == "DOUBLE_LIT") {
                        pos++;
                        curr = tokens[pos].type;
                        if (curr != "RIGHT_PARA") {
                            error();
                        }
                    }
                }
                else if ((curr == "GREATER" && tokens[pos + 1].type == "EQUAL") || (curr == "LESSER" && tokens[pos + 1].type == "EQUAL"))
                {
                    pos++;
                    curr = tokens[pos].type;
                    if (curr == "ID" || curr == "INT_LIT" || curr == "DOUBLE_LIT") {
                        pos++;
                        curr = tokens[pos].type;
                        if (curr != "RIGHT_PARA") {
                            error();
                        }
                    }
                }
                else {
                    error();
                }
            }
            else {
                error();
            }
        }
        private void block() { 
            pos++;
            curr = tokens[pos].type;
            if (curr == "RIGHT_BRACE")
            {
                
            }
            else {
                stmtlist();
                block();
            }
                
        }
        private void stmtlist() {
            STMT();
            if (curr != "SEMI") {
                error();
            }
        }
        private void declare() {
            pos++;
            curr = tokens[pos].type;
            if (curr == "ID" && tokens[pos + 1].type == "COMMA") {
                pos++;
                curr = tokens[pos].type;
                declare();
            }
            else  if (curr == "ID")
            {
                assign();
            }
            else
            {
                error();
            }
        }
        private void assign() {
            if (curr == "ID")
            {
                pos++;
                curr = tokens[pos].type;
                if (curr == "EQUAL")
                {
                    expr();
                }
                else {
                    error();
                }
            }
            else {
                error();
            }
        }
        
        private void expr() {
            pos++;
            curr = tokens[pos].type;
            if (tokens[pos + 1].type == "ADD" || tokens[pos + 1].type == "SUB")
            {
                term(pos + 1);
            }
                term(pos);
            
            
        }
        private void term(int posit) {
            if (tokens[posit+1].type == "MULTI" || tokens[posit+1].type == "DIV" || tokens[posit+1].type == "MOD")
            {
                fact(posit + 1);
            }
            else {
                fact(posit);
            }
        }
        private void fact(int posit) {
            if (curr == "ID")
            {
                pos = posit;
                expr();
            }
            else if (curr == "INT_LIT")
            {
                pos = posit;
                expr();
            }
            else if (curr == "DOUBLE_LIT")
            {
                pos = posit;
                expr();
            }
            else { 
                
            }
        }
    }
}
