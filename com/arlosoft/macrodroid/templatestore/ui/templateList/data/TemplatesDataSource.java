package com.arlosoft.macrodroid.templatestore.ui.templateList.data;

import android.content.Context;
import android.content.pm.Signature;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.database.room.BlockedMacro;
import com.arlosoft.macrodroid.database.room.BlockedUser;
import com.arlosoft.macrodroid.extensions.StringExtensionsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.rest.BaseError;
import com.arlosoft.macrodroid.settings.AppPreferences;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApiKt;
import com.arlosoft.macrodroid.templatestore.common.LoadState;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.ui.templateList.data.TemplatesDataSource;
import com.arlosoft.macrodroid.utils.SigningHelper;
import com.google.gson.Gson;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;
import retrofit2.HttpException;
import retrofit2.Response;

/* compiled from: TemplateDataSource.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TemplatesDataSource extends PageKeyedDataSource<Integer, MacroTemplate> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Gson f14026a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final TemplateStoreApi f14027b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CompositeDisposable f14028c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14029d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14030e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14031f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14032g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final String f14033h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final AppPreferences f14034i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final CategoriesHelper f14035j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final String f14036k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private List<BlockedUser> f14037l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private List<BlockedMacro> f14038m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final String[] f14039n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final String[] f14040o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private MutableLiveData<LoadState> f14041p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private final String f14042q;

    /* compiled from: TemplateDataSource.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final a f14043d = new a();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateDataSource.kt */
        /* renamed from: com.arlosoft.macrodroid.templatestore.ui.templateList.data.TemplatesDataSource$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0121a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0121a f14044d = new C0121a();

            C0121a() {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Publisher c(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (Publisher) tmp0.invoke(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Publisher<?> invoke(@NotNull Flowable<Throwable> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            final C0121a c0121a = C0121a.f14044d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.g
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = TemplatesDataSource.a.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: TemplateDataSource.kt */
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<Flowable<Throwable>, Publisher<?>> {

        /* renamed from: d  reason: collision with root package name */
        public static final b f14045d = new b();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TemplateDataSource.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<Throwable, Publisher<? extends Long>> {

            /* renamed from: d  reason: collision with root package name */
            public static final a f14046d = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final Publisher<? extends Long> invoke(@NotNull Throwable it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Observable.timer(2L, TimeUnit.SECONDS).toFlowable(BackpressureStrategy.DROP);
            }
        }

        b() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Publisher c(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (Publisher) tmp0.invoke(obj);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final Publisher<?> invoke(@NotNull Flowable<Throwable> errors) {
            Intrinsics.checkNotNullParameter(errors, "errors");
            final a aVar = a.f14046d;
            return errors.flatMap(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.h
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    Publisher c4;
                    c4 = TemplatesDataSource.b.c(Function1.this, obj);
                    return c4;
                }
            });
        }
    }

    /* compiled from: TemplateDataSource.kt */
    @SourceDebugExtension({"SMAP\nTemplateDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateDataSource.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/data/TemplatesDataSource$loadAfter$3\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,199:1\n1549#2:200\n1620#2,3:201\n1549#2:204\n1620#2,3:205\n*S KotlinDebug\n*F\n+ 1 TemplateDataSource.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/data/TemplatesDataSource$loadAfter$3\n*L\n139#1:200\n139#1:201,3\n140#1:204\n140#1:205,3\n*E\n"})
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<List<? extends MacroTemplate>, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadCallback<Integer, MacroTemplate> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadParams<Integer> $params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(PageKeyedDataSource.LoadCallback<Integer, MacroTemplate> loadCallback, PageKeyedDataSource.LoadParams<Integer> loadParams) {
            super(1);
            this.$callback = loadCallback;
            this.$params = loadParams;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends MacroTemplate> list) {
            invoke2((List<MacroTemplate>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<MacroTemplate> list) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            ArrayList arrayList = new ArrayList();
            try {
                List<BlockedUser> list2 = TemplatesDataSource.this.f14037l;
                collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (BlockedUser blockedUser : list2) {
                    arrayList2.add(Integer.valueOf(blockedUser.getUserId()));
                }
                List<BlockedMacro> list3 = TemplatesDataSource.this.f14038m;
                collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list3, 10);
                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                for (BlockedMacro blockedMacro : list3) {
                    arrayList3.add(Integer.valueOf(blockedMacro.getMacroId()));
                }
                for (MacroTemplate macroTemplate : list) {
                    if (!arrayList2.contains(Integer.valueOf(macroTemplate.getUserId())) && !arrayList3.contains(Integer.valueOf(macroTemplate.getId()))) {
                        Macro macro = (Macro) TemplatesDataSource.this.f14026a.fromJson(URLDecoder.decode(macroTemplate.getJson(), "utf-8"), (Class<Object>) Macro.class);
                        macro.setDescription(macroTemplate.getDescription());
                        macro.setName(macroTemplate.getName());
                        macro.setCategory(TemplatesDataSource.this.f14035j.getCategoryNameFromId(macroTemplate.getCategoryId()));
                        macroTemplate.setMacro(macro);
                        macroTemplate.setUseTranslatedText(TemplatesDataSource.this.f14034i.getAutoTranslateTemplates());
                        arrayList.add(macroTemplate);
                    }
                }
            } catch (Exception unused) {
            }
            this.$callback.onResult(arrayList, Integer.valueOf(this.$params.key.intValue() + 1));
        }
    }

    /* compiled from: TemplateDataSource.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadCallback<Integer, MacroTemplate> $callback;
        final /* synthetic */ PageKeyedDataSource.LoadParams<Integer> $params;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(PageKeyedDataSource.LoadCallback<Integer, MacroTemplate> loadCallback, PageKeyedDataSource.LoadParams<Integer> loadParams) {
            super(1);
            this.$callback = loadCallback;
            this.$params = loadParams;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            List<? extends MacroTemplate> emptyList;
            PageKeyedDataSource.LoadCallback<Integer, MacroTemplate> loadCallback = this.$callback;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            loadCallback.onResult(emptyList, Integer.valueOf(this.$params.key.intValue() + 1));
        }
    }

    /* compiled from: TemplateDataSource.kt */
    @SourceDebugExtension({"SMAP\nTemplateDataSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TemplateDataSource.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/data/TemplatesDataSource$loadInitial$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,199:1\n1549#2:200\n1620#2,3:201\n1549#2:204\n1620#2,3:205\n*S KotlinDebug\n*F\n+ 1 TemplateDataSource.kt\ncom/arlosoft/macrodroid/templatestore/ui/templateList/data/TemplatesDataSource$loadInitial$1\n*L\n82#1:200\n82#1:201,3\n83#1:204\n83#1:205,3\n*E\n"})
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<List<? extends MacroTemplate>, Unit> {
        final /* synthetic */ PageKeyedDataSource.LoadInitialCallback<Integer, MacroTemplate> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(PageKeyedDataSource.LoadInitialCallback<Integer, MacroTemplate> loadInitialCallback) {
            super(1);
            this.$callback = loadInitialCallback;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends MacroTemplate> list) {
            invoke2((List<MacroTemplate>) list);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(List<MacroTemplate> list) {
            int collectionSizeOrDefault;
            int collectionSizeOrDefault2;
            ArrayList arrayList = new ArrayList();
            for (MacroTemplate macroTemplate : list) {
                try {
                    List<BlockedUser> list2 = TemplatesDataSource.this.f14037l;
                    collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    for (BlockedUser blockedUser : list2) {
                        arrayList2.add(Integer.valueOf(blockedUser.getUserId()));
                    }
                    List<BlockedMacro> list3 = TemplatesDataSource.this.f14038m;
                    collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list3, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
                    for (BlockedMacro blockedMacro : list3) {
                        arrayList3.add(Integer.valueOf(blockedMacro.getMacroId()));
                    }
                    if (!arrayList2.contains(Integer.valueOf(macroTemplate.getUserId())) && !arrayList3.contains(Integer.valueOf(macroTemplate.getId()))) {
                        Macro macro = (Macro) TemplatesDataSource.this.f14026a.fromJson(URLDecoder.decode(macroTemplate.getJson(), "utf-8"), (Class<Object>) Macro.class);
                        macro.setDescription(macroTemplate.getDescription());
                        macro.setName(macroTemplate.getName());
                        macro.setCategory(TemplatesDataSource.this.f14035j.getCategoryNameFromId(macroTemplate.getCategoryId()));
                        macroTemplate.setMacro(macro);
                        macroTemplate.setUseTranslatedText(TemplatesDataSource.this.f14034i.getAutoTranslateTemplates());
                        arrayList.add(macroTemplate);
                    }
                } catch (Exception unused) {
                }
            }
            this.$callback.onResult(arrayList, -1, 2);
            if (arrayList.isEmpty()) {
                TemplatesDataSource.this.n(LoadState.EMPTY);
            } else {
                TemplatesDataSource.this.n(LoadState.HAS_DATA);
            }
        }
    }

    /* compiled from: TemplateDataSource.kt */
    /* loaded from: classes3.dex */
    static final class f extends Lambda implements Function1<Throwable, Unit> {
        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (th instanceof HttpException) {
                Response<?> response = ((HttpException) th).response();
                boolean z3 = false;
                if (response != null && response.code() == 401) {
                    z3 = true;
                }
                if (z3) {
                    TemplatesDataSource.this.n(LoadState.PIRATE_VERSION);
                    return;
                }
            }
            TemplatesDataSource.this.n(LoadState.ERROR);
        }
    }

    public TemplatesDataSource(@NotNull Gson gson, @NotNull TemplateStoreApi api, @NotNull CompositeDisposable compositeDisposable, int i4, int i5, int i6, int i7, @NotNull String searchTerm, @NotNull AppPreferences appPreferences, @NotNull CategoriesHelper categoryHelper, @NotNull String language, @NotNull List<BlockedUser> blockedUsers, @NotNull List<BlockedMacro> blockedMacros) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(compositeDisposable, "compositeDisposable");
        Intrinsics.checkNotNullParameter(searchTerm, "searchTerm");
        Intrinsics.checkNotNullParameter(appPreferences, "appPreferences");
        Intrinsics.checkNotNullParameter(categoryHelper, "categoryHelper");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        Intrinsics.checkNotNullParameter(blockedMacros, "blockedMacros");
        this.f14026a = gson;
        this.f14027b = api;
        this.f14028c = compositeDisposable;
        this.f14029d = i4;
        this.f14030e = i5;
        this.f14031f = i6;
        this.f14032g = i7;
        this.f14033h = searchTerm;
        this.f14034i = appPreferences;
        this.f14035j = categoryHelper;
        this.f14036k = language;
        this.f14037l = blockedUsers;
        this.f14038m = blockedMacros;
        this.f14039n = new String[]{"308201dd30820146020101300d06092a864886f70d010105050030373116301406035504030c0d416e64726f69642044656275673110300e060355040a0c07416e64726f6964310b3009060355040613025553301e170d3138303331383036333030365a170d3438303331303036333030365a30373116301406035504030c0d416e64726f69642044656275673110300e060355040a0c07416e64726f6964310b300906035504061302555330819f300d06092a864886f70d010101050003818d003081890281810086912f222f6b68d99c49efd92ece90934d8f371720a9152f81668d5a9ff7aa72e35d026dadecc529023a946cf3f01231250ab272bd7f94f863efd3df697b80db143f42a01f9d27899e4d893fd63ff8db65232e44152dd96cf70369fd8cd1de83e3b505328248b57b47ef6dcaa9892a6c4367728c1b1f09526858dd628a5c6cbd0203010001300d06092a864886f70d0101050500038181000496ccc7b1517cc0dbaf6d95b939d9eefe63e4f8edc3792f72f906401456eba658d8f229ad8107dc4636b43eb8e549d727bde2eef0e75ad0f7d73945d4b03b41c697047a9bfd7786d7a2ddd7c63e2755efad4f38b1526ff5cf56f06bc636b2a18ab34416aab560d484fa8cf600834c6643eaf98fca26d46e15008c00411043ce", "308201e53082014ea00302010202044f173620300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303131383231313430385a170d3432303131303231313430385a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100b0270c96325dcb34ce75c5f27e58a6e39750d3fb81baa35e920ad1410f7471386b7f3a546e15a6d16069544c0af8cb3c6ad267d67c15c3b979329d782c54e6fa4ada9d47155c934f95bcf744f87f1a917971d401540c7fd5d29540bace27d494d2b2ec92170510544c0219ad444ce5561b7cc7ecd1a654b5ae5340b18ba6b9c90203010001300d06092a864886f70d01010505000381810099f61c4c0f7b738b8ee284dbe794f316d0621f5573fdf1252aad4f601fa2a88452a9a3666d8d9932b67d19188f8dcf0e9c6a85c80c5a410891f56b692b20db6c521b852ca90b76f77a9bb568743b3e16bd4927b65d6f6ff01aaff584d829a165a51e100613f3e0efe54618eef4ee484e8428f8008563dab9e2ce2ea5abf04dbe", "308201e53082014ea003020102020451dc007d300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3133303730393132323232315a170d3433303730323132323232315a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100850e2bc667b811cf3b4aad9ab181aeb761507f0110fb345089ce452651c98580d8fcb0da8af6cf2d51d245c4ebd509cf832b42ee084e10ff8706714ee0def21fcf936b4ff9a14a3c99b944f69158a150718f5c32d66665b7c287742ccba2c7b266250fddcdf5b8f7b3c20e5b4a0c0721143143a2763c54802de3ef5d949701750203010001300d06092a864886f70d010105050003818100498928c82f0ec0cfce4ae49ce76ba65127066880a2780e3617ed7a3258c5e9d3dcc789441afde78a4a62e50c8c46c3043c7260774522f3bdb8226c83ec2964477b93451a3434c03b989c2259e886aa1517d64e1fe9b32785d74d3ac9b8e39993b18f75186c7cd26cf22b2228e0e4d9d650bbae4fcefcbe2abb89ef6ffb00d71a", "308201dd30820146020101300d06092a864886f70d010105050030373116301406035504030c0d416e64726f69642044656275673110300e060355040a0c07416e64726f6964310b3009060355040613025553301e170d3136303932333230333735305a170d3436303931363230333735305a30373116301406035504030c0d416e64726f69642044656275673110300e060355040a0c07416e64726f6964310b300906035504061302555330819f300d06092a864886f70d010101050003818d00308189028181008a2ee13707155166313e78ccc314621c061d717a2f11dd2a2505c7c903ed9e89ccfc4769d953a866039ef1212a6cd923dcb5d77d5b43920cf6f84505c68a2e8de9e76647b7b4771c1f9e01468228e42deac8d4676c12f792e708f9452e205267fed553ba65a93abe48a019bf20f5b35f875dc26bbb87575a533f30d74d7e8cad0203010001300d06092a864886f70d010105050003818100470bd7e3b5b40e639326b241c9005fb3d24cc4180e2e04cc34b54db42b737b401847a5d499cd822e3d85360baa320d16d1ac97f4dc9b86eeab9ae62f019dec13dc707ea41ff11e47e2e2a71e05d7be65235d11574e50cbb165db568466abb5d00a60370b29dd59b47ac6140a12957f85c8eb087adf53c54560300f598545db19"};
        this.f14040o = new String[]{"3082035a30820242a00302010202044e8aeb6d300d06092a864886f70d0101050500306e310b300906035504061302554b3110300e06035504081307556e6b6e6f776e3110300e06035504071307556e6b6e6f776e3111300f060355040a130841726c6f736f66743110300e060355040b1307556e6b6e6f776e311630140603550403130d4a616d69652048696767696e733020170d3131313030343131313830355a180f32323835303731393131313830355a306e310b300906035504061302554b3110300e06035504081307556e6b6e6f776e3110300e06035504071307556e6b6e6f776e3111300f060355040a130841726c6f736f66743110300e060355040b1307556e6b6e6f776e311630140603550403130d4a616d69652048696767696e7330820122300d06092a864886f70d01010105000382010f003082010a0282010100b3bf1433e9b0aa40caff86c949de86bff550e6a787b36bbe88e2695d9baf1ed6c69e07b335ef8d74ec059a78b9c47289511ab916ca9010a67d61585a84cdb449bb49d223b9f638d57245d49253a92a56082bae5cbf7461ed36040ccfe2e1889d6a7a756433fdb8199ff066e66e09b45d6a2a3096678e03b1e00f7f5769f9923388eb94479f77e225cf9ca0bd0d4c04390c639fdcd0f32fc19117067d6b5ede4d4ddb3466fc73fde545a8e73714f976d5747784a1fd9441b7d8e514924f3ce458e54851721d99b75e229dc4fb75c245fb3e6170f95314fb342a9402a412752efc273d00ad658c92bc957109df7855926fc7e9c4871fc9904c562da00045da47110203010001300d06092a864886f70d0101050500038201010047286c6988858644d6549f99af2ae3cd8393bcf5fcca83551a8d46154ab3953026767181292573515c6b9ea7d69d5e236bda06da67c40f8ee2d82d6ebbff9c40cf94f8b19996c8a9ac8b08c7bd4f11494325ef08e2f7a04824b1bf2aa0827ed02158f399d245d5d47ad34dcecc27bf505068cf2430784a6c9f2669d0d1d0921b632c32a84a397f7096ef1ecbac8d703a886dff922a085239386c41ba7450d7e03ba03d60aa4c79c4994358a6f41f89ff87b9f6a073b55589f3b55a636bbabc65777691142940d5367dbb1f3629eff7c6d00abc44392d79264c834525b261f7c958712171ff6c94dce6df90b24bf810cc28e4d8939b5988cbcbd92174f9202f8e"};
        this.f14041p = new MutableLiveData<>();
        this.f14042q = SigningHelper.INSTANCE.getSigningKeySha1(MacroDroidApplication.Companion.getInstance());
    }

    private final boolean g(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr.length > 0) {
                String charsString = signatureArr[0].toCharsString();
                for (String str : this.f14039n) {
                    if (Intrinsics.areEqual(str, charsString)) {
                        return false;
                    }
                }
                for (String str2 : this.f14040o) {
                    if (Intrinsics.areEqual(str2, charsString)) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher h(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Publisher i(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return (Publisher) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(LoadState loadState) {
        this.f14041p.postValue(loadState);
    }

    @NotNull
    public final MutableLiveData<LoadState> getLoadState() {
        return this.f14041p;
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadAfter(@NotNull PageKeyedDataSource.LoadParams<Integer> params, @NotNull PageKeyedDataSource.LoadCallback<Integer, MacroTemplate> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int i4 = this.f14030e;
        String str = this.f14042q;
        int i5 = this.f14031f;
        String sha256 = StringExtensionsKt.sha256(i4 + TemplateStoreApiKt.TEMPLATE_API_SALT + str + i5);
        CompositeDisposable compositeDisposable = this.f14028c;
        Single<List<MacroTemplate>> macros = this.f14027b.getMacros(sha256, this.f14029d, this.f14030e, this.f14031f, params.requestedLoadSize * params.key.intValue(), params.requestedLoadSize, this.f14032g, this.f14033h, this.f14036k);
        final a aVar = a.f14043d;
        Single<List<MacroTemplate>> retryWhen = macros.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.c
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher h4;
                h4 = TemplatesDataSource.h(Function1.this, obj);
                return h4;
            }
        });
        final b bVar = b.f14045d;
        Single<List<MacroTemplate>> retryWhen2 = retryWhen.retryWhen(new Function() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.d
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Publisher i6;
                i6 = TemplatesDataSource.i(Function1.this, obj);
                return i6;
            }
        });
        final c cVar = new c(callback, params);
        Consumer<? super List<MacroTemplate>> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplatesDataSource.j(Function1.this, obj);
            }
        };
        final d dVar = new d(callback, params);
        compositeDisposable.add(retryWhen2.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplatesDataSource.k(Function1.this, obj);
            }
        }));
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadBefore(@NotNull PageKeyedDataSource.LoadParams<Integer> params, @NotNull PageKeyedDataSource.LoadCallback<Integer, MacroTemplate> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void loadInitial(@NotNull PageKeyedDataSource.LoadInitialParams<Integer> params, @NotNull PageKeyedDataSource.LoadInitialCallback<Integer, MacroTemplate> callback) {
        String str;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        n(LoadState.LOADING);
        int i4 = this.f14030e;
        String str2 = this.f14042q;
        if (g(MacroDroidApplication.Companion.getInstance())) {
            str = "1";
        } else {
            str = "";
        }
        int i5 = this.f14031f;
        String sha256 = StringExtensionsKt.sha256(i4 + TemplateStoreApiKt.TEMPLATE_API_SALT + str2 + str + i5);
        CompositeDisposable compositeDisposable = this.f14028c;
        Single<List<MacroTemplate>> macros = this.f14027b.getMacros(sha256, this.f14029d, this.f14030e, this.f14031f, 0, params.requestedLoadSize, this.f14032g, this.f14033h, this.f14036k);
        final e eVar = new e(callback);
        Consumer<? super List<MacroTemplate>> consumer = new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplatesDataSource.l(Function1.this, obj);
            }
        };
        final f fVar = new f();
        compositeDisposable.add(macros.subscribe(consumer, new Consumer() { // from class: com.arlosoft.macrodroid.templatestore.ui.templateList.data.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TemplatesDataSource.m(Function1.this, obj);
            }
        }));
    }

    public final void setLoadState(@NotNull MutableLiveData<LoadState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.f14041p = mutableLiveData;
    }

    public final void updateBlockedUsers(@NotNull List<BlockedUser> blockedUsers) {
        Intrinsics.checkNotNullParameter(blockedUsers, "blockedUsers");
        this.f14037l = blockedUsers;
    }
}
