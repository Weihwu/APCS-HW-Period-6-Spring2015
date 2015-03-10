import java.util.*;

public class QuickSelect{
    
    public static int partition(int[] ary, int si, int ei){
	
	int[] d = new int[ary.length];
	
	System.arraycopy(ary, 0, d, 0, si);
	System.arraycopy(ary, ei, d, ei, ary.length-ei);

	Random r = new Random();

	int index = (int)(Math.random()*(ei-si-1)+si);
	int pivot = ary[index];
	int place = si;

	for (int x = ei-si; x > 0; x--){
	    if(place != index && ary[place] < pivot){
		d[si] = ary[place];
		si++;
	    }else if(place != index && ary[place] >= pivot){
		ei--;
		d[ei] = ary[place];
	    }
	    place++;
	}

	d[si] = pivot;

	System.arraycopy(d, 0, ary, 0, d.length);
	return si;
    }

    public static int quickselect(int[] ary, int n){
	
	int pivot;
	int si = 0;
	int ei = ary.length;
       
	n--;  

	do{
	    pivot = partition(ary, si, ei);
	    if(pivot > n){
		ei = pivot;
	    }else if (pivot < n){
		si = pivot+1;
	    }
	}while (pivot != n);

	return ary[n];
    }
  
	
    public static void main(String[] args){
	
	int[] a = {1, 4, 6, 2, 5, 9, 3, 8, 10, 7};

	System.out.println(toString(a));

	System.out.println(quickselect(a,8));

	System.out.println(toString(a));

	Arrays.sort(a);
	
	System.out.println(toString(a));
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