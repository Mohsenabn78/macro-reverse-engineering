package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.LogcatTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;
import java.util.List;
import kotlin.collections.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogcatTriggerInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LogcatTriggerInfo extends TriggerInfo {
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f15000g = R.string.trigger_logcat;

    /* renamed from: h  reason: collision with root package name */
    private final int f15001h = R.drawable.ic_cat;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f15002i = R.string.trigger_logcat_help;

    /* renamed from: j  reason: collision with root package name */
    private final int f15003j = 1;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final List<String> f15004k;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final SelectableItemInfo f14999l = new LogcatTriggerInfo();

    public LogcatTriggerInfo() {
        List<String> listOf;
        listOf = e.listOf("android.permission.READ_LOGS");
        this.f15004k = listOf;
    }

    @NotNull
    public static final SelectableItemInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new LogcatTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public List<String> getAdbHackPermissionRequired() {
        return this.f15004k;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f15002i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f15001h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f15000g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getRootLevel() {
        return this.f15003j;
    }

    /* compiled from: LogcatTriggerInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableItemInfo getInstance() {
            return LogcatTriggerInfo.f14999l;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
