package com.arlosoft.macrodroid.triggers.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.NotificationButtonTrigger;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import javax.inject.Inject;

/* loaded from: classes3.dex */
public class NotificationButtonNotAssignedActivity extends MacroDroidDaggerBaseActivity {
    public static final String EXTRA_BUTTON_ID = "ButtonId";
    @Inject

    /* renamed from: f  reason: collision with root package name */
    RemoteConfig f14522f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    PremiumStatusHandler f14523g;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(int i4, View view) {
        int size = MacroStore.getInstance().getAllCompletedMacros().size();
        int freeMacros = Settings.getFreeMacros(this);
        if (!this.f14523g.getPremiumStatus().isPro() && size >= freeMacros) {
            Util.showMacroLimitReached(this, this.f14522f);
            return;
        }
        finish();
        Macro macro = new Macro();
        NotificationButtonTrigger notificationButtonTrigger = new NotificationButtonTrigger();
        notificationButtonTrigger.setId(i4);
        macro.setTrigger(notificationButtonTrigger);
        macro.setConfiguringShortcut(true);
        Intent intent = new Intent(this, WizardActivity.class);
        intent.putExtra("Macro", macro);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        finish();
    }

    private void q(Intent intent) {
        final int intExtra = intent.getIntExtra(EXTRA_BUTTON_ID, 0);
        setTitle(R.string.notification_button_not_assigned_title);
        ((Button) findViewById(R.id.button_create_macro)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationButtonNotAssignedActivity.this.o(intExtra, view);
            }
        });
        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationButtonNotAssignedActivity.this.p(view);
            }
        });
        setFinishOnTouchOutside(false);
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_not_button_not_assigned);
        getWindow().setLayout(-1, -2);
        getWindow().addFlags(524288);
        q(getIntent());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        q(intent);
    }
}
