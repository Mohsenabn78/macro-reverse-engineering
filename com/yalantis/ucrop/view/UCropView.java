package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.yalantis.ucrop.R;
import com.yalantis.ucrop.callback.CropBoundsChangeListener;
import com.yalantis.ucrop.callback.OverlayViewChangeListener;

/* loaded from: classes6.dex */
public class UCropView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private GestureCropImageView f38568a;

    /* renamed from: b  reason: collision with root package name */
    private final OverlayView f38569b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements CropBoundsChangeListener {
        a() {
        }

        @Override // com.yalantis.ucrop.callback.CropBoundsChangeListener
        public void onCropAspectRatioChanged(float f4) {
            UCropView.this.f38569b.setTargetAspectRatio(f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements OverlayViewChangeListener {
        b() {
        }

        @Override // com.yalantis.ucrop.callback.OverlayViewChangeListener
        public void onCropRectUpdated(RectF rectF) {
            UCropView.this.f38568a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        this.f38568a.setCropBoundsChangeListener(new a());
        this.f38569b.setOverlayViewChangeListener(new b());
    }

    @NonNull
    public GestureCropImageView getCropImageView() {
        return this.f38568a;
    }

    @NonNull
    public OverlayView getOverlayView() {
        return this.f38569b;
    }

    public void resetCropImageView() {
        removeView(this.f38568a);
        this.f38568a = new GestureCropImageView(getContext());
        c();
        this.f38568a.setCropRect(getOverlayView().getCropViewRect());
        addView(this.f38568a, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        this.f38568a = (GestureCropImageView) findViewById(R.id.image_view_crop);
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.f38569b = overlayView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ucrop_UCropView);
        overlayView.g(obtainStyledAttributes);
        this.f38568a.n(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        c();
    }
}
