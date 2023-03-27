package me.io2.rareitemcollections;

import java.util.List;

public class ItemData {
    public List<String> materials;
    public int rate;
    public ItemData(List<String> material, int rate) {
        this.materials = material;
        this.rate = rate;
    }
}
