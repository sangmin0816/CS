public class Quick<E> extends PrintE<E> {
   E[] array;

   public E[] quickSort(E[] array) {
		this.array = array;
		quick_sort(0, array.length - 1);
		return array;
	}

	private void SWAP(int from, int to){
		E temp = array[from];
		array[from] = array[to];
		array[to] = temp;
	}

	private int pivot(int left, int right){
		int low = left+1, high = right;
		E p = array[left];
		System.out.println("PIVOT: "+p);

		while(low<=high){
			while( low<=right && ((Comparable<E>) array[low]).compareTo(p) <= 0){
				low++;
			} // 왼쪽에서 피봇보다 큰 값

			while( high>=(left+1) && ((Comparable<E>) array[high]).compareTo(p) >= 0 ) {
				high--;
			} // 오른쪽에서 피봇보다 작은 값
			
			if (low<high){ // 왼쪽과 오른쪽이 교차되지 않았다면 위치 바꿈
				SWAP(low, high);
				System.out.print("SWAP: ");
				printArray(array);
			}
		}
		System.out.print("SWAP: ");
		SWAP(left, high);
		printArray(array);
		array[high] = p;
		return high; // 피봇의 위치 반환
	}

	private void quick_sort(int left, int right) {
		if (left < right) {
			printArray(array);
			int p = pivot(left, right);
			quick_sort(left, p-1);
			quick_sort(p+1, right);
		}
	}
}
