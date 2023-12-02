package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzcx;
import com.google.android.gms.internal.icing.zzda;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public abstract class zzda<MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzcx<MessageType, BuilderType>> extends zzbs<MessageType, BuilderType> {
    private static final Map<Object, zzda<?, ?>> zzb = new ConcurrentHashMap();
    protected zzfe zzc = zzfe.zza();
    protected int zzd = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzda> T zzp(Class<T> cls) {
        Map<Object, zzda<?, ?>> map = zzb;
        zzda<?, ?> zzdaVar = map.get(cls);
        if (zzdaVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzdaVar = map.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzdaVar == null) {
            zzdaVar = (zzda) ((zzda) zzfn.zzc(cls)).zzf(6, null, null);
            if (zzdaVar != null) {
                map.put(cls, zzdaVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzdaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzda> void zzq(Class<T> cls, T t3) {
        zzb.put(cls, t3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzr(zzee zzeeVar, String str, Object[] objArr) {
        return new zzeo(zzeeVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzs(Method method, Object obj, Object... objArr) {
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
    public static zzdf zzt() {
        return zzdt.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzdd zzu() {
        return zzco.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzdc zzv() {
        return zzbv.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzdg<E> zzw() {
        return zzen.zzd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzdg<E> zzx(zzdg<E> zzdgVar) {
        int i4;
        int size = zzdgVar.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size + size;
        }
        return zzdgVar.zze(i4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzem.zza().zzb(getClass()).zza(this, (zzda) obj);
    }

    public final int hashCode() {
        int i4 = this.zza;
        if (i4 != 0) {
            return i4;
        }
        int zzb2 = zzem.zza().zzb(getClass()).zzb(this);
        this.zza = zzb2;
        return zzb2;
    }

    public final String toString() {
        return zzeg.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzf(int i4, Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzbs
    public final int zzi() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.icing.zzbs
    public final void zzj(int i4) {
        this.zzd = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzda<MessageType, BuilderType>, BuilderType extends zzcx<MessageType, BuilderType>> BuilderType zzl() {
        return (BuilderType) zzf(5, null, null);
    }

    @Override // com.google.android.gms.internal.icing.zzef
    public final /* bridge */ /* synthetic */ zzee zzm() {
        return (zzda) zzf(6, null, null);
    }

    @Override // com.google.android.gms.internal.icing.zzee
    public final void zzn(zzcm zzcmVar) throws IOException {
        zzem.zza().zzb(getClass()).zzi(this, zzcn.zza(zzcmVar));
    }

    @Override // com.google.android.gms.internal.icing.zzee
    public final int zzo() {
        int i4 = this.zzd;
        if (i4 == -1) {
            int zzd = zzem.zza().zzb(getClass()).zzd(this);
            this.zzd = zzd;
            return zzd;
        }
        return i4;
    }

    @Override // com.google.android.gms.internal.icing.zzee
    public final /* bridge */ /* synthetic */ zzed zzy() {
        zzcx zzcxVar = (zzcx) zzf(5, null, null);
        zzcxVar.zzk(this);
        return zzcxVar;
    }
}
