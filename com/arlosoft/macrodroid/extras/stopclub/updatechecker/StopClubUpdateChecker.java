package com.arlosoft.macrodroid.extras.stopclub.updatechecker;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.modules.BillingModuleKt;
import com.arlosoft.macrodroid.database.room.ExtraInstalled;
import com.arlosoft.macrodroid.extras.data.ExtraPackage;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.gson.GsonUtils;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.CountryCodeUtil;
import com.arlosoft.macrodroid.utils.NotificationUtils;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Source;
import com.google.firebase.firestore.ktx.FirestoreKt;
import com.google.firebase.ktx.Firebase;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StopClubUpdateChecker.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class StopClubUpdateChecker {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12043a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ExtrasManager f12044b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseFirestore f12045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StopClubUpdateChecker.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<DocumentSnapshot, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: StopClubUpdateChecker.kt */
        /* renamed from: com.arlosoft.macrodroid.extras.stopclub.updatechecker.StopClubUpdateChecker$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0099a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtraPackage $ePackage;
            int label;
            final /* synthetic */ StopClubUpdateChecker this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0099a(StopClubUpdateChecker stopClubUpdateChecker, ExtraPackage extraPackage, Continuation<? super C0099a> continuation) {
                super(2, continuation);
                this.this$0 = stopClubUpdateChecker;
                this.$ePackage = extraPackage;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new C0099a(this.this$0, this.$ePackage, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended;
                int i4;
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                int i5 = this.label;
                if (i5 != 0) {
                    if (i5 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ExtrasManager extrasManager = this.this$0.f12044b;
                    ExtraPackage extraPackage = this.$ePackage;
                    this.label = 1;
                    obj = extrasManager.getInstalledVersion(extraPackage, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                ExtraInstalled extraInstalled = (ExtraInstalled) obj;
                if (extraInstalled != null) {
                    i4 = extraInstalled.getVersionCode();
                } else {
                    i4 = 0;
                }
                if (i4 > 0 && i4 < this.$ePackage.getVersionCode()) {
                    this.this$0.d(this.$ePackage);
                }
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((C0099a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        a() {
            super(1);
        }

        public final void a(DocumentSnapshot document) {
            StopClubUpdateChecker stopClubUpdateChecker = StopClubUpdateChecker.this;
            Intrinsics.checkNotNullExpressionValue(document, "document");
            ExtraPackage c4 = stopClubUpdateChecker.c(document);
            if (c4 != null) {
                e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C0099a(StopClubUpdateChecker.this, c4, null), 2, null);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DocumentSnapshot documentSnapshot) {
            a(documentSnapshot);
            return Unit.INSTANCE;
        }
    }

    public StopClubUpdateChecker(@NotNull Context context, @NotNull ExtrasManager extrasManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extrasManager, "extrasManager");
        this.f12043a = context;
        this.f12044b = extrasManager;
        this.f12045c = FirestoreKt.getFirestore(Firebase.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExtraPackage c(DocumentSnapshot documentSnapshot) {
        Map<String, Object> data = documentSnapshot.getData();
        if (data != null) {
            try {
                return (ExtraPackage) GsonUtils.getGsonBuilder().create().fromJson(String.valueOf(data.get("jsonData")), (Class<Object>) ExtraPackage.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(ExtraPackage extraPackage) {
        if (Settings.getNotifiedStopClubVersionCode(this.f12043a) < extraPackage.getVersionCode()) {
            NotificationUtils.displayStopClubUpdataAvaialable(this.f12043a, extraPackage.getVersionString());
            Settings.setNotifiedStopClubVersionCode(this.f12043a, extraPackage.getVersionCode());
        }
    }

    public final void checkForUpdate() {
        String lowerCase = CountryCodeUtil.INSTANCE.getDetectedCountry(this.f12043a, "br").toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        Task<DocumentSnapshot> task = this.f12045c.collection(ExtrasManager.Companion.getExtrasCollection()).document(BillingModuleKt.SKU_STOPCLUB_SUB).collection("countries").document(lowerCase).get(Source.DEFAULT);
        final a aVar = new a();
        task.addOnSuccessListener(new OnSuccessListener() { // from class: com.arlosoft.macrodroid.extras.stopclub.updatechecker.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                StopClubUpdateChecker.b(Function1.this, obj);
            }
        });
    }
}
