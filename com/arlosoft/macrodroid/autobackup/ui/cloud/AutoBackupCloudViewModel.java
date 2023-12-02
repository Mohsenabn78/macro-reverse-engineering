package com.arlosoft.macrodroid.autobackup.ui.cloud;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudViewModel;
import com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupUiState;
import com.arlosoft.macrodroid.autobackup.worker.AutoBackupCloudWorker;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RefreshHomeScreenEvent;
import com.arlosoft.macrodroid.firebase.FirestoreHelper;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import com.arlosoft.macrodroid.utils.SingleLiveEvent;
import com.arlosoft.macrodroid.utils.encryption.Encryptor;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageException;
import com.google.firebase.storage.StorageReference;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.zeroturnaround.zip.ZipUtil;

/* compiled from: AutoBackupCloudViewModel.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAutoBackupCloudViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupCloudViewModel.kt\ncom/arlosoft/macrodroid/autobackup/ui/cloud/AutoBackupCloudViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,320:1\n1#2:321\n*E\n"})
/* loaded from: classes3.dex */
public final class AutoBackupCloudViewModel extends ViewModel implements LifecycleObserver {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f9350a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SignInHelper f9351b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final UserProvider f9352c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final FirestoreHelper f9353d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final PremiumStatusHandler f9354e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final MutableLiveData<Boolean> f9355f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final LiveData<Boolean> f9356g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final SingleLiveEvent<BackupFailReason> f9357h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final SingleLiveEvent<Void> f9358i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final SingleLiveEvent<Boolean> f9359j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final SingleLiveEvent<Pair<BackupInfo, String>> f9360k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final SingleLiveEvent<Pair<BackupInfo, String>> f9361l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final SingleLiveEvent<File> f9362m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final FirebaseStorage f9363n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final MutableLiveData<AutoBackupUiState> f9364o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final LiveData<AutoBackupUiState> f9365p;

    /* compiled from: AutoBackupCloudViewModel.kt */
    @SourceDebugExtension({"SMAP\nAutoBackupCloudViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupCloudViewModel.kt\ncom/arlosoft/macrodroid/autobackup/ui/cloud/AutoBackupCloudViewModel$deleteAllBackups$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,320:1\n1855#2,2:321\n*S KotlinDebug\n*F\n+ 1 AutoBackupCloudViewModel.kt\ncom/arlosoft/macrodroid/autobackup/ui/cloud/AutoBackupCloudViewModel$deleteAllBackups$1\n*L\n275#1:321,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function1<ListResult, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupCloudViewModel.kt */
        /* renamed from: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudViewModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0090a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AutoBackupCloudViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0090a(AutoBackupCloudViewModel autoBackupCloudViewModel, Continuation<? super C0090a> continuation) {
                super(2, continuation);
                this.this$0 = autoBackupCloudViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0090a(this.this$0, continuation);
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
                    this.label = 1;
                    if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.this$0.g();
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0090a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        a() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AutoBackupCloudViewModel this$0, Exception it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "it");
            this$0.getDeleteFailedEvent().postValue(null);
        }

        public final void b(ListResult listResult) {
            SystemLog.logInfo("All cloud backups deleted");
            List<StorageReference> items = listResult.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "listResult.items");
            final AutoBackupCloudViewModel autoBackupCloudViewModel = AutoBackupCloudViewModel.this;
            for (StorageReference storageReference : items) {
                storageReference.delete().addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.j
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public final void onFailure(Exception exc) {
                        AutoBackupCloudViewModel.a.c(AutoBackupCloudViewModel.this, exc);
                    }
                });
            }
            kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(AutoBackupCloudViewModel.this), null, null, new C0090a(AutoBackupCloudViewModel.this, null), 3, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListResult listResult) {
            b(listResult);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudViewModel.kt */
    @SourceDebugExtension({"SMAP\nAutoBackupCloudViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupCloudViewModel.kt\ncom/arlosoft/macrodroid/autobackup/ui/cloud/AutoBackupCloudViewModel$getFiles$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,320:1\n1549#2:321\n1620#2,3:322\n*S KotlinDebug\n*F\n+ 1 AutoBackupCloudViewModel.kt\ncom/arlosoft/macrodroid/autobackup/ui/cloud/AutoBackupCloudViewModel$getFiles$1\n*L\n309#1:321\n309#1:322,3\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<ListResult, Unit> {
        final /* synthetic */ String $deviceId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.$deviceId = str;
        }

        public final void a(ListResult listResult) {
            int collectionSizeOrDefault;
            List reversed;
            List<StorageReference> items = listResult.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "listResult.items");
            List<StorageReference> list = items;
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (StorageReference storageReference : list) {
                String name = storageReference.getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                arrayList.add(new BackupInfo(0L, name));
            }
            reversed = CollectionsKt___CollectionsKt.reversed(arrayList);
            AutoBackupCloudViewModel.this.f9364o.postValue(new AutoBackupUiState.BackupListScreen(false, reversed, false, this.$deviceId));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListResult listResult) {
            a(listResult);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupCloudViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $macroJson;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupCloudViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $macroJson;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$macroJson = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$macroJson, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    List<Macro> importJsonString = MacroStore.getInstance().importJsonString(this.$macroJson, true);
                    if (importJsonString != null && (!importJsonString.isEmpty())) {
                        MacroStore.getInstance().removeAllMacros();
                        MacroStore.getInstance().storeMacroList(importJsonString);
                        MacroStore.getInstance().writeToJSON();
                    }
                    EventBusUtils.getEventBus().post(new RefreshHomeScreenEvent());
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupCloudViewModel.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;

            b(Continuation<? super b> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    Thread.sleep(1800L);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$macroJson = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            c cVar = new c(this.$macroJson, continuation);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00ce, code lost:
            if (com.arlosoft.macrodroid.settings.Settings.getMacroDroidEnabled(r12.this$0.f9350a) == false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00d3, code lost:
            return kotlin.Unit.INSTANCE;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 246
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudViewModel.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public AutoBackupCloudViewModel(@ApplicationContext @NotNull Context context, @NotNull SignInHelper signInHelper, @NotNull UserProvider userProvider, @NotNull FirestoreHelper firestoreHelper, @NotNull PremiumStatusHandler premiumStatusHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(signInHelper, "signInHelper");
        Intrinsics.checkNotNullParameter(userProvider, "userProvider");
        Intrinsics.checkNotNullParameter(firestoreHelper, "firestoreHelper");
        Intrinsics.checkNotNullParameter(premiumStatusHandler, "premiumStatusHandler");
        this.f9350a = context;
        this.f9351b = signInHelper;
        this.f9352c = userProvider;
        this.f9353d = firestoreHelper;
        this.f9354e = premiumStatusHandler;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.valueOf(Settings.getCloudBackupsEnabled(context)));
        this.f9355f = mutableLiveData;
        this.f9356g = mutableLiveData;
        this.f9357h = new SingleLiveEvent<>();
        this.f9358i = new SingleLiveEvent<>();
        this.f9359j = new SingleLiveEvent<>();
        this.f9360k = new SingleLiveEvent<>();
        this.f9361l = new SingleLiveEvent<>();
        this.f9362m = new SingleLiveEvent<>();
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseStorage, "getInstance()");
        this.f9363n = firebaseStorage;
        MutableLiveData<AutoBackupUiState> mutableLiveData2 = new MutableLiveData<>();
        this.f9364o = mutableLiveData2;
        this.f9365p = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AutoBackupCloudViewModel this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.f9358i.postValue(null);
        SystemLog.logError("Cloud backup delete all failed: " + it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        h(Settings.getCloudBackupsId(this.f9350a));
    }

    private final void h(final String str) {
        List emptyList;
        List emptyList2;
        MutableLiveData<AutoBackupUiState> mutableLiveData = this.f9364o;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(new AutoBackupUiState.BackupListScreen(true, emptyList, false, null, 8, null));
        String cloudBackupsId = Settings.getCloudBackupsId(this.f9350a);
        if (cloudBackupsId == null) {
            MutableLiveData<AutoBackupUiState> mutableLiveData2 = this.f9364o;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            mutableLiveData2.postValue(new AutoBackupUiState.BackupListScreen(false, emptyList2, true, str));
            SystemLog.logVerbose("Cloud backup failed - User not logged in");
            return;
        }
        StorageReference reference = this.f9363n.getReference();
        Intrinsics.checkNotNullExpressionValue(reference, "storage.reference");
        StorageReference child = reference.child("cloudBackup/" + cloudBackupsId);
        Intrinsics.checkNotNullExpressionValue(child, "storageRef.child(\"cloudBackup/$uid\")");
        this.f9363n.setMaxDownloadRetryTimeMillis(5000L);
        Task<ListResult> listAll = child.listAll();
        final b bVar = new b(str);
        listAll.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.f
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                AutoBackupCloudViewModel.i(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.g
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                AutoBackupCloudViewModel.j(AutoBackupCloudViewModel.this, str, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AutoBackupCloudViewModel this$0, String str, Exception it) {
        List emptyList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof StorageException) && ((StorageException) it).getHttpResultCode() == 403) {
            this$0.f9364o.postValue(AutoBackupUiState.SignInScreen.INSTANCE);
            return;
        }
        MutableLiveData<AutoBackupUiState> mutableLiveData = this$0.f9364o;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(new AutoBackupUiState.BackupListScreen(false, emptyList, true, str));
    }

    private final void k(String str) {
        kotlinx.coroutines.e.e(ViewModelKt.getViewModelScope(this), null, null, new c(str, null), 3, null);
    }

    private final void l() {
        if (!this.f9354e.getPremiumStatus().isPro()) {
            this.f9364o.postValue(AutoBackupUiState.ProOnlyScreen.INSTANCE);
        } else if (Settings.getCloudBackupsId(this.f9350a) == null) {
            this.f9364o.postValue(AutoBackupUiState.SignInScreen.INSTANCE);
        } else {
            g();
        }
    }

    public final void backupNow() {
        String str;
        if (MacroStore.getInstance().getAllCompletedMacros().size() == 0) {
            this.f9357h.postValue(BackupFailReason.NO_MACROS);
            return;
        }
        this.f9364o.postValue(AutoBackupUiState.BackingUp.INSTANCE);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            str = currentUser.getUid();
        } else {
            str = null;
        }
        if (str == null) {
            this.f9357h.postValue(BackupFailReason.OTHER);
        } else {
            this.f9353d.backupFileToCloud(str, 4000L, new FirestoreHelper.OperationCompleteListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudViewModel$backupNow$1
                @Override // com.arlosoft.macrodroid.firebase.FirestoreHelper.OperationCompleteListener
                public void operationComplete(boolean z3) {
                    if (z3) {
                        AutoBackupCloudViewModel.this.g();
                    } else {
                        AutoBackupCloudViewModel.this.getBackupFailedEvent().postValue(BackupFailReason.OTHER);
                    }
                }
            });
        }
    }

    public final void decryptAndRestore(@NotNull File backupFile, @NotNull String password) {
        byte[] readBytes;
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        Intrinsics.checkNotNullParameter(password, "password");
        try {
            readBytes = kotlin.io.c.readBytes(backupFile);
            k(new String(Encryptor.decrypt(readBytes, password), Charsets.UTF_8));
        } catch (Throwable unused) {
            SystemLog.logError("Failed to restore from cloud backup");
            this.f9359j.postValue(Boolean.FALSE);
        }
    }

    public final void deleteAllBackups() {
        String str;
        this.f9364o.postValue(AutoBackupUiState.Deleting.INSTANCE);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            str = currentUser.getUid();
        } else {
            str = null;
        }
        if (str == null) {
            this.f9358i.postValue(null);
            SystemLog.logVerbose("Cloud backup delete all failed - User not logged in");
            return;
        }
        StorageReference reference = this.f9363n.getReference();
        Intrinsics.checkNotNullExpressionValue(reference, "storage.reference");
        StorageReference child = reference.child("cloudBackup/" + str);
        Intrinsics.checkNotNullExpressionValue(child, "storageRef.child(\"cloudBackup/$uid\")");
        Task<ListResult> listAll = child.listAll();
        final a aVar = new a();
        listAll.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.h
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                AutoBackupCloudViewModel.e(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.i
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                AutoBackupCloudViewModel.f(AutoBackupCloudViewModel.this, exc);
            }
        });
    }

    public final void deleteBackup(@NotNull BackupInfo backupInfo) {
        Intrinsics.checkNotNullParameter(backupInfo, "backupInfo");
        this.f9364o.postValue(AutoBackupUiState.Deleting.INSTANCE);
        this.f9353d.deleteFile(backupInfo.getName(), new FirestoreHelper.OperationCompleteListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudViewModel$deleteBackup$1
            @Override // com.arlosoft.macrodroid.firebase.FirestoreHelper.OperationCompleteListener
            public void operationComplete(boolean z3) {
                if (z3) {
                    AutoBackupCloudViewModel.this.g();
                } else {
                    AutoBackupCloudViewModel.this.getDeleteFailedEvent().postValue(null);
                }
            }
        });
    }

    public final void extractZipAndRestore(@NotNull File zipFile, @NotNull BackupInfo backupInfo) {
        String dropLast;
        String dropLast2;
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(zipFile, "zipFile");
        Intrinsics.checkNotNullParameter(backupInfo, "backupInfo");
        File parentFile = zipFile.getParentFile();
        ZipUtil.unpack(zipFile, parentFile);
        dropLast = StringsKt___StringsKt.dropLast(backupInfo.getName(), 4);
        dropLast2 = StringsKt___StringsKt.dropLast(backupInfo.getName(), 4);
        File file = new File(parentFile, dropLast + ".mdr");
        File file2 = new File(parentFile, dropLast2 + ".emdr");
        try {
            if (file.exists()) {
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
                if (inputStreamReader instanceof BufferedReader) {
                    bufferedReader = (BufferedReader) inputStreamReader;
                } else {
                    bufferedReader = new BufferedReader(inputStreamReader, 8192);
                }
                String readText = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                k(readText);
            } else if (file2.exists()) {
                this.f9362m.postValue(file2);
            } else {
                SystemLog.logError("Failed to restore from cloud backup");
                this.f9359j.postValue(Boolean.FALSE);
            }
        } catch (Exception e4) {
            SystemLog.logError("Failed to restore from cloud backup: " + e4.getMessage());
            this.f9359j.postValue(Boolean.FALSE);
        }
    }

    @NotNull
    public final SingleLiveEvent<BackupFailReason> getBackupFailedEvent() {
        return this.f9357h;
    }

    @NotNull
    public final SingleLiveEvent<Void> getDeleteFailedEvent() {
        return this.f9358i;
    }

    @NotNull
    public final LiveData<Boolean> getEnabledState() {
        return this.f9356g;
    }

    @NotNull
    public final SingleLiveEvent<File> getPromptForPasswordEvent() {
        return this.f9362m;
    }

    @NotNull
    public final SingleLiveEvent<Boolean> getRestoreBackupEvent() {
        return this.f9359j;
    }

    @NotNull
    public final SingleLiveEvent<Pair<BackupInfo, String>> getShowBackupDialogEvent() {
        return this.f9361l;
    }

    @NotNull
    public final SingleLiveEvent<Pair<BackupInfo, String>> getShowLongPressOptionsEvent() {
        return this.f9360k;
    }

    @NotNull
    public final LiveData<AutoBackupUiState> getUiState() {
        return this.f9365p;
    }

    public final void onCloudBackEndabledStateChanged(boolean z3) {
        Settings.setCloudBackupsEnabled(this.f9350a, z3);
        this.f9355f.postValue(Boolean.valueOf(z3));
    }

    public final void onCloudBackupFileClicked(@NotNull BackupInfo backupInfo, @NotNull String filename) {
        Intrinsics.checkNotNullParameter(backupInfo, "backupInfo");
        Intrinsics.checkNotNullParameter(filename, "filename");
        this.f9361l.postValue(new Pair<>(backupInfo, filename));
    }

    public final void onCloudBackupFileLongClicked(@NotNull BackupInfo backupInfo, @NotNull String filename) {
        Intrinsics.checkNotNullParameter(backupInfo, "backupInfo");
        Intrinsics.checkNotNullParameter(filename, "filename");
        this.f9360k.postValue(new Pair<>(backupInfo, filename));
    }

    public final void onSignedInNoUser() {
        String str;
        if (Settings.getCloudBackupsEnabled(this.f9350a)) {
            AutoBackupCloudWorker.Companion.scheduleNewBackup(this.f9350a, 1L);
        }
        Context context = this.f9350a;
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            str = currentUser.getUid();
        } else {
            str = null;
        }
        Settings.setCloudBackupsID(context, str);
        l();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        l();
    }

    public final void refresh() {
        l();
    }

    public final void restoreBackup(@NotNull final BackupInfo backupInfo) {
        Intrinsics.checkNotNullParameter(backupInfo, "backupInfo");
        this.f9364o.postValue(AutoBackupUiState.Restoring.INSTANCE);
        this.f9353d.downloadFile(backupInfo.getName(), new FirestoreHelper.FileDownloadListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudViewModel$restoreBackup$1
            @Override // com.arlosoft.macrodroid.firebase.FirestoreHelper.FileDownloadListener
            public void downloadFailed() {
                SystemLog.logError("Failed to restore from cloud backup");
                AutoBackupCloudViewModel.this.getRestoreBackupEvent().postValue(Boolean.FALSE);
            }

            @Override // com.arlosoft.macrodroid.firebase.FirestoreHelper.FileDownloadListener
            public void fileDownloaded(@NotNull File file) {
                Intrinsics.checkNotNullParameter(file, "file");
                AutoBackupCloudViewModel.this.extractZipAndRestore(file, backupInfo);
            }
        });
    }

    public final void signOut() {
        AuthUI.getInstance().signOut(this.f9350a);
        Settings.setCloudBackupsID(this.f9350a, null);
        AutoBackupCloudWorker.Companion.cancel(this.f9350a);
        l();
    }
}
