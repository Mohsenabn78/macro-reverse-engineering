package com.arlosoft.macrodroid.logcat;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: LogcatMessageRepository.kt */
@StabilityInferred(parameters = 0)
@Singleton
/* loaded from: classes3.dex */
public final class LogcatMessageRepository {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<LogcatMessage> f12645a;

    @Inject
    public LogcatMessageRepository() {
        List<LogcatMessage> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f12645a = emptyList;
    }

    public final void clearMessageList() {
        List<LogcatMessage> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.f12645a = emptyList;
    }

    @NotNull
    public final List<LogcatMessage> getLogcatMessageList() {
        return this.f12645a;
    }

    public final void setLogcatMessageList(@NotNull List<LogcatMessage> logcatMessageList) {
        Intrinsics.checkNotNullParameter(logcatMessageList, "logcatMessageList");
        this.f12645a = logcatMessageList;
    }
}
