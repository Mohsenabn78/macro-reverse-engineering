package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ShapePath {

    /* renamed from: a  reason: collision with root package name */
    private final List<PathOperation> f24288a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<ShadowCompatOperation> f24289b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f24290c;
    @Deprecated
    public float currentShadowAngle;
    @Deprecated
    public float endShadowAngle;
    @Deprecated
    public float endX;
    @Deprecated
    public float endY;
    @Deprecated
    public float startX;
    @Deprecated
    public float startY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class ArcShadowOperation extends ShadowCompatOperation {

        /* renamed from: b  reason: collision with root package name */
        private final PathArcOperation f24294b;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.f24294b = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i4, @NonNull Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(this.f24294b.j(), this.f24294b.n(), this.f24294b.k(), this.f24294b.i()), i4, this.f24294b.l(), this.f24294b.m());
        }
    }

    /* loaded from: classes5.dex */
    static class LineShadowOperation extends ShadowCompatOperation {

        /* renamed from: b  reason: collision with root package name */
        private final PathLineOperation f24295b;

        /* renamed from: c  reason: collision with root package name */
        private final float f24296c;

        /* renamed from: d  reason: collision with root package name */
        private final float f24297d;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f4, float f5) {
            this.f24295b = pathLineOperation;
            this.f24296c = f4;
            this.f24297d = f5;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void a(Matrix matrix, @NonNull ShadowRenderer shadowRenderer, int i4, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f24295b.f24306c - this.f24297d, this.f24295b.f24305b - this.f24296c), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.f24296c, this.f24297d);
            matrix2.preRotate(c());
            shadowRenderer.drawEdgeShadow(canvas, matrix2, rectF, i4);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f24295b.f24306c - this.f24297d) / (this.f24295b.f24305b - this.f24296c)));
        }
    }

    /* loaded from: classes5.dex */
    public static class PathArcOperation extends PathOperation {

        /* renamed from: b  reason: collision with root package name */
        private static final RectF f24298b = new RectF();
        @Deprecated
        public float bottom;
        @Deprecated
        public float left;
        @Deprecated
        public float right;
        @Deprecated
        public float startAngle;
        @Deprecated
        public float sweepAngle;
        @Deprecated
        public float top;

        public PathArcOperation(float f4, float f5, float f6, float f7) {
            p(f4);
            t(f5);
            q(f6);
            o(f7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float i() {
            return this.bottom;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.left;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.right;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.startAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.sweepAngle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.top;
        }

        private void o(float f4) {
            this.bottom = f4;
        }

        private void p(float f4) {
            this.left = f4;
        }

        private void q(float f4) {
            this.right = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(float f4) {
            this.startAngle = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f4) {
            this.sweepAngle = f4;
        }

        private void t(float f4) {
            this.top = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f24307a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f24298b;
            rectF.set(j(), n(), k(), i());
            path.arcTo(rectF, l(), m(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes5.dex */
    public static class PathCubicOperation extends PathOperation {

        /* renamed from: b  reason: collision with root package name */
        private float f24299b;

        /* renamed from: c  reason: collision with root package name */
        private float f24300c;

        /* renamed from: d  reason: collision with root package name */
        private float f24301d;

        /* renamed from: e  reason: collision with root package name */
        private float f24302e;

        /* renamed from: f  reason: collision with root package name */
        private float f24303f;

        /* renamed from: g  reason: collision with root package name */
        private float f24304g;

        public PathCubicOperation(float f4, float f5, float f6, float f7, float f8, float f9) {
            a(f4);
            c(f5);
            b(f6);
            d(f7);
            e(f8);
            f(f9);
        }

        private void a(float f4) {
            this.f24299b = f4;
        }

        private void b(float f4) {
            this.f24301d = f4;
        }

        private void c(float f4) {
            this.f24300c = f4;
        }

        private void d(float f4) {
            this.f24302e = f4;
        }

        private void e(float f4) {
            this.f24303f = f4;
        }

        private void f(float f4) {
            this.f24304g = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f24307a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.f24299b, this.f24300c, this.f24301d, this.f24302e, this.f24303f, this.f24304g);
            path.transform(matrix);
        }
    }

    /* loaded from: classes5.dex */
    public static class PathLineOperation extends PathOperation {

        /* renamed from: b  reason: collision with root package name */
        private float f24305b;

        /* renamed from: c  reason: collision with root package name */
        private float f24306c;

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f24307a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f24305b, this.f24306c);
            path.transform(matrix);
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class PathOperation {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f24307a = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* loaded from: classes5.dex */
    public static class PathQuadOperation extends PathOperation {
        @Deprecated
        public float controlX;
        @Deprecated
        public float controlY;
        @Deprecated
        public float endX;
        @Deprecated
        public float endY;

        private float e() {
            return this.controlX;
        }

        private float f() {
            return this.controlY;
        }

        private float g() {
            return this.endX;
        }

        private float h() {
            return this.endY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(float f4) {
            this.controlX = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(float f4) {
            this.controlY = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(float f4) {
            this.endX = f4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(float f4) {
            this.endY = f4;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f24307a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(e(), f(), g(), h());
            path.transform(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static abstract class ShadowCompatOperation {

        /* renamed from: a  reason: collision with root package name */
        static final Matrix f24308a = new Matrix();

        ShadowCompatOperation() {
        }

        public abstract void a(Matrix matrix, ShadowRenderer shadowRenderer, int i4, Canvas canvas);

        public final void b(ShadowRenderer shadowRenderer, int i4, Canvas canvas) {
            a(f24308a, shadowRenderer, i4, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    private void a(float f4) {
        if (e() == f4) {
            return;
        }
        float e4 = ((f4 - e()) + 360.0f) % 360.0f;
        if (e4 > 180.0f) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(g(), h(), g(), h());
        pathArcOperation.r(e());
        pathArcOperation.s(e4);
        this.f24289b.add(new ArcShadowOperation(pathArcOperation));
        k(f4);
    }

    private void b(ShadowCompatOperation shadowCompatOperation, float f4, float f5) {
        a(f4);
        this.f24289b.add(shadowCompatOperation);
        k(f5);
    }

    private float e() {
        return this.currentShadowAngle;
    }

    private float f() {
        return this.endShadowAngle;
    }

    private void k(float f4) {
        this.currentShadowAngle = f4;
    }

    private void l(float f4) {
        this.endShadowAngle = f4;
    }

    private void m(float f4) {
        this.endX = f4;
    }

    private void n(float f4) {
        this.endY = f4;
    }

    private void o(float f4) {
        this.startX = f4;
    }

    private void p(float f4) {
        this.startY = f4;
    }

    public void addArc(float f4, float f5, float f6, float f7, float f8, float f9) {
        boolean z3;
        float f10;
        PathArcOperation pathArcOperation = new PathArcOperation(f4, f5, f6, f7);
        pathArcOperation.r(f8);
        pathArcOperation.s(f9);
        this.f24288a.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f11 = f8 + f9;
        if (f9 < 0.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            f8 = (f8 + 180.0f) % 360.0f;
        }
        if (z3) {
            f10 = (180.0f + f11) % 360.0f;
        } else {
            f10 = f11;
        }
        b(arcShadowOperation, f8, f10);
        double d4 = f11;
        m(((f4 + f6) * 0.5f) + (((f6 - f4) / 2.0f) * ((float) Math.cos(Math.toRadians(d4)))));
        n(((f5 + f7) * 0.5f) + (((f7 - f5) / 2.0f) * ((float) Math.sin(Math.toRadians(d4)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.f24288a.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.f24288a.get(i4).applyToPath(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f24290c;
    }

    @RequiresApi(21)
    public void cubicToPoint(float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f24288a.add(new PathCubicOperation(f4, f5, f6, f7, f8, f9));
        this.f24290c = true;
        m(f8);
        n(f9);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ShadowCompatOperation d(Matrix matrix) {
        a(f());
        final Matrix matrix2 = new Matrix(matrix);
        final ArrayList arrayList = new ArrayList(this.f24289b);
        return new ShadowCompatOperation() { // from class: com.google.android.material.shape.ShapePath.1
            @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
            public void a(Matrix matrix3, ShadowRenderer shadowRenderer, int i4, Canvas canvas) {
                for (ShadowCompatOperation shadowCompatOperation : arrayList) {
                    shadowCompatOperation.a(matrix2, shadowRenderer, i4, canvas);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.endX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        return this.endY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.startX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.startY;
    }

    public void lineTo(float f4, float f5) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        pathLineOperation.f24305b = f4;
        pathLineOperation.f24306c = f5;
        this.f24288a.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, g(), h());
        b(lineShadowOperation, lineShadowOperation.c() + 270.0f, lineShadowOperation.c() + 270.0f);
        m(f4);
        n(f5);
    }

    @RequiresApi(21)
    public void quadToPoint(float f4, float f5, float f6, float f7) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        pathQuadOperation.i(f4);
        pathQuadOperation.j(f5);
        pathQuadOperation.k(f6);
        pathQuadOperation.l(f7);
        this.f24288a.add(pathQuadOperation);
        this.f24290c = true;
        m(f6);
        n(f7);
    }

    public void reset(float f4, float f5) {
        reset(f4, f5, 270.0f, 0.0f);
    }

    public void reset(float f4, float f5, float f6, float f7) {
        o(f4);
        p(f5);
        m(f4);
        n(f5);
        k(f6);
        l((f6 + f7) % 360.0f);
        this.f24288a.clear();
        this.f24289b.clear();
        this.f24290c = false;
    }

    public ShapePath(float f4, float f5) {
        reset(f4, f5);
    }
}
