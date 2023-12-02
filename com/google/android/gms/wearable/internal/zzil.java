package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzil implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f22811a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaseImplementation.ResultHolder f22812b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f22813c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f22814d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ long f22815e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ zzim f22816f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzil(zzim zzimVar, Uri uri, BaseImplementation.ResultHolder resultHolder, String str, long j4, long j5) {
        this.f22816f = zzimVar;
        this.f22811a = uri;
        this.f22812b = resultHolder;
        this.f22813c = str;
        this.f22814d = j4;
        this.f22815e = j5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.isLoggable("WearableClient", 2);
        if (!"file".equals(this.f22811a.getScheme())) {
            Log.w("WearableClient", "Channel.sendFile used with non-file URI");
            this.f22812b.setFailedResult(new Status(10, "Channel.sendFile used with non-file URI"));
            return;
        }
        File file = new File(this.f22811a.getPath());
        try {
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, 268435456);
            try {
                try {
                    ((zzfb) this.f22816f.getService()).zzw(new zzie(this.f22812b), this.f22813c, open, this.f22814d, this.f22815e);
                    try {
                        open.close();
                    } catch (IOException e4) {
                        Log.w("WearableClient", "Failed to close sourceFd", e4);
                    }
                } catch (Throwable th) {
                    try {
                        open.close();
                    } catch (IOException e5) {
                        Log.w("WearableClient", "Failed to close sourceFd", e5);
                    }
                    throw th;
                }
            } catch (RemoteException e6) {
                Log.w("WearableClient", "Channel.sendFile failed.", e6);
                this.f22812b.setFailedResult(new Status(8));
                try {
                    open.close();
                } catch (IOException e7) {
                    Log.w("WearableClient", "Failed to close sourceFd", e7);
                }
            }
        } catch (FileNotFoundException unused) {
            Log.w("WearableClient", "File couldn't be opened for Channel.sendFile: ".concat(file.toString()));
            this.f22812b.setFailedResult(new Status(13));
        }
    }
}
