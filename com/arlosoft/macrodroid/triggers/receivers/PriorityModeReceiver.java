package com.arlosoft.macrodroid.triggers.receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.PriorityModeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PriorityModeReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PriorityModeReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private static int f15339a = -1;

    /* compiled from: PriorityModeReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getPreviousFilter() {
            return PriorityModeReceiver.f15339a;
        }

        public final void setPreviousFilter(int i4) {
            PriorityModeReceiver.f15339a = i4;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Object obj;
        int currentInterruptionFilter;
        ArrayList<Macro> arrayList = new ArrayList();
        if (context != null) {
            obj = context.getSystemService("notification");
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.app.NotificationManager");
        currentInterruptionFilter = ((NotificationManager) obj).getCurrentInterruptionFilter();
        if (currentInterruptionFilter == f15339a) {
            return;
        }
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof PriorityModeTrigger) && next.constraintsMet(null) && ((PriorityModeTrigger) next).getOption() == currentInterruptionFilter - 1) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            Intrinsics.checkNotNullExpressionValue(macro, "macro");
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        for (Macro macro2 : arrayList) {
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
        f15339a = currentInterruptionFilter;
    }
}
