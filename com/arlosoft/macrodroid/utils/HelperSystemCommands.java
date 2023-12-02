package com.arlosoft.macrodroid.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.os.Bundle;
import android.os.Handler;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.utils.HelperSystemCommands;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HelperSystemCommands.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HelperSystemCommands {

    /* renamed from: a  reason: collision with root package name */
    private static int f16042a;
    @NotNull
    public static final HelperSystemCommands INSTANCE = new HelperSystemCommands();
    public static final int $stable = 8;

    /* compiled from: HelperSystemCommands.kt */
    /* loaded from: classes3.dex */
    public interface WifiNetworksHandler {
        void handleResult(@NotNull List<? extends WifiConfiguration> list);
    }

    private HelperSystemCommands() {
    }

    @JvmStatic
    public static final void getWifiNetworks(@NotNull Context context, @NotNull final WifiNetworksHandler wifiNetworksHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wifiNetworksHandler, "wifiNetworksHandler");
        Intent intent = new Intent(HelperCommandsKt.HELPER_COMMAND_INTENT_ACTION);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, INSTANCE.getRequestId());
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_COMMAND_TYPE, HelperCommandsKt.HELPER_COMMAND_GET_WIFI_NETWORKS);
        context.sendOrderedBroadcast(intent, null, new BroadcastReceiver() { // from class: com.arlosoft.macrodroid.utils.HelperSystemCommands$getWifiNetworks$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(@Nullable Context context2, @Nullable Intent intent2) {
                ArrayList arrayList;
                List<? extends WifiConfiguration> emptyList;
                Bundle resultExtras = getResultExtras(true);
                if (resultExtras != null) {
                    arrayList = resultExtras.getParcelableArrayList(HelperCommandsKt.HELPER_RETURN_WIFI_NETWORK_LIST);
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    HelperSystemCommands.WifiNetworksHandler wifiNetworksHandler2 = HelperSystemCommands.WifiNetworksHandler.this;
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        WifiConfiguration wifiConfiguration = (WifiConfiguration) obj;
                        if (hashSet.add(new Pair(wifiConfiguration.SSID, wifiConfiguration.BSSID))) {
                            arrayList2.add(obj);
                        }
                    }
                    wifiNetworksHandler2.handleResult(arrayList2);
                    return;
                }
                HelperSystemCommands.WifiNetworksHandler wifiNetworksHandler3 = HelperSystemCommands.WifiNetworksHandler.this;
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                wifiNetworksHandler3.handleResult(emptyList);
            }
        }, new Handler(), -1, null, null);
    }

    @JvmStatic
    public static final void sendBluetoothRequest(@NotNull Context context, int i4, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(HelperCommandsKt.HELPER_COMMAND_INTENT_ACTION);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, INSTANCE.getRequestId());
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_COMMAND_TYPE, HelperCommandsKt.HELPER_COMMAND_SET_BLUETOOTH);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SET_BLUETOOTH_STATE, i4);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_BLUETOOTH_DEVICE_NAME, str);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_BLUETOOTH_DEVICE_ADDRESS, str2);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendEnableDisableCamera(@NotNull Context context, int i4) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent(HelperCommandsKt.HELPER_COMMAND_INTENT_ACTION);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, INSTANCE.getRequestId());
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_COMMAND_TYPE, HelperCommandsKt.HELPER_COMMAND_SET_CAMERA_ENABLED_STATE);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_SET_CAMERA_VALUE, i4);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final int sendShellScriptCommand(@NotNull Context context, @NotNull String shellScript, int i4, boolean z3, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shellScript, "shellScript");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        int requestId = INSTANCE.getRequestId();
        Intent intent = new Intent(HelperCommandsKt.HELPER_COMMAND_INTENT_ACTION);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, requestId);
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_COMMAND_TYPE, HelperCommandsKt.HELPER_COMMAND_SHELL_SCRIPT);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SHELL_SCRIPT_COMMAND, shellScript);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SHELL_SCRIPT_TIMEOUT_SECONDS, i4);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SHELL_SCRIPT_USE_ROOT, z3);
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_MACRO_NAME, macroName);
        context.sendBroadcast(intent);
        return requestId;
    }

    @JvmStatic
    public static final void sendSystemSetting(@NotNull Context context, @NotNull String settingType, @NotNull String valueType, @NotNull String settingKey, @NotNull String value) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingType, "settingType");
        Intrinsics.checkNotNullParameter(valueType, "valueType");
        Intrinsics.checkNotNullParameter(settingKey, "settingKey");
        Intrinsics.checkNotNullParameter(value, "value");
        Intent intent = new Intent(HelperCommandsKt.HELPER_COMMAND_INTENT_ACTION);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, INSTANCE.getRequestId());
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_COMMAND_TYPE, HelperCommandsKt.HELPER_COMMAND_SET_SYSTEM_SETTING);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SETTING_TYPE, settingType);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SETTING_VALUE_TYPE, valueType);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SETTING_KEY, settingKey);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SETTING_VALUE, value);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendWifiConnectToSSID(@NotNull Context context, @NotNull String ssid, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(ssid, "ssid");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intent intent = new Intent(HelperCommandsKt.HELPER_COMMAND_INTENT_ACTION);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, INSTANCE.getRequestId());
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_COMMAND_TYPE, HelperCommandsKt.HELPER_COMMAND_SET_WIFI);
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_MACRO_NAME, macroName);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, 3);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_NETWORK_SSID, ssid);
        context.sendBroadcast(intent);
    }

    @JvmStatic
    public static final void sendWifiEnableSetEnableState(@NotNull Context context, boolean z3, @NotNull String macroName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intent intent = new Intent(HelperCommandsKt.HELPER_COMMAND_INTENT_ACTION);
        intent.putExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, INSTANCE.getRequestId());
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_COMMAND_TYPE, HelperCommandsKt.HELPER_COMMAND_SET_WIFI);
        intent.putExtra(HelperCommandsKt.HELPER_EXTRA_MACRO_NAME, macroName);
        intent.putExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, z3 ? 1 : 0);
        context.sendBroadcast(intent);
    }

    public final int getRequestId() {
        int i4 = f16042a;
        f16042a = i4 + 1;
        return i4;
    }

    public final int get_requestId() {
        return f16042a;
    }

    public final void set_requestId(int i4) {
        f16042a = i4;
    }
}
