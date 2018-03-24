package com.mindnotix.mymvprecyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mindnotix.mymvprecyclerview.R;
import com.mindnotix.mymvprecyclerview.listener.IBaseCallBack;
import com.mindnotix.mymvprecyclerview.model.Eventcountmelist;

import java.util.ArrayList;

/**
 * Created by Admin on 3/23/2018.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Eventcountmelist> eventcountmelistArrayList;
    private IBaseCallBack iBaseCallback;

    public CustomAdapter(ArrayList<Eventcountmelist> eventcountmelistArrayList, IBaseCallBack iBaseCallback) {
        this.eventcountmelistArrayList = eventcountmelistArrayList;
        this.iBaseCallback = iBaseCallback;
    }

    public void refresh(ArrayList<Eventcountmelist> mList) {
        this.eventcountmelistArrayList = mList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_participants, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.txtGroupName.setText(eventcountmelistArrayList.get(position).getGroup_name());
        holder.txtUserName.setText(eventcountmelistArrayList.get(position).getFirst_name());
    }

    @Override
    public int getItemCount() {
        return eventcountmelistArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtUserName;
        TextView txtGroupName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtGroupName = itemView.findViewById(R.id.txtGroupName);
            txtUserName = itemView.findViewById(R.id.txtUserName);
        }
    }
}
