package com.google.android.material.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.PathParser;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Transition;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes5.dex */
class TransitionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final RectF f24995a = new RectF();

    /* loaded from: classes5.dex */
    interface CanvasOperation {
        void a(Canvas canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize a(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2);
    }

    private TransitionUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(@NonNull RectF rectF) {
        return rectF.width() * rectF.height();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeAppearanceModel b(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.TransitionUtils.1
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            @NonNull
            public CornerSize apply(@NonNull CornerSize cornerSize) {
                if (!(cornerSize instanceof RelativeCornerSize)) {
                    return new RelativeCornerSize(cornerSize.getCornerSize(rectF) / rectF.height());
                }
                return cornerSize;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader c(@ColorInt int i4) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i4, i4, Shader.TileMode.CLAMP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <T> T d(@Nullable T t3, @NonNull T t4) {
        if (t3 == null) {
            return t4;
        }
        return t3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View e(View view, @IdRes int i4) {
        String resourceName = view.getResources().getResourceName(i4);
        while (view != null) {
            if (view.getId() == i4) {
                return view;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View f(View view, @IdRes int i4) {
        View findViewById = view.findViewById(i4);
        if (findViewById != null) {
            return findViewById;
        }
        return e(view, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF g(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i4 = iArr[0];
        int i5 = iArr[1];
        return new RectF(i4, i5, view.getWidth() + i4, view.getHeight() + i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF h(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean i(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float j(float f4, float f5, float f6) {
        return f4 + (f6 * (f5 - f4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float k(float f4, float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @FloatRange(from = 0.0d, to = 1.0d) float f8) {
        return l(f4, f5, f6, f7, f8, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float l(float f4, float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6, @FloatRange(from = 0.0d, to = 1.0d) float f7, @FloatRange(from = 0.0d) float f8, boolean z3) {
        if (z3 && (f8 < 0.0f || f8 > 1.0f)) {
            return j(f4, f5, f8);
        }
        if (f8 < f6) {
            return f4;
        }
        if (f8 > f7) {
            return f5;
        }
        return j(f4, f5, (f8 - f6) / (f7 - f6));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i4, int i5, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        if (f6 < f4) {
            return i4;
        }
        if (f6 > f5) {
            return i5;
        }
        return (int) j(i4, i5, (f6 - f4) / (f5 - f4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeAppearanceModel n(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, final RectF rectF, final RectF rectF2, @FloatRange(from = 0.0d, to = 1.0d) final float f4, @FloatRange(from = 0.0d, to = 1.0d) final float f5, @FloatRange(from = 0.0d, to = 1.0d) final float f6) {
        if (f6 < f4) {
            return shapeAppearanceModel;
        }
        if (f6 > f5) {
            return shapeAppearanceModel2;
        }
        return u(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.TransitionUtils.2
            @Override // com.google.android.material.transition.TransitionUtils.CornerSizeBinaryOperator
            @NonNull
            public CornerSize a(@NonNull CornerSize cornerSize, @NonNull CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.k(cornerSize.getCornerSize(rectF), cornerSize2.getCornerSize(rectF2), f4, f5, f6));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o(Transition transition, Context context, @AttrRes int i4) {
        int resolveThemeDuration;
        if (i4 != 0 && transition.getDuration() == -1 && (resolveThemeDuration = MotionUtils.resolveThemeDuration(context, i4, -1)) != -1) {
            transition.setDuration(resolveThemeDuration);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean p(Transition transition, Context context, @AttrRes int i4, TimeInterpolator timeInterpolator) {
        if (i4 != 0 && transition.getInterpolator() == null) {
            transition.setInterpolator(MotionUtils.resolveThemeInterpolator(context, i4, timeInterpolator));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q(Transition transition, Context context, @AttrRes int i4) {
        PathMotion r4;
        if (i4 != 0 && (r4 = r(context, i4)) != null) {
            transition.setPathMotion(r4);
            return true;
        }
        return false;
    }

    @Nullable
    static PathMotion r(Context context, @AttrRes int i4) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i4, typedValue, true)) {
            return null;
        }
        int i5 = typedValue.type;
        if (i5 == 16) {
            int i6 = typedValue.data;
            if (i6 == 0) {
                return null;
            }
            if (i6 == 1) {
                return new MaterialArcMotion();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i6);
        } else if (i5 == 3) {
            return new PatternPathMotion(PathParser.createPathFromPathData(String.valueOf(typedValue.string)));
        } else {
            throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
        }
    }

    private static int s(Canvas canvas, Rect rect, int i4) {
        RectF rectF = f24995a;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void t(Canvas canvas, Rect rect, float f4, float f5, float f6, int i4, CanvasOperation canvasOperation) {
        if (i4 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f4, f5);
        canvas.scale(f6, f6);
        if (i4 < 255) {
            s(canvas, rect, i4);
        }
        canvasOperation.a(canvas);
        canvas.restoreToCount(save);
    }

    static ShapeAppearanceModel u(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        ShapeAppearanceModel shapeAppearanceModel3;
        if (i(shapeAppearanceModel, rectF)) {
            shapeAppearanceModel3 = shapeAppearanceModel;
        } else {
            shapeAppearanceModel3 = shapeAppearanceModel2;
        }
        return shapeAppearanceModel3.toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.a(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.a(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.a(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.a(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }
}
