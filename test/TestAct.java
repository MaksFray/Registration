
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestAct {
    static private File newfile= new File("1.txt").getAbsoluteFile();
    
    @BeforeClass
    public static void setUpClass() throws IOException  {
        newfile.createNewFile();
        try(FileWriter writer = new FileWriter(newfile))
        {
            String text = "{\"username\": \"freyl\", \"pass\": \"name1234\", \"email\": \"namo@net.piu\", \"activ\": \"active\", \"role\": \"user\"}";
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        newfile.delete();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidateTrue() {
        boolean expected = true;
        IObject obj = new FObject();
        obj.setValue("username", "freya");
        obj.setValue("pass", "name1234"); 
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "namaq@net.piu");
        Validation v = new Validation();
        v.Handle(obj);
        
    }
    
    @Test(expected = NullPointerException.class)
    public void testValidateFalsePass() {
        IObject obj = new FObject();
        obj.setValue("username", "freya");
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "namaq@net.piu");
        Validation v = new Validation();
        v.Handle(obj);
    }
    
    @Test(expected = NullPointerException.class)
    public void testValidateFalseName() {
        IObject obj = new FObject();
        obj.setValue("pass", "name1234");
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "namaq@net.piu");
        Validation v = new Validation();
        v.Handle(obj);
    }
    
    @Test
    public void testBaseTrue() throws Exception {
        IObject obj = new FObject();
        obj.setValue("username", "freak");
        obj.setValue("email", "mew@net.piu");
        FromBase v = new FromBase();
        v.Handle(obj);
    }
    
    @Test
    public void testBaseFasle() throws Exception {
        IObject obj = new FObject();
        FromBase v = new FromBase();
        v.Handle(obj);
    }
    
    @Test(expected = Exception.class)
    public void testBaseFalseExistedEmail() throws Exception {
        IObject obj = new FObject();
        obj.setValue("email","namo@net.piu");
        FromBase v = new FromBase();
        v.Handle(obj);
    }
    
    @Test(expected = Exception.class)
    public void testBaseFalseExistedName() throws Exception {
        IObject obj = new FObject();
        obj.setValue("username", "freyl");
        FromBase v = new FromBase();
        v.Handle(obj);
    }
    

   @Test
    public void testActivationWithLessTimeout() {
    Activation act = new Activation();
    IObject obj = new FObject();
    act.Handle(obj);
    }
    
    @Test (timeout=5000)
    public void testActivationWithAboveTimeout() {
    Activation act = new Activation();
    IObject obj = new FObject();
    act.Handle(obj);
    }
    
    @Test
    public void testCreateUser() {
        IObject obj = new FObject();
        obj.setValue("pass", "name1234");
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "namaq@net.piu");
        CreateUser v = new CreateUser();
        v.Handle(obj);
    }
    
    @Test
    public void testCreateUserWithoutName() {
        IObject obj = new FObject();
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "namaq@net.piu");
        CreateUser v = new CreateUser();
        v.Handle(obj);
    }
    
    @Test
    public void testCreateUserNull() {
        IObject obj = null;
        CreateUser v = new CreateUser();
        v.Handle(obj);
    }
    
    @Test
    public void testChain() throws Exception {
        IObject obj = new FObject();
        obj.setValue("username", "afreya");
        obj.setValue("pass", "name1234"); 
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "aanamo@net.piu");
        IHandler[] handlers = {new Validation(), new FromBase(), new Role(), new CreateUser()};
        IHandler handler = new MacroHandler(handlers);
        handler.Handle(obj);
    }
    
    
    @Test 
    public void testActiveChain() throws Exception {
        IObject obj = new FObject();
        obj.setValue("username", "freya");
        obj.setValue("pass", "name1234"); 
        obj.setValue("passagain", "name1234");
        obj.setValue("email", "namo@net.piu");
        IHandler[] hands = {new Activation(), new CreateUser()};
        IHandler hand = new MacroHandler(hands);
        hand.Handle(obj);
    }

}


