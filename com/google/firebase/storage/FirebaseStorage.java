package com.google.firebase.storage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.firebase.inject.Provider;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.internal.Util;
import java.io.UnsupportedEncodingException;

/* loaded from: classes5.dex */
public class FirebaseStorage {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f32196a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InternalAuthProvider> f32197b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Provider<InteropAppCheckTokenProvider> f32198c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f32199d;

    /* renamed from: e  reason: collision with root package name */
    private long f32200e = 600000;

    /* renamed from: f  reason: collision with root package name */
    private long f32201f = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;

    /* renamed from: g  reason: collision with root package name */
    private long f32202g = 600000;

    /* renamed from: h  reason: collision with root package name */
    private long f32203h = 120000;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private EmulatedServiceSettings f32204i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseStorage(@Nullable String str, @NonNull FirebaseApp firebaseApp, @Nullable Provider<InternalAuthProvider> provider, @Nullable Provider<InteropAppCheckTokenProvider> provider2) {
        this.f32199d = str;
        this.f32196a = firebaseApp;
        this.f32197b = provider;
        this.f32198c = provider2;
        if (provider2 != null && provider2.get() != null) {
            provider2.get().addAppCheckTokenListener(new AppCheckTokenListener() { // from class: com.google.firebase.storage.FirebaseStorage.1
                @Override // com.google.firebase.appcheck.interop.AppCheckTokenListener
                public void onAppCheckTokenChanged(@NonNull AppCheckTokenResult appCheckTokenResult) {
                }
            });
        }
    }

    @Nullable
    private String c() {
        return this.f32199d;
    }

    private static FirebaseStorage e(@NonNull FirebaseApp firebaseApp, @Nullable Uri uri) {
        String str;
        if (uri != null) {
            str = uri.getHost();
        } else {
            str = null;
        }
        if (uri != null && !TextUtils.isEmpty(uri.getPath())) {
            throw new IllegalArgumentException("The storage Uri cannot contain a path element.");
        }
        Preconditions.checkNotNull(firebaseApp, "Provided FirebaseApp must not be null.");
        FirebaseStorageComponent firebaseStorageComponent = (FirebaseStorageComponent) firebaseApp.get(FirebaseStorageComponent.class);
        Preconditions.checkNotNull(firebaseStorageComponent, "Firebase Storage component is not present.");
        return firebaseStorageComponent.a(str);
    }

    @NonNull
    private StorageReference f(@NonNull Uri uri) {
        boolean z3;
        Preconditions.checkNotNull(uri, "uri must not be null");
        String c4 = c();
        if (!TextUtils.isEmpty(c4) && !uri.getAuthority().equalsIgnoreCase(c4)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "The supplied bucketname does not match the storage bucket of the current instance.");
        return new StorageReference(uri, this);
    }

    @NonNull
    public static FirebaseStorage getInstance() {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        Preconditions.checkArgument(firebaseApp != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(firebaseApp);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public InteropAppCheckTokenProvider a() {
        Provider<InteropAppCheckTokenProvider> provider = this.f32198c;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public InternalAuthProvider b() {
        Provider<InternalAuthProvider> provider = this.f32197b;
        if (provider != null) {
            return provider.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public EmulatedServiceSettings d() {
        return this.f32204i;
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.f32196a;
    }

    public long getMaxChunkUploadRetry() {
        return this.f32201f;
    }

    public long getMaxDownloadRetryTimeMillis() {
        return this.f32202g;
    }

    public long getMaxOperationRetryTimeMillis() {
        return this.f32203h;
    }

    public long getMaxUploadRetryTimeMillis() {
        return this.f32200e;
    }

    @NonNull
    public StorageReference getReference() {
        if (!TextUtils.isEmpty(c())) {
            return f(new Uri.Builder().scheme("gs").authority(c()).path(RemoteSettings.FORWARD_SLASH_STRING).build());
        }
        throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
    }

    @NonNull
    public StorageReference getReferenceFromUrl(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("gs://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("http://")) {
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
        try {
            Uri normalize = Util.normalize(this.f32196a, str);
            if (normalize != null) {
                return f(normalize);
            }
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        } catch (UnsupportedEncodingException e4) {
            Log.e("FirebaseStorage", "Unable to parse location:" + str, e4);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    public void setMaxChunkUploadRetry(long j4) {
        this.f32201f = j4;
    }

    public void setMaxDownloadRetryTimeMillis(long j4) {
        this.f32202g = j4;
    }

    public void setMaxOperationRetryTimeMillis(long j4) {
        this.f32203h = j4;
    }

    public void setMaxUploadRetryTimeMillis(long j4) {
        this.f32200e = j4;
    }

    public void useEmulator(@NonNull String str, int i4) {
        this.f32204i = new EmulatedServiceSettings(str, i4);
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull String str) {
        FirebaseApp firebaseApp = FirebaseApp.getInstance();
        Preconditions.checkArgument(firebaseApp != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(firebaseApp, str);
    }

    @NonNull
    public StorageReference getReference(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("gs://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("http://")) {
            return getReference().child(str);
        }
        throw new IllegalArgumentException("location should not be a full URL.");
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        String storageBucket = firebaseApp.getOptions().getStorageBucket();
        if (storageBucket == null) {
            return e(firebaseApp, null);
        }
        try {
            return e(firebaseApp, Util.normalize(firebaseApp, "gs://" + firebaseApp.getOptions().getStorageBucket()));
        } catch (UnsupportedEncodingException e4) {
            Log.e("FirebaseStorage", "Unable to parse bucket:" + storageBucket, e4);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        Preconditions.checkArgument(str != null, "Null is not a valid value for the Firebase Storage URL.");
        if (str.toLowerCase().startsWith("gs://")) {
            try {
                return e(firebaseApp, Util.normalize(firebaseApp, str));
            } catch (UnsupportedEncodingException e4) {
                Log.e("FirebaseStorage", "Unable to parse url:" + str, e4);
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            }
        }
        throw new IllegalArgumentException("Please use a gs:// URL for your Firebase Storage bucket.");
    }
}
