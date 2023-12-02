package com.h6ah4i.android.widget.advrecyclerview.swipeable;

/* compiled from: SwipeReactionUtils.java */
/* loaded from: classes6.dex */
class d {
    public static boolean a(int i4) {
        if (e(i4) == 2) {
            return true;
        }
        return false;
    }

    public static boolean b(int i4) {
        if (f(i4) == 2) {
            return true;
        }
        return false;
    }

    public static boolean c(int i4) {
        if (g(i4) == 2) {
            return true;
        }
        return false;
    }

    public static boolean d(int i4) {
        if (h(i4) == 2) {
            return true;
        }
        return false;
    }

    public static int e(int i4) {
        return (i4 >>> 18) & 3;
    }

    public static int f(int i4) {
        return (i4 >>> 0) & 3;
    }

    public static int g(int i4) {
        return (i4 >>> 12) & 3;
    }

    public static int h(int i4) {
        return (i4 >>> 6) & 3;
    }
}
