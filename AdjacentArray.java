import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdjacentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArry=new int[]{1,7,4,3,3,5};
		System.out.println();

	}
	
	public static int solution(int[] intArry){
		int absVal=0;
		int maxAbsVal=0;
		if(intArry.length<=0 || intArry.length>40000){
			maxAbsVal=-1;
		}
		List<Integer> list=Arrays.stream(intArry).boxed().collect(Collectors.toList());
		List<Integer>sortList=new ArrayList<Integer>();
		sortList.addAll(list);
		Collections.sort(sortList);
		
		for(int i=0; i<list.size();i++){
			for(int j=i+1; j< list.size();j++){
				if(areAdjacent(list,sortList,i,j)){
					absVal=Math.abs(i-j);
					if(absVal>maxAbsVal)
						maxAbsVal=absVal;
				}
			}
		}
		return maxAbsVal;
	}
public static boolean areAdjacent(List<Integer>list, List<Integer> sortList,int index1, int index2) {
	int val1,val2;
	int minVal,maxVal;
	val1=list.get(index1);
	val2=list.get(index2);
	
	if(val1==val2){
		return false;
	}
	index1=sortList.indexOf(val1);
	index2=sortList.indexOf(val2);
	
	minVal=Math.min(index1, index2);
	maxVal=Math.max(index1, index2);
	
	int absVal=Math.abs(index1-index2);
	int maxAbsVal=0;
	if(absVal>maxAbsVal){
		maxAbsVal=absVal;
		
	}
	
	for (int i=minVal+1;i<maxVal;i++){
		if((sortList.get(i)!=val1) && (sortList.get(i)!=val2)){
			return false;
		}
	}
	return true;
	
	
}
}
