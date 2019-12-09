package LIST;

public class SinglyList<T> {
     public Node<T> head;

     public SinglyList(){
         this.head = new Node<T>();
     }
     
     public SinglyList(T[] values){
         this();
         Node<T> rear = this.head;
         for(int j = 0;j<values.length;j++){
             rear.next = new Node<T>(values[j],null);
             rear = rear.next;
         }
     }
     
     public String toString() {
         String str = this.getClass().getName() + "(";
         Node<T> p = this.head.next;
         while(p!=null){
             str += p.data;
             if(p.next!=null){str += ",";}
             p = p.next;
         }
         return str+")";
     }
     
     public boolean isEmpty(){
         return this.head.next == null;
     }
     
     public T get(int i){
         Node<T> p = this.head.next;
         for(int j=0;p!=null&&j<i;j++){
             p = p.next;
         }
         return ( i>=0 && p!=null)?p.data:null;
     }
     
     public void set(int i,T x){
         Node<T> p = this.head.next;
         for(int j=0;j<i;j++){
             p = p.next;
         }
         p.data = x;
     }

     public Node<T> insert(int i,T x){
         if(x == null){
             throw new NullPointerException();
         }
         Node<T> p = this.head;
         for(int j = 0;p.next!=null&&j<i;j++){
             p = p.next;
         }
         p.next = new Node<T>(x,p.next);
         return p.next;
     }
     
     public Node<T> insert(T x){
         if(x == null){
             throw new NullPointerException();
         }
         Node<T> p = this.head;

         while(p.next != null){
             p = p.next;
         }

         p.next = new Node<T>(x,null);

         return p.next;
     }
     
	public T insertDifferent(T x) {
		Node<T> front=this.head;
		for(int j=0;front.next!=null;j++) {
			if(front.next.data==x)
				return null;
			front=front.next;
			}
		front.next=new Node<T>(x,front.next);
		return x;
	}

    public Node<T> remove(int i) {
         Node<T> p = this.head;
         for (int j = 0;p!=null&&j<i;j++ ){
               p = p.next;
         }
         if(i<=0 && p.next!=null) {
             Node<T> old = p.next;
             p.next = p.next.next;
             return old;
         }
         return null;
    }
    
    public T remove(T data){
    	Node<T> p = this.head;
    	while(p != null){}{
    		if(p.next.data != data){
    			p = p.next;
    		}else{
    			T r = p.next.data;
    			p.next = p.next.next;
    			return p.data;
    		}
    	}
    	return null;
    }

    public Node<T> search(T data){
         Node<T> p = this.head;
        while(p!=null){

            if(p.data != null){
                System.out.println(p.data.toString());
            }

            if(p.data == data){
                return p;
            }
            p=p.next;
        }


         return null;
    }
    
	//  public int search(T x){
	//	 int i = 0;
	//	 Node<T> p = this.head;
	//	 while(p!=null){
	//		 p = p.next;
	//		 i++;
	//		 if(p.data == x){
	//			 return i;
	//		 }
	//	 }
	//	 return 0;
	//}
    
	//public void reverse(){
	//	Node<T> p = this.head;
	//	Object[] middleware =new Object[0x0000ffff];
	//	int index = 0;
	//	
	//	while(p!=null){
	//		middleware[index] = p;
	//		p=p.next;
	//	}
	//	
	//	for(int i = index;i>=0 && index!=0;i--){
	//		middleware[i].next = middleware[i-1];
	//	}
	//	
	//	middleware.length = 0;
	//}
}
