package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.e;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SessionInitiator.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\"\u001a\u00020\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/google/firebase/sessions/SessionInitiator;", "", "", "a", "appBackgrounded", "appForegrounded", "Lcom/google/firebase/sessions/TimeProvider;", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "Lcom/google/firebase/sessions/SessionInitiateListener;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Lcom/google/firebase/sessions/SessionInitiateListener;", "sessionInitiateListener", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "d", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionsSettings", "Lcom/google/firebase/sessions/SessionGenerator;", "e", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionGenerator", "Lkotlin/time/Duration;", "f", "J", "backgroundTime", "Landroid/app/Application$ActivityLifecycleCallbacks;", "g", "Landroid/app/Application$ActivityLifecycleCallbacks;", "getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions", "()Landroid/app/Application$ActivityLifecycleCallbacks;", "activityLifecycleCallbacks", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/firebase/sessions/TimeProvider;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/sessions/SessionInitiateListener;Lcom/google/firebase/sessions/settings/SessionsSettings;Lcom/google/firebase/sessions/SessionGenerator;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class SessionInitiator {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final TimeProvider f32136a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f32137b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final SessionInitiateListener f32138c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SessionsSettings f32139d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final SessionGenerator f32140e;

    /* renamed from: f  reason: collision with root package name */
    private long f32141f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f32142g;

    public SessionInitiator(@NotNull TimeProvider timeProvider, @NotNull CoroutineContext backgroundDispatcher, @NotNull SessionInitiateListener sessionInitiateListener, @NotNull SessionsSettings sessionsSettings, @NotNull SessionGenerator sessionGenerator) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(sessionInitiateListener, "sessionInitiateListener");
        Intrinsics.checkNotNullParameter(sessionsSettings, "sessionsSettings");
        Intrinsics.checkNotNullParameter(sessionGenerator, "sessionGenerator");
        this.f32136a = timeProvider;
        this.f32137b = backgroundDispatcher;
        this.f32138c = sessionInitiateListener;
        this.f32139d = sessionsSettings;
        this.f32140e = sessionGenerator;
        this.f32141f = timeProvider.mo4170elapsedRealtimeUwyO8pc();
        a();
        this.f32142g = new Application.ActivityLifecycleCallbacks() { // from class: com.google.firebase.sessions.SessionInitiator$activityLifecycleCallbacks$1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                SessionInitiator.this.appBackgrounded();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                SessionInitiator.this.appForegrounded();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NotNull Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        };
    }

    private final void a() {
        e.e(CoroutineScopeKt.CoroutineScope(this.f32137b), null, null, new SessionInitiator$initiateSession$1(this, this.f32140e.generateNewSession(), null), 3, null);
    }

    public final void appBackgrounded() {
        this.f32141f = this.f32136a.mo4170elapsedRealtimeUwyO8pc();
    }

    public final void appForegrounded() {
        if (Duration.m4667compareToLRDsOJo(Duration.m4698minusLRDsOJo(this.f32136a.mo4170elapsedRealtimeUwyO8pc(), this.f32141f), this.f32139d.m4172getSessionRestartTimeoutUwyO8pc()) > 0) {
            a();
        }
    }

    @NotNull
    public final Application.ActivityLifecycleCallbacks getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions() {
        return this.f32142g;
    }
}
