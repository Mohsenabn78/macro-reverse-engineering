package com.arlosoft.macrodroid.action.activities;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.arlosoft.macrodroid.R;

/* loaded from: classes2.dex */
public class OptionDialogActivity_ViewBinding implements Unbinder {

    /* renamed from: a  reason: collision with root package name */
    private OptionDialogActivity f2904a;

    @UiThread
    public OptionDialogActivity_ViewBinding(OptionDialogActivity optionDialogActivity) {
        this(optionDialogActivity, optionDialogActivity.getWindow().getDecorView());
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void unbind() {
        OptionDialogActivity optionDialogActivity = this.f2904a;
        if (optionDialogActivity != null) {
            this.f2904a = null;
            optionDialogActivity.button1 = null;
            optionDialogActivity.button2 = null;
            optionDialogActivity.button3 = null;
            optionDialogActivity.messageView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    @UiThread
    public OptionDialogActivity_ViewBinding(OptionDialogActivity optionDialogActivity, View view) {
        this.f2904a = optionDialogActivity;
        optionDialogActivity.button1 = (Button) Utils.findRequiredViewAsType(view, R.id.button_1, "field 'button1'", Button.class);
        optionDialogActivity.button2 = (Button) Utils.findRequiredViewAsType(view, R.id.button_2, "field 'button2'", Button.class);
        optionDialogActivity.button3 = (Button) Utils.findRequiredViewAsType(view, R.id.button_3, "field 'button3'", Button.class);
        optionDialogActivity.messageView = (TextView) Utils.findRequiredViewAsType(view, R.id.option_dialog_message, "field 'messageView'", TextView.class);
    }
}
