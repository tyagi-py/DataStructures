public class BubbleSort {
    public static void main(String args[]){
        int[] a={1,3,5,7,9,2,4,6,8,10};
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }

        for(int i=0;i<10;i++){
            System.out.println(a[i]+"");
        }
    }
}
