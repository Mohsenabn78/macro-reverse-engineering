package com.arlosoft.macrodroid.triggers.receivers;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.VpnTrigger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: VpnChangeReceiver.kt */
@StabilityInferred(parameters = 0)
@TargetApi(21)
/* loaded from: classes3.dex */
public final class VpnChangeReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15370a;

    /* compiled from: VpnChangeReceiver.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList arrayList = new ArrayList();
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network[] allNetworks = connectivityManager.getAllNetworks();
        Intrinsics.checkNotNullExpressionValue(allNetworks, "cm.allNetworks");
        int length = allNetworks.length;
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(allNetworks[i4]);
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                z3 = true;
                break;
            }
            i4++;
        }
        if (!f15370a) {
            f15370a = true;
            if (!z3) {
                return;
            }
        }
        if (z3 == Settings.getVpnEnabledState(context)) {
            return;
        }
        Settings.setVpnEnabledState(context, z3);
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof VpnTrigger) && ((VpnTrigger) next).triggerOnEnabled() == z3 && next.constraintsMet()) {
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                            macro.setTriggerThatInvoked(next);
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
