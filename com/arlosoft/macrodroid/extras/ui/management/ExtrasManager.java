package com.arlosoft.macrodroid.extras.ui.management;

import android.content.Context;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.database.room.ExtraInstalled;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.ktx.Firebase;
import java.io.File;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtrasManager.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ExtrasManager {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12115a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MacroDroidRoomDatabase f12116b;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final String f12114c = "extraPackages";

    /* compiled from: ExtrasManager.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getExtrasCollection() {
            return ExtrasManager.f12114c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasManager.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return ExtrasManager.this.installExtraPackage(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExtrasManager.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ContinuationImpl {
        Object L$0;
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
            return ExtrasManager.this.removeExtraPackage(null, false, this);
        }
    }

    @Inject
    public ExtrasManager(@ApplicationContext @NotNull Context context, @NotNull MacroDroidRoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        this.f12115a = context;
        this.f12116b = roomDatabase;
    }

    public static /* synthetic */ Object removeExtraPackage$default(ExtrasManager extrasManager, String str, boolean z3, Continuation continuation, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = false;
        }
        return extrasManager.removeExtraPackage(str, z3, continuation);
    }

    public final void disableMacros() {
        MacroStore.getInstance().setExtraEnabledState(false);
    }

    public final boolean getActiveState() {
        return Settings.getExtrasEnabled(this.f12115a);
    }

    @Nullable
    public final Object getInstalledVersion(@NotNull ExtraPackage extraPackage, @NotNull Continuation<? super ExtraInstalled> continuation) {
        return this.f12116b.extraInstalledDao().getInstalledExtraById(extraPackage.getId(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0105  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object installExtraPackage(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.extras.data.ExtraPackage r7, @org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.ui.management.ExtrasManager.installExtraPackage(com.arlosoft.macrodroid.extras.data.ExtraPackage, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean isExtraInstalled(@NotNull String packageId) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        String absolutePath = this.f12115a.getFilesDir().getAbsolutePath();
        return new File(absolutePath + "/extramacros.bin").exists();
    }

    public final void registerDeviceId(@NotNull String rootCollection, @NotNull String service) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(rootCollection, "rootCollection");
        Intrinsics.checkNotNullParameter(service, "service");
        MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
        String string = Settings.Secure.getString(companion.getInstance().getContentResolver(), "android_id");
        hashMapOf = s.hashMapOf(TuplesKt.to("hasUsedTrial", "true"));
        FirestoreKt.getFirestore(Firebase.INSTANCE).collection(rootCollection).document(service).collection("devices").document(string).set(hashMapOf, SetOptions.merge());
        com.arlosoft.macrodroid.settings.Settings.setExtraNoFreeTrial(companion.getInstance(), true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeExtraPackage(@org.jetbrains.annotations.NotNull java.lang.String r5, boolean r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.arlosoft.macrodroid.extras.ui.management.ExtrasManager.b
            if (r0 == 0) goto L13
            r0 = r7
            com.arlosoft.macrodroid.extras.ui.management.ExtrasManager$b r0 = (com.arlosoft.macrodroid.extras.ui.management.ExtrasManager.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.arlosoft.macrodroid.extras.ui.management.ExtrasManager$b r0 = new com.arlosoft.macrodroid.extras.ui.management.ExtrasManager$b
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            boolean r6 = r0.Z$0
            java.lang.Object r5 = r0.L$0
            com.arlosoft.macrodroid.extras.ui.management.ExtrasManager r5 = (com.arlosoft.macrodroid.extras.ui.management.ExtrasManager) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = "Removing extra package: "
            r7.append(r2)
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logDebug(r7)
            com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase r7 = r4.f12116b
            com.arlosoft.macrodroid.database.room.ExtraInstalledDao r7 = r7.extraInstalledDao()
            r0.L$0 = r4
            r0.Z$0 = r6
            r0.label = r3
            java.lang.Object r5 = r7.deleteInstalledExtra(r5, r0)
            if (r5 != r1) goto L61
            return r1
        L61:
            r5 = r4
        L62:
            java.io.File r7 = new java.io.File
            android.content.Context r0 = r5.f12115a
            java.io.File r0 = r0.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "/extramacros.bin"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r7.<init>(r0)
            r7.delete()
            com.arlosoft.macrodroid.macro.MacroStore r7 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()
            r7.removeAllExtraMacros()
            android.content.Context r7 = r5.f12115a
            r0 = 0
            com.arlosoft.macrodroid.settings.Settings.setExtrasEnabled(r7, r0)
            r5.setActiveState(r0)
            de.greenrobot.event.EventBus r5 = com.arlosoft.macrodroid.events.EventBusUtils.getEventBus()
            com.arlosoft.macrodroid.events.RefreshStopClubEvent r7 = new com.arlosoft.macrodroid.events.RefreshStopClubEvent
            r7.<init>(r6)
            r5.post(r7)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.extras.ui.management.ExtrasManager.removeExtraPackage(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void setActiveState(boolean z3) {
        MacroStore.getInstance().setExtraEnabledState(z3);
        com.arlosoft.macrodroid.settings.Settings.setExtrasEnabled(this.f12115a, z3);
    }
}
