package com.arlosoft.macrodroid.freeversion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDroidDisabledEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FreeDaysAlarmReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FreeDaysAlarmReceiver extends BroadcastReceiver {
    public static final int $stable = 8;
    @Inject
    public FreeVersionHelper freeVersionHelper;
    @Inject
    public PremiumStatusHandler premiumStatusHandler;

    public FreeDaysAlarmReceiver() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @NotNull
    public final FreeVersionHelper getFreeVersionHelper() {
        FreeVersionHelper freeVersionHelper = this.freeVersionHelper;
        if (freeVersionHelper != null) {
            return freeVersionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("freeVersionHelper");
        return null;
    }

    @NotNull
    public final PremiumStatusHandler getPremiumStatusHandler() {
        PremiumStatusHandler premiumStatusHandler = this.premiumStatusHandler;
        if (premiumStatusHandler != null) {
            return premiumStatusHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("premiumStatusHandler");
        return null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (!getPremiumStatusHandler().getPremiumStatus().isPro() && getFreeVersionHelper().haveFreeDaysExpired()) {
            SystemLog.logVerbose("Free version has expired");
            getFreeVersionHelper().displayFreeDaysExpiredNotification();
            Settings.setMacroDroidEnabled(context, false);
            Macro.setMacroDroidEnabledState(false);
            MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
            EventBusUtils.getEventBus().post(new MacroDroidDisabledEvent());
        }
    }

    public final void setFreeVersionHelper(@NotNull FreeVersionHelper freeVersionHelper) {
        Intrinsics.checkNotNullParameter(freeVersionHelper, "<set-?>");
        this.freeVersionHelper = freeVersionHelper;
    }

    public final void setPremiumStatusHandler(@NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "<set-?>");
        this.premiumStatusHandler = premiumStatusHandler;
    }
}
