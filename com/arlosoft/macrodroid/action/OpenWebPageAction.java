package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.OpenWebPageActionInfo;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariables;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import java.io.IOException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import me.drakeet.support.toast.ToastCompat;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public class OpenWebPageAction extends Action implements HasVariables, BlockingAction, SupportsMagicText {
    public static final Parcelable.Creator<OpenWebPageAction> CREATOR = new d();
    private X509TrustManager TRUST_ALL_CERTS;
    private boolean allowAnyCertificate;
    private boolean blockNextAction;
    private boolean m_disableUrlEncode;
    private boolean m_httpGet;
    private String m_urlToOpen;
    private MacroDroidVariable m_variableSuccessResponse;
    private MacroDroidVariable m_variableToSaveResponse;
    private transient PowerManager.WakeLock wakelock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements HostnameVerifier {
        b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class d implements Parcelable.Creator<OpenWebPageAction> {
        d() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OpenWebPageAction createFromParcel(Parcel parcel) {
            return new OpenWebPageAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public OpenWebPageAction[] newArray(int i4) {
            return new OpenWebPageAction[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements Interceptor {

        /* renamed from: a  reason: collision with root package name */
        private String f2365a;

        public e(String str, String str2) {
            this.f2365a = Credentials.basic(str, str2);
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().header("Authorization", this.f2365a).build());
        }
    }

    /* synthetic */ OpenWebPageAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void X(final String str, final TriggerContextInfo triggerContextInfo, final int i4, final boolean z3, @NotNull final Stack<Integer> stack, final ResumeMacroInfo resumeMacroInfo, final boolean z4) {
        String str2;
        if (this.wakelock == null) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "macrodroid:OpenWebPageAction");
            this.wakelock = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.wakelock.acquire(30000L);
        MacroDroidVariable macroDroidVariable = this.m_variableToSaveResponse;
        if (macroDroidVariable != null) {
            str2 = macroDroidVariable.getName();
        } else {
            str2 = null;
        }
        final String str3 = str2;
        new Thread(new Runnable() { // from class: com.arlosoft.macrodroid.action.od
            @Override // java.lang.Runnable
            public final void run() {
                OpenWebPageAction.this.i0(str, str3, z4, i4, triggerContextInfo, z3, stack, resumeMacroInfo);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(Activity activity, MagicText.MagicTextListener magicTextListener, View view) {
        MagicText.displaySelectionDialog(activity, magicTextListener, getMacro(), R.style.Theme_App_Dialog_Action_SmallText, isChildOfIterateDictionary());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(Activity activity, Spinner spinner, View view) {
        VariablesHelper.createNewVariable(activity, spinner, this, getDialogTheme(), 0, (VariablesHelper.VariableCreatedListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(Activity activity, Spinner spinner, View view) {
        VariablesHelper.createNewVariable(activity, spinner, this, getDialogTheme(), 2, (VariablesHelper.VariableCreatedListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(Spinner spinner, CheckBox checkBox, Activity activity, CompoundButton compoundButton, boolean z3) {
        if (spinner.getCount() <= 1 && spinner.getItemAtPosition(0).equals(SelectableItem.r(R.string.trigger_variable_no_variables))) {
            checkBox.setChecked(false);
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.trigger_variable_no_variables, 0).show();
            return;
        }
        spinner.setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c0(Spinner spinner, CheckBox checkBox, Activity activity, CompoundButton compoundButton, boolean z3) {
        if (spinner.getCount() <= 1 && spinner.getItemAtPosition(0).equals(SelectableItem.r(R.string.trigger_variable_no_variables))) {
            checkBox.setChecked(false);
            ToastCompat.makeText(activity.getApplicationContext(), (int) R.string.trigger_variable_no_variables, 0).show();
            return;
        }
        spinner.setEnabled(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, Spinner spinner, Spinner spinner2, CompoundButton compoundButton, boolean z3) {
        checkBox.setEnabled(z3);
        checkBox2.setEnabled(z3);
        checkBox3.setEnabled(z3);
        checkBox4.setEnabled(z3);
        if (z3 && this.m_variableToSaveResponse != null) {
            spinner.setEnabled(true);
        } else {
            spinner.setEnabled(false);
        }
        if (z3 && this.m_variableSuccessResponse != null) {
            spinner2.setEnabled(true);
        } else {
            spinner2.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(CheckBox checkBox, EditText editText, CheckBox checkBox2, CheckBox checkBox3, AppCompatDialog appCompatDialog, CheckBox checkBox4, Spinner spinner, CheckBox checkBox5, Spinner spinner2, CheckBox checkBox6, View view) {
        this.m_httpGet = checkBox.isChecked();
        this.m_urlToOpen = editText.getText().toString();
        this.blockNextAction = checkBox2.isChecked();
        this.allowAnyCertificate = checkBox3.isChecked();
        appCompatDialog.cancel();
        if (checkBox4.isChecked()) {
            try {
                this.m_variableToSaveResponse = getVariableByName(spinner.getSelectedItem().toString());
            } catch (Exception unused) {
                this.m_variableToSaveResponse = null;
            }
        } else {
            this.m_variableToSaveResponse = null;
        }
        if (checkBox5.isChecked()) {
            try {
                this.m_variableSuccessResponse = getVariableByName(spinner2.getSelectedItem().toString());
            } catch (Exception unused2) {
                this.m_variableSuccessResponse = null;
            }
        } else {
            this.m_variableSuccessResponse = null;
        }
        this.m_disableUrlEncode = !checkBox6.isChecked();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g0(EditText editText, MagicText.MagicTextPair magicTextPair) {
        int max = Math.max(editText.getSelectionStart(), 0);
        int max2 = Math.max(editText.getSelectionEnd(), 0);
        Editable text = editText.getText();
        int min = Math.min(max, max2);
        int max3 = Math.max(max, max2);
        String str = magicTextPair.magicText;
        text.replace(min, max3, str, 0, str.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(boolean z3, int i4, TriggerContextInfo triggerContextInfo, boolean z4, Stack stack, ResumeMacroInfo resumeMacroInfo) {
        if (this.blockNextAction && !z3) {
            getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z4, stack, resumeMacroInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(15:1|(1:3)(1:78)|4|5|6|7|(12:(6:47|48|50|51|52|(17:56|(1:11)|12|(1:14)|15|16|17|18|19|20|(1:39)(1:24)|(1:28)|(1:32)|34|35|36|37))|18|19|20|(1:22)|39|(2:26|28)|(2:30|32)|34|35|36|37)|9|(0)|12|(0)|15|16|17|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0164, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0165, code lost:
        r6 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077 A[Catch: all -> 0x016c, TryCatch #4 {all -> 0x016c, blocks: (B:7:0x0010, B:10:0x001b, B:11:0x002b, B:18:0x0053, B:20:0x0059, B:22:0x005f, B:25:0x0077, B:26:0x0082, B:28:0x0086, B:29:0x00ab, B:46:0x013c, B:53:0x0168, B:54:0x016b, B:17:0x0032), top: B:79:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086 A[Catch: all -> 0x016c, TryCatch #4 {all -> 0x016c, blocks: (B:7:0x0010, B:10:0x001b, B:11:0x002b, B:18:0x0053, B:20:0x0059, B:22:0x005f, B:25:0x0077, B:26:0x0082, B:28:0x0086, B:29:0x00ab, B:46:0x013c, B:53:0x0168, B:54:0x016b, B:17:0x0032), top: B:79:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce A[Catch: all -> 0x0162, TRY_ENTER, TryCatch #1 {all -> 0x0162, blocks: (B:31:0x00c4, B:34:0x00ce, B:36:0x00d6, B:39:0x0116, B:41:0x011c, B:43:0x012e, B:45:0x0134, B:37:0x00f5), top: B:73:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0116 A[Catch: all -> 0x0162, TryCatch #1 {all -> 0x0162, blocks: (B:31:0x00c4, B:34:0x00ce, B:36:0x00d6, B:39:0x0116, B:41:0x011c, B:43:0x012e, B:45:0x0134, B:37:0x00f5), top: B:73:0x00c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012e A[Catch: all -> 0x0162, TryCatch #1 {all -> 0x0162, blocks: (B:31:0x00c4, B:34:0x00ce, B:36:0x00d6, B:39:0x0116, B:41:0x011c, B:43:0x012e, B:45:0x0134, B:37:0x00f5), top: B:73:0x00c4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ void i0(java.lang.String r14, java.lang.String r15, final boolean r16, final int r17, final com.arlosoft.macrodroid.triggers.TriggerContextInfo r18, final boolean r19, final java.util.Stack r20, final com.arlosoft.macrodroid.data.ResumeMacroInfo r21) {
        /*
            Method dump skipped, instructions count: 516
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.OpenWebPageAction.i0(java.lang.String, java.lang.String, boolean, int, com.arlosoft.macrodroid.triggers.TriggerContextInfo, boolean, java.util.Stack, com.arlosoft.macrodroid.data.ResumeMacroInfo):void");
    }

    private void j0(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (!this.m_httpGet) {
            return SelectableItem.r(R.string.action_open_web_page);
        }
        return SelectableItem.r(R.string.action_open_web_page_http_get);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_urlToOpen;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return OpenWebPageActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_urlToOpen};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + " '" + g(this.m_urlToOpen, triggerContextInfo) + "'";
    }

    @Override // com.arlosoft.macrodroid.interfaces.HasVariables
    public List<MacroDroidVariable> getVariables() {
        ArrayList arrayList = new ArrayList();
        MacroDroidVariable macroDroidVariable = this.m_variableSuccessResponse;
        if (macroDroidVariable != null) {
            arrayList.add(macroDroidVariable);
        }
        MacroDroidVariable macroDroidVariable2 = this.m_variableToSaveResponse;
        if (macroDroidVariable2 != null) {
            arrayList.add(macroDroidVariable2);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        boolean z3;
        Iterator<MacroDroidVariable> it;
        final Activity activity = getActivity();
        final AppCompatDialog appCompatDialog = new AppCompatDialog(activity, getDialogTheme());
        appCompatDialog.setContentView(R.layout.enter_url_dialog);
        appCompatDialog.setTitle(R.string.action_open_web_page);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(appCompatDialog.getWindow().getAttributes());
        layoutParams.width = -1;
        appCompatDialog.getWindow().setAttributes(layoutParams);
        Button button = (Button) appCompatDialog.findViewById(R.id.okButton);
        Button button2 = (Button) appCompatDialog.findViewById(R.id.cancelButton);
        final EditText editText = (EditText) appCompatDialog.findViewById(R.id.enter_url_dialog_url);
        Button button3 = (Button) appCompatDialog.findViewById(R.id.enter_url_dialog_magic_text_button);
        final CheckBox checkBox = (CheckBox) appCompatDialog.findViewById(R.id.enter_url_dialog_url_encode_checkbox);
        final CheckBox checkBox2 = (CheckBox) appCompatDialog.findViewById(R.id.enter_url_dialog_http_get_checkbox);
        final CheckBox checkBox3 = (CheckBox) appCompatDialog.findViewById(R.id.block_next_action_checkbox);
        final CheckBox checkBox4 = (CheckBox) appCompatDialog.findViewById(R.id.enter_url_dialog_save_success_state);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.enter_url_dialog_boolean_spinner);
        final CheckBox checkBox5 = (CheckBox) appCompatDialog.findViewById(R.id.enter_url_dialog_save_http_response);
        final CheckBox checkBox6 = (CheckBox) appCompatDialog.findViewById(R.id.allow_any_certificate);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.enter_url_dialog_variable_spinner);
        ArrayList<MacroDroidVariable> allOutputStringVariables = getAllOutputStringVariables();
        ArrayList<MacroDroidVariable> allOutputBooleanVariables = getAllOutputBooleanVariables();
        ((Button) appCompatDialog.findViewById(R.id.addBooleanVariableButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.qd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenWebPageAction.this.Z(activity, spinner, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.addStringVariableButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.rd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenWebPageAction.this.a0(activity, spinner2, view);
            }
        });
        ArrayList arrayList = new ArrayList();
        if (allOutputStringVariables.size() == 0) {
            arrayList.add(SelectableItem.r(R.string.trigger_variable_no_variables));
        }
        Iterator<MacroDroidVariable> it2 = allOutputStringVariables.iterator();
        int i4 = 0;
        int i5 = 0;
        while (it2.hasNext()) {
            MacroDroidVariable next = it2.next();
            MacroDroidVariable macroDroidVariable = this.m_variableToSaveResponse;
            if (macroDroidVariable != null) {
                it = it2;
                if (macroDroidVariable.getName().equals(next.getName())) {
                    i4 = i5;
                }
            } else {
                it = it2;
            }
            arrayList.add(next.getName());
            i5++;
            it2 = it;
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner2.setSelection(i4, false);
        ArrayList arrayList2 = new ArrayList();
        if (allOutputBooleanVariables.size() == 0) {
            arrayList2.add(SelectableItem.r(R.string.trigger_variable_no_variables));
        }
        int i6 = 0;
        int i7 = 0;
        for (MacroDroidVariable macroDroidVariable2 : allOutputBooleanVariables) {
            MacroDroidVariable macroDroidVariable3 = this.m_variableSuccessResponse;
            if (macroDroidVariable3 != null && macroDroidVariable3.getName().equals(macroDroidVariable2.getName())) {
                i7 = i6;
            }
            arrayList2.add(macroDroidVariable2.getName());
            i6++;
        }
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(activity, 17367048, arrayList2);
        arrayAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter2);
        spinner.setSelection(i7, false);
        if (this.m_variableToSaveResponse != null) {
            checkBox5.setChecked(true);
            spinner2.setEnabled(this.m_httpGet);
        } else {
            checkBox5.setChecked(false);
            spinner2.setEnabled(false);
        }
        checkBox6.setChecked(this.allowAnyCertificate);
        if (this.m_variableSuccessResponse != null) {
            checkBox4.setChecked(true);
            spinner.setEnabled(this.m_httpGet);
        } else {
            checkBox4.setChecked(false);
            spinner.setEnabled(false);
        }
        checkBox5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.sd
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                OpenWebPageAction.b0(spinner2, checkBox5, activity, compoundButton, z4);
            }
        });
        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.td
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                OpenWebPageAction.c0(spinner, checkBox4, activity, compoundButton, z4);
            }
        });
        checkBox5.setEnabled(this.m_httpGet);
        checkBox4.setEnabled(this.m_httpGet);
        spinner.setEnabled(this.m_httpGet);
        checkBox3.setEnabled(this.m_httpGet);
        checkBox6.setEnabled(this.m_httpGet);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.arlosoft.macrodroid.action.ud
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                OpenWebPageAction.this.d0(checkBox5, checkBox3, checkBox4, checkBox6, spinner2, spinner, compoundButton, z4);
            }
        });
        checkBox3.setChecked(this.blockNextAction);
        String str = this.m_urlToOpen;
        if (str != null) {
            editText.setText(str);
            z3 = true;
            button.setEnabled(true);
        } else {
            z3 = true;
            button.setEnabled(false);
        }
        editText.setSelection(editText.length());
        checkBox.setChecked(z3 ^ this.m_disableUrlEncode);
        checkBox2.setChecked(this.m_httpGet);
        editText.addTextChangedListener(new c(button, editText));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenWebPageAction.this.e0(checkBox2, editText, checkBox3, checkBox6, appCompatDialog, checkBox5, spinner2, checkBox4, spinner, checkBox, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.wd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.cancel();
            }
        });
        final MagicText.MagicTextListener magicTextListener = new MagicText.MagicTextListener() { // from class: com.arlosoft.macrodroid.action.xd
            @Override // com.arlosoft.macrodroid.common.MagicText.MagicTextListener
            public final void magicTextSelected(MagicText.MagicTextPair magicTextPair) {
                OpenWebPageAction.g0(editText, magicTextPair);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.action.yd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OpenWebPageAction.this.Y(activity, magicTextListener, view);
            }
        });
        appCompatDialog.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void invokeAction(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.triggers.TriggerContextInfo r20, int r21, boolean r22, @org.jetbrains.annotations.NotNull java.util.Stack<java.lang.Integer> r23, @org.jetbrains.annotations.Nullable com.arlosoft.macrodroid.data.ResumeMacroInfo r24, boolean r25) {
        /*
            r19 = this;
            r9 = r19
            java.lang.String r0 = r9.m_urlToOpen     // Catch: java.lang.Exception -> L7b
            r10 = r20
            java.lang.String r0 = r9.g(r0, r10)     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = "://"
            boolean r1 = r0.contains(r1)     // Catch: java.lang.Exception -> L79
            if (r1 != 0) goto L23
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r1.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r2 = "http://"
            r1.append(r2)     // Catch: java.lang.Exception -> L79
            r1.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L79
        L23:
            boolean r1 = r9.m_disableUrlEncode     // Catch: java.lang.Exception -> L79
            if (r1 == 0) goto L28
            goto L57
        L28:
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L79
            r1.<init>(r0)     // Catch: java.lang.Exception -> L79
            java.net.URI r0 = new java.net.URI     // Catch: java.lang.Exception -> L79
            java.lang.String r12 = r1.getProtocol()     // Catch: java.lang.Exception -> L79
            java.lang.String r13 = r1.getUserInfo()     // Catch: java.lang.Exception -> L79
            java.lang.String r14 = r1.getHost()     // Catch: java.lang.Exception -> L79
            int r15 = r1.getPort()     // Catch: java.lang.Exception -> L79
            java.lang.String r16 = r1.getPath()     // Catch: java.lang.Exception -> L79
            java.lang.String r17 = r1.getQuery()     // Catch: java.lang.Exception -> L79
            java.lang.String r18 = r1.getRef()     // Catch: java.lang.Exception -> L79
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Exception -> L79
            java.net.URL r0 = r0.toURL()     // Catch: java.lang.Exception -> L79
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L79
        L57:
            java.lang.String r1 = "%20&%20"
            java.lang.String r2 = "%20%26%20"
            java.lang.String r2 = r0.replace(r1, r2)     // Catch: java.lang.Exception -> L79
            boolean r0 = r9.m_httpGet     // Catch: java.lang.Exception -> L79
            if (r0 == 0) goto L75
            r1 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r1.X(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L79
            goto La0
        L75:
            r9.j0(r2)     // Catch: java.lang.Exception -> L79
            goto La0
        L79:
            r0 = move-exception
            goto L7e
        L7b:
            r0 = move-exception
            r10 = r20
        L7e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Could not launch website: "
            r1.append(r2)
            java.lang.String r2 = r9.m_urlToOpen
            r1.append(r2)
            java.lang.String r2 = ", Error:"
            r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.arlosoft.macrodroid.logging.systemlog.SystemLog.logError(r0)
        La0:
            if (r25 != 0) goto Lc3
            boolean r0 = r9.m_httpGet
            if (r0 == 0) goto Laa
            boolean r0 = r9.blockNextAction
            if (r0 != 0) goto Lc3
        Laa:
            com.arlosoft.macrodroid.macro.Macro r1 = r19.getMacro()
            com.arlosoft.macrodroid.macro.Macro r0 = r19.getMacro()
            java.util.ArrayList r2 = r0.getActions()
            r3 = r21
            r4 = r20
            r5 = r22
            r6 = r23
            r7 = r24
            r1.invokeActions(r2, r3, r4, r5, r6, r7)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.OpenWebPageAction.invokeAction(com.arlosoft.macrodroid.triggers.TriggerContextInfo, int, boolean, java.util.Stack, com.arlosoft.macrodroid.data.ResumeMacroInfo, boolean):void");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 1) {
            this.m_urlToOpen = strArr[0];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_urlToOpen);
        parcel.writeInt(this.m_httpGet ? 1 : 0);
        parcel.writeParcelable(this.m_variableToSaveResponse, i4);
        parcel.writeParcelable(this.m_variableSuccessResponse, i4);
        parcel.writeInt(this.m_disableUrlEncode ? 1 : 0);
        parcel.writeInt(this.blockNextAction ? 1 : 0);
        parcel.writeInt(this.allowAnyCertificate ? 1 : 0);
    }

    public OpenWebPageAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private OpenWebPageAction() {
        this.TRUST_ALL_CERTS = new a();
        PowerManager.WakeLock newWakeLock = ((PowerManager) getContext().getSystemService("power")).newWakeLock(1, "macrodroid:OpenWebPageAction");
        this.wakelock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    private OpenWebPageAction(Parcel parcel) {
        super(parcel);
        this.TRUST_ALL_CERTS = new a();
        this.m_urlToOpen = parcel.readString();
        this.m_httpGet = parcel.readInt() != 0;
        this.m_variableToSaveResponse = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_variableSuccessResponse = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.m_disableUrlEncode = parcel.readInt() != 0;
        this.blockNextAction = parcel.readInt() != 0;
        this.allowAnyCertificate = parcel.readInt() != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements X509TrustManager {
        a() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }
    }

    /* loaded from: classes2.dex */
    class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f2362a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f2363b;

        c(Button button, EditText editText) {
            this.f2362a = button;
            this.f2363b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            boolean z3;
            Button button = this.f2362a;
            if (this.f2363b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
