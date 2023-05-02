using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace evenbettersyntaxanalyzer
{
    internal class token
    {
        public string type { get; set; }
        public string value { get; set; }

        public token(string type, string value)
        {
            this.type = type;
            this.value = value;
        }
    }
}

