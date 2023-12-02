package com.arlosoft.macrodroid.autobackup.ui.local;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.mvp.Presenter;
import com.arlosoft.macrodroid.autobackup.model.AutoBackupConstantsKt;
import com.arlosoft.macrodroid.autobackup.model.BackupFile;
import com.arlosoft.macrodroid.autobackup.worker.AutoBackupWorker;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RefreshHomeScreenEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.encryption.Encryptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AutoBackupLocalPresenter.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAutoBackupLocalPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupLocalPresenter.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,206:1\n1#2:207\n13309#3,2:208\n13309#3,2:210\n6523#3:214\n26#4:212\n26#4:213\n1549#5:215\n1620#5,3:216\n*S KotlinDebug\n*F\n+ 1 AutoBackupLocalPresenter.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalPresenter\n*L\n149#1:208,2\n154#1:210,2\n203#1:214\n199#1:212\n200#1:213\n203#1:215\n203#1:216,3\n*E\n"})
/* loaded from: classes3.dex */
public final class AutoBackupLocalPresenter extends Presenter<AutoBackupLocalViewContract> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Context f9411b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CompletableJob f9412c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private CompletableJob f9413d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupLocalPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $macroJson;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupLocalPresenter.kt */
        /* renamed from: com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalPresenter$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0092a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $macroJson;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0092a(String str, Continuation<? super C0092a> continuation) {
                super(2, continuation);
                this.$macroJson = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0092a(this.$macroJson, continuation);
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
                return ((C0092a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupLocalPresenter.kt */
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
        a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$macroJson = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(this.$macroJson, continuation);
            aVar.L$0 = obj;
            return aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x0115, code lost:
            if (com.arlosoft.macrodroid.settings.Settings.getMacroDroidEnabled(r12.this$0.f9411b) == false) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x011a, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARN: Removed duplicated region for block: B:30:0x009e A[Catch: all -> 0x0015, Exception -> 0x0018, TryCatch #1 {Exception -> 0x0018, blocks: (B:6:0x0010, B:28:0x008f, B:30:0x009e, B:31:0x00a1, B:33:0x00ab, B:34:0x00ae, B:36:0x00b8, B:15:0x0027, B:25:0x0084, B:18:0x0032, B:20:0x0051, B:21:0x0054), top: B:55:0x000a, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00ab A[Catch: all -> 0x0015, Exception -> 0x0018, TryCatch #1 {Exception -> 0x0018, blocks: (B:6:0x0010, B:28:0x008f, B:30:0x009e, B:31:0x00a1, B:33:0x00ab, B:34:0x00ae, B:36:0x00b8, B:15:0x0027, B:25:0x0084, B:18:0x0032, B:20:0x0051, B:21:0x0054), top: B:55:0x000a, outer: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b8 A[Catch: all -> 0x0015, Exception -> 0x0018, TRY_LEAVE, TryCatch #1 {Exception -> 0x0018, blocks: (B:6:0x0010, B:28:0x008f, B:30:0x009e, B:31:0x00a1, B:33:0x00ab, B:34:0x00ae, B:36:0x00b8, B:15:0x0027, B:25:0x0084, B:18:0x0032, B:20:0x0051, B:21:0x0054), top: B:55:0x000a, outer: #0 }] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 317
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalPresenter.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupLocalPresenter.kt */
    /* loaded from: classes3.dex */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupLocalPresenter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<List<BackupFile>> $backupList;
            int label;
            final /* synthetic */ AutoBackupLocalPresenter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Ref.ObjectRef<List<BackupFile>> objectRef, AutoBackupLocalPresenter autoBackupLocalPresenter, Continuation<? super a> continuation) {
                super(2, continuation);
                this.$backupList = objectRef;
                this.this$0 = autoBackupLocalPresenter;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.$backupList, this.this$0, continuation);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List, T] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.$backupList.element = this.this$0.c();
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

        b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            Deferred b4;
            Ref.ObjectRef objectRef;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            boolean z3 = true;
            if (i4 != 0) {
                if (i4 == 1) {
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                b4 = kotlinx.coroutines.e.b(coroutineScope, Dispatchers.getIO(), null, new a(objectRef2, AutoBackupLocalPresenter.this, null), 2, null);
                this.L$0 = objectRef2;
                this.label = 1;
                if (b4.await(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
            }
            List list = (List) objectRef.element;
            if (!((list == null || list.isEmpty()) ? false : false)) {
                AutoBackupLocalViewContract view = AutoBackupLocalPresenter.this.getView();
                if (view != null) {
                    view.showEmptyBackupFiles();
                }
            } else {
                AutoBackupLocalViewContract view2 = AutoBackupLocalPresenter.this.getView();
                if (view2 != null) {
                    T t3 = objectRef.element;
                    Intrinsics.checkNotNull(t3);
                    view2.showBackupFiles((List) t3);
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Inject
    public AutoBackupLocalPresenter(@ApplicationContext @NotNull Context context) {
        CompletableJob c4;
        CompletableJob c5;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f9411b = context;
        c4 = u.c(null, 1, null);
        this.f9412c = c4;
        c5 = u.c(null, 1, null);
        this.f9413d = c5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BackupFile> c() {
        Object[] plus;
        List sortedWith;
        int collectionSizeOrDefault;
        List<BackupFile> emptyList;
        File file = new File(this.f9411b.getFilesDir().getAbsolutePath(), AutoBackupConstantsKt.AUTO_BACKUP_DIR);
        File file2 = new File(this.f9411b.getExternalFilesDir(null), AutoBackupConstantsKt.AUTO_BACKUP_DIR);
        if (!file2.exists() && !file.exists()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            listFiles = new File[0];
        }
        File[] listFiles2 = file2.listFiles();
        if (listFiles2 == null) {
            listFiles2 = new File[0];
        }
        plus = ArraysKt___ArraysJvmKt.plus((Object[]) listFiles, (Object[]) listFiles2);
        sortedWith = ArraysKt___ArraysKt.sortedWith((File[]) plus, new Comparator() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalPresenter$getBackupList$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int compareValues;
                compareValues = kotlin.comparisons.f.compareValues(Long.valueOf(((File) t4).lastModified()), Long.valueOf(((File) t3).lastModified()));
                return compareValues;
            }
        });
        List<File> list = sortedWith;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (File file3 : list) {
            Intrinsics.checkNotNullExpressionValue(file3, "file");
            arrayList.add(new BackupFile(file3));
        }
        return arrayList;
    }

    private final void d(String str) {
        kotlinx.coroutines.e.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.f9412c)), null, null, new a(str, null), 3, null);
    }

    private final void e() {
        kotlinx.coroutines.e.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.f9413d)), null, null, new b(null), 3, null);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void a() {
        Job.DefaultImpls.cancel$default((Job) this.f9412c, (CancellationException) null, 1, (Object) null);
        Job.DefaultImpls.cancel$default((Job) this.f9413d, (CancellationException) null, 1, (Object) null);
    }

    @Override // com.arlosoft.macrodroid.app.mvp.Presenter
    protected void b() {
        e();
    }

    public final void decryptAndRestore(@NotNull BackupFile backupFile, @NotNull String password) {
        byte[] readBytes;
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        Intrinsics.checkNotNullParameter(password, "password");
        try {
            readBytes = kotlin.io.c.readBytes(backupFile.getFile());
            d(new String(Encryptor.decrypt(readBytes, password), Charsets.UTF_8));
        } finally {
        }
    }

    public final void deleteAllBackups() {
        File[] listFiles = new File(this.f9411b.getFilesDir().getAbsolutePath(), AutoBackupConstantsKt.AUTO_BACKUP_DIR).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        File[] listFiles2 = new File(this.f9411b.getExternalFilesDir(null), AutoBackupConstantsKt.AUTO_BACKUP_DIR).listFiles();
        if (listFiles2 != null) {
            for (File file2 : listFiles2) {
                file2.delete();
            }
        }
        AutoBackupLocalViewContract view = getView();
        if (view != null) {
            view.showEmptyBackupFiles();
        }
    }

    public final void deleteBackup(@NotNull BackupFile backupFile) {
        List<BackupFile> mutableList;
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) c());
        mutableList.remove(backupFile);
        if (mutableList.isEmpty()) {
            AutoBackupLocalViewContract view = getView();
            if (view != null) {
                view.showEmptyBackupFiles();
            }
        } else {
            AutoBackupLocalViewContract view2 = getView();
            if (view2 != null) {
                view2.showBackupFiles(mutableList);
            }
        }
        backupFile.getFile().delete();
    }

    public final void onAutoBackupEnableStateChange(boolean z3) {
        if (z3) {
            AutoBackupWorker.Companion.enablePeriodicBackups();
            Settings.setAutoBackupsEnabled(this.f9411b, true);
            return;
        }
        AutoBackupWorker.Companion.cancelPeriodicBackups();
        Settings.setAutoBackupsEnabled(this.f9411b, false);
    }

    public final void onBackupLongClicked(@NotNull BackupFile backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        AutoBackupLocalViewContract view = getView();
        if (view != null) {
            view.showDeleteDialog(backupFile);
        }
    }

    public final void onBackupNowSelected() {
        AutoBackupWorker.Companion.doBackup(this.f9411b);
        e();
    }

    public final void onBackupSelected(@NotNull BackupFile backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        AutoBackupLocalViewContract view = getView();
        if (view != null) {
            view.showBackupDialog(backupFile);
        }
    }

    public final void onDeleteAllSelected() {
        AutoBackupLocalViewContract view = getView();
        if (view != null) {
            view.showDeleteAllDialog();
        }
    }

    public final void restoreBackup(@NotNull BackupFile backupFile) {
        BufferedReader bufferedReader;
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        try {
            if (backupFile.isEncrypted()) {
                AutoBackupLocalViewContract view = getView();
                if (view != null) {
                    view.showPasswordDialog(backupFile);
                    return;
                }
                return;
            }
            File file = backupFile.getFile();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), Charsets.UTF_8);
            if (inputStreamReader instanceof BufferedReader) {
                bufferedReader = (BufferedReader) inputStreamReader;
            } else {
                bufferedReader = new BufferedReader(inputStreamReader, 8192);
            }
            String readText = TextStreamsKt.readText(bufferedReader);
            CloseableKt.closeFinally(bufferedReader, null);
            d(readText);
        } catch (Exception e4) {
            SystemLog.logError("Failed to restore auto backup: " + e4);
            AutoBackupLocalViewContract view2 = getView();
            if (view2 != null) {
                view2.showBackupRestoreFailed();
            }
            AutoBackupLocalViewContract view3 = getView();
            if (view3 != null) {
                view3.showRestoringState(false);
            }
        }
    }

    public final void shareBackup(@NotNull BackupFile backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        AutoBackupLocalViewContract view = getView();
        if (view != null) {
            view.shareBackup(backupFile);
        }
    }
}
