package hackBulgariaWeek2;

public class PolynomialWIthVectorTest {

  public static void main(String[] args) {
    PolynomialWithVector zero = new PolynomialWithVector(0, 0);
    PolynomialWithVector p1 = new PolynomialWithVector(4, 3);
    PolynomialWithVector p2 = new PolynomialWithVector(3, 2);
    PolynomialWithVector p3 = new PolynomialWithVector(1, 0);
    PolynomialWithVector p4 = new PolynomialWithVector(2, 1);
    PolynomialWithVector p = p1.plus(p2).plus(p3).plus(p4);
    
    PolynomialWithVector q1 = new PolynomialWithVector(3, 2);
    PolynomialWithVector q2 = new PolynomialWithVector(5, 0);
    PolynomialWithVector q = q1.plus(q2);
    
    PolynomialWithVector r = p.plus(q);
    PolynomialWithVector s = p.times(q);
    PolynomialWithVector t = p.compose(q);
    
    System.out.println("zero(x) = " + zero);
    System.out.println("p(x) = " + p);
    System.out.println("q(x) = " + q);
    System.out.println("p(x) + q(x) = " + r);
    System.out.println("p(x) * q(x) = " + s);
    System.out.println("p(q(x)) = " + t);
    System.out.println("0 - p(x) = " + zero.minus(p));
    System.out.println("p(3) = " + p.evaluate(3));
    System.out.println("p'(x) = " + p.differentiate());
    System.out.println("p''(x) = " + p.differentiate().differentiate());

  }

}
