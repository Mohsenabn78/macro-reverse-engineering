package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzcbr {
    @VisibleForTesting
    private static final AtomicInteger zza = new AtomicInteger(0);
    @VisibleForTesting
    private static final AtomicInteger zzb = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: protected */
    public static AtomicInteger zzD() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static AtomicInteger zzE() {
        return zzb;
    }

    public static int zzs() {
        return zza.get();
    }

    public static int zzu() {
        return zzb.get();
    }

    public abstract long zzA();

    public abstract long zzB();

    @Nullable
    public abstract Integer zzC();

    public abstract void zzF(Uri[] uriArr, String str);

    public abstract void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z3);

    public abstract void zzH();

    public abstract void zzI(long j4);

    public abstract void zzJ(int i4);

    public abstract void zzK(int i4);

    public abstract void zzL(zzcbq zzcbqVar);

    public abstract void zzM(int i4);

    public abstract void zzN(int i4);

    public abstract void zzO(boolean z3);

    public abstract void zzP(@Nullable Integer num);

    public abstract void zzQ(boolean z3);

    public abstract void zzR(int i4);

    public abstract void zzS(Surface surface, boolean z3) throws IOException;

    public abstract void zzT(float f4, boolean z3) throws IOException;

    public abstract void zzU();

    public abstract boolean zzV();

    public abstract int zzr();

    public abstract int zzt();

    public abstract long zzv();

    public abstract long zzw();

    public abstract long zzx();

    public abstract long zzy();

    public abstract long zzz();
}
