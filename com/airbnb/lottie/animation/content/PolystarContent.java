package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;

/* loaded from: classes2.dex */
public class PolystarContent implements b, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: b  reason: collision with root package name */
    private final String f1473b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f1474c;

    /* renamed from: d  reason: collision with root package name */
    private final PolystarShape.Type f1475d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1476e;

    /* renamed from: f  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1477f;

    /* renamed from: g  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, PointF> f1478g;

    /* renamed from: h  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1479h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1480i;

    /* renamed from: j  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1481j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1482k;

    /* renamed from: l  reason: collision with root package name */
    private final BaseKeyframeAnimation<?, Float> f1483l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1485n;

    /* renamed from: a  reason: collision with root package name */
    private final Path f1472a = new Path();

    /* renamed from: m  reason: collision with root package name */
    private CompoundTrimPathContent f1484m = new CompoundTrimPathContent();

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1486a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f1486a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1486a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.f1474c = lottieDrawable;
        this.f1473b = polystarShape.getName();
        PolystarShape.Type type = polystarShape.getType();
        this.f1475d = type;
        this.f1476e = polystarShape.isHidden();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.getPoints().createAnimation();
        this.f1477f = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.getPosition().createAnimation();
        this.f1478g = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.getRotation().createAnimation();
        this.f1479h = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.f1481j = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.f1483l = createAnimation5;
        PolystarShape.Type type2 = PolystarShape.Type.STAR;
        if (type == type2) {
            this.f1480i = polystarShape.getInnerRadius().createAnimation();
            this.f1482k = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.f1480i = null;
            this.f1482k = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type == type2) {
            baseLayer.addAnimation(this.f1480i);
            baseLayer.addAnimation(this.f1482k);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type == type2) {
            this.f1480i.addUpdateListener(this);
            this.f1482k.addUpdateListener(this);
        }
    }

    private void a() {
        double floatValue;
        int i4;
        double d4;
        double d5;
        double d6;
        int floor = (int) Math.floor(this.f1477f.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1479h;
        if (baseKeyframeAnimation == null) {
            floatValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d7 = floor;
        float floatValue2 = this.f1483l.getValue().floatValue() / 100.0f;
        float floatValue3 = this.f1481j.getValue().floatValue();
        double d8 = floatValue3;
        float cos = (float) (Math.cos(radians) * d8);
        float sin = (float) (Math.sin(radians) * d8);
        this.f1472a.moveTo(cos, sin);
        double d9 = (float) (6.283185307179586d / d7);
        double d10 = radians + d9;
        double ceil = Math.ceil(d7);
        int i5 = 0;
        while (i5 < ceil) {
            float cos2 = (float) (Math.cos(d10) * d8);
            double d11 = ceil;
            float sin2 = (float) (d8 * Math.sin(d10));
            if (floatValue2 != 0.0f) {
                d5 = d8;
                i4 = i5;
                d4 = d10;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d6 = d9;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f4 = floatValue3 * floatValue2 * 0.25f;
                this.f1472a.cubicTo(cos - (cos3 * f4), sin - (((float) Math.sin(atan2)) * f4), cos2 + (((float) Math.cos(atan22)) * f4), sin2 + (f4 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i4 = i5;
                d4 = d10;
                d5 = d8;
                d6 = d9;
                this.f1472a.lineTo(cos2, sin2);
            }
            d10 = d4 + d6;
            i5 = i4 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d11;
            d8 = d5;
            d9 = d6;
        }
        PointF value = this.f1478g.getValue();
        this.f1472a.offset(value.x, value.y);
        this.f1472a.close();
    }

    private void b() {
        double floatValue;
        float f4;
        float f5;
        int i4;
        float f6;
        float f7;
        double d4;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        double d5;
        float f13;
        float f14;
        float f15;
        double d6;
        float f16;
        float f17;
        float f18;
        float f19;
        float floatValue2 = this.f1477f.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f1479h;
        if (baseKeyframeAnimation == null) {
            floatValue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            floatValue = baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(floatValue - 90.0d);
        double d7 = floatValue2;
        float f20 = (float) (6.283185307179586d / d7);
        float f21 = f20 / 2.0f;
        float f22 = floatValue2 - ((int) floatValue2);
        int i5 = (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1));
        if (i5 != 0) {
            radians += (1.0f - f22) * f21;
        }
        float floatValue3 = this.f1481j.getValue().floatValue();
        float floatValue4 = this.f1480i.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f1482k;
        if (baseKeyframeAnimation2 != null) {
            f4 = baseKeyframeAnimation2.getValue().floatValue() / 100.0f;
        } else {
            f4 = 0.0f;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f1483l;
        if (baseKeyframeAnimation3 != null) {
            f5 = baseKeyframeAnimation3.getValue().floatValue() / 100.0f;
        } else {
            f5 = 0.0f;
        }
        if (i5 != 0) {
            f9 = ((floatValue3 - floatValue4) * f22) + floatValue4;
            i4 = i5;
            double d8 = f9;
            float cos = (float) (d8 * Math.cos(radians));
            f8 = (float) (d8 * Math.sin(radians));
            this.f1472a.moveTo(cos, f8);
            d4 = radians + ((f20 * f22) / 2.0f);
            f6 = cos;
            f7 = f21;
        } else {
            i4 = i5;
            double d9 = floatValue3;
            float cos2 = (float) (Math.cos(radians) * d9);
            float sin = (float) (d9 * Math.sin(radians));
            this.f1472a.moveTo(cos2, sin);
            f6 = cos2;
            f7 = f21;
            d4 = radians + f7;
            f8 = sin;
            f9 = 0.0f;
        }
        double ceil = Math.ceil(d7) * 2.0d;
        int i6 = 0;
        float f23 = f7;
        float f24 = f6;
        boolean z3 = false;
        while (true) {
            double d10 = i6;
            if (d10 < ceil) {
                if (z3) {
                    f10 = floatValue3;
                } else {
                    f10 = floatValue4;
                }
                int i7 = (f9 > 0.0f ? 1 : (f9 == 0.0f ? 0 : -1));
                if (i7 != 0 && d10 == ceil - 2.0d) {
                    f11 = f20;
                    f12 = (f20 * f22) / 2.0f;
                } else {
                    f11 = f20;
                    f12 = f23;
                }
                if (i7 != 0 && d10 == ceil - 1.0d) {
                    d5 = d10;
                    f13 = f9;
                } else {
                    d5 = d10;
                    f13 = f9;
                    f9 = f10;
                }
                double d11 = f9;
                double d12 = ceil;
                float cos3 = (float) (d11 * Math.cos(d4));
                float sin2 = (float) (d11 * Math.sin(d4));
                if (f4 == 0.0f && f5 == 0.0f) {
                    this.f1472a.lineTo(cos3, sin2);
                    d6 = d4;
                    f14 = f4;
                    f15 = f5;
                } else {
                    f14 = f4;
                    double atan2 = (float) (Math.atan2(f8, f24) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f15 = f5;
                    d6 = d4;
                    double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z3) {
                        f16 = f14;
                    } else {
                        f16 = f15;
                    }
                    if (z3) {
                        f17 = f15;
                    } else {
                        f17 = f14;
                    }
                    if (z3) {
                        f18 = floatValue4;
                    } else {
                        f18 = floatValue3;
                    }
                    if (z3) {
                        f19 = floatValue3;
                    } else {
                        f19 = floatValue4;
                    }
                    float f25 = f18 * f16 * 0.47829f;
                    float f26 = cos4 * f25;
                    float f27 = f25 * sin3;
                    float f28 = f19 * f17 * 0.47829f;
                    float f29 = cos5 * f28;
                    float f30 = f28 * sin4;
                    if (i4 != 0) {
                        if (i6 == 0) {
                            f26 *= f22;
                            f27 *= f22;
                        } else if (d5 == d12 - 1.0d) {
                            f29 *= f22;
                            f30 *= f22;
                        }
                    }
                    this.f1472a.cubicTo(f24 - f26, f8 - f27, cos3 + f29, sin2 + f30, cos3, sin2);
                }
                d4 = d6 + f12;
                z3 = !z3;
                i6++;
                f24 = cos3;
                f8 = sin2;
                f5 = f15;
                f4 = f14;
                f9 = f13;
                f20 = f11;
                ceil = d12;
            } else {
                PointF value = this.f1478g.getValue();
                this.f1472a.offset(value.x, value.y);
                this.f1472a.close();
                return;
            }
        }
    }

    private void c() {
        this.f1485n = false;
        this.f1474c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public <T> void addValueCallback(T t3, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t3 == LottieProperty.POLYSTAR_POINTS) {
            this.f1477f.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POLYSTAR_ROTATION) {
            this.f1479h.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POSITION) {
            this.f1478g.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.f1480i) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.f1481j.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.f1482k) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t3 == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.f1483l.setValueCallback(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1473b;
    }

    @Override // com.airbnb.lottie.animation.content.b
    public Path getPath() {
        if (this.f1485n) {
            return this.f1472a;
        }
        this.f1472a.reset();
        if (this.f1476e) {
            this.f1485n = true;
            return this.f1472a;
        }
        int i4 = a.f1486a[this.f1475d.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                a();
            }
        } else {
            b();
        }
        this.f1472a.close();
        this.f1484m.apply(this.f1472a);
        this.f1485n = true;
        return this.f1472a;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public void onValueChanged() {
        c();
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i4, list, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            Content content = list.get(i4);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.b() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f1484m.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
