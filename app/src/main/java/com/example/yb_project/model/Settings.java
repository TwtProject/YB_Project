package com.example.yb_project.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Settings {
    @SerializedName("setting")
    @Expose
    private List<Setting> setting = null;

    public List<Setting> getSettings() {
        return setting;
    }

    public void setSetting(List<Setting> setting) {
        this.setting = setting;
    }

    public class Setting{
        @SerializedName("nomor")
        @Expose
        private String nomor;
        @SerializedName("isi")
        @Expose
        private String isiPesan;
        @SerializedName("thumb")
        @Expose
        private String thumb;

        public String getNomor() {
            return nomor;
        }

        public void setNomor(String nomor) {
            this.nomor = nomor;
        }

        public String getIsiPesan() {
            return isiPesan;
        }

        public void setIsiPesan(String isiPesan) {
            this.isiPesan = isiPesan;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }
}
