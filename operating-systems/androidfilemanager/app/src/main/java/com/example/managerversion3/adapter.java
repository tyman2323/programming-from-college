package com.example.managerversion3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.File;

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;
    File[] items;
    private String m_Text = "";
    public adapter(Context context, File[] items){
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleritem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        File selection = items[position];
        holder.textView.setText(selection.getName());
        if(selection.isDirectory()){
            holder.imageView.setImageResource(R.drawable.baseline_folder_24);
        }
        else{
            holder.imageView.setImageResource(R.drawable.baseline_insert_drive_file_24);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selection.isDirectory()){
                    Intent intent = new Intent(context,filelistActivity.class);
                    String path = selection.getAbsolutePath();
                    intent.putExtra("path",path);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
                else{
                    try{
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        String type = "image/*";
                        intent.setDataAndType(Uri.parse(selection.getAbsolutePath()),type);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(context.getApplicationContext(),"Cannot open file",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context,view);
                popupMenu.getMenu().add("Delete");
                popupMenu.getMenu().add("Rename");
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getTitle().equals("Delete")){
                            boolean deleted = selection.delete();
                            if(deleted){
                                Toast.makeText(context.getApplicationContext(),"File has been deleted",Toast.LENGTH_SHORT).show();
                                view.setVisibility(view.GONE);
                            }
                        }
                        if(menuItem.getTitle().equals("Rename")){
                            Toast.makeText(context.getApplicationContext(),"You selected rename",Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.filenametv);
            imageView = itemView.findViewById(R.id.iconview);
        }
    }

}

