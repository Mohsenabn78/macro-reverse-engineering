package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.OrientationTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: OrientationTriggerInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class OrientationTriggerInfo extends TriggerInfo {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final OrientationTriggerInfo f15022j = new OrientationTriggerInfo();
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f15023g = R.string.trigger_orientation;

    /* renamed from: h  reason: collision with root package name */
    private final int f15024h = R.drawable.ic_phone_rotate_landscape_white_24dp;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f15025i = R.string.trigger_orientation_help;

    @NotNull
    public static final OrientationTriggerInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new OrientationTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f15025i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f15024h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f15023g;
    }

    /* compiled from: OrientationTriggerInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OrientationTriggerInfo getInstance() {
            return OrientationTriggerInfo.f15022j;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
