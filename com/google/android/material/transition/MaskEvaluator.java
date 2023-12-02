package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.MaterialContainerTransform;

/* loaded from: classes5.dex */
class MaskEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private final Path f24895a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f24896b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f24897c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeAppearancePathProvider f24898d = ShapeAppearancePathProvider.getInstance();

    /* renamed from: e  reason: collision with root package name */
    private ShapeAppearanceModel f24899e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f24895a);
            return;
        }
        canvas.clipPath(this.f24896b);
        canvas.clipPath(this.f24897c, Region.Op.UNION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f4, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel n4 = TransitionUtils.n(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f4);
        this.f24899e = n4;
        this.f24898d.calculatePath(n4, 1.0f, rectF2, this.f24896b);
        this.f24898d.calculatePath(this.f24899e, 1.0f, rectF3, this.f24897c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f24895a.op(this.f24896b, this.f24897c, Path.Op.UNION);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeAppearanceModel c() {
        return this.f24899e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path d() {
        return this.f24895a;
    }
}
