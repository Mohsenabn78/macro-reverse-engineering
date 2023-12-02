package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import com.google.android.gms.internal.places.zzbc.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class zzbc<MessageType extends zzbc<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzm<MessageType, BuilderType> {
    private static Map<Object, zzbc<?, ?>> zzij = new ConcurrentHashMap();
    protected zzdr zzih = zzdr.zzdh();
    private int zzii = -1;

    /* loaded from: classes4.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzbc<MessageType, BuilderType> implements zzcm {
        protected zzav<Object> zzik = zzav.zzau();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzav<Object> zzbm() {
            if (this.zzik.isImmutable()) {
                this.zzik = (zzav) this.zzik.clone();
            }
            return this.zzik;
        }
    }

    /* loaded from: classes4.dex */
    public static class zzd<T extends zzbc<T, ?>> extends zzn<T> {
        private final T zzie;

        public zzd(T t3) {
            this.zzie = t3;
        }
    }

    /* loaded from: classes4.dex */
    public enum zze {
        public static final int zzil = 1;
        public static final int zzim = 2;
        public static final int zzin = 3;
        public static final int zzio = 4;
        public static final int zzip = 5;
        public static final int zziq = 6;
        public static final int zzir = 7;
        public static final int zzit = 1;
        public static final int zziu = 2;
        public static final int zziw = 1;
        public static final int zzix = 2;
        private static final /* synthetic */ int[] zzis = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zziv = {1, 2};
        private static final /* synthetic */ int[] zziy = {1, 2};

        public static int[] zzbn() {
            return (int[]) zzis.clone();
        }
    }

    /* loaded from: classes4.dex */
    public static class zzf<ContainingType extends zzck, Type> extends zzan<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzbc<?, ?>> void zzb(Class<T> cls, T t3) {
        zzij.put(cls, t3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzbi zzbi() {
        return zzbe.zzbo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzbh<E> zzbj() {
        return zzcy.zzct();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzbc<?, ?>> T zzd(Class<T> cls) {
        zzbc<?, ?> zzbcVar = zzij.get(cls);
        if (zzbcVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzbcVar = zzij.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (zzbcVar == null) {
            zzbcVar = (T) ((zzbc) zzdy.zzh(cls)).zzb(zze.zziq, (Object) null, (Object) null);
            if (zzbcVar != null) {
                zzij.put(cls, zzbcVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzbcVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzbc) zzb(zze.zziq, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzcv.zzcq().zzq(this).equals(this, (zzbc) obj);
    }

    public int hashCode() {
        int i4 = this.zzdt;
        if (i4 != 0) {
            return i4;
        }
        int hashCode = zzcv.zzcq().zzq(this).hashCode(this);
        this.zzdt = hashCode;
        return hashCode;
    }

    @Override // com.google.android.gms.internal.places.zzcm
    public final boolean isInitialized() {
        return zzb(this, true);
    }

    public String toString() {
        return zzcl.zzb(this, super.toString());
    }

    protected final void zzab() {
        zzcv.zzcq().zzq(this).zzd(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzb(int i4, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.places.zzcm
    public final /* synthetic */ zzck zzbg() {
        return (zzbc) zzb(zze.zziq, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.places.zzck
    public final int zzbh() {
        if (this.zzii == -1) {
            this.zzii = zzcv.zzcq().zzq(this).zzn(this);
        }
        return this.zzii;
    }

    @Override // com.google.android.gms.internal.places.zzck
    public final /* synthetic */ zzcj zzbk() {
        zzb zzbVar = (zzb) zzb(zze.zzip, (Object) null, (Object) null);
        zzbVar.zzb((zzb) this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.places.zzck
    public final /* synthetic */ zzcj zzbl() {
        return (zzb) zzb(zze.zzip, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.places.zzck
    public final void zzc(zzaj zzajVar) throws IOException {
        zzcv.zzcq().zzf(getClass()).zzb(this, zzam.zzb(zzajVar));
    }

    @Override // com.google.android.gms.internal.places.zzm
    final void zze(int i4) {
        this.zzii = i4;
    }

    @Override // com.google.android.gms.internal.places.zzm
    final int zzw() {
        return this.zzii;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzb(zzck zzckVar, String str, Object[] objArr) {
        return new zzcx(zzckVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzb(Method method, Object obj, Object... objArr) {
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

    /* loaded from: classes4.dex */
    public static abstract class zzb<MessageType extends zzbc<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzo<MessageType, BuilderType> {
        private final MessageType zzie;
        private MessageType zzif;
        private boolean zzig = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zzie = messagetype;
            this.zzif = (MessageType) messagetype.zzb(zze.zzio, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.places.zzo
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzbVar = (zzb) this.zzie.zzb(zze.zzip, null, null);
            zzbVar.zzb((zzb) ((zzbc) zzbe()));
            return zzbVar;
        }

        @Override // com.google.android.gms.internal.places.zzcm
        public final boolean isInitialized() {
            return zzbc.zzb(this.zzif, false);
        }

        public final BuilderType zzb(MessageType messagetype) {
            if (this.zzig) {
                MessageType messagetype2 = (MessageType) this.zzif.zzb(zze.zzio, null, null);
                zzb(messagetype2, this.zzif);
                this.zzif = messagetype2;
                this.zzig = false;
            }
            zzb(this.zzif, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.places.zzcj
        /* renamed from: zzbc */
        public MessageType zzbe() {
            if (this.zzig) {
                return this.zzif;
            }
            this.zzif.zzab();
            this.zzig = true;
            return this.zzif;
        }

        @Override // com.google.android.gms.internal.places.zzcj
        /* renamed from: zzbd */
        public final MessageType zzbf() {
            MessageType messagetype = (MessageType) zzbe();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzdp(messagetype);
        }

        @Override // com.google.android.gms.internal.places.zzcm
        public final /* synthetic */ zzck zzbg() {
            return this.zzie;
        }

        @Override // com.google.android.gms.internal.places.zzo
        public final /* synthetic */ zzo zzx() {
            return (zzb) clone();
        }

        private static void zzb(MessageType messagetype, MessageType messagetype2) {
            zzcv.zzcq().zzq(messagetype).zzd(messagetype, messagetype2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.places.zzo
        protected final /* synthetic */ zzo zzb(zzm zzmVar) {
            return zzb((zzb<MessageType, BuilderType>) ((zzbc) zzmVar));
        }
    }

    protected static final <T extends zzbc<T, ?>> boolean zzb(T t3, boolean z3) {
        byte byteValue = ((Byte) t3.zzb(zze.zzil, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzp = zzcv.zzcq().zzq(t3).zzp(t3);
        if (z3) {
            t3.zzb(zze.zzim, zzp ? t3 : null, null);
        }
        return zzp;
    }

    private static <T extends zzbc<T, ?>> T zzb(T t3, byte[] bArr, int i4, int i5, zzap zzapVar) throws zzbk {
        T t4 = (T) t3.zzb(zze.zzio, null, null);
        try {
            zzcv.zzcq().zzq(t4).zzb(t4, bArr, 0, i5, new zzr(zzapVar));
            t4.zzab();
            if (t4.zzdt == 0) {
                return t4;
            }
            throw new RuntimeException();
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzbk) {
                throw ((zzbk) e4.getCause());
            }
            throw new zzbk(e4.getMessage()).zzh(t4);
        } catch (IndexOutOfBoundsException unused) {
            throw zzbk.zzbp().zzh(t4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzbc<T, ?>> T zzb(T t3, byte[] bArr) throws zzbk {
        T t4 = (T) zzb(t3, bArr, 0, bArr.length, zzap.zzao());
        if (t4 == null || t4.isInitialized()) {
            return t4;
        }
        throw new zzbk(new zzdp(t4).getMessage()).zzh(t4);
    }
}
