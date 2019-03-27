import java.math.BigDecimal;
import java.util.Scanner;

public class NewtonsMethodQuadratic {
    public static BigDecimal f(BigDecimal x){
        return(x.multiply(x).multiply(x).subtract(new BigDecimal(8))); //function 1
        //return(x.multiply(x).multiply(x).subtract(new BigDecimal(2).multiply(x).multiply(x)).subtract(new BigDecimal(4).multiply(x)).add(new BigDecimal(8)));   //function 2
        //return(x.multiply(x).multiply(x).multiply( new BigDecimal(-1)).add(new BigDecimal(8))); // function 3
        //return(x.multiply(x).multiply(x).multiply(x).subtract( new BigDecimal(23))); // function 6
        //return(x.multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(26).multiply(x).multiply(x))); // function 7/8
       // return(x.multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(26).multiply(x).multiply(x).multiply(x))); // function 9

    }

    public static BigDecimal df(BigDecimal x){
        return(new BigDecimal(3).multiply(x).multiply(x)); // function 1
        //return(new BigDecimal(3).multiply(x).multiply(x).subtract(new BigDecimal(4).multiply(x)).subtract(new BigDecimal(4)));  // function 2
        //return(x.multiply(x).multiply(new BigDecimal(3).multiply(new BigDecimal(-1)))); // function 3
        //return(x.multiply(x).multiply(x).multiply(new BigDecimal(4))); // function 6
        //return(x = new BigDecimal(5).multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(52).multiply(x))); //function 7/8
      // return(new BigDecimal(5).multiply(x).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(78).multiply(x).multiply(x))); // function 9

    }

    public static void NewtonQuadratic(){
        boolean cont = true;
        int iteration = 0;
        BigDecimal tol0 = new BigDecimal(10).pow(1000);
        BigDecimal tol = new BigDecimal(1).divide(tol0,2000, BigDecimal.ROUND_FLOOR);// tolerance
       // BigDecimal tol3 = new BigDecimal(10).pow(700);
        //BigDecimal tol2 = new BigDecimal(1).divide(tol3, 2000, BigDecimal.ROUND_FLOOR);
        BigDecimal x0 = new BigDecimal(5); // guess
        //BigDecimal x0 = tol2;
        BigDecimal x1, error, errorPrev;


        while(cont){
            x1 = x0.subtract(f(x0).divide(df(x0), 2000, BigDecimal.ROUND_FLOOR));
            error = x1.subtract(x0).abs();
            x0 = x1;

            String errorString = error.toString();
            int length = errorString.length();

            iteration++;
            //errorString.substring(length-10, length).equals("0000000000")
            if (error.compareTo(tol) == -1){
                String rootString = x1.toString();
                int x1length = rootString.length();
                System.out.println("Iteration " + iteration +" " +"Final Error: " + errorString.substring(0, 10) + errorString.substring(length-6, length));
                System.out.println("Final Root: " + rootString.substring(0,10) + "..." + rootString.substring(length-10,length));
                cont = false;
            }

            else if (iteration >1739){ // change this number according to function
                if(errorString.substring(length-3,length-2).equals("E"))
                    System.out.println(errorString.substring(length-2, length));

                else if(errorString.substring(length-4,length-3).equals("E"))
                    System.out.println(errorString.substring(length-3, length));

                else if(errorString.substring(length-5,length-4).equals("E"))
                    System.out.println(errorString.substring(length-4, length));

                else if(errorString.substring(length-6,length-5).equals("E"))
                    System.out.println(errorString.substring(length-5, length));


               // else
                 //   System.out.println(errorString.substring(0,10));

            }

            else{
               // System.out.println(errorString.substring(0,10)+ "..." + errorString.substring(length-10, length));
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
            errorPrev = error;
        }
    }

    public static void main (String [] args){
        NewtonQuadratic();
/*        String s = "0000000000000000";
        int length = s.length();
        if(s.substring(length-10, length).equals("0000000000")){
            System.out.println("yep");
        }
        BigDecimal x = new BigDecimal(5);
        x = x.pow(new BigDecimal(.5).intValue());
        System.out.println(x);


        BigDecimal x = new BigDecimal(5);
        x = new BigDecimal(20).multiply(x).multiply(x).multiply(x).subtract(new BigDecimal(156).multiply(x));
        System.out.println(x);

        double e2 = Math.E;
        BigDecimal e = new BigDecimal(Math.E);
        System.out.println(e);
*/

    }
}
