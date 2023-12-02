package com.arlosoft.macrodroid.triggers.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.arlosoft.macrodroid.MacroDroidDialogBaseActivity;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.activities.selecticon.IconSelectActivity;
import com.arlosoft.macrodroid.utils.IconUtils;

/* loaded from: classes3.dex */
public class WidgetConfigureActivity extends MacroDroidDialogBaseActivity {
    public static final String ITEM_TYPE_EXTRA = "item_type";
    public static final String SHOW_FADED_IMAGE_EXTRA = "show_faded_image";

    /* renamed from: d  reason: collision with root package name */
    private ImageView f14540d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f14541e;

    /* renamed from: f  reason: collision with root package name */
    private int f14542f;

    /* renamed from: g  reason: collision with root package name */
    private String f14543g;

    /* renamed from: h  reason: collision with root package name */
    private String f14544h;

    /* renamed from: i  reason: collision with root package name */
    private Uri f14545i;

    /* renamed from: j  reason: collision with root package name */
    private int f14546j;

    /* renamed from: k  reason: collision with root package name */
    private String f14547k;

    /* renamed from: l  reason: collision with root package name */
    private String f14548l;

    /* renamed from: m  reason: collision with root package name */
    private CheckBox f14549m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f14550n;

    /* renamed from: o  reason: collision with root package name */
    private Macro f14551o;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        long j4;
        Intent intent = new Intent(this, IconSelectActivity.class);
        intent.putExtra(IconSelectActivity.EXTRA_DEFAULT_EXTRA_TEXT_ICON, this.f14547k);
        Macro macro = this.f14551o;
        if (macro != null) {
            j4 = macro.getGUID();
        } else {
            j4 = 0;
        }
        intent.putExtra(Constants.EXTRA_MACRO_GUID, j4);
        intent.putExtra(IconSelectActivity.EXTRA_SHOW_TEXT_ICON, true);
        startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(CompoundButton compoundButton, boolean z3) {
        float f4;
        this.f14550n = z3;
        ImageView imageView = this.f14540d;
        if (z3) {
            f4 = 0.25f;
        } else {
            f4 = 1.0f;
        }
        imageView.setAlpha(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        Intent intent = new Intent();
        intent.putExtra(Util.DRAWABLE_ID_EXTRA, this.f14542f);
        intent.putExtra(Util.DRAWABLE_NAME_EXTRA, this.f14543g);
        intent.putExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA, this.f14544h);
        intent.putExtra(Util.FADED_IMAGE_EXTRA, this.f14550n);
        intent.putExtra(Util.ICON_TEXT_EXTRA, this.f14547k);
        intent.setData(this.f14545i);
        intent.putExtra(Util.WIDGET_TEXT_EXTRA, this.f14541e.getText().toString());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(MagicText.MagicTextListener magicTextListener, Macro macro, View view) {
        MagicText.displaySelectionDialog(this, magicTextListener, macro, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i5 != 0) {
            this.f14542f = intent.getIntExtra(Util.DRAWABLE_ID_EXTRA, 0);
            this.f14543g = intent.getStringExtra(Util.DRAWABLE_NAME_EXTRA);
            this.f14544h = intent.getStringExtra(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.f14545i = intent.getData();
            String stringExtra = intent.getStringExtra(Util.ICON_TEXT_EXTRA);
            this.f14547k = stringExtra;
            if (stringExtra != null) {
                stringExtra = MagicText.replaceMagicText(this, stringExtra, null, this.f14551o);
            }
            IconUtils.setImageOnImageView(this, this.f14540d, this.f14543g, this.f14544h, this.f14542f, this.f14545i, stringExtra);
        }
    }

    @Override // com.arlosoft.macrodroid.MacroDroidDialogBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        float f4;
        super.onCreate(bundle);
        int i4 = 0;
        if (getIntent().getIntExtra(ITEM_TYPE_EXTRA, 0) == 1) {
            setTheme(R.style.Theme_App_Dialog_Action);
        }
        setContentView(R.layout.widget_configure);
        setTitle(R.string.configure_widget_button);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setAttributes(attributes);
        this.f14549m = (CheckBox) findViewById(R.id.faded_checkbox);
        this.f14540d = (ImageView) findViewById(R.id.widget_configure_preview_image);
        this.f14551o = null;
        if (bundle != null) {
            this.f14546j = bundle.getInt("resourceId", 0);
            this.f14548l = bundle.getString("text");
            this.f14543g = bundle.getString(Util.DRAWABLE_NAME_EXTRA);
            this.f14550n = bundle.getBoolean(Util.FADED_IMAGE_EXTRA);
            this.f14544h = bundle.getString(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.f14547k = bundle.getString(Util.ICON_TEXT_EXTRA);
            String string = bundle.getString(Util.DRAWABLE_URI_EXTRA);
            if (string != null) {
                this.f14545i = Uri.parse(string);
            }
            this.f14551o = MacroStore.getInstance().getMacroById(bundle.getInt("MacroId"));
        } else {
            this.f14546j = getIntent().getExtras().getInt(Util.DRAWABLE_ID_EXTRA, 0);
            this.f14548l = getIntent().getExtras().getString(Util.WIDGET_TEXT_EXTRA);
            this.f14543g = getIntent().getExtras().getString(Util.DRAWABLE_NAME_EXTRA);
            this.f14550n = getIntent().getExtras().getBoolean(Util.FADED_IMAGE_EXTRA);
            this.f14544h = getIntent().getExtras().getString(Util.DRAWABLE_PACKAGE_NAME_EXTRA);
            this.f14547k = getIntent().getExtras().getString(Util.ICON_TEXT_EXTRA);
            String string2 = getIntent().getExtras().getString(Util.DRAWABLE_URI_EXTRA);
            this.f14551o = MacroStore.getInstance().getMacroById(getIntent().getExtras().getInt("MacroId"));
            if (string2 != null) {
                this.f14545i = Uri.parse(string2);
            }
            boolean z3 = getIntent().getExtras().getBoolean(SHOW_FADED_IMAGE_EXTRA, false);
            CheckBox checkBox = this.f14549m;
            if (!z3) {
                i4 = 8;
            }
            checkBox.setVisibility(i4);
        }
        ((Button) findViewById(R.id.widget_configure_select_icon_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetConfigureActivity.this.o(view);
            }
        });
        this.f14541e = (TextView) findViewById(R.id.widget_configure_preview_text);
        final EditText editText = (EditText) findViewById(R.id.widget_configure_label);
        String str = this.f14548l;
        if (str != null) {
            this.f14541e.setText(str);
            editText.setText(this.f14548l);
        }
        editText.setSelection(editText.getText().length());
        this.f14549m.setChecked(this.f14550n);
        ImageView imageView = this.f14540d;
        if (this.f14550n) {
            f4 = 0.25f;
        } else {
            f4 = 1.0f;
        }
        imageView.setAlpha(f4);
        this.f14549m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.triggers.activities.b0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                WidgetConfigureActivity.this.p(compoundButton, z4);
            }
        });
        String str2 = this.f14547k;
        if (str2 != null) {
            str2 = MagicText.replaceMagicText(this, str2, null, this.f14551o);
        }
        IconUtils.setImageOnImageView(this, this.f14540d, this.f14543g, this.f14544h, this.f14542f, this.f14545i, str2);
        editText.addTextChangedListener(new a());
        ((Button) findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetConfigureActivity.this.q(view);
            }
        });
        ((Button) findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetConfigureActivity.this.r(view);
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.triggers.activities.e0
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                WidgetConfigureActivity.s(editText, magicTextPair);
            }
        };
        final Macro macro = this.f14551o;
        ((Button) findViewById(R.id.special_text_button)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.activities.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetConfigureActivity.this.t(magicTextListener, macro, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        int i4;
        bundle.putInt("resourceId", this.f14546j);
        bundle.putString(Util.DRAWABLE_PACKAGE_NAME_EXTRA, this.f14544h);
        bundle.putString(Util.DRAWABLE_NAME_EXTRA, this.f14543g);
        bundle.putString("text", this.f14548l);
        bundle.putBoolean(Util.FADED_IMAGE_EXTRA, this.f14550n);
        bundle.putString(Util.ICON_TEXT_EXTRA, this.f14547k);
        Macro macro = this.f14551o;
        if (macro != null) {
            i4 = macro.getId();
        } else {
            i4 = 0;
        }
        bundle.putInt("MacroId", i4);
        Uri uri = this.f14545i;
        if (uri != null) {
            bundle.putString(Util.DRAWABLE_URI_EXTRA, uri.toString());
        }
        super.onSaveInstanceState(bundle);
    }

    /* loaded from: classes3.dex */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            WidgetConfigureActivity.this.f14541e.setText(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
