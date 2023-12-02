package com.obsez.android.lib.filechooser;

import androidx.appcompat.app.AlertDialog;
import com.obsez.android.lib.filechooser.ChooserDialog;
import java.lang.ref.WeakReference;

/* compiled from: defBackPressed.java */
/* loaded from: classes6.dex */
class b implements ChooserDialog.OnBackPressedListener {

    /* renamed from: d  reason: collision with root package name */
    private static final ChooserDialog.OnBackPressedListener f36516d = new ChooserDialog.OnBackPressedListener() { // from class: i1.j
        @Override // com.obsez.android.lib.filechooser.ChooserDialog.OnBackPressedListener
        public final void onBackPressed(AlertDialog alertDialog) {
            alertDialog.cancel();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final ChooserDialog.OnBackPressedListener f36517e = new ChooserDialog.OnBackPressedListener() { // from class: i1.j
        @Override // com.obsez.android.lib.filechooser.ChooserDialog.OnBackPressedListener
        public final void onBackPressed(AlertDialog alertDialog) {
            alertDialog.cancel();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<ChooserDialog> f36518a;

    /* renamed from: b  reason: collision with root package name */
    ChooserDialog.OnBackPressedListener f36519b;

    /* renamed from: c  reason: collision with root package name */
    ChooserDialog.OnBackPressedListener f36520c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ChooserDialog chooserDialog) {
        this.f36518a = new WeakReference<>(chooserDialog);
    }

    @Override // com.obsez.android.lib.filechooser.ChooserDialog.OnBackPressedListener
    public void onBackPressed(AlertDialog alertDialog) {
        if (this.f36518a.get().f36486g.size() > 0 && this.f36518a.get().f36486g.get(0).getName().equals("..")) {
            ChooserDialog.OnBackPressedListener onBackPressedListener = this.f36519b;
            if (onBackPressedListener != null) {
                onBackPressedListener.onBackPressed(alertDialog);
                return;
            } else {
                f36517e.onBackPressed(alertDialog);
                return;
            }
        }
        ChooserDialog.OnBackPressedListener onBackPressedListener2 = this.f36520c;
        if (onBackPressedListener2 != null) {
            onBackPressedListener2.onBackPressed(alertDialog);
        } else {
            f36516d.onBackPressed(alertDialog);
        }
    }
}
