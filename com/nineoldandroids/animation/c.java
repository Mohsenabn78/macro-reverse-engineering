package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KeyframeSet.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    int f36387a;

    /* renamed from: b  reason: collision with root package name */
    Keyframe f36388b;

    /* renamed from: c  reason: collision with root package name */
    Keyframe f36389c;

    /* renamed from: d  reason: collision with root package name */
    Interpolator f36390d;

    /* renamed from: e  reason: collision with root package name */
    ArrayList<Keyframe> f36391e;

    /* renamed from: f  reason: collision with root package name */
    TypeEvaluator f36392f;

    public c(Keyframe... keyframeArr) {
        this.f36387a = keyframeArr.length;
        ArrayList<Keyframe> arrayList = new ArrayList<>();
        this.f36391e = arrayList;
        arrayList.addAll(Arrays.asList(keyframeArr));
        this.f36388b = this.f36391e.get(0);
        Keyframe keyframe = this.f36391e.get(this.f36387a - 1);
        this.f36389c = keyframe;
        this.f36390d = keyframe.getInterpolator();
    }

    public static c c(float... fArr) {
        int length = fArr.length;
        Keyframe.a[] aVarArr = new Keyframe.a[Math.max(length, 2)];
        if (length == 1) {
            aVarArr[0] = (Keyframe.a) Keyframe.ofFloat(0.0f);
            aVarArr[1] = (Keyframe.a) Keyframe.ofFloat(1.0f, fArr[0]);
        } else {
            aVarArr[0] = (Keyframe.a) Keyframe.ofFloat(0.0f, fArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                aVarArr[i4] = (Keyframe.a) Keyframe.ofFloat(i4 / (length - 1), fArr[i4]);
            }
        }
        return new a(aVarArr);
    }

    public static c d(int... iArr) {
        int length = iArr.length;
        Keyframe.b[] bVarArr = new Keyframe.b[Math.max(length, 2)];
        if (length == 1) {
            bVarArr[0] = (Keyframe.b) Keyframe.ofInt(0.0f);
            bVarArr[1] = (Keyframe.b) Keyframe.ofInt(1.0f, iArr[0]);
        } else {
            bVarArr[0] = (Keyframe.b) Keyframe.ofInt(0.0f, iArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                bVarArr[i4] = (Keyframe.b) Keyframe.ofInt(i4 / (length - 1), iArr[i4]);
            }
        }
        return new b(bVarArr);
    }

    public static c e(Keyframe... keyframeArr) {
        int length = keyframeArr.length;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (Keyframe keyframe : keyframeArr) {
            if (keyframe instanceof Keyframe.a) {
                z3 = true;
            } else if (keyframe instanceof Keyframe.b) {
                z4 = true;
            } else {
                z5 = true;
            }
        }
        if (z3 && !z4 && !z5) {
            Keyframe.a[] aVarArr = new Keyframe.a[length];
            while (i4 < length) {
                aVarArr[i4] = (Keyframe.a) keyframeArr[i4];
                i4++;
            }
            return new a(aVarArr);
        } else if (z4 && !z3 && !z5) {
            Keyframe.b[] bVarArr = new Keyframe.b[length];
            while (i4 < length) {
                bVarArr[i4] = (Keyframe.b) keyframeArr[i4];
                i4++;
            }
            return new b(bVarArr);
        } else {
            return new c(keyframeArr);
        }
    }

    public static c f(Object... objArr) {
        int length = objArr.length;
        Keyframe.c[] cVarArr = new Keyframe.c[Math.max(length, 2)];
        if (length == 1) {
            cVarArr[0] = (Keyframe.c) Keyframe.ofObject(0.0f);
            cVarArr[1] = (Keyframe.c) Keyframe.ofObject(1.0f, objArr[0]);
        } else {
            cVarArr[0] = (Keyframe.c) Keyframe.ofObject(0.0f, objArr[0]);
            for (int i4 = 1; i4 < length; i4++) {
                cVarArr[i4] = (Keyframe.c) Keyframe.ofObject(i4 / (length - 1), objArr[i4]);
            }
        }
        return new c(cVarArr);
    }

    @Override // 
    /* renamed from: a */
    public c clone() {
        ArrayList<Keyframe> arrayList = this.f36391e;
        int size = arrayList.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i4 = 0; i4 < size; i4++) {
            keyframeArr[i4] = arrayList.get(i4).mo4176clone();
        }
        return new c(keyframeArr);
    }

    public Object b(float f4) {
        int i4 = this.f36387a;
        if (i4 == 2) {
            Interpolator interpolator = this.f36390d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            return this.f36392f.evaluate(f4, this.f36388b.getValue(), this.f36389c.getValue());
        }
        int i5 = 1;
        if (f4 <= 0.0f) {
            Keyframe keyframe = this.f36391e.get(1);
            Interpolator interpolator2 = keyframe.getInterpolator();
            if (interpolator2 != null) {
                f4 = interpolator2.getInterpolation(f4);
            }
            float fraction = this.f36388b.getFraction();
            return this.f36392f.evaluate((f4 - fraction) / (keyframe.getFraction() - fraction), this.f36388b.getValue(), keyframe.getValue());
        } else if (f4 >= 1.0f) {
            Keyframe keyframe2 = this.f36391e.get(i4 - 2);
            Interpolator interpolator3 = this.f36389c.getInterpolator();
            if (interpolator3 != null) {
                f4 = interpolator3.getInterpolation(f4);
            }
            float fraction2 = keyframe2.getFraction();
            return this.f36392f.evaluate((f4 - fraction2) / (this.f36389c.getFraction() - fraction2), keyframe2.getValue(), this.f36389c.getValue());
        } else {
            Keyframe keyframe3 = this.f36388b;
            while (i5 < this.f36387a) {
                Keyframe keyframe4 = this.f36391e.get(i5);
                if (f4 < keyframe4.getFraction()) {
                    Interpolator interpolator4 = keyframe4.getInterpolator();
                    if (interpolator4 != null) {
                        f4 = interpolator4.getInterpolation(f4);
                    }
                    float fraction3 = keyframe3.getFraction();
                    return this.f36392f.evaluate((f4 - fraction3) / (keyframe4.getFraction() - fraction3), keyframe3.getValue(), keyframe4.getValue());
                }
                i5++;
                keyframe3 = keyframe4;
            }
            return this.f36389c.getValue();
        }
    }

    public void g(TypeEvaluator typeEvaluator) {
        this.f36392f = typeEvaluator;
    }

    public String toString() {
        String str = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
        for (int i4 = 0; i4 < this.f36387a; i4++) {
            str = str + this.f36391e.get(i4).getValue() + "  ";
        }
        return str;
    }
}
