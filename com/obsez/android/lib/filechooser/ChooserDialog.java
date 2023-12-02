package com.obsez.android.lib.filechooser;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.obsez.android.lib.filechooser.ChooserDialog;
import com.obsez.android.lib.filechooser.internals.ExtFileFilter;
import com.obsez.android.lib.filechooser.internals.FileUtil;
import com.obsez.android.lib.filechooser.internals.RegexFileFilter;
import com.obsez.android.lib.filechooser.permissions.PermissionsUtil;
import com.obsez.android.lib.filechooser.tool.DirAdapter;
import com.obsez.android.lib.filechooser.tool.RootFile;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class ChooserDialog implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener {

    /* renamed from: l0  reason: collision with root package name */
    private static final CanNavigateUp f36472l0 = new CanNavigateUp() { // from class: i1.f
        @Override // com.obsez.android.lib.filechooser.ChooserDialog.CanNavigateUp
        public final boolean canUpTo(File file) {
            boolean r4;
            r4 = ChooserDialog.r(file);
            return r4;
        }
    };

    /* renamed from: m0  reason: collision with root package name */
    private static final CanNavigateTo f36473m0 = new CanNavigateTo() { // from class: i1.g
        @Override // com.obsez.android.lib.filechooser.ChooserDialog.CanNavigateTo
        public final boolean canNavigate(File file) {
            boolean s3;
            s3 = ChooserDialog.s(file);
            return s3;
        }
    };
    private DialogInterface.OnCancelListener A;
    private DialogInterface.OnDismissListener B;
    private boolean C;
    boolean D;
    private boolean E;
    TextView G;
    private CustomizePathView H;
    View I;
    @Nullable
    String N;
    @Nullable
    String O;
    @Nullable
    String P;
    @Nullable
    String Q;
    @Nullable
    Drawable U;
    @Nullable
    Drawable V;
    @Nullable
    Drawable W;
    @Nullable
    View X;
    boolean Y;
    private PermissionsUtil.OnPermissionListener Z;

    /* renamed from: a  reason: collision with root package name */
    private boolean f36474a;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f36475a0;

    /* renamed from: c0  reason: collision with root package name */
    Button f36479c0;

    /* renamed from: d  reason: collision with root package name */
    Runnable f36480d;

    /* renamed from: d0  reason: collision with root package name */
    Button f36481d0;

    /* renamed from: e  reason: collision with root package name */
    private int f36482e;

    /* renamed from: e0  reason: collision with root package name */
    Button f36483e0;

    /* renamed from: g0  reason: collision with root package name */
    private CanNavigateUp f36487g0;

    /* renamed from: h  reason: collision with root package name */
    DirAdapter f36488h;

    /* renamed from: h0  reason: collision with root package name */
    private CanNavigateTo f36489h0;

    /* renamed from: i  reason: collision with root package name */
    File f36490i;

    /* renamed from: i0  reason: collision with root package name */
    OnBackPressedListener f36491i0;

    /* renamed from: j  reason: collision with root package name */
    Context f36492j;

    /* renamed from: k  reason: collision with root package name */
    AlertDialog f36494k;

    /* renamed from: k0  reason: collision with root package name */
    FileUtil.NewFolderFilter f36495k0;

    /* renamed from: l  reason: collision with root package name */
    ListView f36496l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f36498n;

    /* renamed from: o  reason: collision with root package name */
    private FileFilter f36499o;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private String f36503s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private String f36504t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private String f36505u;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    private Drawable f36507w;

    /* renamed from: y  reason: collision with root package name */
    private String f36509y;

    /* renamed from: z  reason: collision with root package name */
    private DialogInterface.OnClickListener f36510z;

    /* renamed from: b  reason: collision with root package name */
    private String f36476b = null;

    /* renamed from: c  reason: collision with root package name */
    private String f36478c = null;

    /* renamed from: f  reason: collision with root package name */
    boolean f36484f = false;

    /* renamed from: g  reason: collision with root package name */
    List<File> f36486g = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    Result f36497m = null;
    @StringRes

    /* renamed from: p  reason: collision with root package name */
    private int f36500p = -1;
    @StringRes

    /* renamed from: q  reason: collision with root package name */
    private int f36501q = -1;
    @StringRes

    /* renamed from: r  reason: collision with root package name */
    private int f36502r = -1;
    @DrawableRes

    /* renamed from: v  reason: collision with root package name */
    private int f36506v = -1;
    @LayoutRes

    /* renamed from: x  reason: collision with root package name */
    private int f36508x = -1;
    private boolean F = true;
    @StringRes
    int J = -1;
    @StringRes
    int K = -1;
    @StringRes
    int L = -1;
    @StringRes
    int M = -1;
    @DrawableRes
    int R = -1;
    @DrawableRes
    int S = -1;
    @DrawableRes
    int T = -1;

    /* renamed from: b0  reason: collision with root package name */
    boolean f36477b0 = true;

    /* renamed from: f0  reason: collision with root package name */
    private AdapterSetter f36485f0 = null;

    /* renamed from: j0  reason: collision with root package name */
    int f36493j0 = 0;

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface AdapterSetter {
        void apply(DirAdapter dirAdapter);
    }

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface CanNavigateTo {
        boolean canNavigate(File file);
    }

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface CanNavigateUp {
        boolean canUpTo(File file);
    }

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface CustomizePathView {
        void customize(TextView textView);
    }

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface OnBackPressedListener {
        void onBackPressed(AlertDialog alertDialog);
    }

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface Result {
        void onChoosePath(String str, File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewTreeObserver f36512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ViewGroup.MarginLayoutParams f36513b;

        b(ViewTreeObserver viewTreeObserver, ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.f36512a = viewTreeObserver;
            this.f36513b = marginLayoutParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            ChooserDialog.this.f36496l.setSelection(0);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (ChooserDialog.this.G.getHeight() <= 0) {
                return false;
            }
            this.f36512a.removeOnPreDrawListener(this);
            if (ChooserDialog.this.G.getParent() instanceof FrameLayout) {
                this.f36513b.topMargin = ChooserDialog.this.G.getHeight();
            }
            ChooserDialog.this.f36496l.setLayoutParams(this.f36513b);
            ChooserDialog.this.f36496l.post(new Runnable() { // from class: com.obsez.android.lib.filechooser.a
                @Override // java.lang.Runnable
                public final void run() {
                    ChooserDialog.b.this.b();
                }
            });
            return true;
        }
    }

    public ChooserDialog(Context context, @StyleRes int i4) {
        this.f36492j = context;
        n(Integer.valueOf(i4));
    }

    private void A(List<File> list) {
        Collections.sort(list, new Comparator() { // from class: i1.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int q4;
                q4 = ChooserDialog.q((File) obj, (File) obj2);
                return q4;
            }
        });
    }

    private void l(String str) {
        int indexOf;
        int length;
        int length2;
        ViewGroup.LayoutParams layoutParams;
        if (this.G == null) {
            ViewGroup viewGroup = (ViewGroup) this.f36494k.findViewById(this.f36492j.getResources().getIdentifier("contentPanel", "id", this.f36492j.getPackageName()));
            if (viewGroup == null) {
                viewGroup = (ViewGroup) this.f36494k.findViewById(this.f36492j.getResources().getIdentifier("contentPanel", "id", "android"));
                if (viewGroup == null) {
                    return;
                }
            }
            if (viewGroup instanceof LinearLayout) {
                layoutParams = new LinearLayout.LayoutParams(-1, -2);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -2, 48);
            }
            Context context = this.f36492j;
            int[] iArr = R.styleable.FileChooser;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.f36492j, obtainStyledAttributes.getResourceId(R.styleable.FileChooser_fileChooserPathViewStyle, R.style.FileChooserPathViewStyle));
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = contextThemeWrapper.obtainStyledAttributes(iArr);
            this.f36474a = obtainStyledAttributes2.getBoolean(R.styleable.FileChooser_fileChooserPathViewDisplayRoot, true);
            TextView textView = new TextView(contextThemeWrapper);
            this.G = textView;
            viewGroup.addView(textView, 0, layoutParams);
            this.G.setElevation(obtainStyledAttributes2.getInt(R.styleable.FileChooser_fileChooserPathViewElevation, 2));
            obtainStyledAttributes2.recycle();
            CustomizePathView customizePathView = this.H;
            if (customizePathView != null) {
                customizePathView.customize(this.G);
            }
        }
        if (str == null) {
            this.G.setVisibility(8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f36496l.getLayoutParams();
            if (this.G.getParent() instanceof FrameLayout) {
                marginLayoutParams.topMargin = 0;
            }
            this.f36496l.setLayoutParams(marginLayoutParams);
            return;
        }
        if (this.f36476b == null || this.f36478c == null) {
            this.f36476b = FileUtil.getStoragePath(this.f36492j, true);
            this.f36478c = FileUtil.getStoragePath(this.f36492j, false);
        }
        if (str.contains(this.f36476b)) {
            if (this.f36474a) {
                length2 = this.f36476b.lastIndexOf(47) + 1;
            } else {
                length2 = this.f36476b.length();
            }
            str = str.substring(length2);
        }
        if (str.contains(this.f36478c)) {
            if (this.f36474a) {
                length = this.f36478c.lastIndexOf(47) + 1;
            } else {
                length = this.f36478c.length();
            }
            str = str.substring(length);
        }
        this.G.setText(str);
        while (this.G.getLineCount() > 1 && (indexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING, str.indexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1)) != -1) {
            str = "..." + str.substring(indexOf);
            this.G.setText(str);
        }
        this.G.setVisibility(0);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f36496l.getLayoutParams();
        if (this.G.getHeight() == 0) {
            ViewTreeObserver viewTreeObserver = this.G.getViewTreeObserver();
            viewTreeObserver.addOnPreDrawListener(new b(viewTreeObserver, marginLayoutParams2));
            return;
        }
        if (this.G.getParent() instanceof FrameLayout) {
            marginLayoutParams2.topMargin = this.G.getHeight();
        }
        this.f36496l.setLayoutParams(marginLayoutParams2);
    }

    private void m() {
        n(null);
    }

    private void n(@Nullable @StyleRes Integer num) {
        this.f36491i0 = new com.obsez.android.lib.filechooser.b(this);
        if (num == null) {
            TypedValue typedValue = new TypedValue();
            if (!this.f36492j.getTheme().resolveAttribute(R.attr.fileChooserStyle, typedValue, true)) {
                this.f36492j = new ContextThemeWrapper(this.f36492j, R.style.FileChooserStyle);
                return;
            } else {
                this.f36492j = new ContextThemeWrapper(this.f36492j, typedValue.resourceId);
                return;
            }
        }
        this.f36492j = new ContextThemeWrapper(this.f36492j, num.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(DialogInterface dialogInterface, int i4) {
        Result result = this.f36497m;
        if (result != null) {
            result.onChoosePath(this.f36490i.getAbsolutePath(), this.f36490i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p() {
        this.f36496l.setSelection(this.f36482e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int q(File file, File file2) {
        return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean r(File file) {
        if (file != null && file.canRead()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean s(File file) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Drawable drawable, Drawable drawable2, boolean z3, DirAdapter dirAdapter) {
        if (drawable != null) {
            dirAdapter.setDefaultFileIcon(drawable);
        }
        if (drawable2 != null) {
            dirAdapter.setDefaultFolderIcon(drawable2);
        }
        dirAdapter.setResolveFileType(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(int i4, int i5, boolean z3, DirAdapter dirAdapter) {
        if (i4 != -1) {
            dirAdapter.setDefaultFileIcon(ContextCompat.getDrawable(this.f36492j, i4));
        }
        if (i5 != -1) {
            dirAdapter.setDefaultFolderIcon(ContextCompat.getDrawable(this.f36492j, i5));
        }
        dirAdapter.setResolveFileType(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean v(boolean z3, File file) {
        if (file.isDirectory() && (!file.isHidden() || z3)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean w(boolean z3, File file) {
        if (file.isHidden() && !z3) {
            return false;
        }
        return true;
    }

    private void x() {
        this.f36486g.clear();
        if (this.f36490i == null) {
            this.f36490i = new File(FileUtil.getStoragePath(this.f36492j, false));
        }
        File[] listFiles = this.f36490i.listFiles(this.f36499o);
        boolean z3 = true;
        if (this.f36476b == null || this.f36478c == null) {
            this.f36476b = FileUtil.getStoragePath(this.f36492j, true);
            this.f36478c = FileUtil.getStoragePath(this.f36492j, false);
        }
        if (!this.f36476b.equals(this.f36478c)) {
            if (this.f36490i.getAbsolutePath().equals(this.f36478c)) {
                this.f36486g.add(new RootFile(this.f36476b, ".. SDCard Storage"));
            } else if (this.f36490i.getAbsolutePath().equals(this.f36476b)) {
                this.f36486g.add(new RootFile(this.f36478c, ".. Primary Storage"));
            }
        }
        if (this.f36486g.isEmpty() && this.f36490i.getParentFile() != null && this.f36490i.getParentFile().canRead()) {
            this.f36486g.add(new RootFile(this.f36490i.getParentFile().getAbsolutePath(), ".."));
        } else {
            z3 = false;
        }
        if (listFiles == null) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (File file : listFiles) {
            if (file.isDirectory()) {
                linkedList.add(file);
            } else {
                linkedList2.add(file);
            }
        }
        A(linkedList);
        A(linkedList2);
        this.f36486g.addAll(linkedList);
        this.f36486g.addAll(linkedList2);
        AlertDialog alertDialog = this.f36494k;
        if (alertDialog != null && !this.C && this.E) {
            if (z3) {
                alertDialog.setTitle(this.f36490i.getName());
            } else {
                int i4 = this.f36500p;
                if (i4 != -1) {
                    alertDialog.setTitle(i4);
                } else {
                    String str = this.f36503s;
                    if (str != null) {
                        alertDialog.setTitle(str);
                    } else {
                        alertDialog.setTitle(R.string.choose_file);
                    }
                }
            }
        }
        AlertDialog alertDialog2 = this.f36494k;
        if (alertDialog2 != null && alertDialog2.isShowing() && this.F) {
            if (z3) {
                l(this.f36490i.getPath());
            } else {
                l(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        Window window = this.f36494k.getWindow();
        if (window != null) {
            TypedArray obtainStyledAttributes = this.f36492j.obtainStyledAttributes(R.styleable.FileChooser);
            window.setGravity(obtainStyledAttributes.getInt(R.styleable.FileChooser_fileChooserDialogGravity, 17));
            obtainStyledAttributes.recycle();
        }
        this.f36494k.show();
    }

    public ChooserDialog build() {
        Context context = this.f36492j;
        int[] iArr = R.styleable.FileChooser;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f36492j, obtainStyledAttributes.getResourceId(R.styleable.FileChooser_fileChooserDialogStyle, R.style.FileChooserDialogStyle));
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.FileChooser_fileChooserListItemStyle, R.style.FileChooserListItemStyle);
        obtainStyledAttributes.recycle();
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.f36492j, resourceId);
        TypedArray obtainStyledAttributes2 = contextThemeWrapper.obtainStyledAttributes(iArr);
        int resourceId2 = obtainStyledAttributes2.getResourceId(R.styleable.FileChooser_fileListItemFocusedDrawable, R.drawable.listview_item_selector);
        obtainStyledAttributes2.recycle();
        DirAdapter dirAdapter = new DirAdapter(contextThemeWrapper, this.f36509y);
        this.f36488h = dirAdapter;
        AdapterSetter adapterSetter = this.f36485f0;
        if (adapterSetter != null) {
            adapterSetter.apply(dirAdapter);
        }
        y();
        builder.setAdapter(this.f36488h, this);
        if (!this.C) {
            int i4 = this.f36500p;
            if (i4 != -1) {
                builder.setTitle(i4);
            } else {
                String str = this.f36503s;
                if (str != null) {
                    builder.setTitle(str);
                } else {
                    builder.setTitle(R.string.choose_file);
                }
            }
        }
        int i5 = this.f36506v;
        if (i5 != -1) {
            builder.setIcon(i5);
        } else {
            Drawable drawable = this.f36507w;
            if (drawable != null) {
                builder.setIcon(drawable);
            }
        }
        int i6 = this.f36508x;
        if (i6 != -1) {
            builder.setView(i6);
        }
        if (this.f36498n || this.Y) {
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: i1.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i7) {
                    ChooserDialog.this.o(dialogInterface, i7);
                }
            };
            int i7 = this.f36501q;
            if (i7 != -1) {
                builder.setPositiveButton(i7, onClickListener);
            } else {
                String str2 = this.f36504t;
                if (str2 != null) {
                    builder.setPositiveButton(str2, onClickListener);
                } else {
                    builder.setPositiveButton(R.string.title_choose, onClickListener);
                }
            }
        }
        int i8 = this.f36502r;
        if (i8 != -1) {
            builder.setNegativeButton(i8, this.f36510z);
        } else {
            String str3 = this.f36505u;
            if (str3 != null) {
                builder.setNegativeButton(str3, this.f36510z);
            } else {
                builder.setNegativeButton(R.string.dialog_cancel, this.f36510z);
            }
        }
        DialogInterface.OnCancelListener onCancelListener = this.A;
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        DialogInterface.OnDismissListener onDismissListener = this.B;
        if (onDismissListener != null) {
            builder.setOnDismissListener(onDismissListener);
        }
        builder.setOnItemSelectedListener(this).setOnKeyListener(new c(this));
        AlertDialog create = builder.create();
        this.f36494k = create;
        create.setCanceledOnTouchOutside(this.f36475a0);
        this.f36494k.setOnShowListener(new f(this, resourceId2));
        ListView listView = this.f36494k.getListView();
        this.f36496l = listView;
        listView.setOnItemClickListener(this);
        if (this.Y) {
            this.f36496l.setOnItemLongClickListener(this);
        }
        if (this.f36477b0) {
            this.f36496l.setSelector(resourceId2);
            this.f36496l.setDrawSelectorOnTop(true);
            this.f36496l.setItemsCanFocus(true);
            this.f36496l.setChoiceMode(1);
        }
        this.f36496l.requestFocus();
        return this;
    }

    public ChooserDialog cancelOnTouchOutside(boolean z3) {
        this.f36475a0 = z3;
        return this;
    }

    public ChooserDialog customizePathView(CustomizePathView customizePathView) {
        this.H = customizePathView;
        return this;
    }

    public ChooserDialog disableTitle(boolean z3) {
        this.C = z3;
        return this;
    }

    public void dismiss() {
        this.f36494k.dismiss();
    }

    public ChooserDialog displayPath(boolean z3) {
        this.F = z3;
        return this;
    }

    public ChooserDialog enableDpad(boolean z3) {
        this.f36477b0 = z3;
        return this;
    }

    public ChooserDialog enableMultiple(boolean z3) {
        this.Y = z3;
        return this;
    }

    public ChooserDialog enableOptions(boolean z3) {
        this.D = z3;
        return this;
    }

    public boolean goBack() {
        if (this.f36486g.size() <= 0 || !this.f36486g.get(0).getName().equals("..")) {
            return false;
        }
        ListView listView = this.f36496l;
        listView.performItemClick(listView, 0, 0L);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(String str) {
        if (FileUtil.createNewDirectory(str, this.f36490i)) {
            y();
            return;
        }
        File file = new File(this.f36490i, str);
        Context context = this.f36492j;
        Toast.makeText(context, "Couldn't create folder " + file.getName() + " at " + file.getAbsolutePath(), 1).show();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
        if (i4 >= 0 && i4 < this.f36486g.size()) {
            this.f36482e = 0;
            File file = this.f36486g.get(i4);
            if (file instanceof RootFile) {
                if (this.f36487g0 == null) {
                    this.f36487g0 = f36472l0;
                }
                if (this.f36487g0.canUpTo(file)) {
                    this.f36490i = file;
                    int i5 = this.f36493j0;
                    if (i5 == 1) {
                        i5 = 0;
                    }
                    this.f36493j0 = i5;
                    Runnable runnable = this.f36480d;
                    if (runnable != null) {
                        runnable.run();
                    }
                    this.f36484f = false;
                    if (!this.f36488h.getIndexStack().empty()) {
                        this.f36482e = this.f36488h.getIndexStack().pop().intValue();
                    }
                }
            } else {
                int i6 = this.f36493j0;
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            return;
                        }
                        if (file.isDirectory()) {
                            if (this.f36489h0 == null) {
                                this.f36489h0 = f36473m0;
                            }
                            if (this.f36489h0.canNavigate(file)) {
                                this.f36490i = file;
                                this.f36482e = 0;
                                this.f36488h.getIndexStack().push(Integer.valueOf(i4));
                            }
                        } else {
                            this.f36488h.selectItem(i4);
                            if (!this.f36488h.isAnySelected()) {
                                this.f36493j0 = 0;
                                this.f36483e0.setVisibility(4);
                            }
                            this.f36497m.onChoosePath(file.getAbsolutePath(), file);
                            return;
                        }
                    } else {
                        try {
                            FileUtil.deleteFileRecursively(file);
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            Toast.makeText(this.f36492j, e4.getMessage(), 1).show();
                        }
                        this.f36493j0 = 0;
                        Runnable runnable2 = this.f36480d;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        this.f36482e = -1;
                    }
                } else {
                    if (file.isDirectory()) {
                        if (this.f36489h0 == null) {
                            this.f36489h0 = f36473m0;
                        }
                        if (this.f36489h0.canNavigate(file)) {
                            this.f36490i = file;
                            this.f36482e = 0;
                            this.f36488h.getIndexStack().push(Integer.valueOf(i4));
                        }
                    } else if (!this.f36498n && this.f36497m != null) {
                        this.f36494k.dismiss();
                        this.f36497m.onChoosePath(file.getAbsolutePath(), file);
                        if (this.Y) {
                            this.f36497m.onChoosePath(this.f36490i.getAbsolutePath(), this.f36490i);
                            return;
                        }
                        return;
                    }
                    this.f36484f = false;
                }
            }
            y();
            int i7 = this.f36482e;
            if (i7 != -1) {
                this.f36496l.setSelection(i7);
                this.f36496l.post(new Runnable() { // from class: i1.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChooserDialog.this.p();
                    }
                });
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i4, long j4) {
        File file = this.f36486g.get(i4);
        if ((file instanceof RootFile) || file.isDirectory() || this.f36488h.isSelected(i4)) {
            return true;
        }
        this.f36497m.onChoosePath(file.getAbsolutePath(), file);
        this.f36488h.selectItem(i4);
        this.f36493j0 = 2;
        this.f36483e0.setVisibility(0);
        Runnable runnable = this.f36480d;
        if (runnable != null) {
            runnable.run();
        }
        return true;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
        boolean z3 = true;
        if (i4 != this.f36486g.size() - 1) {
            z3 = false;
        }
        this.f36484f = z3;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        this.f36484f = false;
    }

    public ChooserDialog show() {
        String[] strArr;
        if (this.f36494k == null || this.f36496l == null) {
            build();
        }
        if (Build.VERSION.SDK_INT < 23) {
            z();
            return this;
        }
        if (this.Z == null) {
            this.Z = new a();
        }
        if (this.D) {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        } else {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        }
        PermissionsUtil.checkPermissions(this.f36492j, this.Z, strArr);
        return this;
    }

    public ChooserDialog titleFollowsDir(boolean z3) {
        this.E = z3;
        return this;
    }

    public ChooserDialog withAdapterSetter(AdapterSetter adapterSetter) {
        this.f36485f0 = adapterSetter;
        return this;
    }

    public ChooserDialog withChosenListener(Result result) {
        this.f36497m = result;
        return this;
    }

    public ChooserDialog withDateFormat() {
        return withDateFormat("yyyy/MM/dd HH:mm:ss");
    }

    public ChooserDialog withFileIcons(final boolean z3, final Drawable drawable, final Drawable drawable2) {
        this.f36485f0 = new AdapterSetter() { // from class: i1.c
            @Override // com.obsez.android.lib.filechooser.ChooserDialog.AdapterSetter
            public final void apply(DirAdapter dirAdapter) {
                ChooserDialog.t(drawable, drawable2, z3, dirAdapter);
            }
        };
        return this;
    }

    public ChooserDialog withFileIconsRes(final boolean z3, final int i4, final int i5) {
        this.f36485f0 = new AdapterSetter() { // from class: i1.d
            @Override // com.obsez.android.lib.filechooser.ChooserDialog.AdapterSetter
            public final void apply(DirAdapter dirAdapter) {
                ChooserDialog.this.u(i4, i5, z3, dirAdapter);
            }
        };
        return this;
    }

    public ChooserDialog withFilter(FileFilter fileFilter) {
        withFilter(false, false, (String[]) null);
        this.f36499o = fileFilter;
        return this;
    }

    public ChooserDialog withFilterRegex(boolean z3, boolean z4, String str, int i4) {
        this.f36498n = z3;
        this.f36499o = new RegexFileFilter(z3, z4, str, i4);
        return this;
    }

    public ChooserDialog withIcon(@DrawableRes int i4) {
        this.f36506v = i4;
        return this;
    }

    @RequiresApi(21)
    public ChooserDialog withLayoutView(@LayoutRes int i4) {
        this.f36508x = i4;
        return this;
    }

    public ChooserDialog withNavigateTo(CanNavigateTo canNavigateTo) {
        this.f36489h0 = canNavigateTo;
        return this;
    }

    public ChooserDialog withNavigateUpTo(CanNavigateUp canNavigateUp) {
        this.f36487g0 = canNavigateUp;
        return this;
    }

    public ChooserDialog withNegativeButton(@StringRes int i4, DialogInterface.OnClickListener onClickListener) {
        this.f36502r = i4;
        this.f36510z = onClickListener;
        return this;
    }

    public ChooserDialog withNegativeButtonListener(DialogInterface.OnClickListener onClickListener) {
        this.f36510z = onClickListener;
        return this;
    }

    public ChooserDialog withNewFolderFilter(FileUtil.NewFolderFilter newFolderFilter) {
        this.f36495k0 = newFolderFilter;
        return this;
    }

    public ChooserDialog withOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        OnBackPressedListener onBackPressedListener2 = this.f36491i0;
        if (onBackPressedListener2 instanceof com.obsez.android.lib.filechooser.b) {
            ((com.obsez.android.lib.filechooser.b) onBackPressedListener2).f36519b = onBackPressedListener;
        }
        return this;
    }

    public ChooserDialog withOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        this.A = onCancelListener;
        return this;
    }

    @RequiresApi(17)
    public ChooserDialog withOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.B = onDismissListener;
        return this;
    }

    public ChooserDialog withOnLastBackPressedListener(OnBackPressedListener onBackPressedListener) {
        OnBackPressedListener onBackPressedListener2 = this.f36491i0;
        if (onBackPressedListener2 instanceof com.obsez.android.lib.filechooser.b) {
            ((com.obsez.android.lib.filechooser.b) onBackPressedListener2).f36520c = onBackPressedListener;
        }
        return this;
    }

    public ChooserDialog withOptionIcons(@DrawableRes int i4, @DrawableRes int i5, @DrawableRes int i6) {
        this.R = i4;
        this.S = i5;
        this.T = i6;
        return this;
    }

    public ChooserDialog withOptionResources(@StringRes int i4, @StringRes int i5, @StringRes int i6, @StringRes int i7) {
        this.J = i4;
        this.K = i5;
        this.L = i6;
        this.M = i7;
        return this;
    }

    public ChooserDialog withOptionStringResources(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.N = str;
        this.O = str2;
        this.P = str3;
        this.Q = str4;
        return this;
    }

    public ChooserDialog withResources(@StringRes int i4, @StringRes int i5, @StringRes int i6) {
        this.f36500p = i4;
        this.f36501q = i5;
        this.f36502r = i6;
        return this;
    }

    public ChooserDialog withStartFile(String str) {
        if (str != null) {
            this.f36490i = new File(str);
        } else {
            this.f36490i = new File(FileUtil.getStoragePath(this.f36492j, false));
        }
        if (!this.f36490i.isDirectory()) {
            this.f36490i = this.f36490i.getParentFile();
        }
        if (this.f36490i == null) {
            this.f36490i = new File(FileUtil.getStoragePath(this.f36492j, false));
        }
        return this;
    }

    public ChooserDialog withStringResources(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f36503s = str;
        this.f36504t = str2;
        this.f36505u = str3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        x();
        this.f36488h.setEntries(this.f36486g);
    }

    public ChooserDialog withDateFormat(String str) {
        this.f36509y = str;
        return this;
    }

    public ChooserDialog withIcon(@Nullable Drawable drawable) {
        this.f36507w = drawable;
        return this;
    }

    public ChooserDialog withFilter(boolean z3, boolean z4, FileFilter fileFilter) {
        withFilter(z3, z4, (String[]) null);
        this.f36499o = fileFilter;
        return this;
    }

    public ChooserDialog withFilterRegex(boolean z3, boolean z4, String str) {
        this.f36498n = z3;
        this.f36499o = new RegexFileFilter(z3, z4, str, 2);
        return this;
    }

    public ChooserDialog withNegativeButton(@Nullable String str, DialogInterface.OnClickListener onClickListener) {
        this.f36505u = str;
        if (str != null) {
            this.f36502r = -1;
        }
        this.f36510z = onClickListener;
        return this;
    }

    public ChooserDialog withOptionIcons(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Nullable Drawable drawable3) {
        this.U = drawable;
        this.V = drawable2;
        this.W = drawable3;
        return this;
    }

    public ChooserDialog withFilter(boolean z3, String... strArr) {
        return withFilter(false, z3, strArr);
    }

    public ChooserDialog withFilter(boolean z3, final boolean z4, String... strArr) {
        this.f36498n = z3;
        if (strArr != null && strArr.length != 0) {
            this.f36499o = new ExtFileFilter(z3, z4, strArr);
        } else {
            this.f36499o = z3 ? new FileFilter() { // from class: i1.a
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean v3;
                    v3 = ChooserDialog.v(z4, file);
                    return v3;
                }
            } : new FileFilter() { // from class: i1.b
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean w3;
                    w3 = ChooserDialog.w(z4, file);
                    return w3;
                }
            };
        }
        return this;
    }

    public ChooserDialog(Activity activity, @StyleRes int i4) {
        this.f36492j = activity;
        n(Integer.valueOf(i4));
    }

    /* loaded from: classes6.dex */
    class a implements PermissionsUtil.OnPermissionListener {
        a() {
        }

        @Override // com.obsez.android.lib.filechooser.permissions.PermissionsUtil.OnPermissionListener
        public void onPermissionGranted(String[] strArr) {
            boolean z3;
            int length = strArr.length;
            boolean z4 = false;
            int i4 = 0;
            while (true) {
                if (i4 < length) {
                    if (strArr[i4].equals("android.permission.READ_EXTERNAL_STORAGE")) {
                        z3 = true;
                        break;
                    }
                    i4++;
                } else {
                    z3 = false;
                    break;
                }
            }
            if (!z3) {
                return;
            }
            if (ChooserDialog.this.D) {
                int length2 = strArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        break;
                    } else if (strArr[i5].equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                        z4 = true;
                        break;
                    } else {
                        i5++;
                    }
                }
            } else {
                z4 = z3;
            }
            if (!z4) {
                return;
            }
            if (ChooserDialog.this.f36488h.isEmpty()) {
                ChooserDialog.this.y();
            }
            ChooserDialog.this.z();
        }

        @Override // com.obsez.android.lib.filechooser.permissions.PermissionsUtil.OnPermissionListener
        public void onShouldShowRequestPermissionRationale(String[] strArr) {
            Toast.makeText(ChooserDialog.this.f36492j, "You denied the Read/Write permissions on SDCard.", 1).show();
        }

        @Override // com.obsez.android.lib.filechooser.permissions.PermissionsUtil.OnPermissionListener
        public void onPermissionDenied(String[] strArr) {
        }
    }

    public ChooserDialog(Fragment fragment, @StyleRes int i4) {
        this.f36492j = fragment.getActivity();
        n(Integer.valueOf(i4));
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i4) {
    }

    public ChooserDialog(Context context) {
        this.f36492j = context;
        m();
    }

    public ChooserDialog(Activity activity) {
        this.f36492j = activity;
        m();
    }

    public ChooserDialog(Fragment fragment) {
        this.f36492j = fragment.getActivity();
        m();
    }
}
