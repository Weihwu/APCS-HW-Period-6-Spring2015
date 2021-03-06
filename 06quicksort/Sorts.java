import java.util.*;

public class Sorts{

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

    public static void quicksort(int[] ary){
	quickhelp(ary, 0, ary.length);
    }

    public static void quickhelp(int[]ary, int si, int ei){
	int index;
	if (ei-si > 1){
	    index = partition(ary, si, ei);
	    quickhelp(ary, si, index);
	    quickhelp(ary, index+1, ei);
	}
    }
	    
    public static void main(String[]args){
	
	int[] a = new int[500];
	
	Random r = new Random();

	for (int x = 0; x < a.length; x++){
	    a[x] = r.nextInt(2000001) - 1000000;
	}

	System.out.println(toString(a));
	quicksort(a);
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
