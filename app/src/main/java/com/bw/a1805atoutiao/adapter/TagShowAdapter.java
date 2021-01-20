package com.bw.a1805atoutiao.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.a1805atoutiao.R;
import com.bw.framework.base.BaseRVAdapter;
import com.bw.framework.bean.TitleBean;
import com.bw.framework.callback.ITagNotShowItemClickListener;

public class TagShowAdapter extends BaseRVAdapter<TitleBean> {
    private boolean isShow=false;
    private ITagNotShowItemClickListener tagShowItemClickListener;

    public void setOnItemShowItemClickListener(ITagNotShowItemClickListener itemShowItemClickListener){
        this.tagShowItemClickListener=itemShowItemClickListener;
    }
    public void setShow(boolean show){
        this.isShow=show;
        notifyDataSetChanged();
    }
    @Override
    protected int getLayoutId(int viewType) {
        return R.layout.item_tag_other;
    }

    @Override
    protected void convert(final TitleBean itemData, BaseViewHolder baseViewHolder, final int position) {
        TextView title = baseViewHolder.itemView.findViewById(R.id.tv_text);
        ImageView image = baseViewHolder.itemView.findViewById(R.id.img_edit);
        if (isShow){
             image.setVisibility(View.VISIBLE);
        }else {
             image.setVisibility(View.GONE);
        }

        title.setText(itemData.getTitle());

        baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tagShowItemClickListener!=null){
                    tagShowItemClickListener.onItemClick(itemData,position);
                }
            }
        });
    }

    @Override
    protected int getViewType(int position) {
        return 0;
    }
}
