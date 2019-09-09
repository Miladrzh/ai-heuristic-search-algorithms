package problem3;

import interfaces.State;

/**
 * Created by Milad on 12/21/2017.
 */
public class EquationState implements State {
    public int a, b, c, d;

    public EquationState() {
        a = (int) Math.random() * 40;
        if (Math.random() > 0.5)
            a *= -1;
        b = (int) Math.random() * 40;
        if (Math.random() > 0.5)
            b *= -1;
        c = (int) Math.random() * 40;
        if (Math.random() > 0.5)
            c *= -1;
        d = (int) Math.random() * 40;
        if (Math.random() > 0.5)
            d *= -1;
    }

    public int value() {
        return a + 2 * b + 3 * c + 4 * d;
    }

    public EquationState child(EquationState y) {
        EquationState ret = new EquationState();
        if (Math.random() > 0.5)
            ret.a = y.a;
        else
            ret.a = this.a;
        if (Math.random() > 0.5)
            ret.b = y.b;
        else
            ret.b = this.b;
        if (Math.random() > 0.5)
            ret.c = y.c;
        else
            ret.c = this.c;
        if (Math.random() > 0.5)
            ret.d = y.d;
        else
            ret.d = this.d;
        return ret;
    }

    public EquationState mutate() {
        EquationState ret = new EquationState();

        if (Math.random() < 0.25)
            ret.a = this.a - 1;
        else if (Math.random() < 0.50)
            ret.a = this.a + 1;
        else
            ret.a = this.a;

        if (Math.random() < 0.25)
            ret.b = this.b - 1;
        else if (Math.random() < 0.50)
            ret.b = this.b + 1;
        else
            ret.b = this.b;

        if (Math.random() < 0.25)
            ret.c = this.c - 1;
        else if (Math.random() < 0.50)
            ret.c = this.c + 1;
        else
            ret.c = this.c;

        if (Math.random() < 0.25)
            ret.d = this.d - 1;
        else if (Math.random() < 0.50)
            ret.d = this.d + 1;
        else
            ret.d = this.d;
        return ret;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "a: " + a + "  b: " + b + "  c: " + c + "  d: " + d + "\n";
        return ret;
    }
}
