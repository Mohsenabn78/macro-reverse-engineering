package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatKeyframeSet.java */
/* loaded from: classes6.dex */
public class a extends c {

    /* renamed from: g  reason: collision with root package name */
    private float f36379g;

    /* renamed from: h  reason: collision with root package name */
    private float f36380h;

    /* renamed from: i  reason: collision with root package name */
    private float f36381i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f36382j;

    public a(Keyframe.a... aVarArr) {
        super(aVarArr);
        this.f36382j = true;
    }

    @Override // com.nineoldandroids.animation.c
    public Object b(float f4) {
        return Float.valueOf(i(f4));
    }

    @Override // com.nineoldandroids.animation.c
    /* renamed from: h */
    public a clone() {
        ArrayList<Keyframe> arrayList = this.f36391e;
        int size = arrayList.size();
        Keyframe.a[] aVarArr = new Keyframe.a[size];
        for (int i4 = 0; i4 < size; i4++) {
            aVarArr[i4] = (Keyframe.a) arrayList.get(i4).mo4176clone();
        }
        return new a(aVarArr);
    }

    public float i(float f4) {
        int i4 = this.f36387a;
        if (i4 == 2) {
            if (this.f36382j) {
                this.f36382j = false;
                this.f36379g = ((Keyframe.a) this.f36391e.get(0)).b();
                float b4 = ((Keyframe.a) this.f36391e.get(1)).b();
                this.f36380h = b4;
                this.f36381i = b4 - this.f36379g;
            }
            Interpolator interpolator = this.f36390d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            TypeEvaluator typeEvaluator = this.f36392f;
            if (typeEvaluator == null) {
                return this.f36379g + (f4 * this.f36381i);
            }
            return ((Number) typeEvaluator.evaluate(f4, Float.valueOf(this.f36379g), Float.valueOf(this.f36380h))).floatValue();
        } else if (f4 <= 0.0f) {
            Keyframe.a aVar = (Keyframe.a) this.f36391e.get(0);
            Keyframe.a aVar2 = (Keyframe.a) this.f36391e.get(1);
            float b5 = aVar.b();
            float b6 = aVar2.b();
            float fraction = aVar.getFraction();
            float fraction2 = aVar2.getFraction();
            Interpolator interpolator2 = aVar2.getInterpolator();
            if (interpolator2 != null) {
                f4 = interpolator2.getInterpolation(f4);
            }
            float f5 = (f4 - fraction) / (fraction2 - fraction);
            TypeEvaluator typeEvaluator2 = this.f36392f;
            if (typeEvaluator2 == null) {
                return b5 + (f5 * (b6 - b5));
            }
            return ((Number) typeEvaluator2.evaluate(f5, Float.valueOf(b5), Float.valueOf(b6))).floatValue();
        } else if (f4 >= 1.0f) {
            Keyframe.a aVar3 = (Keyframe.a) this.f36391e.get(i4 - 2);
            Keyframe.a aVar4 = (Keyframe.a) this.f36391e.get(this.f36387a - 1);
            float b7 = aVar3.b();
            float b8 = aVar4.b();
            float fraction3 = aVar3.getFraction();
            float fraction4 = aVar4.getFraction();
            Interpolator interpolator3 = aVar4.getInterpolator();
            if (interpolator3 != null) {
                f4 = interpolator3.getInterpolation(f4);
            }
            float f6 = (f4 - fraction3) / (fraction4 - fraction3);
            TypeEvaluator typeEvaluator3 = this.f36392f;
            if (typeEvaluator3 == null) {
                return b7 + (f6 * (b8 - b7));
            }
            return ((Number) typeEvaluator3.evaluate(f6, Float.valueOf(b7), Float.valueOf(b8))).floatValue();
        } else {
            Keyframe.a aVar5 = (Keyframe.a) this.f36391e.get(0);
            int i5 = 1;
            while (true) {
                int i6 = this.f36387a;
                if (i5 < i6) {
                    Keyframe.a aVar6 = (Keyframe.a) this.f36391e.get(i5);
                    if (f4 < aVar6.getFraction()) {
                        Interpolator interpolator4 = aVar6.getInterpolator();
                        if (interpolator4 != null) {
                            f4 = interpolator4.getInterpolation(f4);
                        }
                        float fraction5 = (f4 - aVar5.getFraction()) / (aVar6.getFraction() - aVar5.getFraction());
                        float b9 = aVar5.b();
                        float b10 = aVar6.b();
                        TypeEvaluator typeEvaluator4 = this.f36392f;
                        if (typeEvaluator4 == null) {
                            return b9 + (fraction5 * (b10 - b9));
                        }
                        return ((Number) typeEvaluator4.evaluate(fraction5, Float.valueOf(b9), Float.valueOf(b10))).floatValue();
                    }
                    i5++;
                    aVar5 = aVar6;
                } else {
                    return ((Number) this.f36391e.get(i6 - 1).getValue()).floatValue();
                }
            }
        }
    }
}
