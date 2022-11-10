package _2021210981chap3;

import java.util.Scanner;

public class first {
    public static int judge(char operator1) {
        if (Integer.valueOf(operator1) == 42 || Integer.valueOf(operator1) == 47)
            return 1;
        else
            return 0;
    }

    public static String transform(String expression) throws Exception {
        SeqStack operator = new SeqStack(100);
        String outcome = "";
        for (int i = 0; i < expression.length(); i++) {
            //遇到运算对象时，将运算对象追加到保存到后缀表达式的字符串中
            if (!(expression.charAt(i) >= 40 && expression.charAt(i) <= 47)) {
                outcome += expression.charAt(i);
                continue;
            }
            //遇到运算符时，进行如下判断
            //如果运算符为括号，进行如下判断
            //运算符为左括号(，则直接将运算符入栈
            if (expression.charAt(i) == 40)
                operator.push(expression.charAt(i));
                //运算符为右括号)，则依次从s1栈中弹出运算符并追加到字符串中，直到遇到左括号(此时将这一对括号丢弃。
            else if (expression.charAt(i) == 41) {
                while ((char) (operator.getTop()) != 40) {
                    outcome += (char) operator.pop();
                }
            }
            //如果运算符不是括号
            else {
                //栈顶元素为左括号(或者s1栈为空，直接将刚弹出的左括号(和运算符依次入s1栈。
                if (operator.top == 0)
                    operator.push(expression.charAt(i));
                else if (judge(expression.charAt(i)) > judge((Character) operator.getTop()))
                    operator.push(expression.charAt(i));
                else {
                    while ((judge((char) operator.getTop()) >= judge(expression.charAt(i))) && (char) operator.getTop() != 40) {
                        outcome += (char) operator.pop();
                        if (operator.top == 0)
                            break;
                    }
                    operator.push(expression.charAt(i));
                }
            }
        }
        while (operator.top != 0) {
            if ((char) operator.getTop() != 40)
                outcome += (char) operator.pop();
            else
                operator.pop();
        }
        return outcome;
    }

    public static Double PostfixEvaluation(String expression) throws Exception {
        SeqStack<Double> val = new SeqStack<>(100);
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= 48 && expression.charAt(i) <= 57)
                val.push((double) Character.getNumericValue(expression.charAt(i)));
            else {
                double y = val.pop();
                double x = val.pop();
                if (expression.charAt(i) == '*')
                    val.push(x * y);
                else if (expression.charAt(i) == '/')
                    val.push(x / y);
                else if (expression.charAt(i) == '+')
                    val.push(x + y);
                else if (expression.charAt(i) == '-')
                    val.push(x - y);
            }
        }
        return (Double) val.getTop();
    }

    public static void main(String[] args) throws Exception {
        String Infix, Postfix;
        Scanner reader = new Scanner(System.in);
        Infix = reader.nextLine();
        Postfix = transform(Infix);
        Double val = PostfixEvaluation(Postfix);
        System.out.println("后缀表达式形式为：" + Postfix);
        System.out.println("后缀表达式求值为：" + val);
    }
}
