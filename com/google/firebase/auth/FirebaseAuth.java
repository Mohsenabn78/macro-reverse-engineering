package com.google.firebase.auth;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.internal.p002firebaseauthapi.zzaas;
import com.google.android.gms.internal.p002firebaseauthapi.zzaax;
import com.google.android.gms.internal.p002firebaseauthapi.zzabh;
import com.google.android.gms.internal.p002firebaseauthapi.zzacg;
import com.google.android.gms.internal.p002firebaseauthapi.zzacq;
import com.google.android.gms.internal.p002firebaseauthapi.zzadu;
import com.google.android.gms.internal.p002firebaseauthapi.zzaee;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzba;
import com.google.firebase.auth.internal.zzbr;
import com.google.firebase.auth.internal.zzbt;
import com.google.firebase.auth.internal.zzbv;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzbz;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public abstract class FirebaseAuth implements InternalAuthProvider {
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f28871a;

    /* renamed from: b  reason: collision with root package name */
    private final List f28872b;

    /* renamed from: c  reason: collision with root package name */
    private final List f28873c;

    /* renamed from: d  reason: collision with root package name */
    private final List f28874d;

    /* renamed from: e  reason: collision with root package name */
    private final zzaao f28875e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private FirebaseUser f28876f;

    /* renamed from: g  reason: collision with root package name */
    private final com.google.firebase.auth.internal.zzw f28877g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f28878h;

    /* renamed from: i  reason: collision with root package name */
    private String f28879i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f28880j;

    /* renamed from: k  reason: collision with root package name */
    private String f28881k;

    /* renamed from: l  reason: collision with root package name */
    private zzbr f28882l;

    /* renamed from: m  reason: collision with root package name */
    private final RecaptchaAction f28883m;

    /* renamed from: n  reason: collision with root package name */
    private final RecaptchaAction f28884n;

    /* renamed from: o  reason: collision with root package name */
    private final RecaptchaAction f28885o;

    /* renamed from: p  reason: collision with root package name */
    private final zzbt f28886p;

    /* renamed from: q  reason: collision with root package name */
    private final zzbz f28887q;

    /* renamed from: r  reason: collision with root package name */
    private final com.google.firebase.auth.internal.zzf f28888r;

    /* renamed from: s  reason: collision with root package name */
    private final Provider f28889s;

    /* renamed from: t  reason: collision with root package name */
    private final Provider f28890t;

    /* renamed from: u  reason: collision with root package name */
    private zzbv f28891u;

    /* renamed from: v  reason: collision with root package name */
    private final Executor f28892v;

    /* renamed from: w  reason: collision with root package name */
    private final Executor f28893w;

    /* renamed from: x  reason: collision with root package name */
    private final Executor f28894x;

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    /* loaded from: classes5.dex */
    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
    /* loaded from: classes5.dex */
    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public FirebaseAuth(@NonNull FirebaseApp firebaseApp, @NonNull Provider provider, @NonNull Provider provider2, @NonNull @Background Executor executor, @NonNull @Blocking Executor executor2, @NonNull @Lightweight Executor executor3, @NonNull @Lightweight ScheduledExecutorService scheduledExecutorService, @NonNull @UiThread Executor executor4) {
        zzadu zzb;
        zzaao zzaaoVar = new zzaao(firebaseApp, executor2, scheduledExecutorService);
        zzbt zzbtVar = new zzbt(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey());
        zzbz zzc = zzbz.zzc();
        com.google.firebase.auth.internal.zzf zzb2 = com.google.firebase.auth.internal.zzf.zzb();
        this.f28872b = new CopyOnWriteArrayList();
        this.f28873c = new CopyOnWriteArrayList();
        this.f28874d = new CopyOnWriteArrayList();
        this.f28878h = new Object();
        this.f28880j = new Object();
        this.f28883m = RecaptchaAction.custom("getOobCode");
        this.f28884n = RecaptchaAction.custom("signInWithPassword");
        this.f28885o = RecaptchaAction.custom("signUpPassword");
        this.f28871a = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.f28875e = (zzaao) Preconditions.checkNotNull(zzaaoVar);
        zzbt zzbtVar2 = (zzbt) Preconditions.checkNotNull(zzbtVar);
        this.f28886p = zzbtVar2;
        this.f28877g = new com.google.firebase.auth.internal.zzw();
        zzbz zzbzVar = (zzbz) Preconditions.checkNotNull(zzc);
        this.f28887q = zzbzVar;
        this.f28888r = (com.google.firebase.auth.internal.zzf) Preconditions.checkNotNull(zzb2);
        this.f28889s = provider;
        this.f28890t = provider2;
        this.f28892v = executor2;
        this.f28893w = executor3;
        this.f28894x = executor4;
        FirebaseUser zza2 = zzbtVar2.zza();
        this.f28876f = zza2;
        if (zza2 != null && (zzb = zzbtVar2.zzb(zza2)) != null) {
            g(this, this.f28876f, zzb, false, false);
        }
        zzbzVar.zze(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static void g(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzadu zzaduVar, boolean z3, boolean z4) {
        boolean z5;
        boolean z6;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzaduVar);
        boolean z7 = false;
        boolean z8 = true;
        if (firebaseAuth.f28876f != null && firebaseUser.getUid().equals(firebaseAuth.f28876f.getUid())) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5 && z4) {
            return;
        }
        FirebaseUser firebaseUser2 = firebaseAuth.f28876f;
        if (firebaseUser2 == null) {
            z6 = true;
        } else {
            z7 = (!z5 || (firebaseUser2.zzd().zze().equals(zzaduVar.zze()) ^ true)) ? true : true;
            z6 = true ^ z5;
            z8 = z7;
        }
        Preconditions.checkNotNull(firebaseUser);
        if (firebaseAuth.f28876f != null && firebaseUser.getUid().equals(firebaseAuth.getUid())) {
            firebaseAuth.f28876f.zzc(firebaseUser.getProviderData());
            if (!firebaseUser.isAnonymous()) {
                firebaseAuth.f28876f.zzb();
            }
            firebaseAuth.f28876f.zzi(firebaseUser.getMultiFactor().getEnrolledFactors());
        } else {
            firebaseAuth.f28876f = firebaseUser;
        }
        if (z3) {
            firebaseAuth.f28886p.zzd(firebaseAuth.f28876f);
        }
        if (z8) {
            FirebaseUser firebaseUser3 = firebaseAuth.f28876f;
            if (firebaseUser3 != null) {
                firebaseUser3.zzh(zzaduVar);
            }
            zzS(firebaseAuth, firebaseAuth.f28876f);
        }
        if (z6) {
            zzR(firebaseAuth, firebaseAuth.f28876f);
        }
        if (z3) {
            firebaseAuth.f28886p.zze(firebaseUser, zzaduVar);
        }
        FirebaseUser firebaseUser4 = firebaseAuth.f28876f;
        if (firebaseUser4 != null) {
            zzD(firebaseAuth).zze(firebaseUser4.zzd());
        }
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    private final Task i(FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, boolean z3) {
        RecaptchaAction recaptchaAction;
        zzab zzabVar = new zzab(this, z3, firebaseUser, emailAuthCredential);
        String str = this.f28881k;
        if (z3) {
            recaptchaAction = this.f28883m;
        } else {
            recaptchaAction = this.f28884n;
        }
        return zzabVar.zzb(this, str, recaptchaAction);
    }

    private final Task j(String str, String str2, @Nullable String str3, @Nullable FirebaseUser firebaseUser, boolean z3) {
        return new zzz(this, str, z3, firebaseUser, str2, str3).zzb(this, str3, this.f28884n);
    }

    private final Task k(EmailAuthCredential emailAuthCredential, @Nullable FirebaseUser firebaseUser, boolean z3) {
        return new zzaa(this, z3, firebaseUser, emailAuthCredential).zzb(this, this.f28881k, this.f28883m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks l(@Nullable String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        com.google.firebase.auth.internal.zzw zzwVar = this.f28877g;
        if (zzwVar.zzd() && str != null && str.equals(zzwVar.zza())) {
            return new zzl(this, onVerificationStateChangedCallbacks);
        }
        return onVerificationStateChangedCallbacks;
    }

    private final boolean m(String str) {
        ActionCodeUrl parseLink = ActionCodeUrl.parseLink(str);
        if (parseLink != null && !TextUtils.equals(this.f28881k, parseLink.zza())) {
            return true;
        }
        return false;
    }

    public static zzbv zzD(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.f28891u == null) {
            firebaseAuth.f28891u = new zzbv((FirebaseApp) Preconditions.checkNotNull(firebaseAuth.f28871a));
        }
        return firebaseAuth.f28891u;
    }

    public static void zzR(@NonNull FirebaseAuth firebaseAuth, @Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder();
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
        }
        firebaseAuth.f28894x.execute(new zzw(firebaseAuth));
    }

    public static void zzS(@NonNull FirebaseAuth firebaseAuth, @Nullable FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder();
            sb.append("Notifying id token listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
        }
        if (firebaseUser != null) {
            str = firebaseUser.zze();
        } else {
            str = null;
        }
        firebaseAuth.f28894x.execute(new zzv(firebaseAuth, new InternalTokenResult(str)));
    }

    public static final void zzX(@NonNull final FirebaseAuthMissingActivityForRecaptchaException firebaseAuthMissingActivityForRecaptchaException, @NonNull PhoneAuthOptions phoneAuthOptions, @NonNull String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback with MissingActivity exception for phone number/uid - ".concat(String.valueOf(str)));
        final PhoneAuthProvider.OnVerificationStateChangedCallbacks zza2 = zzacg.zza(str, phoneAuthOptions.zze(), null);
        phoneAuthOptions.zzi().execute(new Runnable() { // from class: com.google.firebase.auth.zzi
            @Override // java.lang.Runnable
            public final void run() {
                PhoneAuthProvider.OnVerificationStateChangedCallbacks.this.onVerificationFailed(firebaseAuthMissingActivityForRecaptchaException);
            }
        });
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.f28874d.add(authStateListener);
        this.f28894x.execute(new zzu(this, authStateListener));
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.f28872b.add(idTokenListener);
        this.f28894x.execute(new zzs(this, idTokenListener));
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zza(this.f28871a, str, this.f28881k);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zzb(this.f28871a, str, this.f28881k);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.f28875e.zzc(this.f28871a, str, str2, this.f28881k);
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return new zzn(this, str, str2).zzb(this, this.f28881k, this.f28885o);
    }

    @NonNull
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zzf(this.f28871a, str, this.f28881k);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    @NonNull
    public final Task getAccessToken(boolean z3) {
        return zzc(this.f28876f, z3);
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.f28871a;
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.f28876f;
    }

    @NonNull
    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.f28877g;
    }

    @Nullable
    public String getLanguageCode() {
        String str;
        synchronized (this.f28878h) {
            str = this.f28879i;
        }
        return str;
    }

    @Nullable
    public Task<AuthResult> getPendingAuthResult() {
        return this.f28887q.zza();
    }

    @Nullable
    public String getTenantId() {
        String str;
        synchronized (this.f28880j) {
            str = this.f28881k;
        }
        return str;
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider, com.google.firebase.internal.InternalTokenProvider
    @Nullable
    public final String getUid() {
        FirebaseUser firebaseUser = this.f28876f;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.getUid();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean h() {
        return zzaax.zza(getApp().getApplicationContext());
    }

    @NonNull
    public Task<Void> initializeRecaptchaConfig() {
        if (this.f28882l == null) {
            this.f28882l = new zzbr(this.f28871a, this);
        }
        return this.f28882l.zzb(this.f28881k, Boolean.FALSE).continueWithTask(new zzy(this));
    }

    public boolean isSignInWithEmailLink(@NonNull String str) {
        return EmailAuthCredential.zzi(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks q(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        if (phoneAuthOptions.zzk()) {
            return onVerificationStateChangedCallbacks;
        }
        return new zzm(this, phoneAuthOptions, onVerificationStateChangedCallbacks);
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.f28874d.remove(authStateListener);
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.f28872b.remove(idTokenListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, null);
    }

    @NonNull
    public Task<Void> sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (actionCodeSettings.canHandleCodeInApp()) {
            String str2 = this.f28879i;
            if (str2 != null) {
                actionCodeSettings.zzf(str2);
            }
            return new zzp(this, str, actionCodeSettings).zzb(this, this.f28881k, this.f28883m);
        }
        throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
    }

    @NonNull
    public Task<Void> setFirebaseUIVersion(@Nullable String str) {
        return this.f28875e.zzA(str);
    }

    public void setLanguageCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.f28878h) {
            this.f28879i = str;
        }
    }

    public void setTenantId(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.f28880j) {
            this.f28881k = str;
        }
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        FirebaseUser firebaseUser = this.f28876f;
        if (firebaseUser != null && firebaseUser.isAnonymous()) {
            com.google.firebase.auth.internal.zzx zzxVar = (com.google.firebase.auth.internal.zzx) this.f28876f;
            zzxVar.zzq(false);
            return Tasks.forResult(new com.google.firebase.auth.internal.zzr(zzxVar));
        }
        return this.f28875e.zzB(this.f28871a, new zzac(this), this.f28881k);
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if (!emailAuthCredential.zzg()) {
                return j(emailAuthCredential.zzd(), (String) Preconditions.checkNotNull(emailAuthCredential.zze()), this.f28881k, null, false);
            }
            if (m(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaas.zza(new Status(17072)));
            }
            return k(emailAuthCredential, null, false);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.f28875e.zzG(this.f28871a, (PhoneAuthCredential) zza2, this.f28881k, new zzac(this));
        } else {
            return this.f28875e.zzC(this.f28871a, zza2, this.f28881k, new zzac(this));
        }
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zzD(this.f28871a, str, this.f28881k, new zzac(this));
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return j(str, str2, this.f28881k, null, false);
    }

    @NonNull
    public Task<AuthResult> signInWithEmailLink(@NonNull String str, @NonNull String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzO();
        zzbv zzbvVar = this.f28891u;
        if (zzbvVar != null) {
            zzbvVar.zzc();
        }
    }

    @NonNull
    public Task<AuthResult> startActivityForSignInWithProvider(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider) {
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.f28887q.zzi(activity, taskCompletionSource, this)) {
            return Tasks.forException(zzaas.zza(new Status(17057)));
        }
        this.f28887q.zzg(activity.getApplicationContext(), this);
        federatedAuthProvider.zzc(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Void> updateCurrentUser(@NonNull FirebaseUser firebaseUser) {
        String str;
        if (firebaseUser != null) {
            String tenantId = firebaseUser.getTenantId();
            if ((tenantId != null && !tenantId.equals(this.f28881k)) || ((str = this.f28881k) != null && !str.equals(tenantId))) {
                return Tasks.forException(zzaas.zza(new Status(17072)));
            }
            String apiKey = firebaseUser.zza().getOptions().getApiKey();
            String apiKey2 = this.f28871a.getOptions().getApiKey();
            if (firebaseUser.zzd().zzj() && apiKey2.equals(apiKey)) {
                zzQ(com.google.firebase.auth.internal.zzx.zzk(this.f28871a, firebaseUser), firebaseUser.zzd(), true);
                return Tasks.forResult(null);
            }
            return zzi(firebaseUser, new zzae(this));
        }
        throw new IllegalArgumentException("Cannot update current user with null user!");
    }

    public void useAppLanguage() {
        synchronized (this.f28878h) {
            this.f28879i = zzabh.zza();
        }
    }

    public void useEmulator(@NonNull String str, int i4) {
        Preconditions.checkNotEmpty(str);
        boolean z3 = false;
        if (i4 >= 0 && i4 <= 65535) {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "Port number must be in the range 0-65535");
        zzacq.zzf(this.f28871a, str, i4);
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zzR(this.f28871a, str, this.f28881k);
    }

    public final synchronized zzbr zzB() {
        return this.f28882l;
    }

    @VisibleForTesting
    public final synchronized zzbv zzC() {
        return zzD(this);
    }

    @NonNull
    public final Provider zzE() {
        return this.f28889s;
    }

    @NonNull
    public final Provider zzF() {
        return this.f28890t;
    }

    @NonNull
    public final Executor zzL() {
        return this.f28892v;
    }

    @NonNull
    public final Executor zzM() {
        return this.f28893w;
    }

    @NonNull
    public final Executor zzN() {
        return this.f28894x;
    }

    public final void zzO() {
        Preconditions.checkNotNull(this.f28886p);
        FirebaseUser firebaseUser = this.f28876f;
        if (firebaseUser != null) {
            zzbt zzbtVar = this.f28886p;
            Preconditions.checkNotNull(firebaseUser);
            zzbtVar.zzc(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()));
            this.f28876f = null;
        }
        this.f28886p.zzc("com.google.firebase.auth.FIREBASE_USER");
        zzS(this, null);
        zzR(this, null);
    }

    public final synchronized void zzP(zzbr zzbrVar) {
        this.f28882l = zzbrVar;
    }

    public final void zzQ(FirebaseUser firebaseUser, zzadu zzaduVar, boolean z3) {
        g(this, firebaseUser, zzaduVar, true, false);
    }

    public final void zzU(@NonNull PhoneAuthOptions phoneAuthOptions) {
        String phoneNumber;
        String str;
        if (phoneAuthOptions.zzm()) {
            FirebaseAuth zzb = phoneAuthOptions.zzb();
            if (((com.google.firebase.auth.internal.zzag) Preconditions.checkNotNull(phoneAuthOptions.zzc())).zzf()) {
                phoneNumber = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
                str = phoneNumber;
            } else {
                PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(phoneAuthOptions.zzf());
                String checkNotEmpty = Preconditions.checkNotEmpty(phoneMultiFactorInfo.getUid());
                phoneNumber = phoneMultiFactorInfo.getPhoneNumber();
                str = checkNotEmpty;
            }
            if (phoneAuthOptions.zzd() == null || !zzacg.zzd(str, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
                zzb.f28888r.zza(zzb, phoneNumber, phoneAuthOptions.zza(), zzb.h(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzk(zzb, phoneAuthOptions, str));
                return;
            }
            return;
        }
        FirebaseAuth zzb2 = phoneAuthOptions.zzb();
        String checkNotEmpty2 = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
        if (phoneAuthOptions.zzd() == null && zzacg.zzd(checkNotEmpty2, phoneAuthOptions.zze(), phoneAuthOptions.zza(), phoneAuthOptions.zzi())) {
            return;
        }
        zzb2.f28888r.zza(zzb2, checkNotEmpty2, phoneAuthOptions.zza(), zzb2.h(), phoneAuthOptions.zzk()).addOnCompleteListener(new zzj(zzb2, phoneAuthOptions, checkNotEmpty2));
    }

    public final void zzV(@NonNull PhoneAuthOptions phoneAuthOptions, @Nullable String str, @Nullable String str2) {
        boolean z3;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks;
        long longValue = phoneAuthOptions.zzg().longValue();
        if (longValue >= 0 && longValue <= 120) {
            String checkNotEmpty = Preconditions.checkNotEmpty(phoneAuthOptions.zzh());
            if (phoneAuthOptions.zzd() != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzaee zzaeeVar = new zzaee(checkNotEmpty, longValue, z3, this.f28879i, this.f28881k, str, str2, h());
            PhoneAuthProvider.OnVerificationStateChangedCallbacks l4 = l(checkNotEmpty, phoneAuthOptions.zze());
            if (TextUtils.isEmpty(str)) {
                onVerificationStateChangedCallbacks = q(phoneAuthOptions, l4);
            } else {
                onVerificationStateChangedCallbacks = l4;
            }
            this.f28875e.zzT(this.f28871a, zzaeeVar, onVerificationStateChangedCallbacks, phoneAuthOptions.zza(), phoneAuthOptions.zzi());
            return;
        }
        throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
    }

    @NonNull
    public final Task zza(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.f28875e.zze(firebaseUser, new zzr(this, firebaseUser));
    }

    @NonNull
    public final Task zzb(@NonNull FirebaseUser firebaseUser, @NonNull MultiFactorAssertion multiFactorAssertion, @Nullable String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(multiFactorAssertion);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.f28875e.zzg(this.f28871a, (PhoneMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, new zzac(this));
        }
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.f28875e.zzh(this.f28871a, (TotpMultiFactorAssertion) multiFactorAssertion, firebaseUser, str, this.f28881k, new zzac(this));
        }
        return Tasks.forException(zzaas.zza(new Status(FirebaseError.ERROR_INTERNAL_ERROR)));
    }

    @NonNull
    public final Task zzc(@Nullable FirebaseUser firebaseUser, boolean z3) {
        if (firebaseUser == null) {
            return Tasks.forException(zzaas.zza(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzadu zzd = firebaseUser.zzd();
        if (zzd.zzj() && !z3) {
            return Tasks.forResult(zzba.zza(zzd.zze()));
        }
        return this.f28875e.zzk(this.f28871a, firebaseUser, zzd.zzf(), new zzx(this));
    }

    @NonNull
    public final Task zzd() {
        return this.f28875e.zzl();
    }

    @NonNull
    public final Task zze(@NonNull String str) {
        return this.f28875e.zzm(this.f28881k, "RECAPTCHA_ENTERPRISE");
    }

    @NonNull
    public final Task zzf(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.f28875e.zzn(this.f28871a, firebaseUser, authCredential.zza(), new zzad(this));
    }

    @NonNull
    public final Task zzg(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return i(firebaseUser, emailAuthCredential, false);
            }
            if (m(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaas.zza(new Status(17072)));
            }
            return i(firebaseUser, emailAuthCredential, true);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.f28875e.zzu(this.f28871a, firebaseUser, (PhoneAuthCredential) zza2, this.f28881k, new zzad(this));
        } else {
            return this.f28875e.zzo(this.f28871a, firebaseUser, zza2, firebaseUser.getTenantId(), new zzad(this));
        }
    }

    @NonNull
    public final Task zzh(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        AuthCredential zza2 = authCredential.zza();
        if (zza2 instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zza2;
            if ("password".equals(emailAuthCredential.getSignInMethod())) {
                return j(emailAuthCredential.zzd(), Preconditions.checkNotEmpty(emailAuthCredential.zze()), firebaseUser.getTenantId(), firebaseUser, true);
            }
            if (m(Preconditions.checkNotEmpty(emailAuthCredential.zzf()))) {
                return Tasks.forException(zzaas.zza(new Status(17072)));
            }
            return k(emailAuthCredential, firebaseUser, true);
        } else if (zza2 instanceof PhoneAuthCredential) {
            return this.f28875e.zzv(this.f28871a, firebaseUser, (PhoneAuthCredential) zza2, this.f28881k, new zzad(this));
        } else {
            return this.f28875e.zzp(this.f28871a, firebaseUser, zza2, firebaseUser.getTenantId(), new zzad(this));
        }
    }

    public final Task zzi(FirebaseUser firebaseUser, zzbx zzbxVar) {
        Preconditions.checkNotNull(firebaseUser);
        return this.f28875e.zzw(this.f28871a, firebaseUser, zzbxVar);
    }

    public final Task zzj(MultiFactorAssertion multiFactorAssertion, com.google.firebase.auth.internal.zzag zzagVar, @Nullable FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzagVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            return this.f28875e.zzi(this.f28871a, firebaseUser, (PhoneMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzagVar.zze()), new zzac(this));
        }
        if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            return this.f28875e.zzj(this.f28871a, firebaseUser, (TotpMultiFactorAssertion) multiFactorAssertion, Preconditions.checkNotEmpty(zzagVar.zze()), this.f28881k, new zzac(this));
        }
        throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
    }

    @NonNull
    public final Task zzk(@Nullable ActionCodeSettings actionCodeSettings, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        if (this.f28879i != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzb();
            }
            actionCodeSettings.zzf(this.f28879i);
        }
        return this.f28875e.zzx(this.f28871a, actionCodeSettings, str);
    }

    @NonNull
    public final Task zzl(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.f28887q.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaas.zza(new Status(17057)));
        }
        this.f28887q.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zza(activity);
        return taskCompletionSource.getTask();
    }

    @NonNull
    public final Task zzm(@NonNull Activity activity, @NonNull FederatedAuthProvider federatedAuthProvider, @NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(federatedAuthProvider);
        Preconditions.checkNotNull(firebaseUser);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (!this.f28887q.zzj(activity, taskCompletionSource, this, firebaseUser)) {
            return Tasks.forException(zzaas.zza(new Status(17057)));
        }
        this.f28887q.zzh(activity.getApplicationContext(), this, firebaseUser);
        federatedAuthProvider.zzb(activity);
        return taskCompletionSource.getTask();
    }

    public final Task zzn(com.google.firebase.auth.internal.zzag zzagVar) {
        Preconditions.checkNotNull(zzagVar);
        return this.f28875e.zzI(zzagVar, this.f28881k).continueWithTask(new zzt(this));
    }

    @NonNull
    public final Task zzo(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zzK(this.f28871a, firebaseUser, str, this.f28881k, new zzad(this)).continueWithTask(new zzq(this));
    }

    @NonNull
    public final Task zzp(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.f28875e.zzL(this.f28871a, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzq(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zzM(this.f28871a, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzr(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.f28875e.zzN(this.f28871a, firebaseUser, str, new zzad(this));
    }

    @NonNull
    public final Task zzs(@NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.f28875e.zzO(this.f28871a, firebaseUser, phoneAuthCredential.clone(), new zzad(this));
    }

    @NonNull
    public final Task zzt(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.f28875e.zzP(this.f28871a, firebaseUser, userProfileChangeRequest, new zzad(this));
    }

    @NonNull
    public final Task zzu(@NonNull String str, @NonNull String str2, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str3 = this.f28879i;
        if (str3 != null) {
            actionCodeSettings.zzf(str3);
        }
        return this.f28875e.zzQ(str, str2, actionCodeSettings);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    @KeepForSdk
    public void removeIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.f28873c.remove(idTokenListener);
        zzC().zzd(this.f28873c.size());
    }

    @NonNull
    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    @Override // com.google.firebase.auth.internal.InternalAuthProvider
    @KeepForSdk
    public void addIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.f28873c.add(idTokenListener);
        zzC().zzd(this.f28873c.size());
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzb();
        }
        String str2 = this.f28879i;
        if (str2 != null) {
            actionCodeSettings.zzf(str2);
        }
        actionCodeSettings.zzg(1);
        return new zzo(this, str, actionCodeSettings).zzb(this, this.f28881k, this.f28883m);
    }
}
