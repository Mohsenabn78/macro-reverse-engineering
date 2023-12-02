package com.google.android.gms.internal.ads;

import com.google.android.gms.wearable.WearableStatusCodes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfpu {
    private final zzfos zza;
    private final zzfpt zzb;

    private zzfpu(zzfpt zzfptVar) {
        zzfor zzforVar = zzfor.zza;
        this.zzb = zzfptVar;
        this.zza = zzforVar;
    }

    public static zzfpu zzb(int i4) {
        return new zzfpu(new zzfpq(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED));
    }

    public static zzfpu zzc(zzfos zzfosVar) {
        return new zzfpu(new zzfpo(zzfosVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator zzg(CharSequence charSequence) {
        return this.zzb.zza(this, charSequence);
    }

    public final Iterable zzd(CharSequence charSequence) {
        charSequence.getClass();
        return new zzfpr(this, charSequence);
    }

    public final List zzf(CharSequence charSequence) {
        Iterator zzg = zzg(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzg.hasNext()) {
            arrayList.add((String) zzg.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
