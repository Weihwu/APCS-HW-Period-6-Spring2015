import java.util.*;

public class Sorts{
    
    public static int[] merge(int[] a , int[] b){
	
	if (a.length > 1){
	    a = merge(filler(a, 0, a.length/2), filler(a, a.length/2, a.length));
	}
	if (b.length > 1){
	    b = merge(filler(b, 0, b.length/2), filler(b, b.length/2, b.length));
	}

	int[] c = new int[a.length + b.length];

	int placea = 0;
	int placeb = 0;

	for (int x = 0; x < c.length; x++){
	    if (placea == a.length){
		c[x] = b[placeb++];
	    }else if (placeb == b.length){
		c[x] = a[placea++];
	    }else{
		if (a[placea] < b[placeb]){
		    c[x] = a[placea++];
		}else{
		    c[x] = b[placeb++];
		}
	    }
	}
	return c;
    }

    public static void mergesort(int[] a){
	int[] b = merge(filler(a, 0, a.length/2), filler(a, a.length/2, a.length));
	System.arraycopy(b, 0, a, 0, a.length);
    }

    public static void main(String[]args){
	
	out("Mergesort Test:");
	int[] a = {1,2,3,4,5,6,7,8,9,10};
	int[] b = {10,9,8,7,6,5,4,3,2,1};

	out("");
	
	out("Sorted Start:");
	out(toString(a));
	out("Finish:");
	long startTime = System.nanoTime();
	mergesort(a);
	long endTime = System.nanoTime();
	out((endTime - startTime) + " nanoseconds");
	out(toString(a));

	out("");

	out("Reverse Sorted Start:");
	out(toString(b));
	out("Finish:");
	startTime = System.nanoTime();
	mergesort(b);
	endTime = System.nanoTime();
	out((endTime - startTime) + " nanoseconds");
	out(toString(b));

	Random r = new Random();
	int[] c = new int[50];
	for (int x = 0; x < 50; x++){
	    c[x] = r.nextInt(3) + 1;
	}
	int[] d = new int[50];
	for (int x = 0; x < 50; x++){
	    d[x] = r.nextInt(2000001) + 1000000;
	}

	out("");

	out("Random Small Start:");
	out(toString(c));
	out("Finish:");
	startTime = System.nanoTime();
	mergesort(c);
	endTime = System.nanoTime();
	out((endTime - startTime) + " nanoseconds");
	out(toString(c));

	out("");

	out("Random Big Start:");
	out(toString(d));
	out("Finish:");
	startTime = System.nanoTime();
	mergesort(d);
	endTime = System.nanoTime();
	out((endTime - startTime) + " nanoseconds");
	out(toString(d));
    }
	    	
    public static void out(String phrase){
	System.out.println(phrase);
    }

    public static int[] filler(int[] a, int start, int end){
	return Arrays.copyOfRange(a, start, end);
    }	

    public static String toString(int[] c){
	String str = "[";
	for(int x = 0; x < c.length; x++){
	    str += " " + c[x];
	}
	str += " ]";
	return str;
    }
}