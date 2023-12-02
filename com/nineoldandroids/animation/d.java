package com.nineoldandroids.animation;

import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

/* compiled from: PreHoneycombCompat.java */
/* loaded from: classes6.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    static Property<View, Float> f36393a = new f("alpha");

    /* renamed from: b  reason: collision with root package name */
    static Property<View, Float> f36394b = new g("pivotX");

    /* renamed from: c  reason: collision with root package name */
    static Property<View, Float> f36395c = new h("pivotY");

    /* renamed from: d  reason: collision with root package name */
    static Property<View, Float> f36396d = new i("translationX");

    /* renamed from: e  reason: collision with root package name */
    static Property<View, Float> f36397e = new j("translationY");

    /* renamed from: f  reason: collision with root package name */
    static Property<View, Float> f36398f = new k(Key.ROTATION);

    /* renamed from: g  reason: collision with root package name */
    static Property<View, Float> f36399g = new l("rotationX");

    /* renamed from: h  reason: collision with root package name */
    static Property<View, Float> f36400h = new m("rotationY");

    /* renamed from: i  reason: collision with root package name */
    static Property<View, Float> f36401i = new n("scaleX");

    /* renamed from: j  reason: collision with root package name */
    static Property<View, Float> f36402j = new a("scaleY");

    /* renamed from: k  reason: collision with root package name */
    static Property<View, Integer> f36403k = new b("scrollX");

    /* renamed from: l  reason: collision with root package name */
    static Property<View, Integer> f36404l = new c("scrollY");

    /* renamed from: m  reason: collision with root package name */
    static Property<View, Float> f36405m = new C0209d("x");

    /* renamed from: n  reason: collision with root package name */
    static Property<View, Float> f36406n = new e("y");

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class a extends FloatProperty<View> {
        a(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setScaleY(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class b extends IntProperty<View> {
        b(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollX());
        }

        @Override // com.nineoldandroids.util.IntProperty
        /* renamed from: b */
        public void setValue(View view, int i4) {
            AnimatorProxy.wrap(view).setScrollX(i4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class c extends IntProperty<View> {
        c(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Integer get(View view) {
            return Integer.valueOf(AnimatorProxy.wrap(view).getScrollY());
        }

        @Override // com.nineoldandroids.util.IntProperty
        /* renamed from: b */
        public void setValue(View view, int i4) {
            AnimatorProxy.wrap(view).setScrollY(i4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* renamed from: com.nineoldandroids.animation.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0209d extends FloatProperty<View> {
        C0209d(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setX(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class e extends FloatProperty<View> {
        e(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setY(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class f extends FloatProperty<View> {
        f(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getAlpha());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setAlpha(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class g extends FloatProperty<View> {
        g(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setPivotX(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class h extends FloatProperty<View> {
        h(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getPivotY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setPivotY(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class i extends FloatProperty<View> {
        i(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setTranslationX(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class j extends FloatProperty<View> {
        j(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getTranslationY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setTranslationY(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class k extends FloatProperty<View> {
        k(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotation());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setRotation(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class l extends FloatProperty<View> {
        l(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setRotationX(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class m extends FloatProperty<View> {
        m(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getRotationY());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setRotationY(f4);
        }
    }

    /* compiled from: PreHoneycombCompat.java */
    /* loaded from: classes6.dex */
    static class n extends FloatProperty<View> {
        n(String str) {
            super(str);
        }

        @Override // com.nineoldandroids.util.Property
        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(AnimatorProxy.wrap(view).getScaleX());
        }

        @Override // com.nineoldandroids.util.FloatProperty
        /* renamed from: b */
        public void setValue(View view, float f4) {
            AnimatorProxy.wrap(view).setScaleX(f4);
        }
    }
}
