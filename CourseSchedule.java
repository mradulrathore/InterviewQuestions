import java.util.*;

public class CourseSchedule{
    static ArrayList<Integer> buildOrder = new ArrayList<Integer>();

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of courses :");
        int numberOfCourses = sc.nextInt();
        int[] courses = new int[numberOfCourses];
        for(int i=0;i<numberOfCourses;i++){
            courses[i] = i;
        }

        System.out.println("Enter number of dependencies :");
        int numberOfDependencies = sc.nextInt();
        int[][] dependency = new int[numberOfDependencies][2];
        System.out.println("Enter dependencies : format : course1 space course2 numbers , meaning course2 depends on course1");
        for(int i=0;i<numberOfDependencies;i++){
            dependency[i][0] = sc.nextInt();
            dependency[i][1] = sc.nextInt();
        }



        boolean isCourseCompletionPossible = isBuildCompletionPossible(courses,dependency);
        if(isCourseCompletionPossible){
            System.out.println("Order in which the courses has to be taken :"+buildOrder);
        }
        else{
            System.out.println("With the given dependency the build cant complete .");
        }
    }

    private static void displayDependency(HashMap<Integer,ArrayList<Integer>> map){
        System.out.println("Dependencies : ");
        for(Map.Entry<Integer,ArrayList<Integer>> mapEntry : map.entrySet()){
            System.out.println(mapEntry.getKey() + " is dependent on "+mapEntry.getValue());
        }
    }

    private static boolean isBuildCompletionPossible(int[] courses ,int[][] dependencies){

        HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();

        for(int c : courses){
            map.put(c,new ArrayList());
        }

        int row = dependencies.length;
        for(int i=0;i<row;i++){

            int dependingOn  = dependencies[i][1];
            int dependent = dependencies[i][0];

            ArrayList<Integer> dependingOnList = map.getOrDefault(dependent,new ArrayList<Integer>());
            dependingOnList.add(dependingOn);
            map.put(dependent,dependingOnList);

        }
        displayDependency(map);
        Queue<Integer> nonDependentProjectQueue = getNonDependentProject(map);
        if(nonDependentProjectQueue.size() == 0){
            return false;
        } 

        int completedProjects = 0;


        while(!nonDependentProjectQueue.isEmpty()){

            completedProjects++;
            Integer pop = nonDependentProjectQueue.remove();
            for(Map.Entry<Integer,ArrayList<Integer>> mapEntry : map.entrySet()){
                ArrayList<Integer> dependingOnList =  mapEntry.getValue();
                if(dependingOnList.contains(pop)){
                    dependingOnList.remove(pop);
                    map.put(mapEntry.getKey(),dependingOnList);
                    if(dependingOnList.size() == 0){
                        nonDependentProjectQueue.add(mapEntry.getKey());
                        buildOrder.add(mapEntry.getKey());
                    }

                }
        }

        }

        return completedProjects == courses.length;

    }

    private static Queue<Integer> getNonDependentProject(HashMap<Integer,ArrayList<Integer>> map){
        Queue<Integer> nonDependentProjectQueue = new LinkedList<Integer>();
        for(Map.Entry<Integer,ArrayList<Integer>> mapEntry : map.entrySet()){
                if(mapEntry.getValue().size() == 0){
                    nonDependentProjectQueue.add(mapEntry.getKey());
                    buildOrder.add(mapEntry.getKey());
                }
        }
        return nonDependentProjectQueue;

    }

}