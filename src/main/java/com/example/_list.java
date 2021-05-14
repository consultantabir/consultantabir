package simpleJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
/***
 * 
 * @author AB
 * Program to find present and absent elements by comparing test list in master list
 */
public class _list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Integer test[]= {13,1,2,12,6,7,8,0};
Integer master[]= {1,2,3,4,5,6,7,8,9,0,18};

System.out.println("Imperative----------------");
boolean present=false;
List<Integer> presentE=new LinkedList<>();
List<Integer> absentE=new LinkedList<>();
for(int t=0;t<test.length;t++) {
	present=false;
	for(int m=0;m<master.length;m++) {
		if(test[t] == master[m]) {
			present=true;
			presentE.add(test[t]);
			break;
		}
	}
	if(!present) {
		absentE.add(test[t]);
	}
}
if(!presentE.isEmpty()) {
	System.out.print("Present:");
	Collections.sort(presentE);
	for(Integer i:presentE)
		System.out.print(String.format(" %d", i));
}
if(!absentE.isEmpty()) {
	System.out.print("\nAbsent:");
	Collections.sort(absentE);
	for(Integer i:absentE)
		System.out.print(String.format(" %d", i));
}
System.out.println("\nFunctional----------------");

List<Integer> testL=Arrays.asList(test);
List<Integer> masterL=new ArrayList();
Collections.addAll(masterL, master);
List<Integer> presentL=testL.stream()
.filter(testI -> masterL.stream()
		.anyMatch(masterI -> masterI.equals(testI)))
.sorted(Comparator.naturalOrder())
.collect(Collectors.toList());

List<Integer> absentL=new ArrayList(testL);
absentL.removeAll(masterL);
Collections.sort(absentL);

if(!presentL.isEmpty()) {
	System.out.print("Present:");
	for(Integer i:presentL)
		System.out.print(String.format(" %d", i));
}
if(!absentL.isEmpty()) {
	System.out.print("\nAbsent:");
	for(Integer i:absentL)
		System.out.print(String.format(" %d", i));
}
}	
}
