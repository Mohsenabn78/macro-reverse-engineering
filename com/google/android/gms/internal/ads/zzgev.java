package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgev {
    private final Map zza;
    private final Map zzb;

    private zzgev() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzgev zza(zzges zzgesVar) throws GeneralSecurityException {
        zzgex zzgexVar = new zzgex(zzgesVar.zzc(), zzgesVar.zzd(), null);
        if (this.zza.containsKey(zzgexVar)) {
            zzges zzgesVar2 = (zzges) this.zza.get(zzgexVar);
            if (!zzgesVar2.equals(zzgesVar) || !zzgesVar.equals(zzgesVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzgexVar.toString()));
            }
        } else {
            this.zza.put(zzgexVar, zzgesVar);
        }
        return this;
    }

    public final zzgev zzb(zzfyn zzfynVar) throws GeneralSecurityException {
        if (zzfynVar != null) {
            Map map = this.zzb;
            Class zzb = zzfynVar.zzb();
            if (map.containsKey(zzb)) {
                zzfyn zzfynVar2 = (zzfyn) this.zzb.get(zzb);
                if (!zzfynVar2.equals(zzfynVar) || !zzfynVar.equals(zzfynVar2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb.toString()));
                }
            } else {
                this.zzb.put(zzb, zzfynVar);
            }
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgev(zzgeu zzgeuVar) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgev(zzgez zzgezVar, zzgeu zzgeuVar) {
        this.zza = new HashMap(zzgez.zzd(zzgezVar));
        this.zzb = new HashMap(zzgez.zze(zzgezVar));
    }
}
