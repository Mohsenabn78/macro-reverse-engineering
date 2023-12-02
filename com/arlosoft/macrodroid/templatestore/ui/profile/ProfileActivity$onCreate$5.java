package com.arlosoft.macrodroid.templatestore.ui.profile;

import android.content.DialogInterface;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileActivity.kt */
/* loaded from: classes3.dex */
public final class ProfileActivity$onCreate$5 extends OnBackPressedCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ProfileActivity f13809a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileActivity$onCreate$5(ProfileActivity profileActivity) {
        super(true);
        this.f13809a = profileActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ProfileActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ProfileActivity this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        boolean x3;
        boolean z3;
        x3 = this.f13809a.x();
        if (!x3) {
            z3 = this.f13809a.f13804f;
            if (z3) {
                this.f13809a.getPresenter().signOut();
                return;
            } else {
                this.f13809a.finish();
                return;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f13809a, R.style.Theme_App_Dialog_Template);
        builder.setTitle(R.string.save_changes);
        builder.setMessage(R.string.do_you_wish_to_save_changes_generic);
        final ProfileActivity profileActivity = this.f13809a;
        builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ProfileActivity$onCreate$5.c(ProfileActivity.this, dialogInterface, i4);
            }
        });
        final ProfileActivity profileActivity2 = this.f13809a;
        builder.setNegativeButton(R.string.discard, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.templatestore.ui.profile.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                ProfileActivity$onCreate$5.d(ProfileActivity.this, dialogInterface, i4);
            }
        });
        builder.show();
    }
}
