package com.google.android.gms.nearby;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.nearby.zzax;
import com.google.android.gms.internal.nearby.zzi;
import com.google.android.gms.internal.nearby.zzii;
import com.google.android.gms.internal.nearby.zzjj;
import com.google.android.gms.internal.nearby.zzl;
import com.google.android.gms.internal.nearby.zzrv;
import com.google.android.gms.internal.nearby.zzsb;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzbh;
import com.google.android.gms.nearby.messages.internal.zzbx;
import com.google.android.gms.nearby.messages.internal.zzby;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.uwb.UwbClient;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class Nearby {
    @NonNull
    @Deprecated
    public static final Api<ConnectionsOptions> CONNECTIONS_API = new Api<>("Nearby.CONNECTIONS_API", zzjj.zzb, zzjj.zza);
    @NonNull
    @Deprecated
    public static final Connections Connections = new zzjj();
    @NonNull
    @Deprecated
    public static final Api<MessagesOptions> MESSAGES_API = new Api<>("Nearby.MESSAGES_API", zzbx.zzc, zzbx.zzb);
    @NonNull
    @Deprecated
    public static final Messages Messages = zzbx.zza;
    @ShowFirstParty
    public static final zzc zza = new zzby();
    @NonNull
    @ShowFirstParty
    @Deprecated
    public static final Api zzb = new Api("Nearby.BOOTSTRAP_API", zzl.zzb, zzl.zza);
    @ShowFirstParty
    @Deprecated
    public static final zzi zzc = new zzl();

    private Nearby() {
    }

    @NonNull
    public static final ConnectionsClient getConnectionsClient(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return zzii.zza(activity, null);
    }

    @NonNull
    public static ExposureNotificationClient getExposureNotificationClient(@NonNull Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzax(context);
    }

    @NonNull
    @Deprecated
    public static final MessagesClient getMessagesClient(@NonNull Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return new zzbh(activity, (MessagesOptions) null);
    }

    @NonNull
    public static UwbClient getUwbControleeClient(@NonNull Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        com.google.android.gms.nearby.uwb.zzc zzcVar = new com.google.android.gms.nearby.uwb.zzc();
        zzcVar.zza(2);
        return new zzrv(context, zzcVar.zzb());
    }

    @NonNull
    public static UwbClient getUwbControllerClient(@NonNull Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        com.google.android.gms.nearby.uwb.zzc zzcVar = new com.google.android.gms.nearby.uwb.zzc();
        zzcVar.zza(1);
        return new zzrv(context, zzcVar.zzb());
    }

    public static boolean zza(@NonNull Context context) {
        if (Wrappers.packageManager(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") != 0) {
            return true;
        }
        return zzsb.zzb(context.getContentResolver(), "gms:nearby:requires_gms_check", true);
    }

    @NonNull
    public static final ConnectionsClient getConnectionsClient(@NonNull Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return zzii.zzb(context, null);
    }

    @NonNull
    @Deprecated
    public static final MessagesClient getMessagesClient(@NonNull Activity activity, @NonNull MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzbh(activity, messagesOptions);
    }

    @NonNull
    @Deprecated
    public static final MessagesClient getMessagesClient(@NonNull Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzbh(context, (MessagesOptions) null);
    }

    @NonNull
    @Deprecated
    public static final MessagesClient getMessagesClient(@NonNull Context context, @NonNull MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzbh(context, messagesOptions);
    }
}
