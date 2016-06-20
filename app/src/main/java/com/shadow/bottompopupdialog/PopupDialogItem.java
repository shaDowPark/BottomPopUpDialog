package com.shadow.bottompopupdialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by shadow on 2016/6/20.
 */
public class PopupDialogItem extends LinearLayout {


    private Context mContext;

    private TextView mContentView;

    private View mLineView;

    private String mContent;

    public PopupDialogItem(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public PopupDialogItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_popup_dialog, this);
        mContentView = (TextView) view.findViewById(R.id.popup_dialog_item);
        mLineView = view.findViewById(R.id.popup_dialog_line);
    }

    public void refreshData(String text) {
        mContentView.setText(text);
        mContent = text;
    }

    public void hideLine() {
        mLineView.setVisibility(GONE);
    }

    public String getItemContent() {
        return mContent;
    }

    public void setTextColor(int textColor) {
        mContentView.setTextColor(textColor);
    }

}
