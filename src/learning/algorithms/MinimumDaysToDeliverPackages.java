package learning.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * There is N delivery centers. Each Devliery Outlet has some packages to be delivered, denoted by parcels[i]. There is a Rule how delivery should be completed. On each day, an equal number of parcerls are to be dispatched from each delivery center that has atleast one parcel remaining.

Find minimum nunmber of days needed to deliver all the parcels.
Input:
parcels= {2,3,4,3,3}
o/p: 3

explanation:

{2,3,4,3,3}
reduce the parcels each day with the smallest number of parcels on each delivery center.
day 1 - {0,1,2,1,1}
day 2 - {0,0,1,0,0}
day 3 - {0,0,0,0,0}

 */

public class MinimumDaysToDeliverPackages {
    
    private static int minDays(List<Integer> parcels) {
        int minDays = 0;
        return minDays = calcMinDays(parcels.stream().mapToInt(Integer::intValue).toArray(), minDays);
    }

    private static int calcMinDays(int[] parcelArr, int minDays) {
        int minParcel = Integer.MAX_VALUE;
        for (int i : parcelArr) {
            int m = Math.min(minParcel, i);
            if (m != 0) {
                minParcel = m;
            }
        }

        if (minParcel != Integer.MAX_VALUE) {
            for (int i = 0; i < parcelArr.length; i++) {
                if (parcelArr[i] != 0) {
                    parcelArr[i] = parcelArr[i] - minParcel;
                }
            }
            minDays = minDays + 1;
        } else {
            return minDays;
        }
        return calcMinDays(parcelArr, minDays);
    } 

    public static void main(String[] args) {
        List<Integer> parcels = new ArrayList<>();
        parcels.add(2);
        parcels.add(3);
        parcels.add(4);
        parcels.add(3);
        parcels.add(3);

        //int[] arr = {1, 1, 1, 1, 1};
        int[] arr = {8, 5, 9, 3, 4};
        //System.out.println(minDays(parcels));
        System.out.println("Min Days: " + minDays(Arrays.stream(arr).boxed().toList()));
    }
}
