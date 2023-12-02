package com.arlosoft.macrodroid.freeversion.datapartners;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: DataAiDataPartner.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class DataAiDataPartner extends DataPartner {
    public static final int $stable = 0;

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    public void initialise(@NotNull Function1<? super Boolean, Unit> completeCallback) {
        Intrinsics.checkNotNullParameter(completeCallback, "completeCallback");
        SystemLog.logDebug("Initialising Data.ai service");
        completeCallback.invoke(Boolean.TRUE);
    }

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    @NotNull
    public String partnerName() {
        return "DataAi";
    }

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    public void disableDataSharing(boolean z3) {
    }

    @Override // com.arlosoft.macrodroid.freeversion.datapartners.DataPartner
    public void enableDataSharing() {
    }
}
