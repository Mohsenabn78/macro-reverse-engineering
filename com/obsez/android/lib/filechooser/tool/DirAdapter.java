package com.obsez.android.lib.filechooser.tool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.obsez.android.lib.filechooser.R;
import com.obsez.android.lib.filechooser.internals.FileUtil;
import com.obsez.android.lib.filechooser.internals.UiUtil;
import com.obsez.android.lib.filechooser.internals.WrappedDrawable;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/* loaded from: classes6.dex */
public class DirAdapter extends ArrayAdapter<File> {

    /* renamed from: a  reason: collision with root package name */
    private SimpleDateFormat f36573a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f36574b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f36575c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36576d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuffColorFilter f36577e;

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<File> f36578f;

    /* renamed from: g  reason: collision with root package name */
    private GetView f36579g;

    /* renamed from: h  reason: collision with root package name */
    private Stack<Integer> f36580h;

    @FunctionalInterface
    /* loaded from: classes6.dex */
    public interface GetView {
        @NonNull
        View getView(@NonNull File file, boolean z3, @Deprecated boolean z4, View view, @NonNull ViewGroup viewGroup, @NonNull LayoutInflater layoutInflater);
    }

    public DirAdapter(Context context, String str) {
        super(context, R.layout.li_row_textview, R.id.text, new ArrayList());
        this.f36574b = null;
        this.f36575c = null;
        this.f36576d = false;
        this.f36578f = new SparseArray<>();
        this.f36579g = null;
        this.f36580h = new Stack<>();
        a(str);
    }

    @SuppressLint({"SimpleDateFormat"})
    private void a(String str) {
        String str2;
        if (str != null && !"".equals(str.trim())) {
            str2 = str.trim();
        } else {
            str2 = "yyyy/MM/dd HH:mm:ss";
        }
        this.f36573a = new SimpleDateFormat(str2);
        if (this.f36574b == null) {
            this.f36574b = ContextCompat.getDrawable(getContext(), R.drawable.ic_folder);
        }
        if (this.f36575c == null) {
            this.f36575c = ContextCompat.getDrawable(getContext(), R.drawable.ic_file);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(R.styleable.FileChooser);
        int color = obtainStyledAttributes.getColor(R.styleable.FileChooser_fileListItemSelectedTint, getContext().getResources().getColor(R.color.li_row_background_tint));
        obtainStyledAttributes.recycle();
        this.f36577e = new PorterDuffColorFilter(color, PorterDuff.Mode.MULTIPLY);
    }

    public void clearSelected() {
        this.f36578f.clear();
    }

    public Drawable getDefaultFileIcon() {
        return this.f36575c;
    }

    public Drawable getDefaultFolderIcon() {
        return this.f36574b;
    }

    public Stack<Integer> getIndexStack() {
        return this.f36580h;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i4) {
        try {
            return ((File) getItem(i4)).hashCode();
        } catch (IndexOutOfBoundsException unused) {
            try {
                return ((File) getItem(0)).hashCode();
            } catch (IndexOutOfBoundsException unused2) {
                return 0L;
            }
        }
    }

    public List<File> getSelected() {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f36578f.size(); i4++) {
            arrayList.add(this.f36578f.valueAt(i4));
        }
        return arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NonNull
    public View getView(int i4, View view, @NonNull ViewGroup viewGroup) {
        boolean z3;
        Drawable drawable;
        Drawable newDrawable;
        File file = (File) super.getItem(i4);
        if (file == null) {
            return super.getView(i4, view, viewGroup);
        }
        if (this.f36578f.get(file.hashCode(), null) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        GetView getView = this.f36579g;
        if (getView != null) {
            return getView.getView(file, z3, false, view, viewGroup, LayoutInflater.from(getContext()));
        }
        ViewGroup viewGroup2 = (ViewGroup) super.getView(i4, view, viewGroup);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.text);
        TextView textView2 = (TextView) viewGroup2.findViewById(R.id.txt_size);
        TextView textView3 = (TextView) viewGroup2.findViewById(R.id.txt_date);
        textView3.setVisibility(0);
        textView.setText(file.getName());
        if (file.isDirectory()) {
            newDrawable = this.f36574b.getConstantState().newDrawable();
            textView2.setText("");
            if (file.lastModified() != 0) {
                textView3.setText(this.f36573a.format(new Date(file.lastModified())));
            } else {
                textView3.setVisibility(8);
            }
        } else {
            if (this.f36576d) {
                drawable = UiUtil.resolveFileTypeIcon(getContext(), Uri.fromFile(file));
                if (drawable != null) {
                    drawable = new WrappedDrawable(drawable, 24.0f, 24.0f);
                }
            } else {
                drawable = null;
            }
            if (drawable == null) {
                drawable = this.f36575c;
            }
            newDrawable = drawable.getConstantState().newDrawable();
            textView2.setText(FileUtil.getReadableFileSize(file.length()));
            textView3.setText(this.f36573a.format(new Date(file.lastModified())));
        }
        if (file.isHidden()) {
            newDrawable.mutate().setColorFilter(new PorterDuffColorFilter(-2130706433, PorterDuff.Mode.SRC_ATOP));
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(newDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
        View findViewById = viewGroup2.findViewById(R.id.root);
        if (findViewById.getBackground() == null) {
            findViewById.setBackgroundResource(R.color.li_row_background);
        }
        if (!z3) {
            findViewById.getBackground().clearColorFilter();
        } else {
            findViewById.getBackground().setColorFilter(this.f36577e);
        }
        return viewGroup2;
    }

    public boolean isAnySelected() {
        if (this.f36578f.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        if (getCount() == 0) {
            return true;
        }
        if (getCount() == 1 && (getItem(0) instanceof RootFile)) {
            return true;
        }
        return false;
    }

    public boolean isOneSelected() {
        if (this.f36578f.size() == 1) {
            return true;
        }
        return false;
    }

    public boolean isResolveFileType() {
        return this.f36576d;
    }

    public boolean isSelected(int i4) {
        return isSelectedById((int) getItemId(i4));
    }

    public boolean isSelectedById(int i4) {
        if (this.f36578f.get(i4, null) != null) {
            return true;
        }
        return false;
    }

    public void overrideGetView(GetView getView) {
        this.f36579g = getView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void selectItem(int i4) {
        int itemId = (int) getItemId(i4);
        if (this.f36578f.get(itemId, null) == null) {
            this.f36578f.append(itemId, getItem(i4));
        } else {
            this.f36578f.delete(itemId);
        }
        notifyDataSetChanged();
    }

    public void setDefaultFileIcon(Drawable drawable) {
        this.f36575c = drawable;
    }

    public void setDefaultFolderIcon(Drawable drawable) {
        this.f36574b = drawable;
    }

    public void setEntries(List<File> list) {
        setNotifyOnChange(false);
        super.clear();
        setNotifyOnChange(true);
        super.addAll(list);
    }

    public void setResolveFileType(boolean z3) {
        this.f36576d = z3;
    }

    public DirAdapter(Context context, List<File> list, int i4, String str) {
        super(context, i4, R.id.text, list);
        this.f36574b = null;
        this.f36575c = null;
        this.f36576d = false;
        this.f36578f = new SparseArray<>();
        this.f36579g = null;
        this.f36580h = new Stack<>();
        a(str);
    }
}
