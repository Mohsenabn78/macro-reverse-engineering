package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.UiThread;

/* loaded from: classes5.dex */
public class ShapeAppearancePathProvider {

    /* renamed from: a  reason: collision with root package name */
    private final ShapePath[] f24270a = new ShapePath[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f24271b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f24272c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f24273d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f24274e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f24275f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final ShapePath f24276g = new ShapePath();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f24277h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f24278i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f24279j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f24280k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f24281l = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class Lazy {

        /* renamed from: a  reason: collision with root package name */
        static final ShapeAppearancePathProvider f24282a = new ShapeAppearancePathProvider();

        private Lazy() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i4);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class ShapeAppearancePathSpec {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final ShapeAppearanceModel f24283a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Path f24284b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final RectF f24285c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final PathListener f24286d;

        /* renamed from: e  reason: collision with root package name */
        public final float f24287e;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, @Nullable PathListener pathListener, Path path) {
            this.f24286d = pathListener;
            this.f24283a = shapeAppearanceModel;
            this.f24287e = f4;
            this.f24285c = rectF;
            this.f24284b = path;
        }
    }

    public ShapeAppearancePathProvider() {
        for (int i4 = 0; i4 < 4; i4++) {
            this.f24270a[i4] = new ShapePath();
            this.f24271b[i4] = new Matrix();
            this.f24272c[i4] = new Matrix();
        }
    }

    private float a(int i4) {
        return (i4 + 1) * 90;
    }

    private void b(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        this.f24277h[0] = this.f24270a[i4].i();
        this.f24277h[1] = this.f24270a[i4].j();
        this.f24271b[i4].mapPoints(this.f24277h);
        if (i4 == 0) {
            Path path = shapeAppearancePathSpec.f24284b;
            float[] fArr = this.f24277h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = shapeAppearancePathSpec.f24284b;
            float[] fArr2 = this.f24277h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f24270a[i4].applyToPath(this.f24271b[i4], shapeAppearancePathSpec.f24284b);
        PathListener pathListener = shapeAppearancePathSpec.f24286d;
        if (pathListener != null) {
            pathListener.onCornerPathCreated(this.f24270a[i4], this.f24271b[i4], i4);
        }
    }

    private void c(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        int i5 = (i4 + 1) % 4;
        this.f24277h[0] = this.f24270a[i4].g();
        this.f24277h[1] = this.f24270a[i4].h();
        this.f24271b[i4].mapPoints(this.f24277h);
        this.f24278i[0] = this.f24270a[i5].i();
        this.f24278i[1] = this.f24270a[i5].j();
        this.f24271b[i5].mapPoints(this.f24278i);
        float[] fArr = this.f24277h;
        float f4 = fArr[0];
        float[] fArr2 = this.f24278i;
        float max = Math.max(((float) Math.hypot(f4 - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
        float g4 = g(shapeAppearancePathSpec.f24285c, i4);
        this.f24276g.reset(0.0f, 0.0f);
        EdgeTreatment h4 = h(i4, shapeAppearancePathSpec.f24283a);
        h4.getEdgePath(max, g4, shapeAppearancePathSpec.f24287e, this.f24276g);
        this.f24279j.reset();
        this.f24276g.applyToPath(this.f24272c[i4], this.f24279j);
        if (this.f24281l && (h4.a() || i(this.f24279j, i4) || i(this.f24279j, i5))) {
            Path path = this.f24279j;
            path.op(path, this.f24275f, Path.Op.DIFFERENCE);
            this.f24277h[0] = this.f24276g.i();
            this.f24277h[1] = this.f24276g.j();
            this.f24272c[i4].mapPoints(this.f24277h);
            Path path2 = this.f24274e;
            float[] fArr3 = this.f24277h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f24276g.applyToPath(this.f24272c[i4], this.f24274e);
        } else {
            this.f24276g.applyToPath(this.f24272c[i4], shapeAppearancePathSpec.f24284b);
        }
        PathListener pathListener = shapeAppearancePathSpec.f24286d;
        if (pathListener != null) {
            pathListener.onEdgePathCreated(this.f24276g, this.f24272c[i4], i4);
        }
    }

    private void d(int i4, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    pointF.set(rectF.right, rectF.top);
                    return;
                } else {
                    pointF.set(rectF.left, rectF.top);
                    return;
                }
            }
            pointF.set(rectF.left, rectF.bottom);
            return;
        }
        pointF.set(rectF.right, rectF.bottom);
    }

    private CornerSize e(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return shapeAppearanceModel.getTopRightCornerSize();
                }
                return shapeAppearanceModel.getTopLeftCornerSize();
            }
            return shapeAppearanceModel.getBottomLeftCornerSize();
        }
        return shapeAppearanceModel.getBottomRightCornerSize();
    }

    private CornerTreatment f(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return shapeAppearanceModel.getTopRightCorner();
                }
                return shapeAppearanceModel.getTopLeftCorner();
            }
            return shapeAppearanceModel.getBottomLeftCorner();
        }
        return shapeAppearanceModel.getBottomRightCorner();
    }

    private float g(@NonNull RectF rectF, int i4) {
        float[] fArr = this.f24277h;
        ShapePath shapePath = this.f24270a[i4];
        fArr[0] = shapePath.endX;
        fArr[1] = shapePath.endY;
        this.f24271b[i4].mapPoints(fArr);
        if (i4 != 1 && i4 != 3) {
            return Math.abs(rectF.centerY() - this.f24277h[1]);
        }
        return Math.abs(rectF.centerX() - this.f24277h[0]);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @UiThread
    public static ShapeAppearancePathProvider getInstance() {
        return Lazy.f24282a;
    }

    private EdgeTreatment h(int i4, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return shapeAppearanceModel.getRightEdge();
                }
                return shapeAppearanceModel.getTopEdge();
            }
            return shapeAppearanceModel.getLeftEdge();
        }
        return shapeAppearanceModel.getBottomEdge();
    }

    @RequiresApi(19)
    private boolean i(Path path, int i4) {
        this.f24280k.reset();
        this.f24270a[i4].applyToPath(this.f24271b[i4], this.f24280k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f24280k.computeBounds(rectF, true);
        path.op(this.f24280k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() > 1.0f && rectF.height() > 1.0f) {
            return true;
        }
        return false;
    }

    private void j(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i4) {
        f(i4, shapeAppearancePathSpec.f24283a).getCornerPath(this.f24270a[i4], 90.0f, shapeAppearancePathSpec.f24287e, shapeAppearancePathSpec.f24285c, e(i4, shapeAppearancePathSpec.f24283a));
        float a4 = a(i4);
        this.f24271b[i4].reset();
        d(i4, shapeAppearancePathSpec.f24285c, this.f24273d);
        Matrix matrix = this.f24271b[i4];
        PointF pointF = this.f24273d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f24271b[i4].preRotate(a4);
    }

    private void l(int i4) {
        this.f24277h[0] = this.f24270a[i4].g();
        this.f24277h[1] = this.f24270a[i4].h();
        this.f24271b[i4].mapPoints(this.f24277h);
        float a4 = a(i4);
        this.f24272c[i4].reset();
        Matrix matrix = this.f24272c[i4];
        float[] fArr = this.f24277h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f24272c[i4].preRotate(a4);
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f4, rectF, null, path);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(boolean z3) {
        this.f24281l = z3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f4, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        this.f24274e.rewind();
        this.f24275f.rewind();
        this.f24275f.addRect(rectF, Path.Direction.CW);
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f4, rectF, pathListener, path);
        for (int i4 = 0; i4 < 4; i4++) {
            j(shapeAppearancePathSpec, i4);
            l(i4);
        }
        for (int i5 = 0; i5 < 4; i5++) {
            b(shapeAppearancePathSpec, i5);
            c(shapeAppearancePathSpec, i5);
        }
        path.close();
        this.f24274e.close();
        if (this.f24274e.isEmpty()) {
            return;
        }
        path.op(this.f24274e, Path.Op.UNION);
    }
}
