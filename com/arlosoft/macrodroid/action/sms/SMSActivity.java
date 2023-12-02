package com.arlosoft.macrodroid.action.sms;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.sms.SMSActivity;
import com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class SMSActivity extends MacroDroidBaseActivity {
    public static final String ADD_TO_MESSAGE_LOG_EXTRA = "AddToMessageLogExtra";
    public static final String CONTACT_EXTRA = "ContactExtra";
    public static final String MESSAGE_EXTRA = "MessageExtra";
    public static final String NUMBER = "Number";
    public static final String PRE_POPULATE_EXTRA = "PrePopulate";

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Trigger> f4982f;

    /* renamed from: g  reason: collision with root package name */
    private EditText f4983g;

    /* renamed from: h  reason: collision with root package name */
    private CheckBox f4984h;

    /* renamed from: i  reason: collision with root package name */
    private CheckBox f4985i;

    /* renamed from: j  reason: collision with root package name */
    private MenuItem f4986j;

    /* renamed from: k  reason: collision with root package name */
    private EditText f4987k;

    /* renamed from: l  reason: collision with root package name */
    private Macro f4988l;

    /* renamed from: m  reason: collision with root package name */
    private MagicText.MagicTextListener f4989m;

    /* renamed from: n  reason: collision with root package name */
    private int f4990n;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(this.f4987k.getSelectionStart(), 0);
        int max2 = Math.max(this.f4987k.getSelectionEnd(), 0);
        Editable text = this.f4987k.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(this, magicTextListener, this.f4988l, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        MagicText.displaySelectionDialog(this, this.f4989m, this.f4988l, R.style.Theme_App_Dialog_Action_SmallText, IteratorType.NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(this.f4983g.getSelectionStart(), 0);
        int max2 = Math.max(this.f4983g.getSelectionEnd(), 0);
        Editable text = this.f4983g.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(View view) {
        Intent intent = new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.dir/phone_v2");
        startActivityForResult(intent, 99);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (i4 == 99 && i5 == -1) {
            Cursor query = getContentResolver().query(intent.getData(), new String[]{"data1"}, null, null, null);
            if (query != null && query.getCount() > 0) {
                query.moveToFirst();
                this.f4987k.setText(String.valueOf(query.getString(query.getColumnIndex("data1"))));
            }
            query.close();
        }
    }

    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String string;
        String string2;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        int subscriptionId;
        int simSlotIndex;
        CharSequence displayName;
        CharSequence carrierName;
        int subscriptionId2;
        int subscriptionId3;
        super.onCreate(bundle);
        setContentView(R.layout.send_sms_action);
        setTitle(R.string.action_send_sms);
        this.f4984h = (CheckBox) findViewById(R.id.send_sms_add_to_message_log_checkbox);
        this.f4985i = (CheckBox) findViewById(R.id.send_sms_pre_populate);
        this.f4984h.setVisibility(8);
        if (bundle != null) {
            this.f4982f = bundle.getParcelableArrayList("Trigger");
            string = bundle.getString("Message");
            this.f4984h.setChecked(bundle.getBoolean(ADD_TO_MESSAGE_LOG_EXTRA));
            this.f4985i.setChecked(bundle.getBoolean(PRE_POPULATE_EXTRA));
            string2 = bundle.getString(NUMBER);
            this.f4988l = (Macro) bundle.getParcelable("Macro");
        } else {
            this.f4982f = getIntent().getExtras().getParcelableArrayList("Trigger");
            string = getIntent().getExtras().getString("Message");
            this.f4984h.setChecked(getIntent().getExtras().getBoolean(ADD_TO_MESSAGE_LOG_EXTRA));
            this.f4985i.setChecked(getIntent().getExtras().getBoolean(PRE_POPULATE_EXTRA));
            string2 = getIntent().getExtras().getString(NUMBER);
            this.f4988l = (Macro) getIntent().getExtras().getParcelable("Macro");
        }
        this.f4983g = (EditText) findViewById(R.id.smsText);
        EditText editText = (EditText) findViewById(R.id.send_sms_phone_number);
        this.f4987k = editText;
        editText.setText(string2);
        this.f4983g.setText(string);
        if (Build.VERSION.SDK_INT >= 22) {
            activeSubscriptionInfoList = ((SubscriptionManager) getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
            SystemLog.logVerbose("Multi sim subscriptionInfos = " + activeSubscriptionInfoList);
            if (activeSubscriptionInfoList != null && activeSubscriptionInfoList.size() > 1) {
                Spinner spinner = (Spinner) findViewById(R.id.sim_selection_spinner);
                ArrayList arrayList = new ArrayList();
                int intExtra = getIntent().getIntExtra(Constants.SIM_ID, 0);
                int i4 = 0;
                int i5 = 0;
                for (SubscriptionInfo subscriptionInfo : activeSubscriptionInfoList) {
                    StringBuilder sb = new StringBuilder();
                    simSlotIndex = subscriptionInfo.getSimSlotIndex();
                    sb.append(simSlotIndex + 1);
                    sb.append(" : ");
                    displayName = subscriptionInfo.getDisplayName();
                    sb.append((Object) displayName);
                    sb.append(" - ");
                    carrierName = subscriptionInfo.getCarrierName();
                    sb.append((Object) carrierName);
                    arrayList.add(sb.toString());
                    subscriptionId2 = subscriptionInfo.getSubscriptionId();
                    if (subscriptionId2 == intExtra) {
                        subscriptionId3 = subscriptionInfo.getSubscriptionId();
                        this.f4990n = subscriptionId3;
                        i4 = i5;
                    }
                    i5++;
                }
                if (intExtra == 0) {
                    subscriptionId = ((SubscriptionInfo) activeSubscriptionInfoList.get(0)).getSubscriptionId();
                    this.f4990n = subscriptionId;
                }
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(this, (int) R.layout.simple_spinner_dropdown_item, arrayList));
                spinner.setSelection(i4);
                spinner.setOnItemSelectedListener(new a(activeSubscriptionInfoList));
            } else {
                findViewById(R.id.sim_selection_layout).setVisibility(8);
            }
        }
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: t.c
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SMSActivity.this.u(magicTextPair);
            }
        };
        ((Button) findViewById(R.id.send_sms_magic_text_button_number)).setOnClickListener(new View.OnClickListener() { // from class: t.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SMSActivity.this.v(magicTextListener, view);
            }
        });
        ((Button) findViewById(R.id.send_sms_magic_text_button)).setOnClickListener(new View.OnClickListener() { // from class: t.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SMSActivity.this.w(view);
            }
        });
        b bVar = new b();
        this.f4987k.addTextChangedListener(bVar);
        this.f4983g.addTextChangedListener(bVar);
        this.f4989m = new MagicText.MagicTextListener() { // from class: t.a
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                SMSActivity.this.x(magicTextPair);
            }
        };
        try {
            ((ImageButton) findViewById(R.id.send_sms_select_contact)).setOnClickListener(new View.OnClickListener() { // from class: t.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SMSActivity.this.y(view);
                }
            });
        } catch (Exception unused) {
            ToastCompat.makeText(getApplicationContext(), (int) R.string.no_app_available, 0).show();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z3;
        int i4;
        getMenuInflater().inflate(R.menu.sms_activity, menu);
        MenuItem findItem = menu.findItem(R.id.menu_accept);
        this.f4986j = findItem;
        if (this.f4987k.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        findItem.setEnabled(z3);
        Drawable icon = this.f4986j.getIcon();
        if (this.f4986j.isEnabled()) {
            i4 = 255;
        } else {
            i4 = 96;
        }
        icon.setAlpha(i4);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != 16908332) {
            if (itemId == R.id.menu_accept) {
                Contact contact = new Contact(Contact.HARDWIRED_NUMBER_CONTACT_ID, Contact.getHardwiredContactName(), Contact.HARDWIRED_NUMBER_CONTACT_ID);
                String obj = this.f4983g.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(CONTACT_EXTRA, contact);
                intent.putExtra(MESSAGE_EXTRA, obj);
                intent.putExtra(ADD_TO_MESSAGE_LOG_EXTRA, this.f4984h.isChecked());
                intent.putExtra(PRE_POPULATE_EXTRA, this.f4985i.isChecked());
                intent.putExtra(NUMBER, this.f4987k.getText().toString());
                intent.putExtra(Constants.SIM_ID, this.f4990n);
                setResult(-1, intent);
                finish();
                return true;
            }
            return true;
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.app.base.MacroDroidBaseActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        String obj = this.f4983g.getText().toString();
        bundle.putParcelableArrayList("Trigger", this.f4982f);
        bundle.putString("Message", obj);
        bundle.putBoolean(ADD_TO_MESSAGE_LOG_EXTRA, this.f4984h.isChecked());
        bundle.putBoolean(PRE_POPULATE_EXTRA, this.f4985i.isChecked());
        bundle.putString(NUMBER, this.f4987k.getText().toString());
        bundle.putParcelable("Macro", this.f4988l);
        super.onSaveInstanceState(bundle);
    }

    /* loaded from: classes2.dex */
    class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f4991a;

        a(List list) {
            this.f4991a = list;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        @SuppressLint({"NewApi"})
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            int subscriptionId;
            SMSActivity sMSActivity = SMSActivity.this;
            subscriptionId = ((SubscriptionInfo) this.f4991a.get(i4)).getSubscriptionId();
            sMSActivity.f4990n = subscriptionId;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes2.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            int i4;
            if (SMSActivity.this.f4986j != null) {
                MenuItem menuItem = SMSActivity.this.f4986j;
                if (SMSActivity.this.f4987k.length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                menuItem.setEnabled(z3);
                Drawable icon = SMSActivity.this.f4986j.getIcon();
                if (SMSActivity.this.f4986j.isEnabled()) {
                    i4 = 255;
                } else {
                    i4 = 96;
                }
                icon.setAlpha(i4);
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
