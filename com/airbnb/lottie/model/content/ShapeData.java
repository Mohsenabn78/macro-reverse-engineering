package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ShapeData {

    /* renamed from: a  reason: collision with root package name */
    private final List<CubicCurveData> f1683a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f1684b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1685c;

    public ShapeData(PointF pointF, boolean z3, List<CubicCurveData> list) {
        this.f1684b = pointF;
        this.f1685c = z3;
        this.f1683a = new ArrayList(list);
    }

    private void a(float f4, float f5) {
        if (this.f1684b == null) {
            this.f1684b = new PointF();
        }
        this.f1684b.set(f4, f5);
    }

    public List<CubicCurveData> getCurves() {
        return this.f1683a;
    }

    public PointF getInitialPoint() {
        return this.f1684b;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        boolean z3;
        if (this.f1684b == null) {
            this.f1684b = new PointF();
        }
        if (!shapeData.isClosed() && !shapeData2.isClosed()) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f1685c = z3;
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            Logger.warning("Curves must have the same number of control points. Shape 1: " + shapeData.getCurves().size() + "\tShape 2: " + shapeData2.getCurves().size());
        }
        int min = Math.min(shapeData.getCurves().size(), shapeData2.getCurves().size());
        if (this.f1683a.size() < min) {
            for (int size = this.f1683a.size(); size < min; size++) {
                this.f1683a.add(new CubicCurveData());
            }
        } else if (this.f1683a.size() > min) {
            for (int size2 = this.f1683a.size() - 1; size2 >= min; size2--) {
                List<CubicCurveData> list = this.f1683a;
                list.remove(list.size() - 1);
            }
        }
        PointF initialPoint = shapeData.getInitialPoint();
        PointF initialPoint2 = shapeData2.getInitialPoint();
        a(MiscUtils.lerp(initialPoint.x, initialPoint2.x, f4), MiscUtils.lerp(initialPoint.y, initialPoint2.y, f4));
        for (int size3 = this.f1683a.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.getCurves().get(size3);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF controlPoint12 = cubicCurveData2.getControlPoint1();
            PointF controlPoint22 = cubicCurveData2.getControlPoint2();
            PointF vertex2 = cubicCurveData2.getVertex();
            this.f1683a.get(size3).setControlPoint1(MiscUtils.lerp(controlPoint1.x, controlPoint12.x, f4), MiscUtils.lerp(controlPoint1.y, controlPoint12.y, f4));
            this.f1683a.get(size3).setControlPoint2(MiscUtils.lerp(controlPoint2.x, controlPoint22.x, f4), MiscUtils.lerp(controlPoint2.y, controlPoint22.y, f4));
            this.f1683a.get(size3).setVertex(MiscUtils.lerp(vertex.x, vertex2.x, f4), MiscUtils.lerp(vertex.y, vertex2.y, f4));
        }
    }

    public boolean isClosed() {
        return this.f1685c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f1683a.size() + "closed=" + this.f1685c + '}';
    }

    public ShapeData() {
        this.f1683a = new ArrayList();
    }
}
