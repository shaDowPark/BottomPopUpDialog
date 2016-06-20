package com.shadow.bottompopupdialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by shadow on 2016/6/20.
 */
public class BottomPopUpDialog extends DialogFragment {


    private TextView mCancel;

    private LinearLayout mContentLayout;

    private String[] mDataArray;

    private SparseIntArray mColorArray = new SparseIntArray();

    private BottomPopDialogOnClickListener mListener;

    public BottomPopUpDialog() {
        super();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //该方法需要放在onViewCreated比较合适, 若在 onStart 在部分机型(如:小米3)会出现闪烁的情况
        getDialog().getWindow().setBackgroundDrawableResource(R.color.transparent_70);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Holo_Light_NoActionBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_pop_up_dialog, null);
        initView(view);
//        registerListener(view);
        setCancelable(true);
        return view;
    }

    private void initView(View view) {

        mContentLayout =(LinearLayout) view.findViewById(R.id.pop_dialog_content_layout);
        mCancel = (TextView) view.findViewById(R.id.cancel);

        for (int i = 0; i < mDataArray.length; i++) {
            PopupDialogItem dialogItem = new PopupDialogItem(getContext());
            dialogItem.refreshData(mDataArray[i]);

            if (i == mDataArray.length-1){
                dialogItem.hideLine();
            }

            if (mColorArray.size() != 0 && mColorArray.get(i) != 0) {
                dialogItem.setTextColor(mColorArray.get(i));
            }


            mContentLayout.addView(dialogItem);

//            dialogItem.setOnClickListener(v -> mListener.onDialogOnClick(dialogItem.getItemContent()));
        }

    }

    public void refreshData(String[] dataArray){
        mDataArray = dataArray;
    }

    public void setItemOnListener(BottomPopDialogOnClickListener listener){
        mListener = listener;
    }


    /**
     * 设置字体颜色
     * */
    public void setItemTextColor(int index ,int color){
        mColorArray.put(index,color);
    }

//    private void registerListener(View view) {
//        view.setOnTouchListener((v, event) -> {
//            if (event.getAction() == MotionEvent.ACTION_DOWN){
//                dismiss();
//            }
//            return false;
//        });
//        mCancel.setOnClickListener(v -> dismiss());
//    }


    public interface BottomPopDialogOnClickListener{
        void onDialogOnClick(String tag);
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
