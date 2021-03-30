/**
 * Name: Parser.java
 *
 *  The main objective of this class is to implement a simple parser.
 *  It should be able to parser the following grammar rule:
 *  <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
 *  <term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
 *  <factor> ::= <unsigned integer> | ( <exp> )
 *
 */

public class Parser {

    MyTokenizer _tokenizer;

    public Parser(MyTokenizer tokenizer) {
        _tokenizer = tokenizer;
    }

    /*
    <exp>    ::= <term> | <term> + <exp> | <term> - <exp>
     */
    public Exp parseExp() {
        // TODO: Implement parse function for <exp>
        // ########## YOUR CODE STARTS HERE ##########
 
    	Exp term = parseTerm();
    	
		if (_tokenizer.hasNext() == true) {
		
	   		Token t = _tokenizer.current();
			if(t.type() == Token.Type.ADD)
			{
				_tokenizer.next();
	    		Exp exp = parseExp();
	    		return new AddExp(term, exp);
	    	}
	    	else if (t.type() == Token.Type.SUB)
	    	{
				_tokenizer.next();
	   			Exp exp = parseExp();
	   			return new SubExp(term, exp);
	    	}
		}
   		return term;

        // ########## YOUR CODE ENDS HERE ##########
    }

    //<term>   ::=  <factor> | <factor> * <term> | <factor> / <term>
    public Exp parseTerm() {
        // TODO: Implement parse function for <term>
        // ########## YOUR CODE STARTS HERE ##########

    	Exp factor = parseFactor();

		_tokenizer.next();

		if (_tokenizer.hasNext() == true) {
    		Token t = _tokenizer.current();
    	
	    	if(t.type() == Token.Type.MUL)
	    	{
				_tokenizer.next();
	   			Exp term = parseTerm();
	   			return new MultExp(factor, term);
	   		}
	    	else if (t.type() == Token.Type.DIV)
	    	{
	   	    	_tokenizer.next();
	   			Exp term = parseTerm();
	   			return new DivExp(factor, term);
	   		}
    	}
    	
   		return factor;
        // ########## YOUR CODE ENDS HERE ##########
    }
    
    //<factor> ::= <unsigned integer> | ( <exp> )
    public Exp parseFactor() {
        // TODO: Implement parse function for <factor>
        // ########## YOUR CODE STARTS HERE ##########
    	IntExp i;

    	Token t = _tokenizer.current();
    	
    	if (t.type() == Token.Type.LBRA)
    	{
			_tokenizer.next();
   			Exp exp = parseExp();
			return exp;
    	}
    	else //if(t.type() == Token.Type.INT)
    	{
    		Integer ti = Integer.parseInt(t.token());
    		i = new IntExp(ti);
    		return i;
    	}
    	
        // ########## YOUR CODE ENDS HERE ##########
    }

    public static void main(String[] args) {
        MyTokenizer mathTokenizer = new MyTokenizer("2+1");
        Exp t1 = new Parser(mathTokenizer).parseExp();
        System.out.println(t1.show());
        System.out.println(t1.evaluate());
    }
}
