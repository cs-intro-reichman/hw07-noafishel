/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		double x1 = 0.0, y1 = 0.0;
        double x2 = 1.0, y2 = 0.0;
        double x3 = 0.5, y3 = Math.sqrt(3) / 2.0;
		sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0){
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x2, y2, x3, y3);
			StdDraw.line(x3, y3, x1, y1);
			
		} else {
			double midX1X2 = (x1 + x2) / 2, midY1Y2 = (y1 + y2) / 2;
			double midX2X3 = (x2 + x3) / 2, midY2Y3 = (y2 + y3) / 2;
			double midX3X1 = (x3 + x1) / 2, midY3Y1 = (y3 + y1) / 2;

			sierpinski(n - 1, x1, midX1X2, midX3X1, y1, midY1Y2, midY3Y1);
			sierpinski(n - 1, midX1X2, x2, midX2X3, midY1Y2, y2, midY2Y3);
			sierpinski(n - 1, midX3X1, midX2X3, x3, midY3Y1, midY2Y3, y3);
		}
	}
}
