package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzij implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ParcelFileDescriptor f22804a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ byte[] f22805b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzij(zzim zzimVar, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
        this.f22804a = parcelFileDescriptor;
        this.f22805b = bArr;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        if (Log.isLoggable("WearableClient", 3)) {
            "processAssets: writing data to FD : ".concat(String.valueOf(this.f22804a));
        }
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(this.f22804a);
        try {
            try {
                autoCloseOutputStream.write(this.f22805b);
                autoCloseOutputStream.flush();
                if (Log.isLoggable("WearableClient", 3)) {
                    String valueOf = String.valueOf(this.f22804a);
                    StringBuilder sb = new StringBuilder();
                    sb.append("processAssets: wrote data: ");
                    sb.append(valueOf);
                }
                Boolean bool = Boolean.TRUE;
                try {
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf2 = String.valueOf(this.f22804a);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("processAssets: closing: ");
                        sb2.append(valueOf2);
                    }
                    autoCloseOutputStream.close();
                    return bool;
                } catch (IOException unused) {
                    return bool;
                }
            } catch (IOException unused2) {
                String valueOf3 = String.valueOf(this.f22804a);
                Log.w("WearableClient", "processAssets: writing data failed: " + valueOf3);
                try {
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf4 = String.valueOf(this.f22804a);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("processAssets: closing: ");
                        sb3.append(valueOf4);
                    }
                    autoCloseOutputStream.close();
                } catch (IOException unused3) {
                }
                return Boolean.FALSE;
            }
        } catch (Throwable th) {
            try {
                if (Log.isLoggable("WearableClient", 3)) {
                    String valueOf5 = String.valueOf(this.f22804a);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("processAssets: closing: ");
                    sb4.append(valueOf5);
                }
                autoCloseOutputStream.close();
            } catch (IOException unused4) {
            }
            throw th;
        }
    }
}
