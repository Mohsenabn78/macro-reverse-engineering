package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

/* loaded from: classes6.dex */
public final class ViewHelper {

    /* loaded from: classes6.dex */
    private static final class a {
        static void A(View view, float f4) {
            view.setX(f4);
        }

        static void B(View view, float f4) {
            view.setY(f4);
        }

        static float a(View view) {
            return view.getAlpha();
        }

        static float b(View view) {
            return view.getPivotX();
        }

        static float c(View view) {
            return view.getPivotY();
        }

        static float d(View view) {
            return view.getRotation();
        }

        static float e(View view) {
            return view.getRotationX();
        }

        static float f(View view) {
            return view.getRotationY();
        }

        static float g(View view) {
            return view.getScaleX();
        }

        static float h(View view) {
            return view.getScaleY();
        }

        static float i(View view) {
            return view.getScrollX();
        }

        static float j(View view) {
            return view.getScrollY();
        }

        static float k(View view) {
            return view.getTranslationX();
        }

        static float l(View view) {
            return view.getTranslationY();
        }

        static float m(View view) {
            return view.getX();
        }

        static float n(View view) {
            return view.getY();
        }

        static void o(View view, float f4) {
            view.setAlpha(f4);
        }

        static void p(View view, float f4) {
            view.setPivotX(f4);
        }

        static void q(View view, float f4) {
            view.setPivotY(f4);
        }

        static void r(View view, float f4) {
            view.setRotation(f4);
        }

        static void s(View view, float f4) {
            view.setRotationX(f4);
        }

        static void t(View view, float f4) {
            view.setRotationY(f4);
        }

        static void u(View view, float f4) {
            view.setScaleX(f4);
        }

        static void v(View view, float f4) {
            view.setScaleY(f4);
        }

        static void w(View view, int i4) {
            view.setScrollX(i4);
        }

        static void x(View view, int i4) {
            view.setScrollY(i4);
        }

        static void y(View view, float f4) {
            view.setTranslationX(f4);
        }

        static void z(View view, float f4) {
            view.setTranslationY(f4);
        }
    }

    private ViewHelper() {
    }

    public static float getAlpha(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getAlpha();
        }
        return a.a(view);
    }

    public static float getPivotX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getPivotX();
        }
        return a.b(view);
    }

    public static float getPivotY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getPivotY();
        }
        return a.c(view);
    }

    public static float getRotation(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotation();
        }
        return a.d(view);
    }

    public static float getRotationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationX();
        }
        return a.e(view);
    }

    public static float getRotationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getRotationY();
        }
        return a.f(view);
    }

    public static float getScaleX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScaleX();
        }
        return a.g(view);
    }

    public static float getScaleY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScaleY();
        }
        return a.h(view);
    }

    public static float getScrollX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScrollX();
        }
        return a.i(view);
    }

    public static float getScrollY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getScrollY();
        }
        return a.j(view);
    }

    public static float getTranslationX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationX();
        }
        return a.k(view);
    }

    public static float getTranslationY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getTranslationY();
        }
        return a.l(view);
    }

    public static float getX(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getX();
        }
        return a.m(view);
    }

    public static float getY(View view) {
        if (AnimatorProxy.NEEDS_PROXY) {
            return AnimatorProxy.wrap(view).getY();
        }
        return a.n(view);
    }

    public static void setAlpha(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setAlpha(f4);
        } else {
            a.o(view, f4);
        }
    }

    public static void setPivotX(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotX(f4);
        } else {
            a.p(view, f4);
        }
    }

    public static void setPivotY(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setPivotY(f4);
        } else {
            a.q(view, f4);
        }
    }

    public static void setRotation(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotation(f4);
        } else {
            a.r(view, f4);
        }
    }

    public static void setRotationX(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationX(f4);
        } else {
            a.s(view, f4);
        }
    }

    public static void setRotationY(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setRotationY(f4);
        } else {
            a.t(view, f4);
        }
    }

    public static void setScaleX(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleX(f4);
        } else {
            a.u(view, f4);
        }
    }

    public static void setScaleY(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScaleY(f4);
        } else {
            a.v(view, f4);
        }
    }

    public static void setScrollX(View view, int i4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollX(i4);
        } else {
            a.w(view, i4);
        }
    }

    public static void setScrollY(View view, int i4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setScrollY(i4);
        } else {
            a.x(view, i4);
        }
    }

    public static void setTranslationX(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationX(f4);
        } else {
            a.y(view, f4);
        }
    }

    public static void setTranslationY(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setTranslationY(f4);
        } else {
            a.z(view, f4);
        }
    }

    public static void setX(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setX(f4);
        } else {
            a.A(view, f4);
        }
    }

    public static void setY(View view, float f4) {
        if (AnimatorProxy.NEEDS_PROXY) {
            AnimatorProxy.wrap(view).setY(f4);
        } else {
            a.B(view, f4);
        }
    }
}
