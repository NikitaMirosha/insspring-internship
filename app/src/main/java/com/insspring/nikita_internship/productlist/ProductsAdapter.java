package com.insspring.nikita_internship.productlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.insspring.nikita_internship.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.UsersAdapterVh> implements Filterable {

    private List<ProductsModel> productsModelList;
    private List<ProductsModel> getProductsModelListFiltered;
    private Context context;
    private SelectedProduct selectedProduct;

    public ProductsAdapter(List<ProductsModel> productsModelList, SelectedProduct selectedProduct) {
        this.productsModelList = productsModelList;
        this.getProductsModelListFiltered = productsModelList;
        this.selectedProduct = selectedProduct;
    }

    @NonNull
    @Override
    public ProductsAdapter.UsersAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new UsersAdapterVh(LayoutInflater.from(context).inflate(R.layout.activity_scroll_products, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.UsersAdapterVh holder, int position) {

        ProductsModel productsModel = productsModelList.get(position);

        String username = productsModel.getProductName();
        String prefix = productsModel.getProductName().substring(0, 1);

        holder.tvUsername.setText(username);
        holder.tvPrefix.setText(prefix);

    }

    @Override
    public int getItemCount() {
        return productsModelList.size();
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();

                if (charSequence == null | charSequence.length() == 0) {
                    filterResults.count = getProductsModelListFiltered.size();
                    filterResults.values = getProductsModelListFiltered;

                } else {
                    String searchChr = charSequence.toString().toLowerCase();

                    List<ProductsModel> resultData = new ArrayList<>();

                    for (ProductsModel userModel : getProductsModelListFiltered) {
                        if (userModel.getProductName().toLowerCase().contains(searchChr)) {
                            resultData.add(userModel);
                        }
                    }
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;

                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                productsModelList = (List<ProductsModel>) filterResults.values;
                notifyDataSetChanged();

            }
        };
        return filter;
    }

    public interface SelectedProduct {

        void selectedProduct(ProductsModel productsModel);

    }

    public class UsersAdapterVh extends RecyclerView.ViewHolder {

        TextView tvPrefix;
        TextView tvUsername;
        ImageView imIcon;

        public UsersAdapterVh(@NonNull View itemView) {
            super(itemView);
            tvPrefix = itemView.findViewById(R.id.prefix);
            tvUsername = itemView.findViewById(R.id.username);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedProduct.selectedProduct(productsModelList.get(getAdapterPosition()));
                }
            });

        }
    }
}
