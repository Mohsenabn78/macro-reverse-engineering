package com.google.firebase.sessions;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SessionEvent.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/google/firebase/sessions/DataCollectionStatus;", "", "Lcom/google/firebase/sessions/DataCollectionState;", "component1", "component2", "", "component3", "performance", "crashlytics", "sessionSamplingRate", "copy", "", "toString", "", "hashCode", "other", "", "equals", "a", "Lcom/google/firebase/sessions/DataCollectionState;", "getPerformance", "()Lcom/google/firebase/sessions/DataCollectionState;", "b", "getCrashlytics", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "D", "getSessionSamplingRate", "()D", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/firebase/sessions/DataCollectionState;Lcom/google/firebase/sessions/DataCollectionState;D)V", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class DataCollectionStatus {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final DataCollectionState f32099a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final DataCollectionState f32100b;

    /* renamed from: c  reason: collision with root package name */
    private final double f32101c;

    public DataCollectionStatus() {
        this(null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 7, null);
    }

    public static /* synthetic */ DataCollectionStatus copy$default(DataCollectionStatus dataCollectionStatus, DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            dataCollectionState = dataCollectionStatus.f32099a;
        }
        if ((i4 & 2) != 0) {
            dataCollectionState2 = dataCollectionStatus.f32100b;
        }
        if ((i4 & 4) != 0) {
            d4 = dataCollectionStatus.f32101c;
        }
        return dataCollectionStatus.copy(dataCollectionState, dataCollectionState2, d4);
    }

    @NotNull
    public final DataCollectionState component1() {
        return this.f32099a;
    }

    @NotNull
    public final DataCollectionState component2() {
        return this.f32100b;
    }

    public final double component3() {
        return this.f32101c;
    }

    @NotNull
    public final DataCollectionStatus copy(@NotNull DataCollectionState performance, @NotNull DataCollectionState crashlytics, double d4) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        Intrinsics.checkNotNullParameter(crashlytics, "crashlytics");
        return new DataCollectionStatus(performance, crashlytics, d4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectionStatus)) {
            return false;
        }
        DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) obj;
        if (this.f32099a == dataCollectionStatus.f32099a && this.f32100b == dataCollectionStatus.f32100b && Intrinsics.areEqual((Object) Double.valueOf(this.f32101c), (Object) Double.valueOf(dataCollectionStatus.f32101c))) {
            return true;
        }
        return false;
    }

    @NotNull
    public final DataCollectionState getCrashlytics() {
        return this.f32100b;
    }

    @NotNull
    public final DataCollectionState getPerformance() {
        return this.f32099a;
    }

    public final double getSessionSamplingRate() {
        return this.f32101c;
    }

    public int hashCode() {
        return (((this.f32099a.hashCode() * 31) + this.f32100b.hashCode()) * 31) + androidx.compose.animation.core.b.a(this.f32101c);
    }

    @NotNull
    public String toString() {
        return "DataCollectionStatus(performance=" + this.f32099a + ", crashlytics=" + this.f32100b + ", sessionSamplingRate=" + this.f32101c + ')';
    }

    public DataCollectionStatus(@NotNull DataCollectionState performance, @NotNull DataCollectionState crashlytics, double d4) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        Intrinsics.checkNotNullParameter(crashlytics, "crashlytics");
        this.f32099a = performance;
        this.f32100b = crashlytics;
        this.f32101c = d4;
    }

    public /* synthetic */ DataCollectionStatus(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState, (i4 & 2) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState2, (i4 & 4) != 0 ? 1.0d : d4);
    }
}
