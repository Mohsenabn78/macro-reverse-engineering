package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zada;
import com.google.android.gms.common.api.internal.zak;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@Deprecated
/* loaded from: classes4.dex */
public abstract class GoogleApiClient {
    @NonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    @GuardedBy("sAllClients")

    /* renamed from: a  reason: collision with root package name */
    private static final Set f20008a = Collections.newSetFromMap(new WeakHashMap());

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    public static void dumpAll(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr) {
        Set<GoogleApiClient> set = f20008a;
        synchronized (set) {
            String str2 = str + "  ";
            int i4 = 0;
            for (GoogleApiClient googleApiClient : set) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i4);
                googleApiClient.dump(str2, fileDescriptor, printWriter, strArr);
                i4++;
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static Set<GoogleApiClient> getAllClients() {
        Set<GoogleApiClient> set = f20008a;
        synchronized (set) {
        }
        return set;
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public abstract ConnectionResult blockingConnect();

    @NonNull
    @ResultIgnorabilityUnspecified
    public abstract ConnectionResult blockingConnect(long j4, @NonNull TimeUnit timeUnit);

    @NonNull
    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i4) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(@NonNull String str, @NonNull FileDescriptor fileDescriptor, @NonNull PrintWriter printWriter, @NonNull String[] strArr);

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t3) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t3) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> anyClientKey) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    @NonNull
    @KeepForSdk
    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    @NonNull
    @KeepForSdk
    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public boolean hasApi(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @KeepForSdk
    public boolean maybeSignIn(@NonNull SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    @KeepForSdk
    public void maybeSignOut() {
        throw new UnsupportedOperationException();
    }

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    @KeepForSdk
    public <L> ListenerHolder<L> registerListener(@NonNull L l4) {
        throw new UnsupportedOperationException();
    }

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public void zao(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    public void zap(zada zadaVar) {
        throw new UnsupportedOperationException();
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static final class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Account f20009a;

        /* renamed from: b  reason: collision with root package name */
        private final Set f20010b;

        /* renamed from: c  reason: collision with root package name */
        private final Set f20011c;

        /* renamed from: d  reason: collision with root package name */
        private int f20012d;

        /* renamed from: e  reason: collision with root package name */
        private View f20013e;

        /* renamed from: f  reason: collision with root package name */
        private String f20014f;

        /* renamed from: g  reason: collision with root package name */
        private String f20015g;

        /* renamed from: h  reason: collision with root package name */
        private final Map f20016h;

        /* renamed from: i  reason: collision with root package name */
        private final Context f20017i;

        /* renamed from: j  reason: collision with root package name */
        private final Map f20018j;

        /* renamed from: k  reason: collision with root package name */
        private LifecycleActivity f20019k;

        /* renamed from: l  reason: collision with root package name */
        private int f20020l;
        @Nullable

        /* renamed from: m  reason: collision with root package name */
        private OnConnectionFailedListener f20021m;

        /* renamed from: n  reason: collision with root package name */
        private Looper f20022n;

        /* renamed from: o  reason: collision with root package name */
        private GoogleApiAvailability f20023o;

        /* renamed from: p  reason: collision with root package name */
        private Api.AbstractClientBuilder f20024p;

        /* renamed from: q  reason: collision with root package name */
        private final ArrayList f20025q;

        /* renamed from: r  reason: collision with root package name */
        private final ArrayList f20026r;

        public Builder(@NonNull Context context) {
            this.f20010b = new HashSet();
            this.f20011c = new HashSet();
            this.f20016h = new ArrayMap();
            this.f20018j = new ArrayMap();
            this.f20020l = -1;
            this.f20023o = GoogleApiAvailability.getInstance();
            this.f20024p = com.google.android.gms.signin.zad.zac;
            this.f20025q = new ArrayList();
            this.f20026r = new ArrayList();
            this.f20017i = context;
            this.f20022n = context.getMainLooper();
            this.f20014f = context.getPackageName();
            this.f20015g = context.getClass().getName();
        }

        private final void a(Api api, @Nullable Api.ApiOptions apiOptions, Scope... scopeArr) {
            HashSet hashSet = new HashSet(((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zac(), "Base client builder must not be null")).getImpliedScopes(apiOptions));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.f20016h.put(api, new com.google.android.gms.common.internal.zab(hashSet));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.f20018j.put(api, null);
            List<Scope> impliedScopes = ((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zac(), "Base client builder must not be null")).getImpliedScopes(null);
            this.f20011c.addAll(impliedScopes);
            this.f20010b.addAll(impliedScopes);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o4, @NonNull Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o4, "Null options are not permitted for this Api");
            this.f20018j.put(api, o4);
            a(api, o4, scopeArr);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            Preconditions.checkNotNull(connectionCallbacks, "Listener must not be null");
            this.f20025q.add(connectionCallbacks);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            Preconditions.checkNotNull(onConnectionFailedListener, "Listener must not be null");
            this.f20026r.add(onConnectionFailedListener);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder addScope(@NonNull Scope scope) {
            Preconditions.checkNotNull(scope, "Scope must not be null");
            this.f20010b.add(scope);
            return this;
        }

        @NonNull
        @ResultIgnorabilityUnspecified
        public GoogleApiClient build() {
            boolean z3;
            boolean z4;
            Preconditions.checkArgument(!this.f20018j.isEmpty(), "must call addApi() to add at least one API");
            ClientSettings zaa = zaa();
            Map zad = zaa.zad();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Api api = null;
            boolean z5 = false;
            for (Api api2 : this.f20018j.keySet()) {
                Object obj = this.f20018j.get(api2);
                if (zad.get(api2) != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                arrayMap.put(api2, Boolean.valueOf(z4));
                zat zatVar = new zat(api2, z4);
                arrayList.add(zatVar);
                Api.AbstractClientBuilder abstractClientBuilder = (Api.AbstractClientBuilder) Preconditions.checkNotNull(api2.zaa());
                Api.Client buildClient = abstractClientBuilder.buildClient(this.f20017i, this.f20022n, zaa, (ClientSettings) obj, (ConnectionCallbacks) zatVar, (OnConnectionFailedListener) zatVar);
                arrayMap2.put(api2.zab(), buildClient);
                if (abstractClientBuilder.getPriority() == 1) {
                    if (obj != null) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                if (buildClient.providesSignIn()) {
                    if (api == null) {
                        api = api2;
                    } else {
                        throw new IllegalStateException(api2.zad() + " cannot be used with " + api.zad());
                    }
                }
            }
            if (api != null) {
                if (!z5) {
                    if (this.f20009a == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Preconditions.checkState(z3, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.zad());
                    Preconditions.checkState(this.f20010b.equals(this.f20011c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.zad());
                } else {
                    throw new IllegalStateException("With using " + api.zad() + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                }
            }
            zabe zabeVar = new zabe(this.f20017i, new ReentrantLock(), this.f20022n, zaa, this.f20023o, this.f20024p, arrayMap, this.f20025q, this.f20026r, arrayMap2, this.f20020l, zabe.zad(arrayMap2.values(), true), arrayList);
            synchronized (GoogleApiClient.f20008a) {
                GoogleApiClient.f20008a.add(zabeVar);
            }
            if (this.f20020l >= 0) {
                zak.zaa(this.f20019k).zad(this.f20020l, zabeVar, this.f20021m);
            }
            return zabeVar;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i4, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            LifecycleActivity lifecycleActivity = new LifecycleActivity((Activity) fragmentActivity);
            Preconditions.checkArgument(i4 >= 0, "clientId must be non-negative");
            this.f20020l = i4;
            this.f20021m = onConnectionFailedListener;
            this.f20019k = lifecycleActivity;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setAccountName(@NonNull String str) {
            Account account;
            if (str == null) {
                account = null;
            } else {
                account = new Account(str, "com.google");
            }
            this.f20009a = account;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setGravityForPopups(int i4) {
            this.f20012d = i4;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setHandler(@NonNull Handler handler) {
            Preconditions.checkNotNull(handler, "Handler must not be null");
            this.f20022n = handler.getLooper();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder setViewForPopups(@NonNull View view) {
            Preconditions.checkNotNull(view, "View must not be null");
            this.f20013e = view;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder useDefaultAccount() {
            setAccountName("<<default account>>");
            return this;
        }

        @NonNull
        @VisibleForTesting
        public final ClientSettings zaa() {
            SignInOptions signInOptions = SignInOptions.zaa;
            Map map = this.f20018j;
            Api api = com.google.android.gms.signin.zad.zag;
            if (map.containsKey(api)) {
                signInOptions = (SignInOptions) this.f20018j.get(api);
            }
            return new ClientSettings(this.f20009a, this.f20010b, this.f20016h, this.f20012d, this.f20013e, this.f20014f, this.f20015g, signInOptions, false);
        }

        @NonNull
        @CanIgnoreReturnValue
        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <T extends Api.ApiOptions.NotRequiredOptions> Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, @NonNull Scope... scopeArr) {
            Preconditions.checkNotNull(api, "Api must not be null");
            this.f20018j.put(api, null);
            a(api, null, scopeArr);
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o4) {
            Preconditions.checkNotNull(api, "Api must not be null");
            Preconditions.checkNotNull(o4, "Null options are not permitted for this Api");
            this.f20018j.put(api, o4);
            List<Scope> impliedScopes = ((Api.BaseClientBuilder) Preconditions.checkNotNull(api.zac(), "Base client builder must not be null")).getImpliedScopes(o4);
            this.f20011c.addAll(impliedScopes);
            this.f20010b.addAll(impliedScopes);
            return this;
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            Preconditions.checkNotNull(connectionCallbacks, "Must provide a connected listener");
            this.f20025q.add(connectionCallbacks);
            Preconditions.checkNotNull(onConnectionFailedListener, "Must provide a connection failed listener");
            this.f20026r.add(onConnectionFailedListener);
        }
    }
}
