package com.google.firebase.sessions.settings;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SettingsCache.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJL\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0007R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\nR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010\nR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u000e¨\u0006+"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionConfigs;", "", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/Double;", "", "component3", "()Ljava/lang/Integer;", "component4", "", "component5", "()Ljava/lang/Long;", "sessionEnabled", "sessionSamplingRate", "sessionRestartTimeout", "cacheDuration", "cacheUpdatedTime", "copy", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/google/firebase/sessions/settings/SessionConfigs;", "", "toString", "hashCode", "other", "equals", "a", "Ljava/lang/Boolean;", "getSessionEnabled", "b", "Ljava/lang/Double;", "getSessionSamplingRate", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Ljava/lang/Integer;", "getSessionRestartTimeout", "d", "getCacheDuration", "e", "Ljava/lang/Long;", "getCacheUpdatedTime", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class SessionConfigs {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Boolean f32164a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Double f32165b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Integer f32166c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Integer f32167d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final Long f32168e;

    public SessionConfigs(@Nullable Boolean bool, @Nullable Double d4, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l4) {
        this.f32164a = bool;
        this.f32165b = d4;
        this.f32166c = num;
        this.f32167d = num2;
        this.f32168e = l4;
    }

    public static /* synthetic */ SessionConfigs copy$default(SessionConfigs sessionConfigs, Boolean bool, Double d4, Integer num, Integer num2, Long l4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bool = sessionConfigs.f32164a;
        }
        if ((i4 & 2) != 0) {
            d4 = sessionConfigs.f32165b;
        }
        Double d5 = d4;
        if ((i4 & 4) != 0) {
            num = sessionConfigs.f32166c;
        }
        Integer num3 = num;
        if ((i4 & 8) != 0) {
            num2 = sessionConfigs.f32167d;
        }
        Integer num4 = num2;
        if ((i4 & 16) != 0) {
            l4 = sessionConfigs.f32168e;
        }
        return sessionConfigs.copy(bool, d5, num3, num4, l4);
    }

    @Nullable
    public final Boolean component1() {
        return this.f32164a;
    }

    @Nullable
    public final Double component2() {
        return this.f32165b;
    }

    @Nullable
    public final Integer component3() {
        return this.f32166c;
    }

    @Nullable
    public final Integer component4() {
        return this.f32167d;
    }

    @Nullable
    public final Long component5() {
        return this.f32168e;
    }

    @NotNull
    public final SessionConfigs copy(@Nullable Boolean bool, @Nullable Double d4, @Nullable Integer num, @Nullable Integer num2, @Nullable Long l4) {
        return new SessionConfigs(bool, d4, num, num2, l4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        if (Intrinsics.areEqual(this.f32164a, sessionConfigs.f32164a) && Intrinsics.areEqual((Object) this.f32165b, (Object) sessionConfigs.f32165b) && Intrinsics.areEqual(this.f32166c, sessionConfigs.f32166c) && Intrinsics.areEqual(this.f32167d, sessionConfigs.f32167d) && Intrinsics.areEqual(this.f32168e, sessionConfigs.f32168e)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer getCacheDuration() {
        return this.f32167d;
    }

    @Nullable
    public final Long getCacheUpdatedTime() {
        return this.f32168e;
    }

    @Nullable
    public final Boolean getSessionEnabled() {
        return this.f32164a;
    }

    @Nullable
    public final Integer getSessionRestartTimeout() {
        return this.f32166c;
    }

    @Nullable
    public final Double getSessionSamplingRate() {
        return this.f32165b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        Boolean bool = this.f32164a;
        int i4 = 0;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        int i5 = hashCode * 31;
        Double d4 = this.f32165b;
        if (d4 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = d4.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        Integer num = this.f32166c;
        if (num == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        Integer num2 = this.f32167d;
        if (num2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num2.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        Long l4 = this.f32168e;
        if (l4 != null) {
            i4 = l4.hashCode();
        }
        return i8 + i4;
    }

    @NotNull
    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f32164a + ", sessionSamplingRate=" + this.f32165b + ", sessionRestartTimeout=" + this.f32166c + ", cacheDuration=" + this.f32167d + ", cacheUpdatedTime=" + this.f32168e + ')';
    }
}
