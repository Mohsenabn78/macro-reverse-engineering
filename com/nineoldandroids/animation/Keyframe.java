package com.nineoldandroids.animation;

import android.view.animation.Interpolator;

/* loaded from: classes6.dex */
public abstract class Keyframe implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    float f36324a;

    /* renamed from: b  reason: collision with root package name */
    Class f36325b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f36326c = null;

    /* renamed from: d  reason: collision with root package name */
    boolean f36327d = false;

    /* loaded from: classes6.dex */
    static class c extends Keyframe {

        /* renamed from: e  reason: collision with root package name */
        Object f36330e;

        c(float f4, Object obj) {
            boolean z3;
            Class<?> cls;
            this.f36324a = f4;
            this.f36330e = obj;
            if (obj != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f36327d = z3;
            if (z3) {
                cls = obj.getClass();
            } else {
                cls = Object.class;
            }
            this.f36325b = cls;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        /* renamed from: a */
        public c mo4176clone() {
            c cVar = new c(getFraction(), this.f36330e);
            cVar.setInterpolator(getInterpolator());
            return cVar;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public Object getValue() {
            return this.f36330e;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public void setValue(Object obj) {
            boolean z3;
            this.f36330e = obj;
            if (obj != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f36327d = z3;
        }
    }

    public static Keyframe ofFloat(float f4, float f5) {
        return new a(f4, f5);
    }

    public static Keyframe ofInt(float f4, int i4) {
        return new b(f4, i4);
    }

    public static Keyframe ofObject(float f4, Object obj) {
        return new c(f4, obj);
    }

    @Override // 
    /* renamed from: clone */
    public abstract Keyframe mo4176clone();

    public float getFraction() {
        return this.f36324a;
    }

    public Interpolator getInterpolator() {
        return this.f36326c;
    }

    public Class getType() {
        return this.f36325b;
    }

    public abstract Object getValue();

    public boolean hasValue() {
        return this.f36327d;
    }

    public void setFraction(float f4) {
        this.f36324a = f4;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f36326c = interpolator;
    }

    public abstract void setValue(Object obj);

    public static Keyframe ofFloat(float f4) {
        return new a(f4);
    }

    public static Keyframe ofInt(float f4) {
        return new b(f4);
    }

    public static Keyframe ofObject(float f4) {
        return new c(f4, null);
    }

    /* loaded from: classes6.dex */
    static class a extends Keyframe {

        /* renamed from: e  reason: collision with root package name */
        float f36328e;

        a(float f4, float f5) {
            this.f36324a = f4;
            this.f36328e = f5;
            this.f36325b = Float.TYPE;
            this.f36327d = true;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        /* renamed from: a */
        public a mo4176clone() {
            a aVar = new a(getFraction(), this.f36328e);
            aVar.setInterpolator(getInterpolator());
            return aVar;
        }

        public float b() {
            return this.f36328e;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public Object getValue() {
            return Float.valueOf(this.f36328e);
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public void setValue(Object obj) {
            if (obj != null && obj.getClass() == Float.class) {
                this.f36328e = ((Float) obj).floatValue();
                this.f36327d = true;
            }
        }

        a(float f4) {
            this.f36324a = f4;
            this.f36325b = Float.TYPE;
        }
    }

    /* loaded from: classes6.dex */
    static class b extends Keyframe {

        /* renamed from: e  reason: collision with root package name */
        int f36329e;

        b(float f4, int i4) {
            this.f36324a = f4;
            this.f36329e = i4;
            this.f36325b = Integer.TYPE;
            this.f36327d = true;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        /* renamed from: a */
        public b mo4176clone() {
            b bVar = new b(getFraction(), this.f36329e);
            bVar.setInterpolator(getInterpolator());
            return bVar;
        }

        public int b() {
            return this.f36329e;
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public Object getValue() {
            return Integer.valueOf(this.f36329e);
        }

        @Override // com.nineoldandroids.animation.Keyframe
        public void setValue(Object obj) {
            if (obj != null && obj.getClass() == Integer.class) {
                this.f36329e = ((Integer) obj).intValue();
                this.f36327d = true;
            }
        }

        b(float f4) {
            this.f36324a = f4;
            this.f36325b = Integer.TYPE;
        }
    }
}
