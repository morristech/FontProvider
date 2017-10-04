package moe.shizuku.fontprovider.adapter;

import java.util.List;

import moe.shizuku.fontprovider.FontInfo;
import moe.shizuku.fontprovider.viewholder.FontViewHolder;
import moe.shizuku.utils.recyclerview.BaseRecyclerViewAdapter;

/**
 * Created by rikka on 2017/10/2.
 */

public class FontManageAdapter extends BaseRecyclerViewAdapter {

    public FontManageAdapter(List<?> items) {
        super(items);

        setHasStableIds(true);

        putRule(FontInfo.class, FontViewHolder.CREATOR);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
