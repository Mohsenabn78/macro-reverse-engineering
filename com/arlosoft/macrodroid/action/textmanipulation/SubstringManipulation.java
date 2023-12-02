package com.arlosoft.macrodroid.action.textmanipulation;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.textmanipulation.TextManipulation;
import com.arlosoft.macrodroid.common.DontObfuscate;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

@DontObfuscate
/* loaded from: classes2.dex */
public class SubstringManipulation extends TextManipulation {
    public static final Parcelable.Creator<SubstringManipulation> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SubstringManipulation> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SubstringManipulation createFromParcel(Parcel parcel) {
            return new SubstringManipulation(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SubstringManipulation[] newArray(int i4) {
            return new SubstringManipulation[i4];
        }
    }

    /* synthetic */ SubstringManipulation(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String apply(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        int intValue = getIntValue(0, macro, triggerContextInfo);
        int intValue2 = getIntValue(1, macro, triggerContextInfo);
        if (intValue > str.length()) {
            return "";
        }
        if (intValue2 > str.length()) {
            intValue2 = str.length();
        }
        return str.substring(intValue, intValue2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getDescription() {
        return R.string.text_manipulation_substring_description;
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
        return R.string.text_manipulation_substring;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getParamNames() {
        return new int[]{R.string.text_manipulation_start_index, R.string.text_manipulation_end_index};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public TextManipulation.ParamType[] getParamTypes() {
        TextManipulation.ParamType paramType = TextManipulation.ParamType.INTEGER;
        return new TextManipulation.ParamType[]{paramType, paramType};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public SubstringManipulation() {
    }

    private SubstringManipulation(Parcel parcel) {
        super(parcel);
    }
}
