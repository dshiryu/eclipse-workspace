public class Quadrat {
	private double pointX;
	private double pointY;
	private double side;

    public Quadrat(double x1, double y1, double l) { 
    	this.pointX = x1;
    	this.pointY = y1;
    	this.side = l;
    }
    
    public void zeichne( ) {
    	//StdDraw.line(x1,y1,x2,y1);
    	StdDraw.line(this.pointX,this.pointY,this.side,this.pointY);
    	StdDraw.line(this.pointX,this.pointY,this.pointX,this.side);
    	StdDraw.line(this.pointX,this.side,this.side,this.side);
    	StdDraw.line(this.side,this.side,this.side,this.pointY);
    }
}
