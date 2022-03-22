// merge sort
public class Solution {
	public void sortIntegers(int[] A) {
		if (A == null || A.length == 0) {
 			return;
		}
		int[] temp = new int[A.length];
		mergeSort(A, 0, A.length - 1, temp);
	}

	private void mergeSort(int[] A, int start, int end, int[] temp) {
		if (start >= end) {
			return;
		}
		// 处理左半区间
		mergeSort(A, start, (start + end) / 2, temp);
		// 处理右半区间
		 mergeSort(A, (start + end) / 2 + 1, end, temp);
		// 合并排序数组
		merge(A, start, end, temp);
	}

	private void merge(int[] A, int start, int end, int[] temp) {
		int middle = (start + end) / 2;
		int leftIndex = start;
		int rightIndex = middle + 1;
		int index = start;
		
		while (leftIndex <= middle && rightIndex <= end) {
			if (A[leftIndex] < A[rightIndex]) {
				temp[index++] = A[leftIndex++];
			} else {
				temp[index++] = A[rightIndex++];
			}
		}

		while (leftIndex <= middle) {
			temp[index++] = A[leftIndex++];
		}

		while (rightIndex <= end) {
			temp[index++] = A[rightIndex++];
		}

		for (int i = start; i <= end; i++) {
			A[i] = temp[i];
		}
	}
}