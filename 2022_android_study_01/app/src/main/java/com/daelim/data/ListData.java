package com.daelim.data;

import android.graphics.drawable.Drawable;

public class ListData {
    private Long id;
    private Drawable icon;
    private String team;

    public ListData(Long id, Drawable icon, String team) {
        this.id = id;
        this.icon = icon;
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
