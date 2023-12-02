package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.activities.ScanTagActivity;
import com.arlosoft.macrodroid.triggers.info.NFCTriggerInfo;

/* loaded from: classes3.dex */
public class NFCTrigger extends Trigger {
    public static final Parcelable.Creator<NFCTrigger> CREATOR = new b();
    public static final String NFC_TRIGGER_MACRODROID_URL = "macrodroid://tag/";
    private static final int SCAN_REQUEST = 4455;
    public static final String TAG_NAME_EXTRA = "TagName";
    private String m_tagName;
    private transient String m_tagNameToWrite;
    private transient boolean m_writeTag;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<NFCTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NFCTrigger createFromParcel(Parcel parcel) {
            return new NFCTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NFCTrigger[] newArray(int i4) {
            return new NFCTrigger[i4];
        }
    }

    /* synthetic */ NFCTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(EditText editText, Activity activity, DialogInterface dialogInterface, int i4) {
        this.m_tagNameToWrite = editText.getText().toString();
        Intent intent = new Intent(activity, ScanTagActivity.class);
        intent.putExtra(TAG_NAME_EXTRA, this.m_tagNameToWrite);
        activity.startActivityForResult(intent, SCAN_REQUEST);
    }

    private void W() {
        final Activity activity = getActivity();
        final EditText editText = new EditText(new ContextThemeWrapper(activity, m()));
        editText.setSingleLine();
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
        editText.setHint(R.string.trigger_nfc_enter_tag_name);
        editText.setInputType(524288);
        editText.setMinimumWidth(getContext().getResources().getDimensionPixelSize(R.dimen.alert_dialog_input_min_width));
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.margin_medium);
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.input_text_dialog_top_margin);
        AlertDialog create = new AlertDialog.Builder(activity, m()).setTitle(R.string.trigger_nfc_write_tag).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                NFCTrigger.this.U(editText, activity, dialogInterface, i4);
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.t5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                dialogInterface.dismiss();
            }
        }).create();
        create.setView(editText, dimensionPixelOffset, dimensionPixelSize, dimensionPixelOffset, 0);
        create.show();
        Button button = create.getButton(-1);
        button.setEnabled(false);
        editText.addTextChangedListener(new a(button, editText));
    }

    private String[] getOptions() {
        return new String[]{SelectableItem.r(R.string.trigger_nfc_write_tag), SelectableItem.r(R.string.trigger_nfc_existing_tag)};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        boolean z3;
        if (i4 == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.m_writeTag = z3;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        return this.m_tagName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return NFCTriggerInfo.getInstance();
    }

    public String getTagName() {
        return this.m_tagName;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == SCAN_REQUEST) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, m());
            if (i5 == -1) {
                String str = this.m_tagNameToWrite;
                this.m_tagName = str;
                if (str != null) {
                    builder.setMessage(R.string.trigger_nfc_tag_configured).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.p5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i6) {
                            NFCTrigger.this.R(dialogInterface, i6);
                        }
                    });
                } else {
                    this.m_tagName = intent.getExtras().getString(TAG_NAME_EXTRA);
                    builder.setMessage(SelectableItem.r(R.string.trigger_nfc_using_nfc_tag) + this.m_tagName).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.q5
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i6) {
                            NFCTrigger.this.S(dialogInterface, i6);
                        }
                    });
                }
            } else {
                this.m_tagName = "";
                builder.setMessage(R.string.trigger_nfc_failed_to_write).setCancelable(false).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.r5
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i6) {
                        dialogInterface.dismiss();
                    }
                });
                if (this.m_tagNameToWrite == null) {
                    builder.setMessage(R.string.trigger_nfc_failed_to_read);
                }
            }
            builder.create().show();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        String str = this.m_tagName;
        if (str != null && str.length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        this.m_writeTag = true;
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        if (this.m_writeTag) {
            W();
            return;
        }
        Activity activity = getActivity();
        activity.startActivityForResult(new Intent(activity, ScanTagActivity.class), SCAN_REQUEST);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_tagName);
    }

    public NFCTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private NFCTrigger() {
    }

    private NFCTrigger(Parcel parcel) {
        super(parcel);
        this.m_tagName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Button f14390a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14391b;

        a(Button button, EditText editText) {
            this.f14390a = button;
            this.f14391b = editText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            boolean z3;
            Button button = this.f14390a;
            if (this.f14391b.getText().length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            button.setEnabled(z3);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
