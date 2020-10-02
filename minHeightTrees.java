//To find the mininmun height tree roots call for function minHeightTrees with parameters n and edges in the form of a 2D array
public class Answer
{
	public HashMap<Integer,ArrayList<Integer>> connectionsToList(int n , int[][] connections){
	    HashMap<Integer,ArrayList<Integer>> List = new HashMap<Integer,ArrayList<Integer>>();
	    for(int i=0;i<n;i++){
	        List.put(i,new ArrayList<Integer>());
	    }
	    for(int[] con:connections){
	        List.get(con[0]).add(con[1]);
	        List.get(con[1]).add(con[0]);
	    }
	    return List;
	}

	public List<Integer> minHeightTrees(int n,int[][]connections){
	    if (n==1){
	        return Arrays.asList(0);
	    }
	    HashMap<Integer,ArrayList<Integer>> List = connectionsToList(n,connections);
	    ArrayList<Integer> leafNodes = new ArrayList<Integer>();
	    for(int i=0;i<n;i++){
	        if(List.get(i).size()==1){
	            leafNodes.add(i);
	        }
	    }
	    while(n>2){
	        n-=leafNodes.size();
	        ArrayList<Integer> newLeafNodes = new ArrayList<Integer>();
	        for(int leaf:leafNodes){
	            for(int conLeaf: List.get(leaf)){
	                List.get(conLeaf).remove(Integer.valueOf(leaf));
	                if(List.get(conLeaf).size()==1){
	                    newLeafNodes.add(conLeaf);
	                }
	            }
	            List.remove(leaf);
	        }
	        leafNodes = newLeafNodes;
	    }
	    return leafNodes;
	}
}
