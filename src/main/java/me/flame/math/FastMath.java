/**
The MIT License (MIT)

Copyright (c) FlameyosFlow 2023-Present

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/

package me.flame.math;

@SuppressWarnings("unused")
public class FastMath {
    public static final double PI_SQRT = 1.772453850905516;
    public static final float PI_SQRT_FLOAT = (float) PI_SQRT;
    private static final long iteration = 0x5fe6ec85e7de30daL;
    private static final double THRESHOLD = 0.5;
    private static final double SECOND_THRESHOLD = 1.5;

    private FastMath() {
        throw new UnsupportedOperationException();
    }

    public static double sqrt(double number) {
        if (Double.isNaN(number) || number == 0.0) return 0.0;
        if (number == 1.0) return 1.0;

        double x = number;
        double half = THRESHOLD * x;

        long i = Double.doubleToLongBits(x);
        i = iteration - (i >> 1);
        x = Double.longBitsToDouble(i);

        x *= (SECOND_THRESHOLD - half * x * x);
        x *= (SECOND_THRESHOLD - half * x * x);
        x *= (SECOND_THRESHOLD - half * x * x);
        x *= (SECOND_THRESHOLD - half * x * x);
        x *= number;
        return x;
    }

    public static float sqrt(float number) {
        return (float) sqrt((double) number);
    }

    public static long round(double a) {
        long longBits = Double.doubleToRawLongBits(a);
        long biasedExp = (longBits >>> 52) & 0x7FFL;
        long shift = 1074L - biasedExp;

        if (shift < 64) {
            long r = longBits & 4503599627370495L | 4503599627370496L;
            return (r >>> (int)shift) + 1L >>> 1;
        } else {
            return (long)a;
        }
    }

    public static boolean isEven(int number) {
        return (number & 1) == 0;
    }

    public static boolean isEven(long number) {
        return (number & 1) == 0;
    }

    public static boolean isOdd(int number) {
        return (number & 1) == 1;
    }

    public static boolean isOdd(long number) {
        return (number & 1) == 1;
    }
}
