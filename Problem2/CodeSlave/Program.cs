using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeSlave
{
    class Program
    {
        static void Main(string[] args)
        {
            int length = 0;
            int counter = 0;
            string outputFileName = @"output.txt";
            bool header = true;
            int clapper = 0;
            int clap = 0;
            using (FileStream fs = File.Open(@"input_2.txt", FileMode.Open))
            using (BufferedStream bs = new BufferedStream(fs))
            using (StreamReader sr = new StreamReader(bs))
            {
                using (var outputFile = new StreamWriter(outputFileName))
                {
                    string s;
                    while ((s = sr.ReadLine()) != null)
                    {
                        if (header)
                        {
                            header = false;
                            length = Convert.ToInt16(s);
                        }
                        else
                        {
                            clapper = Convert.ToInt32(s.Split(' ')[0]);
                            clap = Convert.ToInt32(s.Split(' ')[1]);
                            counter++;

                            bool[] circuit = new bool[clapper + 1];
                            circuit[0] = true;
                            int firstOn = 0;
                            for (int j = 1; j <= clap; j++)
                            {
                                for (int k = clapper; k >= 1; k--)
                                {
                                    if (circuit[k - 1] == true)
                                    {
                                        circuit[k] = !circuit[k];
                                    }
                                }
                                if (circuit.Contains(false) == false)
                                {
                                    if (firstOn == 0)
                                    {
                                        firstOn = j;
                                        int temp = clap - firstOn;
                                        int reminder = temp % firstOn + 1;
                                        if (firstOn == 1)
                                        {
                                            if (clap % 2 == 1)
                                            {
                                                reminder = 0;
                                            }
                                            else
                                            { reminder = 1; }
                                        }
                                        if (reminder == 0)
                                        {
                                            outputFile.WriteLine(string.Format("Experiment-{0}: {1}", counter, "ON"));
                                        }
                                        else
                                        {
                                            outputFile.WriteLine(string.Format("Experiment-{0}: {1}", counter, "OFF"));
                                        }
                                        break;
                                    }
                                }
                            }
                            if (firstOn == 0)
                            {
                                if (circuit.Contains(false))
                                {
                                    outputFile.WriteLine(string.Format("Experiment-{0}: {1}", counter, "OFF"));
                                }
                                else
                                {
                                    outputFile.WriteLine(string.Format("Experiment-{0}: {1}", counter, "ON"));
                                }
                            }
                            firstOn = 0;
                            circuit = null;
                        }

                    }
                }
            }
        }
    }
}
