package com.obsez.android.lib.filechooser;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.obsez.android.lib.filechooser.f;
import com.obsez.android.lib.filechooser.internals.FileUtil;
import com.obsez.android.lib.filechooser.internals.UiUtil;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: onShowListener.java */
/* loaded from: classes6.dex */
public class f implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<ChooserDialog> f36526a;

    /* renamed from: b  reason: collision with root package name */
    private int f36527b;

    /* compiled from: onShowListener.java */
    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f36528a;

        /* compiled from: onShowListener.java */
        /* renamed from: com.obsez.android.lib.filechooser.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class ViewTreeObserver$OnPreDrawListenerC0212a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver f36530a;

            ViewTreeObserver$OnPreDrawListenerC0212a(ViewTreeObserver viewTreeObserver) {
                this.f36530a = viewTreeObserver;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (((ChooserDialog) f.this.f36526a.get()).I.getHeight() <= 0) {
                    return false;
                }
                this.f36530a.removeOnPreDrawListener(this);
                a aVar = a.this;
                aVar.f36528a.f36532a = UiUtil.getListYScroll(((ChooserDialog) f.this.f36526a.get()).f36496l);
                if (((ChooserDialog) f.this.f36526a.get()).I.getParent() instanceof FrameLayout) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((ChooserDialog) f.this.f36526a.get()).f36496l.getLayoutParams();
                    marginLayoutParams.bottomMargin = ((ChooserDialog) f.this.f36526a.get()).I.getHeight();
                    ((ChooserDialog) f.this.f36526a.get()).f36496l.setLayoutParams(marginLayoutParams);
                }
                ((ChooserDialog) f.this.f36526a.get()).I.setVisibility(0);
                ((ChooserDialog) f.this.f36526a.get()).I.requestFocus();
                return true;
            }
        }

        a(b bVar) {
            this.f36528a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((ChooserDialog) f.this.f36526a.get()).I.getHeight() == 0) {
                ViewTreeObserver viewTreeObserver = ((ChooserDialog) f.this.f36526a.get()).I.getViewTreeObserver();
                viewTreeObserver.addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC0212a(viewTreeObserver));
                return;
            }
            this.f36528a.f36532a = UiUtil.getListYScroll(((ChooserDialog) f.this.f36526a.get()).f36496l);
            ((ChooserDialog) f.this.f36526a.get()).I.setVisibility(0);
            ((ChooserDialog) f.this.f36526a.get()).I.requestFocus();
            if (((ChooserDialog) f.this.f36526a.get()).I.getParent() instanceof FrameLayout) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((ChooserDialog) f.this.f36526a.get()).f36496l.getLayoutParams();
                marginLayoutParams.bottomMargin = ((ChooserDialog) f.this.f36526a.get()).I.getHeight();
                ((ChooserDialog) f.this.f36526a.get()).f36496l.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: onShowListener.java */
    /* loaded from: classes6.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        int f36532a = 0;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: onShowListener.java */
    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DialogInterface f36534a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f36535b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PorterDuffColorFilter f36536c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runnable f36537d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Runnable f36538e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: onShowListener.java */
        /* loaded from: classes6.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            private EditText f36540a = null;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewGroup f36541b;

            a(ViewGroup viewGroup) {
                this.f36541b = viewGroup;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ boolean d(EditText editText, FrameLayout frameLayout, TextView textView, int i4, KeyEvent keyEvent) {
                if (i4 == 6) {
                    UiUtil.hideKeyboardFrom(((ChooserDialog) f.this.f36526a.get()).f36492j, editText);
                    ((ChooserDialog) f.this.f36526a.get()).k(editText.getText().toString());
                    frameLayout.setVisibility(8);
                    frameLayout.clearFocus();
                    if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                        Button button = ((ChooserDialog) f.this.f36526a.get()).f36479c0;
                        button.setFocusable(true);
                        button.requestFocus();
                        ((ChooserDialog) f.this.f36526a.get()).f36496l.setFocusable(true);
                    }
                    return true;
                }
                return false;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(EditText editText, FrameLayout frameLayout, View view) {
                UiUtil.hideKeyboardFrom(((ChooserDialog) f.this.f36526a.get()).f36492j, editText);
                frameLayout.setVisibility(8);
                frameLayout.clearFocus();
                if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                    Button button = ((ChooserDialog) f.this.f36526a.get()).f36479c0;
                    button.setFocusable(true);
                    button.requestFocus();
                    ((ChooserDialog) f.this.f36526a.get()).f36496l.setFocusable(true);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(EditText editText, FrameLayout frameLayout, View view) {
                UiUtil.hideKeyboardFrom(((ChooserDialog) f.this.f36526a.get()).f36492j, editText);
                ((ChooserDialog) f.this.f36526a.get()).k(editText.getText().toString());
                UiUtil.hideKeyboardFrom(((ChooserDialog) f.this.f36526a.get()).f36492j, editText);
                frameLayout.setVisibility(8);
                frameLayout.clearFocus();
                if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                    Button button = ((ChooserDialog) f.this.f36526a.get()).f36479c0;
                    button.setFocusable(true);
                    button.requestFocus();
                    ((ChooserDialog) f.this.f36526a.get()).f36496l.setFocusable(true);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewGroup.LayoutParams layoutParams;
                FileUtil.NewFolderFilter newFolderFilter;
                c.this.f36538e.run();
                File file = new File(((ChooserDialog) f.this.f36526a.get()).f36490i, "New folder");
                int i4 = 1;
                while (file.exists()) {
                    File file2 = ((ChooserDialog) f.this.f36526a.get()).f36490i;
                    file = new File(file2, "New folder (" + i4 + ')');
                    i4++;
                }
                EditText editText = this.f36540a;
                if (editText != null) {
                    editText.setText(file.getName());
                }
                if (((ChooserDialog) f.this.f36526a.get()).X == null) {
                    Context context = ((ChooserDialog) f.this.f36526a.get()).f36492j;
                    int[] iArr = R.styleable.FileChooser;
                    TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(((ChooserDialog) f.this.f36526a.get()).f36492j, obtainStyledAttributes.getResourceId(R.styleable.FileChooser_fileChooserNewFolderStyle, R.style.FileChooserNewFolderStyle));
                    obtainStyledAttributes.recycle();
                    TypedArray obtainStyledAttributes2 = contextThemeWrapper.obtainStyledAttributes(iArr);
                    try {
                        ((AlertDialog) c.this.f36534a).getWindow().clearFlags(131080);
                        ((AlertDialog) c.this.f36534a).getWindow().setSoftInputMode(obtainStyledAttributes2.getInt(R.styleable.FileChooser_fileChooserNewFolderSoftInputMode, 48) | 4);
                    } catch (NullPointerException e4) {
                        e4.printStackTrace();
                    }
                    final FrameLayout frameLayout = new FrameLayout(((ChooserDialog) f.this.f36526a.get()).f36492j);
                    frameLayout.setBackgroundColor(obtainStyledAttributes2.getColor(R.styleable.FileChooser_fileChooserNewFolderOverlayColor, 1627389951));
                    frameLayout.setScrollContainer(true);
                    if (this.f36541b instanceof FrameLayout) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
                    } else {
                        layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    }
                    this.f36541b.addView(frameLayout, layoutParams);
                    frameLayout.setOnClickListener(null);
                    frameLayout.setVisibility(4);
                    ((ChooserDialog) f.this.f36526a.get()).X = frameLayout;
                    LinearLayout linearLayout = new LinearLayout(((ChooserDialog) f.this.f36526a.get()).f36492j);
                    frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2, 17));
                    frameLayout.setFocusable(false);
                    float f4 = 0.56f;
                    float f5 = obtainStyledAttributes2.getFloat(R.styleable.FileChooser_fileChooserNewFolderWidthWeight, 0.56f);
                    if (f5 > 0.0f) {
                        f4 = f5;
                    }
                    if (f4 > 1.0f) {
                        f4 = 1.0f;
                    }
                    View space = new Space(((ChooserDialog) f.this.f36526a.get()).f36492j);
                    float f6 = (1.0f - f4) / 2.0f;
                    linearLayout.addView(space, new LinearLayout.LayoutParams(0, -2, f6));
                    space.setFocusable(false);
                    LinearLayout linearLayout2 = new LinearLayout(((ChooserDialog) f.this.f36526a.get()).f36492j);
                    linearLayout2.setOrientation(1);
                    linearLayout2.setBackgroundColor(obtainStyledAttributes2.getColor(R.styleable.FileChooser_fileChooserNewFolderBackgroundColor, -1));
                    linearLayout2.setElevation(obtainStyledAttributes2.getInt(R.styleable.FileChooser_fileChooserNewFolderElevation, 25));
                    linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(0, -2, f4));
                    linearLayout2.setFocusable(false);
                    View space2 = new Space(((ChooserDialog) f.this.f36526a.get()).f36492j);
                    linearLayout.addView(space2, new LinearLayout.LayoutParams(0, -2, f6));
                    space2.setFocusable(false);
                    final EditText editText2 = new EditText(((ChooserDialog) f.this.f36526a.get()).f36492j);
                    int color = obtainStyledAttributes2.getColor(R.styleable.FileChooser_fileChooserNewFolderTextColor, c.this.f36535b);
                    editText2.setTextColor(color);
                    editText2.getBackground().mutate().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
                    editText2.setText(file.getName());
                    editText2.setSelectAllOnFocus(true);
                    editText2.setSingleLine(true);
                    editText2.setInputType(524464);
                    InputFilter[] inputFilterArr = new InputFilter[1];
                    if (((ChooserDialog) f.this.f36526a.get()).f36495k0 != null) {
                        newFolderFilter = ((ChooserDialog) f.this.f36526a.get()).f36495k0;
                    } else {
                        newFolderFilter = new FileUtil.NewFolderFilter();
                    }
                    inputFilterArr[0] = newFolderFilter;
                    editText2.setFilters(inputFilterArr);
                    editText2.setGravity(1);
                    editText2.setImeOptions(6);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.setMargins(3, 2, 3, 0);
                    linearLayout2.addView(editText2, layoutParams2);
                    this.f36540a = editText2;
                    FrameLayout frameLayout2 = new FrameLayout(((ChooserDialog) f.this.f36526a.get()).f36492j);
                    linearLayout2.addView(frameLayout2, new LinearLayout.LayoutParams(-1, -2));
                    Button button = new Button(((ChooserDialog) f.this.f36526a.get()).f36492j, null, 16843567);
                    if (((ChooserDialog) f.this.f36526a.get()).L != -1) {
                        button.setText(((ChooserDialog) f.this.f36526a.get()).L);
                    } else if (((ChooserDialog) f.this.f36526a.get()).P != null) {
                        button.setText(((ChooserDialog) f.this.f36526a.get()).P);
                    } else {
                        button.setText(R.string.new_folder_cancel);
                    }
                    button.setTextColor(c.this.f36535b);
                    if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                        button.setBackgroundResource(f.this.f36527b);
                    }
                    frameLayout2.addView(button, new FrameLayout.LayoutParams(-2, -2, GravityCompat.START));
                    Button button2 = new Button(((ChooserDialog) f.this.f36526a.get()).f36492j, null, 16843567);
                    if (((ChooserDialog) f.this.f36526a.get()).M != -1) {
                        button2.setText(((ChooserDialog) f.this.f36526a.get()).M);
                    } else if (((ChooserDialog) f.this.f36526a.get()).Q != null) {
                        button2.setText(((ChooserDialog) f.this.f36526a.get()).Q);
                    } else {
                        button2.setText(R.string.new_folder_ok);
                    }
                    button2.setTextColor(c.this.f36535b);
                    if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                        button2.setBackgroundResource(f.this.f36527b);
                    }
                    frameLayout2.addView(button2, new FrameLayout.LayoutParams(-2, -2, GravityCompat.END));
                    int hashCode = button.hashCode();
                    button.setId(hashCode);
                    button2.setNextFocusLeftId(hashCode);
                    editText2.setNextFocusLeftId(hashCode);
                    editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.obsez.android.lib.filechooser.i
                        @Override // android.widget.TextView.OnEditorActionListener
                        public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
                            boolean d4;
                            d4 = f.c.a.this.d(editText2, frameLayout, textView, i5, keyEvent);
                            return d4;
                        }
                    });
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.obsez.android.lib.filechooser.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            f.c.a.this.e(editText2, frameLayout, view2);
                        }
                    });
                    button2.setOnClickListener(new View.OnClickListener() { // from class: com.obsez.android.lib.filechooser.k
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            f.c.a.this.f(editText2, frameLayout, view2);
                        }
                    });
                    obtainStyledAttributes2.recycle();
                }
                if (((ChooserDialog) f.this.f36526a.get()).X.getVisibility() != 0) {
                    ((ChooserDialog) f.this.f36526a.get()).X.setVisibility(0);
                    if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                        ((ChooserDialog) f.this.f36526a.get()).X.requestFocus();
                        ((ChooserDialog) f.this.f36526a.get()).f36479c0.setFocusable(false);
                        ((ChooserDialog) f.this.f36526a.get()).f36496l.setFocusable(false);
                    }
                    if (((ChooserDialog) f.this.f36526a.get()).G != null && ((ChooserDialog) f.this.f36526a.get()).G.getVisibility() == 0) {
                        ((ChooserDialog) f.this.f36526a.get()).X.setPadding(0, UiUtil.dip2px(32), 0, UiUtil.dip2px(12));
                        return;
                    } else {
                        ((ChooserDialog) f.this.f36526a.get()).X.setPadding(0, UiUtil.dip2px(12), 0, UiUtil.dip2px(12));
                        return;
                    }
                }
                ((ChooserDialog) f.this.f36526a.get()).X.setVisibility(8);
                if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                    ((ChooserDialog) f.this.f36526a.get()).X.clearFocus();
                    ((ChooserDialog) f.this.f36526a.get()).f36479c0.setFocusable(true);
                    ((ChooserDialog) f.this.f36526a.get()).f36496l.setFocusable(true);
                }
            }
        }

        c(DialogInterface dialogInterface, int i4, PorterDuffColorFilter porterDuffColorFilter, Runnable runnable, Runnable runnable2) {
            this.f36534a = dialogInterface;
            this.f36535b = i4;
            this.f36536c = porterDuffColorFilter;
            this.f36537d = runnable;
            this.f36538e = runnable2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Button button, int i4) {
            if (((ChooserDialog) f.this.f36526a.get()).f36493j0 == 1) {
                PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(-2130771968, PorterDuff.Mode.SRC_IN);
                ((ChooserDialog) f.this.f36526a.get()).f36479c0.getCompoundDrawables()[0].setColorFilter(porterDuffColorFilter);
                ((ChooserDialog) f.this.f36526a.get()).f36479c0.setTextColor(-2130771968);
                button.getCompoundDrawables()[0].setColorFilter(porterDuffColorFilter);
                button.setTextColor(-2130771968);
                return;
            }
            ((ChooserDialog) f.this.f36526a.get()).f36479c0.getCompoundDrawables()[0].clearColorFilter();
            ((ChooserDialog) f.this.f36526a.get()).f36479c0.setTextColor(i4);
            button.getCompoundDrawables()[0].clearColorFilter();
            button.setTextColor(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Runnable runnable, final Button button, final int i4, View view) {
            runnable.run();
            int i5 = 0;
            if (((ChooserDialog) f.this.f36526a.get()).f36493j0 == 2) {
                boolean z3 = true;
                for (File file : ((ChooserDialog) f.this.f36526a.get()).f36488h.getSelected()) {
                    ((ChooserDialog) f.this.f36526a.get()).f36497m.onChoosePath(file.getAbsolutePath(), file);
                    if (z3) {
                        try {
                            FileUtil.deleteFileRecursively(file);
                        } catch (IOException e4) {
                            Toast.makeText(((ChooserDialog) f.this.f36526a.get()).f36492j, e4.getMessage(), 1).show();
                            z3 = false;
                        }
                    }
                }
                ((ChooserDialog) f.this.f36526a.get()).f36488h.clearSelected();
                ((ChooserDialog) f.this.f36526a.get()).f36483e0.setVisibility(4);
                ((ChooserDialog) f.this.f36526a.get()).f36493j0 = 0;
                ((ChooserDialog) f.this.f36526a.get()).y();
                return;
            }
            ChooserDialog chooserDialog = (ChooserDialog) f.this.f36526a.get();
            if (((ChooserDialog) f.this.f36526a.get()).f36493j0 != 1) {
                i5 = 1;
            }
            chooserDialog.f36493j0 = i5;
            if (((ChooserDialog) f.this.f36526a.get()).f36480d == null) {
                ((ChooserDialog) f.this.f36526a.get()).f36480d = new Runnable() { // from class: com.obsez.android.lib.filechooser.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.c.this.c(button, i4);
                    }
                };
            }
            ((ChooserDialog) f.this.f36526a.get()).f36480d.run();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewGroup.LayoutParams layoutParams;
            Drawable drawable;
            Drawable drawable2;
            if (((ChooserDialog) f.this.f36526a.get()).X != null && ((ChooserDialog) f.this.f36526a.get()).X.getVisibility() == 0) {
                return;
            }
            if (((ChooserDialog) f.this.f36526a.get()).I == null) {
                ViewGroup viewGroup = (ViewGroup) ((AlertDialog) this.f36534a).findViewById(((ChooserDialog) f.this.f36526a.get()).f36492j.getResources().getIdentifier("contentPanel", "id", ((ChooserDialog) f.this.f36526a.get()).f36492j.getPackageName()));
                if (viewGroup == null) {
                    viewGroup = (ViewGroup) ((AlertDialog) this.f36534a).findViewById(((ChooserDialog) f.this.f36526a.get()).f36492j.getResources().getIdentifier("contentPanel", "id", "android"));
                    if (viewGroup == null) {
                        return;
                    }
                }
                FrameLayout frameLayout = new FrameLayout(((ChooserDialog) f.this.f36526a.get()).f36492j);
                if (viewGroup instanceof LinearLayout) {
                    layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) ((ChooserDialog) f.this.f36526a.get()).f36496l.getLayoutParams();
                    layoutParams2.weight = 1.0f;
                    ((ChooserDialog) f.this.f36526a.get()).f36496l.setLayoutParams(layoutParams2);
                } else {
                    layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
                }
                viewGroup.addView(frameLayout, layoutParams);
                frameLayout.setFocusable(false);
                if (viewGroup instanceof FrameLayout) {
                    ((ChooserDialog) f.this.f36526a.get()).f36496l.bringToFront();
                }
                Button button = new Button(((ChooserDialog) f.this.f36526a.get()).f36492j, null, 16843567);
                if (((ChooserDialog) f.this.f36526a.get()).J != -1) {
                    button.setText(((ChooserDialog) f.this.f36526a.get()).J);
                } else if (((ChooserDialog) f.this.f36526a.get()).N != null) {
                    button.setText(((ChooserDialog) f.this.f36526a.get()).N);
                } else {
                    button.setText(R.string.option_create_folder);
                }
                button.setTextColor(this.f36535b);
                if (((ChooserDialog) f.this.f36526a.get()).S != -1) {
                    drawable = ContextCompat.getDrawable(((ChooserDialog) f.this.f36526a.get()).f36492j, ((ChooserDialog) f.this.f36526a.get()).S);
                } else if (((ChooserDialog) f.this.f36526a.get()).V != null) {
                    drawable = ((ChooserDialog) f.this.f36526a.get()).V;
                } else {
                    drawable = ContextCompat.getDrawable(((ChooserDialog) f.this.f36526a.get()).f36492j, R.drawable.ic_add_24dp);
                }
                if (drawable != null) {
                    drawable.setColorFilter(this.f36536c);
                    button.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                    button.setBackgroundResource(f.this.f36527b);
                }
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2, 8388627);
                ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = UiUtil.dip2px(10);
                frameLayout.addView(button, layoutParams3);
                final Button button2 = new Button(((ChooserDialog) f.this.f36526a.get()).f36492j, null, 16843567);
                if (((ChooserDialog) f.this.f36526a.get()).K != -1) {
                    button2.setText(((ChooserDialog) f.this.f36526a.get()).K);
                } else if (((ChooserDialog) f.this.f36526a.get()).O != null) {
                    button2.setText(((ChooserDialog) f.this.f36526a.get()).O);
                } else {
                    button2.setText(R.string.options_delete);
                }
                button2.setTextColor(this.f36535b);
                if (((ChooserDialog) f.this.f36526a.get()).T != -1) {
                    drawable2 = ContextCompat.getDrawable(((ChooserDialog) f.this.f36526a.get()).f36492j, ((ChooserDialog) f.this.f36526a.get()).T);
                } else if (((ChooserDialog) f.this.f36526a.get()).W != null) {
                    drawable2 = ((ChooserDialog) f.this.f36526a.get()).W;
                } else {
                    drawable2 = ContextCompat.getDrawable(((ChooserDialog) f.this.f36526a.get()).f36492j, R.drawable.ic_delete_24dp);
                }
                if (drawable2 != null) {
                    drawable2.setColorFilter(this.f36536c);
                    button2.setCompoundDrawablesWithIntrinsicBounds(drawable2, (Drawable) null, (Drawable) null, (Drawable) null);
                }
                if (((ChooserDialog) f.this.f36526a.get()).f36477b0) {
                    button2.setBackgroundResource(f.this.f36527b);
                }
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2, 8388629);
                ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = UiUtil.dip2px(10);
                frameLayout.addView(button2, layoutParams4);
                ((ChooserDialog) f.this.f36526a.get()).I = frameLayout;
                this.f36537d.run();
                button.setOnClickListener(new a(viewGroup));
                final Runnable runnable = this.f36538e;
                final int i4 = this.f36535b;
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.obsez.android.lib.filechooser.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        f.c.this.d(runnable, button2, i4, view2);
                    }
                });
            } else if (((ChooserDialog) f.this.f36526a.get()).I.getVisibility() == 0) {
                this.f36538e.run();
            } else {
                this.f36537d.run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ChooserDialog chooserDialog, int i4) {
        this.f36526a = new WeakReference<>(chooserDialog);
        this.f36527b = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(b bVar, View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        int i12 = i11 - i9;
        if (view.getHeight() != i12) {
            int height = i12 - view.getHeight();
            int listYScroll = UiUtil.getListYScroll(this.f36526a.get().f36496l);
            int i13 = bVar.f36532a;
            if (i13 != listYScroll) {
                height += i13 - listYScroll;
            }
            this.f36526a.get().f36496l.scrollListBy(height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(b bVar) {
        bVar.f36532a = UiUtil.getListYScroll(this.f36526a.get().f36496l);
        this.f36526a.get().I.setVisibility(8);
        if (this.f36526a.get().I.getParent() instanceof FrameLayout) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f36526a.get().f36496l.getLayoutParams();
            marginLayoutParams.bottomMargin = 0;
            this.f36526a.get().f36496l.setLayoutParams(marginLayoutParams);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        Drawable drawable;
        this.f36526a.get().f36479c0 = this.f36526a.get().f36494k.getButton(-3);
        this.f36526a.get().f36481d0 = this.f36526a.get().f36494k.getButton(-2);
        this.f36526a.get().f36483e0 = this.f36526a.get().f36494k.getButton(-1);
        ViewGroup viewGroup = (ViewGroup) this.f36526a.get().f36483e0.getParent();
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.width = -1;
        viewGroup.setLayoutParams(layoutParams);
        viewGroup.removeAllViews();
        ViewGroup.LayoutParams layoutParams2 = this.f36526a.get().f36479c0.getLayoutParams();
        if (viewGroup instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) layoutParams2;
            layoutParams3.weight = 1.0f;
            layoutParams3.width = 0;
        }
        if (this.f36526a.get().D) {
            viewGroup.addView(this.f36526a.get().f36479c0, 0, layoutParams2);
        } else {
            viewGroup.addView(new Space(this.f36526a.get().f36492j), 0, layoutParams2);
        }
        viewGroup.addView(this.f36526a.get().f36481d0, 1);
        viewGroup.addView(this.f36526a.get().f36483e0, 2);
        if (this.f36526a.get().Y) {
            this.f36526a.get().f36483e0.setVisibility(4);
        }
        if (this.f36526a.get().f36477b0) {
            this.f36526a.get().f36479c0.setBackgroundResource(this.f36527b);
            this.f36526a.get().f36481d0.setBackgroundResource(this.f36527b);
            this.f36526a.get().f36483e0.setBackgroundResource(this.f36527b);
        }
        if (this.f36526a.get().D) {
            int currentTextColor = this.f36526a.get().f36479c0.getCurrentTextColor();
            PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(currentTextColor, PorterDuff.Mode.SRC_IN);
            this.f36526a.get().f36479c0.setText("");
            this.f36526a.get().f36479c0.setVisibility(0);
            if (this.f36526a.get().R != -1) {
                drawable = ContextCompat.getDrawable(this.f36526a.get().f36492j, this.f36526a.get().R);
            } else if (this.f36526a.get().U != null) {
                drawable = this.f36526a.get().U;
            } else {
                drawable = ContextCompat.getDrawable(this.f36526a.get().f36492j, R.drawable.ic_menu_24dp);
            }
            if (drawable != null) {
                drawable.setColorFilter(porterDuffColorFilter);
                this.f36526a.get().f36479c0.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            final b bVar = new b();
            this.f36526a.get().f36496l.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.obsez.android.lib.filechooser.d
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    f.this.e(bVar, view, i4, i5, i6, i7, i8, i9, i10, i11);
                }
            });
            this.f36526a.get().f36479c0.setOnClickListener(new c(dialogInterface, currentTextColor, porterDuffColorFilter, new a(bVar), new Runnable() { // from class: com.obsez.android.lib.filechooser.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.f(bVar);
                }
            }));
        }
    }
}
