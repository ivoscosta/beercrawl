package zx_ventures.com.beercrawl.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zx_ventures.com.beercrawl.R;

/**
 * Created by nds on 25/08/17.
 */

public class PocListAdapter extends BaseAdapter {

    private Context context;
    private List<String> arraylist;

    public PocListAdapter(List<String> apps, Context context) {
        this.arraylist = apps;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;

        if (rowView == null) {
            rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_movie, null);
            // configure view holder
            viewHolder = new ViewHolder();
            viewHolder.imgPoster = (ImageView) rowView.findViewById(R.id.poster);
            viewHolder.txtTitle = (TextView) rowView.findViewById(R.id.title);
            viewHolder.txtYear = (TextView) rowView.findViewById(R.id.year);
            viewHolder.txtType = (TextView) rowView.findViewById(R.id.type);
            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Util.setPicture(viewHolder.imgPoster, arraylist.get(position).getPoster());
        viewHolder.txtTitle.setText(arraylist.get(position).getTitle());
        viewHolder.txtYear.setText(arraylist.get(position).getYear());
        viewHolder.txtType.setText(arraylist.get(position).getType());
        return rowView;
    }

    public class ViewHolder {
        TextView name;
    }
}
