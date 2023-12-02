package com.arlosoft.macrodroid.triggers.info;

import android.app.Activity;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.IntentReceivedTrigger;
import com.arlosoft.macrodroid.triggers.TriggerInfo;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IntentReceivedTriggerInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class IntentReceivedTriggerInfo extends TriggerInfo {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final IntentReceivedTriggerInfo f14988j = new IntentReceivedTriggerInfo();

    /* renamed from: g  reason: collision with root package name */
    private final int f14989g = R.string.trigger_intent_received;

    /* renamed from: h  reason: collision with root package name */
    private final int f14990h = R.drawable.ic_cube_send_white_24dp;

    /* renamed from: i  reason: collision with root package name */
    private final int f14991i = R.string.trigger_intent_received_help;

    @NotNull
    public static final IntentReceivedTriggerInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new IntentReceivedTrigger(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f14991i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f14990h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f14989g;
    }

    /* compiled from: IntentReceivedTriggerInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IntentReceivedTriggerInfo getInstance() {
            return IntentReceivedTriggerInfo.f14988j;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
