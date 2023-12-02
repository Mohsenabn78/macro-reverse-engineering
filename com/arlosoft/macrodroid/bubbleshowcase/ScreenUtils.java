package com.arlosoft.macrodroid.bubbleshowcase;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ScreenUtils.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ScreenUtils {
    public static final int $stable = 0;
    @NotNull
    public static final ScreenUtils INSTANCE = new ScreenUtils();

    private ScreenUtils() {
    }

    private final ViewGroup a(Activity activity) {
        ViewParent parent = ((ViewGroup) activity.findViewById(16908290)).getParent().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) parent;
    }

    public final int dpToPx(int i4) {
        return Math.round(i4 * (Resources.getSystem().getDisplayMetrics().densityDpi / 160));
    }

    public final int getAxisXpositionOfViewOnScreen(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int[] iArr = new int[2];
        targetView.getLocationOnScreen(iArr);
        return iArr[0];
    }

    public final int getAxisYpositionOfViewOnScreen(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        int[] iArr = new int[2];
        targetView.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public final int getHorizontalScreenOffset(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getScreenWidth(activity) - a(activity).getWidth();
    }

    public final int getScreenHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public final int getScreenWidth(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public final int getStatusBarHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final int getVerticalScreenOffset(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return getScreenHeight(activity) - a(activity).getHeight();
    }

    public final boolean isViewLocatedAtHalfLeftOfTheScreen(@NotNull Activity activity, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (getScreenWidth(activity) / 2 > getAxisXpositionOfViewOnScreen(targetView)) {
            return true;
        }
        return false;
    }

    public final boolean isViewLocatedAtHalfTopOfTheScreen(@NotNull Activity activity, @NotNull View targetView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        if (getScreenHeight(activity) / 2 > getAxisYpositionOfViewOnScreen(targetView)) {
            return true;
        }
        return false;
    }

    public final int pxToDp(int i4) {
        return Math.round(i4 / (Resources.getSystem().getDisplayMetrics().densityDpi / 160));
    }
}
