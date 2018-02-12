package id.sch.smktelkom_mlg.tugas3.xirpl519.planets;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ericcogustia on 2/9/18.
 */

public class ShipAdapter extends RecyclerView.Adapter<ShipAdapter.Holder> {
    List<ShipClass> shipClassList;

    public ShipAdapter(List<ShipClass> ship) {
        shipClassList = ship;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_data, null);
        return new Holder(V);

    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        ShipClass s = shipClassList.get(position);
        holder.tvname.setText("name : " + s.getName());
        holder.tvmodel.setText("model : " + s.getModel());
        holder.tvmanufacturer.setText("Manufacturer : " + s.getManufacturer());
        holder.tvpassengers.setText("Passengers : " + s.getPassengers());
    }

    @Override
    public int getItemCount() {
        return shipClassList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView tvname;
        TextView tvmodel;
        TextView tvmanufacturer;
        TextView tvpassengers;

        public Holder(View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tv_name);
            tvmodel = itemView.findViewById(R.id.tv_model);
            tvmanufacturer = itemView.findViewById(R.id.tv_manufacturer);
            tvpassengers = itemView.findViewById(R.id.tv_passengers);
        }
    }
}
