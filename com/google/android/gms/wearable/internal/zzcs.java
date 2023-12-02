package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzcs implements DataApi.GetFdForAssetResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22738a;

    /* renamed from: b  reason: collision with root package name */
    private volatile ParcelFileDescriptor f22739b;

    /* renamed from: c  reason: collision with root package name */
    private volatile InputStream f22740c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f22741d = false;

    public zzcs(Status status, ParcelFileDescriptor parcelFileDescriptor) {
        this.f22738a = status;
        this.f22739b = parcelFileDescriptor;
    }

    @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
    public final ParcelFileDescriptor getFd() {
        if (!this.f22741d) {
            return this.f22739b;
        }
        throw new IllegalStateException("Cannot access the file descriptor after release().");
    }

    @Override // com.google.android.gms.wearable.DataApi.GetFdForAssetResult
    public final InputStream getInputStream() {
        if (!this.f22741d) {
            if (this.f22739b == null) {
                return null;
            }
            if (this.f22740c == null) {
                this.f22740c = new ParcelFileDescriptor.AutoCloseInputStream(this.f22739b);
            }
            return this.f22740c;
        }
        throw new IllegalStateException("Cannot access the input stream after release().");
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22738a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        if (this.f22739b == null) {
            return;
        }
        if (!this.f22741d) {
            try {
                if (this.f22740c != null) {
                    this.f22740c.close();
                } else {
                    this.f22739b.close();
                }
                this.f22741d = true;
                this.f22739b = null;
                this.f22740c = null;
                return;
            } catch (IOException unused) {
                return;
            }
        }
        throw new IllegalStateException("releasing an already released result.");
    }
}
