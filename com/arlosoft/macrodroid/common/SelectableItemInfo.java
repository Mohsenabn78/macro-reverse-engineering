package com.arlosoft.macrodroid.common;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SelectableItemInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class SelectableItemInfo {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private final int f10009a = 9999;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10010b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10011c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10012d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f10013e;

    public boolean allowedOnDevice() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= minSDKVersion() && i4 <= maxSDKVersion() && ((!isRootOnly() || supportsAdbHack() || Settings.getRootEnabled(MacroDroidApplication.Companion.getInstance())) && (Settings.areExperimentalFeaturesEnabled(MacroDroidApplication.Companion.getInstance()) || !isExperimental()))) {
            return true;
        }
        return false;
    }

    @NotNull
    public abstract SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro);

    @Nullable
    public List<String> getAdbHackPermissionRequired() {
        return this.f10013e;
    }

    @NotNull
    protected List<Integer> getAdditionalSearchTerms() {
        return new ArrayList();
    }

    @ColorRes
    public abstract int getCategoryColor();

    @StringRes
    public abstract int getHelpInfo();

    @DrawableRes
    public abstract int getIcon();

    @DrawableRes
    public abstract int getIconBgDrawable(boolean z3);

    @ColorRes
    public abstract int getItemColor(boolean z3);

    public abstract int getItemType();

    @StringRes
    public abstract int getName();

    public int getRootLevel() {
        return this.f10009a;
    }

    @NotNull
    public final List<Integer> getSerchTerms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(getName()));
        arrayList.addAll(getAdditionalSearchTerms());
        return arrayList;
    }

    public boolean isBeta() {
        return this.f10012d;
    }

    public boolean isExperimental() {
        return this.f10010b;
    }

    public boolean isProOnly() {
        return this.f10011c;
    }

    public boolean isRootOnly() {
        if (Build.VERSION.SDK_INT >= getRootLevel()) {
            return true;
        }
        return false;
    }

    protected int maxSDKVersion() {
        return Integer.MAX_VALUE;
    }

    public int minSDKVersion() {
        return 1;
    }

    public final boolean supportsAdbHack() {
        if (getAdbHackPermissionRequired() != null) {
            return true;
        }
        return false;
    }
}
