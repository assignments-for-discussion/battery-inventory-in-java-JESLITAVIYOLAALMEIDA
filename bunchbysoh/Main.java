package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for (int presentCapacity : presentCapacities) {
            int ratedCapacity = 120;
            // Calculate SoH for each battery
            double soh = (presentCapacity / (double) ratedCapacity) * 100;
            if (soh > 80) {
                counts.healthy++;
            } 
            else if (soh <= 80 && soh >=63) {
                    counts.exchange++;
            } 
            else {
            counts.failed++;
        }

        }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 72};
    CountsBySoH counts1 = countBatteriesByHealth(presentCapacities);
    assert(counts1.healthy == 2);
    assert(counts1.exchange == 3);
    assert(counts1.failed == 1);
    int[] presentCapacities2 = {120, 120, 120, 120};
    CountsBySoH counts2 = countBatteriesByHealth(presentCapacities2);
    assert (counts2.healthy == 4);
    assert (counts2.exchange == 0);
    assert (counts2.failed == 0);
    int[] presentCapacities3 = {63, 80, 81, 100};
    CountsBySoH counts3 = countBatteriesByHealth(presentCapacities3);
    assert counts3.healthy == 3;
    assert counts3.exchange == 1;
    assert counts3.failed == 0;
    int[] presentCapacities4 = {62, 60, 45, 30};
    CountsBySoH counts4 = countBatteriesByHealth(presentCapacities4);
    assert counts4.healthy == 0;
    assert counts4.exchange == 0;
    assert counts4.failed == 4;
    System.out.println("Done counting :)\n");
    System.out.println("All the test cases are passed :)\n"); 
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
