package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.auth.zzab;
import com.google.android.gms.internal.auth.zzad;
import com.google.android.gms.internal.auth.zzaf;
import com.google.android.gms.internal.auth.zzah;
import com.google.android.gms.internal.auth.zzy;
import com.google.android.gms.internal.auth.zzz;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public class AccountTransferClient extends GoogleApi<zzn> {

    /* renamed from: a  reason: collision with root package name */
    private static final Api.ClientKey<com.google.android.gms.internal.auth.zzu> f19639a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.auth.zzu, zzn> f19640b;

    /* renamed from: c  reason: collision with root package name */
    private static final Api<zzn> f19641c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class zza<T> extends com.google.android.gms.internal.auth.zzs {

        /* renamed from: a  reason: collision with root package name */
        private zzb<T> f19642a;

        public zza(zzb<T> zzbVar) {
            this.f19642a = zzbVar;
        }

        @Override // com.google.android.gms.internal.auth.zzs, com.google.android.gms.internal.auth.zzx
        public final void onFailure(Status status) {
            this.f19642a.b(status);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class zzb<T> extends TaskApiCall<com.google.android.gms.internal.auth.zzu, T> {

        /* renamed from: d  reason: collision with root package name */
        private TaskCompletionSource<T> f19643d;

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.TaskApiCall
        public /* synthetic */ void a(com.google.android.gms.internal.auth.zzu zzuVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
            this.f19643d = taskCompletionSource;
            c((zzz) zzuVar.getService());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void b(Status status) {
            AccountTransferClient.a(this.f19643d, status);
        }

        protected abstract void c(zzz zzzVar) throws RemoteException;

        /* JADX INFO: Access modifiers changed from: protected */
        public final void setResult(T t3) {
            this.f19643d.setResult(t3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ zzb(com.google.android.gms.auth.api.accounttransfer.zzc zzcVar) {
            this();
        }
    }

    static {
        Api.ClientKey<com.google.android.gms.internal.auth.zzu> clientKey = new Api.ClientKey<>();
        f19639a = clientKey;
        com.google.android.gms.auth.api.accounttransfer.zzc zzcVar = new com.google.android.gms.auth.api.accounttransfer.zzc();
        f19640b = zzcVar;
        f19641c = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", zzcVar, clientKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountTransferClient(@NonNull Context context) {
        super(context, f19641c, (Api.ApiOptions) null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(TaskCompletionSource taskCompletionSource, Status status) {
        taskCompletionSource.setException(new AccountTransferException(status));
    }

    public Task<DeviceMetaData> getDeviceMetaData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zzg(this, new com.google.android.gms.internal.auth.zzv(str)));
    }

    public Task<Void> notifyCompletion(String str, int i4) {
        Preconditions.checkNotNull(str);
        return doWrite(new zzj(this, new zzab(str, i4)));
    }

    public Task<byte[]> retrieveData(String str) {
        Preconditions.checkNotNull(str);
        return doRead(new zze(this, new zzad(str)));
    }

    public Task<Void> sendData(String str, byte[] bArr) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bArr);
        return doWrite(new zzd(this, new zzaf(str, bArr)));
    }

    public Task<Void> showUserChallenge(String str, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(pendingIntent);
        return doWrite(new zzi(this, new zzah(str, pendingIntent)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static abstract class zzc extends zzb<Void> {

        /* renamed from: e  reason: collision with root package name */
        zzy f19644e;

        private zzc() {
            super(null);
            this.f19644e = new zzk(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ zzc(com.google.android.gms.auth.api.accounttransfer.zzc zzcVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountTransferClient(@NonNull Activity activity) {
        super(activity, (Api<Api.ApiOptions>) f19641c, (Api.ApiOptions) null, new GoogleApi.Settings.Builder().setMapper(new ApiExceptionMapper()).build());
    }
}
