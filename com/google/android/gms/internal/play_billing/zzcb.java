package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzbx;
import com.google.android.gms.internal.play_billing.zzcb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public abstract class zzcb<MessageType extends zzcb<MessageType, BuilderType>, BuilderType extends zzbx<MessageType, BuilderType>> extends zzak<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzeh zzc = zzeh.zzc();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcb zzg(Class cls) {
        Map map = zzb;
        zzcb zzcbVar = (zzcb) map.get(cls);
        if (zzcbVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzcbVar = (zzcb) map.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzcbVar == null) {
            zzcbVar = (zzcb) ((zzcb) zzeq.zze(cls)).zzt(6, null, null);
            if (zzcbVar != null) {
                map.put(cls, zzcbVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzcbVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzcb zzi(zzcb zzcbVar, byte[] bArr, zzbn zzbnVar) throws zzci {
        zzcb zzv = zzv(zzcbVar, bArr, 0, bArr.length, zzbnVar);
        if (zzv != null && !zzv.zzr()) {
            zzci zza = new zzef(zzv).zza();
            zza.zzf(zzv);
            throw zza;
        }
        return zzv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzk(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzl(zzdf zzdfVar, String str, Object[] objArr) {
        return new zzdo(zzdfVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzo(Class cls, zzcb zzcbVar) {
        zzcbVar.zzn();
        zzb.put(cls, zzcbVar);
    }

    private final int zzu(zzdp zzdpVar) {
        if (zzdpVar == null) {
            return zzdn.zza().zzb(getClass()).zza(this);
        }
        return zzdpVar.zza(this);
    }

    private static zzcb zzv(zzcb zzcbVar, byte[] bArr, int i4, int i5, zzbn zzbnVar) throws zzci {
        zzcb zzh = zzcbVar.zzh();
        try {
            zzdp zzb2 = zzdn.zza().zzb(zzh.getClass());
            zzb2.zzh(zzh, bArr, 0, i5, new zzan(zzbnVar));
            zzb2.zzf(zzh);
            return zzh;
        } catch (zzci e4) {
            e4.zzf(zzh);
            throw e4;
        } catch (zzef e5) {
            zzci zza = e5.zza();
            zza.zzf(zzh);
            throw zza;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzci) {
                throw ((zzci) e6.getCause());
            }
            zzci zzciVar = new zzci(e6);
            zzciVar.zzf(zzh);
            throw zzciVar;
        } catch (IndexOutOfBoundsException unused) {
            zzci zzg = zzci.zzg();
            zzg.zzf(zzh);
            throw zzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzdn.zza().zzb(getClass()).zzj(this, (zzcb) obj);
    }

    public final int hashCode() {
        if (!zzs()) {
            int i4 = this.zza;
            if (i4 == 0) {
                int zzc = zzc();
                this.zza = zzc;
                return zzc;
            }
            return i4;
        }
        return zzc();
    }

    public final String toString() {
        return zzdh.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.play_billing.zzak
    public final int zza(zzdp zzdpVar) {
        if (zzs()) {
            int zzu = zzu(zzdpVar);
            if (zzu >= 0) {
                return zzu;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zzu);
        }
        int i4 = this.zzd & Integer.MAX_VALUE;
        if (i4 != Integer.MAX_VALUE) {
            return i4;
        }
        int zzu2 = zzu(zzdpVar);
        if (zzu2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zzu2;
            return zzu2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + zzu2);
    }

    final int zzc() {
        return zzdn.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    public final int zzd() {
        int i4;
        if (zzs()) {
            i4 = zzu(null);
            if (i4 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i4);
            }
        } else {
            i4 = this.zzd & Integer.MAX_VALUE;
            if (i4 == Integer.MAX_VALUE) {
                i4 = zzu(null);
                if (i4 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | i4;
                } else {
                    throw new IllegalStateException("serialized size must be non-negative, was " + i4);
                }
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbx zze() {
        return (zzbx) zzt(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdg
    public final /* synthetic */ zzdf zzf() {
        return (zzcb) zzt(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcb zzh() {
        return (zzcb) zzt(4, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    public final /* synthetic */ zzde zzj() {
        return (zzbx) zzt(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm() {
        zzdn.zza().zzb(getClass()).zzf(this);
        zzn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzn() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzp(int i4) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdf
    public final void zzq(zzbi zzbiVar) throws IOException {
        zzdn.zza().zzb(getClass()).zzi(this, zzbj.zza(zzbiVar));
    }

    public final boolean zzr() {
        zzcb<MessageType, BuilderType> zzcbVar;
        byte byteValue = ((Byte) zzt(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzdn.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzcbVar = null;
        } else {
            zzcbVar = this;
        }
        zzt(2, zzcbVar, null);
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzs() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzt(int i4, Object obj, Object obj2);
}
