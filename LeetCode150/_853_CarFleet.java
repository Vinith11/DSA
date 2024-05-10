
import java.util.*;

/*
 * Car Fleet is a situation where one car is moving at a certain speed and 
 * another car is moving faster than first car, at some point there will meet
 * this situation is called Car Fleet.
 *                                                      A     B      C
 * Example: there are 2 cars like (position, speed) = [(5,2),(7,1), (1,2)]
 *          assume targrt is 10 
 *          time taken for car A to reach target = (10-5)/2 = 2.5
 *          time taken for car B to reach target = (10-7)/1 = 3
 *          car A will reach the target first, so the car fleet is 1
 * 
 *          Now take for car C to reach target = (10-1)/2 = 4.5
 *          car C will reach the target later than car A, so the car fleet is 2
 *          because it will collide with itself
 */
class Car {

    int pos, speed;

    Car(int p, int s) {
        pos = p;
        speed = s;
    }
}

class CarComparator implements Comparator<Car> {

    public int compare(Car a, Car b) {
        return a.pos - b.pos;
    }
}

public class _853_CarFleet {

    /*
     * Array Approach
     * 
     * Steps:
     * 1. Create a result variable to store the result and an array to store the time taken for each car to reach the target
     * 2. Iterate through the position array and store the time taken for each car to reach the target
     * 3. Initialize a variable as 0.0 to store previous and Iterate through the time array from the end to start 
     * 4. If the current time is greater than the previous time, then update the previous time and increment the result
     * 5. return the result
     * 
     * Time complexity: O(n)
     */
    public static int method1(int target, int[] position, int[] speed) {
        int res = 0;
        double[] timArr = new double[target];

        for (int i = 0; i < position.length; i++) {
            timArr[position[i]] = (double) (target - position[i]) / speed[i];
        }
        double prev = 0.0;

        System.out.println("Target");
        for (int i = 0; i < target; i++) {
            System.out.print(timArr[i] + " ");
        }
        System.out.println("\n");

        for (int i = target - 1; i >= 0; i--) {
            double curr = timArr[i];
            if (curr > prev) {
                prev = curr;
                res++;
            }
        }
        return res;
    }


    /*
     * Stack Approach
     * 
     * Steps:
     * 1. Create a list of cars and store the position and speed of each car
     * 2. Sort the cars based on the position
     * 3. Create a stack to store the time taken for each car to reach the target
     * 4. Iterate through the cars and calculate the time taken for each car to reach the target
     * 
     * Time complexity: O(nlogn)
     */
    public static int method2(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; ++i) {
            Car car = new Car(position[i], speed[i]);
            cars.add(car);
        }
        Collections.sort(cars, new CarComparator());

        Stack<Double> stack = new Stack<>();
        for (Car car : cars) {
            double time = (target - car.pos) / (double) car.speed;
            while (!stack.isEmpty() && time >= stack.peek()) {
                stack.pop();
            }
            stack.push(time);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(method2(target, position, speed));
    }
}
