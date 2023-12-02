package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.telephony.TelephonyMonitor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;

/* compiled from: MobileDataUtil.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MobileDataUtil {
    public static final int $stable = 0;
    @NotNull
    public static final MobileDataUtil INSTANCE = new MobileDataUtil();
    @NotNull
    public static final String NETWORK_TYPE_NO_SIM = "no_sim";

    private MobileDataUtil() {
    }

    private final String a(int i4) {
        switch (i4) {
            case 0:
                return TypeDescription.Generic.OfWildcardType.SYMBOL;
            case 1:
                return "GPRS (2.5G)";
            case 2:
                return "EDGE (2.75G)";
            case 3:
            case 5:
            case 6:
            case 12:
                return "3G";
            case 4:
            case 7:
            case 11:
                return "2G";
            case 8:
            case 9:
            case 10:
                return "H (3G+)";
            case 13:
            case 18:
                return "4G";
            case 14:
            case 15:
            case 17:
                return "H+ (3G++)";
            case 16:
                return "GSM";
            case 19:
            default:
                return "4G+";
            case 20:
                return "5G";
        }
    }

    @JvmStatic
    @NotNull
    public static final String getNetworkClass(@NotNull Context context) {
        int dataNetworkType;
        Intrinsics.checkNotNullParameter(context, "context");
        if (TelephonyMonitor.INSTANCE.is5g()) {
            return "5G";
        }
        Object systemService = context.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        if (telephonyManager.getSimState() == 1) {
            return "No Sim";
        }
        if (Build.VERSION.SDK_INT < 24) {
            return INSTANCE.a(telephonyManager.getNetworkType());
        }
        MobileDataUtil mobileDataUtil = INSTANCE;
        dataNetworkType = telephonyManager.getDataNetworkType();
        return mobileDataUtil.a(dataNetworkType);
    }
}
