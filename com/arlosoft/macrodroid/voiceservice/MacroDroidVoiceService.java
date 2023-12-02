package com.arlosoft.macrodroid.voiceservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.service.voice.VoiceInteractionService;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroDroidVoiceService.kt */
@StabilityInferred(parameters = 0)
@RequiresApi(23)
/* loaded from: classes3.dex */
public final class MacroDroidVoiceService extends VoiceInteractionService {
    @NotNull
    public static final String ACTION = "com.arlosoft.macrodropid.action.ASSISTANT";
    @NotNull
    public static final String PERMISSION = "com.arlosoft.macrodroid.permission.ASSISTANT";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final BroadcastReceiver f16441a = new BroadcastReceiver() { // from class: com.arlosoft.macrodroid.voiceservice.MacroDroidVoiceService$broadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (StringsKt.equals$default(intent.getAction(), MacroDroidVoiceService.ACTION, false, 2, null)) {
                try {
                    MacroDroidVoiceService.this.showSession(intent.getExtras(), 0);
                } catch (Exception e4) {
                    SystemLog.logError("Failed to invoke MacroDroidVoiceService: " + e4);
                }
            }
        }
    };
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MacroDroidVoiceService.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.service.voice.VoiceInteractionService
    public void onReady() {
        super.onReady();
        registerReceiver(this.f16441a, new IntentFilter(ACTION));
    }

    @Override // android.service.voice.VoiceInteractionService
    public void onShutdown() {
        try {
            unregisterReceiver(this.f16441a);
        } catch (Exception unused) {
        }
        super.onShutdown();
    }
}
