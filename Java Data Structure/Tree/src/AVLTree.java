public class AVLTree {
   class Node<T>{
      T data;
      Node<T> left;
      Node<T> right;
      Node<T> parent;
      
      public Node(T obj){ // 생성자
         data = obj;
         parent = left = right = null;
      }
   }

   public AVLTree(){
      root = null;
      currentSize = 0;
   }

   public void add(E obj){
      Node<E> node = new Node<E>(obj);
      // 트리가 비어있을 경우
      if (root == null){
         root = node;
         currentSize++;
         return;
      }
      add(root, node);
   }

   private void add(Node<E> parent, Node<E> new Node){
      // newNode의 data가 parent의 data보다 크면 트리의 오른쪽에 추가하면 됩니다.
      if (((Comparable<E>)newNode.data.compareTo(parent.data)>0)) {
         if (parent.right == null){
            parent.right = newNode;
            newNode.parent = parent;
            currentSize++;
         }
         else
            add(parent.right, newNode);
      }
      // newNode의 data가 parent의 data보다 작거나 같으면 트리의 왼쪽에 추가하면 됩니다.
      else{
         if (parent.left == null){
            parent.left = newNode;
            newNode.parent = parent;
            currentSize++;
         }
         else
            add(parent.left, newNode);
      }
      // AVL트리가 규칙에 맞게 잘 되어있는지 확인합니다.
      checkBalance(newNode);
   }

   public void checkBalance(Node<E> node){
      // 높이 차이가 1 초과 혹은 -1 미만 (AVL 트리 규칙 위반)
      if ((height(node.left) - height(node.right)>1) || (height(node.left) - height(node.right)<-1))
         rebalance(node);
      if (node.parent == null) // 루트일 때 재귀 종료
         return;
      checkBalance(node.parent); // 다른 레벨의 균형도 맞는지 확인
   }  


   public void rebalance(Node<E> node){
      if (height(node.left) - height(node.right)>1) {
         if(height(node.left.left) > height(node.left.right))
            node = rightRotate(node); // LL 회전
         else 
            node = leftRightRotate(node); // LR 회전
      }

      else { 
         if(height(node.left.left) > height(node.left.right))
            node = rightLeftRotate(node); // RL 회전
         else
            node = leftRotate(node); // RR 회전
      }
         // 루트로 올 때까지 반복합니다.
      if (node.parent == null)
         root=node;
   }
}
