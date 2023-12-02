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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@DontObfuscate
/* loaded from: classes2.dex */
public class ExtractTextManipulation extends TextManipulation {
    public static final Parcelable.Creator<ExtractTextManipulation> CREATOR = new a();
    private static final int OPTION_FIRST_MATCH = 0;
    private static final int OPTION_FULL_MATCH = 2;
    private static final int OPTION_GROUP_1 = 1;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ExtractTextManipulation> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ExtractTextManipulation createFromParcel(Parcel parcel) {
            return new ExtractTextManipulation(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ExtractTextManipulation[] newArray(int i4) {
            return new ExtractTextManipulation[i4];
        }
    }

    /* synthetic */ ExtractTextManipulation(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public String apply(String str, Macro macro, TriggerContextInfo triggerContextInfo) {
        Matcher matcher = Pattern.compile(MagicText.replaceMagicText(MacroDroidApplication.getInstance(), this.params.get(0), triggerContextInfo, macro)).matcher(str);
        if (Integer.valueOf(this.params.get(1)).intValue() == 1) {
            if (matcher.find()) {
                try {
                    return matcher.group(1);
                } catch (Exception unused) {
                }
            }
            return "";
        } else if (Integer.valueOf(this.params.get(1)).intValue() == 0) {
            if (!matcher.find()) {
                return "";
            }
            return str.substring(matcher.start(), matcher.end());
        } else {
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                sb.append(matcher.group(0));
            }
            return sb.toString();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int getDescription() {
        return R.string.text_manipulation_extract_text_description;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getEnumNames(int i4) {
        if (i4 == 1) {
            return new int[]{R.string.text_manipulation_text_extract_first_match, R.string.text_manipulation_text_extract_group_1, R.string.text_manipulation_text_extract_full_match};
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
        return R.string.text_manipulation_extract_text;
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public int[] getParamNames() {
        return new int[]{R.string.text_manipulation_text_to_match_regex, 0};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation
    public TextManipulation.ParamType[] getParamTypes() {
        return new TextManipulation.ParamType[]{TextManipulation.ParamType.STRING, TextManipulation.ParamType.ENUM};
    }

    @Override // com.arlosoft.macrodroid.action.textmanipulation.TextManipulation, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public ExtractTextManipulation() {
    }

    private ExtractTextManipulation(Parcel parcel) {
        super(parcel);
    }
}
