public class Merge<E> extends PrintE<E>{
   E[] array;
   Object[] temp; // 제네릭은 런타임 전까지 배열 정의 불가, Object로 대체
   
   public E[] mergeSort(E[] list) {
      this.array = list;
      // 빈 배열을 만들어 데이터가 정렬되면 이를 저장
      this.temp = new Object[list.length];
      
      printArray(this.array);
      split(0, this.array.length - 1);
      return this.array;
   }

   // 리스트가 1개 남을 때까지 나눕니다.
   private void split( int low, int high) {      
      if (low < high){
         int mid = (high + low) / 2;
         split (low, mid);
         split (mid + 1, high);
         merge (low, mid, high);
         
      }
   }
   // 대소 비교 후 순서에 맞게 열거합니다.
   private void merge(int low, int mid, int high) {
      int i=low, j=mid+1, k = low;
      int l;
      
      // 나눈 리스트 간의 대소 비교와 정렬
      while (i <= mid && j <= high) {
         if (((Comparable<E>)this.array[i]).compareTo(this.array[j]) <= 0){
            temp[k++] = this.array[i++];
         }
         else{
            temp[k++] = this.array[j++];
         }
      }

      // 나머지 리스트를 채워넣음
      // i가 mid로 가고 j가 high로 갈 때까지 반복
      if(i>mid){
         for(l=j; l<=high; l++){
            temp[k++] =  this.array[l];
         }
      } else {
         for(l=i; l<=mid; l++){
            temp[k++] = this.array[l];
         }
      }
      // 원래 배열에 다시 복사
      for (l = low; l<= high; l++){
         this.array[l] = (E)temp[l];
      }
      printArray(this.array);
   }
}