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
public class LowerCaseManipulation extends TextManipulation {
    public static final Parcelable.Creator<LowerCaseManipulation> CREATOR = new a();

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<LowerCaseManipulation> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public LowerCaseManipulation createFromParcel(Parcel parcel) {
            return new LowerCaseManipulation(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public LowerCaseManipulation[] newArray(int i4) {
            return new LowerCaseManipulation[i4];
        }
    }

    /* synthetic */ LowerCaseManipulation(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String apply(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        return str.toLowerCase();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getDescription() {
        return R.string.text_manipulation_lowercase_description;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String getExtendedInfo(String str) {
        if (str.length() > 28) {
            str = str.substring(0, 28) + "..";
        }
        return getString(getName()) + " (" + str + ")";
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getName() {
        return R.string.text_manipulation_lowercase;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getParamNames() {
        return new int[0];
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public TextManipulation.ParamType[] getParamTypes() {
        return new TextManipulation.ParamType[0];
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public LowerCaseManipulation() {
    }

    private LowerCaseManipulation(Parcel parcel) {
        super(parcel);
    }
}
