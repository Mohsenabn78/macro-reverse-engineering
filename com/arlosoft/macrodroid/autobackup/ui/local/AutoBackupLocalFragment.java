package com.arlosoft.macrodroid.autobackup.ui.local;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseFragment;
import com.arlosoft.macrodroid.autobackup.model.BackupFile;
import com.arlosoft.macrodroid.autobackup.ui.BackupFileListAdapter;
import com.arlosoft.macrodroid.databinding.FragmentLocalBackupBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.utils.FileUtils;
import es.dmoral.toasty.Toasty;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.anko.AlertBuilder;
import org.jetbrains.anko.AndroidDialogsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AutoBackupLocalFragment.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAutoBackupLocalFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupLocalFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalFragment\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 CustomServices.kt\norg/jetbrains/anko/CustomServicesKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 5 SupportDialogs.kt\norg/jetbrains/anko/support/v4/SupportDialogsKt\n*L\n1#1,208:1\n262#2,2:209\n262#2,2:211\n262#2,2:213\n262#2,2:215\n262#2,2:237\n26#3:217\n65#4,16:218\n93#4,3:234\n49#5:239\n49#5:240\n*S KotlinDebug\n*F\n+ 1 AutoBackupLocalFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalFragment\n*L\n86#1:209,2\n87#1:211,2\n91#1:213,2\n92#1:215,2\n156#1:237,2\n110#1:217\n123#1:218,16\n123#1:234,3\n178#1:239\n185#1:240\n*E\n"})
/* loaded from: classes3.dex */
public final class AutoBackupLocalFragment extends MacroDroidDaggerBaseFragment implements AutoBackupLocalViewContract {

    /* renamed from: b  reason: collision with root package name */
    private FragmentLocalBackupBinding f9404b;

    /* renamed from: c  reason: collision with root package name */
    private SwitchCompat f9405c;
    @Inject
    public AutoBackupLocalPresenter presenter;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AutoBackupLocalFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AutoBackupLocalFragment createFragment() {
            return new AutoBackupLocalFragment();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoBackupLocalFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: a */
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
            return new a(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Settings.hideInfoCardAutoBackup(AutoBackupLocalFragment.this.requireContext());
                FragmentLocalBackupBinding fragmentLocalBackupBinding = AutoBackupLocalFragment.this.f9404b;
                if (fragmentLocalBackupBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentLocalBackupBinding = null;
                }
                fragmentLocalBackupBinding.infoCard.infoCardView.setVisibility(8);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: AutoBackupLocalFragment.kt */
    @SourceDebugExtension({"SMAP\nAutoBackupLocalFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupLocalFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalFragment$showDeleteAllDialog$1\n+ 2 AlertBuilder.kt\norg/jetbrains/anko/AlertBuilderKt\n*L\n1#1,208:1\n99#2:209\n102#2:210\n*S KotlinDebug\n*F\n+ 1 AutoBackupLocalFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalFragment$showDeleteAllDialog$1\n*L\n179#1:209\n180#1:210\n*E\n"})
    /* loaded from: classes3.dex */
    static final class b extends Lambda implements Function1<AlertBuilder<? extends DialogInterface>, Unit> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupLocalFragment.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<DialogInterface, Unit> {
            final /* synthetic */ AutoBackupLocalFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AutoBackupLocalFragment autoBackupLocalFragment) {
                super(1);
                this.this$0 = autoBackupLocalFragment;
            }

            public final void a(@NotNull DialogInterface it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getPresenter().deleteAllBackups();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                a(dialogInterface);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupLocalFragment.kt */
        /* renamed from: com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalFragment$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0091b extends Lambda implements Function1<DialogInterface, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final C0091b f9408d = new C0091b();

            C0091b() {
                super(1);
            }

            public final void a(@NotNull DialogInterface it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                a(dialogInterface);
                return Unit.INSTANCE;
            }
        }

        b() {
            super(1);
        }

        public final void a(@NotNull AlertBuilder<? extends DialogInterface> alert) {
            Intrinsics.checkNotNullParameter(alert, "$this$alert");
            alert.positiveButton(17039379, new a(AutoBackupLocalFragment.this));
            alert.negativeButton(17039369, C0091b.f9408d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AlertBuilder<? extends DialogInterface> alertBuilder) {
            a(alertBuilder);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: AutoBackupLocalFragment.kt */
    @SourceDebugExtension({"SMAP\nAutoBackupLocalFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutoBackupLocalFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalFragment$showDeleteDialog$1\n+ 2 AlertBuilder.kt\norg/jetbrains/anko/AlertBuilderKt\n*L\n1#1,208:1\n99#2:209\n102#2:210\n*S KotlinDebug\n*F\n+ 1 AutoBackupLocalFragment.kt\ncom/arlosoft/macrodroid/autobackup/ui/local/AutoBackupLocalFragment$showDeleteDialog$1\n*L\n186#1:209\n187#1:210\n*E\n"})
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements Function1<AlertBuilder<? extends DialogInterface>, Unit> {
        final /* synthetic */ BackupFile $backupFile;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupLocalFragment.kt */
        /* loaded from: classes3.dex */
        public static final class a extends Lambda implements Function1<DialogInterface, Unit> {
            final /* synthetic */ BackupFile $backupFile;
            final /* synthetic */ AutoBackupLocalFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AutoBackupLocalFragment autoBackupLocalFragment, BackupFile backupFile) {
                super(1);
                this.this$0 = autoBackupLocalFragment;
                this.$backupFile = backupFile;
            }

            public final void a(@NotNull DialogInterface it) {
                Intrinsics.checkNotNullParameter(it, "it");
                this.this$0.getPresenter().deleteBackup(this.$backupFile);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                a(dialogInterface);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AutoBackupLocalFragment.kt */
        /* loaded from: classes3.dex */
        public static final class b extends Lambda implements Function1<DialogInterface, Unit> {

            /* renamed from: d  reason: collision with root package name */
            public static final b f9409d = new b();

            b() {
                super(1);
            }

            public final void a(@NotNull DialogInterface it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface) {
                a(dialogInterface);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(BackupFile backupFile) {
            super(1);
            this.$backupFile = backupFile;
        }

        public final void a(@NotNull AlertBuilder<? extends DialogInterface> alert) {
            Intrinsics.checkNotNullParameter(alert, "$this$alert");
            alert.positiveButton(17039379, new a(AutoBackupLocalFragment.this, this.$backupFile));
            alert.negativeButton(17039369, b.f9409d);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AlertBuilder<? extends DialogInterface> alertBuilder) {
            a(alertBuilder);
            return Unit.INSTANCE;
        }
    }

    private final void h() {
        FragmentLocalBackupBinding fragmentLocalBackupBinding = null;
        if (Settings.shouldHideInfoAutoBackup(requireContext())) {
            FragmentLocalBackupBinding fragmentLocalBackupBinding2 = this.f9404b;
            if (fragmentLocalBackupBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentLocalBackupBinding = fragmentLocalBackupBinding2;
            }
            fragmentLocalBackupBinding.infoCard.infoCardView.setVisibility(8);
            return;
        }
        FragmentLocalBackupBinding fragmentLocalBackupBinding3 = this.f9404b;
        if (fragmentLocalBackupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLocalBackupBinding3 = null;
        }
        fragmentLocalBackupBinding3.infoCard.infoCardView.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.auto_backup_primary));
        FragmentLocalBackupBinding fragmentLocalBackupBinding4 = this.f9404b;
        if (fragmentLocalBackupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLocalBackupBinding4 = null;
        }
        fragmentLocalBackupBinding4.infoCard.infoCardTitle.setText(getString(R.string.local_backup));
        try {
            FragmentLocalBackupBinding fragmentLocalBackupBinding5 = this.f9404b;
            if (fragmentLocalBackupBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentLocalBackupBinding5 = null;
            }
            TextView textView = fragmentLocalBackupBinding5.infoCard.infoCardDetail;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.auto_backup_info_card);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.auto_backup_info_card)");
            String format = String.format(string, Arrays.copyOf(new Object[]{14}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
        } catch (Exception unused) {
            FragmentLocalBackupBinding fragmentLocalBackupBinding6 = this.f9404b;
            if (fragmentLocalBackupBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentLocalBackupBinding6 = null;
            }
            fragmentLocalBackupBinding6.infoCard.infoCardDetail.setText(getString(R.string.auto_backup_info_card));
        }
        FragmentLocalBackupBinding fragmentLocalBackupBinding7 = this.f9404b;
        if (fragmentLocalBackupBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLocalBackupBinding7 = null;
        }
        Button button = fragmentLocalBackupBinding7.infoCard.infoCardGotIt;
        Intrinsics.checkNotNullExpressionValue(button, "binding.infoCard.infoCardGotIt");
        ViewExtensionsKt.onClick$default(button, null, new a(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(AutoBackupLocalFragment this$0, CompoundButton compoundButton, boolean z3) {
        int i4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getPresenter().onAutoBackupEnableStateChange(z3);
        Context requireContext = this$0.requireContext();
        String string = this$0.getString(R.string.local_backup);
        if (z3) {
            i4 = R.string.enabled;
        } else {
            i4 = R.string.disabled;
        }
        String string2 = this$0.getString(i4);
        ToastCompat.makeText(requireContext, (CharSequence) (string + " - " + string2), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(AutoBackupLocalFragment this$0, BackupFile backupFile, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(backupFile, "$backupFile");
        this$0.getPresenter().restoreBackup(backupFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AutoBackupLocalFragment this$0, BackupFile backupFile, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(backupFile, "$backupFile");
        this$0.getPresenter().shareBackup(backupFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(AutoBackupLocalFragment this$0, BackupFile backupFile, EditText editText, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(backupFile, "$backupFile");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.getPresenter().decryptAndRestore(backupFile, editText.getText().toString());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AutoBackupLocalFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showRestoringState(false);
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void finishBackupScreen() {
        requireActivity().finish();
    }

    @NotNull
    public final AutoBackupLocalPresenter getPresenter() {
        AutoBackupLocalPresenter autoBackupLocalPresenter = this.presenter;
        if (autoBackupLocalPresenter != null) {
            return autoBackupLocalPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("presenter");
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        inflater.inflate(R.menu.autobackup_menu, menu);
        View actionView = menu.findItem(R.id.switch_enabled).getActionView();
        Intrinsics.checkNotNull(actionView, "null cannot be cast to non-null type androidx.appcompat.widget.SwitchCompat");
        SwitchCompat switchCompat = (SwitchCompat) actionView;
        this.f9405c = switchCompat;
        SwitchCompat switchCompat2 = null;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enabledSwitch");
            switchCompat = null;
        }
        switchCompat.setChecked(Settings.getAutoBackupsEnabled(requireContext()));
        SwitchCompat switchCompat3 = this.f9405c;
        if (switchCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("enabledSwitch");
        } else {
            switchCompat2 = switchCompat3;
        }
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.f
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                AutoBackupLocalFragment.i(AutoBackupLocalFragment.this, compoundButton, z3);
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentLocalBackupBinding inflate = FragmentLocalBackupBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.f9404b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        return inflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        int itemId = item.getItemId();
        if (itemId != R.id.backup_now) {
            if (itemId == R.id.delete_all_backups) {
                getPresenter().onDeleteAllSelected();
            }
        } else {
            getPresenter().onBackupNowSelected();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        h();
        getPresenter().takeView(this);
    }

    public final void setPresenter(@NotNull AutoBackupLocalPresenter autoBackupLocalPresenter) {
        Intrinsics.checkNotNullParameter(autoBackupLocalPresenter, "<set-?>");
        this.presenter = autoBackupLocalPresenter;
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void shareBackup(@NotNull BackupFile backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(268435456);
            intent.setType("text/plain");
            FileUtils.addFileStreamToIntent(requireContext(), intent, backupFile.getFile());
            startActivity(Intent.createChooser(intent, getString(R.string.share_file)));
        } catch (Exception e4) {
            ToastCompat.makeText(requireContext(), (int) R.string.export_failed, 0).show();
            SystemLog.logError("Failed to export file: " + e4);
        }
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showBackupDialog(@NotNull final BackupFile backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle(backupFile.getFile().getName());
        builder.setMessage(R.string.restore_backup_dialog_text);
        builder.setPositiveButton(R.string.restore_backup, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AutoBackupLocalFragment.j(AutoBackupLocalFragment.this, backupFile, dialogInterface, i4);
            }
        });
        builder.setNeutralButton(R.string.share_file, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                AutoBackupLocalFragment.k(AutoBackupLocalFragment.this, backupFile, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showBackupFiles(@NotNull List<BackupFile> backupFiles) {
        Intrinsics.checkNotNullParameter(backupFiles, "backupFiles");
        FragmentLocalBackupBinding fragmentLocalBackupBinding = this.f9404b;
        FragmentLocalBackupBinding fragmentLocalBackupBinding2 = null;
        if (fragmentLocalBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLocalBackupBinding = null;
        }
        RecyclerView recyclerView = fragmentLocalBackupBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(0);
        FragmentLocalBackupBinding fragmentLocalBackupBinding3 = this.f9404b;
        if (fragmentLocalBackupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLocalBackupBinding3 = null;
        }
        FrameLayout frameLayout = fragmentLocalBackupBinding3.emptyView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.emptyView");
        frameLayout.setVisibility(8);
        BackupFileListAdapter backupFileListAdapter = new BackupFileListAdapter(backupFiles, getPresenter());
        FragmentLocalBackupBinding fragmentLocalBackupBinding4 = this.f9404b;
        if (fragmentLocalBackupBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentLocalBackupBinding2 = fragmentLocalBackupBinding4;
        }
        fragmentLocalBackupBinding2.recyclerView.setAdapter(backupFileListAdapter);
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showBackupRestoreFailed() {
        Context context = getContext();
        if (context != null) {
            Toasty.Config.getInstance().setTextColor(-1).tintIcon(false).apply();
            Toasty.custom(context, (CharSequence) getString(R.string.backup_file_restore_failed), (Drawable) null, ContextCompat.getColor(requireContext(), R.color.md_red_600), 1, false, true).show();
        }
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showBackupRestored() {
        Context context = getContext();
        if (context != null) {
            Toasty.Config.getInstance().setTextColor(-1).tintIcon(false).apply();
            Toasty.custom(context, (CharSequence) getString(R.string.backup_file_restored), (Drawable) null, ContextCompat.getColor(requireContext(), R.color.md_green_600), 1, false, true).show();
        }
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showDeleteAllDialog() {
        String string = getString(R.string.are_you_sure);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.are_you_sure)");
        String string2 = getString(R.string.delete_all_backups);
        b bVar = new b();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AndroidDialogsKt.alert(requireActivity, string, string2, bVar).show();
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showDeleteDialog(@NotNull BackupFile backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        String str = getString(R.string.confirm_backup_delete) + "\n\n" + backupFile.getFile().getName();
        String string = getString(R.string.delete);
        c cVar = new c(backupFile);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
        AndroidDialogsKt.alert(requireActivity, str, string, cVar).show();
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showEmptyBackupFiles() {
        FragmentLocalBackupBinding fragmentLocalBackupBinding = this.f9404b;
        FragmentLocalBackupBinding fragmentLocalBackupBinding2 = null;
        if (fragmentLocalBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLocalBackupBinding = null;
        }
        RecyclerView recyclerView = fragmentLocalBackupBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setVisibility(8);
        FragmentLocalBackupBinding fragmentLocalBackupBinding3 = this.f9404b;
        if (fragmentLocalBackupBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentLocalBackupBinding2 = fragmentLocalBackupBinding3;
        }
        FrameLayout frameLayout = fragmentLocalBackupBinding2.emptyView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.emptyView");
        frameLayout.setVisibility(0);
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showPasswordDialog(@NotNull final BackupFile backupFile) {
        Intrinsics.checkNotNullParameter(backupFile, "backupFile");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        Object systemService = new ContextThemeWrapper(requireActivity(), (int) R.style.Theme_App_Dialog_AutoBackup).getSystemService("layout_inflater");
        if (systemService != null) {
            View inflate = ((LayoutInflater) systemService).inflate(R.layout.dialog_password_prompt, (ViewGroup) null);
            final EditText passwordEntry = (EditText) inflate.findViewById(R.id.passwordEntry);
            final Button button = (Button) inflate.findViewById(R.id.okButton);
            Button button2 = (Button) inflate.findViewById(R.id.cancelButton);
            builder.setTitle(R.string.enter_password);
            builder.setView(inflate);
            final androidx.appcompat.app.AlertDialog create = builder.create();
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
            passwordEntry.setText(Settings.getAutoBackupEncryptionPassword(requireContext()));
            Intrinsics.checkNotNullExpressionValue(passwordEntry, "passwordEntry");
            passwordEntry.addTextChangedListener(new TextWatcher() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalFragment$showPasswordDialog$$inlined$addTextChangedListener$default$1
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
            button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AutoBackupLocalFragment.l(AutoBackupLocalFragment.this, backupFile, passwordEntry, create, view);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AutoBackupLocalFragment.m(create, view);
                }
            });
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.autobackup.ui.local.e
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    AutoBackupLocalFragment.n(AutoBackupLocalFragment.this, dialogInterface);
                }
            });
            passwordEntry.requestFocus();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @Override // com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalViewContract
    public void showRestoringState(boolean z3) {
        int i4;
        FragmentLocalBackupBinding fragmentLocalBackupBinding = this.f9404b;
        if (fragmentLocalBackupBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentLocalBackupBinding = null;
        }
        FrameLayout frameLayout = fragmentLocalBackupBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.loadingView");
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        frameLayout.setVisibility(i4);
    }
}
