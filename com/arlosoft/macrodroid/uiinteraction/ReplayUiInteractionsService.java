package com.arlosoft.macrodroid.uiinteraction;

import android.app.IntentService;
import android.content.Intent;
import android.view.WindowManager;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.services.HUDView;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.utils.OverlayUtils;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReplayUiInteractionsService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ReplayUiInteractionsService extends IntentService {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private HUDView f15856a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager f15857b;

    public ReplayUiInteractionsService() {
        super("ReplayUiInteractionsService");
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, OverlayUtils.getOverlayType(), 24, -3);
        Object systemService = getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.f15857b = (WindowManager) systemService;
        this.f15856a = new HUDView(this, "Replaying Touch Events", R.drawable.play_translucent);
        WindowManager windowManager = this.f15857b;
        HUDView hUDView = null;
        if (windowManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowManager");
            windowManager = null;
        }
        HUDView hUDView2 = this.f15856a;
        if (hUDView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hudView");
        } else {
            hUDView = hUDView2;
        }
        windowManager.addView(hUDView, layoutParams);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(@Nullable Intent intent) {
        List<UiInteraction> list;
        if (intent != null) {
            list = intent.getParcelableArrayListExtra(ReplayUiInteractionsServiceKt.EXTRA_INTERACTIONS_LIST);
        } else {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        long j4 = 0;
        for (UiInteraction uiInteraction : list) {
            if (j4 != 0) {
                Thread.sleep(uiInteraction.getTimestamp() - j4);
            } else {
                Thread.sleep(2000L);
            }
            startService(new Intent(this, UIInteractionAccessibilityService.class));
            j4 = uiInteraction.getTimestamp();
        }
    }
}
