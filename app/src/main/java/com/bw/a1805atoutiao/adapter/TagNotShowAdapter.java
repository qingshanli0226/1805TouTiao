package com.bw.a1805atoutiao.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.a1805atoutiao.R;
import com.bw.framework.base.BaseRVAdapter;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.callback.ITagNotShowItemClickListener;

public class TagNotShowAdapter extends BaseRVAdapter<TitleBean> {
    private ITagNotShowItemClickListener tagNotShowItemClickListener;

    public void setOnItemNotShowItemClickListener(ITagNotShowItemClickListener itemNotShowItemClickListener){
         this.tagNotShowItemClickListener=itemNotShowItemClickListener;
    }

    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_tag_other;
    }

    @Override
    protected void convert(final TitleBean itemData, BaseViewHolder baseViewHolder, final int position) {
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
