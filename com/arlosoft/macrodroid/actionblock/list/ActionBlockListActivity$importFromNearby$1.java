package com.arlosoft.macrodroid.actionblock.list;

import android.view.View;
import android.widget.ImageView;
import com.araujo.jordan.excuseme.model.PermissionStatus;
import com.arlosoft.macrodroid.databinding.ActivityActionBlockListBinding;
import com.arlosoft.macrodroid.nearby.NearbyHelper;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionBlockListActivity.kt */
/* loaded from: classes.dex */
public final class ActionBlockListActivity$importFromNearby$1 extends Lambda implements Function1<PermissionStatus, Unit> {
    final /* synthetic */ List<String> $permissionsRequired;
    final /* synthetic */ ActionBlockListActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBlockListActivity$importFromNearby$1(List<String> list, ActionBlockListActivity actionBlockListActivity) {
        super(1);
        this.$permissionsRequired = list;
        this.this$0 = actionBlockListActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ActionBlockListActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityActionBlockListBinding activityActionBlockListBinding = this$0.f5592h;
        if (activityActionBlockListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding = null;
        }
        activityActionBlockListBinding.nearbySharePanel.collapse();
        this$0.getNearbyHelper().stopAdvertising();
        this$0.getNearbyHelper().disconnect();
    }

    public final void b(@NotNull PermissionStatus it) {
        Intrinsics.checkNotNullParameter(it, "it");
        for (String str : this.$permissionsRequired) {
            if (!it.getGranted().contains(str)) {
                return;
            }
        }
        ActivityActionBlockListBinding activityActionBlockListBinding = this.this$0.f5592h;
        ActivityActionBlockListBinding activityActionBlockListBinding2 = null;
        if (activityActionBlockListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityActionBlockListBinding = null;
        }
        activityActionBlockListBinding.nearbySharePanel.expand();
        NearbyHelper nearbyHelper = this.this$0.getNearbyHelper();
        final ActionBlockListActivity actionBlockListActivity = this.this$0;
        nearbyHelper.initialiseHelperForReceiving(new NearbyHelper.NearbyReceiveListener() { // from class: com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity$importFromNearby$1.1
            @Override // com.arlosoft.macrodroid.nearby.NearbyHelper.NearbyReceiveListener
            public void jsonDataAvailable(@NotNull String jsonString) {
                Intrinsics.checkNotNullParameter(jsonString, "jsonString");
                ActivityActionBlockListBinding activityActionBlockListBinding3 = ActionBlockListActivity.this.f5592h;
                if (activityActionBlockListBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityActionBlockListBinding3 = null;
                }
                activityActionBlockListBinding3.nearbySharePanel.collapse();
                ActionBlockListActivity.this.getNearbyHelper().stopAdvertising();
                ActionBlockListActivity.this.getNearbyHelper().disconnect();
                ActionBlockListActivity.this.z(jsonString);
            }
        });
        ActivityActionBlockListBinding activityActionBlockListBinding3 = this.this$0.f5592h;
        if (activityActionBlockListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityActionBlockListBinding2 = activityActionBlockListBinding3;
        }
        ImageView imageView = activityActionBlockListBinding2.dismissButton;
        final ActionBlockListActivity actionBlockListActivity2 = this.this$0;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.actionblock.list.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActionBlockListActivity$importFromNearby$1.c(ActionBlockListActivity.this, view);
            }
        });
        this.this$0.getNearbyHelper().startAdvertising(NearbyHelper.SERVICE_ID_ACTION_BLOCK_SHARE);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PermissionStatus permissionStatus) {
        b(permissionStatus);
        return Unit.INSTANCE;
    }
}
