import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[] {5,4,2,1,7,9,5,3,2,10};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void heapSort(int[] nums) {
        // 生成大根堆
        for(int i=(nums.length-1)/2; i>=0; i--) {
            // i从末节点序号的一半开始是因为叶节点不需要调整，只需要调整父节点
            adjustHeap(nums, i, nums.length);
        }

        for(int i=nums.length-1; i>=0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap(nums, 0, i);
        }
    }

    public static void adjustHeap(int[] nums, int parent, int length) {
        int temp = nums[parent];
        // 求左子节点序号
        int lchild = parent * 2 + 1;

        while(lchild < length) {
            int rchild = lchild + 1;
            // 如果右子节点存在且右子节点大于左子节点
            if(rchild < length && nums[rchild] > nums[lchild])
                lchild = rchild;

            // 如果最大子节点都不比父节点大，那没必要下移父节点，跳出循环
            if(nums[lchild] <= temp)
                break;

            // 较大的子节点上移，来到当前父节点的位置，之前的父节点继续下移
            nums[parent] = nums[lchild];
            parent = lchild;
            lchild = parent * 2 + 1;
        }
        nums[parent] = temp;
    }


}
