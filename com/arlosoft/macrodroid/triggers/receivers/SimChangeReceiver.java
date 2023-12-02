package com.arlosoft.macrodroid.triggers.receivers;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.SimChangeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SimChangeReceiver.kt */
@StabilityInferred(parameters = 0)
@TargetApi(21)
/* loaded from: classes3.dex */
public final class SimChangeReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15354a;

    /* compiled from: SimChangeReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void resetIgnoredState() {
            SimChangeReceiver.f15354a = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!f15354a) {
            f15354a = true;
            return;
        }
        String stringExtra = intent.getStringExtra("ss");
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof SimChangeTrigger) {
                        SimChangeTrigger simChangeTrigger = (SimChangeTrigger) next;
                        if ((simChangeTrigger.getTriggerOption() == 0 && Intrinsics.areEqual(stringExtra, "READY")) || (simChangeTrigger.getTriggerOption() == 1 && Intrinsics.areEqual(stringExtra, "ABSENT") && next.constraintsMet())) {
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                                macro.setTriggerThatInvoked(next);
                                break;
                            }
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }
}
