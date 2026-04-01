public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(nums2[i], i);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int current = nums1[i];
            int indexInNums2 = map.get(current);
            int nextGreater = -1; 
            for (int j = indexInNums2 + 1; j < m ;j++) {
                if (nums2[j] > current) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            result[i] = nextGreater;
        }
        return result;
    }
}
// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//         int m = nums2.length;
//         int[] result = new int[n];
//         for (int i = 0; i < n; i++) {
//             int current = nums1[i];
//             boolean found = false;
//             for (int j = 0; j < m; j++) {
//                 if (nums2[j] == current) {
//                     for (int k = j + 1; k < m; k++) {
//                         if (nums2[k] > current) {
//                             result[i] = nums2[k]; 
//                             found = true;
//                             break;
//                         }
//                     }
//                     if (!found) {
//                         result[i] = -1;
//                     }
//                     break;
//                 }
//             }
//         }
        
//         return result;
//     }
// }