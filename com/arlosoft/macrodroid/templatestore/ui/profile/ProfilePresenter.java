package com.arlosoft.macrodroid.templatestore.ui.profile;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.mvp.Presenter;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.events.TemplateStoreRefreshEvent;
import com.arlosoft.macrodroid.templatestore.model.User;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateRefreshNotifier;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import me.drakeet.support.toast.ToastCompat;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.HttpException;

/* compiled from: ProfilePresenter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ProfilePresenter extends Presenter<ProfileViewContract> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ScreenLoader f13817b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final TemplateStoreApi f13818c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final UserProvider f13819d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Context f13820e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final TemplateRefreshNotifier f13821f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final LocalTemplateOverrideStore f13822g;

    /* renamed from: h  reason: collision with root package name */
    private CompositeDisposable f13823h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfilePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<User, Unit> {
        a() {
            super(1);
        }

        public final void a(User user) {
            Settings.setTemplateStoreAccount(ProfilePresenter.this.f13820e, user);
            ProfilePresenter.this.f13817b.closeCurrentScreen();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            a(user);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfilePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<Throwable, Unit> {
        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if ((th instanceof HttpException) && ((HttpException) th).code() == 409) {
                ProfileViewContract view = ProfilePresenter.this.getView();
                if (view != null) {
                    view.showUsernameTaken();
                    return;
                }
                return;
            }
            ProfileViewContract view2 = ProfilePresenter.this.getView();
            if (view2 != null) {
                view2.showGenericError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfilePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<Throwable, Unit> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ProfileViewContract view = ProfilePresenter.this.getView();
            if (view != null) {
                view.showDeleteFailed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfilePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<User, Unit> {
        final /* synthetic */ MultipartBody.Part $image;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MultipartBody.Part part) {
            super(1);
            this.$image = part;
        }

        public final void a(User user) {
            Settings.setTemplateStoreAccount(ProfilePresenter.this.f13820e, user);
            ProfilePresenter.this.f13817b.closeCurrentScreen();
            if (this.$image != null) {
                ProfilePresenter.this.f13821f.notifyRefreshRequired();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            a(user);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ProfilePresenter.kt */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if ((th instanceof HttpException) && ((HttpException) th).code() == 409) {
                ProfileViewContract view = ProfilePresenter.this.getView();
                if (view != null) {
                    view.showUsernameTaken();
                    return;
                }
                return;
            }
            ProfileViewContract view2 = ProfilePresenter.this.getView();
            if (view2 != null) {
                view2.showGenericError();
            }
        }
    }

    @Inject
    public ProfilePresenter(@NotNull ScreenLoader screenLoader, @NotNull TemplateStoreApi api, @NotNull UserProvider userProvider, @ApplicationContext @NotNull Context context, @NotNull TemplateRefreshNotifier templateRefreshNotifier, @NotNull LocalTemplateOverrideStore templateOverrideStore) {
        Intrinsics.checkNotNullParameter(screenLoader, "screenLoader");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateRefreshNotifier, "templateRefreshNotifier");
        Intrinsics.checkNotNullParameter(templateOverrideStore, "templateOverrideStore");
        this.f13817b = screenLoader;
        this.f13818c = api;
        this.f13819d = userProvider;
        this.f13820e = context;
        this.f13821f = templateRefreshNotifier;
        this.f13822g = templateOverrideStore;
    }

    private final void k(String str, String str2, String str3, MultipartBody.Part part) {
        Single<User> addUser;
        ProfileViewContract view = getView();
        if (view != null) {
            view.setLoadingState(true);
        }
        String sha256 = StringExtensionsKt.sha256(str + TemplateStoreApiKt.TEMPLATE_API_SALT + str2 + str3);
        CompositeDisposable compositeDisposable = this.f13823h;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        if (part != null) {
            addUser = this.f13818c.addUserWithImage(sha256, str, str2, str3, part);
        } else {
            addUser = this.f13818c.addUser(sha256, str, str2, str3);
        }
        Single<User> doFinally = addUser.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.m
            @Override // io.reactivex.functions.Action
            public final void run() {
                ProfilePresenter.l(ProfilePresenter.this);
            }
        });
        final a aVar = new a();
        Consumer<? super User> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProfilePresenter.m(Function1.this, obj);
            }
        };
        final b bVar = new b();
        compositeDisposable.add(doFinally.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProfilePresenter.n(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(ProfilePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProfileViewContract view = this$0.getView();
        if (view != null) {
            view.setLoadingState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ProfilePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f13822g.clearAll();
        this$0.signOut();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void q(String str, MultipartBody.Part part) {
        Single<User> updateUser;
        ProfileViewContract view = getView();
        if (view != null) {
            view.setLoadingState(true);
        }
        int userId = this.f13819d.getUser().getUserId();
        String sha256 = StringExtensionsKt.sha256(userId + TemplateStoreApiKt.TEMPLATE_API_SALT + str);
        CompositeDisposable compositeDisposable = this.f13823h;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        if (part != null) {
            updateUser = this.f13818c.updateUserWithImage(sha256, this.f13819d.getUser().getUserId(), str, part);
        } else {
            updateUser = this.f13818c.updateUser(sha256, this.f13819d.getUser().getUserId(), str);
        }
        Single<User> doFinally = updateUser.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doFinally(new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.j
            @Override // io.reactivex.functions.Action
            public final void run() {
                ProfilePresenter.r(ProfilePresenter.this);
            }
        });
        final d dVar = new d(part);
        Consumer<? super User> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProfilePresenter.s(Function1.this, obj);
            }
        };
        final e eVar = new e();
        compositeDisposable.add(doFinally.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.l
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProfilePresenter.t(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ProfilePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProfileViewContract view = this$0.getView();
        if (view != null) {
            view.setLoadingState(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void a() {
        CompositeDisposable compositeDisposable = this.f13823h;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        compositeDisposable.clear();
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void b() {
        this.f13823h = new CompositeDisposable();
    }

    public final void deleteProfile() {
        int userId = this.f13819d.getUser().getUserId();
        String sha256 = StringExtensionsKt.sha256(userId + TemplateStoreApiKt.TEMPLATE_API_SALT);
        CompositeDisposable compositeDisposable = this.f13823h;
        if (compositeDisposable == null) {
            Intrinsics.throwUninitializedPropertyAccessException("compositeDisposable");
            compositeDisposable = null;
        }
        Completable observeOn = this.f13818c.deleteUser(sha256, this.f13819d.getUser().getUserId()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        Action action = new Action() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.h
            @Override // io.reactivex.functions.Action
            public final void run() {
                ProfilePresenter.o(ProfilePresenter.this);
            }
        };
        final c cVar = new c();
        compositeDisposable.add(observeOn.subscribe(action, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ProfilePresenter.p(Function1.this, obj);
            }
        }));
    }

    public final void onSignOutClick() {
        ProfileViewContract view = getView();
        if (view != null) {
            view.showConfirmSignOut();
        }
    }

    public final void saveProfileData(boolean z3, @NotNull String username, @NotNull String personalIdentifier, @NotNull String description, @Nullable File file) {
        MultipartBody.Part part;
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(personalIdentifier, "personalIdentifier");
        Intrinsics.checkNotNullParameter(description, "description");
        ProfileViewContract view = getView();
        if (view != null) {
            view.hideKeyboard();
        }
        if (z3 && (username.length() < 3 || username.length() > 20)) {
            ProfileViewContract view2 = getView();
            if (view2 != null) {
                view2.showInvalidUsername();
                return;
            }
            return;
        }
        if (file != null) {
            part = MultipartBody.Part.Companion.createFormData("upload", file.getName(), RequestBody.Companion.create(MediaType.Companion.parse(ImageUtils.MIME_TYPE_IMAGE_WILDCARD), file));
        } else {
            part = null;
        }
        if (z3) {
            k(username, personalIdentifier, description, part);
        } else {
            q(description, part);
        }
    }

    public final void signOut() {
        this.f13819d.clearUser();
        ToastCompat.makeText(this.f13820e.getApplicationContext(), (CharSequence) this.f13820e.getString(R.string.templates_signed_out_popup), 1).show();
        this.f13817b.closeCurrentScreen();
        EventBusUtils.getEventBus().post(new TemplateStoreRefreshEvent());
    }
}
