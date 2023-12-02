package com.afollestad.materialdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.afollestad.materialdialogs.internal.MDRootLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DialogBase.java */
/* loaded from: classes2.dex */
public class b extends Dialog implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    protected MDRootLayout f1069a;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnShowListener f1070b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, int i4) {
        super(context, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        super.setOnShowListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(View view) {
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public View findViewById(int i4) {
        return this.f1069a.findViewById(i4);
    }

    public void onShow(DialogInterface dialogInterface) {
        DialogInterface.OnShowListener onShowListener = this.f1070b;
        if (onShowListener != null) {
            onShowListener.onShow(dialogInterface);
        }
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(int i4) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Override // android.app.Dialog
    public final void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        this.f1070b = onShowListener;
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(@NonNull View view) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }

    @Override // android.app.Dialog
    @Deprecated
    public void setContentView(@NonNull View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessError {
        throw new IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.");
    }
}
