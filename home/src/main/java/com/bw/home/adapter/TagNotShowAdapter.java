package com.bw.home.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.framework.base.BaseRVAdapter;
import com.bw.framework.bean.LabelsBean;
import com.bw.framework.callback.ITagNotShowItemClickListener;
import com.bw.home.R;



public class TagNotShowAdapter extends BaseRVAdapter<LabelsBean> {
    private ITagNotShowItemClickListener tagNotShowItemClickListener;

    public void setOnItemNotShowItemClickListener(ITagNotShowItemClickListener itemNotShowItemClickListener){
         this.tagNotShowItemClickListener=itemNotShowItemClickListener;
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_tag_other;
    }

    @Override
    protected void convert(final LabelsBean itemData, BaseViewHolder baseViewHolder, final int position) {
        TextView title = baseViewHolder.itemView.findViewById(R.id.tv_text);
        ImageView image = baseViewHolder.itemView.findViewById(R.id.img_edit);
        image.setVisibility(View.GONE);
        title.setText(itemData.getTitle());

        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tagNotShowItemClickListener!=null){
                    tagNotShowItemClickListener.onItemClick(itemData,position);
                }
            }
        });




    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }
}
