package com.arlosoft.macrodroid.editscreen;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.selectableitemlist.AddTriggerActivity;
import com.arlosoft.macrodroid.settings.Settings;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditMacroActivity.kt */
/* loaded from: classes3.dex */
public final class EditMacroActivity$triggerHeaderCallback$1 implements HeaderCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditMacroActivity f11775a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EditMacroActivity$triggerHeaderCallback$1(EditMacroActivity editMacroActivity) {
        this.f11775a = editMacroActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(EditMacroActivity this$0, Intent myStarterIntent, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(myStarterIntent, "$myStarterIntent");
        this$0.startActivityForResult(myStarterIntent, 909091);
    }

    @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
    public void onAdd() {
        final Intent intent = new Intent(this.f11775a, AddTriggerActivity.class);
        Macro macro = this.f11775a.f11735f;
        Macro macro2 = null;
        if (macro == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
            macro = null;
        }
        intent.putExtra("MacroId", macro.getId());
        Macro macro3 = this.f11775a.f11735f;
        if (macro3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("macro");
        } else {
            macro2 = macro3;
        }
        if (macro2.getTriggerList().size() > 0 && !Settings.hasShownMultiTriggerWarning(this.f11775a)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f11775a, R.style.Theme_App_Dialog);
            builder.setTitle(R.string.multiple_triggers);
            AlertDialog.Builder cancelable = builder.setMessage(R.string.multiple_trigger_info).setCancelable(true);
            final EditMacroActivity editMacroActivity = this.f11775a;
            cancelable.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.editscreen.q0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    EditMacroActivity$triggerHeaderCallback$1.b(EditMacroActivity.this, intent, dialogInterface, i4);
                }
            });
            builder.show();
            Settings.setShownMultiTriggerWarning(this.f11775a, true);
            return;
        }
        this.f11775a.startActivityForResult(intent, 909091);
    }

    @Override // com.arlosoft.macrodroid.editscreen.HeaderCallback
    public void onPaste() {
        this.f11775a.y0();
    }
}
