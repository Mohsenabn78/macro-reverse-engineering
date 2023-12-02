package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerInfo;
import com.arlosoft.macrodroid.triggers.VolumeLongPressTrigger;
import java.util.List;
import kotlin.collections.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VolumeLongPressTriggerInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VolumeLongPressTriggerInfo extends TriggerInfo {
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f15082g = R.string.trigger_volume_long_press;

    /* renamed from: h  reason: collision with root package name */
    private final int f15083h = R.drawable.ic_webhook_white_24dp;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f15084i = R.string.trigger_volume_long_press_help;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final List<String> f15085j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f15086k;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final SelectableItemInfo f15081l = new VolumeLongPressTriggerInfo();

    public VolumeLongPressTriggerInfo() {
        List<String> listOf;
        listOf = e.listOf("android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER");
        this.f15085j = listOf;
        this.f15086k = true;
    }

    @NotNull
    public static final SelectableItemInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new VolumeLongPressTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public List<String> getAdbHackPermissionRequired() {
        return this.f15085j;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f15084i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f15083h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f15082g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public boolean isRootOnly() {
        return this.f15086k;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int minSDKVersion() {
        return 26;
    }

    /* compiled from: VolumeLongPressTriggerInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableItemInfo getInstance() {
            return VolumeLongPressTriggerInfo.f15081l;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
