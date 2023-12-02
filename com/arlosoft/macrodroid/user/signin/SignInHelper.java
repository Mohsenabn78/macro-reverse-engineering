package com.arlosoft.macrodroid.user.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.extensions.DialogExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.rest.BaseError;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.events.TemplateStoreRefreshEvent;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.FirebaseUiException;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;
import retrofit2.HttpException;

/* compiled from: SignInHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SignInHelper {
    public static final int REQUEST_CODE_SIGN_IN = 9729;
    @NotNull

    /* renamed from: e */
    private static final List<AuthUI.IdpConfig> f15987e;
    @NotNull

    /* renamed from: a */
    private final Context f15988a;
    @NotNull

    /* renamed from: b */
    private final ScreenLoader f15989b;
    @NotNull

    /* renamed from: c */
    private final TemplateStoreApi f15990c;
    @NotNull

    /* renamed from: d */
    private final UserProvider f15991d;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public interface SignInCallbackHandler {
        void onSignInError();

        void onSignInStarted();

        void onSignedIn(@NotNull User user);

        void onSignedInNoUser();
    }

    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public interface SignOutCallback {
        void onSignedOut();
    }

    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d */
        public static final a f15992d = new a();

        /* compiled from: SignInHelper.kt */
        /* renamed from: com.arlosoft.macrodroid.user.signin.SignInHelper$a$a */
        /* loaded from: classes3.dex */
        public static final class C0130a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d */
            public static final C0130a f15993d = new C0130a();

            C0130a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Publisher<? extends Long> invoke(@NotNull Throwable error) {
                Intrinsics.checkNotNullParameter(error, "error");
                if (new BaseError(error, null, 2, null).isNetworkOrTimeoutError()) {
                    return Observable.timer(2L, TimeUnit.SECONDS).toFlowable(BackpressureStrategy.DROP);
                }
                return Flowable.error(error);
            }
        }

        a() {
            super(1);
        }

        public static final Publisher c(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (Publisher) tmp0.invoke(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Publisher<?> invoke(@NotNull Flowable<Throwable> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            final C0130a c0130a = C0130a.f15993d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.user.signin.h
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = SignInHelper.a.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<User, Unit> {
        final /* synthetic */ SignInCallbackHandler $callbackHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(SignInCallbackHandler signInCallbackHandler) {
            super(1);
            SignInHelper.this = r1;
            this.$callbackHandler = signInCallbackHandler;
        }

        public final void a(@NotNull User user) {
            Intrinsics.checkNotNullParameter(user, "user");
            Settings.setTemplateStoreAccount(SignInHelper.this.f15988a, user);
            this.$callbackHandler.onSignedIn(user);
            EventBusUtils.getEventBus().post(new TemplateStoreRefreshEvent());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            a(user);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ SignInCallbackHandler $callbackHandler;
        final /* synthetic */ String $personalIdentifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, SignInCallbackHandler signInCallbackHandler) {
            super(1);
            SignInHelper.this = r1;
            this.$personalIdentifier = str;
            this.$callbackHandler = signInCallbackHandler;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable th) {
            if (th instanceof HttpException) {
                if (((HttpException) th).code() == 404) {
                    SignInHelper.this.f15989b.loadProfileScreen(true, this.$personalIdentifier, false);
                    return;
                } else {
                    this.$callbackHandler.onSignInError();
                    return;
                }
            }
            this.$callbackHandler.onSignInError();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function0<Unit> {
        final /* synthetic */ Fragment $fragment;
        final /* synthetic */ SignInHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Fragment fragment, SignInHelper signInHelper) {
            super(0);
            this.$fragment = fragment;
            this.this$0 = signInHelper;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            this.$fragment.startActivityForResult(this.this$0.h(), SignInHelper.REQUEST_CODE_SIGN_IN);
        }
    }

    /* compiled from: SignInHelper.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function0<Unit> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ SignInHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Activity activity, SignInHelper signInHelper) {
            super(0);
            this.$activity = activity;
            this.this$0 = signInHelper;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final void invoke2() {
            this.$activity.startActivityForResult(this.this$0.h(), SignInHelper.REQUEST_CODE_SIGN_IN);
        }
    }

    static {
        List<AuthUI.IdpConfig> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AuthUI.IdpConfig[]{new AuthUI.IdpConfig.EmailBuilder().build(), new AuthUI.IdpConfig.GoogleBuilder().build(), new AuthUI.IdpConfig.PhoneBuilder().build()});
        f15987e = listOf;
    }

    @Inject
    public SignInHelper(@ApplicationContext @NotNull Context context, @NotNull ScreenLoader screenLoader, @NotNull TemplateStoreApi api, @NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        this.f15988a = context;
        this.f15989b = screenLoader;
        this.f15990c = api;
        this.f15991d = userProvider;
    }

    public final Intent h() {
        Intent build = ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) ((AuthUI.SignInIntentBuilder) AuthUI.getInstance().createSignInIntentBuilder().setAlwaysShowSignInMethodScreen(true)).setIsSmartLockEnabled(false)).setAvailableProviders(f15987e)).setTheme(R.style.LoginTheme)).setLogo(R.drawable.onboarding_intro)).setAlwaysShowSignInMethodScreen(true)).build();
        Intrinsics.checkNotNullExpressionValue(build, "getInstance()\n          …\n                .build()");
        return build;
    }

    public static /* synthetic */ void handleSignInResult$default(SignInHelper signInHelper, IdpResponse idpResponse, CompositeDisposable compositeDisposable, SignInCallbackHandler signInCallbackHandler, boolean z3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z3 = true;
        }
        signInHelper.handleSignInResult(idpResponse, compositeDisposable, signInCallbackHandler, z3);
    }

    private final void i(String str, CompositeDisposable compositeDisposable, SignInCallbackHandler signInCallbackHandler) {
        signInCallbackHandler.onSignInStarted();
        Single<User> userByPersonalIdentifier = this.f15990c.getUserByPersonalIdentifier(str);
        final a aVar = a.f15992d;
        Single<User> observeOn = userByPersonalIdentifier.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.user.signin.e
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher j4;
                j4 = SignInHelper.j(Function1.this, obj);
                return j4;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final b bVar = new b(signInCallbackHandler);
        Consumer<? super User> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.user.signin.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SignInHelper.k(Function1.this, obj);
            }
        };
        final c cVar = new c(str, signInCallbackHandler);
        compositeDisposable.add(observeOn.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.user.signin.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SignInHelper.l(Function1.this, obj);
            }
        }));
    }

    public static final Publisher j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void m(final Activity activity, final Function0<Unit> function0) {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, R.style.Theme_App_Dialog_Template);
        appCompatDialog.setContentView(R.layout.dialog_user_generated_content_policy);
        appCompatDialog.setTitle(R.string.user_generated_content_policy_title);
        View findViewById = appCompatDialog.findViewById(R.id.okButton);
        Intrinsics.checkNotNull(findViewById);
        View findViewById2 = appCompatDialog.findViewById(R.id.cancelButton);
        Intrinsics.checkNotNull(findViewById2);
        ((Button) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.user.signin.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignInHelper.n(activity, function0, appCompatDialog, view);
            }
        });
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.user.signin.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SignInHelper.o(AppCompatDialog.this, view);
            }
        });
        DialogExtensionsKt.setWidthToParent(appCompatDialog, 0);
        appCompatDialog.show();
    }

    public static final void n(Activity activity, Function0 acceptedCallback, AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(acceptedCallback, "$acceptedCallback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Settings.setHasAcceptedUserGeneratedContentPolicy(activity, true);
        acceptedCallback.invoke();
        dialog.dismiss();
    }

    public static final void o(AppCompatDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    public static final void p(Function0 shouldBlockCallback, Task task) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(shouldBlockCallback, "$shouldBlockCallback");
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful() && (task.getException() instanceof FirebaseException)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) String.valueOf(task.getException()), (CharSequence) "blocked", false, 2, (Object) null);
            if (contains$default) {
                shouldBlockCallback.invoke();
            } else {
                FirebaseAnalyticsEventLogger.logAnonymousSignInFailed(String.valueOf(task.getException()));
            }
        }
    }

    public static final void q(Function0 shouldBlockCallback, Exception e4) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(shouldBlockCallback, "$shouldBlockCallback");
        Intrinsics.checkNotNullParameter(e4, "e");
        if (e4 instanceof FirebaseException) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) e4.toString(), (CharSequence) "blocked", false, 2, (Object) null);
            if (contains$default) {
                shouldBlockCallback.invoke();
            } else {
                FirebaseAnalyticsEventLogger.logAnonymousSignInFailed(e4.toString());
            }
        }
    }

    public final void handleSignInResult(@Nullable IdpResponse idpResponse, @NotNull CompositeDisposable disposable, @NotNull SignInCallbackHandler callbackHandler, boolean z3) {
        Integer num;
        FirebaseUiException error;
        FirebaseUiException error2;
        String phoneNumber;
        Intrinsics.checkNotNullParameter(disposable, "disposable");
        Intrinsics.checkNotNullParameter(callbackHandler, "callbackHandler");
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            if (currentUser.getEmail() != null) {
                phoneNumber = currentUser.getEmail();
            } else {
                phoneNumber = currentUser.getPhoneNumber();
            }
            if (phoneNumber != null) {
                if (z3) {
                    i(phoneNumber, disposable, callbackHandler);
                    return;
                } else {
                    callbackHandler.onSignedInNoUser();
                    return;
                }
            }
            SystemLog.logError("Sign in error, no user email or phone number was returned");
            FirebaseCrashlytics.getInstance().recordException(new Exception("Template store sign in error, no user email or phone number was returned"));
            return;
        }
        Integer num2 = null;
        if (idpResponse != null && (error2 = idpResponse.getError()) != null) {
            num = Integer.valueOf(error2.getErrorCode());
        } else {
            num = null;
        }
        SystemLog.logError("Sign in error: " + num);
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        if (idpResponse != null && (error = idpResponse.getError()) != null) {
            num2 = Integer.valueOf(error.getErrorCode());
        }
        firebaseCrashlytics.recordException(new Exception("Template store Sign in error: " + num2));
    }

    public final void signIn(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (Settings.getHasAcceptedUserGeneratedContentPolicy(this.f15988a)) {
            fragment.startActivityForResult(h(), REQUEST_CODE_SIGN_IN);
            return;
        }
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "fragment.requireActivity()");
        m(requireActivity, new d(fragment, this));
    }

    public final void signInAnonymouslyIfNotSignedIn(@NotNull final Function0<Unit> shouldBlockCallback) {
        Intrinsics.checkNotNullParameter(shouldBlockCallback, "shouldBlockCallback");
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            return;
        }
        FirebaseAuth.getInstance().signInAnonymously().addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.user.signin.c
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                SignInHelper.p(Function0.this, task);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.user.signin.d
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                SignInHelper.q(Function0.this, exc);
            }
        });
    }

    public final void signOut(@Nullable SignOutCallback signOutCallback) {
        this.f15991d.clearUser();
        Context context = this.f15988a;
        ToastCompat.makeText(context, (CharSequence) context.getString(R.string.templates_signed_out_popup), 1).show();
        if (signOutCallback != null) {
            signOutCallback.onSignedOut();
        }
    }

    public final void signIn(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Settings.getHasAcceptedUserGeneratedContentPolicy(this.f15988a)) {
            activity.startActivityForResult(h(), REQUEST_CODE_SIGN_IN);
        } else {
            m(activity, new e(activity, this));
        }
    }
}
