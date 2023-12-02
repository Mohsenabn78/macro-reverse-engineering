package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzady;
import com.google.android.gms.internal.p002firebaseauthapi.zzaet;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbc {
    @Nullable
    public static MultiFactorInfo zza(zzady zzadyVar) {
        if (zzadyVar == null) {
            return null;
        }
        if (!TextUtils.isEmpty(zzadyVar.zzf())) {
            return new PhoneMultiFactorInfo(zzadyVar.zze(), zzadyVar.zzd(), zzadyVar.zza(), Preconditions.checkNotEmpty(zzadyVar.zzf()));
        }
        if (zzadyVar.zzc() == null) {
            return null;
        }
        return new TotpMultiFactorInfo(zzadyVar.zze(), zzadyVar.zzd(), zzadyVar.zza(), (zzaet) Preconditions.checkNotNull(zzadyVar.zzc(), "totpInfo cannot be null."));
    }

    public static List zzb(List list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                MultiFactorInfo zza = zza((zzady) it.next());
                if (zza != null) {
                    arrayList.add(zza);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }
}
