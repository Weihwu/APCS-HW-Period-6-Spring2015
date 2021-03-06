public class Recursion{
    
    public String name(){
	return "Wu,Wei Hou";
    }
    
    /** Factorial */
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}else if (n <= 1){
	    return 1;
	}else{
	    return fact(n-1) * n;
	}
    }
    
    /** Fibonacci */
    public int fib(int n){
	return fibhelp(0,1,n);
    }
    public int fibhelp(int a, int b, int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}else if (n==0){
	    return a;
	}else{
	    return fibhelp(b, a+b, n-1);
	}
    }

    /** Square Root */
    public double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	int g = 1;
	return sqrthelp(n, g);
    }
    public double sqrthelp(double n, double g){
	double g2 = (n/g + g)/2;
	if (g != g2){
	    return sqrthelp(n, g2);
	}else{
	    return g;
	}
    }

    public static void main(String[]args){
	Recursion a = new Recursion();
	System.out.println(a.name());
	System.out.println(a.fact(10));
	System.out.println(a.fib(20));
	System.out.println(a.sqrt(133));
   }
}
