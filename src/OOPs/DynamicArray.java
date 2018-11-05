package OOPs;

public class DynamicArray {
    private int[] array;
    private int index;
    public DynamicArray(int size) {
        index=-1;
        this.array = new int[size];
    }

    public DynamicArray() {
        index=-1;
        this.array =new int[5];
    }
    public void add(int n){
        index++;
        if(index==array.length){
            int[] temp = array;
            array =new int[array.length +5];
            for(int i=0;i<temp.length;i++){
                array[i]=temp[i];
            }
            array[index]=n;
        }
        else{
            array[index]=n;
        }
    }
    public int get(int idx){
        if(idx>index) throw new ArrayIndexOutOfBoundsException();
        else return array[idx];
    }
    public int size(){
        return index+1;
    }



}
