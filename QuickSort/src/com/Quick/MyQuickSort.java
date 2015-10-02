package com.Quick;

public class MyQuickSort {
	
	
	

		public static void main(String[] args) {
			
			//create array 122345
			
			int[] arr = {400,30,50,22,39,21,3,1,99,62,8,4,52,403,4};// make my array for parttioning
			int nElems = arr.length;
			
			//System.out.println( partiton(-1, nElems, 22, arr));
			quickSort(arr);
			for (int i : arr) {
				System.out.print(i+",");
			}
			
		}
		
		public static void quickSort(int[] array) {
			recursiveQuickSort(0, array.length-1, array);
		}//end qs
		
		
		public static void recursiveQuickSort(int left, int right, int[] array) {
			
			int size = right - left + 1;
			
			if(size <= 3) {
				manualSort(left, right, array);
				
			}else {
				int pivot = medianOfThree(array, left, right);
				int partition = partiton(left,right,pivot,array);
				recursiveQuickSort(left, partition-1, array);
				recursiveQuickSort( partition+1,right, array);
				
				
			}
				
			
		}//end recursive
		
		public static void manualSort(int left, int right,int[] array) {
			
			int size = right-left+1;
			//System.out.println(size+"left: "+left+";right: "+right);
			if (size <= 1) {
				return;//already sorted
			}
			
			if(size == 2) {
				if( array[left] > array[right]) {
					sWap(left, right, array);
					return;}
				}else {
					if(array[left] > array[right-1]) {
						sWap(left, right-1, array);
					}
					if(array[left] > array[right]) {
						sWap(left, right, array);
					}
					if(array[right-1] > array[right]) {
						sWap(right-1, right, array);
					}
					
				}
				
				
			}
		
		
		
		
		
		
		/*
		 * method will take a pivot int value and an array and partition the array on the said pivot
		 * @param int pivot
		 * @param int [] array
		 */
		
		
		public static int partiton(int left, int right, int pivot, int[] theArray) {
			
			int leftPtr = left; // right of first elem
			int rightPtr = right - 1; // left of pivot
			while(true)
			{
			while( theArray[++leftPtr] < pivot ) // find bigger
			; // (nop)
			while( theArray[--rightPtr] > pivot ) // find smaller
				; // (nop)
			if(leftPtr >= rightPtr) // if pointers cross,
			break; // partition done
			else // not crossed, so
			sWap(leftPtr, rightPtr,theArray); // swap elements
			} // end while(true)
			sWap(leftPtr, right-1,theArray); // restore pivot
			return leftPtr; // return pivot location
			
			
			
			
		}
		
		/*
		 * the sWap mthd will swap values of the 2 indexes given.
		 */
			
			public static void sWap(int l, int r , int[] ar) {
				int temp = ar[l];
				
				ar[l] = ar[r];
				ar[r] = temp;
			}
			
			/*
			 * median of 3 finds the best pivot between [o] [centre] and [array.length]
			 * median of 3 then sorts the 3 possible pivots  
			 * 
			 */
			
			public static int medianOfThree(int[] theArray,int left, int right)  {
				
				
				int center = (left+right)/2;
				// order left & center
				if( theArray[left] > theArray[center] )
				sWap(left, center,theArray);
				// order left & right
				if( theArray[left] > theArray[right] )
				sWap(left, right,theArray);
				// order center & right
				if( theArray[center] > theArray[right] )
				sWap(center, right,theArray);
				sWap(center, right-1,theArray); // put pivot on right
				return theArray[right-1]; // return median value
				
			}
			
			
			
			
			
		}//end main
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		





