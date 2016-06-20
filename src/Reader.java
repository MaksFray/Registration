
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Reader {
    
    private static final Pattern PARSER = Pattern.compile("\"username\": \"(.*)\", \"pass\": \"(.*)\", \"email\": \"(.*)\", \"activ\": \"(.*)\", \"role\": \"(.*)\"");
    
    public List check() throws IOException
    {
        List <IObject> ob= new ArrayList<IObject>();
        IObject object=null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("1.txt"));
            String input = reader.readLine();
            reader.close();
            StringTokenizer st = new StringTokenizer(input, "{");
            int num = st.countTokens();
            String record;
            while(num>0) {
            record = st.nextToken();
            Matcher matcher = PARSER.matcher(record);
            if (matcher.find()) {
            String name = matcher.group(1);
            String pass = matcher.group(2);
            String email = matcher.group(3);
            String activ = matcher.group(4);
            String role = matcher.group(5);

            object = new FObject();
            object.setValue("pass", pass);
            object.setValue("email", email);
            object.setValue("username", name);
            object.setValue("activ", activ);
            object.setValue("role", role);
           
            num--;
            
            if (object != null) {
                ob.add(object);
            }
            
            }
        }
          
            } catch (FileNotFoundException ex) {
        }
        return ob;
    }
    
}
