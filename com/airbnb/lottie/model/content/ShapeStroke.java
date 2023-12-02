package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapeStroke implements ContentModel {

    /* renamed from: a  reason: collision with root package name */
    private final String f1699a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final AnimatableFloatValue f1700b;

    /* renamed from: c  reason: collision with root package name */
    private final List<AnimatableFloatValue> f1701c;

    /* renamed from: d  reason: collision with root package name */
    private final AnimatableColorValue f1702d;

    /* renamed from: e  reason: collision with root package name */
    private final AnimatableIntegerValue f1703e;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatableFloatValue f1704f;

    /* renamed from: g  reason: collision with root package name */
    private final LineCapType f1705g;

    /* renamed from: h  reason: collision with root package name */
    private final LineJoinType f1706h;

    /* renamed from: i  reason: collision with root package name */
    private final float f1707i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1708j;

    /* loaded from: classes2.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i4 = a.f1711a[ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: classes2.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i4 = a.f1712b[ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1711a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f1712b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f1712b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1712b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1712b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f1711a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1711a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1711a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, LineCapType lineCapType, LineJoinType lineJoinType, float f4, boolean z3) {
        this.f1699a = str;
        this.f1700b = animatableFloatValue;
        this.f1701c = list;
        this.f1702d = animatableColorValue;
        this.f1703e = animatableIntegerValue;
        this.f1704f = animatableFloatValue2;
        this.f1705g = lineCapType;
        this.f1706h = lineJoinType;
        this.f1707i = f4;
        this.f1708j = z3;
    }

    public LineCapType getCapType() {
        return this.f1705g;
    }

    public AnimatableColorValue getColor() {
        return this.f1702d;
    }

    public AnimatableFloatValue getDashOffset() {
        return this.f1700b;
    }

    public LineJoinType getJoinType() {
        return this.f1706h;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.f1701c;
    }

    public float getMiterLimit() {
        return this.f1707i;
    }

    public String getName() {
        return this.f1699a;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.f1703e;
    }

    public AnimatableFloatValue getWidth() {
        return this.f1704f;
    }

    public boolean isHidden() {
        return this.f1708j;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new StrokeContent(lottieDrawable, baseLayer, this);
    }
}
