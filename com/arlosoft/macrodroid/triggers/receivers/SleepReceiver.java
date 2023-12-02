package com.arlosoft.macrodroid.triggers.receivers;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.SleepTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import com.google.android.gms.location.SleepClassifyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SleepReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SleepReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    @NotNull
    public static final String TAG = "SleepReceiver";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static SleepState f15355a = SleepState.NONE;

    /* compiled from: SleepReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PendingIntent createSleepReceiverPendingIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, SleepReceiver.class), 134217728 | PendingIntentHelper.FLAG_MUTABLE);
            Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(\n          …LAG_MUTABLE\n            )");
            return broadcast;
        }
    }

    /* compiled from: SleepReceiver.kt */
    /* loaded from: classes3.dex */
    public enum SleepState {
        NONE,
        AWAKE,
        ASLEEP,
        UNCERTAIN
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        SleepState sleepState;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList<Macro> arrayList = new ArrayList();
        if (SleepClassifyEvent.hasEvents(intent)) {
            List<SleepClassifyEvent> extractEvents = SleepClassifyEvent.extractEvents(intent);
            Intrinsics.checkNotNullExpressionValue(extractEvents, "extractEvents(intent)");
            Iterator<SleepClassifyEvent> it = extractEvents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SleepClassifyEvent next = it.next();
                if (next.getConfidence() >= Settings.getSleepFallAsleepThreshold(context)) {
                    sleepState = SleepState.ASLEEP;
                } else if (next.getConfidence() <= Settings.getSleepWakeUpThreshold(context)) {
                    sleepState = SleepState.AWAKE;
                } else {
                    sleepState = SleepState.NONE;
                }
                int motion = next.getMotion();
                int light = next.getLight();
                SystemLog.logVerbose("Sleep confidence = {" + next + ".confidence}/100. Motion = " + motion + "/6, light =" + light + "/6 (" + sleepState + ")");
                if (sleepState != f15355a && sleepState != SleepState.UNCERTAIN) {
                    for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                        Iterator<Trigger> it2 = macro.getTriggerListWithAwaitingActions().iterator();
                        while (it2.hasNext()) {
                            Trigger next2 = it2.next();
                            if (next2 instanceof SleepTrigger) {
                                SleepTrigger sleepTrigger = (SleepTrigger) next2;
                                if ((sleepTrigger.triggerOnAwake() && sleepState == SleepState.AWAKE) || (!sleepTrigger.triggerOnAwake() && sleepState == SleepState.ASLEEP)) {
                                    if (next2.constraintsMet()) {
                                        macro.setTriggerThatInvoked(next2);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            Intrinsics.checkNotNullExpressionValue(macro, "macro");
                                            arrayList.add(macro);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    f15355a = sleepState;
                }
            }
        }
        for (Macro macro2 : arrayList) {
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }
}
