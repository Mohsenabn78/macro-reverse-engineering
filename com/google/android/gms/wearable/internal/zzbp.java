package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbp implements Channel.GetOutputStreamResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22707a;

    /* renamed from: b  reason: collision with root package name */
    private final OutputStream f22708b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbp(Status status, @Nullable OutputStream outputStream) {
        this.f22707a = (Status) Preconditions.checkNotNull(status);
        this.f22708b = outputStream;
    }

    @Override // com.google.android.gms.wearable.Channel.GetOutputStreamResult
    @Nullable
    public final OutputStream getOutputStream() {
        return this.f22708b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22707a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        OutputStream outputStream = this.f22708b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
