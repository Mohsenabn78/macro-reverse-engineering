package com.obsez.android.lib.filechooser;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import java.lang.ref.WeakReference;

/* compiled from: keyListener.java */
/* loaded from: classes6.dex */
class c implements DialogInterface.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<ChooserDialog> f36521a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ChooserDialog chooserDialog) {
        this.f36521a = new WeakReference<>(chooserDialog);
    }

    protected void finalize() throws Throwable {
        this.f36521a.clear();
        this.f36521a = null;
        super.finalize();
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i4, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        if (i4 != 4 && i4 != 111) {
            if (!this.f36521a.get().f36477b0) {
                return true;
            }
            if (!this.f36521a.get().f36496l.hasFocus()) {
                if (i4 != 19 || this.f36521a.get().f36479c0 == null) {
                    return false;
                }
                if (!this.f36521a.get().f36479c0.hasFocus() && !this.f36521a.get().f36481d0.hasFocus() && !this.f36521a.get().f36483e0.hasFocus()) {
                    if (this.f36521a.get().I != null && this.f36521a.get().I.hasFocus()) {
                        this.f36521a.get().f36496l.requestFocus();
                        this.f36521a.get().f36484f = true;
                        return true;
                    }
                } else {
                    int i5 = 17;
                    if (this.f36521a.get().I != null && this.f36521a.get().I.getVisibility() == 0) {
                        View view = this.f36521a.get().I;
                        if (this.f36521a.get().f36479c0.hasFocus()) {
                            i5 = 66;
                        }
                        view.requestFocus(i5);
                        return true;
                    } else if (this.f36521a.get().X != null && this.f36521a.get().X.getVisibility() == 0) {
                        this.f36521a.get().X.requestFocus(17);
                        return true;
                    } else {
                        this.f36521a.get().f36496l.requestFocus();
                        this.f36521a.get().f36484f = true;
                        return true;
                    }
                }
            }
            if (this.f36521a.get().f36496l.hasFocus()) {
                switch (i4) {
                    case 20:
                        if (this.f36521a.get().f36484f) {
                            this.f36521a.get().f36484f = false;
                            if (this.f36521a.get().I != null && this.f36521a.get().I.getVisibility() == 0) {
                                this.f36521a.get().I.requestFocus();
                            } else if (this.f36521a.get().f36479c0.getVisibility() == 0) {
                                this.f36521a.get().f36479c0.requestFocus();
                            } else {
                                this.f36521a.get().f36481d0.requestFocus();
                            }
                            return true;
                        }
                        break;
                    case 21:
                        this.f36521a.get().f36491i0.onBackPressed(this.f36521a.get().f36494k);
                        this.f36521a.get().f36484f = false;
                        return true;
                    case 22:
                        this.f36521a.get().f36496l.performItemClick(this.f36521a.get().f36496l, this.f36521a.get().f36496l.getSelectedItemPosition(), this.f36521a.get().f36496l.getSelectedItemId());
                        this.f36521a.get().f36484f = false;
                        return true;
                    default:
                        return false;
                }
            }
            return false;
        } else if (this.f36521a.get().X != null && this.f36521a.get().X.getVisibility() == 0) {
            this.f36521a.get().X.setVisibility(8);
            return true;
        } else {
            this.f36521a.get().f36491i0.onBackPressed(this.f36521a.get().f36494k);
            return true;
        }
    }
}
