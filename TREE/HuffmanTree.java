package TREE;

public class HuffmanTree {
    private String charset;
    //编译字符集范围，后文中做了限制，我们最多能编译256个字符。
    private TriElement[] hafftree;
    //表示字符叶子结点的只有前n（weight.length）个
    public HuffmanTree(int[] weight ){//这个构造函数我们没有做多态，因为后面的压缩和译码都是根据已经生成好的huffman树结构来实现的。
        //weight是字符权重的集合，可能为0；
        this.charset = "";
        for(int i = 0;i < weight.length; i++){
            this.charset += (char)('A'+i);
            //这里我们之前设置的生成预编译字符集实际映射。
        }

        int n = weight.length;
        //获取要生成的字符集的大小。
        this.hafftree = new TriElement[2*n-1];
        //根据子叶结点和结点总数的关系构建出树的大小。
        for(int i = 0;i < n;i++){
        //前n个结点
            this.hafftree[i] = new TriElement(weight[i]);
        }

        for(int i = n;i < 2*n-1;i++){
            //这颗树实际上来看是左子树和右子树同时构建的。（虽然难以理解）
            int min1 = Integer.MAX_VALUE;
            int min2 = min1;
            int x1 = -1;
            int x2 = -1;

            for(int j = 0;j < i;j++){
                if(this.hafftree[j].parent == -1){
                    //已经缔结过的结点就不需要在缔结操作了。
                    if(this.hafftree[j].data < min1){
                        min2 = min1;
                        x2 = x1;
                        min1 = this.hafftree[j].data;
                        x1 = j;
                    }else if(this.hafftree[j].data < min2){
                        min2 = this.hafftree[j].data;
                        x2 = j;
                    }
                }
            }
            this.hafftree[x1].parent = i;
            this.hafftree[x2].parent = i;
            this.hafftree[i] = new TriElement(min1+min2,-1,x1,x2);
        }
    }

    public String getCode(int i){
        int n = 8;
        char hufcode[] = new char[n];
        //按照ACS编码来说，二的八次幂能储存256个不同字符（等长编码。）
        int child = i;
        if(!this.hafftree[i].isLeaf()){
            return "不在字符集范围";
        }
        //要获取的第i个字符的编码一定是叶子结点，想要获得他的huffman编码就一定需要，从下往上遍历。
        int parent = this.hafftree[child].parent;
        //获取要获取字符的父级结点的id。这个时候我们已经确定了i的位置了，所以i这个变量就没用了。
        for(i= n-1;parent!=-1;i--){
            // i=7，parent有值，i--
            hufcode[i] = (this.hafftree[parent].left == child)? '0' : '1';
            //从huffcode的最后一位开始添加二进制数据，判断child相对于parent的位置，左填0，右填1.
            child = parent;
            //节点上移。
            parent = hafftree[child].parent;
            //结点上移，同时更新判断条件。
        }
        return new String(hufcode,i+1,n-1-i);
        //huffman编码是从上向下的编码，我们反向获取从叶子结点开始索值，然后在反向填入字串，最后前面可能有空余。
    }

    public String toString(){
        String str = "Huffman树节点数组：[";

        for(int i = 0;i < this.hafftree.length;i++){
            str += this.hafftree[i].toString() +',';
        }
        str += "]\n\r"+"Huffman编码：";
        for(int i = 0;i < this.hafftree.length;i++){
            str += this.charset.charAt(i)+';'+ this.getCode(i)+',';
        }
        return str;
    }

    public String encode(String text){
        String compressed = "";
        for(int i =0;i<text.length();i++){
            compressed += this.getCode(text.charAt(i)-'A');
        }
        return compressed;
    }

    public String decode(String compressed){
        //解码的方式不是字符串匹配，而是根据预解码的顺序来从树顶向下索引，
        // 到叶子结点的时候，就记录字符，重置结点到根节点。
        String text = "";
        int node = this.hafftree.length-1;
        //获取根节点
        for(int i = 0;i<compressed.length();i++){
            if(compressed.charAt(i) == '0'){
                node = this.hafftree[node].left;
            }else if(compressed.charAt(i) == '1'){
                node = this.hafftree[node].right;
            }else{
                return "编码字符集错误！";
            }
            if(this.hafftree[node].isLeaf()){
                text += 'A' + node;
                node = this.hafftree.length-1;
            }
        }
        return text;
    }
}
