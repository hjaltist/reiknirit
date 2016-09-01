package d1;

/**
 * Created by hjaltisteinar on 25.8.2016.
 */

import edu.princeton.cs.algs4.*;

public class Parentheses {
    public static void main(String[] args)
    {
        Stack<String> ops =  new Stack<String>();
        Stack<Double> vals =  new Stack<Double>();

        int left = 0;
        int right = 0;

        while(!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            StdOut.println(s);

            if(s.equals("(")){
                left++;
            } else if(s.equals("+")) {
                ops.push(s);
            } else if(s.equals("-")) {
                ops.push(s);
            } else if(s.equals("*")) {
                ops.push(s);
            } else if(s.equals("/")) {
                ops.push(s);
            } else if(s.equals(")")) {

                right++;

                String op = ops.pop();
                //StdOut.println(op);
                double v = vals.pop();

                if	(op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                }

                vals.push(v);
            }
            else
                vals.push(Double.parseDouble(s));

        }
        // forritið virðist stoppa hér....
        StdOut.print("TEST");
        StdOut.println(vals.pop());
    }
}
