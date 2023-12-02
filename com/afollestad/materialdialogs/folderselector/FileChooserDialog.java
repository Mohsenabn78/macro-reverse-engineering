package com.afollestad.materialdialogs.folderselector;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.MimeTypeMap;
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
public class FileChooserDialog extends DialogFragment implements MaterialDialog.ListCallback {

    /* renamed from: b  reason: collision with root package name */
    private File f1108b;

    /* renamed from: c  reason: collision with root package name */
    private File[] f1109c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1110d = true;

    /* renamed from: e  reason: collision with root package name */
    private FileCallback f1111e;

    /* loaded from: classes2.dex */
    public interface FileCallback {
        void onFileChooserDismissed(@NonNull FileChooserDialog fileChooserDialog);

        void onFileSelection(@NonNull FileChooserDialog fileChooserDialog, @NonNull File file);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Comparator<File> {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file.isDirectory() && !file2.isDirectory()) {
                return -1;
            }
            if (!file.isDirectory() && file2.isDirectory()) {
                return 1;
            }
            return file.getName().compareTo(file2.getName());
        }
    }

    private void b() {
        try {
            boolean z3 = true;
            if (this.f1108b.getPath().split(RemoteSettings.FORWARD_SLASH_STRING).length <= 1) {
                z3 = false;
            }
            this.f1110d = z3;
        } catch (IndexOutOfBoundsException unused) {
            this.f1110d = false;
        }
    }

    @NonNull
    private Builder d() {
        return (Builder) getArguments().getSerializable("builder");
    }

    boolean c(File file, String str, MimeTypeMap mimeTypeMap) {
        int lastIndexOf;
        if (str == null || str.equals("*/*")) {
            return true;
        }
        String uri = file.toURI().toString();
        int lastIndexOf2 = uri.lastIndexOf(46);
        if (lastIndexOf2 == -1) {
            return false;
        }
        String substring = uri.substring(lastIndexOf2 + 1);
        if (substring.endsWith("json")) {
            return str.startsWith("application/json");
        }
        String mimeTypeFromExtension = mimeTypeMap.getMimeTypeFromExtension(substring);
        if (mimeTypeFromExtension == null) {
            return false;
        }
        if (mimeTypeFromExtension.equals(str)) {
            return true;
        }
        int lastIndexOf3 = str.lastIndexOf(47);
        if (lastIndexOf3 == -1) {
            return false;
        }
        String substring2 = str.substring(0, lastIndexOf3);
        if (str.substring(lastIndexOf3 + 1).equals("*") && (lastIndexOf = mimeTypeFromExtension.lastIndexOf(47)) != -1 && mimeTypeFromExtension.substring(0, lastIndexOf).equals(substring2)) {
            return true;
        }
        return false;
    }

    CharSequence[] e() {
        int i4;
        File[] fileArr = this.f1109c;
        int i5 = 0;
        if (fileArr == null) {
            return this.f1110d ? new String[]{d().goUpLabel} : new String[0];
        }
        int length = fileArr.length;
        boolean z3 = this.f1110d;
        String[] strArr = new String[length + (z3 ? 1 : 0)];
        if (z3) {
            strArr[0] = d().goUpLabel;
        }
        while (true) {
            File[] fileArr2 = this.f1109c;
            if (i5 < fileArr2.length) {
                if (this.f1110d) {
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

    File[] f(@Nullable String str, @Nullable String[] strArr) {
        boolean z3;
        File[] listFiles = this.f1108b.listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles == null) {
            return null;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                arrayList.add(file);
            } else if (strArr != null) {
                int length = strArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 < length) {
                        if (file.getName().toLowerCase().endsWith(strArr[i4].toLowerCase())) {
                            z3 = true;
                            break;
                        }
                        i4++;
                    } else {
                        z3 = false;
                        break;
                    }
                }
                if (z3) {
                    arrayList.add(file);
                }
            } else if (str != null && c(file, str, singleton)) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new b(null));
        return (File[]) arrayList.toArray(new File[arrayList.size()]);
    }

    @NonNull
    public String getInitialPath() {
        return d().initialPath;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof FileCallback) {
            this.f1111e = (FileCallback) getActivity();
        } else if (getParentFragment() instanceof FileCallback) {
            this.f1111e = (FileCallback) getParentFragment();
        } else {
            throw new IllegalStateException("FileChooserDialog needs to be shown from an Activity/Fragment implementing FileCallback.");
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
                getArguments().putString("current_path", d().initialPath);
            }
            this.f1108b = new File(getArguments().getString("current_path"));
            b();
            this.f1109c = f(d().mimeType, d().extensions);
            return new MaterialDialog.Builder(getActivity()).title(this.f1108b.getAbsolutePath()).typeface(d().mediumFont, d().regularFont).items(e()).itemsCallback(this).onNegative(new a()).autoDismiss(false).negativeText(d().cancelButton).build();
        }
        throw new IllegalStateException("You must create a FileChooserDialog using the Builder.");
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        FileCallback fileCallback = this.f1111e;
        if (fileCallback != null) {
            fileCallback.onFileChooserDismissed(this);
        }
    }

    @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
    public void onSelection(MaterialDialog materialDialog, View view, int i4, CharSequence charSequence) {
        boolean z3 = this.f1110d;
        boolean z4 = true;
        if (z3 && i4 == 0) {
            File parentFile = this.f1108b.getParentFile();
            this.f1108b = parentFile;
            if (parentFile.getAbsolutePath().equals("/storage/emulated")) {
                this.f1108b = this.f1108b.getParentFile();
            }
            if (this.f1108b.getParent() == null) {
                z4 = false;
            }
            this.f1110d = z4;
        } else {
            File[] fileArr = this.f1109c;
            if (z3) {
                i4--;
            }
            File file = fileArr[i4];
            this.f1108b = file;
            this.f1110d = true;
            if (file.getAbsolutePath().equals("/storage/emulated")) {
                this.f1108b = Environment.getExternalStorageDirectory();
            }
        }
        if (this.f1108b.isFile()) {
            this.f1111e.onFileSelection(this, this.f1108b);
            dismiss();
            return;
        }
        this.f1109c = f(d().mimeType, d().extensions);
        MaterialDialog materialDialog2 = (MaterialDialog) getDialog();
        materialDialog2.setTitle(this.f1108b.getAbsolutePath());
        getArguments().putString("current_path", this.f1108b.getAbsolutePath());
        materialDialog2.setItems(e());
    }

    public void show(FragmentManager fragmentManager) {
        String str = d().tag;
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (findFragmentByTag != null) {
            ((DialogFragment) findFragmentByTag).dismiss();
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
        }
        show(fragmentManager, str);
    }

    /* loaded from: classes2.dex */
    public static class Builder implements Serializable {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final transient Context f1112a;
        String[] extensions;
        @Nullable
        String mediumFont;
        @Nullable
        String regularFont;
        String tag;
        @StringRes
        int cancelButton = 17039360;
        String initialPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String mimeType = null;
        String goUpLabel = "...";

        public Builder(@NonNull Context context) {
            this.f1112a = context;
        }

        @NonNull
        public FileChooserDialog build() {
            FileChooserDialog fileChooserDialog = new FileChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            fileChooserDialog.setArguments(bundle);
            return fileChooserDialog;
        }

        @NonNull
        public Builder cancelButton(@StringRes int i4) {
            this.cancelButton = i4;
            return this;
        }

        @NonNull
        public Builder extensionsFilter(@Nullable String... strArr) {
            this.extensions = strArr;
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
        public Builder mimeType(@Nullable String str) {
            this.mimeType = str;
            return this;
        }

        @NonNull
        public FileChooserDialog show(FragmentManager fragmentManager) {
            FileChooserDialog build = build();
            build.show(fragmentManager);
            return build;
        }

        @NonNull
        public Builder tag(@Nullable String str) {
            if (str == null) {
                str = "[MD_FILE_SELECTOR]";
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
        public FileChooserDialog show(FragmentActivity fragmentActivity) {
            return show(fragmentActivity.getSupportFragmentManager());
        }
    }

    public void show(FragmentActivity fragmentActivity) {
        show(fragmentActivity.getSupportFragmentManager());
    }
}
