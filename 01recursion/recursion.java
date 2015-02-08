public class recursion{
    
    public String name(){
	return "Wu,Wei Hou";
    }

    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}else if (n==1){
	    return 1;
	}else{
	    return fact(n-1) * n;
	}
    }
    
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
}