package hackBulgariaWeek2;

import java.util.Vector;

public class PolynomialWithVector {
  private Vector<Double> coeffs;
  private int deg;
  public PolynomialWithVector(double a, double b) {
    coeffs = new Vector<Double>((int) (b + 1));
    deg = degree();
  }
  public int degree() {
    int d = 0;
    for (int i = 0; i < coeffs.size(); i++) {
      if(coeffs.get(i) != 0) {
        d = i;
      }
    }
    return d;
  }
  public PolynomialWithVector plus(PolynomialWithVector b) {
    PolynomialWithVector a = this;
    PolynomialWithVector c = new PolynomialWithVector(0, Math.max(a.deg, b.deg));
    for (int i = 0; i <= a.deg; i++) {
      double result = c.coeffs.get(i);
      result += a.coeffs.get(i);
    }
    for (int i = 0; i <= b.deg; i++) {
      double result = c.coeffs.get(i);
      result += b.coeffs.get(i);
    }
    c.deg = c.degree();
    return c;
  }
  public PolynomialWithVector minus(PolynomialWithVector b) {
    PolynomialWithVector a = this;
    PolynomialWithVector c = new PolynomialWithVector(0, Math.max(a.deg, b.deg));
    for (int i = 0; i <= a.deg; i++) {
      double result = c.coeffs.get(i);
      result += a.coeffs.get(i);
    }
    for (int i = 0; i <= b.deg; i++) {
      double result = c.coeffs.get(i);
      result -= b.coeffs.get(i);
    }
    c.deg = c.degree();
    return c;
  }
  public PolynomialWithVector times(PolynomialWithVector b) {
    PolynomialWithVector a = this;
    PolynomialWithVector c = new PolynomialWithVector(0, a.deg + b.deg);
    for (int i = 0; i <= a.deg; i++) {
      for (int j = 0; j <= b.deg; j++) {
        double result = c.coeffs.get(i + j);
        result += (a.coeffs.get(i) * b.coeffs.get(j));
      }
    }
    c.deg = c.degree();
    return c;
  }
  public PolynomialWithVector compose(PolynomialWithVector b) {
    PolynomialWithVector a = this;
    PolynomialWithVector c = new PolynomialWithVector(0, 0);
    for (int i = a.deg; i >= 0; i--) {
      PolynomialWithVector term = new PolynomialWithVector(a.coeffs.get(i), 0.0);
      c = term.plus(b.times(c));
    }
    return c;
  }
  public boolean eq(PolynomialWithVector b) {
    PolynomialWithVector a = this;
    if(a.deg != b.deg) {
      return false;
    }
    for (int i = a.deg; i >= 0; i--) {
      if(a.coeffs.get(i) != b.coeffs.get(i)) {
        return false;
      }
    }
    return true;
  }
  public double evaluate(double x) {
    double p = 0;
    for (int i = deg; i >= 0; i--) {
      p = coeffs.get(i) + (x * p);
    }
    return p;
  }
  public PolynomialWithVector differentiate() {
    if(deg == 0) {
      return new PolynomialWithVector(0, 0);
    }
    PolynomialWithVector deriv = new PolynomialWithVector(0, deg - 1);
    deriv.deg = deg - 1;
    for (int i = 0; i < deg; i++) {
      double result = deriv.coeffs.get(i);
      result = (i + 1) * coeffs.get(i + 1);
    }
    return deriv;
  }
  public String toString() {
    if(deg == 0) {
      return "" + coeffs.get(0);
    }
    if(deg == 1) {
      return coeffs.get(1) + "x + " + coeffs.get(0);
    }
    String s = coeffs.get(deg) + "x^" + deg;
    for (int i = deg - 1; i >= 0; i--) {
      if(coeffs.get(i) == 0) {
        continue;
      } else if(coeffs.get(i) > 0) {
        s = s + " + " + (coeffs.get(i));
      } else if(coeffs.get(i) < 0) {
        s = s + " - " + (-coeffs.get(i));
      }
      if(i == 1) {
        s = s + "x";
      } else if(i > 1) {
        s = s + "x^" + i;
      }
    }
    return s;
  }
}
