public class RedBlackTree<K,V> {
	Node<K,V> root;
	int size;
	class Node<K,V> {
		K key;
		V value;
		Node<K,V> left, right, parent;
		boolean isLeftChild, isBlack;
		public Node (K key, V value) {
			this.key = key;
			this.value = value;
			left = right = parent = null;
			isBlack = false;
			isLeftChild = false;
		}
	}

   

   public void add(K key, V value){
      Node<K,V> node = new Node<K,V>(key, value);
      // 트리가 비어있을 경우
      if (root == null) {
         root = node;
         root.black = true;
         size++;
         return;
      }
      
      add(root, node);
      size++;
   }

   // add 재귀함수, 내부클래스
   private void add (Node<K,V> parent, Node<K,V> newNode){
      // newNode의 data가 parent의 data보다 크면 트리의 오른쪽에 추가
      if (((Comparable<K>) newNode.key).compareTo(parent.key) > 0){
         if(parent.right == null){
            parent.right = newNode;
            newNode.parent = parent;
            newNode.isLeftChild=false;
            return;
         }
         return add(parent.right, newNode);
      }

      // newNode의 data가 parent의 data보다 작거나 같으면 트리의 왼쪽에 추가   
      if (parent.left == null){
         parent.left = newNode;
         newNode.parent = parent;
         newNode.isLeftChild=true;
         return;
      }
      return add(parent.left, newNode);
      // 레드 블랙 트리가 규칙에 맞게 잘 되어있는지 확인합니다.
      checkColor(newNode);
   }

   public void checkColor(Node<K,V> node){
      //  루트는 항상 검은색이므로 색을 확인할 필요가 없습니다.
      if (node == root)
         return;
      // 빨간 노드 2개가 연속으로 나오는 경우 (레드 블랙 트리 규칙 위반)
      if (!node.black && !node.parent.black)
         correctTree(node);
      // 부모 노드를 계속 확인합니다.
      checkColor(node.parent);
   }

   public void correctTree(Node<K,V> node){
      // node의 부모 노드가 왼쪽 자식이면 이모 노드는 조부모 노드의 오른쪽 자식입니다.
      if (node.parent.isLeftChild) {
         // 이모 노드가 검은색 (이모 노드가 비어있는 경우 포함)
         if(node.parent.parent.right == null || node.parent.parent.right.black)
            // 회전
            return rotate(node);
         //  이모 노드가 빨간색
         if (node.parent.parent.right != null)
            // 색상 변환
            node.parent.parent.right.black = true;
         node.parent.parent.black = false;
         node.parent.black = true;
         return;
      }
      // node의 부모 노드가 오른쪽 자식이면 이모 노드는 조부모 노드의 왼쪽 자식입니다.
      // 위 코드와 동일하게 하되, 이모 노드를 node.parent.parent.left로 바꿉니다.
      else {
         // 이모 노드가 검은색 (이모 노드가 비어있는 경우 포함)
         if(node.parent.parent.left == null || node.parent.parent.left.black)
            // 회전
            return rotate(node);
         //  이모 노드가 빨간색
         if (node.parent.parent.left != null)
            // 색상 변환
            node.parent.parent.left.black = true;
         node.parent.parent.black = false;
         node.parent.black = true;
         return;
      }
   }

   public void rotate(Node<K,V> node){
      // 현재 노드가 왼쪽 자식
      if (node.isLeftChild) {
         // 부모 노드가 왼쪽 자식
         if (node.parent.isLeftChild) {
            // 조부모 노드를 우측회전
            rightRotate(node.parent.parent);
            node.black = false;
            node.parent.black = true;
            if(node.parent.right != null)
               node.parent.right.black = false;
            return;
         }
         // 부모 노드가 오른쪽 자식
         // 조부모 노드를 우측-좌측 회전
         rightleftRotate(node.parent.parent);
         node.black = true;
         node.right.black = false;
         node.left.black = false;
         return;
      }
         
      // 현재 노드가 오른쪽 자식일 경우에도 부모 노드의 위치에 따라 좌측 회전, 좌측-우측 회전을 합니다.
      else {
         if (!node.parent.isLeftChild) {
            // 부모 오른쪽, 자식 오른쪽 좌측 회전
            leftRotate(node.parent.parent);
            node.black = false;
            node.parent.black = true;
            if(node.parent.left != null)
               node.parent.left.black = false;
            return;
         }
            // 부모 노드가 왼쪽, 자식 오른쪽 좌측 우측 회전
         leftrightRotate(node.parent.parent);
         node.black = true;
         node.right.black = false;
         node.left.black = false;
         return;
      }  
   }

   // 좌측 회전: 조부모 노드를 부모 노드의 왼쪽 자식 노드 위치로 옮깁니다.
   public void leftRotate (Node<K,V> node){
      Node<K,V> temp = node.right;
      node.right = temp.left;
      // 부모 노드 node.right가 temp가 되면서 조부모 노드가 없어집니다.
      if(node.right != null) {
         node.right.parent = node;
         node.right.isLeftChild = false;
      }
      // node가 루트인 경우
      if(node.parent == null) {
         root = temp;
         temp.parent = null;
      }
      // node가 루트가 아닌 경우
      else {
         temp.parent = node.parent;
         if(node.isLeftChild) {
            temp.isLeftChild = true;
            temp.parent.left = temp;
         } else {			
            temp.isLeftChild = false;
            temp.parent.right = temp;
         }
         temp.left = node;
         node.isLeftChild = true;
         node.parent = temp;
      }
   }

   public void rihgtRotate (Node<K,V> node){
      Node<K,V> temp = node.left;
      node.left = temp.right;
      if(node.left != null) {
         node.left.parent = node;
         node.left.isLeftChild = true;
      }
      // node가 루트인 경우
      if(node.parent == null) {
         root = temp;
         temp.parent = null;
      }
      // node가 루트가 아닌 경우
      else {
         temp.parent = node.parent;
         if(node.isLeftChild) {
            temp.isLeftChild = true;
            temp.parent.left = temp;
         } else {			
            temp.isLeftChild = false;
            temp.parent.right = temp;
         }
         temp.right = node;
         node.isLeftChild = false;
         node.parent = temp;
      }
   }

   public int height() {
      if(root == null)
         return 0;
      return height(root) - 1; // 간선은 노드 개수 -1
   }

   // 트리의 어느 지점에서나 높이는 왼쪽과 오른쪽 중 가장 긴 경로의 길이입니다.
   public int height(Node<K,V> node) {
      if (node == null)
         return 0;
      int leftheight = height(node.left) + 1
      int rightheight = height(node.right) + 1
      if (leftheight > rightheight)
         return leftheight;
      return rightheight;
   }

   public int blackNodes(Node<K,V> node) {
      if (node == null)
         return 1;
      int rightBlackNodes = blackNodes(node.right)
      int leftBlackNodes = blackNodes(node.left)
      // 오른쪽과 왼쪽의 검은색 노드 개수가 다르면 에러를 내거나 고쳐줍니다.
      if (rightBlackNodes != leftBlackNodes)
         // throw an error
         // or fix the tree
      // 검은색 노드이면 해당 노드의 수를 늘려줍니다.
      if (node.black)
         leftBlackNodes++;
      return leftBlackNodes;
   }   
}