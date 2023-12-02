package com.afollestad.materialdialogs.folderselector;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class FolderChooserDialog extends DialogFragment implements MaterialDialog.ListCallback {

    /* renamed from: b  reason: collision with root package name */
    private File f1114b;

    /* renamed from: c  reason: collision with root package name */
    private File[] f1115c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1116d = false;

    /* renamed from: e  reason: collision with root package name */
    private FolderCallback f1117e;

    /* loaded from: classes2.dex */
    public interface FolderCallback {
        void onFolderChooserDismissed(@NonNull FolderChooserDialog folderChooserDialog);

        void onFolderSelection(@NonNull FolderChooserDialog folderChooserDialog, @NonNull File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements MaterialDialog.SingleButtonCallback {
        a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            materialDialog.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    class b implements MaterialDialog.SingleButtonCallback {
        b() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            materialDialog.dismiss();
            FolderCallback folderCallback = FolderChooserDialog.this.f1117e;
            FolderChooserDialog folderChooserDialog = FolderChooserDialog.this;
            folderCallback.onFolderSelection(folderChooserDialog, folderChooserDialog.f1114b);
        }
    }

    /* loaded from: classes2.dex */
    class c implements MaterialDialog.SingleButtonCallback {
        c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
        public void onClick(@NonNull MaterialDialog materialDialog, @NonNull DialogAction dialogAction) {
            FolderChooserDialog.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements MaterialDialog.InputCallback {
        d() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.InputCallback
        public void onInput(@NonNull MaterialDialog materialDialog, CharSequence charSequence) {
            File file = new File(FolderChooserDialog.this.f1114b, charSequence.toString());
            if (file.mkdir()) {
                FolderChooserDialog.this.k();
                return;
            }
            Toast.makeText(FolderChooserDialog.this.getActivity(), "Unable to create folder " + file.getAbsolutePath() + ", make sure you have the WRITE_EXTERNAL_STORAGE permission or root permissions.", 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class e implements Comparator<File> {
        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    private void f() {
        try {
            boolean z3 = true;
            if (this.f1114b.getPath().split(RemoteSettings.FORWARD_SLASH_STRING).length <= 1) {
                z3 = false;
            }
            this.f1116d = z3;
        } catch (IndexOutOfBoundsException unused) {
            this.f1116d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        new MaterialDialog.Builder(getActivity()).title(h().newFolderButton).input(0, 0, false, (MaterialDialog.InputCallback) new d()).show();
    }

    @NonNull
    private Builder h() {
        return (Builder) getArguments().getSerializable("builder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f1115c = j();
        MaterialDialog materialDialog = (MaterialDialog) getDialog();
        materialDialog.setTitle(this.f1114b.getAbsolutePath());
        getArguments().putString("current_path", this.f1114b.getAbsolutePath());
        materialDialog.setItems(i());
    }

    String[] i() {
        int i4;
        File[] fileArr = this.f1115c;
        int i5 = 0;
        if (fileArr == null) {
            return this.f1116d ? new String[]{h().goUpLabel} : new String[0];
        }
        int length = fileArr.length;
        boolean z3 = this.f1116d;
        String[] strArr = new String[length + (z3 ? 1 : 0)];
        if (z3) {
            strArr[0] = h().goUpLabel;
        }
        while (true) {
            File[] fileArr2 = this.f1115c;
            if (i5 < fileArr2.length) {
                if (this.f1116d) {
                    i4 = i5 + 1;
                } else {
                    i4 = i5;
                }
                strArr[i4] = fileArr2[i5].getName();
                i5++;
            } else {
                return strArr;
            }
        }
    }

    File[] j() {
        File[] listFiles = this.f1114b.listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles == null) {
            return null;
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new e(null));
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FolderCallback) {
            this.f1117e = (FolderCallback) getActivity();
        } else if (getParentFragment() instanceof FolderCallback) {
            this.f1117e = (FolderCallback) getParentFragment();
        } else {
            throw new IllegalStateException("FolderChooserDialog needs to be shown from an Activity/Fragment implementing FolderCallback.");
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(getActivity(), "android.permission.READ_EXTERNAL_STORAGE") != 0) {
            return new MaterialDialog.Builder(getActivity()).title(R.string.md_error_label).content(R.string.md_storage_perm_error).positiveText(17039370).build();
        }
        if (getArguments() != null && getArguments().containsKey("builder")) {
            if (!getArguments().containsKey("current_path")) {
                getArguments().putString("current_path", h().initialPath);
            }
            this.f1114b = new File(getArguments().getString("current_path"));
            f();
            this.f1115c = j();
            MaterialDialog.Builder negativeText = new MaterialDialog.Builder(getActivity()).typeface(h().mediumFont, h().regularFont).title(this.f1114b.getAbsolutePath()).items(i()).itemsCallback(this).onPositive(new b()).onNegative(new a()).autoDismiss(false).positiveText(h().chooseButton).negativeText(h().cancelButton);
            if (h().allowNewFolder) {
                negativeText.neutralText(h().newFolderButton);
                negativeText.onNeutral(new c());
            }
            if (RemoteSettings.FORWARD_SLASH_STRING.equals(h().initialPath)) {
                this.f1116d = false;
            }
            return negativeText.build();
        }
        throw new IllegalStateException("You must create a FolderChooserDialog using the Builder.");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        FolderCallback folderCallback = this.f1117e;
        if (folderCallback != null) {
            folderCallback.onFolderChooserDismissed(this);
        }
    }

    @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
    public void onSelection(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence) {
        boolean z3 = this.f1116d;
        boolean z4 = true;
        if (z3 && i4 == 0) {
            File parentFile = this.f1114b.getParentFile();
            this.f1114b = parentFile;
            if (parentFile.getAbsolutePath().equals("/storage/emulated")) {
                this.f1114b = this.f1114b.getParentFile();
            }
            if (this.f1114b.getParent() == null) {
                z4 = false;
            }
            this.f1116d = z4;
        } else {
            File[] fileArr = this.f1115c;
            if (z3) {
                i4--;
            }
            File file = fileArr[i4];
            this.f1114b = file;
            this.f1116d = true;
            if (file.getAbsolutePath().equals("/storage/emulated")) {
                this.f1114b = Environment.getExternalStorageDirectory();
            }
        }
        k();
    }

    public void show(FragmentActivity fragmentActivity) {
        show(fragmentActivity.getSupportFragmentManager());
    }

    /* loaded from: classes2.dex */
    public static class Builder implements Serializable {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final transient Context f1118a;
        boolean allowNewFolder;
        @Nullable
        String mediumFont;
        @StringRes
        int newFolderButton;
        @Nullable
        String regularFont;
        String tag;
        @StringRes
        int chooseButton = R.string.md_choose_label;
        @StringRes
        int cancelButton = 17039360;
        String goUpLabel = "...";
        String initialPath = Environment.getExternalStorageDirectory().getAbsolutePath();

        public Builder(@NonNull Context context) {
            this.f1118a = context;
        }

        @NonNull
        public Builder allowNewFolder(boolean z3, @StringRes int i4) {
            this.allowNewFolder = z3;
            if (i4 == 0) {
                i4 = R.string.new_folder;
            }
            this.newFolderButton = i4;
            return this;
        }

        @NonNull
        public FolderChooserDialog build() {
            FolderChooserDialog folderChooserDialog = new FolderChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            folderChooserDialog.setArguments(bundle);
            return folderChooserDialog;
        }

        @NonNull
        public Builder cancelButton(@StringRes int i4) {
            this.cancelButton = i4;
            return this;
        }

        @NonNull
        public Builder chooseButton(@StringRes int i4) {
            this.chooseButton = i4;
            return this;
        }

        @NonNull
        public Builder goUpLabel(String str) {
            this.goUpLabel = str;
            return this;
        }

        @NonNull
        public Builder initialPath(@Nullable String str) {
            if (str == null) {
                str = File.separator;
            }
            this.initialPath = str;
            return this;
        }

        @NonNull
        public FolderChooserDialog show(FragmentManager fragmentManager) {
            FolderChooserDialog build = build();
            build.show(fragmentManager);
            return build;
        }

        @NonNull
        public Builder tag(@Nullable String str) {
            if (str == null) {
                str = "[MD_FOLDER_SELECTOR]";
            }
            this.tag = str;
            return this;
        }

        @NonNull
        public Builder typeface(@Nullable String str, @Nullable String str2) {
            this.mediumFont = str;
            this.regularFont = str2;
            return this;
        }

        @NonNull
        public FolderChooserDialog show(FragmentActivity fragmentActivity) {
            return show(fragmentActivity.getSupportFragmentManager());
        }
    }

    public void show(FragmentManager fragmentManager) {
        String str = h().tag;
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            ((DialogFragment) findFragmentByTag).dismiss();
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
        }
        show(fragmentManager, str);
    }
}
