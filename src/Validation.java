
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class Validation implements IHandler{

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[a-z]+(\\.[a-z]+)*(\\.[a-z]{1,})$";
    private static final String _PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*$";
    
    
 
 
    public boolean validateEmail(String hex) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
    
    public boolean validateName(String s)
    {
        boolean b=true;
        pattern = Pattern.compile(_PATTERN);
        matcher = pattern.matcher(s);
        b= (s.length()>3 && s.length()<12)&&(matcher.matches()) ? true : false;
        return b;
    }
    
    public boolean validatePass(String s1,String s2)
    {
        boolean b=true;
        pattern = Pattern.compile(_PATTERN);
        matcher = pattern.matcher(s1);
        b =  ((s1.length()>5) && (s1.length()<16))&&(matcher.matches())&&(s1.equals(s2)) ? true : false;
        return b;
    }
    

    @Override
    public void Handle(IObject object) {
        boolean c = validateEmail((String)object.getValue("email")) && validateName((String)object.getValue("username")) && 
                validatePass((String)object.getValue("pass"),(String)object.getValue("passagain"));
        
        if(!c)
            {
            try { 
                throw new Exception();
            } catch (Exception ex) {
                Logger.getLogger(Validation.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
 
}
    

