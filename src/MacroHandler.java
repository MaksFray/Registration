
public class MacroHandler implements IHandler {

    private IHandler[] handlers;
    
    public MacroHandler(IHandler[] handlers)
    {
        this.handlers=handlers;
    }
    
    @Override
    public void Handle(IObject object) throws Exception {
       for(IHandler handler : handlers)
       {
           handler.Handle(object);
       }
        
    }
    
}
