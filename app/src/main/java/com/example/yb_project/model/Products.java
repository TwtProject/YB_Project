package com.example.yb_project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Products {

    @SerializedName("data")
    @Expose
    private List<Product> data = null;

    public List<Product> getProducts() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;
    }

    public class Product{

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("nama_produk")
        @Expose
        private String namaProduk;
        @SerializedName("link")
        @Expose
        private String link;
        @SerializedName("gambar")
        @Expose
        private String gambar;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNamaProduk() {
            return namaProduk;
        }

        public void setNamaProduk(String namaProduk) {
            this.namaProduk = namaProduk;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getGambar() {
            return gambar;
        }

        public void setGambar(String gambar) {
            this.gambar = gambar;
        }
    }
}
