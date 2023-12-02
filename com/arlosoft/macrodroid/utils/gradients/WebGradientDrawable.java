package com.arlosoft.macrodroid.utils.gradients;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebGradientDrawable.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class WebGradientDrawable extends Drawable {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f16115a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ShapeDrawable f16116b;

    public WebGradientDrawable(@NotNull String name, @NotNull ShapeDrawable.ShaderFactory shaderFactory) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(shaderFactory, "shaderFactory");
        this.f16115a = name;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        this.f16116b = shapeDrawable;
        shapeDrawable.setShape(new RectShape());
        shapeDrawable.setShaderFactory(shaderFactory);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.f16116b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.Callback getCallback() {
        return this.f16116b.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Drawable.ConstantState getConstantState() {
        return this.f16116b.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    @NotNull
    public Drawable getCurrent() {
        return this.f16116b;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    @NotNull
    public Rect getDirtyBounds() {
        Rect dirtyBounds = this.f16116b.getDirtyBounds();
        Intrinsics.checkNotNullExpressionValue(dirtyBounds, "delegate.dirtyBounds");
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f16116b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f16116b.getMinimumWidth();
    }

    @NotNull
    public final String getName() {
        return this.f16115a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f16116b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NotNull Rect padding) {
        Intrinsics.checkNotNullParameter(padding, "padding");
        return this.f16116b.getPadding(padding);
    }

    @NotNull
    public final Shape getShape() {
        Shape shape = this.f16116b.getShape();
        Intrinsics.checkNotNullExpressionValue(shape, "delegate.shape");
        return shape;
    }

    @Override // android.graphics.drawable.Drawable
    @Nullable
    public Region getTransparentRegion() {
        return this.f16116b.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(19)
    public boolean isAutoMirrored() {
        return this.f16116b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f16116b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    @NotNull
    public Drawable mutate() {
        Drawable mutate = this.f16116b.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate, "delegate.mutate()");
        return mutate;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f16116b.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i4, int i5, int i6, int i7) {
        this.f16116b.setBounds(i4, i5, i6, i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i4) {
        this.f16116b.setChangingConfigurations(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f16116b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f16116b.setFilterBitmap(z3);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f4, float f5) {
        this.f16116b.setHotspot(f4, f5);
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspotBounds(int i4, int i5, int i6, int i7) {
        this.f16116b.setHotspotBounds(i4, i5, i6, i7);
    }

    public final void setShape(@NotNull Shape value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f16116b.setShape(value);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(@NotNull int[] stateSet) {
        Intrinsics.checkNotNullParameter(stateSet, "stateSet");
        return this.f16116b.setState(stateSet);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        return this.f16116b.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        this.f16116b.setBounds(bounds);
    }
}
