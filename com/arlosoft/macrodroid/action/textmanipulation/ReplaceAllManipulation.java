package com.arlosoft.macrodroid.action.textmanipulation;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.textmanipulation.TextManipulation;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

@DontObfuscate
/* loaded from: classes2.dex */
public class ReplaceAllManipulation extends TextManipulation {
    public static final Parcelable.Creator<ReplaceAllManipulation> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ReplaceAllManipulation> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ReplaceAllManipulation createFromParcel(Parcel parcel) {
            return new ReplaceAllManipulation(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ReplaceAllManipulation[] newArray(int i4) {
            return new ReplaceAllManipulation[i4];
        }
    }

    /* synthetic */ ReplaceAllManipulation(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String apply(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        return str.replaceAll(MagicText.replaceMagicText(MacroDroidApplication.getInstance(), this.params.get(0), triggerContextInfo, macro).replace("\\n", "\n"), MagicText.replaceMagicText(MacroDroidApplication.getInstance(), this.params.get(1), triggerContextInfo, macro).replace("\\n", "\n"));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getDescription() {
        return R.string.text_manipulation_replace_all_description;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String getExtendedInfo(String str) {
        if (str.length() > 28) {
            str = str.substring(0, 28) + "..";
        }
        return getString(getName()) + " (" + str + ", " + this.params.get(0) + ", " + this.params.get(1) + ")";
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getName() {
        return R.string.text_manipulation_replace_all;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getParamNames() {
        return new int[]{R.string.text_manipulation_text_to_replace_regex, R.string.text_manipulation_new_text};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public TextManipulation.ParamType[] getParamTypes() {
        return new TextManipulation.ParamType[]{TextManipulation.ParamType.STRING, TextManipulation.ParamType.STRING_OPTIONAL};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public ReplaceAllManipulation() {
    }

    private ReplaceAllManipulation(Parcel parcel) {
        super(parcel);
    }
}
