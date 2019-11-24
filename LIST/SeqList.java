package LIST;

public class SeqList<T extends Comparable> extends Object {
    public Object[] element;
    public int num;
    //这个num指的是实际容量。
    public SeqList(int Length){
        this.element = new Object[Length];
        this.num = 0;
        //这里我们只声明了长度所以说n是0。
    }
    public SeqList(){
        this(64);
    }

    public SeqList(T[] values){
        this(values.length);
        for(int i = 0;i<values.length;i++){
            this.element[i] = values[i];
        }
        this.num = values.length;
    }
    public boolean isEmpty(){
        return this.num == 0;
    }
    public int size(){
        return this.num;
    }

    public T get(int i){
        if(i<0||i>this.num){
            return null;
        }else{
            return (T)this.element[i];
        }
    }
    public void set(int i,T x){
        if(x==null){
            throw new NullPointerException("x == null");
        }
        if(i>=0 && i<this.num){
            this.element[i] = x;
        }else{
            throw new IndexOutOfBoundsException(i+"");
        }
    }
    public String toSting(){
        String str = this.getClass().getName()+"(";
        if(this.num>0){
            for(int i = 0;i<this.num;i++){
                str += this.element[i].toString();
            }
        }
        return str+")";
    }
    
    public int insert(int i,T x){
        if(x==null){
            throw new NullPointerException(x+"==null");
        }
        if(i<0)i=0;
        if(i>this.num)i=this.num;
        Object[] source = this.element;
        if(this.element.length == this.num){
            this.element = new Object[source.length*2];
            for(int j = 0;j<i;j++){
                this.element[j] = source[j];
            }
        }

        for(int j = this.num-1;j >= i;j--){
            this.element[j+1] = source[j];
        }

        this.element[i] = x;
        this.num++;
        return i;
    }
    
    public int insert(T x){
    	return this.insert(this.num,x);
    }
    
    public T del(int i){
        if(i<0 || i>=this.num)return null;

        T oldEle = (T)this.element[i];

        for(int j = i ; j < this.num-1 ; j++){
            this.element[j] = this.element[j+1];
        }

        this.element[this.num-1] = null;
        this.num--;
        return oldEle;
    }
    
    public Object[] insertCombo(int i,T[] arr){
        if(i<0)i=0;
        if(i>this.num)i=this.num;
        Object[] source = this.element;
        if(element.length == this.num){
            this.element = new Object[source.length*2];
            this.num = element.length;
        }
        if(element.length < arr.length+this.num){
            this.element = new Object[(arr.length+this.num)*2];
            this.num = element.length;
        }

        for(int j = 0;j<i;j++){
            this.element[j] = source[j];
        }
        for(int j = 0;j<arr.length;j++){
            this.element[i+j] = arr[j];
        }
        for(int j = i+arr.length;j<source.length+arr.length;j++){
            this.element[j] = source[j-arr.length];
        }

        return this.element;
    }
    
    public void delCombo(int i,int k){//0	45
        if(i<0 || i>=this.num)return;
        
        for(int p = i;p < i+k;p++){
        	this.element[p] = this.element[p+k];
        }
        
    	this.num = this.num-k;
    }
    
    public int binarysearch(T n){
    	int start = 0;
    	int end = this.num - 1;

    	while(start <= end){
    		int middle = (start+end)/2;
    		int whobig =((T)this.element[middle]).compareTo(n);
    		if(whobig > 0){
    			end = middle - 1;
    		}else if(whobig < 0){
    			start = middle + 1;
    		}else{
    			return middle;
    		}
    	}
    	return -1;
    }
}
