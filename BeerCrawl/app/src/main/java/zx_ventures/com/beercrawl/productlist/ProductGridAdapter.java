package zx_ventures.com.beercrawl.productlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import zx_ventures.com.beercrawl.R;
import zx_ventures.com.beercrawl.data.PocCategorySearchQuery;
import zx_ventures.com.beercrawl.util.Util;

/**
 * Created by ivo on 28/12/16.
 */

public class ProductGridAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<PocCategorySearchQuery.Product> mProducts;
    
    public ProductGridAdapter(Context context, List<PocCategorySearchQuery.Product> products) {
        this.mContext = context;
        this.mProducts = products;
    }
    
    @Override
    public int getCount() {
        return mProducts.size();
    }
    
    @Override
    public long getItemId(int position) {
        return 0;
    }
    
    @Override
    public Object getItem(int position) {
        return null;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final PocCategorySearchQuery.Product product = mProducts.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_grid_product, null);
        }

        final ImageView imageView = (ImageView)convertView.findViewById(R.id.picture);
        final TextView priceTextView = (TextView)convertView.findViewById(R.id.price);
        final TextView nameTextView = (TextView)convertView.findViewById(R.id.title);

        if(product.productVariants().size() > 0) {
            Util.setPicture(imageView, product.productVariants().get(0).imageUrl());
            priceTextView.setText("R$"+ product.productVariants().get(0).price().toString().replace(".",","));
            nameTextView.setText(product.productVariants().get(0).title());
        }

        return convertView;
    }

}
