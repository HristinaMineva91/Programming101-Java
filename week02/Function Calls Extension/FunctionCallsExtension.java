package function;

import java.util.HashMap;

public class FunctionCallsExtension {
  private static interface Function {
    public int call(int x);
  }

  public static HashMap<String, Function> functionMap(String[] funcs) {
    final HashMap<String, Function> functions = new HashMap<String, Function>();
    for (String str : funcs) {
      final String[] terms = str.split(" ");
      String name = terms[0];
      functions.put(name, new Function() {
        public int call(int x) {
          int result = 0;
          String operation = null;
          for (int i = 3; i < terms.length; i++) {
            if (isInteger(terms[i])) {
              result += sign(operation) * Integer.parseInt(terms[i]);
            } else if (isOperation(terms[i])) {
              operation = terms[i];
            } else if (isVariable(terms[i])) {
              result += sign(operation) * x;
            } else if (isFunction(terms[i])) {
              String name = functionName(terms[i]);
              String arg = functionArg(terms[i]);
              if (isInteger(arg)) {
                int intArg = Integer.parseInt(arg);
                result += sign(operation) * functions.get(name).call(intArg);
              } else {
                result += sign(operation) * functions.get(name).call(x);
              }
            }
          }
          return result;
        } 
      });
    }
    
    return functions;
  }

  public static String functionName(String str) {
    return str.substring(0, str.indexOf("("));
  }
  
  public static String functionArg(String str) {
    return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
  }

  public static int sign(String operation) {
    return (operation == null || operation.equals("+")) ? 1 : -1;
  }

  public static boolean isInteger(String str) {
    try {
      Integer.parseInt(str);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
  
  public static boolean isOperation(String str) {
    return str.equals("+") || str.equals("-");
  }
  
  public static boolean isVariable(String str) {
    return !isInteger(str) && !isOperation(str) && str.indexOf("(") == -1 && str.indexOf(")") == -1;
  }
  
  public static boolean isFunction(String str) {
    return !isInteger(str) && !isOperation(str);
  }

  public static int evaluate(HashMap<String, Function> functionMap,
      String expr, int x) {
    String[] funcs = expr.split(" . ");
    int result = x;
    int i = funcs.length - 1;
    do {
      result = functionMap.get(funcs[i]).call(result);
      i--;
    } while (i >= 0);

    return result;
  }

  public static void main(String[] args) {
    int n = 2;
    String[] funcs = { "inc x = x + 1", "dec x = x - inc(0)" };
    String expr = "dec . dec";
    int x = 2;
    System.out.println(evaluate(functionMap(funcs), expr, x));
  }
}
