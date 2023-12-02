package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {

    /* renamed from: a  reason: collision with root package name */
    private static final zzd f19812a = new zzd(null);
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    private static int f19813b = zzc.f19814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    @VisibleForTesting
    /* loaded from: classes4.dex */
    public enum zzc {

        /* renamed from: a  reason: collision with root package name */
        public static final int f19814a = 1;

        /* renamed from: b  reason: collision with root package name */
        public static final int f19815b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f19816c = 3;

        /* renamed from: d  reason: collision with root package name */
        public static final int f19817d = 4;

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ int[] f19818e = {1, 2, 3, 4};

        public static int[] a() {
            return (int[]) f19818e.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class zzd implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private zzd() {
        }

        /* synthetic */ zzd(com.google.android.gms.auth.api.signin.zzc zzcVar) {
            this();
        }

        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        @Nullable
        public final /* synthetic */ GoogleSignInAccount convert(GoogleSignInResult googleSignInResult) {
            return googleSignInResult.getSignInAccount();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInClient(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new ApiExceptionMapper());
    }

    private final synchronized int a() {
        if (f19813b == zzc.f19814a) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(applicationContext, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            if (isGooglePlayServicesAvailable == 0) {
                f19813b = zzc.f19817d;
            } else if (googleApiAvailability.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) == null && DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") != 0) {
                f19813b = zzc.f19816c;
            } else {
                f19813b = zzc.f19815b;
            }
        }
        return f19813b;
    }

    @NonNull
    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        int i4 = com.google.android.gms.auth.api.signin.zzc.f19879a[a() - 1];
        if (i4 != 1) {
            if (i4 != 2) {
                return zzi.zze(applicationContext, getApiOptions());
            }
            return zzi.zzc(applicationContext, getApiOptions());
        }
        return zzi.zzd(applicationContext, getApiOptions());
    }

    public Task<Void> revokeAccess() {
        boolean z3;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (a() == zzc.f19816c) {
            z3 = true;
        } else {
            z3 = false;
        }
        return PendingResultUtil.toVoidTask(zzi.zzd(asGoogleApiClient, applicationContext, z3));
    }

    public Task<Void> signOut() {
        boolean z3;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        if (a() == zzc.f19816c) {
            z3 = true;
        } else {
            z3 = false;
        }
        return PendingResultUtil.toVoidTask(zzi.zzc(asGoogleApiClient, applicationContext, z3));
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        boolean z3;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Context applicationContext = getApplicationContext();
        GoogleSignInOptions apiOptions = getApiOptions();
        if (a() == zzc.f19816c) {
            z3 = true;
        } else {
            z3 = false;
        }
        return PendingResultUtil.toTask(zzi.zzc(asGoogleApiClient, applicationContext, apiOptions, z3), f19812a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInClient(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }
}
