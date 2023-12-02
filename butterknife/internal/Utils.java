package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.UiThread;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class Utils {
    private static final TypedValue VALUE = new TypedValue();

    private Utils() {
        throw new AssertionError("No instances.");
    }

    @SafeVarargs
    public static <T> T[] arrayFilteringNull(T... tArr) {
        int length = tArr.length;
        int i4 = 0;
        for (T t3 : tArr) {
            if (t3 != null) {
                tArr[i4] = t3;
                i4++;
            }
        }
        if (i4 != length) {
            return (T[]) Arrays.copyOf(tArr, i4);
        }
        return tArr;
    }

    public static <T> T castParam(Object obj, String str, int i4, String str2, int i5, Class<T> cls) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException e4) {
            throw new IllegalStateException("Parameter #" + (i4 + 1) + " of method '" + str + "' was of the wrong type for parameter #" + (i5 + 1) + " of method '" + str2 + "'. See cause for more info.", e4);
        }
    }

    public static <T> T castView(View view, @IdRes int i4, String str, Class<T> cls) {
        try {
            return cls.cast(view);
        } catch (ClassCastException e4) {
            String resourceEntryName = getResourceEntryName(view, i4);
            throw new IllegalStateException("View '" + resourceEntryName + "' with ID " + i4 + " for " + str + " was of the wrong type. See cause for more info.", e4);
        }
    }

    public static <T> T findOptionalViewAsType(View view, @IdRes int i4, String str, Class<T> cls) {
        return (T) castView(view.findViewById(i4), i4, str, cls);
    }

    public static View findRequiredView(View view, @IdRes int i4, String str) {
        View findViewById = view.findViewById(i4);
        if (findViewById != null) {
            return findViewById;
        }
        String resourceEntryName = getResourceEntryName(view, i4);
        throw new IllegalStateException("Required view '" + resourceEntryName + "' with ID " + i4 + " for " + str + " was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    }

    public static <T> T findRequiredViewAsType(View view, @IdRes int i4, String str, Class<T> cls) {
        return (T) castView(findRequiredView(view, i4, str), i4, str, cls);
    }

    @UiThread
    public static float getFloat(Context context, @DimenRes int i4) {
        TypedValue typedValue = VALUE;
        context.getResources().getValue(i4, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i4) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    private static String getResourceEntryName(View view, @IdRes int i4) {
        if (view.isInEditMode()) {
            return "<unavailable while editing>";
        }
        return view.getContext().getResources().getResourceEntryName(i4);
    }

    @UiThread
    public static Drawable getTintedDrawable(Context context, @DrawableRes int i4, @AttrRes int i5) {
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = VALUE;
        if (theme.resolveAttribute(i5, typedValue, true)) {
            Drawable wrap = DrawableCompat.wrap(ContextCompat.getDrawable(context, i4).mutate());
            DrawableCompat.setTint(wrap, ContextCompat.getColor(context, typedValue.resourceId));
            return wrap;
        }
        throw new Resources.NotFoundException("Required tint color attribute with name " + context.getResources().getResourceEntryName(i5) + " and attribute ID " + i5 + " was not found.");
    }

    @SafeVarargs
    public static <T> List<T> listFilteringNull(T... tArr) {
        return new ImmutableList(arrayFilteringNull(tArr));
    }
}
