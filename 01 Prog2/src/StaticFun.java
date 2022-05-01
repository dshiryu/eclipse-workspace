
public class StaticFun {

	public static int count = 0;
    StaticFun(){
        int compare = count;
    	System.out.println(compare);
        count++;
    }
    
static class MoreStaticFun {
	public static int instanceNr = 0;  
	public static MoreStaticFun generateInstance() {
	    if(instanceNr == 0) {
	    	instanceNr++;
	    	return new MoreStaticFun();
	    } else {
	    	return null ;
		}
	}
}

static class Singleton {
    private static Singleton singleInstance = null ;
    
    public static Singleton createInstance() {
        if(singleInstance == null) singleInstance = new Singleton(); 
    	return singleInstance;
    }
}
    
	public static void main(String[] args) {
		//StaticFun x = new StaticFun();
		//x = new StaticFun();
		//System.out.println( (MoreStaticFun.generateInstance() == null) ? "null" : "") ;
		//System.out.println( (MoreStaticFun.generateInstance() == null) ? "null" : "") ;
		System.out.println(Singleton.createInstance());
	}

}
