import java.util.HashMap;

// Class to represent a pair
class abcd {

    class pair {
        int first, second;

        pair(int f, int s) {
            first = f;
            second = s;
        }
    }

    ;

    boolean findPairs(int arr[]) {
        // Create an empty Hash to store mapping from sum to
        // pair indexes
        HashMap<Integer, pair> map = new HashMap<Integer, pair>();
        int n = arr.length;

        // Traverse through all possible pairs of arr[] 
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                // If sum of current pair is not in hash,
                // then store it and continue to next pair
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum))
                    map.put(sum, new pair(i, j));

                else // Else (Sum already present in hash)
                {
                    // Find previous pair
                    pair p = map.get(sum);

                    // Since array elements are distinct, we don't
                    // need to check if any element is common among pairs
                    System.out.println("(" + arr[p.first] + ", " + arr[p.second] +
                            ") and (" + arr[i] + ", " + arr[j] + ")");
                    return true;
                }
            }
        }
        return false;
    }
}