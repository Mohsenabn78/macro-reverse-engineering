package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.info.IpAddressChangeTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.IpAddressChangeReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IpAddressChangeTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class IpAddressChangeTrigger extends Trigger {
    public static final int $stable = 0;
    @Nullable
    private static IpAddressChangeReceiver s_connectivityChangeTriggerReceiver;
    private static int s_triggerCounter;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final Parcelable.Creator<IpAddressChangeTrigger> CREATOR = new Parcelable.Creator<IpAddressChangeTrigger>() { // from class: com.arlosoft.macrodroid.triggers.IpAddressChangeTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IpAddressChangeTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new IpAddressChangeTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public IpAddressChangeTrigger[] newArray(int i4) {
            return new IpAddressChangeTrigger[i4];
        }
    };
    @NotNull
    private static final IpAddressChangeTrigger$Companion$networkCallback$1 networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.arlosoft.macrodroid.triggers.IpAddressChangeTrigger$Companion$networkCallback$1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(@NotNull Network network, @NotNull LinkProperties linkProperties) {
            Intrinsics.checkNotNullParameter(network, "network");
            Intrinsics.checkNotNullParameter(linkProperties, "linkProperties");
            super.onLinkPropertiesChanged(network, linkProperties);
            ArrayList arrayList = new ArrayList();
            String localIpv4Address = Util.getLocalIpv4Address();
            MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
            String previousIpAddress = Settings.getPreviousIpAddress(companion.getInstance());
            if (!Intrinsics.areEqual(localIpv4Address, TypeDescription.Generic.OfWildcardType.SYMBOL) && !Intrinsics.areEqual(localIpv4Address, previousIpAddress)) {
                Settings.setPreviousIpAddress(companion.getInstance(), localIpv4Address);
                if (previousIpAddress == null) {
                    return;
                }
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Trigger next = it.next();
                            if ((next instanceof IpAddressChangeTrigger) && next.constraintsMet()) {
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
    };

    public /* synthetic */ IpAddressChangeTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    Object systemService = getContext().getSystemService("connectivity");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                    ((ConnectivityManager) systemService).unregisterNetworkCallback(networkCallback);
                } else {
                    MacroDroidApplication.Companion.getInstance().unregisterReceiver(s_connectivityChangeTriggerReceiver);
                }
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_connectivityChangeTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            if (Build.VERSION.SDK_INT >= 24) {
                Object systemService = getContext().getSystemService("connectivity");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
                ((ConnectivityManager) systemService).registerDefaultNetworkCallback(networkCallback);
            } else {
                s_connectivityChangeTriggerReceiver = new IpAddressChangeReceiver();
                MacroDroidApplication.Companion.getInstance().registerReceiver(s_connectivityChangeTriggerReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return IpAddressChangeTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
    }

    public IpAddressChangeTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private IpAddressChangeTrigger() {
    }

    private IpAddressChangeTrigger(Parcel parcel) {
        super(parcel);
    }

    /* compiled from: IpAddressChangeTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
