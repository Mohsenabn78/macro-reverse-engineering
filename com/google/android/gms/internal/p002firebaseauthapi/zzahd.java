package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzagz;
import com.google.android.gms.internal.p002firebaseauthapi.zzahd;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahd  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzahd<MessageType extends zzahd<MessageType, BuilderType>, BuilderType extends zzagz<MessageType, BuilderType>> extends zzafi<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzajp zzc = zzajp.zzc();

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzahi zzA() {
        return zzair.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzahi zzB(zzahi zzahiVar) {
        int i4;
        int size = zzahiVar.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size + size;
        }
        return zzahiVar.zzd(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzD(Method method, Object obj, Object... objArr) {
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
    public static Object zzE(zzaii zzaiiVar, String str, Object[] objArr) {
        return new zzais(zzaiiVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzH(Class cls, zzahd zzahdVar) {
        zzahdVar.zzG();
        zzb.put(cls, zzahdVar);
    }

    private final int zza(zzaiu zzaiuVar) {
        return zzaiq.zza().zzb(getClass()).zza(this);
    }

    private static zzahd zzb(zzahd zzahdVar) throws zzahl {
        if (zzahdVar != null && !zzahdVar.zzK()) {
            zzahl zza = new zzajn(zzahdVar).zza();
            zza.zzh(zzahdVar);
            throw zza;
        }
        return zzahdVar;
    }

    private static zzahd zzc(zzahd zzahdVar, byte[] bArr, int i4, int i5, zzagq zzagqVar) throws zzahl {
        zzahd zzw = zzahdVar.zzw();
        try {
            zzaiu zzb2 = zzaiq.zza().zzb(zzw.getClass());
            zzb2.zzi(zzw, bArr, 0, i5, new zzafl(zzagqVar));
            zzb2.zzf(zzw);
            return zzw;
        } catch (zzahl e4) {
            e = e4;
            if (e.zzl()) {
                e = new zzahl(e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzajn e5) {
            zzahl zza = e5.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzahl) {
                throw ((zzahl) e6.getCause());
            }
            zzahl zzahlVar = new zzahl(e6);
            zzahlVar.zzh(zzw);
            throw zzahlVar;
        } catch (IndexOutOfBoundsException unused) {
            zzahl zzj = zzahl.zzj();
            zzj.zzh(zzw);
            throw zzj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzahd zzv(Class cls) {
        Map map = zzb;
        zzahd zzahdVar = (zzahd) map.get(cls);
        if (zzahdVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzahdVar = (zzahd) map.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzahdVar == null) {
            zzahdVar = (zzahd) ((zzahd) zzajy.zze(cls)).zzj(6, null, null);
            if (zzahdVar != null) {
                map.put(cls, zzahdVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzahdVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzahd zzx(zzahd zzahdVar, zzafy zzafyVar, zzagq zzagqVar) throws zzahl {
        zzage zzh = zzafyVar.zzh();
        zzahd zzw = zzahdVar.zzw();
        try {
            zzaiu zzb2 = zzaiq.zza().zzb(zzw.getClass());
            zzb2.zzh(zzw, zzagf.zzq(zzh), zzagqVar);
            zzb2.zzf(zzw);
            try {
                zzh.zzz(0);
                zzb(zzw);
                return zzw;
            } catch (zzahl e4) {
                e4.zzh(zzw);
                throw e4;
            }
        } catch (zzahl e5) {
            e = e5;
            if (e.zzl()) {
                e = new zzahl(e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzajn e6) {
            zzahl zza = e6.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e7) {
            if (e7.getCause() instanceof zzahl) {
                throw ((zzahl) e7.getCause());
            }
            zzahl zzahlVar = new zzahl(e7);
            zzahlVar.zzh(zzw);
            throw zzahlVar;
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof zzahl) {
                throw ((zzahl) e8.getCause());
            }
            throw e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzahd zzy(zzahd zzahdVar, InputStream inputStream, zzagq zzagqVar) throws zzahl {
        zzagc zzagcVar = new zzagc(inputStream, 4096, null);
        zzahd zzw = zzahdVar.zzw();
        try {
            zzaiu zzb2 = zzaiq.zza().zzb(zzw.getClass());
            zzb2.zzh(zzw, zzagf.zzq(zzagcVar), zzagqVar);
            zzb2.zzf(zzw);
            zzb(zzw);
            return zzw;
        } catch (zzahl e4) {
            e = e4;
            if (e.zzl()) {
                e = new zzahl(e);
            }
            e.zzh(zzw);
            throw e;
        } catch (zzajn e5) {
            zzahl zza = e5.zza();
            zza.zzh(zzw);
            throw zza;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzahl) {
                throw ((zzahl) e6.getCause());
            }
            zzahl zzahlVar = new zzahl(e6);
            zzahlVar.zzh(zzw);
            throw zzahlVar;
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof zzahl) {
                throw ((zzahl) e7.getCause());
            }
            throw e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzahd zzz(zzahd zzahdVar, byte[] bArr, zzagq zzagqVar) throws zzahl {
        zzahd zzc = zzc(zzahdVar, bArr, 0, bArr.length, zzagqVar);
        zzb(zzc);
        return zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzaiq.zza().zzb(getClass()).zzj(this, (zzahd) obj);
    }

    public final int hashCode() {
        if (!zzL()) {
            int i4 = this.zza;
            if (i4 == 0) {
                int zzr = zzr();
                this.zza = zzr;
                return zzr;
            }
            return i4;
        }
        return zzr();
    }

    public final String toString() {
        return zzaik.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaii
    public final /* synthetic */ zzaih zzC() {
        return (zzagz) zzj(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzF() {
        zzaiq.zza().zzb(getClass()).zzf(this);
        zzG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzG() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzI(int i4) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaii
    public final void zzJ(zzagl zzaglVar) throws IOException {
        zzaiq.zza().zzb(getClass()).zzm(this, zzagm.zza(zzaglVar));
    }

    public final boolean zzK() {
        zzahd<MessageType, BuilderType> zzahdVar;
        byte byteValue = ((Byte) zzj(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzaiq.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzahdVar = null;
        } else {
            zzahdVar = this;
        }
        zzj(2, zzahdVar, null);
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzL() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaij
    public final /* synthetic */ zzaii zzM() {
        return (zzahd) zzj(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzj(int i4, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafi
    final int zzn(zzaiu zzaiuVar) {
        if (zzL()) {
            int zza = zzaiuVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i4 = this.zzd & Integer.MAX_VALUE;
        if (i4 == Integer.MAX_VALUE) {
            int zza2 = zzaiuVar.zza(this);
            if (zza2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        return i4;
    }

    final int zzr() {
        return zzaiq.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaii
    public final int zzs() {
        int i4;
        if (zzL()) {
            i4 = zza(null);
            if (i4 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + i4);
            }
        } else {
            i4 = this.zzd & Integer.MAX_VALUE;
            if (i4 == Integer.MAX_VALUE) {
                i4 = zza(null);
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
    public final zzagz zzt() {
        return (zzagz) zzj(5, null, null);
    }

    public final zzagz zzu() {
        zzagz zzagzVar = (zzagz) zzj(5, null, null);
        zzagzVar.zzh(this);
        return zzagzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzahd zzw() {
        return (zzahd) zzj(4, null, null);
    }
}
