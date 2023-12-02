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
final class zzik implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Uri f22806a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaseImplementation.ResultHolder f22807b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ boolean f22808c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f22809d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzim f22810e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzik(zzim zzimVar, Uri uri, BaseImplementation.ResultHolder resultHolder, boolean z3, String str) {
        this.f22810e = zzimVar;
        this.f22806a = uri;
        this.f22807b = resultHolder;
        this.f22808c = z3;
        this.f22809d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4;
        Log.isLoggable("WearableClient", 2);
        if (!"file".equals(this.f22806a.getScheme())) {
            Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
            this.f22807b.setFailedResult(new Status(10, "Channel.receiveFile used with non-file URI"));
            return;
        }
        File file = new File(this.f22806a.getPath());
        if (true != this.f22808c) {
            i4 = 0;
        } else {
            i4 = 33554432;
        }
        try {
            ParcelFileDescriptor open = ParcelFileDescriptor.open(file, i4 | 671088640);
            try {
                try {
                    ((zzfb) this.f22810e.getService()).zzC(new zzii(this.f22807b), this.f22809d, open);
                    try {
                        open.close();
                    } catch (IOException e4) {
                        Log.w("WearableClient", "Failed to close targetFd", e4);
                    }
                } catch (RemoteException e5) {
                    Log.w("WearableClient", "Channel.receiveFile failed.", e5);
                    this.f22807b.setFailedResult(new Status(8));
                    try {
                        open.close();
                    } catch (IOException e6) {
                        Log.w("WearableClient", "Failed to close targetFd", e6);
                    }
                }
            } catch (Throwable th) {
                try {
                    open.close();
                } catch (IOException e7) {
                    Log.w("WearableClient", "Failed to close targetFd", e7);
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: ".concat(file.toString()));
            this.f22807b.setFailedResult(new Status(13));
        }
    }
}
