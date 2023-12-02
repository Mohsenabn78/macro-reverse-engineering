package com.araujo.jordan.excuseme.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DesignUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/araujo/jordan/excuseme/utils/DesignUtils;", "", "()V", "Companion", "excuseme_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class DesignUtils {
    public static final Companion Companion = new Companion(null);

    /* compiled from: DesignUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/araujo/jordan/excuseme/utils/DesignUtils$Companion;", "", "()V", "resolveColor", "", "context", "Landroid/content/Context;", TypedValues.Custom.S_COLOR, "", "excuseme_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int resolveColor(@NotNull Context context, @NotNull String color) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(color, "color");
            try {
                Resources resources = context.getResources();
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkExpressionValueIsNotNull(applicationContext, "context.applicationContext");
                ColorStateList colorStateList = AppCompatResources.getColorStateList(context, resources.getIdentifier(color, TypedValues.Custom.S_COLOR, applicationContext.getPackageName()));
                Intrinsics.checkExpressionValueIsNotNull(colorStateList, "AppCompatResources.getCo…      )\n                )");
                return colorStateList.getDefaultColor();
            } catch (Exception unused) {
                return Color.parseColor(color);
            }
        }
    }
}
