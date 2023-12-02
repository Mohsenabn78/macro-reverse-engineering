package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IntKeyframeSet.java */
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: g  reason: collision with root package name */
    private int f36383g;

    /* renamed from: h  reason: collision with root package name */
    private int f36384h;

    /* renamed from: i  reason: collision with root package name */
    private int f36385i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f36386j;

    public b(Keyframe.b... bVarArr) {
        super(bVarArr);
        this.f36386j = true;
    }

    @Override // com.nineoldandroids.animation.c
    public Object b(float f4) {
        return Integer.valueOf(i(f4));
    }

    @Override // com.nineoldandroids.animation.c
    /* renamed from: h */
    public b clone() {
        ArrayList<Keyframe> arrayList = this.f36391e;
        int size = arrayList.size();
        Keyframe.b[] bVarArr = new Keyframe.b[size];
        for (int i4 = 0; i4 < size; i4++) {
            bVarArr[i4] = (Keyframe.b) arrayList.get(i4).mo4176clone();
        }
        return new b(bVarArr);
    }

    public int i(float f4) {
        int i4 = this.f36387a;
        if (i4 == 2) {
            if (this.f36386j) {
                this.f36386j = false;
                this.f36383g = ((Keyframe.b) this.f36391e.get(0)).b();
                int b4 = ((Keyframe.b) this.f36391e.get(1)).b();
                this.f36384h = b4;
                this.f36385i = b4 - this.f36383g;
            }
            Interpolator interpolator = this.f36390d;
            if (interpolator != null) {
                f4 = interpolator.getInterpolation(f4);
            }
            TypeEvaluator typeEvaluator = this.f36392f;
            if (typeEvaluator == null) {
                return this.f36383g + ((int) (f4 * this.f36385i));
            }
            return ((Number) typeEvaluator.evaluate(f4, Integer.valueOf(this.f36383g), Integer.valueOf(this.f36384h))).intValue();
        } else if (f4 <= 0.0f) {
            Keyframe.b bVar = (Keyframe.b) this.f36391e.get(0);
            Keyframe.b bVar2 = (Keyframe.b) this.f36391e.get(1);
            int b5 = bVar.b();
            int b6 = bVar2.b();
            float fraction = bVar.getFraction();
            float fraction2 = bVar2.getFraction();
            Interpolator interpolator2 = bVar2.getInterpolator();
            if (interpolator2 != null) {
                f4 = interpolator2.getInterpolation(f4);
            }
            float f5 = (f4 - fraction) / (fraction2 - fraction);
            TypeEvaluator typeEvaluator2 = this.f36392f;
            if (typeEvaluator2 == null) {
                return b5 + ((int) (f5 * (b6 - b5)));
            }
            return ((Number) typeEvaluator2.evaluate(f5, Integer.valueOf(b5), Integer.valueOf(b6))).intValue();
        } else if (f4 >= 1.0f) {
            Keyframe.b bVar3 = (Keyframe.b) this.f36391e.get(i4 - 2);
            Keyframe.b bVar4 = (Keyframe.b) this.f36391e.get(this.f36387a - 1);
            int b7 = bVar3.b();
            int b8 = bVar4.b();
            float fraction3 = bVar3.getFraction();
            float fraction4 = bVar4.getFraction();
            Interpolator interpolator3 = bVar4.getInterpolator();
            if (interpolator3 != null) {
                f4 = interpolator3.getInterpolation(f4);
            }
            float f6 = (f4 - fraction3) / (fraction4 - fraction3);
            TypeEvaluator typeEvaluator3 = this.f36392f;
            if (typeEvaluator3 == null) {
                return b7 + ((int) (f6 * (b8 - b7)));
            }
            return ((Number) typeEvaluator3.evaluate(f6, Integer.valueOf(b7), Integer.valueOf(b8))).intValue();
        } else {
            Keyframe.b bVar5 = (Keyframe.b) this.f36391e.get(0);
            int i5 = 1;
            while (true) {
                int i6 = this.f36387a;
                if (i5 < i6) {
                    Keyframe.b bVar6 = (Keyframe.b) this.f36391e.get(i5);
                    if (f4 < bVar6.getFraction()) {
                        Interpolator interpolator4 = bVar6.getInterpolator();
                        if (interpolator4 != null) {
                            f4 = interpolator4.getInterpolation(f4);
                        }
                        float fraction5 = (f4 - bVar5.getFraction()) / (bVar6.getFraction() - bVar5.getFraction());
                        int b9 = bVar5.b();
                        int b10 = bVar6.b();
                        TypeEvaluator typeEvaluator4 = this.f36392f;
                        if (typeEvaluator4 == null) {
                            return b9 + ((int) (fraction5 * (b10 - b9)));
                        }
                        return ((Number) typeEvaluator4.evaluate(fraction5, Integer.valueOf(b9), Integer.valueOf(b10))).intValue();
                    }
                    i5++;
                    bVar5 = bVar6;
                } else {
                    return ((Number) this.f36391e.get(i6 - 1).getValue()).intValue();
                }
            }
        }
    }
}
