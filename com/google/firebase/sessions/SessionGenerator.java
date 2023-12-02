package com.google.firebase.sessions;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;

/* compiled from: SessionGenerator.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00048\u0006@BX\u0086.¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\t¨\u0006%"}, d2 = {"Lcom/google/firebase/sessions/SessionGenerator;", "", "", "a", "Lcom/google/firebase/sessions/SessionDetails;", "generateNewSession", "", "Z", "getCollectEvents", "()Z", "collectEvents", "Lcom/google/firebase/sessions/TimeProvider;", "b", "Lcom/google/firebase/sessions/TimeProvider;", "timeProvider", "Lkotlin/Function0;", "Ljava/util/UUID;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Lkotlin/jvm/functions/Function0;", "uuidGenerator", "d", "Ljava/lang/String;", "firstSessionId", "", "e", "I", "sessionIndex", "<set-?>", "f", "Lcom/google/firebase/sessions/SessionDetails;", "getCurrentSession", "()Lcom/google/firebase/sessions/SessionDetails;", "currentSession", "getHasGenerateSession", "hasGenerateSession", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(ZLcom/google/firebase/sessions/TimeProvider;Lkotlin/jvm/functions/Function0;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class SessionGenerator {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f32123a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final TimeProvider f32124b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function0<UUID> f32125c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final String f32126d;

    /* renamed from: e  reason: collision with root package name */
    private int f32127e;

    /* renamed from: f  reason: collision with root package name */
    private SessionDetails f32128f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SessionGenerator.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.google.firebase.sessions.SessionGenerator$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<UUID> {

        /* renamed from: a  reason: collision with root package name */
        public static final AnonymousClass1 f32129a = new AnonymousClass1();

        AnonymousClass1() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    public SessionGenerator(boolean z3, @NotNull TimeProvider timeProvider, @NotNull Function0<UUID> uuidGenerator) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(uuidGenerator, "uuidGenerator");
        this.f32123a = z3;
        this.f32124b = timeProvider;
        this.f32125c = uuidGenerator;
        this.f32126d = a();
        this.f32127e = -1;
    }

    private final String a() {
        String replace$default;
        String uuid = this.f32125c.invoke().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "uuidGenerator().toString()");
        replace$default = m.replace$default(uuid, "-", "", false, 4, (Object) null);
        String lowerCase = replace$default.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    public final SessionDetails generateNewSession() {
        String a4;
        int i4 = this.f32127e + 1;
        this.f32127e = i4;
        if (i4 == 0) {
            a4 = this.f32126d;
        } else {
            a4 = a();
        }
        this.f32128f = new SessionDetails(a4, this.f32126d, this.f32127e, this.f32124b.currentTimeUs());
        return getCurrentSession();
    }

    public final boolean getCollectEvents() {
        return this.f32123a;
    }

    @NotNull
    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.f32128f;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        Intrinsics.throwUninitializedPropertyAccessException("currentSession");
        return null;
    }

    public final boolean getHasGenerateSession() {
        if (this.f32128f != null) {
            return true;
        }
        return false;
    }

    public /* synthetic */ SessionGenerator(boolean z3, TimeProvider timeProvider, Function0 function0, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z3, timeProvider, (i4 & 4) != 0 ? AnonymousClass1.f32129a : function0);
    }
}
