package com.arlosoft.macrodroid.voiceservice;

import android.os.Bundle;
import android.service.voice.VoiceInteractionSessionService;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroDroidVoiceSessionService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MacroDroidVoiceSessionService extends VoiceInteractionSessionService {
    public static final int $stable = 0;

    @Override // android.service.voice.VoiceInteractionSessionService
    @NotNull
    public MacroDroidVoiceSession onNewSession(@Nullable Bundle bundle) {
        return new MacroDroidVoiceSession(this);
    }
}
