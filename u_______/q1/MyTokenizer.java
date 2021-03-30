

public class MyTokenizer implements Tokenizer {

    private String buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public MyTokenizer(String text) {
    	buffer = text;		// save input text (string)
    	next();		// extracts the first token.
    }

    /**
     *  This function will find and extract a next token from {@code buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {


        buffer = buffer.trim(); // remove whitespace

         if(buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
         }

        // ########## YOUR CODE STARTS HERE ##########
         char firstChar = buffer.charAt(0);
         
         //odd number and even number
       
         
         if(Character.isDigit(firstChar)) {
        	String str = "";
         	int i = 0;
         	char currentChar;
         	
         	while(i < buffer.length()) {
         		currentChar = buffer.charAt(i);
         		if(Character.isDigit(currentChar)!= true) 
         			break;
         			
         		i++;
         		
         		Character c = currentChar;
     			str += c;
         		
         	}
         	if((Integer.parseInt(str)%2)==1)
         		currentToken = new Token(str, Token.Type.ODD_NUMBER);
         	else
         		currentToken = new Token(str, Token.Type.EVEN_NUMBER);
         }
         
         if(Character.isLowerCase(firstChar)) {
         	String str = "";
          	int i = 0;
          	int flag=0;
          	char currentChar;
          	
          	while(i < buffer.length()) {
          		currentChar = buffer.charAt(i);
          		if(Character.isLowerCase(currentChar)!= true) 
          			{
          				if(Character.isUpperCase(currentChar)) 
          				{
          					flag=1;
          				
          				}
          				else
          				{
          					break;
          				}
          			}
          			
          		i++;
          		
          		Character c = currentChar;
      			str += c;
          		
          	}
          	if(flag==0)
          	currentToken = new Token(str, Token.Type.LOWER_CASE_WORD);
          	else
          	currentToken = new Token(str, Token.Type.CAMEL_CASE_WORD);
          	
          }
        
         
         if(Character.isUpperCase(firstChar)) {
          	String str = "";
           	int i = 0;
           	char currentChar;
           	int flag=0;
           	
           	while(i < buffer.length()) {
           		currentChar = buffer.charAt(i);
           		if(Character.isUpperCase(currentChar)!= true) 
           			{
           			if(Character.isLowerCase(currentChar)) 
      				{
      					flag=1;
      				
      				}
      				else
      				{
      					break;
      				}
           			}
           			
           		i++;
           		
           		Character c = currentChar;
       			str += c;
           		
           	}
           	
           	if(flag==0)
              	currentToken = new Token(str, Token.Type.UPPER_CASE_WORD);
            else
              	currentToken = new Token(str, Token.Type.CAMEL_CASE_WORD);
           	
           }
         
         if(!Character.isLetterOrDigit(firstChar)) 
        	 currentToken = new Token(firstChar+"", Token.Type.NON_ALPHANUMERIC);
         
            	
            
         
         
        
         
         
         
         

       
        // ########## YOUR CODE ENDS HERE ##########
        
        // Remove the extracted token from buffer
        int tokenLen = currentToken.getValue().length();
        buffer = buffer.substring(tokenLen);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }


}