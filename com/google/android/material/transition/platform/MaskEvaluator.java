package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.platform.MaterialContainerTransform;

@RequiresApi(21)
/* loaded from: classes5.dex */
class MaskEvaluator {

    /* renamed from: a  reason: collision with root package name */
    private final Path f25033a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f25034b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f25035c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final ShapeAppearancePathProvider f25036d = ShapeAppearancePathProvider.getInstance();

    /* renamed from: e  reason: collision with root package name */
    private ShapeAppearanceModel f25037e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.f25033a);
            return;
        }
        canvas.clipPath(this.f25034b);
        canvas.clipPath(this.f25035c, Region.Op.UNION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f4, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel o4 = TransitionUtils.o(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f4);
        this.f25037e = o4;
        this.f25036d.calculatePath(o4, 1.0f, rectF2, this.f25034b);
        this.f25036d.calculatePath(this.f25037e, 1.0f, rectF3, this.f25035c);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f25033a.op(this.f25034b, this.f25035c, Path.Op.UNION);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeAppearanceModel c() {
        return this.f25037e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path d() {
        return this.f25033a;
    }
}
