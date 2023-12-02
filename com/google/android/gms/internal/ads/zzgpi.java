package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgpi;
import com.google.android.gms.internal.ads.zzgpm;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzgpi<MessageType extends zzgpm<MessageType, BuilderType>, BuilderType extends zzgpi<MessageType, BuilderType>> extends zzgnm<MessageType, BuilderType> {
    protected zzgpm zza;
    private final zzgpm zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgpi(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzaY()) {
            this.zza = messagetype.zzaD();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzgre.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzgnm
    /* renamed from: zzai */
    public final zzgpi zzah() {
        zzgpi zzgpiVar = (zzgpi) this.zzb.zzb(5, null, null);
        zzgpiVar.zza = zzan();
        return zzgpiVar;
    }

    public final zzgpi zzaj(zzgpm zzgpmVar) {
        if (!this.zzb.equals(zzgpmVar)) {
            if (!this.zza.zzaY()) {
                zzaq();
            }
            zza(this.zza, zzgpmVar);
        }
        return this;
    }

    public final zzgpi zzak(byte[] bArr, int i4, int i5, zzgoy zzgoyVar) throws zzgpy {
        if (!this.zza.zzaY()) {
            zzaq();
        }
        try {
            zzgre.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i5, new zzgnq(zzgoyVar));
            return this;
        } catch (zzgpy e4) {
            throw e4;
        } catch (IOException e5) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e5);
        } catch (IndexOutOfBoundsException unused) {
            throw zzgpy.zzj();
        }
    }

    public final MessageType zzal() {
        MessageType zzan = zzan();
        if (zzan.zzaX()) {
            return zzan;
        }
        throw new zzgsf(zzan);
    }

    @Override // com.google.android.gms.internal.ads.zzgqv
    /* renamed from: zzam */
    public MessageType zzan() {
        if (!this.zza.zzaY()) {
            return (MessageType) this.zza;
        }
        this.zza.zzaS();
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzap() {
        if (!this.zza.zzaY()) {
            zzaq();
        }
    }

    protected void zzaq() {
        zzgpm zzaD = this.zzb.zzaD();
        zza(zzaD, this.zza);
        this.zza = zzaD;
    }

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final /* synthetic */ zzgqw zzbf() {
        throw null;
    }
}
