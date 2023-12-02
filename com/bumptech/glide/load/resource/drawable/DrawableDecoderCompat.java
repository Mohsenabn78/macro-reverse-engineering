package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: classes3.dex */
public final class DrawableDecoderCompat {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f17285a = true;

    private DrawableDecoderCompat() {
    }

    private static Drawable a(Context context, Context context2, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        try {
            if (f17285a) {
                return c(context2, i4, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e4) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return ContextCompat.getDrawable(context2, i4);
            }
            throw e4;
        } catch (NoClassDefFoundError unused2) {
            f17285a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return b(context2, i4, theme);
    }

    private static Drawable b(Context context, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        return ResourcesCompat.getDrawable(context.getResources(), i4, theme);
    }

    private static Drawable c(Context context, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new ContextThemeWrapper(context, theme);
        }
        return AppCompatResources.getDrawable(context, i4);
    }

    public static Drawable getDrawable(Context context, Context context2, @DrawableRes int i4) {
        return a(context, context2, i4, null);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int i4, @Nullable Resources.Theme theme) {
        return a(context, context, i4, theme);
    }
}
