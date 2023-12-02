package com.arlosoft.macrodroid.firebase;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.autobackup.model.AutoBackupConstantsKt;
import com.arlosoft.macrodroid.autobackup.worker.AutoBackupCloudWorker;
import com.arlosoft.macrodroid.firebase.FirestoreHelper;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.zeroturnaround.zip.ZipUtil;
import timber.log.Timber;

/* compiled from: FirestoreHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nFirestoreHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FirestoreHelper.kt\ncom/arlosoft/macrodroid/firebase/FirestoreHelper\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,238:1\n13309#2,2:239\n1054#3:241\n1855#3,2:242\n1477#3:244\n1502#3,3:245\n1505#3,3:255\n1855#3:258\n1855#3,2:259\n1856#3:261\n372#4,7:248\n*S KotlinDebug\n*F\n+ 1 FirestoreHelper.kt\ncom/arlosoft/macrodroid/firebase/FirestoreHelper\n*L\n98#1:239,2\n125#1:241\n128#1:242,2\n133#1:244\n133#1:245,3\n133#1:255,3\n134#1:258\n135#1:259,2\n134#1:261\n133#1:248,7\n*E\n"})
/* loaded from: classes3.dex */
public final class FirestoreHelper {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12142a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseStorage f12143b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: FirestoreHelper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: FirestoreHelper.kt */
    /* loaded from: classes3.dex */
    public interface FileDownloadListener {
        void downloadFailed();

        void fileDownloaded(@NotNull File file);
    }

    /* compiled from: FirestoreHelper.kt */
    /* loaded from: classes3.dex */
    public interface OperationCompleteListener {
        void operationComplete(boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FirestoreHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<String, Unit> {
        final /* synthetic */ File $backupDir;
        final /* synthetic */ long $maxRetryTime;
        final /* synthetic */ OperationCompleteListener $onCompleteListener;
        final /* synthetic */ StorageReference $storageRef;
        final /* synthetic */ long $timeStamp;
        final /* synthetic */ String $uid;
        final /* synthetic */ FirestoreHelper this$0;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FirestoreHelper.kt */
        /* renamed from: com.arlosoft.macrodroid.firebase.FirestoreHelper$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0107a extends Lambda implements Function1<String, Unit> {
            final /* synthetic */ String $basefilename;
            final /* synthetic */ OperationCompleteListener $onCompleteListener;
            final /* synthetic */ StorageReference $storageRef;
            final /* synthetic */ String $uid;
            final /* synthetic */ FirestoreHelper this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: FirestoreHelper.kt */
            /* renamed from: com.arlosoft.macrodroid.firebase.FirestoreHelper$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0108a extends Lambda implements Function1<UploadTask.TaskSnapshot, Unit> {
                final /* synthetic */ File $file;
                final /* synthetic */ OperationCompleteListener $onCompleteListener;
                final /* synthetic */ FirestoreHelper this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0108a(File file, OperationCompleteListener operationCompleteListener, FirestoreHelper firestoreHelper) {
                    super(1);
                    this.$file = file;
                    this.$onCompleteListener = operationCompleteListener;
                    this.this$0 = firestoreHelper;
                }

                public final void a(UploadTask.TaskSnapshot taskSnapshot) {
                    String name = this.$file.getName();
                    SystemLog.logInfo("File uploaded to cloud backup: " + name);
                    OperationCompleteListener operationCompleteListener = this.$onCompleteListener;
                    if (operationCompleteListener != null) {
                        operationCompleteListener.operationComplete(true);
                    }
                    this.this$0.k();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(UploadTask.TaskSnapshot taskSnapshot) {
                    a(taskSnapshot);
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0107a(FirestoreHelper firestoreHelper, String str, StorageReference storageReference, String str2, OperationCompleteListener operationCompleteListener) {
                super(1);
                this.this$0 = firestoreHelper;
                this.$basefilename = str;
                this.$storageRef = storageReference;
                this.$uid = str2;
                this.$onCompleteListener = operationCompleteListener;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(OperationCompleteListener operationCompleteListener, FirestoreHelper this$0, Exception it) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(it, "it");
                SystemLog.logError("Failed to upload to cloud backup: " + it);
                if (operationCompleteListener != null) {
                    operationCompleteListener.operationComplete(false);
                }
                this$0.k();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e(Function1 tmp0, Object obj) {
                Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                tmp0.invoke(obj);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                String nameWithoutExtension;
                File l4 = this.this$0.l(this.$basefilename);
                if (l4 != null) {
                    StorageReference storageReference = this.$storageRef;
                    String str2 = this.$uid;
                    String str3 = this.$basefilename;
                    final OperationCompleteListener operationCompleteListener = this.$onCompleteListener;
                    final FirestoreHelper firestoreHelper = this.this$0;
                    nameWithoutExtension = kotlin.io.e.getNameWithoutExtension(l4);
                    StorageReference child = storageReference.child("cloudBackup/" + str2 + RemoteSettings.FORWARD_SLASH_STRING + (nameWithoutExtension + ".zip"));
                    Intrinsics.checkNotNullExpressionValue(child, "storageRef.child(\"cloudB…up/$uid/$outputFileName\")");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Attempting to upload macro file to: ");
                    sb.append(child);
                    Timber.d(sb.toString(), new Object[0]);
                    SystemLog.logDebug("Attempting to upload macro file to: " + child);
                    File file = new File(str3 + ".zip");
                    ZipUtil.packEntry(l4, file);
                    StorageTask<UploadTask.TaskSnapshot> addOnFailureListener = child.putFile(Uri.fromFile(file)).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.firebase.j
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public final void onFailure(Exception exc) {
                            FirestoreHelper.a.C0107a.c(FirestoreHelper.OperationCompleteListener.this, firestoreHelper, exc);
                        }
                    });
                    final C0108a c0108a = new C0108a(l4, operationCompleteListener, firestoreHelper);
                    addOnFailureListener.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.firebase.k
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public final void onSuccess(Object obj) {
                            FirestoreHelper.a.C0107a.e(Function1.this, obj);
                        }
                    });
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(File file, long j4, FirestoreHelper firestoreHelper, long j5, StorageReference storageReference, String str, OperationCompleteListener operationCompleteListener) {
            super(1);
            this.$backupDir = file;
            this.$timeStamp = j4;
            this.this$0 = firestoreHelper;
            this.$maxRetryTime = j5;
            this.$storageRef = storageReference;
            this.$uid = str;
            this.$onCompleteListener = operationCompleteListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(OperationCompleteListener operationCompleteListener, Exception it) {
            Intrinsics.checkNotNullParameter(it, "it");
            SystemLog.logWarning("Faled to uploaded to cloud backup: " + it + "}");
            if (operationCompleteListener != null) {
                operationCompleteListener.operationComplete(false);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            String str = this.$backupDir.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + this.$timeStamp + "___" + identifier;
            this.this$0.f12143b.setMaxUploadRetryTimeMillis(this.$maxRetryTime);
            Task<String> id = FirebaseInstallations.getInstance().getId();
            final C0107a c0107a = new C0107a(this.this$0, str, this.$storageRef, this.$uid, this.$onCompleteListener);
            Task<String> addOnSuccessListener = id.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.firebase.h
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    FirestoreHelper.a.c(Function1.this, obj);
                }
            });
            final OperationCompleteListener operationCompleteListener = this.$onCompleteListener;
            addOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.firebase.i
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    FirestoreHelper.a.e(FirestoreHelper.OperationCompleteListener.this, exc);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FirestoreHelper.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<ListResult, Unit> {
        b() {
            super(1);
        }

        public final void a(ListResult listResult) {
            SystemLog.logInfo("All cloud backups deleted");
            FirestoreHelper firestoreHelper = FirestoreHelper.this;
            List<StorageReference> items = listResult.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "listResult.items");
            firestoreHelper.o(items);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ListResult listResult) {
            a(listResult);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FirestoreHelper.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<Void, Unit> {
        final /* synthetic */ OperationCompleteListener $onCompleteListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(OperationCompleteListener operationCompleteListener) {
            super(1);
            this.$onCompleteListener = operationCompleteListener;
        }

        public final void a(Void r22) {
            OperationCompleteListener operationCompleteListener = this.$onCompleteListener;
            if (operationCompleteListener != null) {
                operationCompleteListener.operationComplete(true);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r12) {
            a(r12);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: FirestoreHelper.kt */
    /* loaded from: classes3.dex */
    static final class d extends Lambda implements Function1<FileDownloadTask.TaskSnapshot, Unit> {
        final /* synthetic */ FileDownloadListener $fileDownloadListener;
        final /* synthetic */ File $localFile;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(FileDownloadListener fileDownloadListener, File file) {
            super(1);
            this.$fileDownloadListener = fileDownloadListener;
            this.$localFile = file;
        }

        public final void a(FileDownloadTask.TaskSnapshot taskSnapshot) {
            FileDownloadListener fileDownloadListener = this.$fileDownloadListener;
            File localFile = this.$localFile;
            Intrinsics.checkNotNullExpressionValue(localFile, "localFile");
            fileDownloadListener.fileDownloaded(localFile);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(FileDownloadTask.TaskSnapshot taskSnapshot) {
            a(taskSnapshot);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public FirestoreHelper(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f12142a = context;
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
        Intrinsics.checkNotNullExpressionValue(firebaseStorage, "getInstance()");
        this.f12143b = firebaseStorage;
    }

    private final void h() {
        String cloudBackupsId = Settings.getCloudBackupsId(this.f12142a);
        if (cloudBackupsId == null) {
            SystemLog.logVerbose("Cloud backup delete all failed - User not logged in");
            return;
        }
        StorageReference reference = this.f12143b.getReference();
        Intrinsics.checkNotNullExpressionValue(reference, "storage.reference");
        StorageReference child = reference.child("cloudBackup/" + cloudBackupsId);
        Intrinsics.checkNotNullExpressionValue(child, "storageRef.child(\"cloudBackup/$uid\")");
        Task<ListResult> listAll = child.listAll();
        final b bVar = new b();
        listAll.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.firebase.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirestoreHelper.i(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.firebase.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FirestoreHelper.j(exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        SystemLog.logError("Cloud backup delete all failed: " + it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        File[] listFiles = new File(this.f12142a.getFilesDir().getAbsolutePath(), AutoBackupConstantsKt.CLOUD_BACKUP_DIR).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File l(String str) {
        String str2;
        String str3;
        boolean autoBackupEncryptionEnabled = Settings.getAutoBackupEncryptionEnabled(this.f12142a);
        if (autoBackupEncryptionEnabled) {
            str2 = Settings.getAutoBackupEncryptionPassword(this.f12142a);
        } else {
            str2 = null;
        }
        if (autoBackupEncryptionEnabled) {
            str3 = ".emdr";
        } else {
            str3 = ".mdr";
        }
        String str4 = str + str3;
        if (MacroStore.getInstance(this.f12142a.getApplicationContext()).getAllCompletedMacros().size() > 0) {
            try {
                SystemLog.logVerbose("Saving cloud auto backup file");
                MacroStore.getInstance(this.f12142a.getApplicationContext()).writeToJSON(str4, true, true, false, str2);
                return new File(str4);
            } catch (Exception e4) {
                SystemLog.logError("Autobackup failed: " + e4);
                FirebaseCrashlytics.getInstance().recordException(e4);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(OperationCompleteListener operationCompleteListener, Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (operationCompleteListener != null) {
            operationCompleteListener.operationComplete(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(List<? extends StorageReference> list) {
        List sortedWith;
        List<StorageReference> drop;
        List take;
        List<StorageReference> drop2;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.arlosoft.macrodroid.firebase.FirestoreHelper$deleteFiles$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                long u3;
                long u4;
                int compareValues;
                FirestoreHelper firestoreHelper = FirestoreHelper.this;
                String name = ((StorageReference) t4).getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                u3 = firestoreHelper.u(name);
                Long valueOf = Long.valueOf(u3);
                FirestoreHelper firestoreHelper2 = FirestoreHelper.this;
                String name2 = ((StorageReference) t3).getName();
                Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                u4 = firestoreHelper2.u(name2);
                compareValues = kotlin.comparisons.f.compareValues(valueOf, Long.valueOf(u4));
                return compareValues;
            }
        });
        List list2 = sortedWith;
        drop = CollectionsKt___CollectionsKt.drop(list2, 20);
        for (StorageReference storageReference : drop) {
            storageReference.delete();
        }
        take = CollectionsKt___CollectionsKt.take(list2, 20);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : take) {
            String name = ((StorageReference) obj).getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            String t3 = t(name);
            Object obj2 = linkedHashMap.get(t3);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(t3, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (List list3 : linkedHashMap.values()) {
            drop2 = CollectionsKt___CollectionsKt.drop(list3, 5);
            for (StorageReference storageReference2 : drop2) {
                storageReference2.delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(FileDownloadListener fileDownloadListener, Exception it) {
        Intrinsics.checkNotNullParameter(fileDownloadListener, "$fileDownloadListener");
        Intrinsics.checkNotNullParameter(it, "it");
        fileDownloadListener.downloadFailed();
    }

    private final void r(final Function1<? super String, Unit> function1) {
        final String str = Build.MANUFACTURER;
        final String str2 = Build.MODEL;
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener() { // from class: com.arlosoft.macrodroid.firebase.e
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                FirestoreHelper.s(Function1.this, str, str2, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Function1 identifierReady, String str, String str2, Task task) {
        Intrinsics.checkNotNullParameter(identifierReady, "$identifierReady");
        Intrinsics.checkNotNullParameter(task, "task");
        boolean isSuccessful = task.isSuccessful();
        String str3 = TypeDescription.Generic.OfWildcardType.SYMBOL;
        if (isSuccessful) {
            try {
                str3 = (String) task.getResult();
            } catch (Exception e4) {
                SystemLog.logError("Failed to get firebase instance id: " + e4);
            }
        }
        identifierReady.invoke(str + "___" + str2 + "___" + str3);
    }

    private final String t(String str) {
        int lastIndexOf$default;
        int lastIndexOf$default2;
        try {
            lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "___", 0, false, 6, (Object) null);
            lastIndexOf$default2 = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, ".", 0, false, 6, (Object) null);
            String substring = str.substring(lastIndexOf$default + 3, lastIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("getDeviceIdFromName failed (" + str + "): " + e4));
            return TypeDescription.Generic.OfWildcardType.SYMBOL;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long u(String str) {
        int indexOf$default;
        try {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, "___", 0, false, 6, (Object) null);
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return Long.parseLong(substring);
        } catch (NumberFormatException unused) {
            return Long.MAX_VALUE;
        }
    }

    public final void backupFileToCloud(@NotNull String uid, long j4, @Nullable OperationCompleteListener operationCompleteListener) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        StorageReference reference = this.f12143b.getReference();
        Intrinsics.checkNotNullExpressionValue(reference, "storage.reference");
        File file = new File(this.f12142a.getFilesDir().getAbsolutePath(), AutoBackupConstantsKt.CLOUD_BACKUP_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        r(new a(file, System.currentTimeMillis(), this, j4, reference, uid, operationCompleteListener));
    }

    public final void backupMacrosToCloud() {
        String cloudBackupsId = Settings.getCloudBackupsId(this.f12142a);
        if (cloudBackupsId == null) {
            SystemLog.logVerbose("Cloud backup failed - User not logged in");
            return;
        }
        backupFileToCloud(cloudBackupsId, 10000L, null);
        h();
    }

    public final void deleteFile(@NotNull String name, @Nullable final OperationCompleteListener operationCompleteListener) {
        Intrinsics.checkNotNullParameter(name, "name");
        String cloudBackupsId = Settings.getCloudBackupsId(this.f12142a);
        if (cloudBackupsId == null) {
            if (operationCompleteListener != null) {
                operationCompleteListener.operationComplete(false);
                return;
            }
            return;
        }
        StorageReference reference = this.f12143b.getReference();
        Intrinsics.checkNotNullExpressionValue(reference, "storage.reference");
        StorageReference child = reference.child("cloudBackup/" + cloudBackupsId + RemoteSettings.FORWARD_SLASH_STRING + name);
        Intrinsics.checkNotNullExpressionValue(child, "storageRef.child(\"cloudBackup/$uid/$name\")");
        Task<Void> addOnFailureListener = child.delete().addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.firebase.c
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FirestoreHelper.m(FirestoreHelper.OperationCompleteListener.this, exc);
            }
        });
        final c cVar = new c(operationCompleteListener);
        addOnFailureListener.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.firebase.d
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirestoreHelper.n(Function1.this, obj);
            }
        });
    }

    public final void downloadFile(@NotNull String name, @NotNull final FileDownloadListener fileDownloadListener) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fileDownloadListener, "fileDownloadListener");
        String cloudBackupsId = Settings.getCloudBackupsId(this.f12142a);
        if (cloudBackupsId == null) {
            fileDownloadListener.downloadFailed();
            return;
        }
        File createTempFile = File.createTempFile(AutoBackupCloudWorker.UNIQUE_WORK_NAME, "zip");
        this.f12143b.setMaxDownloadRetryTimeMillis(5000L);
        StorageReference reference = this.f12143b.getReference();
        Intrinsics.checkNotNullExpressionValue(reference, "storage.reference");
        StorageReference child = reference.child("cloudBackup/" + cloudBackupsId + RemoteSettings.FORWARD_SLASH_STRING + name);
        Intrinsics.checkNotNullExpressionValue(child, "storageRef.child(\"cloudBackup/$uid/$name\")");
        FileDownloadTask file = child.getFile(createTempFile);
        final d dVar = new d(fileDownloadListener, createTempFile);
        file.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.firebase.f
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirestoreHelper.p(Function1.this, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.arlosoft.macrodroid.firebase.g
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                FirestoreHelper.q(FirestoreHelper.FileDownloadListener.this, exc);
            }
        });
    }

    @NotNull
    public final Context getContext() {
        return this.f12142a;
    }
}
