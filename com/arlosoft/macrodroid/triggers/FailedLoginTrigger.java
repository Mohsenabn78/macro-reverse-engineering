package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.FailedLoginTriggerInfo;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes3.dex */
public class FailedLoginTrigger extends Trigger {
    public static final Parcelable.Creator<FailedLoginTrigger> CREATOR = new b();
    private int m_numFailures;
    private int m_timeIndex;

    /* loaded from: classes3.dex */
    class b implements Parcelable.Creator<FailedLoginTrigger> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FailedLoginTrigger createFromParcel(Parcel parcel) {
            return new FailedLoginTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FailedLoginTrigger[] newArray(int i4) {
            return new FailedLoginTrigger[i4];
        }
    }

    /* synthetic */ FailedLoginTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void O() {
        if (!checkActivityAlive()) {
            return;
        }
        final AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), getDialogTheme());
        appCompatDialog.setContentView(R.layout.failed_login_configuration);
        appCompatDialog.setTitle(R.string.trigger_failed_login_configure);
        final Spinner spinner = (Spinner) appCompatDialog.findViewById(R.id.failed_login_config_count_spinner);
        final Spinner spinner2 = (Spinner) appCompatDialog.findViewById(R.id.failed_login_config_timespan_spinner);
        spinner.setSelection(this.m_numFailures - 1);
        spinner2.setSelection(this.m_timeIndex);
        spinner.setOnItemSelectedListener(new a(spinner2));
        ((Button) appCompatDialog.findViewById(R.id.okButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.s2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FailedLoginTrigger.this.P(spinner, spinner2, appCompatDialog, view);
            }
        });
        ((Button) appCompatDialog.findViewById(R.id.cancelButton)).setOnClickListener(new View.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppCompatDialog.this.dismiss();
            }
        });
        appCompatDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(Spinner spinner, Spinner spinner2, AppCompatDialog appCompatDialog, View view) {
        this.m_numFailures = spinner.getSelectedItemPosition() + 1;
        this.m_timeIndex = spinner2.getSelectedItemPosition();
        appCompatDialog.dismiss();
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_numFailures == 1) {
            return SelectableItem.r(R.string.trigger_failed_login_any);
        }
        String[] stringArray = getContext().getResources().getStringArray(R.array.failed_login_attempt_timespan_options);
        return this.m_numFailures + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + SelectableItem.r(R.string.trigger_failed_login_failures_in) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + stringArray[this.m_timeIndex];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return FailedLoginTriggerInfo.getInstance();
    }

    public int getNumFailures() {
        return this.m_numFailures;
    }

    public int getTimePeriod() {
        int i4 = this.m_timeIndex;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return 3600;
                        }
                        return 1800;
                    }
                    return 600;
                }
                return 300;
            }
            return 120;
        }
        return 60;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        O();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresDeviceAdmin() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.m_numFailures);
        parcel.writeInt(this.m_timeIndex);
    }

    public FailedLoginTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private FailedLoginTrigger() {
        this.m_numFailures = 1;
    }

    private FailedLoginTrigger(Parcel parcel) {
        super(parcel);
        this.m_numFailures = parcel.readInt();
        this.m_timeIndex = parcel.readInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements AdapterView.OnItemSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Spinner f14358a;

        a(Spinner spinner) {
            this.f14358a = spinner;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            boolean z3;
            Spinner spinner = this.f14358a;
            if (i4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            spinner.setEnabled(z3);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
