public class RangeSum{
	 int[] array;
	 int[] bit;

	 RangeSum(int[] array){
		  this.array=array;
		  int l=array.length+1;
		  bit=new int[l];
		  for(int i=0;i<l-1;i++){
			   update(i,array[i]);
		  }
	 }

	 public int sumRange(int start,int end){
		  return sumRange(end+1)-sumRange(start);
	 }

	 public void update(int index,int value){
		  updateBit(index+1,array[index]);
		  array[index]=value;
	 }

	 private void updateBit(int index,int value){
		  int i=index;
		  while(i<bit.length){
			   bit[i]+=value;
			   i=  i | (i + 1);
		  }
	 }
	 private int sumRange(int index){
		  int sum=0;
		  int i=index;
		  while(i>=0){
			   sum+=bit[i];
			   i=(i & (i + 1)) - 1;
		  }
		  return sum;
	 }
}

