package com.google.firebase.sessions;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.ktx.FirebaseKt;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FirebaseSessions.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B7\b\u0000\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020(\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\u0004\b.\u0010/J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions;", "", "Lcom/google/firebase/sessions/SessionDetails;", "sessionDetails", "", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "(Lcom/google/firebase/sessions/SessionDetails;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "d", "Lcom/google/firebase/sessions/api/SessionSubscriber;", "subscriber", "register", "Lcom/google/firebase/FirebaseApp;", "a", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "Lcom/google/firebase/sessions/ApplicationInfo;", "b", "Lcom/google/firebase/sessions/ApplicationInfo;", "applicationInfo", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "sessionSettings", "Lcom/google/firebase/sessions/TimeProvider;", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lcom/google/firebase/sessions/SessionGenerator;", "e", "Lcom/google/firebase/sessions/SessionGenerator;", "sessionGenerator", "Lcom/google/firebase/sessions/EventGDTLogger;", "f", "Lcom/google/firebase/sessions/EventGDTLogger;", "eventGDTLogger", "Lcom/google/firebase/sessions/SessionCoordinator;", "g", "Lcom/google/firebase/sessions/SessionCoordinator;", "sessionCoordinator", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallations", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundDispatcher", "blockingDispatcher", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "transportFactoryProvider", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/firebase/FirebaseApp;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/google/firebase/inject/Provider;)V", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class FirebaseSessions {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f32104a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ApplicationInfo f32105b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final SessionsSettings f32106c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final TimeProvider f32107d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final SessionGenerator f32108e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final EventGDTLogger f32109f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final SessionCoordinator f32110g;

    /* compiled from: FirebaseSessions.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessions$Companion;", "", "()V", "TAG", "", "instance", "Lcom/google/firebase/sessions/FirebaseSessions;", "getInstance$annotations", "getInstance", "()Lcom/google/firebase/sessions/FirebaseSessions;", "app", "Lcom/google/firebase/FirebaseApp;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FirebaseSessions getInstance() {
            return getInstance(FirebaseKt.getApp(Firebase.INSTANCE));
        }

        @JvmStatic
        @NotNull
        public final FirebaseSessions getInstance(@NotNull FirebaseApp app) {
            Intrinsics.checkNotNullParameter(app, "app");
            Object obj = app.get(FirebaseSessions.class);
            Intrinsics.checkNotNullExpressionValue(obj, "app.get(FirebaseSessions::class.java)");
            return (FirebaseSessions) obj;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public FirebaseSessions(@NotNull FirebaseApp firebaseApp, @NotNull FirebaseInstallationsApi firebaseInstallations, @NotNull CoroutineDispatcher backgroundDispatcher, @NotNull CoroutineDispatcher blockingDispatcher, @NotNull Provider<TransportFactory> transportFactoryProvider) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        Intrinsics.checkNotNullParameter(firebaseInstallations, "firebaseInstallations");
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(blockingDispatcher, "blockingDispatcher");
        Intrinsics.checkNotNullParameter(transportFactoryProvider, "transportFactoryProvider");
        this.f32104a = firebaseApp;
        ApplicationInfo applicationInfo = SessionEvents.INSTANCE.getApplicationInfo(firebaseApp);
        this.f32105b = applicationInfo;
        Context applicationContext = firebaseApp.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
        SessionsSettings sessionsSettings = new SessionsSettings(applicationContext, blockingDispatcher, backgroundDispatcher, firebaseInstallations, applicationInfo);
        this.f32106c = sessionsSettings;
        Time time = new Time();
        this.f32107d = time;
        EventGDTLogger eventGDTLogger = new EventGDTLogger(transportFactoryProvider);
        this.f32109f = eventGDTLogger;
        this.f32110g = new SessionCoordinator(firebaseInstallations, eventGDTLogger);
        SessionGenerator sessionGenerator = new SessionGenerator(d(), time, null, 4, null);
        this.f32108e = sessionGenerator;
        final SessionInitiator sessionInitiator = new SessionInitiator(time, backgroundDispatcher, new SessionInitiateListener() { // from class: com.google.firebase.sessions.FirebaseSessions$sessionInitiateListener$1
            @Override // com.google.firebase.sessions.SessionInitiateListener
            @Nullable
            public Object onInitiateSession(@NotNull SessionDetails sessionDetails, @NotNull Continuation<? super Unit> continuation) {
                Object c4;
                Object coroutine_suspended;
                c4 = FirebaseSessions.this.c(sessionDetails, continuation);
                coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (c4 == coroutine_suspended) {
                    return c4;
                }
                return Unit.INSTANCE;
            }
        }, sessionsSettings, sessionGenerator);
        final Context applicationContext2 = firebaseApp.getApplicationContext().getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions());
            firebaseApp.addLifecycleEventListener(new FirebaseAppLifecycleListener() { // from class: com.google.firebase.sessions.b
                @Override // com.google.firebase.FirebaseAppLifecycleListener
                public final void onDeleted(String str, FirebaseOptions firebaseOptions) {
                    FirebaseSessions.b(applicationContext2, sessionInitiator, str, firebaseOptions);
                }
            });
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext2.getClass() + '.');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context, SessionInitiator sessionInitiator, String str, FirebaseOptions firebaseOptions) {
        Intrinsics.checkNotNullParameter(sessionInitiator, "$sessionInitiator");
        Log.w("FirebaseSessions", "FirebaseApp instance deleted. Sessions library will not collect session data.");
        ((Application) context).unregisterActivityLifecycleCallbacks(sessionInitiator.getActivityLifecycleCallbacks$com_google_firebase_firebase_sessions());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(1:(4:12|13|14|15)(2:18|19))(3:20|21|(2:23|24)(2:25|(2:27|28)(5:29|(1:31)|13|14|15))))(1:32))(2:61|(1:63)(1:64))|33|(2:35|36)(6:37|(2:40|38)|41|42|(2:53|(2:54|(1:60)(2:56|(2:58|59))))(0)|(2:47|48)(2:49|(1:51)(3:52|21|(0)(0))))))|67|6|7|(0)(0)|33|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010f, code lost:
        android.util.Log.w("FirebaseSessions", "FirebaseApp is not initialized. Sessions library will not collect session data.", r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(com.google.firebase.sessions.SessionDetails r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.c(com.google.firebase.sessions.SessionDetails, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean d() {
        if (Math.random() <= this.f32106c.getSamplingRate()) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final FirebaseSessions getInstance() {
        return Companion.getInstance();
    }

    public final void register(@NotNull SessionSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        FirebaseSessionsDependencies.INSTANCE.register$com_google_firebase_firebase_sessions(subscriber);
        StringBuilder sb = new StringBuilder();
        sb.append("Registering Sessions SDK subscriber with name: ");
        sb.append(subscriber.getSessionSubscriberName());
        sb.append(", data collection enabled: ");
        sb.append(subscriber.isDataCollectionEnabled());
        if (this.f32108e.getHasGenerateSession()) {
            subscriber.onSessionChanged(new SessionSubscriber.SessionDetails(this.f32108e.getCurrentSession().getSessionId()));
        }
    }

    @JvmStatic
    @NotNull
    public static final FirebaseSessions getInstance(@NotNull FirebaseApp firebaseApp) {
        return Companion.getInstance(firebaseApp);
    }
}
