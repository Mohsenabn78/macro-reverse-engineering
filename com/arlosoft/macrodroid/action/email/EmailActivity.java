package com.arlosoft.macrodroid.action.email;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.PauseAction;
import com.arlosoft.macrodroid.action.SendEmailAction;
import com.arlosoft.macrodroid.action.email.EmailActivity;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.PreferencesActivity;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EmailActivity extends MacroDroidBaseActivity {
    public static final String ADDRESS_EXTRA = "Address";
    public static final String ATTACH_SYSTEM_LOG_EXTRA = "AttachSystemLog";
    public static final String ATTACH_USER_LOG_EXTRA = "AttachUserLog";
    public static final String BODY_EXTRA = "Body";
    public static final String EXTRA_BLOCK_NEXT_ACTIONS = "block_next_actions";
    public static final String EXTRA_DICTIONARY_KEYS = "dictionary_keys";
    public static final String EXTRA_VARIABLE_EXTRA = "Variable";
    public static final String FROM_EXTRA = "From";
    public static final String HIDE_MESSAGE_TEXT_EXTRA = "HideMessageText";
    public static final String HTML_MODE_ENABLED_EXTRA = "HtmlMode";
    public static final String SENDING_ATTACHMENT_EXTRA = "SendingAttachment";
    public static final String SMTP_MODE_EXTRA = "SmtpMode";
    public static final String SUBJECT_EXTRA = "Subject";

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Trigger> f3423f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f3424g;

    /* renamed from: h  reason: collision with root package name */
    private EditText f3425h;

    /* renamed from: i  reason: collision with root package name */
    private EditText f3426i;

    /* renamed from: j  reason: collision with root package name */
    private EditText f3427j;

    /* renamed from: k  reason: collision with root package name */
    private CheckBox f3428k;

    /* renamed from: l  reason: collision with root package name */
    private Spinner f3429l;

    /* renamed from: m  reason: collision with root package name */
    private Button f3430m;

    /* renamed from: n  reason: collision with root package name */
    private MenuItem f3431n;

    /* renamed from: o  reason: collision with root package name */
    private Macro f3432o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3433p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3434q;

    /* renamed from: r  reason: collision with root package name */
    private CheckBox f3435r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f3436s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f3437t;

    /* renamed from: u  reason: collision with root package name */
    boolean f3438u;

    /* renamed from: v  reason: collision with root package name */
    private MagicText.MagicTextListener f3439v;

    /* renamed from: w  reason: collision with root package name */
    private MacroDroidVariable f3440w = null;

    /* renamed from: x  reason: collision with root package name */
    private DictionaryKeys f3441x = null;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SendEmailAction f3442a;

        /* renamed from: com.arlosoft.macrodroid.action.email.EmailActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0083a implements VariablesHelper.VariableCreatedListener {
            C0083a() {
            }

            @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
            public void variableCreated(MacroDroidVariable macroDroidVariable) {
                EmailActivity.this.f3440w = macroDroidVariable;
                EmailActivity.this.f3441x = null;
                a aVar = a.this;
                EmailActivity.this.t(aVar.f3442a);
            }
        }

        a(SendEmailAction sendEmailAction) {
            this.f3442a = sendEmailAction;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EmailActivity emailActivity = EmailActivity.this;
            VariablesHelper.createNewVariable(emailActivity, emailActivity.f3429l, this.f3442a, R.style.Theme_App_Dialog_Action, 0, true, false, new C0083a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements VariableHelper.VariableSelectedListener {
        c() {
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void customItemSelected(int i4, @NonNull String str) {
            EmailActivity.this.f3440w = null;
            EmailActivity.this.f3441x = null;
        }

        @Override // com.arlosoft.macrodroid.variables.VariableHelper.VariableSelectedListener
        public void variableSelected(@NonNull MacroDroidVariable macroDroidVariable, @Nullable List<String> list) {
            DictionaryKeys dictionaryKeys;
            EmailActivity.this.f3440w = macroDroidVariable;
            EmailActivity emailActivity = EmailActivity.this;
            if (list != null) {
                dictionaryKeys = new DictionaryKeys(list);
            } else {
                dictionaryKeys = null;
            }
            emailActivity.f3441x = dictionaryKeys;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(SendEmailAction sendEmailAction) {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(getString(R.string.none));
        Spinner spinner = this.f3429l;
        Macro macro = this.f3432o;
        MacroDroidVariable macroDroidVariable = this.f3440w;
        if (macroDroidVariable != null) {
            str = macroDroidVariable.getName();
        } else {
            str = null;
        }
        VariableHelper.configureBooleanVarSpinner(this, R.style.Theme_App_Dialog_Action, sendEmailAction, spinner, macro, false, arrayList, str, "", true, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(View view) {
        Intent intent = new Intent(this, PreferencesActivity.class);
        intent.putExtra(PreferencesActivity.EXTRA_SHORTCUT, 2);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(MagicText.MagicTextPair magicTextPair) {
        EditText editText;
        if (this.f3424g.hasFocus()) {
            editText = this.f3424g;
        } else if (this.f3425h.hasFocus()) {
            editText = this.f3425h;
        } else if (this.f3426i.hasFocus()) {
            editText = this.f3426i;
        } else if (this.f3427j.hasFocus()) {
            editText = this.f3427j;
        } else {
            editText = null;
        }
        if (editText != null) {
            int max = Math.max(editText.getSelectionStart(), 0);
            int max2 = Math.max(editText.getSelectionEnd(), 0);
            Editable text = editText.getText();
            int min = Math.min(max, max2);
            int max3 = Math.max(max, max2);
            String str = magicTextPair.magicText;
            text.replace(min, max3, str, 0, str.length());
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        String string3;
        String string4;
        int i4;
        int i5;
        int i6;
        int i7;
        super.onCreate(bundle);
        setContentView(R.layout.send_email_action);
        setTitle(R.string.action_send_email);
        if (bundle != null) {
            this.f3423f = bundle.getParcelableArrayList("Trigger");
            string = bundle.getString("Subject");
            string2 = bundle.getString("Body");
            string3 = bundle.getString(ADDRESS_EXTRA);
            string4 = bundle.getString("From");
            this.f3436s = bundle.getBoolean(ATTACH_SYSTEM_LOG_EXTRA);
            this.f3437t = bundle.getBoolean("AttachUserLog");
            this.f3432o = (Macro) bundle.getParcelable("Macro");
            this.f3433p = bundle.getBoolean(SMTP_MODE_EXTRA);
            this.f3434q = bundle.getBoolean(HTML_MODE_ENABLED_EXTRA);
            this.f3438u = bundle.getBoolean(HIDE_MESSAGE_TEXT_EXTRA);
        } else {
            this.f3423f = getIntent().getExtras().getParcelableArrayList("Trigger");
            string = getIntent().getExtras().getString("Subject");
            string2 = getIntent().getExtras().getString("Body");
            string3 = getIntent().getExtras().getString(ADDRESS_EXTRA);
            string4 = getIntent().getExtras().getString("From");
            this.f3436s = getIntent().getExtras().getBoolean(ATTACH_SYSTEM_LOG_EXTRA);
            this.f3437t = getIntent().getExtras().getBoolean("AttachUserLog");
            this.f3432o = (Macro) getIntent().getExtras().getParcelable("Macro");
            this.f3433p = getIntent().getExtras().getBoolean(SMTP_MODE_EXTRA);
            this.f3434q = getIntent().getExtras().getBoolean(HTML_MODE_ENABLED_EXTRA);
            this.f3438u = getIntent().getExtras().getBoolean(HIDE_MESSAGE_TEXT_EXTRA);
        }
        int i8 = 0;
        boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_BLOCK_NEXT_ACTIONS, false);
        this.f3440w = (MacroDroidVariable) getIntent().getParcelableExtra("Variable");
        this.f3441x = (DictionaryKeys) getIntent().getParcelableExtra(PauseAction.DICTIONARY_KEYS_EXTRA);
        SendEmailAction sendEmailAction = (SendEmailAction) getIntent().getParcelableExtra("selectable_item");
        if (sendEmailAction != null) {
            sendEmailAction.setMacro(this.f3432o);
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.wait_to_complete_options);
        View findViewById = findViewById(R.id.fromEmailAddressLayout);
        this.f3428k = (CheckBox) findViewById(R.id.wait_to_complete_checkbox);
        if (this.f3433p) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        findViewById.setVisibility(i4);
        View findViewById2 = findViewById(R.id.configure_smtp_server);
        this.f3435r = (CheckBox) findViewById(R.id.html_check_box);
        this.f3429l = (Spinner) findViewById(R.id.booleanVariableSpinner);
        this.f3430m = (Button) findViewById(R.id.addVariableButton);
        if (this.f3433p) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        findViewById2.setVisibility(i5);
        CheckBox checkBox = this.f3435r;
        if (this.f3433p) {
            i6 = 0;
        } else {
            i6 = 8;
        }
        checkBox.setVisibility(i6);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: r.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailActivity.this.u(view);
            }
        });
        if (sendEmailAction != null) {
            i7 = 0;
        } else {
            i7 = 8;
        }
        viewGroup.setVisibility(i7);
        this.f3435r.setChecked(this.f3434q);
        EditText editText = (EditText) findViewById(R.id.fromAddress);
        this.f3427j = editText;
        editText.setText(string4);
        EditText editText2 = (EditText) findViewById(R.id.body);
        this.f3424g = editText2;
        editText2.setText(string2);
        EditText editText3 = this.f3424g;
        if (this.f3438u) {
            i8 = 8;
        }
        editText3.setVisibility(i8);
        EditText editText4 = (EditText) findViewById(R.id.subject);
        this.f3425h = editText4;
        editText4.setText(string);
        EditText editText5 = (EditText) findViewById(R.id.toAddress);
        this.f3426i = editText5;
        editText5.setText(string3);
        this.f3428k.setChecked(booleanExtra);
        if (sendEmailAction != null) {
            this.f3430m.setOnClickListener(new a(sendEmailAction));
        }
        if (sendEmailAction != null) {
            t(sendEmailAction);
        }
        this.f3426i.addTextChangedListener(new b());
        this.f3439v = new MagicText.MagicTextListener() { // from class: r.b
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                EmailActivity.this.v(magicTextPair);
            }
        };
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z3;
        int i4;
        getMenuInflater().inflate(R.menu.compose_email_menu, menu);
        MenuItem findItem = menu.findItem(R.id.menu_accept);
        this.f3431n = findItem;
        if (this.f3426i.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        findItem.setEnabled(z3);
        Drawable icon = this.f3431n.getIcon();
        if (this.f3431n.isEnabled()) {
            i4 = 255;
        } else {
            i4 = 96;
        }
        icon.setAlpha(i4);
        menu.findItem(R.id.menu_attach_system_log).setChecked(this.f3436s);
        menu.findItem(R.id.menu_attach_user_log).setChecked(this.f3437t);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            case R.id.menu_accept /* 2131363373 */:
                String obj = this.f3427j.getText().toString();
                String obj2 = this.f3426i.getText().toString();
                String obj3 = this.f3424g.getText().toString();
                String obj4 = this.f3425h.getText().toString();
                boolean isChecked = this.f3435r.isChecked();
                Intent intent = new Intent();
                intent.putExtra("From", obj);
                intent.putExtra(ADDRESS_EXTRA, obj2);
                intent.putExtra("Body", obj3);
                intent.putExtra("Subject", obj4);
                intent.putExtra("AttachUserLog", this.f3437t);
                intent.putExtra(ATTACH_SYSTEM_LOG_EXTRA, this.f3436s);
                intent.putExtra(HTML_MODE_ENABLED_EXTRA, isChecked);
                intent.putExtra("Variable", this.f3440w);
                intent.putExtra("dictionary_keys", this.f3441x);
                intent.putExtra(EXTRA_BLOCK_NEXT_ACTIONS, this.f3428k.isChecked());
                setResult(-1, intent);
                finish();
                return true;
            case R.id.menu_attach_system_log /* 2131363377 */:
                boolean z3 = !this.f3436s;
                this.f3436s = z3;
                menuItem.setChecked(z3);
                if (this.f3436s) {
                    this.f3437t = false;
                }
                return true;
            case R.id.menu_attach_user_log /* 2131363378 */:
                boolean z4 = !this.f3437t;
                this.f3437t = z4;
                menuItem.setChecked(z4);
                if (this.f3437t) {
                    this.f3436s = false;
                }
                return true;
            case R.id.menu_special_text /* 2131363437 */:
                MagicText.displaySelectionDialog(this, this.f3439v, this.f3432o, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(R.id.menu_attach_system_log).setChecked(this.f3436s);
        menu.findItem(R.id.menu_attach_user_log).setChecked(this.f3437t);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelableArrayList("Trigger", this.f3423f);
        bundle.putString("From", this.f3427j.getText().toString());
        bundle.putString("Body", this.f3424g.getText().toString());
        bundle.putString("Subject", this.f3425h.getText().toString());
        bundle.putString(ADDRESS_EXTRA, this.f3426i.getText().toString());
        bundle.putBoolean(ATTACH_SYSTEM_LOG_EXTRA, this.f3436s);
        bundle.putBoolean("AttachUserLog", this.f3437t);
        bundle.putBoolean(SMTP_MODE_EXTRA, this.f3433p);
        bundle.putParcelable("Macro", this.f3432o);
        bundle.putBoolean(HTML_MODE_ENABLED_EXTRA, this.f3434q);
        bundle.putBoolean(HIDE_MESSAGE_TEXT_EXTRA, this.f3438u);
        bundle.putParcelable("Variable", this.f3440w);
        bundle.putParcelable("dictionary_keys", this.f3441x);
        bundle.putBoolean(EXTRA_BLOCK_NEXT_ACTIONS, this.f3428k.isChecked());
        super.onSaveInstanceState(bundle);
    }

    /* loaded from: classes2.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (EmailActivity.this.f3431n != null) {
                if (editable.length() > 0) {
                    EmailActivity.this.f3431n.setEnabled(true);
                    EmailActivity.this.f3431n.getIcon().setAlpha(255);
                    return;
                }
                EmailActivity.this.f3431n.setEnabled(false);
                EmailActivity.this.f3431n.getIcon().setAlpha(96);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
