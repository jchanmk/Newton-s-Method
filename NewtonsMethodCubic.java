import java.math.BigDecimal;

public class NewtonsMethodCubic {
///// only change these 3 functions to find root
    public static BigDecimal f(BigDecimal x){
        //return(x.multiply(x).multiply(x).subtract(new BigDecimal(8))); //function 1
        //return(x.multiply(x).multiply(x).subtract(new BigDecimal(2).multiply(x).multiply(x)).subtract(new BigDecimal(4).multiply(x)).add(new BigDecimal(8)));   //function 2
        //return(x.multiply(x).multiply(x).multiply( new BigDecimal(-1)).add(new BigDecimal(8))); // function 3
       // return(x.multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(26).multiply(x).multiply(x))); // function 7/8
        //return(x.multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(26).multiply(x).multiply(x).multiply(x))); // function 9
        return(x.multiply(x).subtract(new BigDecimal(4).multiply(x)).add(new BigDecimal(4))); // x^2-4x+4
    }
    public static BigDecimal df(BigDecimal x){
       // return(new BigDecimal(3).multiply(x).multiply(x)); // function 1
       // return(new BigDecimal(3).multiply(x).multiply(x).subtract(new BigDecimal(4).multiply(x)).subtract(new BigDecimal(4)));  // function 2
        //return(x.multiply(x).multiply(new BigDecimal(3).multiply(new BigDecimal(-1)))); // function 3
       // return(x = new BigDecimal(5).multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(52).multiply(x))); //function 7/8
       // return(new BigDecimal(5).multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(78).multiply(x).multiply(x))); // function 9
        return(new BigDecimal(2).multiply(x).subtract(new BigDecimal(4)));  //2x-4
    }

    public static BigDecimal ddf(BigDecimal x){
        //return(x.multiply(new BigDecimal(6))); //function 1
       // return(x.multiply(new BigDecimal(6)).subtract(new BigDecimal(4)));   //function 2
        //return(x.multiply(new BigDecimal(-6))); // function 3
       // return (new BigDecimal(20).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(52))); // function 7/8
        //return (new BigDecimal(20).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(156).multiply(x))); //function 9
        return (new BigDecimal(2)); // 2

    }

///// additional newtons method for newtons method
    public static BigDecimal function(BigDecimal x){
        //compute the number in the square root, then create the function with that eg. find sqrt(2) --> x^2-2=0
        //then plug in an initial guess
        //function of the sqrt would be x^2-shit inside sqrt.

        return(df(x).pow(2).subtract(new BigDecimal(2).multiply(f(x)).multiply(ddf(x))));

    }

    public static BigDecimal secondnewtonf(BigDecimal x){
        return (x.multiply(x).subtract(function(x)));

    }

    public static BigDecimal root2(BigDecimal x){
        return(new BigDecimal(2).multiply(x));
    }

    public static BigDecimal sqrt(BigDecimal x){
        BigDecimal tol0 = new BigDecimal(10).pow(1000);
        BigDecimal x1;
        BigDecimal t = function(x);
       // double x5 = Math.round(Math.sqrt(function(x).intValue()));
       // double x5 = Math.sqrt(function(x).intValue());
        //BigDecimal x7 = new BigDecimal(x5).add(new BigDecimal(5));
        int itteration = 0;


        while(itteration<20){
            x1 = x.subtract((x.multiply(x).subtract(t)).divide(root2(x), 2000, BigDecimal.ROUND_FLOOR));

            x = x1;
            itteration++;
            //System.out.println(x);

        }
       // System.out.println(x);
        return x;
    }
//////

    public static void NewtonCubic(){
        boolean cont = true;
        int iteration = 0;
        BigDecimal tol0 = new BigDecimal(10).pow(1000);
        BigDecimal tol = new BigDecimal(1).divide(tol0,2000, BigDecimal.ROUND_FLOOR);// tolerance
        BigDecimal tol3 = new BigDecimal(10).pow(700);
        BigDecimal tol2 = new BigDecimal(1).divide(tol3, 2000, BigDecimal.ROUND_FLOOR);

        BigDecimal x0 = new BigDecimal(3 ); // guess
        //BigDecimal x0 = tol2;
        BigDecimal x1, error;


        while(cont){
 /*add*/         // x1 = x0.subtract(df(x0).divide(ddf(x0), 2000, BigDecimal.ROUND_FLOOR)).add(sqrt(x0).divide(ddf(x0), 2000, BigDecimal.ROUND_FLOOR));
 /*subtract*/     x1 = x0.subtract(df(x0).divide(ddf(x0), 2000, BigDecimal.ROUND_FLOOR)).subtract(sqrt(x0).divide(ddf(x0), 2000, BigDecimal.ROUND_FLOOR));
            error = x1.subtract(x0).abs();
            x0 = x1;

            String errorString = error.toString();
            int length = errorString.length();

            iteration++;
            //errorString.substring(length-10, length).equals("0000000000")
            if (error.compareTo(tol) == -1){
                String rootString = x1.toString();
                int x1length = rootString.length();
                System.out.println("Iteration " + iteration +" "+ "Final Error: " + errorString.substring(0, 10) + errorString.substring(length-6, length));
                System.out.println("Final Root: " + rootString.substring(0,10) + "..." + rootString.substring(x1length-10,x1length));
                cont = false;
            }

            else if (iteration >774) { // change this number according to function
                if (errorString.substring(length - 3, length - 2).equals("E"))
                    System.out.println(errorString.substring(length - 2, length));

                else if (errorString.substring(length - 4, length - 3).equals("E"))
                    System.out.println(errorString.substring(length - 3, length));

                else if (errorString.substring(length - 5, length - 4).equals("E"))
                    System.out.println(errorString.substring(length - 4, length));

                else if (errorString.substring(length - 6, length - 5).equals("E"))
                    System.out.println(errorString.substring(length - 5, length));
            }

                else{
               // System.out.println("Iteration " + iteration + ": " + errorString.substring(0,10)+ "..." + errorString.substring(length-10, length));
              //  System.out.println(errorString.substring(0,10)+ " " + errorString.substring(length-5, length));

                if(errorString.substring(length-3,length-2).equals("E"))
                    System.out.println(errorString.substring(0,10)+ errorString.substring(length-3, length));

                else if(errorString.substring(length-4,length-3).equals("E"))
                    System.out.println(errorString.substring(0,10)+ errorString.substring(length-4, length));

                else if(errorString.substring(length-5,length-4).equals("E"))
                    System.out.println(errorString.substring(0,10)+ errorString.substring(length-5, length));

                else if(errorString.substring(length-6,length-5).equals("E"))
                    System.out.println(errorString.substring(0,10)+ errorString.substring(length-6, length));

                else
                    System.out.println(errorString.substring(0,10));

            }
        }
    }

    public static void main (String [] args){
        NewtonCubic();
       /* BigDecimal x = new BigDecimal(3);
        double x5 = Math.round(Math.sqrt(function(x).intValue()));
        BigDecimal x7 = new BigDecimal(x5);
        System.out.println(x7);
*/

    }
}
