public class QuickSelect{
    
    public static void partition(int[] ary, int si, int ei){
	
	int[] d = new int[ary.length];
	
	System.arraycopy(ary, 0, d, 0, si);
	System.arraycopy(ary, ei+1, d, ei+1, ary.length-1-ei);

	int pivot = ary[si];
	int place = si+1;

	while(si < ei){
	    if (ary[place] < pivot){
		d[si] = ary[place];
		si++;
	    }else{
		d[ei] = ary[place];
		ei--;
	    }
	    place++;
	}

	d[si] = pivot;

	System.arraycopy(d, 0, ary, 0, d.length);
    }
	
    public static void main(String[] args){
	
	int[] a = {1, 4, 6, 2, 5, 9, 3, 8, 10, 7};

	System.out.println(toString(a));

	partition(a, 0, a.length-1);

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