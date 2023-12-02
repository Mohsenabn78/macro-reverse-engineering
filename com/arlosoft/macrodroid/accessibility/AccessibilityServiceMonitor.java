package com.arlosoft.macrodroid.accessibility;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AccessibilityServiceMonitor.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class AccessibilityServiceMonitor {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f2045a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessibilityServiceMonitor.kt */
    /* loaded from: classes2.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            String str;
            boolean contains$default;
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
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            List<String> accessibilityServicesToKeepRunning = Settings.getAccessibilityServicesToKeepRunning(AccessibilityServiceMonitor.this.f2045a);
            String accessibilityServiceOutput = Settings.Secure.getString(AccessibilityServiceMonitor.this.f2045a.getContentResolver(), "enabled_accessibility_services");
            boolean z3 = false;
            if (accessibilityServiceOutput == null) {
                str = "";
            } else {
                boolean z4 = false;
                for (String serviceId : accessibilityServicesToKeepRunning) {
                    Intrinsics.checkNotNullExpressionValue(accessibilityServiceOutput, "accessibilityServiceOutput");
                    Intrinsics.checkNotNullExpressionValue(serviceId, "serviceId");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) accessibilityServiceOutput, (CharSequence) serviceId, false, 2, (Object) null);
                    if (!contains$default) {
                        accessibilityServiceOutput = accessibilityServiceOutput + ":" + serviceId;
                        z4 = true;
                    }
                }
                str = accessibilityServiceOutput;
                z3 = z4;
            }
            if (z3) {
                try {
                    Settings.Secure.putString(AccessibilityServiceMonitor.this.f2045a.getContentResolver(), "enabled_accessibility_services", str);
                } catch (SecurityException unused) {
                    SystemLog.logError("Could not re-enable accessibility service, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS");
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

    @Inject
    public AccessibilityServiceMonitor(@ApplicationContext @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2045a = context;
    }

    private final void a() {
        e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        a();
    }

    public final void monitorServices() {
        ContentResolver contentResolver = this.f2045a.getContentResolver();
        Uri uriFor = Settings.Secure.getUriFor("enabled_accessibility_services");
        a();
        final Handler handler = new Handler();
        contentResolver.registerContentObserver(uriFor, false, new ContentObserver(handler) { // from class: com.arlosoft.macrodroid.accessibility.AccessibilityServiceMonitor$monitorServices$observer$1
            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z3) {
                super.onChange(z3);
                AccessibilityServiceMonitor.this.b();
            }
        });
    }
}
