package model;

import java.util.ArrayList;

public class test {

	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> ll = new ArrayList();
		int[] xx = new int[5];
		for(int i = 0 ; i<5;i++) {
			ll.add(i * 2);
			xx[i] = i + 2;
		}
//		System.out.println(ll.hashCode());
//		ll = listPlus(ll);
//		inList(ll);
		System.out.println(xx.hashCode());
		arrPlus(xx);
		
		for(int i = 0 ; i < xx.length;i++) {
			System.out.println(xx[i]);
		}
		
		
	}
	public static void inList(ArrayList<Integer> ll) {
		for(Integer x : ll) {
			System.out.println(x);
		}
		
	}
	public static ArrayList<Integer> listPlus(ArrayList<Integer> ll) {
		System.out.println(ll.hashCode());
		for(int i = 0 ; i < ll.size();i++) {
			ll.set(i, ll.get(i) + 10);
		}
		return ll;
	}
	public static void arrPlus(int[] ll) {
		System.out.println(ll.hashCode());
		for(int i = 0 ; i < ll.length;i++) {
			plusInt(ll[i]);
		}
		
	}
	public void plusInt(int x) {
		x += 10;
	}
	
}
