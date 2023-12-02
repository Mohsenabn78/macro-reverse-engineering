package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzgx extends zzgf {
    public final zzgj zzb;
    public final int zzc;

    public zzgx(zzgj zzgjVar, int i4, int i5) {
        super(zzb(2008, 1));
        this.zzb = zzgjVar;
        this.zzc = 1;
    }

    public static zzgx zza(IOException iOException, zzgj zzgjVar, int i4) {
        int i5;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i5 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i5 = 1004;
        } else if (message != null && zzfon.zza(message).matches("cleartext.*not permitted.*")) {
            i5 = 2007;
        } else {
            i5 = 2001;
        }
        if (i5 == 2007) {
            return new zzgw(iOException, zzgjVar);
        }
        return new zzgx(iOException, zzgjVar, i5, i4);
    }

    private static int zzb(int i4, int i5) {
        if (i4 == 2000) {
            if (i5 != 1) {
                return 2000;
            }
            return 2001;
        }
        return i4;
    }

    public zzgx(IOException iOException, zzgj zzgjVar, int i4, int i5) {
        super(iOException, zzb(i4, i5));
        this.zzb = zzgjVar;
        this.zzc = i5;
    }

    public zzgx(String str, zzgj zzgjVar, int i4, int i5) {
        super(str, zzb(i4, i5));
        this.zzb = zzgjVar;
        this.zzc = i5;
    }

    public zzgx(String str, @Nullable IOException iOException, zzgj zzgjVar, int i4, int i5) {
        super(str, iOException, zzb(i4, i5));
        this.zzb = zzgjVar;
        this.zzc = i5;
    }
}
