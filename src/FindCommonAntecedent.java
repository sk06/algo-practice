
import java.util.HashMap;
import java.util.Map;


public class FindCommonAntecedent {

	
	    static Map<String, String> familyTree = new HashMap<String, String>();
	    
	    public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        /* Store all relationships in a map
	         Betty - Ann
	         Clare - Ann
	         Donna - Betty
	         Gloria - Clare 
	         ... */
	        
	        /*Read and load input*/
	    	for( String s : args) {
	            System.out.println(s);
	        }
	    	//read the last line of input
	        String[] inputNames = args[(args.length-1)].split(",");  
	        String inputName1 = inputNames[0];
	        String inputName2 = inputNames[1];
	        //load relationship map as described above
	        String[] level = null;
	        for(int i= 1 ; i <  args.length - 1; i++){
	            level = args[i].split(",");
	            for (int j = 1; j < level.length; j++){
	                familyTree.put(level[j], level[0]);
	            }
	        } 
	        
	        //recursively call each person to find a parent. End condition for the recursion will be when recursive calls return the same parent name
	        System.out.println(findClosestAntecedent(inputName1, inputName2));
	        
	    }
	    
	    
	    public static String findClosestAntecedent(String name1, String name2) {
	        //if a name is not a key in the map, it means it is the root of the family tree
	    	System.out.println(name1 + "," + name2);
	    	String closestAntecedent = "";
	    	if (name1.equals(name2)) return name1;
	        if(!familyTree.containsKey(name1)) return name1;
	        if(!familyTree.containsKey(name2)) return name2;
	        
	        if (familyTree.containsKey(name1) && familyTree.containsKey(name2)){
	        	if(familyTree.get(name1).equals(familyTree.get(name2)))  return familyTree.get(name1); 
	            if(familyTree.get(name1).equals(name2))
	                return name2;
	            else if(familyTree.get(name2).equals(name1))
	                return name1;
	            else
	                return findClosestAntecedent(familyTree.get(name1), familyTree.get(name2));   
	        }
	        return closestAntecedent;
	    }
	    
	}


