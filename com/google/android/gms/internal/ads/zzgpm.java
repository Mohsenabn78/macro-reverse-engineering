package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgpi;
import com.google.android.gms.internal.ads.zzgpm;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgpm<MessageType extends zzgpm<MessageType, BuilderType>, BuilderType extends zzgpi<MessageType, BuilderType>> extends zzgnn<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzgsh zzc = zzgsh.zzc();

    private final int zza(zzgrp zzgrpVar) {
        return zzgre.zza().zzb(getClass()).zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgpm zzaC(Class cls) {
        Map map = zzb;
        zzgpm zzgpmVar = (zzgpm) map.get(cls);
        if (zzgpmVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgpmVar = (zzgpm) map.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzgpmVar == null) {
            zzgpmVar = (zzgpm) ((zzgpm) zzgsq.zzg(cls)).zzb(6, null, null);
            if (zzgpmVar != null) {
                map.put(cls, zzgpmVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzgpmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpm zzaE(zzgpm zzgpmVar, zzgoe zzgoeVar) throws zzgpy {
        zzgoy zzgoyVar = zzgoy.zza;
        zzgom zzl = zzgoeVar.zzl();
        zzgpm zzaD = zzgpmVar.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgon.zzq(zzl), zzgoyVar);
            zzb2.zzf(zzaD);
            try {
                zzl.zzz(0);
                zzc(zzaD);
                zzc(zzaD);
                return zzaD;
            } catch (zzgpy e4) {
                e4.zzh(zzaD);
                throw e4;
            }
        } catch (zzgpy e5) {
            e = e5;
            if (e.zzl()) {
                e = new zzgpy(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e6) {
            zzgpy zza = e6.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e7) {
            if (e7.getCause() instanceof zzgpy) {
                throw ((zzgpy) e7.getCause());
            }
            zzgpy zzgpyVar = new zzgpy(e7);
            zzgpyVar.zzh(zzaD);
            throw zzgpyVar;
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof zzgpy) {
                throw ((zzgpy) e8.getCause());
            }
            throw e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpm zzaF(zzgpm zzgpmVar, byte[] bArr) throws zzgpy {
        zzgpm zzd = zzd(zzgpmVar, bArr, 0, bArr.length, zzgoy.zza);
        zzc(zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpm zzaG(zzgpm zzgpmVar, zzgoe zzgoeVar, zzgoy zzgoyVar) throws zzgpy {
        zzgom zzl = zzgoeVar.zzl();
        zzgpm zzaD = zzgpmVar.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgon.zzq(zzl), zzgoyVar);
            zzb2.zzf(zzaD);
            try {
                zzl.zzz(0);
                zzc(zzaD);
                return zzaD;
            } catch (zzgpy e4) {
                e4.zzh(zzaD);
                throw e4;
            }
        } catch (zzgpy e5) {
            e = e5;
            if (e.zzl()) {
                e = new zzgpy(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e6) {
            zzgpy zza = e6.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e7) {
            if (e7.getCause() instanceof zzgpy) {
                throw ((zzgpy) e7.getCause());
            }
            zzgpy zzgpyVar = new zzgpy(e7);
            zzgpyVar.zzh(zzaD);
            throw zzgpyVar;
        } catch (RuntimeException e8) {
            if (e8.getCause() instanceof zzgpy) {
                throw ((zzgpy) e8.getCause());
            }
            throw e8;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpm zzaH(zzgpm zzgpmVar, InputStream inputStream, zzgoy zzgoyVar) throws zzgpy {
        zzgom zzH = zzgom.zzH(inputStream, 4096);
        zzgpm zzaD = zzgpmVar.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzh(zzaD, zzgon.zzq(zzH), zzgoyVar);
            zzb2.zzf(zzaD);
            zzc(zzaD);
            return zzaD;
        } catch (zzgpy e4) {
            e = e4;
            if (e.zzl()) {
                e = new zzgpy(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e5) {
            zzgpy zza = e5.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzgpy) {
                throw ((zzgpy) e6.getCause());
            }
            zzgpy zzgpyVar = new zzgpy(e6);
            zzgpyVar.zzh(zzaD);
            throw zzgpyVar;
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof zzgpy) {
                throw ((zzgpy) e7.getCause());
            }
            throw e7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpm zzaI(zzgpm zzgpmVar, byte[] bArr, zzgoy zzgoyVar) throws zzgpy {
        zzgpm zzd = zzd(zzgpmVar, bArr, 0, bArr.length, zzgoyVar);
        zzc(zzd);
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpr zzaJ() {
        return zzgpn.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpr zzaK(zzgpr zzgprVar) {
        int i4;
        int size = zzgprVar.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size + size;
        }
        return zzgprVar.zzg(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpu zzaL() {
        return zzgql.zzf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpu zzaM(zzgpu zzgpuVar) {
        int i4;
        int size = zzgpuVar.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size + size;
        }
        return zzgpuVar.zza(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpv zzaN() {
        return zzgrf.zze();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzgpv zzaO(zzgpv zzgpvVar) {
        int i4;
        int size = zzgpvVar.size();
        if (size == 0) {
            i4 = 10;
        } else {
            i4 = size + size;
        }
        return zzgpvVar.zzd(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzaQ(Method method, Object obj, Object... objArr) {
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
    public static Object zzaR(zzgqw zzgqwVar, String str, Object[] objArr) {
        return new zzgrg(zzgqwVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzaU(Class cls, zzgpm zzgpmVar) {
        zzgpmVar.zzaT();
        zzb.put(cls, zzgpmVar);
    }

    private static zzgpm zzc(zzgpm zzgpmVar) throws zzgpy {
        if (zzgpmVar != null && !zzgpmVar.zzaX()) {
            zzgpy zza = new zzgsf(zzgpmVar).zza();
            zza.zzh(zzgpmVar);
            throw zza;
        }
        return zzgpmVar;
    }

    private static zzgpm zzd(zzgpm zzgpmVar, byte[] bArr, int i4, int i5, zzgoy zzgoyVar) throws zzgpy {
        zzgpm zzaD = zzgpmVar.zzaD();
        try {
            zzgrp zzb2 = zzgre.zza().zzb(zzaD.getClass());
            zzb2.zzi(zzaD, bArr, 0, i5, new zzgnq(zzgoyVar));
            zzb2.zzf(zzaD);
            return zzaD;
        } catch (zzgpy e4) {
            e = e4;
            if (e.zzl()) {
                e = new zzgpy(e);
            }
            e.zzh(zzaD);
            throw e;
        } catch (zzgsf e5) {
            zzgpy zza = e5.zza();
            zza.zzh(zzaD);
            throw zza;
        } catch (IOException e6) {
            if (e6.getCause() instanceof zzgpy) {
                throw ((zzgpy) e6.getCause());
            }
            zzgpy zzgpyVar = new zzgpy(e6);
            zzgpyVar.zzh(zzaD);
            throw zzgpyVar;
        } catch (IndexOutOfBoundsException unused) {
            zzgpy zzj = zzgpy.zzj();
            zzj.zzh(zzaD);
            throw zzj;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgre.zza().zzb(getClass()).zzj(this, (zzgpm) obj);
    }

    public final int hashCode() {
        if (!zzaY()) {
            int i4 = this.zza;
            if (i4 == 0) {
                int zzay = zzay();
                this.zza = zzay;
                return zzay;
            }
            return i4;
        }
        return zzay();
    }

    public final String toString() {
        return zzgqy.zza(this, super.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzgpi zzaA() {
        return (zzgpi) zzb(5, null, null);
    }

    public final zzgpi zzaB() {
        zzgpi zzgpiVar = (zzgpi) zzb(5, null, null);
        zzgpiVar.zzaj(this);
        return zzgpiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgpm zzaD() {
        return (zzgpm) zzb(4, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgqw
    public final /* synthetic */ zzgqv zzaP() {
        return (zzgpi) zzb(5, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaS() {
        zzgre.zza().zzb(getClass()).zzf(this);
        zzaT();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaT() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaV(int i4) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgqw
    public final void zzaW(zzgot zzgotVar) throws IOException {
        zzgre.zza().zzb(getClass()).zzm(this, zzgou.zza(zzgotVar));
    }

    public final boolean zzaX() {
        zzgpm<MessageType, BuilderType> zzgpmVar;
        byte byteValue = ((Byte) zzb(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzgre.zza().zzb(getClass()).zzk(this);
        if (true != zzk) {
            zzgpmVar = null;
        } else {
            zzgpmVar = this;
        }
        zzb(2, zzgpmVar, null);
        return zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaY() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgnn
    public final int zzat(zzgrp zzgrpVar) {
        if (zzaY()) {
            int zza = zzgrpVar.zza(this);
            if (zza >= 0) {
                return zza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza);
        }
        int i4 = this.zzd & Integer.MAX_VALUE;
        if (i4 == Integer.MAX_VALUE) {
            int zza2 = zzgrpVar.zza(this);
            if (zza2 >= 0) {
                this.zzd = (this.zzd & Integer.MIN_VALUE) | zza2;
                return zza2;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + zza2);
        }
        return i4;
    }

    final int zzay() {
        return zzgre.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgqw
    public final int zzaz() {
        int i4;
        if (zzaY()) {
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
    public abstract Object zzb(int i4, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.ads.zzgqx
    public final /* synthetic */ zzgqw zzbf() {
        return (zzgpm) zzb(6, null, null);
    }
}
