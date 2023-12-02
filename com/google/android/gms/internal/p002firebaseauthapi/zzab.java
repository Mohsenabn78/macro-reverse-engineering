package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzab  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzab {
    private final zzj zza;
    private final zzaa zzb;

    private zzab(zzaa zzaaVar) {
        zzi zziVar = zzi.zza;
        this.zzb = zzaaVar;
        this.zza = zziVar;
    }

    public static zzab zzb(zzj zzjVar) {
        return new zzab(new zzw(zzjVar));
    }

    public static zzab zzc(String str) {
        zzp zzpVar = new zzp(Pattern.compile("[.-]"));
        if (!((zzo) zzpVar.zza("")).zza.matches()) {
            return new zzab(new zzy(zzpVar));
        }
        throw new IllegalArgumentException(zzac.zzb("The pattern may not match the empty string: %s", zzpVar));
    }

    public final List zzd(CharSequence charSequence) {
        charSequence.getClass();
        Iterator zza = this.zzb.zza(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (zza.hasNext()) {
            arrayList.add((String) zza.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
