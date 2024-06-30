public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	    Map<int, int> cards = new HashMap();
		int N = sc.nextInt();
		for(int i=0; i<N; i++){
		    int card = sc.nextInt();
		    if(cards.get(card)==false){
		        cards[card] = 0
		    }
		    cards[card]++;
		}
		
		int M = sc.nextInt();
		for(int i=0; i<M; i++){
		    int card = sc.nextInt();
		    if(cards.get(card)==false){
		        System.print("0 ");
		    } else {
		        System.print(cars[card]+" ");
		    }
		}
		
		sc.close();
	}
}
