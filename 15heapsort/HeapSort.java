public class HeapSort {
    
    public static int[] sort(int[] ary) {
	
	for (int x = 0; x < ary.length; x++) {
	    int xx = x;
	    while (xx*2 +1 < ary.length) {
		if (ary[xx] < ary[xx*2 + 1]) {
		    int temp = ary[xx];
		    ary[xx] = ary[xx*2 + 1];
		    ary[xx*2 + 1] = temp;
		}
		xx = xx*2+1;
	    }
	}

	int y = ary.length-1;
	for (int x = 0; x < ary.length; x++) {
	    int largest = ary[0];
	    ary[0] = ary[y];
	    ary[y] = largest;

	    int xx = 0;
	    while (xx*2 +1 < y && xx*2+2 < y) {
		int z;
		if (ary[xx*2+1] > ary[xx*2+2]) {
		    z = xx*2+1;
		}else {
		    z = xx*2+2;
		}
		if (ary[xx] < ary[z]) {
		    int temp = ary[xx];
		    ary[xx] = ary[z];
		    ary[z] = temp;
		}
		xx = z;
	    }
	    y--;
	}

	return ary;
    }

    public static String toString(int[] ary){
	String str = "[";
	for(int x = 0; x < ary.length; x++){
	    str += " " + ary[x];
	}
	str += " ]";
	return str;
    }

    public static void main(String[] args) {
	HeapSort a = new HeapSort();

	int[] test = {8,9,3,1,6,4,2,7};
	
	System.out.println(toString(a.sort(test)));

    }
}
	