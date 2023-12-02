package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import com.google.android.material.R;

/* loaded from: classes5.dex */
public class ShapeAppearanceModel {
    public static final CornerSize PILL = new RelativeCornerSize(0.5f);

    /* renamed from: a  reason: collision with root package name */
    CornerTreatment f24246a;

    /* renamed from: b  reason: collision with root package name */
    CornerTreatment f24247b;

    /* renamed from: c  reason: collision with root package name */
    CornerTreatment f24248c;

    /* renamed from: d  reason: collision with root package name */
    CornerTreatment f24249d;

    /* renamed from: e  reason: collision with root package name */
    CornerSize f24250e;

    /* renamed from: f  reason: collision with root package name */
    CornerSize f24251f;

    /* renamed from: g  reason: collision with root package name */
    CornerSize f24252g;

    /* renamed from: h  reason: collision with root package name */
    CornerSize f24253h;

    /* renamed from: i  reason: collision with root package name */
    EdgeTreatment f24254i;

    /* renamed from: j  reason: collision with root package name */
    EdgeTreatment f24255j;

    /* renamed from: k  reason: collision with root package name */
    EdgeTreatment f24256k;

    /* renamed from: l  reason: collision with root package name */
    EdgeTreatment f24257l;

    /* loaded from: classes5.dex */
    public static final class Builder {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private CornerTreatment f24258a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private CornerTreatment f24259b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private CornerTreatment f24260c;
        @NonNull

        /* renamed from: d  reason: collision with root package name */
        private CornerTreatment f24261d;
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        private CornerSize f24262e;
        @NonNull

        /* renamed from: f  reason: collision with root package name */
        private CornerSize f24263f;
        @NonNull

        /* renamed from: g  reason: collision with root package name */
        private CornerSize f24264g;
        @NonNull

        /* renamed from: h  reason: collision with root package name */
        private CornerSize f24265h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        private EdgeTreatment f24266i;
        @NonNull

        /* renamed from: j  reason: collision with root package name */
        private EdgeTreatment f24267j;
        @NonNull

        /* renamed from: k  reason: collision with root package name */
        private EdgeTreatment f24268k;
        @NonNull

        /* renamed from: l  reason: collision with root package name */
        private EdgeTreatment f24269l;

        public Builder() {
            this.f24258a = MaterialShapeUtils.b();
            this.f24259b = MaterialShapeUtils.b();
            this.f24260c = MaterialShapeUtils.b();
            this.f24261d = MaterialShapeUtils.b();
            this.f24262e = new AbsoluteCornerSize(0.0f);
            this.f24263f = new AbsoluteCornerSize(0.0f);
            this.f24264g = new AbsoluteCornerSize(0.0f);
            this.f24265h = new AbsoluteCornerSize(0.0f);
            this.f24266i = MaterialShapeUtils.c();
            this.f24267j = MaterialShapeUtils.c();
            this.f24268k = MaterialShapeUtils.c();
            this.f24269l = MaterialShapeUtils.c();
        }

        private static float m(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).f24245a;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).f24183a;
            }
            return -1.0f;
        }

        @NonNull
        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this);
        }

        @NonNull
        public Builder setAllCornerSizes(@NonNull CornerSize cornerSize) {
            return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setAllCorners(int i4, @Dimension float f4) {
            return setAllCorners(MaterialShapeUtils.a(i4)).setAllCornerSizes(f4);
        }

        @NonNull
        public Builder setAllEdges(@NonNull EdgeTreatment edgeTreatment) {
            return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
        }

        @NonNull
        public Builder setBottomEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.f24268k = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setBottomLeftCorner(int i4, @Dimension float f4) {
            return setBottomLeftCorner(MaterialShapeUtils.a(i4)).setBottomLeftCornerSize(f4);
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@Dimension float f4) {
            this.f24265h = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(int i4, @Dimension float f4) {
            return setBottomRightCorner(MaterialShapeUtils.a(i4)).setBottomRightCornerSize(f4);
        }

        @NonNull
        public Builder setBottomRightCornerSize(@Dimension float f4) {
            this.f24264g = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setLeftEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.f24269l = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setRightEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.f24267j = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setTopEdge(@NonNull EdgeTreatment edgeTreatment) {
            this.f24266i = edgeTreatment;
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(int i4, @Dimension float f4) {
            return setTopLeftCorner(MaterialShapeUtils.a(i4)).setTopLeftCornerSize(f4);
        }

        @NonNull
        public Builder setTopLeftCornerSize(@Dimension float f4) {
            this.f24262e = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(int i4, @Dimension float f4) {
            return setTopRightCorner(MaterialShapeUtils.a(i4)).setTopRightCornerSize(f4);
        }

        @NonNull
        public Builder setTopRightCornerSize(@Dimension float f4) {
            this.f24263f = new AbsoluteCornerSize(f4);
            return this;
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@NonNull CornerSize cornerSize) {
            this.f24265h = cornerSize;
            return this;
        }

        @NonNull
        public Builder setBottomRightCornerSize(@NonNull CornerSize cornerSize) {
            this.f24264g = cornerSize;
            return this;
        }

        @NonNull
        public Builder setTopLeftCornerSize(@NonNull CornerSize cornerSize) {
            this.f24262e = cornerSize;
            return this;
        }

        @NonNull
        public Builder setTopRightCornerSize(@NonNull CornerSize cornerSize) {
            this.f24263f = cornerSize;
            return this;
        }

        @NonNull
        public Builder setAllCorners(@NonNull CornerTreatment cornerTreatment) {
            return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
        }

        @NonNull
        public Builder setBottomLeftCorner(int i4, @NonNull CornerSize cornerSize) {
            return setBottomLeftCorner(MaterialShapeUtils.a(i4)).setBottomLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setBottomRightCorner(int i4, @NonNull CornerSize cornerSize) {
            return setBottomRightCorner(MaterialShapeUtils.a(i4)).setBottomRightCornerSize(cornerSize);
        }

        @NonNull
        public Builder setTopLeftCorner(int i4, @NonNull CornerSize cornerSize) {
            return setTopLeftCorner(MaterialShapeUtils.a(i4)).setTopLeftCornerSize(cornerSize);
        }

        @NonNull
        public Builder setTopRightCorner(int i4, @NonNull CornerSize cornerSize) {
            return setTopRightCorner(MaterialShapeUtils.a(i4)).setTopRightCornerSize(cornerSize);
        }

        @NonNull
        public Builder setAllCornerSizes(@Dimension float f4) {
            return setTopLeftCornerSize(f4).setTopRightCornerSize(f4).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f4);
        }

        @NonNull
        public Builder setBottomLeftCorner(@NonNull CornerTreatment cornerTreatment) {
            this.f24261d = cornerTreatment;
            float m4 = m(cornerTreatment);
            if (m4 != -1.0f) {
                setBottomLeftCornerSize(m4);
            }
            return this;
        }

        @NonNull
        public Builder setBottomRightCorner(@NonNull CornerTreatment cornerTreatment) {
            this.f24260c = cornerTreatment;
            float m4 = m(cornerTreatment);
            if (m4 != -1.0f) {
                setBottomRightCornerSize(m4);
            }
            return this;
        }

        @NonNull
        public Builder setTopLeftCorner(@NonNull CornerTreatment cornerTreatment) {
            this.f24258a = cornerTreatment;
            float m4 = m(cornerTreatment);
            if (m4 != -1.0f) {
                setTopLeftCornerSize(m4);
            }
            return this;
        }

        @NonNull
        public Builder setTopRightCorner(@NonNull CornerTreatment cornerTreatment) {
            this.f24259b = cornerTreatment;
            float m4 = m(cornerTreatment);
            if (m4 != -1.0f) {
                setTopRightCornerSize(m4);
            }
            return this;
        }

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
            this.f24258a = MaterialShapeUtils.b();
            this.f24259b = MaterialShapeUtils.b();
            this.f24260c = MaterialShapeUtils.b();
            this.f24261d = MaterialShapeUtils.b();
            this.f24262e = new AbsoluteCornerSize(0.0f);
            this.f24263f = new AbsoluteCornerSize(0.0f);
            this.f24264g = new AbsoluteCornerSize(0.0f);
            this.f24265h = new AbsoluteCornerSize(0.0f);
            this.f24266i = MaterialShapeUtils.c();
            this.f24267j = MaterialShapeUtils.c();
            this.f24268k = MaterialShapeUtils.c();
            this.f24269l = MaterialShapeUtils.c();
            this.f24258a = shapeAppearanceModel.f24246a;
            this.f24259b = shapeAppearanceModel.f24247b;
            this.f24260c = shapeAppearanceModel.f24248c;
            this.f24261d = shapeAppearanceModel.f24249d;
            this.f24262e = shapeAppearanceModel.f24250e;
            this.f24263f = shapeAppearanceModel.f24251f;
            this.f24264g = shapeAppearanceModel.f24252g;
            this.f24265h = shapeAppearanceModel.f24253h;
            this.f24266i = shapeAppearanceModel.f24254i;
            this.f24267j = shapeAppearanceModel.f24255j;
            this.f24268k = shapeAppearanceModel.f24256k;
            this.f24269l = shapeAppearanceModel.f24257l;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize);
    }

    @NonNull
    private static Builder a(Context context, @StyleRes int i4, @StyleRes int i5, int i6) {
        return b(context, i4, i5, new AbsoluteCornerSize(i6));
    }

    @NonNull
    private static Builder b(Context context, @StyleRes int i4, @StyleRes int i5, @NonNull CornerSize cornerSize) {
        if (i5 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i4);
            i4 = i5;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i4, R.styleable.ShapeAppearance);
        try {
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i6);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i6);
            int i9 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i6);
            int i10 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i6);
            CornerSize c4 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cornerSize);
            CornerSize c5 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, c4);
            CornerSize c6 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, c4);
            CornerSize c7 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, c4);
            return new Builder().setTopLeftCorner(i7, c5).setTopRightCorner(i8, c6).setBottomRightCorner(i9, c7).setBottomLeftCorner(i10, c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, c4));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    private static CornerSize c(TypedArray typedArray, int i4, @NonNull CornerSize cornerSize) {
        TypedValue peekValue = typedArray.peekValue(i4);
        if (peekValue == null) {
            return cornerSize;
        }
        int i5 = peekValue.type;
        if (i5 == 5) {
            return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i5 == 6) {
            return new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f));
        }
        return cornerSize;
    }

    @NonNull
    public EdgeTreatment getBottomEdge() {
        return this.f24256k;
    }

    @NonNull
    public CornerTreatment getBottomLeftCorner() {
        return this.f24249d;
    }

    @NonNull
    public CornerSize getBottomLeftCornerSize() {
        return this.f24253h;
    }

    @NonNull
    public CornerTreatment getBottomRightCorner() {
        return this.f24248c;
    }

    @NonNull
    public CornerSize getBottomRightCornerSize() {
        return this.f24252g;
    }

    @NonNull
    public EdgeTreatment getLeftEdge() {
        return this.f24257l;
    }

    @NonNull
    public EdgeTreatment getRightEdge() {
        return this.f24255j;
    }

    @NonNull
    public EdgeTreatment getTopEdge() {
        return this.f24254i;
    }

    @NonNull
    public CornerTreatment getTopLeftCorner() {
        return this.f24246a;
    }

    @NonNull
    public CornerSize getTopLeftCornerSize() {
        return this.f24250e;
    }

    @NonNull
    public CornerTreatment getTopRightCorner() {
        return this.f24247b;
    }

    @NonNull
    public CornerSize getTopRightCornerSize() {
        return this.f24251f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect(@NonNull RectF rectF) {
        boolean z3;
        boolean z4;
        boolean z5;
        if (this.f24257l.getClass().equals(EdgeTreatment.class) && this.f24255j.getClass().equals(EdgeTreatment.class) && this.f24254i.getClass().equals(EdgeTreatment.class) && this.f24256k.getClass().equals(EdgeTreatment.class)) {
            z3 = true;
        } else {
            z3 = false;
        }
        float cornerSize = this.f24250e.getCornerSize(rectF);
        if (this.f24251f.getCornerSize(rectF) == cornerSize && this.f24253h.getCornerSize(rectF) == cornerSize && this.f24252g.getCornerSize(rectF) == cornerSize) {
            z4 = true;
        } else {
            z4 = false;
        }
        if ((this.f24247b instanceof RoundedCornerTreatment) && (this.f24246a instanceof RoundedCornerTreatment) && (this.f24248c instanceof RoundedCornerTreatment) && (this.f24249d instanceof RoundedCornerTreatment)) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z3 && z4 && z5) {
            return true;
        }
        return false;
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(float f4) {
        return toBuilder().setAllCornerSizes(f4).build();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ShapeAppearanceModel withTransformedCornerSizes(@NonNull CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
    }

    private ShapeAppearanceModel(@NonNull Builder builder) {
        this.f24246a = builder.f24258a;
        this.f24247b = builder.f24259b;
        this.f24248c = builder.f24260c;
        this.f24249d = builder.f24261d;
        this.f24250e = builder.f24262e;
        this.f24251f = builder.f24263f;
        this.f24252g = builder.f24264g;
        this.f24253h = builder.f24265h;
        this.f24254i = builder.f24266i;
        this.f24255j = builder.f24267j;
        this.f24256k = builder.f24268k;
        this.f24257l = builder.f24269l;
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5) {
        return builder(context, attributeSet, i4, i5, 0);
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(@NonNull CornerSize cornerSize) {
        return toBuilder().setAllCornerSizes(cornerSize).build();
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5, int i6) {
        return builder(context, attributeSet, i4, i5, new AbsoluteCornerSize(i6));
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i4, @StyleRes int i5, @NonNull CornerSize cornerSize) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i4, i5);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return b(context, resourceId, resourceId2, cornerSize);
    }

    @NonNull
    public static Builder builder(Context context, @StyleRes int i4, @StyleRes int i5) {
        return a(context, i4, i5, 0);
    }

    public ShapeAppearanceModel() {
        this.f24246a = MaterialShapeUtils.b();
        this.f24247b = MaterialShapeUtils.b();
        this.f24248c = MaterialShapeUtils.b();
        this.f24249d = MaterialShapeUtils.b();
        this.f24250e = new AbsoluteCornerSize(0.0f);
        this.f24251f = new AbsoluteCornerSize(0.0f);
        this.f24252g = new AbsoluteCornerSize(0.0f);
        this.f24253h = new AbsoluteCornerSize(0.0f);
        this.f24254i = MaterialShapeUtils.c();
        this.f24255j = MaterialShapeUtils.c();
        this.f24256k = MaterialShapeUtils.c();
        this.f24257l = MaterialShapeUtils.c();
    }
}
