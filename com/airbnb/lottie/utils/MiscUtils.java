package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* loaded from: classes2.dex */
public class MiscUtils {

    /* renamed from: a  reason: collision with root package name */
    private static PointF f1866a = new PointF();

    private static int a(int i4, int i5) {
        boolean z3;
        int i6 = i4 / i5;
        if ((i4 ^ i5) >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i7 = i4 % i5;
        if (!z3 && i7 != 0) {
            return i6 - 1;
        }
        return i6;
    }

    public static PointF addPoints(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(float f4, float f5) {
        return c((int) f4, (int) f5);
    }

    private static int c(int i4, int i5) {
        return i4 - (i5 * a(i4, i5));
    }

    public static int clamp(int i4, int i5, int i6) {
        return Math.max(i5, Math.min(i6, i4));
    }

    public static boolean contains(float f4, float f5, float f6) {
        if (f4 >= f5 && f4 <= f6) {
            return true;
        }
        return false;
    }

    public static void getPathFromData(ShapeData shapeData, Path path) {
        path.reset();
        PointF initialPoint = shapeData.getInitialPoint();
        path.moveTo(initialPoint.x, initialPoint.y);
        f1866a.set(initialPoint.x, initialPoint.y);
        for (int i4 = 0; i4 < shapeData.getCurves().size(); i4++) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(i4);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            if (controlPoint1.equals(f1866a) && controlPoint2.equals(vertex)) {
                path.lineTo(vertex.x, vertex.y);
            } else {
                path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, vertex.x, vertex.y);
            }
            f1866a.set(vertex.x, vertex.y);
        }
        if (shapeData.isClosed()) {
            path.close();
        }
    }

    public static double lerp(double d4, double d5, @FloatRange(from = 0.0d, to = 1.0d) double d6) {
        return d4 + (d6 * (d5 - d4));
    }

    public static void resolveKeyPath(KeyPath keyPath, int i4, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.fullyResolvesTo(keyPathElementContent.getName(), i4)) {
            list.add(keyPath2.addKey(keyPathElementContent.getName()).resolve(keyPathElementContent));
        }
    }

    public static float clamp(float f4, float f5, float f6) {
        return Math.max(f5, Math.min(f6, f4));
    }

    public static float lerp(float f4, float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return f4 + (f6 * (f5 - f4));
    }

    public static double clamp(double d4, double d5, double d6) {
        return Math.max(d5, Math.min(d6, d4));
    }

    public static int lerp(int i4, int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        return (int) (i4 + (f4 * (i5 - i4)));
    }
}
