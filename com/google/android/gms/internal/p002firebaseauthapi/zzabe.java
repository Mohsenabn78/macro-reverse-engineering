package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.arlosoft.macrodroid.common.Util;
import com.google.android.gms.common.internal.LibraryVersion;
import java.util.List;
import kotlin.time.DurationKt;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabe  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzabe {
    private final int zza;

    public zzabe(String str) {
        int i4 = -1;
        try {
            List zzd = zzab.zzc("[.-]").zzd(str);
            if (zzd.size() == 1) {
                i4 = Integer.parseInt(str);
                str = str;
            } else {
                str = str;
                if (zzd.size() >= 3) {
                    int parseInt = (Integer.parseInt((String) zzd.get(0)) * DurationKt.NANOS_IN_MILLIS) + (Integer.parseInt((String) zzd.get(1)) * 1000);
                    int parseInt2 = Integer.parseInt((String) zzd.get(2));
                    i4 = parseInt + parseInt2;
                    str = parseInt2;
                }
            }
        } catch (IllegalArgumentException e4) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                String.format("Version code parsing failed for: %s with exception %s.", str, e4);
            }
        }
        this.zza = i4;
    }

    public static zzabe zza() {
        String version = LibraryVersion.getInstance().getVersion("firebase-auth");
        if (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) {
            version = Util.ANY_CONTACT_ID;
        }
        return new zzabe(version);
    }

    public final String zzb() {
        return String.format("X%s", Integer.toString(this.zza));
    }
}
