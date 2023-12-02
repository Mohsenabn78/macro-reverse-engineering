package com.arlosoft.macrodroid.plugins;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.common.AppInfo;
import com.arlosoft.macrodroid.extensions.LiveDataExtensionsKt;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.plugins.api.AppBrainApi;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.plugins.api.UploadPluginBody;
import com.arlosoft.macrodroid.plugins.data.AppBrainPackageInfo;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PluginsViewModel.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
/* loaded from: classes3.dex */
public final class PluginsViewModel extends ViewModel {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private static final List<String> f13090k;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f13091a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PluginListApi f13092b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final AppBrainApi f13093c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final UserProvider f13094d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final MutableLiveData<String> f13095e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final LiveData<String> f13096f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final List<String> f13097g;

    /* renamed from: h  reason: collision with root package name */
    private int f13098h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13099i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final SingleLiveEvent<UiState> f13100j;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: PluginsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<String> getAppBrainKeys() {
            return PluginsViewModel.f13090k;
        }
    }

    /* compiled from: PluginsViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static abstract class UiState {
        public static final int $stable = 0;

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class CheckConnection extends UiState {
            public static final int $stable = 0;
            @NotNull
            public static final CheckConnection INSTANCE = new CheckConnection();

            private CheckConnection() {
                super(null);
            }
        }

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class MaxAttemptsPassed extends UiState {
            public static final int $stable = 0;
            @NotNull
            public static final MaxAttemptsPassed INSTANCE = new MaxAttemptsPassed();

            private MaxAttemptsPassed() {
                super(null);
            }
        }

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class PackageNotOnPlayStore extends UiState {
            public static final int $stable = 0;
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final String f13101a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PackageNotOnPlayStore(@NotNull String packageName) {
                super(null);
                Intrinsics.checkNotNullParameter(packageName, "packageName");
                this.f13101a = packageName;
            }

            @NotNull
            public final String getPackageName() {
                return this.f13101a;
            }
        }

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class ShowAppInfoDialog extends UiState {
            public static final int $stable = 0;
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final AppBrainPackageInfo f13102a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowAppInfoDialog(@NotNull AppBrainPackageInfo packageInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
                this.f13102a = packageInfo;
            }

            @NotNull
            public final AppBrainPackageInfo getPackageInfo() {
                return this.f13102a;
            }
        }

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class ShowLoadingBlocker extends UiState {
            public static final int $stable = 0;
            @NotNull
            public static final ShowLoadingBlocker INSTANCE = new ShowLoadingBlocker();

            private ShowLoadingBlocker() {
                super(null);
            }
        }

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class ShowPluginListDialog extends UiState {
            public static final int $stable = 8;
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final List<AppInfo> f13103a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ShowPluginListDialog(@NotNull List<? extends AppInfo> appInfoList) {
                super(null);
                Intrinsics.checkNotNullParameter(appInfoList, "appInfoList");
                this.f13103a = appInfoList;
            }

            @NotNull
            public final List<AppInfo> getAppInfoList() {
                return this.f13103a;
            }
        }

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class UploadComplete extends UiState {
            public static final int $stable = 0;
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final String f13104a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UploadComplete(@NotNull String pluginName) {
                super(null);
                Intrinsics.checkNotNullParameter(pluginName, "pluginName");
                this.f13104a = pluginName;
            }

            @NotNull
            public final String getPluginName() {
                return this.f13104a;
            }
        }

        /* compiled from: PluginsViewModel.kt */
        @StabilityInferred(parameters = 0)
        /* loaded from: classes3.dex */
        public static final class UploadFailed extends UiState {
            public static final int $stable = 0;
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final UploadFailReason f13105a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UploadFailed(@NotNull UploadFailReason uploadFailReason) {
                super(null);
                Intrinsics.checkNotNullParameter(uploadFailReason, "uploadFailReason");
                this.f13105a = uploadFailReason;
            }

            @NotNull
            public final UploadFailReason getUploadFailReason() {
                return this.f13105a;
            }
        }

        private UiState() {
        }

        public /* synthetic */ UiState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PluginsViewModel.kt */
    /* loaded from: classes3.dex */
    public enum UploadFailReason {
        CONNECTION_ERROR,
        ALREADY_EXISTS,
        USER_NOT_ALLOWED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginsViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PluginsViewModel.this.a(null, this);
        }
    }

    /* compiled from: PluginsViewModel.kt */
    /* loaded from: classes3.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $packageName;
        int I$0;
        int I$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.$packageName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new b(this.$packageName, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x014e, code lost:
            if (r6 == 0) goto L13;
         */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ef  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ff  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x010e  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x012a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c2 -> B:66:0x00c8). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0139 -> B:59:0x014e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x014c -> B:59:0x014e). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
            /*
                Method dump skipped, instructions count: 339
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.plugins.PluginsViewModel.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: PluginsViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $developerName;
        final /* synthetic */ String $downloadLink;
        final /* synthetic */ Drawable $drawable;
        final /* synthetic */ String $hash;
        final /* synthetic */ String $iconUrl;
        final /* synthetic */ String $name;
        final /* synthetic */ String $packageName;
        final /* synthetic */ String $shortDescription;
        final /* synthetic */ String $website;
        int label;
        final /* synthetic */ PluginsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Drawable drawable, PluginsViewModel pluginsViewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$drawable = drawable;
            this.this$0 = pluginsViewModel;
            this.$name = str;
            this.$developerName = str2;
            this.$shortDescription = str3;
            this.$packageName = str4;
            this.$downloadLink = str5;
            this.$iconUrl = str6;
            this.$website = str7;
            this.$hash = str8;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$drawable, this.this$0, this.$name, this.$developerName, this.$shortDescription, this.$packageName, this.$downloadLink, this.$iconUrl, this.$website, this.$hash, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x000e, B:28:0x00aa, B:10:0x001b, B:20:0x006e, B:22:0x0072, B:24:0x008e, B:25:0x0090, B:15:0x0025, B:17:0x0029), top: B:47:0x0008 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a9 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                Method dump skipped, instructions count: 285
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.plugins.PluginsViewModel.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"84603.643puiug6j4qnrja6vaf1", "983510.h4klnfj3vg5gu0ney8e2d"});
        f13090k = listOf;
    }

    @Inject
    public PluginsViewModel(@ApplicationContext @NotNull Context context, @NotNull PluginListApi pluginListApi, @NotNull AppBrainApi appBrainApi, @NotNull UserProvider userProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pluginListApi, "pluginListApi");
        Intrinsics.checkNotNullParameter(appBrainApi, "appBrainApi");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        this.f13091a = context;
        this.f13092b = pluginListApi;
        this.f13093c = appBrainApi;
        this.f13094d = userProvider;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this.f13095e = mutableLiveData;
        this.f13096f = LiveDataExtensionsKt.debounce(mutableLiveData, 500L, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()));
        this.f13097g = new ArrayList();
        this.f13100j = new SingleLiveEvent<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.arlosoft.macrodroid.plugins.PluginsViewModel.a
            if (r0 == 0) goto L13
            r0 = r6
            com.arlosoft.macrodroid.plugins.PluginsViewModel$a r0 = (com.arlosoft.macrodroid.plugins.PluginsViewModel.a) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.plugins.PluginsViewModel$a r0 = new com.arlosoft.macrodroid.plugins.PluginsViewModel$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.L$0
            com.arlosoft.macrodroid.plugins.PluginsViewModel r5 = (com.arlosoft.macrodroid.plugins.PluginsViewModel) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L2d
            goto L48
        L2d:
            r6 = move-exception
            goto L4f
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            com.arlosoft.macrodroid.plugins.api.PluginListApi r6 = r4.f13092b     // Catch: java.lang.Exception -> L4d
            r0.L$0 = r4     // Catch: java.lang.Exception -> L4d
            r0.label = r3     // Catch: java.lang.Exception -> L4d
            java.lang.Object r5 = r6.checkPackage(r5, r0)     // Catch: java.lang.Exception -> L4d
            if (r5 != r1) goto L47
            return r1
        L47:
            r5 = r4
        L48:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch: java.lang.Exception -> L2d
            return r5
        L4d:
            r6 = move-exception
            r5 = r4
        L4f:
            boolean r0 = r6 instanceof retrofit2.HttpException
            r1 = 0
            if (r0 == 0) goto L5f
            retrofit2.HttpException r6 = (retrofit2.HttpException) r6
            int r6 = r6.code()
            r0 = 403(0x193, float:5.65E-43)
            if (r6 != r0) goto L5f
            goto L60
        L5f:
            r3 = 0
        L60:
            if (r3 == 0) goto L6f
            com.arlosoft.macrodroid.utils.SingleLiveEvent<com.arlosoft.macrodroid.plugins.PluginsViewModel$UiState> r5 = r5.f13100j
            com.arlosoft.macrodroid.plugins.PluginsViewModel$UiState$UploadFailed r6 = new com.arlosoft.macrodroid.plugins.PluginsViewModel$UiState$UploadFailed
            com.arlosoft.macrodroid.plugins.PluginsViewModel$UploadFailReason r0 = com.arlosoft.macrodroid.plugins.PluginsViewModel.UploadFailReason.ALREADY_EXISTS
            r6.<init>(r0)
            r5.postValue(r6)
            goto L76
        L6f:
            com.arlosoft.macrodroid.utils.SingleLiveEvent<com.arlosoft.macrodroid.plugins.PluginsViewModel$UiState> r5 = r5.f13100j
            com.arlosoft.macrodroid.plugins.PluginsViewModel$UiState$CheckConnection r6 = com.arlosoft.macrodroid.plugins.PluginsViewModel.UiState.CheckConnection.INSTANCE
            r5.postValue(r6)
        L76:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.plugins.PluginsViewModel.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(String str, String str2, Continuation<? super AppBrainPackageInfo> continuation) {
        return this.f13093c.getApp(str, str2, continuation);
    }

    public final void getPluginList() {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new PluginsViewModel$getPluginList$1(this, null), 2, null);
    }

    @NotNull
    public final LiveData<String> getSearchText() {
        return this.f13096f;
    }

    @NotNull
    public final SingleLiveEvent<UiState> getUiState() {
        return this.f13100j;
    }

    public final void onNewSignIn() {
        this.f13099i = false;
    }

    public final void onSubmitAppPackage(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f13100j.postValue(UiState.ShowLoadingBlocker.INSTANCE);
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new b(packageName, null), 2, null);
    }

    public final void sumbitPlugin(@NotNull String packageName, @NotNull String name, @NotNull String developerName, @NotNull String shortDescription, @NotNull String website, @NotNull String downloadLink, @Nullable String str, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(developerName, "developerName");
        Intrinsics.checkNotNullParameter(shortDescription, "shortDescription");
        Intrinsics.checkNotNullParameter(website, "website");
        Intrinsics.checkNotNullParameter(downloadLink, "downloadLink");
        int userId = this.f13094d.getUser().getUserId();
        String sha256 = StringExtensionsKt.sha256(shortDescription + name + TemplateStoreApiKt.TEMPLATE_API_SALT + userId);
        new UploadPluginBody(this.f13094d.getUser().getUserId(), name, developerName, shortDescription, packageName, downloadLink, str, website, "en");
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new c(drawable, this, name, developerName, shortDescription, packageName, downloadLink, str, website, sha256, null), 2, null);
    }

    public final void updateSearchText(@NotNull String searchText) {
        Intrinsics.checkNotNullParameter(searchText, "searchText");
        this.f13095e.postValue(searchText);
    }
}
