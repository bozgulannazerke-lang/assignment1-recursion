import java.util.Arrays;
public class Experiment {
    private Sorter sorter=new Sorter();
    private Searcher searcher=new Searcher();
    public long measureSortTime(int arr[], String type){
        int[] copy=Arrays.copyOf(arr, arr.length);
        long startTime=System.nanoTime();
        if(type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        }
        else{
            sorter.advancedSort(copy);
        }
        long endTime=System.nanoTime();
        return endTime-startTime;
    }
    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        searcher.search(arr, target); // Используем наш объект searcher
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    public void runAllExperiments(){
        int[] sizes={10, 100, 1000, 5000};

        System.out.println("Size|Basic Sort(ns)|Advanced Sort(ns)");
        System.out.println("-------------------");

        for (int size : sizes){
            int[] myArr=sorter.generateRandomArray(size);

            long basicTime=measureSortTime(myArr, "basic");
            long advancedTime=measureSortTime(myArr, "advanced");
            sorter.advancedSort(myArr);
            long searchTime = measureSearchTime(myArr, -1);
            System.out.println(size + "|" + basicTime + "|" + advancedTime + "|" + searchTime);
        }
    }
}
