package com.arlosoft.macrodroid.extras.ui.viewmodel;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.data.ExtrasViewState;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.ktx.Firebase;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtrasViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ExtrasViewModel extends ViewModel implements DefaultLifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12119a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ExtrasManager f12120b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final MacroDroidRoomDatabase f12121c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final RemoteConfig f12122d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final ExtrasDownloader f12123e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final SingleLiveEvent<String> f12124f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final MutableLiveData<ExtrasViewState> f12125g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final LiveData<ExtrasViewState> f12126h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final FirebaseFirestore f12127i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackage $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ExtraPackage extraPackage, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$extraPackage = extraPackage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$extraPackage, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (ExtrasViewModel.this.f12120b.isExtraInstalled(this.$extraPackage.getId())) {
                    ExtrasManager extrasManager = ExtrasViewModel.this.f12120b;
                    String id = this.$extraPackage.getId();
                    this.label = 1;
                    if (ExtrasManager.removeExtraPackage$default(extrasManager, id, false, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ExtrasViewModel.this.b(null, false, this);
        }
    }

    /* compiled from: ExtrasViewModel.kt */
    /* loaded from: classes3.dex */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $chunk;
        final /* synthetic */ String $encryptedMacroSet;
        final /* synthetic */ ExtraPackage $extraPackage;
        final /* synthetic */ boolean $forceUpdate;
        int label;
        final /* synthetic */ ExtrasViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z3, ExtrasViewModel extrasViewModel, ExtraPackage extraPackage, String str, String str2, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$forceUpdate = z3;
            this.this$0 = extrasViewModel;
            this.$extraPackage = extraPackage;
            this.$encryptedMacroSet = str;
            this.$chunk = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new c(this.$forceUpdate, this.this$0, this.$extraPackage, this.$encryptedMacroSet, this.$chunk, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (this.$forceUpdate || !this.this$0.f12120b.isExtraInstalled(this.$extraPackage.getId())) {
                    ExtrasManager extrasManager = this.this$0.f12120b;
                    ExtraPackage extraPackage = this.$extraPackage;
                    String str = this.$encryptedMacroSet;
                    String str2 = this.$chunk;
                    this.label = 1;
                    if (extrasManager.installExtraPackage(extraPackage, str, str2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* compiled from: ExtrasViewModel.kt */
    /* loaded from: classes3.dex */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExtraPackage $extraPackage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ExtraPackage extraPackage, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$extraPackage = extraPackage;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$extraPackage, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 != 0) {
                if (i4 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                if (ExtrasViewModel.this.f12120b.isExtraInstalled(this.$extraPackage.getId())) {
                    ExtrasManager extrasManager = ExtrasViewModel.this.f12120b;
                    String id = this.$extraPackage.getId();
                    this.label = 1;
                    if (ExtrasManager.removeExtraPackage$default(extrasManager, id, false, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public ExtrasViewModel(@ApplicationContext @NotNull Context context, @NotNull ExtrasManager extrasManager, @NotNull MacroDroidRoomDatabase roomDatabase, @NotNull RemoteConfig remoteConfig, @NotNull ExtrasDownloader extrasDownloader) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extrasManager, "extrasManager");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        Intrinsics.checkNotNullParameter(remoteConfig, "remoteConfig");
        Intrinsics.checkNotNullParameter(extrasDownloader, "extrasDownloader");
        this.f12119a = context;
        this.f12120b = extrasManager;
        this.f12121c = roomDatabase;
        this.f12122d = remoteConfig;
        this.f12123e = extrasDownloader;
        this.f12124f = new SingleLiveEvent<>();
        MutableLiveData<ExtrasViewState> mutableLiveData = new MutableLiveData<>();
        this.f12125g = mutableLiveData;
        this.f12126h = mutableLiveData;
        this.f12127i = FirestoreKt.getFirestore(Firebase.INSTANCE);
        refresh();
    }

    private final void a(ExtraPackage extraPackage, int i4) {
        if (i4 > 53800019) {
            e.e(ViewModelKt.getViewModelScope(this), null, null, new a(extraPackage, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(com.arlosoft.macrodroid.extras.data.ExtraPackage r19, boolean r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel.b
            if (r2 == 0) goto L17
            r2 = r1
            com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel$b r2 = (com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel.b) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel$b r2 = new com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel$b
            r2.<init>(r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L41
            if (r4 != r5) goto L39
            boolean r3 = r2.Z$0
            java.lang.Object r4 = r2.L$1
            com.arlosoft.macrodroid.extras.data.ExtraPackage r4 = (com.arlosoft.macrodroid.extras.data.ExtraPackage) r4
            java.lang.Object r2 = r2.L$0
            com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel r2 = (com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r14 = r3
            r5 = r4
            goto L64
        L39:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L41:
            kotlin.ResultKt.throwOnFailure(r1)
            com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r1 = r0.f12121c
            com.arlosoft.macrodroid.database.room.ExtraInstalledDao r1 = r1.extraInstalledDao()
            java.lang.String r4 = r19.getId()
            r2.L$0 = r0
            r6 = r19
            r2.L$1 = r6
            r7 = r20
            r2.Z$0 = r7
            r2.label = r5
            java.lang.Object r1 = r1.getInstalledExtraById(r4, r2)
            if (r1 != r3) goto L61
            return r3
        L61:
            r2 = r0
            r5 = r6
            r14 = r7
        L64:
            com.arlosoft.macrodroid.database.room.ExtraInstalled r1 = (com.arlosoft.macrodroid.database.room.ExtraInstalled) r1
            com.arlosoft.macrodroid.extras.ui.management.ExtrasManager r3 = r2.f12120b
            java.lang.String r4 = r5.getId()
            boolean r3 = r3.isExtraInstalled(r4)
            com.arlosoft.macrodroid.remoteconfig.RemoteConfig r4 = r2.f12122d
            java.lang.String r6 = r5.getId()
            com.arlosoft.macrodroid.remoteconfig.ExtraMinVersion r6 = r4.getExtraMinVersion(r6)
            int r4 = r6.getVersionCode()
            r2.a(r5, r4)
            com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState r15 = new com.arlosoft.macrodroid.extras.data.ExtraPackageWithPriceAndState
            r7 = 0
            r8 = 0
            r9 = 0
            r4 = 0
            if (r3 == 0) goto L95
            if (r1 == 0) goto L95
            int r1 = r1.getVersionCode()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r10 = r1
            goto L96
        L95:
            r10 = r4
        L96:
            r11 = 0
            r12 = 0
            r13 = 0
            r1 = 0
            r16 = 1472(0x5c0, float:2.063E-42)
            r17 = 0
            r4 = r15
            r3 = r15
            r15 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r3)
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto Lb9
            androidx.lifecycle.MutableLiveData<com.arlosoft.macrodroid.extras.data.ExtrasViewState> r1 = r2.f12125g
            com.arlosoft.macrodroid.extras.data.ExtrasViewState$Error r2 = com.arlosoft.macrodroid.extras.data.ExtrasViewState.Error.INSTANCE
            r1.postValue(r2)
        Lb9:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel.b(com.arlosoft.macrodroid.extras.data.ExtraPackage, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public final SingleLiveEvent<String> getUpdateInstalledEvent() {
        return this.f12124f;
    }

    @NotNull
    public final LiveData<ExtrasViewState> getViewState() {
        return this.f12126h;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.b(this, lifecycleOwner);
    }

    public final void onExtraSubscriptionIsActive(@NotNull ExtraPackage extraPackage, @NotNull String encryptedMacroSet, @NotNull String chunk, boolean z3) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        Intrinsics.checkNotNullParameter(encryptedMacroSet, "encryptedMacroSet");
        Intrinsics.checkNotNullParameter(chunk, "chunk");
        this.f12120b.registerDeviceId("extras", "misc");
        e.e(ViewModelKt.getViewModelScope(this), null, null, new c(z3, this, extraPackage, encryptedMacroSet, chunk, null), 3, null);
    }

    public final void onExtraSubscriptionIsNotActive(@NotNull ExtraPackage extraPackage) {
        Intrinsics.checkNotNullParameter(extraPackage, "extraPackage");
        e.e(ViewModelKt.getViewModelScope(this), null, null, new d(extraPackage, null), 3, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.d(this, lifecycleOwner);
    }

    public final void onRetryClicked() {
        refresh();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.d.f(this, lifecycleOwner);
    }

    public final void refresh() {
    }
}
