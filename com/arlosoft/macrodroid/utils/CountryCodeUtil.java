package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: CountryCodeUtil.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CountryCodeUtil {
    public static final int $stable = 0;
    @NotNull
    public static final CountryCodeUtil INSTANCE = new CountryCodeUtil();

    private CountryCodeUtil() {
    }

    private final String a(Context context) {
        LocaleList locales;
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                locales = context.getResources().getConfiguration().getLocales();
                locale = locales.get(0);
                return locale.getCountry();
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return context.getResources().getConfiguration().locale.getCountry();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: Exception -> 0x0026, TRY_LEAVE, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0001, B:5:0x0014, B:12:0x0021), top: B:17:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String b(android.content.Context r3) {
        /*
            r2 = this;
            r0 = 0
            java.lang.String r1 = "phone"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch: java.lang.Exception -> L26
            java.lang.String r1 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r1)     // Catch: java.lang.Exception -> L26
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch: java.lang.Exception -> L26
            java.lang.String r1 = r3.getNetworkCountryIso()     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L1d
            int r1 = r1.length()     // Catch: java.lang.Exception -> L26
            if (r1 != 0) goto L1b
            goto L1d
        L1b:
            r1 = 0
            goto L1e
        L1d:
            r1 = 1
        L1e:
            if (r1 == 0) goto L21
            return r0
        L21:
            java.lang.String r3 = r3.getNetworkCountryIso()     // Catch: java.lang.Exception -> L26
            return r3
        L26:
            r3 = move-exception
            r3.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.utils.CountryCodeUtil.b(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0021 A[Catch: Exception -> 0x0026, TRY_LEAVE, TryCatch #0 {Exception -> 0x0026, blocks: (B:3:0x0001, B:5:0x0014, B:12:0x0021), top: B:17:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String c(android.content.Context r3) {
        /*
            r2 = this;
            r0 = 0
            java.lang.String r1 = "phone"
            java.lang.Object r3 = r3.getSystemService(r1)     // Catch: java.lang.Exception -> L26
            java.lang.String r1 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r1)     // Catch: java.lang.Exception -> L26
            android.telephony.TelephonyManager r3 = (android.telephony.TelephonyManager) r3     // Catch: java.lang.Exception -> L26
            java.lang.String r1 = r3.getSimCountryIso()     // Catch: java.lang.Exception -> L26
            if (r1 == 0) goto L1d
            int r1 = r1.length()     // Catch: java.lang.Exception -> L26
            if (r1 != 0) goto L1b
            goto L1d
        L1b:
            r1 = 0
            goto L1e
        L1d:
            r1 = 1
        L1e:
            if (r1 == 0) goto L21
            return r0
        L21:
            java.lang.String r3 = r3.getSimCountryIso()     // Catch: java.lang.Exception -> L26
            return r3
        L26:
            r3 = move-exception
            r3.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.utils.CountryCodeUtil.c(android.content.Context):java.lang.String");
    }

    @NotNull
    public final String getDetectedCountry(@NotNull Context context, @NotNull String defaultCountryIsoCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultCountryIsoCode, "defaultCountryIsoCode");
        String c4 = c(context);
        if (c4 == null && (c4 = b(context)) == null) {
            String a4 = a(context);
            if (a4 != null) {
                return a4;
            }
            return defaultCountryIsoCode;
        }
        return c4;
    }
}
