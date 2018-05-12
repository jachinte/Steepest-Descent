//Unconstrained non linear optimization, Steepest Descent/Gradient method had to make this for Operations research intro class.
//Step is constant


import java.util.Scanner;
class Main {
    //Global minimum is redundant, use only if you need precise count of iterations
    static double globMin = -1 / 14;
    static double epsilon = 0.07;
    static double step = 0.05;

    double fun(double x, double y) {
        return x - y + 5 * x * x - 4 * x * y + 5 * y * y;
    }
    //derivative after x basing on function
    static double derx(double x, double y) {
        return 10 * x - 4 * y + 1;
    }
    //derivative after y
    static double dery(double x, double y) {
        return -4 * x + 10 * y - 1;
    }

    //These two functions are redundant and can be replaced with using just derx and dery
    //Gradient x
    static double gradFunx(double x, double y) {
        return derx(x, y);
    }
    //Gradient y
    static double gradFuny(double x, double y) {
        return dery(x, y);
    }
    //Next x value
    static double xtGradfX(double x, double y, double step) {
        return x - step * gradFunx(x, y);
    }
    //Next y value
    static double xtGradfY(double x, double y, double step) {
        return y - step * gradFuny(x, y);
    }


    public static void main(String[] args) {
        int iter = 1;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter initial trial solution");
        System.out.print("(x) - ");
        double xIn = scan.nextDouble();
        System.out.print("(y) - ");
        double yIn = scan.nextDouble();
        System.out.print("Epsilon? - ");
        double epsilon = scan.nextDouble();
        System.out.print("Step? - ");
         double solis = scan.nextDouble();

        do {

            System.out.println("----------------------------");
            System.out.println("Iteration: " + iter);
            System.out.println("x' = " + xIn + ", " + yIn);
            System.out.printf("Gradient function elements = (%.5f, %.5f)\n", gradFunx(xIn, yIn), gradFuny(xIn, yIn));
            System.out.printf("Next elements = (%.5f, %.5f)\n", xtGradfX(xIn, yIn, solis), xtGradfY(xIn, yIn, solis));

            xIn = xtGradfX(xIn, yIn, solis);
            yIn = xtGradfY(xIn, yIn, solis);
            iter++;
           /* Use this only if you're interested in first 100 iterations
            if (iter > 100) {
                break;
            }
            */

        } while (Math.abs(gradFunx(xIn, yIn)) >= epsilon && Math.abs(gradFuny(xIn, yIn)) >= epsilon);

    }

}