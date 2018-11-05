public class SelectionSort {
    public static void main(String args[]){
        int[] a={1,3,5,7,9,2,4,6,8,10};

        for(int j=0;j<a.length;j++){
            int min= Integer.MAX_VALUE,key=0;
            for(int i=j;i<a.length;i++){

                if(a[i]<min){
                    min=a[i];
                    key=i;
                }
            }
            int temp=a[key];
            a[key]=a[j];
            a[j]=temp;
        }
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
