package bunchbysoh;
public class Main {
    static class CountsBySoH {
        public int healthy = 0;
        public int replace = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
        CountsBySoH counts = new CountsBySoH();

        for (int capacity : presentCapacities) {
            double soh = (capacity * 100.0) / 120; // Calculate SoH as a percentage

            if (soh > 80) {
                counts.healthy++;
            } else if (soh >= 63) {
                counts.replace++;
            } else {
                counts.failed++;
            }
        }
        return counts;
    }

    static void testBucketingByHealth() {
        System.out.println("Counting batteries by SoH...\n");
        int[] presentCapacities = {115, 118, 80, 95, 91, 72};
        CountsBySoH counts = countBatteriesByHealth(presentCapacities);

        System.out.println("Number of Healthy Batteries: " + counts.healthy);
        System.out.println("Number of Replace Batteries: " + counts.replace);
        System.out.println("Number of Failed Batteries: " + counts.failed);
        //one more test case to verify
        int[] presentCapacities2 = {120, 120, 120, 120};
        CountsBySoH counts2 = countBatteriesByHealth(presentCapacities2);
        System.out.println("Number of Healthy Batteries: " + counts2.healthy);
        System.out.println("Number of Replace Batteries: " + counts2.replace);
        System.out.println("Number of Failed Batteries: " + counts2.failed);
        System.out.println("Done counting :)\n");
    }

    public static void main(String[] args) {
        testBucketingByHealth();
    }
}
