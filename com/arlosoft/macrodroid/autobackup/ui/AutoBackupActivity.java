package com.arlosoft.macrodroid.autobackup.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity;
import com.arlosoft.macrodroid.databinding.ActivityAutoBackupBinding;
import com.arlosoft.macrodroid.settings.Settings;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AutoBackupActivity.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAutoBackupActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupActivity.kt\ncom/arlosoft/macrodroid/autobackup/ui/AutoBackupActivity\n+ 2 CustomServices.kt\norg/jetbrains/anko/CustomServicesKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,142:1\n26#2:143\n262#3,2:144\n65#4,16:146\n93#4,3:162\n*S KotlinDebug\n*F\n+ 1 AutoBackupActivity.kt\ncom/arlosoft/macrodroid/autobackup/ui/AutoBackupActivity\n*L\n83#1:143\n89#1:144,2\n99#1:146,16\n99#1:162,3\n*E\n"})
/* loaded from: classes3.dex */
public final class AutoBackupActivity extends MacroDroidDaggerBaseActivity {

    /* renamed from: f  reason: collision with root package name */
    private ActivityAutoBackupBinding f9309f;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AutoBackupActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent createIntent(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, AutoBackupActivity.class);
        }
    }

    @JvmStatic
    @NotNull
    public static final Intent createIntent(@NotNull Context context) {
        return Companion.createIntent(context);
    }

    private final void p() {
        final d dVar = new d(this);
        ActivityAutoBackupBinding activityAutoBackupBinding = this.f9309f;
        ActivityAutoBackupBinding activityAutoBackupBinding2 = null;
        if (activityAutoBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAutoBackupBinding = null;
        }
        activityAutoBackupBinding.viewPager.setAdapter(dVar);
        ActivityAutoBackupBinding activityAutoBackupBinding3 = this.f9309f;
        if (activityAutoBackupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityAutoBackupBinding3 = null;
        }
        TabLayout tabLayout = activityAutoBackupBinding3.tabLayout;
        ActivityAutoBackupBinding activityAutoBackupBinding4 = this.f9309f;
        if (activityAutoBackupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAutoBackupBinding2 = activityAutoBackupBinding4;
        }
        new TabLayoutMediator(tabLayout, activityAutoBackupBinding2.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.arlosoft.macrodroid.autobackup.ui.a
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i4) {
                AutoBackupActivity.q(d.this, tab, i4);
            }
        }).attach();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(d adapter, TabLayout.Tab tab, int i4) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(adapter.a(i4));
    }

    private final void r() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_App_Dialog_AutoBackup);
        Object systemService = new ContextThemeWrapper(this, (int) R.style.Theme_App_Dialog_AutoBackup).getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
            final EditText passwordEntry = (EditText) inflate.findViewById(R.id.passwordEntry);
            final Button button = (Button) inflate.findViewById(R.id.okButton);
            Button button2 = (Button) inflate.findViewById(R.id.cancelButton);
            TextView encryptionWarning = (TextView) inflate.findViewById(R.id.exported_password_warning);
            Intrinsics.checkNotNullExpressionValue(encryptionWarning, "encryptionWarning");
            encryptionWarning.setVisibility(0);
            builder.setTitle(R.string.enter_password);
            builder.setView(inflate);
            final AlertDialog create = builder.create();
            Intrinsics.checkNotNullExpressionValue(create, "alert.create()");
            Window window = create.getWindow();
            if (window != null) {
                window.clearFlags(131080);
            }
            Window window2 = create.getWindow();
            if (window2 != null) {
                window2.setSoftInputMode(5);
            }
            create.show();
            passwordEntry.setText(Settings.getAutoBackupEncryptionPassword(this));
            Intrinsics.checkNotNullExpressionValue(passwordEntry, "passwordEntry");
            passwordEntry.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.autobackup.ui.AutoBackupActivity$showEncryptionPasswordDialog$$inlined$addTextChangedListener$default$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable editable) {
                    boolean z3;
                    Button button3 = button;
                    if (passwordEntry.getText().length() >= 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    button3.setEnabled(z3);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence charSequence, int i4, int i5, int i6) {
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AutoBackupActivity.s(AutoBackupActivity.this, passwordEntry, create, view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AutoBackupActivity.t(create, view);
                }
            });
            passwordEntry.requestFocus();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(AutoBackupActivity this$0, EditText editText, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Settings.setAutoBackupEncryptionPassword(this$0, editText.getText().toString());
        Settings.setAutoBackupEncryptionEnabled(this$0, true);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity, com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ActivityAutoBackupBinding inflate = ActivityAutoBackupBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        this.f9309f = inflate;
        ActivityAutoBackupBinding activityAutoBackupBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        ActivityAutoBackupBinding activityAutoBackupBinding2 = this.f9309f;
        if (activityAutoBackupBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityAutoBackupBinding = activityAutoBackupBinding2;
        }
        setSupportActionBar(activityAutoBackupBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setTitle(R.string.auto_backup);
        }
        p();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@NotNull Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.autobackup_top_level_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == R.id.encrypt_file) {
            item.setChecked(!item.isChecked());
            if (item.isChecked()) {
                r();
                return true;
            }
            Settings.setAutoBackupEncryptionEnabled(this, false);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(@Nullable Menu menu) {
        MenuItem menuItem;
        if (menu != null) {
            menuItem = menu.findItem(R.id.encrypt_file);
        } else {
            menuItem = null;
        }
        if (menuItem != null) {
            menuItem.setChecked(Settings.getAutoBackupEncryptionEnabled(this));
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
