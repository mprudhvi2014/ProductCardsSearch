package com.productcards.adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.productcards.model.Content;
import com.productcards.model.ProductCardListResults;
import com.bumptech.glide.Glide;
import com.productcards.R;
import com.productcards.ui.ProductCardsViewActivity;
import com.productcards.ui.fragments.ProductCardsDetailsFragment;

import java.util.List;

public class ProductCardsListAdapter extends BaseAdapter {

    private List<ProductCardListResults> mProductsCardsModels;
    private ProductCardsViewActivity mContext;

    public ProductCardsListAdapter(List<ProductCardListResults> productsCardsModels, ProductCardsViewActivity context) {
        mProductsCardsModels = productsCardsModels;
        mContext = context;
    }


    @Override
    public int getCount() {
        return mProductsCardsModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductsCardsModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ProductsCardsViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.products_cards_list_adapter, parent, false);
            viewHolder = new ProductsCardsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ProductsCardsViewHolder) convertView.getTag();
        }

        final ProductCardListResults productCardsMapResultsModel = mProductsCardsModels.get(position);
        viewHolder.cardTitle.setText(productCardsMapResultsModel.getTopDescription());
        Glide.with(mContext)
                .load(productCardsMapResultsModel.getBackgroundImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(viewHolder.cardImageView);
        viewHolder.cardDealTxt.setText(productCardsMapResultsModel.getTitle());
        String bottomDescription = productCardsMapResultsModel.getBottomDescription();
        if (bottomDescription != null) {
            String[] bottomDesc = bottomDescription.split("<a");
            CharSequence sequence = Html.fromHtml("<a " + bottomDesc[1]);
            SpannableStringBuilder strBuilder = new SpannableStringBuilder(sequence);
            URLSpan[] urls = strBuilder.getSpans(0, sequence.length(), URLSpan.class);
            for (final URLSpan span : urls) {
                viewHolder.cardDetails.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = span.getURL().trim();
                        url = url.replace("\"", "");
                        url = url.replace("\\", "");

                        showWebViewURLFragment(url);

                    }
                });

            }
            viewHolder.cardDetails.setText(bottomDesc[0]+strBuilder);
            viewHolder.cardDetails.setMovementMethod(LinkMovementMethod.getInstance());

        }
        viewHolder.shopMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Content[] content = productCardsMapResultsModel.getContent();
                if (content != null && content.length > 1) {
                    String targetMen = productCardsMapResultsModel.getContent()[0].getTarget();
                    if (targetMen != null)
                        showWebViewURLFragment(targetMen);
                } else {
                    if (content != null && content.length == 1) {
                        if (!(content[0].getTarget().contains("womens"))) {
                            showWebViewURLFragment(content[0].getTarget());

                        }
                    }
                }

            }
        });
        viewHolder.shopWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Content[] content = productCardsMapResultsModel.getContent();
                if (content != null && content.length > 1) {
                    String targetWomen = productCardsMapResultsModel.getContent()[1].getTarget();
                    if (targetWomen != null)
                        showWebViewURLFragment(targetWomen);
                } else {
                    if (content != null && content.length == 1) {
                        if (content[0].getTarget().contains("womens")) {
                            showWebViewURLFragment(content[0].getTarget());

                        }
                    }
                }

            }
        });
        viewHolder.cardCode.setText(productCardsMapResultsModel.getPromoMessage());
        return convertView;

    }


    private void showWebViewURLFragment(String url) {

        ProductCardsDetailsFragment mBbvaListFragment = ProductCardsDetailsFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putString(
                "url", url);
        mBbvaListFragment.setArguments(bundle);

        mContext.getSupportFragmentManager().beginTransaction()
                .replace(
                        R.id.mapViewContainer,
                        mBbvaListFragment)
                .addToBackStack(null)
                .commit();
        mContext.getSupportFragmentManager().executePendingTransactions();

    }

    private class ProductsCardsViewHolder {

        private ImageView cardImageView;
        private TextView cardTitle;
        private TextView cardDealTxt;
        private TextView cardCode;
        private TextView cardDetails;
        private Button shopMen;
        private Button shopWomen;


        public ProductsCardsViewHolder(@NonNull View convertView) {
            cardImageView = (ImageView) convertView.findViewById(R.id.cardbackgroundImage);
            cardTitle = (TextView) convertView.findViewById(R.id.cardTopDescription);
            cardDealTxt = (TextView) convertView.findViewById(R.id.cardTitle);
            cardCode = (TextView) convertView.findViewById(R.id.cardPromoMessage);
            cardDetails = (TextView) convertView.findViewById(R.id.cardBottomDescription);
            shopMen = (Button) convertView.findViewById(R.id.shopMen);
            shopWomen = (Button) convertView.findViewById(R.id.shopWomen);


        }


    }
}
