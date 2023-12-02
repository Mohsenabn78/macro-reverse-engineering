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
import java.util.regex.Pattern;

@DontObfuscate
/* loaded from: classes2.dex */
public class RemoveTextManipulation extends TextManipulation {
    public static final Parcelable.Creator<RemoveTextManipulation> CREATOR = new a();
    private static final int OPTION_NO_REGEX = 0;
    private static final int OPTION_USE_REGEX = 1;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<RemoveTextManipulation> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RemoveTextManipulation createFromParcel(Parcel parcel) {
            return new RemoveTextManipulation(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RemoveTextManipulation[] newArray(int i4) {
            return new RemoveTextManipulation[i4];
        }
    }

    /* synthetic */ RemoveTextManipulation(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String apply(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        String replaceMagicText = MagicText.replaceMagicText(MacroDroidApplication.getInstance(), this.params.get(0), triggerContextInfo, macro);
        if (Integer.valueOf(this.params.get(1)).intValue() == 0) {
            return str.replaceAll(Pattern.quote(replaceMagicText), "");
        }
        return str.replaceAll(replaceMagicText, "");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getDescription() {
        return R.string.text_manipulation_remove_text_description;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getEnumNames(int i4) {
        if (i4 == 1) {
            return new int[]{R.string.text_manipulation_text_plain_text, R.string.text_manipulation_remove_text_use_regex};
        }
        return super.getEnumNames(i4);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String getExtendedInfo(String str) {
        if (str.length() > 28) {
            str = str.substring(0, 28) + "..";
        }
        return getString(getName()) + " (" + str + ", " + this.params.get(0) + ")";
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getName() {
        return R.string.text_manipulation_remove_text;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getParamNames() {
        return new int[]{R.string.text_to_match, 0};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public TextManipulation.ParamType[] getParamTypes() {
        return new TextManipulation.ParamType[]{TextManipulation.ParamType.STRING, TextManipulation.ParamType.ENUM};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public RemoveTextManipulation() {
    }

    private RemoveTextManipulation(Parcel parcel) {
        super(parcel);
    }
}
