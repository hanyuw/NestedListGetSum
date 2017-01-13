package Snapchat;

import java.util.ArrayList;
import java.util.List;



public class Solution {
	public static void main(String[] args) {
		String s1 = "[1, [2, [3]]]";
		String s2 = "[]";
		String s3 = "[1, [2, 3]]";
		String s4 = "[0, [2, [3]], 1]";
		String s5 = null;
		String s6 = "[1, [2, Integer.MAX_VALUE]]";

		NestedInteger nestedInt3 = new Solution().new NestedInteger(3);
		NestedInteger nestedInt2 = new Solution().new NestedInteger(2);
		NestedInteger nestedInt1 = new Solution().new NestedInteger(1);

		List<NestedInteger> list3 = new ArrayList<NestedInteger>();
		list3.add(nestedInt3);
		NestedInteger ele3 = new Solution().new NestedInteger(list3);

		List<NestedInteger> list2 = new ArrayList<NestedInteger>();
		list2.add(nestedInt2);
		list2.add(ele3);
		NestedInteger ele2 = new Solution().new NestedInteger(list2);

		List<NestedInteger> list1 = new ArrayList<NestedInteger>();
		list1.add(nestedInt1);
		list1.add(ele2);
		NestedInteger ele1 = new Solution().new NestedInteger(list1);

		System.out.println(getSum(ele1.getList(), 1));
	}




	// public long sum(String str) {
	//     /// Edge case
	//     if (str == null) {
	//         return 0;
	//     }
	// 
	//     /// Translate string into nested integer
	//     //<NestedInteger> list = getList(str);
	// 
	//     /// Divide and conquer
	//     return getSum(list, 1);
	// }

	private static long getSum(List<NestedInteger> list, int level) {
		/// Base case
		if (list == null) {
			return 0;
		}

		int result = 0;

		for (NestedInteger ele : list) {
			if (ele.isInteger()) {
				result += (long) ele.getValue() * level;
			} else {
				result += getSum(ele.getList(), level + 1);
			}
		}

		return result;
	}




	public class NestedInteger {
		/// Field
		private int val;
		private List<NestedInteger> list;

		/// Constructor
		public NestedInteger(int val) {
			this.val = val;
			this.list = null;
		}

		public NestedInteger(List<NestedInteger> list) {
			this.list = list;
		}


		public boolean isInteger() {
			return list == null;
		}

		public int getValue() {
			return this.val;
		}

		public List<NestedInteger> getList() {
			if (this.list != null) {
				return this.list;
			}
			return null;
		}
	}
}
