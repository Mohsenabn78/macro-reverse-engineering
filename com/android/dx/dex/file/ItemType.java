package com.android.dx.dex.file;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import com.android.dx.util.ToHuman;
import com.koushikdutta.ion.loader.MtpConstants;

/* loaded from: classes2.dex */
public enum ItemType implements ToHuman {
    TYPE_HEADER_ITEM(0, "header_item"),
    TYPE_STRING_ID_ITEM(1, "string_id_item"),
    TYPE_TYPE_ID_ITEM(2, "type_id_item"),
    TYPE_PROTO_ID_ITEM(3, "proto_id_item"),
    TYPE_FIELD_ID_ITEM(4, "field_id_item"),
    TYPE_METHOD_ID_ITEM(5, "method_id_item"),
    TYPE_CLASS_DEF_ITEM(6, "class_def_item"),
    TYPE_MAP_LIST(4096, "map_list"),
    TYPE_TYPE_LIST(4097, "type_list"),
    TYPE_ANNOTATION_SET_REF_LIST(InputDeviceCompat.SOURCE_TOUCHSCREEN, "annotation_set_ref_list"),
    TYPE_ANNOTATION_SET_ITEM(FragmentTransaction.TRANSIT_FRAGMENT_FADE, "annotation_set_item"),
    TYPE_CLASS_DATA_ITEM(8192, "class_data_item"),
    TYPE_CODE_ITEM(MtpConstants.RESPONSE_OK, "code_item"),
    TYPE_STRING_DATA_ITEM(8194, "string_data_item"),
    TYPE_DEBUG_INFO_ITEM(MtpConstants.RESPONSE_SESSION_NOT_OPEN, "debug_info_item"),
    TYPE_ANNOTATION_ITEM(MtpConstants.RESPONSE_INVALID_TRANSACTION_ID, "annotation_item"),
    TYPE_ENCODED_ARRAY_ITEM(8197, "encoded_array_item"),
    TYPE_ANNOTATIONS_DIRECTORY_ITEM(MtpConstants.RESPONSE_PARAMETER_NOT_SUPPORTED, "annotations_directory_item"),
    TYPE_MAP_ITEM(-1, "map_item"),
    TYPE_TYPE_ITEM(-1, "type_item"),
    TYPE_EXCEPTION_HANDLER_ITEM(-1, "exception_handler_item"),
    TYPE_ANNOTATION_SET_REF_ITEM(-1, "annotation_set_ref_item");
    
    private final String humanName;
    private final int mapValue;
    private final String typeName;

    ItemType(int i4, String str) {
        this.mapValue = i4;
        this.typeName = str;
        this.humanName = (str.endsWith("_item") ? str.substring(0, str.length() - 5) : str).replace('_', ' ');
    }

    public int getMapValue() {
        return this.mapValue;
    }

    public String getTypeName() {
        return this.typeName;
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return this.humanName;
    }
}
